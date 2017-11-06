/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
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
package org.eclipse.papyrus.moka.fuml;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.moka.engine.AbstractExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.DefaultCreateObjectActionStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions.DefaultGetAssociationStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.RedefinitionBasedDispatchStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.FIFOGetNextEventStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Executor;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.FirstChoiceStrategy;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL3.ExecutionFactoryL3;
import org.eclipse.papyrus.moka.fuml.debug.ControlDelegate;
import org.eclipse.papyrus.moka.fuml.registry.IOpaqueBehaviorExecutionRegistry;
import org.eclipse.papyrus.moka.fuml.registry.ISystemServicesRegistry;
import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Type;

/**
 * The Class FUMLExecutionEngine.
 */
public abstract class FUMLExecutionEngine extends AbstractExecutionEngine {

	/** The Constant LIBRAY_EXTENSION_POINT_ID. */
	protected final static String LIBRAY_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.library";

	/** The Constant SERVICES_EXTENSION_POINT_ID. */
	protected final static String SERVICES_EXTENSION_POINT_ID = "org.eclipse.papyrus.moka.fuml.services";

	/** The main. */
	protected static Behavior main = null;

	/** The args. */
	protected String[] args;

	/** The arguments. */
	protected List<ParameterValue> arguments;

	/** The locus. */
	protected Locus locus;

	/** The started. */
	protected boolean started = false;

	/** The e instance. */
	public static FUMLExecutionEngine eInstance;

	// Starts the execution of the given behavior
	/**
	 * Start.
	 *
	 * @param behavior
	 *            the behavior
	 */
	protected void start(Behavior behavior) {
		if (behavior != null) {
			main = behavior;
			// creates the locus, executor and execution factory
			this.locus = new Locus();
			this.locus.setExecutor(new Executor());
			this.locus.setFactory(new ExecutionFactoryL3());
			this.locus.currentModelToBeExecuted = main;
			// initializes built-in primitive types
			this.initializeBuiltInPrimitiveTypes(locus);
			// Initializes opaque behavior executions
			this.registerOpaqueBehaviorExecutions(locus);
			// Initializes system services
			this.registerSystemServices(locus);
			// Initializes semantic strategies
			this.registerSemanticStrategies(locus);
			// Initializes arguments
			this.initializeArguments(this.args);
			// Finally launches the execution
			this.started = true;
			this.locus.executor.execute(main, null, this.arguments);
			eInstance.getControlDelegate().waitForTermination();
		}
	}

	// Register semantic strategies available in the environment
	/**
	 * Register semantic strategies.
	 *
	 * @param locus
	 *            the locus
	 */
	protected void registerSemanticStrategies(Locus locus) {
		locus.factory.setStrategy(new FirstChoiceStrategy());
		locus.factory.setStrategy(new FIFOGetNextEventStrategy());
		locus.factory.setStrategy(new RedefinitionBasedDispatchStrategy());
		locus.factory.setStrategy(new DefaultCreateObjectActionStrategy());
		locus.factory.setStrategy(new DefaultGetAssociationStrategy());
	}

	// Register OpaqueBehaviorExecutions available in the environment
	/**
	 * Register opaque behavior executions.
	 *
	 * @param locus
	 *            the locus
	 */
	protected void registerOpaqueBehaviorExecutions(Locus locus) {
		// Load any OpaqueBehaviorExecution library contributing to the extension LIBRAY_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(LIBRAY_EXTENSION_POINT_ID);
		try {
			for (int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadLibrary(o, locus, this.eObjectToExecute);
			}
		} catch (CoreException ex) {
			Activator.log.error(ex);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	// Register System Services available in the environment
	/**
	 * Register system services.
	 *
	 * @param locus
	 *            the locus
	 */
	protected void registerSystemServices(Locus locus) {
		// Load any contribution to the extension SERVICES_EXTENSION_POINT_ID
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IConfigurationElement[] config = registry.getConfigurationElementsFor(SERVICES_EXTENSION_POINT_ID);
		try {
			for (int i = 0; i < config.length; i++) {
				IConfigurationElement e = config[i];
				final Object o = e.createExecutableExtension("class");
				loadServices(o, locus, this.eObjectToExecute);
			}
		} catch (CoreException ex) {
			Activator.log.error(ex);
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	// Initializes primitive types of the locus with content of UMLPrimitiveTypes
	/**
	 * Initialize built in primitive types.
	 *
	 * @param locus
	 *            the locus
	 */
	protected void initializeBuiltInPrimitiveTypes(Locus locus) {
		List<IRegisteredLibrary> libraries = RegisteredLibrary.getRegisteredLibraries();
		ResourceSet resourceSet = Util.createTemporaryResourceSet();
		for (IRegisteredLibrary l : libraries) {
			if (l.getName().equals("UMLPrimitiveTypes")) {
				URI libraryUri = l.getUri();
				Resource libraryResource = resourceSet.getResource(libraryUri, true);
				Iterator<EObject> libElementIterator = libraryResource.getAllContents();
				while (libElementIterator.hasNext()) {
					EObject currentElement = libElementIterator.next();
					if (currentElement instanceof PrimitiveType) {
						locus.factory.addBuiltInType((Type) currentElement);
					}
				}
			}
		}
	}

	// Loads a library of OpaqueBehaviorExecutions using the safe runner pattern
	/**
	 * Load library.
	 *
	 * @param o
	 *            the o
	 * @param locus
	 *            the locus
	 * @param context
	 *            the context
	 */
	protected static void loadLibrary(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				Activator.log.error(e);
			}

			public void run() throws Exception {
				((IOpaqueBehaviorExecutionRegistry) o).init(context).registerOpaqueBehaviorExecutions(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	// Loads System services using the safe runner pattern
	/**
	 * Load services.
	 *
	 * @param o
	 *            the o
	 * @param locus
	 *            the locus
	 * @param context
	 *            the context
	 */
	protected static void loadServices(final Object o, final Locus locus, final Object context) {
		ISafeRunnable runnable = new ISafeRunnable() {

			public void handleException(Throwable e) {
				Activator.log.error(e);
			}

			public void run() throws Exception {
				((ISystemServicesRegistry) o).init(context).registerSystemServices(locus);
			}
		};
		SafeRunner.run(runnable);
	}

	/**
	 * Returns the ControlDelegate object associated with this engine.
	 * This object can be used by fUML visitors as a kind of control manager,
	 * which is charge of managing debug specific aspects (e.g., suspension,
	 * termination, animation, etc.)
	 *
	 * @return The ControlDelegate object associated with this engine
	 */
	public abstract ControlDelegate getControlDelegate();

	/**
	 * Returns the fUML locus associated with this engine
	 *
	 * @return the fUML locus associated with this engine
	 */
	public Locus getLocus() {
		return this.locus;
	}
}
