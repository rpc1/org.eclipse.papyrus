/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.validation;

import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.xtext.validation.Check;


public class ConstraintWithVSLlJavaValidator extends AbstractConstraintWithVSLlJavaValidator {

	// @Check
	// public void checkGreetingStartsWithCapital(Greeting greeting) {
	// if (!Character.isUpperCase(greeting.getName().charAt(0))) {
	// warning("Name should start with a capital", MyDslPackage.GREETING__NAME);
	// }
	// }

	private static Namespace model;
	private static Element contextElement;

	private static boolean valid_Expression = true;

	public static void init(Element _contextElement) {
		contextElement = _contextElement;
		valid_Expression = true;
		if (contextElement != null) {
			Element elem = contextElement.getOwner();
			while (elem.getOwner() != null) {
				elem = elem.getOwner();
			}
			model = (Namespace) elem;
		}
	}

	public static Namespace getModel() {
		return model;
	}

	public static Element getContextElement() {
		return contextElement;
	}

	public static boolean validate() {
		return valid_Expression;
	}

	@Check
	public void checkConstraintSpecification_Expression(ConstraintSpecification constraintSpecificationRule) {
		if (constraintSpecificationRule != null && constraintSpecificationRule.getExpression() != null) {

			VSLJavaValidator.setExpectedType(VSLJavaValidator._boolean);

			VSLValidationResult validationResult = VSLJavaValidator.eInstance.checkExpressionRule(constraintSpecificationRule.getExpression());
			if (!validationResult.errorFound()) {
				String inferedTypeName = validationResult.inferedType() != null ? validationResult.inferedType().getName() : "null";
				if (!inferedTypeName.equals("Boolean")) {
					error("Expecting an expression of type Boolean. Found an expression of type " + inferedTypeName,
							constraintSpecificationRule,
							ConstraintWithVSLlPackage.eINSTANCE.getConstraintSpecification_Expression(),
							INSIGNIFICANT_INDEX);
					valid_Expression = false;
				}
				else {
					valid_Expression = true;
				}
			}
			else {
				error(validationResult.errorMessage(),
						validationResult.validatedRule(),
						validationResult.validatedFeature(),
						INSIGNIFICANT_INDEX);
				valid_Expression = false;
			}
		}
	}

}
