/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Stereotype Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration#getStereotypesToApply <em>Stereotypes To Apply</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfigurationPackage#getApplyStereotypeAdviceConfiguration()
 * @model
 * @generated
 */
public interface ApplyStereotypeAdviceConfiguration extends AdviceBindingConfiguration {
	/**
	 * Returns the value of the '<em><b>Stereotypes To Apply</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.StereotypeToApply}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotypes To Apply</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotypes To Apply</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfigurationPackage#getApplyStereotypeAdviceConfiguration_StereotypesToApply()
	 * @model containment="true"
	 * @generated
	 */
	EList<StereotypeToApply> getStereotypesToApply();

} // ApplyStereotypeAdviceConfiguration
