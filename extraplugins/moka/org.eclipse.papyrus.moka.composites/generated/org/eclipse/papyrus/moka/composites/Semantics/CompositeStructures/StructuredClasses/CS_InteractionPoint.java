/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;


public class CS_InteractionPoint extends Reference {

	/*
	 * Represents the Reference to the CompositeObject owning this InteractionPort. NOTE: This is introduced to address requirement R3 (It represents
	 * the "link from that instance to the instance of the owning classifier [...] through which communication is forwarded to the instance of the
	 * owning classifier or through which the owning classifier communicates)
	 */
	public CS_Reference owner;

	/*
	 * The Port for which this InteractionPoint is a runtime manifestation
	 */
	public Port definingPort;

	@Override
	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// Overriden to do nothing
	}

	@Override
	public Execution dispatch(Operation operation) {
		// Delegates dispatching to the owning object
		return this.owner.dispatchIn(operation, this);
	}

	@Override
	public void send(SignalInstance signalInstance) {
		// Delegates sending to the owning object
		this.owner.sendIn(signalInstance, this);
	}

	@Override
	public Value copy() {
		// Create a new interaction point with the same referent as this interaction point.
		CS_InteractionPoint newValue = (CS_InteractionPoint) (super.copy());
		newValue.referent = this.referent;
		return newValue;
	}

	@Override
	public Value new_() {
		// Create a new interaction point with no referent.
		return new CS_InteractionPoint();
	}


}
