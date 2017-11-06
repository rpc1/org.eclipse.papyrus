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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration;

import org.eclipse.papyrus.infra.elementtypesconfigurations.invarianttypeconfiguration.InvariantRuleConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Invariant Stereotype Rule Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#getRequiredProfile <em>Required Profile</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#isStrict <em>Strict</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfigurationPackage#getInvariantStereotypeRuleConfiguration()
 * @model
 * @generated
 */
public interface InvariantStereotypeRuleConfiguration extends InvariantRuleConfiguration
{
	/**
	 * Returns the value of the '<em><b>Stereotype Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #setStereotypeQualifiedName(String)
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfigurationPackage#getInvariantStereotypeRuleConfiguration_StereotypeQualifiedName()
	 * @model required="true"
	 * @generated
	 */
	String getStereotypeQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype Qualified Name</em>' attribute.
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 */
	void setStereotypeQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Required Profile</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Profile</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Profile</em>' attribute.
	 * @see #setRequiredProfile(String)
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfigurationPackage#getInvariantStereotypeRuleConfiguration_RequiredProfile()
	 * @model
	 * @generated
	 */
	String getRequiredProfile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#getRequiredProfile <em>Required Profile</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Profile</em>' attribute.
	 * @see #getRequiredProfile()
	 * @generated
	 */
	void setRequiredProfile(String value);

	/**
	 * Returns the value of the '<em><b>Strict</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Strict</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict</em>' attribute.
	 * @see #setStrict(boolean)
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfigurationPackage#getInvariantStereotypeRuleConfiguration_Strict()
	 * @model required="true"
	 * @generated
	 */
	boolean isStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfiguration#isStrict <em>Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict</em>' attribute.
	 * @see #isStrict()
	 * @generated
	 */
	void setStrict(boolean value);

} // InvariantStereotypeRuleConfiguration
