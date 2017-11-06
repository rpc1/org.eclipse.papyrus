/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.model.customizationplugin;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File Based Customizable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getFileBasedCustomizableElement()
 * @model abstract="true"
 * @generated
 */
public interface FileBasedCustomizableElement extends CustomizableElement {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#getFileBasedCustomizableElement_File()
	 * @model required="true"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // FileBasedCustomizableElement
