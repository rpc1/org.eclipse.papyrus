/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration#getRoots <em>Roots</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration#getNewChildPolicies <em>New Child Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getNewchildConfiguration()
 * @model
 * @generated
 */
public interface NewchildConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Roots</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.newchild.MenuRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roots</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Roots</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getNewchildConfiguration_Roots()
	 * @model containment="true"
	 * @generated
	 */
	EList<MenuRoot> getRoots();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getNewchildConfiguration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>New Child Policies</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Child Policies</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>New Child Policies</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.emf.newchild.NewchildPackage#getNewchildConfiguration_NewChildPolicies()
	 * @model containment="true"
	 * @generated
	 */
	EList<NewChildPolicySet> getNewChildPolicies();

} // NewchildConfiguration
