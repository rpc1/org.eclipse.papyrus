/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Compartment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.LiteralCompartment#getEnumerationShape <em>Enumeration Shape</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLiteralCompartment()
 * @model
 * @generated
 */
public interface LiteralCompartment extends ListCompartment {

	/**
	 * Returns the value of the '<em><b>Enumeration Shape</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.umldi.EnumerationShape#getLiteralCompartment <em>Literal Compartment</em>}
	 * '.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 * <li>'{@link org.eclipse.papyrus.umldi.UmlDiagramElement#getOwningUmlDiagramElement() <em>Owning Uml Diagram Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Shape</em>' container reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Enumeration Shape</em>' container reference.
	 * @see #setEnumerationShape(EnumerationShape)
	 * @see org.eclipse.papyrus.umldi.UMLDIPackage#getLiteralCompartment_EnumerationShape()
	 * @see org.eclipse.papyrus.umldi.EnumerationShape#getLiteralCompartment
	 * @model opposite="literalCompartment" transient="false" ordered="false"
	 * @generated
	 */
	EnumerationShape getEnumerationShape();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.umldi.LiteralCompartment#getEnumerationShape <em>Enumeration Shape</em>}' container
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Enumeration Shape</em>' container reference.
	 * @see #getEnumerationShape()
	 * @generated
	 */
	void setEnumerationShape(EnumerationShape value);
} // LiteralCompartment
