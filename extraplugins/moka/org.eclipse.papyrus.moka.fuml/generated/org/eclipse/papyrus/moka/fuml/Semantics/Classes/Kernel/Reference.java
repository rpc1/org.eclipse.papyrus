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
package org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.Communications.SignalInstance;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StructuralFeature;

public class Reference extends StructuredValue {

	public Object_ referent;

	public Object getUnderlying() {
		return this.referent;
	}

	public void startBehavior(Class classifier, List<ParameterValue> inputs) {
		// Asynchronously start the behavior of the given classifier for the
		// referent object.
		this.referent.startBehavior(classifier, inputs);
	}

	public Execution dispatch(Operation operation) {
		// Dispatch the given operation to the referent object.
		return this.referent.dispatch(operation);
	}

	public void send(SignalInstance signalInstance) {
		// Send the given signal instance to the referent object.
		this.referent.send(signalInstance);
	}

	public void destroy() {
		// Destroy the referent.
		this.referent.destroy();
	}

	@Override
	public Boolean equals(Value otherValue) {
		// Test if this reference is equal to the otherValue.
		// To be equal, the otherValue must also be a reference, with the same
		// referent as this reference.
		boolean isEqual = false;
		if (otherValue instanceof Reference) {
			isEqual = (((Reference) otherValue).referent == this.referent);
		}
		return isEqual;
	}

	@Override
	public Value copy() {
		// Create a new reference with the same referent as this reference.
		Reference newValue = (Reference) (super.copy());
		newValue.referent = this.referent;
		return newValue;
	}

	@Override
	public Value new_() {
		// Create a new reference with no referent.
		return new Reference();
	}

	@Override
	public List<Classifier> getTypes() {
		// Get the types of the referent object.
		return this.referent.getTypes();
	}

	@Override
	public FeatureValue getFeatureValue(StructuralFeature feature) {
		// Get the feature value associated with the given feature in the
		// referent object.
		return this.referent.getFeatureValue(feature);
	}

	@Override
	public void setFeatureValue(StructuralFeature feature, List<Value> values, Integer position) {
		// Set the values associated with the given feature in the referent
		// object.
		this.referent.setFeatureValue(feature, values, position);
	}

	@Override
	public List<FeatureValue> getFeatureValues() {
		// Return the feature values of the referent.
		return this.referent.getFeatureValues();
	}

	@Override
	public String toString() {
		return "Reference to " + this.referent.toString();
	}
}
