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
package org.eclipse.papyrus.moka.fuml.Semantics.Actions.IntermediateActions;

import org.eclipse.papyrus.moka.fuml.Semantics.Actions.BasicActions.ActionActivation;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.uml2.uml.ValueSpecificationAction;

public class ValueSpecificationActionActivation extends ActionActivation {

	@Override
	public void doAction() {
		// Evaluate the value specification for the action and place the result
		// on the result pin of the action.
		ValueSpecificationAction action = (ValueSpecificationAction) (this.node);
		Value value = this.getExecutionLocus().executor.evaluate(action.getValue());
		this.putToken(action.getResult(), value);
	}
}
