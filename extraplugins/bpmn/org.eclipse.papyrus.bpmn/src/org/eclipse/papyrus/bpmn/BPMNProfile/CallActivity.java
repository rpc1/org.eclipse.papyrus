/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.CallBehaviorAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getBase_CallBehaviorAction <em>Base Call Behavior Action</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getCalledElementRef <em>Called Element Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCallActivity()
 * @model
 * @generated
 */
public interface CallActivity extends BPMNActivity {
	/**
	 * Returns the value of the '<em><b>Base Call Behavior Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Call Behavior Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Call Behavior Action</em>' reference.
	 * @see #setBase_CallBehaviorAction(CallBehaviorAction)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCallActivity_Base_CallBehaviorAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CallBehaviorAction getBase_CallBehaviorAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getBase_CallBehaviorAction <em>Base Call Behavior Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Call Behavior Action</em>' reference.
	 * @see #getBase_CallBehaviorAction()
	 * @generated
	 */
	void setBase_CallBehaviorAction(CallBehaviorAction value);

	/**
	 * Returns the value of the '<em><b>Called Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Element Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Element Ref</em>' reference.
	 * @see #setCalledElementRef(CallableElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getCallActivity_CalledElementRef()
	 * @model ordered="false"
	 * @generated
	 */
	CallableElement getCalledElementRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.CallActivity#getCalledElementRef <em>Called Element Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Element Ref</em>' reference.
	 * @see #getCalledElementRef()
	 * @generated
	 */
	void setCalledElementRef(CallableElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.calledElementRef = self.base_CallBehaviorAction.behavior.extension_CallableElement
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='CallActivity.calledElementRef.values'"
	 * @generated
	 */
	boolean CallActivitycalledElementRefvalues(DiagnosticChain diagnostics, Map<Object, Object> context);

} // CallActivity
