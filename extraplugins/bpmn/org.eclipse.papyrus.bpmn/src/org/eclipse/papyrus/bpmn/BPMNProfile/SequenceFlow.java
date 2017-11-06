/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.ControlFlow;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getBase_ControlFlow <em>Base Control Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#isImmediate <em>Is Immediate</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getConditionExpression <em>Condition Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSequenceFlow()
 * @model
 * @generated
 */
public interface SequenceFlow extends FlowElement {
	/**
	 * Returns the value of the '<em><b>Base Control Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Control Flow</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Control Flow</em>' reference.
	 * @see #setBase_ControlFlow(ControlFlow)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSequenceFlow_Base_ControlFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControlFlow getBase_ControlFlow();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getBase_ControlFlow <em>Base Control Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Control Flow</em>' reference.
	 * @see #getBase_ControlFlow()
	 * @generated
	 */
	void setBase_ControlFlow(ControlFlow value);

	/**
	 * Returns the value of the '<em><b>Is Immediate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Immediate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Immediate</em>' attribute.
	 * @see #setIsImmediate(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSequenceFlow_IsImmediate()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isImmediate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#isImmediate <em>Is Immediate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Immediate</em>' attribute.
	 * @see #isImmediate()
	 * @generated
	 */
	void setIsImmediate(boolean value);

	/**
	 * Returns the value of the '<em><b>Condition Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Expression</em>' reference.
	 * @see #setConditionExpression(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSequenceFlow_ConditionExpression()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getConditionExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.SequenceFlow#getConditionExpression <em>Condition Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Expression</em>' reference.
	 * @see #getConditionExpression()
	 * @generated
	 */
	void setConditionExpression(BPMNExpression value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SequenceFlow::/conditionExpression : BPMNExpression = ControlFloe.guard  (defined on Activity edge)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SequenceFlow.conditionExpression'"
	 * @generated
	 */
	boolean SequenceFlowconditionExpression(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SequenceFlow::/sourceRef : ActivityNode = ControlFlow.source (defined on Activity edge). Constrained to elements stereotyped by BPMN Flow Node  stereotypes
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SequenceFlow.sourceRef'"
	 * @generated
	 */
	boolean SequenceFlowsourceRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SequenceFlow::/targetRef : ActivityNode = ControlFlow.target (defined on Activity edge). Constrained to elements stereotyped by BPMN Flow Node  stereotypes
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SequenceFlow.targetRef'"
	 * @generated
	 */
	boolean SequenceFlowtargetRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SequenceFlow
