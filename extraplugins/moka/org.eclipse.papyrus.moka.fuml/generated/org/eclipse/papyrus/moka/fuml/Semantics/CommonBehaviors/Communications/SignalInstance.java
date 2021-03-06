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
package org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.CompoundValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Signal;

public class SignalInstance extends CompoundValue {

	public Signal type;

	@Override
	public List<Classifier> getTypes() {
		// Return the single type of this signal instance.
		List<Classifier> types = new ArrayList<Classifier>();
		types.add(this.type);
		return types;
	}

	@Override
	public Value new_() {
		// Create a new signal instance with no type or feature values.
		return new SignalInstance();
	}

	@Override
	public Value copy() {
		// Create a new signal instance with the same type and feature values as
		// this signal instance.
		SignalInstance newValue = (SignalInstance) (super.copy());
		newValue.type = this.type;
		return newValue;
	}
}
