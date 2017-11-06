/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.SetValuesAdviceConfiguration;
import org.eclipse.papyrus.infra.services.edit.utils.ElementTypeUtils;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.creation.EditionDialog;
import org.eclipse.swt.widgets.Display;

/**
 * advice for the {@link SetValuesAdviceConfiguration}
 */
public class RuntimeValuesEditionAdviceEditHelperAdvice extends AbstractEditHelperAdvice {

	/** list of views to display */
	protected Set<View> viewsToDisplay;


	/**
	 * Default Constructor
	 */
	public RuntimeValuesEditionAdviceEditHelperAdvice(RuntimeValuesEditionAdviceConfiguration configuration) {
		viewsToDisplay = new HashSet<View>();
		for (ViewToDisplay display : configuration.getViewsToDisplay()) {
			View view = display.getView();
			if (view != null) {
				viewsToDisplay.add(view);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		return super.approveRequest(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		return super.getBeforeCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		return super.getAfterCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		return super.getBeforeConfigureCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {
		final EObject elementToConfigure = request.getElementToConfigure();
		if (elementToConfigure == null) {
			return null;
		}
		
		final boolean dialogCancellable = ElementTypeUtils.dialogCancellable(request);

		return new AbstractTransactionalCommand(request.getEditingDomain(), "Editing " + EMFCoreUtil.getName(elementToConfigure), Collections.singletonList(WorkspaceSynchronizer.getFile((elementToConfigure.eResource())))) {
			/**
			 * {@inheritDoc}
			 */
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Set<View> viewsToDisplay = getViewsToDisplay();
				if (!viewsToDisplay.isEmpty()) {
					EditionDialog dialog = new EditionDialog(Display.getCurrent().getActiveShell(), dialogCancellable) {

					};
					dialog.setTitle("Edit " + EMFCoreUtil.getName(elementToConfigure));
					dialog.setViews(viewsToDisplay);
					dialog.setInput(elementToConfigure);

					dialog.open();
				}

				return CommandResult.newOKCommandResult(elementToConfigure);
			}
		};

	}


	/**
	 * @return the viewsToDisplay
	 */
	public Set<View> getViewsToDisplay() {
		return viewsToDisplay;
	}

}
