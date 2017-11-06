/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ExpansionRegion;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Instance Loop Characteristics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopCardinality <em>Loop Cardinality</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getCompletionCondition <em>Completion Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBase_ExpansionRegion <em>Base Expansion Region</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#isSequential <em>Is Sequential</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataInputRef <em>Loop Data Input Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataOutputRef <em>Loop Data Output Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOutputDataItem <em>Output Data Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getInputDataItem <em>Input Data Item</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getComplexBehaviorDefinition <em>Complex Behavior Definition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics()
 * @model
 * @generated
 */
public interface MultiInstanceLoopCharacteristics extends LoopCharacteristics {
	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' attribute.
	 * The default value is <code>"all"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior
	 * @see #setBehavior(MultiInstanceBehavior)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_Behavior()
	 * @model default="all" required="true" ordered="false"
	 * @generated
	 */
	MultiInstanceBehavior getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBehavior <em>Behavior</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' attribute.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceBehavior
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(MultiInstanceBehavior value);

	/**
	 * Returns the value of the '<em><b>Loop Cardinality</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Cardinality</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Cardinality</em>' reference.
	 * @see #setLoopCardinality(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_LoopCardinality()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getLoopCardinality();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopCardinality <em>Loop Cardinality</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Cardinality</em>' reference.
	 * @see #getLoopCardinality()
	 * @generated
	 */
	void setLoopCardinality(BPMNExpression value);

	/**
	 * Returns the value of the '<em><b>Completion Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Completion Condition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Completion Condition</em>' reference.
	 * @see #setCompletionCondition(BPMNExpression)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_CompletionCondition()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNExpression getCompletionCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getCompletionCondition <em>Completion Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Completion Condition</em>' reference.
	 * @see #getCompletionCondition()
	 * @generated
	 */
	void setCompletionCondition(BPMNExpression value);

	/**
	 * Returns the value of the '<em><b>Base Expansion Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Expansion Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Expansion Region</em>' reference.
	 * @see #setBase_ExpansionRegion(ExpansionRegion)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_Base_ExpansionRegion()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ExpansionRegion getBase_ExpansionRegion();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getBase_ExpansionRegion <em>Base Expansion Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Expansion Region</em>' reference.
	 * @see #getBase_ExpansionRegion()
	 * @generated
	 */
	void setBase_ExpansionRegion(ExpansionRegion value);

	/**
	 * Returns the value of the '<em><b>Is Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Sequential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Sequential</em>' attribute.
	 * @see #setIsSequential(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_IsSequential()
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isSequential();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#isSequential <em>Is Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Sequential</em>' attribute.
	 * @see #isSequential()
	 * @generated
	 */
	void setIsSequential(boolean value);

	/**
	 * Returns the value of the '<em><b>Loop Data Input Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Data Input Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Data Input Ref</em>' reference.
	 * @see #setLoopDataInputRef(ItemAwareElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_LoopDataInputRef()
	 * @model ordered="false"
	 * @generated
	 */
	ItemAwareElement getLoopDataInputRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataInputRef <em>Loop Data Input Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Data Input Ref</em>' reference.
	 * @see #getLoopDataInputRef()
	 * @generated
	 */
	void setLoopDataInputRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Loop Data Output Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Data Output Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Data Output Ref</em>' reference.
	 * @see #setLoopDataOutputRef(ItemAwareElement)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_LoopDataOutputRef()
	 * @model ordered="false"
	 * @generated
	 */
	ItemAwareElement getLoopDataOutputRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getLoopDataOutputRef <em>Loop Data Output Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Data Output Ref</em>' reference.
	 * @see #getLoopDataOutputRef()
	 * @generated
	 */
	void setLoopDataOutputRef(ItemAwareElement value);

	/**
	 * Returns the value of the '<em><b>Output Data Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Data Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Data Item</em>' reference.
	 * @see #setOutputDataItem(DataOutput)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_OutputDataItem()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataOutput getOutputDataItem();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOutputDataItem <em>Output Data Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Data Item</em>' reference.
	 * @see #getOutputDataItem()
	 * @generated
	 */
	void setOutputDataItem(DataOutput value);

	/**
	 * Returns the value of the '<em><b>Input Data Item</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Data Item</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data Item</em>' reference.
	 * @see #setInputDataItem(DataInput)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_InputDataItem()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataInput getInputDataItem();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getInputDataItem <em>Input Data Item</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Data Item</em>' reference.
	 * @see #getInputDataItem()
	 * @generated
	 */
	void setInputDataItem(DataInput value);

	/**
	 * Returns the value of the '<em><b>One Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Behavior Event Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Behavior Event Ref</em>' reference.
	 * @see #setOneBehaviorEventRef(EventDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_OneBehaviorEventRef()
	 * @model ordered="false"
	 * @generated
	 */
	EventDefinition getOneBehaviorEventRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getOneBehaviorEventRef <em>One Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Behavior Event Ref</em>' reference.
	 * @see #getOneBehaviorEventRef()
	 * @generated
	 */
	void setOneBehaviorEventRef(EventDefinition value);

	/**
	 * Returns the value of the '<em><b>None Behavior Event Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>None Behavior Event Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>None Behavior Event Ref</em>' reference.
	 * @see #setNoneBehaviorEventRef(EventDefinition)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_NoneBehaviorEventRef()
	 * @model ordered="false"
	 * @generated
	 */
	EventDefinition getNoneBehaviorEventRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.MultiInstanceLoopCharacteristics#getNoneBehaviorEventRef <em>None Behavior Event Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>None Behavior Event Ref</em>' reference.
	 * @see #getNoneBehaviorEventRef()
	 * @generated
	 */
	void setNoneBehaviorEventRef(EventDefinition value);

	/**
	 * Returns the value of the '<em><b>Complex Behavior Definition</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ComplexBehaviorDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex Behavior Definition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Behavior Definition</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getMultiInstanceLoopCharacteristics_ComplexBehaviorDefinition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ComplexBehaviorDefinition> getComplexBehaviorDefinition();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Stereotype may be applied only on CallActivity, Task, and SubProcess
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='MultiinstanceLoopCharacteristics.target'"
	 * @generated
	 */
	boolean MultiinstanceLoopCharacteristicstarget(DiagnosticChain diagnostics, Map<Object, Object> context);

} // MultiInstanceLoopCharacteristics
