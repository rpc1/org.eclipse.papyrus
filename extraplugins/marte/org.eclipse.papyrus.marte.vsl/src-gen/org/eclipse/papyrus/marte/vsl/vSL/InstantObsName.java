/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instant Obs Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getPath <em>Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getInstantId <em>Instant Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInstantObsName()
 * @model
 * @generated
 */
public interface InstantObsName extends EObject
{
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Path</em>' containment reference.
	 * @see #setPath(QualifiedName)
	 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInstantObsName_Path()
	 * @model containment="true"
	 * @generated
	 */
	QualifiedName getPath();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getPath <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Path</em>' containment reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(QualifiedName value);

	/**
	 * Returns the value of the '<em><b>Instant Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instant Id</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Instant Id</em>' reference.
	 * @see #setInstantId(TimeObservation)
	 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getInstantObsName_InstantId()
	 * @model
	 * @generated
	 */
	TimeObservation getInstantId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.InstantObsName#getInstantId <em>Instant Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Instant Id</em>' reference.
	 * @see #getInstantId()
	 * @generated
	 */
	void setInstantId(TimeObservation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;'"
	 * @generated
	 */
	EObject getFilteredParentRule(EClass filter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;'"
	 * @generated
	 */
	Type getExpectedType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;'"
	 * @generated
	 */
	Element getContextElement();

} // InstantObsName
