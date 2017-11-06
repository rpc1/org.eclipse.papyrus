/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 431618
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.markers;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.validation.problems.EProblem;
import org.eclipse.papyrus.cdo.validation.problems.edit.ProblemEditUtil;
import org.eclipse.papyrus.cdo.validation.problems.util.ProblemsManager;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.markerlistener.providers.AbstractMarkerProvider;
import org.eclipse.papyrus.infra.services.markerlistener.providers.IMarkerProvider2;
import org.eclipse.papyrus.infra.services.markerlistener.util.MarkerListenerUtils;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * This is the CDOMarkerProvider type. Enjoy.
 */
public class CDOMarkerProvider extends AbstractMarkerProvider implements IMarkerProvider2 {

	private final ProblemEditUtil defaultUtil = new ProblemEditUtil(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	public CDOMarkerProvider() {
		super();
	}

	@Override
	public boolean canProvideMarkersFor(Resource resource) {
		return resource instanceof CDOResource;
	}

	@Override
	public Collection<? extends IPapyrusMarker> getMarkers(final Resource resource, final String type, final boolean includeSubtypes) throws CoreException {
		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter
		return run(resource, CoreException.class, new RunnableWithResult.Impl<Collection<? extends IPapyrusMarker>>() {

			@Override
			public void run() {
				setResult(Lists.newArrayList(Iterators.transform( //
						getProblems(resource, type, includeSubtypes), //
						CDOPapyrusMarker.wrap(getProblemEditUtil(resource)))));
			}
		});
	}

	protected Iterator<? extends EProblem> getProblems(final Resource resource, final String type, boolean includeSubtypes) {
		final Predicate<EProblem> filter;

		if (type == null) {
			filter = Predicates.alwaysTrue();
		} else if (includeSubtypes) {
			filter = new Predicate<EProblem>() {

				@Override
				public boolean apply(EProblem input) {
					return MarkerListenerUtils.isMarkerTypeSubtypeOf(input.getType(), type);
				}
			};
		} else {
			filter = new Predicate<EProblem>() {

				@Override
				public boolean apply(EProblem input) {
					return type.equals(input.getType());
				}
			};
		}

		return Iterators.filter(getProblemsManager(resource).getAllProblems(resource), filter);
	}

	@Override
	public void createMarkers(final Resource resource, final Diagnostic diagnostic, final IProgressMonitor monitor) throws CoreException {
		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(resource, CoreException.class, new Runnable() {

			@Override
			public void run() {
				try {
					basicCreateMarkers(resource, diagnostic, monitor);
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	final void basicCreateMarkers(Resource resource, Diagnostic diagnostic, IProgressMonitor monitor) throws CoreException {
		super.createMarkers(resource, diagnostic, monitor);
	}

	@Override
	protected void doCreateMarker(Resource resource, Diagnostic diagnostic) throws CoreException {
		ProblemsManager mgr = getProblemsManager(resource);
		EProblem problem = mgr.createProblem(diagnostic);
		if (problem != null) {
			mgr.addProblem(problem);
		}
	}

	@Override
	protected void batchCreated(Resource resource) {
		super.batchCreated(resource);

		ResourceSet rset = resource.getResourceSet();
		if (rset instanceof ModelSet) {
			// yield the resource set to any other threads that might
			// be waiting to read it
			((ModelSet) rset).getTransactionalEditingDomain().yield();
		}
	}

	@Override
	public void deleteMarkers(final EObject object, final IProgressMonitor monitor, final String type, final boolean includeSubtypes) throws CoreException {
		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(object.eResource(), CoreException.class, new Runnable() {

			@Override
			public void run() {
				try {
					basicDeleteMarkers(object, monitor, type, includeSubtypes);
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	protected final void basicDeleteMarkers(EObject object, IProgressMonitor monitor, String type, boolean includeSubtypes) throws CoreException {
		super.deleteMarkers(object, monitor, type, includeSubtypes);
	}

	@Override
	public void deleteMarkers(final Resource resource, IProgressMonitor monitor) {
		try {
			this.deleteMarkers(resource, monitor, null, true);
		} catch (CoreException e) {
			Activator.log.error(e);
		}
	}

	@Override
	public void deleteMarkers(final Resource resource, IProgressMonitor monitor, final String markerType, final boolean includeSubtypes) throws CoreException {
		SubMonitor sub = SubMonitor.convert(monitor, IProgressMonitor.UNKNOWN);

		// run in a read-only transaction because the problems manager accesses
		// a cross-reference adapter. Note that a read/write transaction is not
		// needed because we aren't modifying the contents of the resource set
		// (the problems model is not stored in a resource)
		run(resource, new Runnable() {

			@Override
			public void run() {
				ProblemsManager mgr = getProblemsManager(resource);
				if (markerType == null) {
					// efficiently remove all markers for the resource
					mgr.purgeProblems(resource);
				} else {
					// tediously remove the matching markers
					for (EProblem next : Lists.newArrayList(getProblems(resource, markerType, includeSubtypes))) {
						ProblemsManager.delete(next);
					}
				}
			}
		});

		sub.done();
	}

	@Override
	public boolean hasMarkers(Resource context, EObject object) {
		ProblemsManager manager = getProblemsManager(context);

		return (manager != null) && manager.getAllProblems(object).hasNext();
	}

	@Override
	public ICommand getMarkerDeletionCommand(Resource context, EObject object) {
		return new MarkerDeletionCommand(context, object);
	}

	private ProblemsManager getProblemsManager(Resource resource) {
		return ProblemsManager.getProblemsManager(resource.getResourceSet());
	}

	private ProblemEditUtil getProblemEditUtil(Resource resource) {
		ProblemEditUtil result = defaultUtil;

		ResourceSet rset = resource.getResourceSet();
		if (rset instanceof ModelSet) {
			AdapterFactory factory = ((AdapterFactoryEditingDomain) ((ModelSet) rset).getTransactionalEditingDomain()).getAdapterFactory();
			result = new ProblemEditUtil(factory);
		}

		return result;
	}

	static <X extends Throwable> void run(Resource context, Runnable runnable) {
		run(context, RuntimeException.class, runnable);
	}

	static <X extends Throwable> void run(Resource context, Class<X> exceptionType, Runnable runnable) throws X {
		ResourceSet rset = context.getResourceSet();
		if (rset instanceof ModelSet) {
			try {
				((ModelSet) rset).getTransactionalEditingDomain().runExclusive(runnable);
			} catch (WrappedException e) {
				throw exceptionType.cast(e.exception());
			} catch (InterruptedException e) {
				Activator.log.error("CDO problem markers runnable interrupted.", e); //$NON-NLS-1$
			}
		} else {
			runnable.run();
		}
	}

	static <T, X extends Throwable> T run(Resource context, Class<X> exceptionType, RunnableWithResult<T> runnable) throws X {
		T result;

		ResourceSet rset = context.getResourceSet();
		if (rset instanceof ModelSet) {
			try {
				result = TransactionUtil.runExclusive(((ModelSet) rset).getTransactionalEditingDomain(), runnable);
			} catch (WrappedException e) {
				throw exceptionType.cast(e.exception());
			} catch (InterruptedException e) {
				Activator.log.error("CDO problem markers runnable interrupted.", e); //$NON-NLS-1$
				result = null;
			}
		} else {
			runnable.run();
			result = runnable.getResult();
		}

		return result;
	}

	//
	// Nested types
	//

	private class MarkerDeletionCommand extends AbstractCommand {

		private Resource context;

		private EObject object;

		private Collection<? extends EProblem> problemsForUndo;

		public MarkerDeletionCommand(Resource context, EObject object) {
			super("Delete markers");

			this.context = context;
			this.object = object;
		}

		@Override
		public void dispose() {
			context = null;
			object = null;
			problemsForUndo = null;

			super.dispose();
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			ProblemsManager manager = getProblemsManager(context);
			Collection<EProblem> problems = Lists.newArrayList(manager.getAllProblems(object));
			if (problems.isEmpty()) {
				// Nothing to do
				return CommandResult.newOKCommandResult();
			}

			for (EProblem problem : problems) {
				ProblemsManager.delete(problem);
			}

			// Initialize undo information
			problemsForUndo = problems;

			return CommandResult.newOKCommandResult();
		}

		@Override
		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			if (problemsForUndo == null) {
				// Nothing to do
				return CommandResult.newOKCommandResult();
			}

			// Detach undo information
			final Collection<? extends EProblem> problems = problemsForUndo;
			problemsForUndo = null;

			Resource resource = object.eResource();
			if (resource != null) { // Should have been reattached by now
				context = resource;
				ProblemsManager manager = getProblemsManager(resource);
				for (EProblem problem : problems) {
					problem.setElement(object);
					manager.addProblem(problem);
				}
			}

			return CommandResult.newOKCommandResult();
		}

		@Override
		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			return doExecuteWithResult(progressMonitor, info);
		}

	}

}
