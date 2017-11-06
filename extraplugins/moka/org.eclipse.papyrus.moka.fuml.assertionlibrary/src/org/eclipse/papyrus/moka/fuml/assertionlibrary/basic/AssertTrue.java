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
package org.eclipse.papyrus.moka.fuml.assertionlibrary.basic;

import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.BooleanValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.OpaqueBehaviorExecution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.Reporter;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.TestDecision;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.TestReport;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.utils.AssertionExecutionContextHelper;
import org.eclipse.uml2.uml.Classifier;

public class AssertTrue extends OpaqueBehaviorExecution {

	@Override
	public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
		Classifier executionContext = AssertionExecutionContextHelper.getExecutionContext(this);
		StringValue label = (StringValue) inputParameters.get(0).values.get(0);
		BooleanValue assertionResult = (BooleanValue) inputParameters.get(1).values.get(0);
		Reporter.INSTANCE.add(new TestReport(executionContext != null ? executionContext : null, label.value, assertionResult.value == true ? TestDecision.SUCCESS : TestDecision.FAILED, getClass()));
	}

	@Override
	public Value new_() {
		return new AssertTrue();
	}

}
