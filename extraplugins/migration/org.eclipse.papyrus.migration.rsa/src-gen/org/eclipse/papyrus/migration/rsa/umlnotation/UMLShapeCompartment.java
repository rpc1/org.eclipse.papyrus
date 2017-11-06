/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.umlnotation;

import org.eclipse.gmf.runtime.notation.Compartment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Shape Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.UMLShapeCompartment#isVerticalAlignment <em>Vertical Alignment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.migration.rsa.umlnotation.PapyrusUMLNotationPackage#getUMLShapeCompartment()
 * @model
 * @generated
 */
public interface UMLShapeCompartment extends Compartment, UMLView {

	/**
	 * Returns the value of the '<em><b>Vertical Alignment</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertical Alignment</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Vertical Alignment</em>' attribute.
	 * @see #setVerticalAlignment(boolean)
	 * @see org.eclipse.papyrus.migration.rsa.umlnotation.PapyrusUMLNotationPackage#getUMLShapeCompartment_VerticalAlignment()
	 * @model default="true"
	 * @generated
	 */
	boolean isVerticalAlignment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.migration.rsa.umlnotation.UMLShapeCompartment#isVerticalAlignment <em>Vertical Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Vertical Alignment</em>' attribute.
	 * @see #isVerticalAlignment()
	 * @generated
	 */
	void setVerticalAlignment(boolean value);
} // UMLShapeCompartment
