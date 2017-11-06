/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.ncpolicy;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Policy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CustomPolicy#getClassName <em>Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getCustomPolicy()
 * @model
 * @generated
 */
public interface CustomPolicy extends NewChildPolicy {
	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NcpolicyPackage#getCustomPolicy_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.CustomPolicy#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

} // CustomPolicy
