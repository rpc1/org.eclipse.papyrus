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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hierarchy Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#getContainerType <em>Container Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#isPermitted <em>Permitted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#isStrict <em>Strict</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage#getHierarchyPermission()
 * @model
 * @generated
 */
public interface HierarchyPermission extends EObject {
	/**
	 * Returns the value of the '<em><b>Container Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container Type</em>' attribute.
	 * @see #setContainerType(String)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage#getHierarchyPermission_ContainerType()
	 * @model required="true"
	 * @generated
	 */
	String getContainerType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#getContainerType <em>Container Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container Type</em>' attribute.
	 * @see #getContainerType()
	 * @generated
	 */
	void setContainerType(String value);

	/**
	 * Returns the value of the '<em><b>Permitted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permitted</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permitted</em>' attribute.
	 * @see #setPermitted(boolean)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage#getHierarchyPermission_Permitted()
	 * @model required="true"
	 * @generated
	 */
	boolean isPermitted();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#isPermitted <em>Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permitted</em>' attribute.
	 * @see #isPermitted()
	 * @generated
	 */
	void setPermitted(boolean value);

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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage#getHierarchyPermission_Strict()
	 * @model required="true"
	 * @generated
	 */
	boolean isStrict();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission#isStrict <em>Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict</em>' attribute.
	 * @see #isStrict()
	 * @generated
	 */
	void setStrict(boolean value);

} // HierarchyPermission
