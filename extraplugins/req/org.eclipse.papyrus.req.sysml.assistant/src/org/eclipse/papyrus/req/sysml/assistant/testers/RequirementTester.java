/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
*     CEA LIST. - initial API and implementation
*     Trung-Truc Nguyen - Bug 473610
*     
*******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.testers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.req.sysml.assistant.I_SysMLStereotype;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This class helps to test if the selected element is a SysML Requirement or not
 */
public class RequirementTester extends PropertyTester {

	public static final String isRequirementElement = "isRequirementElement";//NSL
	
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (isRequirementElement.equals(property)) {
			boolean testResult = isExpected((IStructuredSelection) receiver);

			return expectedValue.equals(testResult);
		}
		return false;
	}
	private boolean isExpected(IStructuredSelection receiver) {
		for (Object current : receiver.toArray()) {
			// Adapt current selection to EObject
			if (current instanceof IAdaptable) {
				EObject eObj = (EObject) ((IAdaptable) current)
						.getAdapter(EObject.class);
				if (!(eObj instanceof Element))
					return false;
				for (Stereotype st : ((Element)eObj).getAppliedStereotypes()) {
					if(st.getQualifiedName().equals(I_SysMLStereotype.REQUIREMENT_STEREOTYPE))
						return true;
				}
			}
			return false;
		}
		return false;
	}

}
