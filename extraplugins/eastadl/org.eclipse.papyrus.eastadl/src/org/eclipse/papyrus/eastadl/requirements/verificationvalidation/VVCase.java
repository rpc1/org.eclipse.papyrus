/**
 */
package org.eclipse.papyrus.eastadl.requirements.verificationvalidation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.VVCaseInstanceRef;
import org.eclipse.papyrus.eastadl.infrastructure.elements.TraceableSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VV Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * VVCase represents a V&V effort, i.e. it specifies concrete test subjects and targets and provides stimuli and the expected outcome on a concrete technical level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getAbstractVVCase <em>Abstract VV Case</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvTarget <em>Vv Target</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvSubject <em>Vv Subject</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvLog <em>Vv Log</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getVvProcedure <em>Vv Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase()
 * @model
 * @generated
 */
public interface VVCase extends TraceableSpecification {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Abstract VV Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract VV Case</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Abstract VV Case</em>' reference.
	 * @see #setAbstractVVCase(VVCase)
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_AbstractVVCase()
	 * @model ordered="false"
	 * @generated
	 */
	VVCase getAbstractVVCase();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVCase#getAbstractVVCase <em>Abstract VV Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Abstract VV Case</em>' reference.
	 * @see #getAbstractVVCase()
	 * @generated
	 */
	void setAbstractVVCase(VVCase value);

	/**
	 * Returns the value of the '<em><b>Vv Target</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVTarget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vv Target</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Vv Target</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_VvTarget()
	 * @model ordered="false"
	 * @generated
	 */
	EList<VVTarget> getVvTarget();

	/**
	 * Returns the value of the '<em><b>Vv Subject</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.VVCaseInstanceRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vv Subject</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Vv Subject</em>' containment reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_VvSubject()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VVCaseInstanceRef> getVvSubject();

	/**
	 * Returns the value of the '<em><b>Vv Log</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVLog}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vv Log</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Vv Log</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_VvLog()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<VVLog> getVvLog();

	/**
	 * Returns the value of the '<em><b>Vv Procedure</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VVProcedure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The abstract VV procedures for this AbstractVVCase.
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Vv Procedure</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage#getVVCase_VvProcedure()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<VVProcedure> getVvProcedure();

} // VVCase