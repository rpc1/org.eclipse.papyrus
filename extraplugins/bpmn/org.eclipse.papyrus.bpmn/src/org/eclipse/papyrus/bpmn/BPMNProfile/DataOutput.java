/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_OutputPin <em>Base Output Pin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#isCollection <em>Is Collection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_Parameter <em>Base Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetRefs <em>Output Set Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithOptional <em>Output Set With Optional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getOutputSetWithWhileExecuting <em>Output Set With While Executing</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput()
 * @model
 * @generated
 */
public interface DataOutput extends ItemAwareElement {
	/**
	 * Returns the value of the '<em><b>Base Output Pin</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Output Pin</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Output Pin</em>' reference.
	 * @see #setBase_OutputPin(OutputPin)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_Base_OutputPin()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputPin getBase_OutputPin();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_OutputPin <em>Base Output Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Output Pin</em>' reference.
	 * @see #getBase_OutputPin()
	 * @generated
	 */
	void setBase_OutputPin(OutputPin value);

	/**
	 * Returns the value of the '<em><b>Is Collection</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Collection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Collection</em>' attribute.
	 * @see #setIsCollection(boolean)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_IsCollection()
	 * @model default="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isCollection();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#isCollection <em>Is Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Collection</em>' attribute.
	 * @see #isCollection()
	 * @generated
	 */
	void setIsCollection(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Parameter</em>' reference.
	 * @see #setBase_Parameter(Parameter)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_Base_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getBase_Parameter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_Parameter <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Parameter</em>' reference.
	 * @see #getBase_Parameter()
	 * @generated
	 */
	void setBase_Parameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Base Activity Parameter Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Parameter Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity Parameter Node</em>' reference.
	 * @see #setBase_ActivityParameterNode(ActivityParameterNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_Base_ActivityParameterNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActivityParameterNode getBase_ActivityParameterNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity Parameter Node</em>' reference.
	 * @see #getBase_ActivityParameterNode()
	 * @generated
	 */
	void setBase_ActivityParameterNode(ActivityParameterNode value);

	/**
	 * Returns the value of the '<em><b>Output Set Refs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getDataOutputRefs <em>Data Output Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Set Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Set Refs</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_OutputSetRefs()
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet#getDataOutputRefs
	 * @model opposite="dataOutputRefs" required="true" ordered="false"
	 * @generated
	 */
	EList<OutputSet> getOutputSetRefs();

	/**
	 * Returns the value of the '<em><b>Output Set With Optional</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Set With Optional</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Set With Optional</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_OutputSetWithOptional()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<OutputSet> getOutputSetWithOptional();

	/**
	 * Returns the value of the '<em><b>Output Set With While Executing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Set With While Executing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Set With While Executing</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataOutput_OutputSetWithWhileExecuting()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<OutputSet> getOutputSetWithWhileExecuting();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DataOutput owned by BPMN Process has a notation. 
	 * DataOutput owned by BPMN Activity has no notation. 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataOutput.notation'"
	 * @generated
	 */
	boolean DataOutputnotation(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DataOutput::/itemSubjectRef :ItemDefinition [0..1] = ObjectNode.type (defined on typed element)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataOutput.itemSubjectRef'"
	 * @generated
	 */
	boolean DataOutputitemSubjectRef(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataOutput
