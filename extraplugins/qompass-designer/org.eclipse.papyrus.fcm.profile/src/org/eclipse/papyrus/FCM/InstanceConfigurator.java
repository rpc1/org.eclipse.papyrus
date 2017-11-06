/**
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 *
 */
package org.eclipse.papyrus.FCM;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Configurator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.FCM.InstanceConfigurator#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.FCM.InstanceConfigurator#isOnNodeModel <em>On Node Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getInstanceConfigurator()
 * @model
 * @generated
 */
public interface InstanceConfigurator extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInstanceConfigurator_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InstanceConfigurator#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>On Node Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Node Model</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>On Node Model</em>' attribute.
	 * @see #setOnNodeModel(boolean)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getInstanceConfigurator_OnNodeModel()
	 * @model dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isOnNodeModel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.InstanceConfigurator#isOnNodeModel <em>On Node Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>On Node Model</em>' attribute.
	 * @see #isOnNodeModel()
	 * @generated
	 */
	void setOnNodeModel(boolean value);

} // InstanceConfigurator
