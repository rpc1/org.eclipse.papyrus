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
package org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.InvocationActions;

// Imports
import java.util.List;

import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.SendSignalActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Reference;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;


public class CS_SendSignalActionActivation extends SendSignalActionActivation {

	@Override
	public void doAction() {
		// If onPort is not specified, behaves like in fUML
		// If onPort is specified,
		// Get the value from the target pin. If the value is not a reference,
		// then do nothing.
		// Otherwise, construct a signal using the values from the argument pins
		// As compared to fUML, instead of sending directly to target reference
		// by calling operation send:
		// - if the target is to be the same as or a container of (directly or indirectly)
		// the object executing the Action, the Signal shall be related to a Reception belonging
		// to a required interface of onPort, and sendOut is called on the target reference
		// so that the signal will be sent to the environment
		// - if the target is NOT to be the same as or a container of (directly or indirectly)
		// the object executing the Action, the Signal shall be related to a Reception belonging
		// to a provided Interface of onPort, and operation sendIn is called so that the signal
		// will be sent to the internals of the target object

		SendSignalAction action = (SendSignalAction) (this.node);

		if (action.getOnPort() == null) {
			// Behaves like in fUML
			this.doActionDefault();
		} else {
			Value target = this.takeTokens(action.getTarget()).get(0);

			if (target instanceof CS_Reference) {
				// Constructs the signal instance
				Signal signal = action.getSignal();
				CS_SignalInstance signalInstance = new CS_SignalInstance();
				signalInstance.type = signal;

				List<Property> attributes = signal.getOwnedAttributes();
				List<InputPin> argumentPins = action.getArguments();
				Integer i = 0;
				while (i < attributes.size()) {
					Property attribute = attributes.get(i);
					InputPin argumentPin = argumentPins.get(i);
					List<Value> values = this.takeTokens(argumentPin);
					signalInstance.setFeatureValue(attribute, values, 0);
					i = i + 1;
				}

				// Tries to determine if the signal has to be
				// sent to the environment or to the internals of
				// target, through onPort
				CS_Reference targetReference = (CS_Reference) target;
				// Port onPort = action.onPort ;
				Object_ executionContext = this.group.activityExecution.context;
				if (executionContext == targetReference.referent || targetReference.compositeReferent.contains(executionContext)) {
					targetReference.sendOut(signalInstance, action.getOnPort());
				} else {
					targetReference.sendIn(signalInstance, action.getOnPort());
				}
			}
		}
	}

	public void doActionDefault() {
		// Get the value from the target pin. If the value is not a reference,
		// then do nothing.
		// Otherwise, construct a signal using the values from the argument pins
		// and send it to the referent object.
		// This operation captures same semantics as fUML
		// SendSignalActionActivation.doAction() except that it constructs
		// a CS_SignalInstance instead of a SignalInstance

		SendSignalAction action = (SendSignalAction) (this.node);
		Value target = this.takeTokens(action.getTarget()).get(0);

		if (target instanceof Reference) {
			Signal signal = action.getSignal();

			CS_SignalInstance signalInstance = new CS_SignalInstance();
			signalInstance.type = signal;

			List<Property> attributes = signal.getOwnedAttributes();
			List<InputPin> argumentPins = action.getArguments();
			for (int i = 0; i < attributes.size(); i++) {
				Property attribute = attributes.get(i);
				InputPin argumentPin = argumentPins.get(i);
				List<Value> values = this.takeTokens(argumentPin);
				signalInstance.setFeatureValue(attribute, values, 0);
			}

			((Reference) target).send(signalInstance);
		}
	}
}
