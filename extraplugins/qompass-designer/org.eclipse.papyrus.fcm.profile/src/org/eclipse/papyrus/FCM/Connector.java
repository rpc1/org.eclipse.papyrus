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

import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This stereotype references the interaction component that should realize the communication. It can be applied to UML connectors as well as to properties. The former is used, if there are two communication partners, the latter is more flexible. For instance,
 * in case of a DDS interaction, a publisher does not know the consumers, it therefore communicates with a part (property) representing the publisher part of the interaction component
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.FCM.Connector#getBase_Connector <em>Base Connector</em>}</li>
 * <li>{@link org.eclipse.papyrus.FCM.Connector#getIc <em>Ic</em>}</li>
 * <li>{@link org.eclipse.papyrus.FCM.Connector#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.FCM.FCMPackage#getConnector()
 * @model
 * @generated
 */
public interface Connector extends ConfigurableElementInstance {
	/**
	 * Returns the value of the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Connector</em>' reference.
	 * @see #setBase_Connector(org.eclipse.uml2.uml.Connector)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getConnector_Base_Connector()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Connector getBase_Connector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Connector#getBase_Connector <em>Base Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Connector</em>' reference.
	 * @see #getBase_Connector()
	 * @generated
	 */
	void setBase_Connector(org.eclipse.uml2.uml.Connector value);

	/**
	 * Returns the value of the '<em><b>Ic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ic</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Ic</em>' reference.
	 * @see #setIc(InteractionComponent)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getConnector_Ic()
	 * @model ordered="false"
	 * @generated
	 */
	InteractionComponent getIc();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Connector#getIc <em>Ic</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Ic</em>' reference.
	 * @see #getIc()
	 * @generated
	 */
	void setIc(InteractionComponent value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.FCM.FCMPackage#getConnector_Base_Property()
	 * @model ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.FCM.Connector#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // Connector
