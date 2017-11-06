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
package org.eclipse.papyrus.moka.fuml.standardlibrary.library.unlimitednatural;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.UnlimitedNaturalValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.uml2.uml.PrimitiveType;

public class Lower extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		try {
			Integer x = ((UnlimitedNaturalValue) inputParameters.get(0).values.get(0)).value;
			Integer y = ((UnlimitedNaturalValue) inputParameters.get(1).values.get(0)).value;
			BooleanValue result = new BooleanValue();
			result.value = x >= 0 && (y < 0 || x < y);
			List<Value> outputs = new ArrayList<Value>();
			result.type = (PrimitiveType) this.locus.factory.getBuiltInType("Boolean"); // ADDED
			outputs.add(result);
			outputParameters.get(0).values = outputs;
		} catch (Exception e) {
			Debug.println("An error occured during the execution of < " + e.getMessage());
		}
	}

	@Override
	public Value new_() {
		return new Lower();
	}

}
