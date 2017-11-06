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
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable Element Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.FCM.ConfigurableElementInstance#getConfiguration <em>Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getConfigurableElementInstance()
 * @model abstract="true"
 * @generated
 */
public interface ConfigurableElementInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Configuration</em>' reference.
	 * @see #setConfiguration(InstanceSpecification)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getConfigurableElementInstance_Configuration()
	 * @model ordered="false"
	 * @generated
	 */
	InstanceSpecification getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.ConfigurableElementInstance#getConfiguration <em>Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Configuration</em>' reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(InstanceSpecification value);

} // ConfigurableElementInstance
