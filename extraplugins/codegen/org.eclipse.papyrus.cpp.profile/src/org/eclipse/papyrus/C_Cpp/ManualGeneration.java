/**
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    CEA LIST - Initial API and implementation
 *
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manual Generation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Some toolkits require a quite particular way of use. For instance, LTTng requires the use of C (not C++) for the declaration of a trace provider and the header file is read several time with redefined macros. Therefore, the code generator supports a "manual" generation mode, in which primarily the contents of the CppInclude directive is written.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getExtensionBody <em>Extension Body</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getManualGeneration()
 * @model
 * @generated
 */
public interface ManualGeneration extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Body</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Body</em>' attribute.
	 * @see #setExtensionBody(String)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getManualGeneration_ExtensionBody()
	 * @model dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getExtensionBody();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getExtensionBody <em>Extension Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Body</em>' attribute.
	 * @see #getExtensionBody()
	 * @generated
	 */
	void setExtensionBody(String value);

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getManualGeneration_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

} // ManualGeneration
