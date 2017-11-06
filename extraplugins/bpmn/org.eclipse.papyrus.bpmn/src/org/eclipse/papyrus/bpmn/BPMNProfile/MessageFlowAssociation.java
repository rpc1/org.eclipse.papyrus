/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Flow Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getInnerMessageFlowRef <em>Inner Message Flow Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getOuterMessageFlowRef <em>Outer Message Flow Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlowAssociation()
 * @model
 * @generated
 */
public interface MessageFlowAssociation extends BaseElement {
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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlowAssociation_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Inner Message Flow Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Message Flow Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Message Flow Ref</em>' reference.
	 * @see #setInnerMessageFlowRef(MessageFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlowAssociation_InnerMessageFlowRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MessageFlow getInnerMessageFlowRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getInnerMessageFlowRef <em>Inner Message Flow Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Message Flow Ref</em>' reference.
	 * @see #getInnerMessageFlowRef()
	 * @generated
	 */
	void setInnerMessageFlowRef(MessageFlow value);

	/**
	 * Returns the value of the '<em><b>Outer Message Flow Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outer Message Flow Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outer Message Flow Ref</em>' reference.
	 * @see #setOuterMessageFlowRef(MessageFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMessageFlowAssociation_OuterMessageFlowRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MessageFlow getOuterMessageFlowRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlowAssociation#getOuterMessageFlowRef <em>Outer Message Flow Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outer Message Flow Ref</em>' reference.
	 * @see #getOuterMessageFlowRef()
	 * @generated
	 */
	void setOuterMessageFlowRef(MessageFlow value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MessageFlowAssociation InnerMessageFlowRef is a UML dependency supplier
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MessageFlowAssociation.innerMessageFlowRef'"
	 * @generated
	 */
	boolean MessageFlowAssociationinnerMessageFlowRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * MessageFlowAssociation OuterMessageFlowRef is a UML dependency client
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MessageFlowAssociation.outerMessageFlowRef'"
	 * @generated
	 */
	boolean MessageFlowAssociationouterMessageFlowRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MessageFlowAssociation
