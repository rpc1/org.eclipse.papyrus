/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target <em>target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLinkEventDefinition()
 * @model
 * @generated
 */
public interface LinkEventDefinition extends EventDefinition {
	/**
	 * Returns the value of the '<em><b>target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>target</em>' reference.
	 * @see #set_target(LinkEventDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLinkEventDefinition__target()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getSource
	 * @model opposite="source" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' target'"
	 * @generated
	 */
	LinkEventDefinition get_target();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target <em>target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>target</em>' reference.
	 * @see #get_target()
	 * @generated
	 */
	void set_target(LinkEventDefinition value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target <em>target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLinkEventDefinition_Source()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#get_target
	 * @model opposite="_target" required="true" ordered="false"
	 * @generated
	 */
	EList<LinkEventDefinition> getSource();

	/**
	 * Returns the value of the '<em><b>Base Call Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Call Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Call Event</em>' reference.
	 * @see #setBase_CallEvent(CallEvent)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getLinkEventDefinition_Base_CallEvent()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CallEvent getBase_CallEvent();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.LinkEventDefinition#getBase_CallEvent <em>Base Call Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Call Event</em>' reference.
	 * @see #getBase_CallEvent()
	 * @generated
	 */
	void setBase_CallEvent(CallEvent value);

} // LinkEventDefinition
