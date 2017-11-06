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
 *****************************************************************************/
package org.eclipse.papyrus.moka.async.fuml.Semantics.Classes.Kernel;

import java.util.Iterator;
import java.util.List;

import org.eclipse.papyrus.moka.async.fuml.Activator;
import org.eclipse.papyrus.moka.async.fuml.Semantics.CommonBehaviors.Communications.AsyncObjectActivation;
import org.eclipse.papyrus.moka.async.fuml.debug.AsyncControlDelegate;
import org.eclipse.papyrus.moka.async.fuml.debug.AsyncDebug;
import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.FUMLExecutionEngine;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.uml2.uml.Class;

/**
 * Object_ class is slightly modified in order to enable creation and starting of its
 * object activation on a new thread. This override the previous behavior that was limited
 * the call of the startBehavior(...) method
 *
 */
public class AsyncObject_ extends CS_Object {

	/** The objectactivation thread. */
	protected Thread objectactivationThread;

	/**
	 * Create and start the Java Thread required to execute its owning objectActivation.
	 *
	 * @param classifier
	 * @param inputs
	 */
	@Override
	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		if (this.objectActivation == null) {
			this.objectActivation = new AsyncObjectActivation(classifier, inputs);
			this.objectActivation.object = this;
		}
		/* 1. Create Thread Name */
		String threadName = "Thread_";
		Iterator<Class> classes = this.types.iterator();
		while (classes.hasNext()) {
			threadName += classes.next().getName();
			if (classes.hasNext()) {
				threadName += "|";
			}
		}
		/* 2. Pattern to start the Runnable corresponding to the AsyncObjectActivation */
		// Thread objectactivationThread = new Thread((AsyncObjectActivation)this.objectActivation, threadName);
		objectactivationThread = new Thread((AsyncObjectActivation) this.objectActivation, threadName);

		((AsyncControlDelegate) FUMLExecutionEngine.eInstance.getControlDelegate()).registerObjectActivation(this.objectActivation, threadName); // Added for connection with debug api

		objectactivationThread.start();

		AsyncDebug.println("[NEW THREAD] Active object instance started on a new thread");
	}

	/**
	 * TODO write Javadoc
	 */
	public void join() {
		try {
			objectactivationThread.join();
		} catch (InterruptedException e) {
			Activator.log.error(e);
		}
	}
}
