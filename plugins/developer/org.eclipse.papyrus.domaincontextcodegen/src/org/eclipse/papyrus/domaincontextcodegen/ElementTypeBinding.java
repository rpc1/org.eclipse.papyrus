/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Type Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding#getRef <em>Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypeBinding()
 * @model
 * @generated
 */
public interface ElementTypeBinding extends Binding {

	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(ElementType)
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getElementTypeBinding_Ref()
	 * @model
	 * @generated
	 */
	ElementType getRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(ElementType value);

} // ElementTypeBinding