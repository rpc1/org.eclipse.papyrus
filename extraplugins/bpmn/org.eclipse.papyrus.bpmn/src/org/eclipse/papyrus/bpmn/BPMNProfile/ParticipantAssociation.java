/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Participant Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getInnerParticipantRef <em>Inner Participant Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getOuterParticipantRef <em>Outer Participant Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantAssociation()
 * @model
 * @generated
 */
public interface ParticipantAssociation extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantAssociation_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Inner Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Participant Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Participant Ref</em>' reference.
	 * @see #setInnerParticipantRef(Participant)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantAssociation_InnerParticipantRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Participant getInnerParticipantRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getInnerParticipantRef <em>Inner Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Participant Ref</em>' reference.
	 * @see #getInnerParticipantRef()
	 * @generated
	 */
	void setInnerParticipantRef(Participant value);

	/**
	 * Returns the value of the '<em><b>Outer Participant Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Participant Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Participant Ref</em>' reference.
	 * @see #setOuterParticipantRef(Participant)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getParticipantAssociation_OuterParticipantRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Participant getOuterParticipantRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.ParticipantAssociation#getOuterParticipantRef <em>Outer Participant Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Participant Ref</em>' reference.
	 * @see #getOuterParticipantRef()
	 * @generated
	 */
	void setOuterParticipantRef(Participant value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ParticipantAssociation::/innerParticipantRef : Participant = Dependency.supplier
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ParticipantAssociation.innerParticipantRef'"
	 * @generated
	 */
	boolean ParticipantAssociationinnerParticipantRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * ParticipantAssociation::/outerParticipantRef : Participant = Dependency.clients
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='ParticipantAssociation.outerParticipantRef'"
	 * @generated
	 */
	boolean ParticipantAssociationouterParticipantRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // ParticipantAssociation
