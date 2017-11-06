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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.nattable.allocation.config.tester;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.eastadl.nattable.allocation.config.Activator;
import org.eclipse.papyrus.eastadl.nattable.allocation.config.messages.Messages;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.infra.nattable.tester.ITableTester;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

public class TableAllocationCreationTester implements ITableTester {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.tester.ITableTester#isAllowed(java.lang.Object)
	 *
	 * @param context
	 * @return
	 */
	@Override
	public IStatus isAllowed(Object context) {
		if (context instanceof Element) {
			Element el = (Element) context;
			boolean result = context instanceof Component;
			if (result) {
				final String packageQN = UMLUtil.getProfile(FunctionmodelingPackage.eINSTANCE, el).getQualifiedName();
				result = result && el.getNearestPackage().getAppliedProfile(packageQN, true) != null;
				if (result) {
					return new Status(IStatus.OK, Activator.PLUGIN_ID, Messages.TableAllocationCreationTester_OKMessage);
				} else {
					return new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format(Messages.TableAllocationCreationTester_ProfileNotApplied, packageQN));
				}
			}
		}
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.TableAllocationCreationTester_NotAnUMLElement);
	}

}
