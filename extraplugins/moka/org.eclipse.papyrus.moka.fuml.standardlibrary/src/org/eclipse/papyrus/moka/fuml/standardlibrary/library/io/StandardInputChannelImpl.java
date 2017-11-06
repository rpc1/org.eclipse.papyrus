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

package org.eclipse.papyrus.moka.fuml.standardlibrary.library.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.StringValue;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.Execution;
import org.eclipse.papyrus.moka.fuml.Semantics.CommonBehaviors.BasicBehaviors.ParameterValue;
import org.eclipse.papyrus.moka.fuml.debug.Debug;
import org.eclipse.papyrus.moka.fuml.registry.service.framework.AbstractService;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;

public class StandardInputChannelImpl extends AbstractService {

	protected static BufferedReader bufferedReader;

	protected InputStream in = null;

	public StandardInputChannelImpl(Class service) {
		super(service);
		this.types.add(service);
		this.in = StandardOutputChannelImpl.getConsole().getInputStream();
	}

	@Override
	public Execution dispatch(Operation operation) {
		if (operation.getName().equals("readLine")) {
			return new ReadLineExecution(operation);
		}
		return null;
	}

	protected class ReadLineExecution extends AbstractService.ServiceOperationExecution {

		protected Operation operation;

		public ReadLineExecution(Operation operation) {
			super(operation);
		}

		@Override
		public Value new_() {
			return new ReadLineExecution(operation);
		}

		@Override
		public void doBody(List<ParameterValue> inputParameters, List<ParameterValue> outputParameters) {
			// This implementation does not produce errorStatus information.
			try {
				if (bufferedReader == null) {
					bufferedReader = new BufferedReader(new InputStreamReader(in));
				}
				String line = bufferedReader.readLine();
				StringValue result = new StringValue();
				result.value = "" + line;
				List<Value> outputs = new ArrayList<Value>();
				outputs.add(result);
				outputParameters.get(0).values = outputs;
			} catch (Exception e) {
				Debug.println("An error occured during the execution of readLine " + e.getMessage());
			}
		}
	}
}
