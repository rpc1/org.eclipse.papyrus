/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.uml2.uml.DataStoreNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Object Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getDataObjectRef <em>Data Object Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getBase_DataStoreNode <em>Base Data Store Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataObjectReference()
 * @model
 * @generated
 */
public interface DataObjectReference extends FlowElement, ItemAwareElement {
	/**
	 * Returns the value of the '<em><b>Data Object Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Object Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Object Ref</em>' reference.
	 * @see #setDataObjectRef(DataObject)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataObjectReference_DataObjectRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataObject getDataObjectRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getDataObjectRef <em>Data Object Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Object Ref</em>' reference.
	 * @see #getDataObjectRef()
	 * @generated
	 */
	void setDataObjectRef(DataObject value);

	/**
	 * Returns the value of the '<em><b>Base Data Store Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Data Store Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Data Store Node</em>' reference.
	 * @see #setBase_DataStoreNode(DataStoreNode)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataObjectReference_Base_DataStoreNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataStoreNode getBase_DataStoreNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataObjectReference#getBase_DataStoreNode <em>Base Data Store Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Store Node</em>' reference.
	 * @see #getBase_DataStoreNode()
	 * @generated
	 */
	void setBase_DataStoreNode(DataStoreNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Should be used between UML DataStoreNodes with BPMN
	 *   DataObject sytereotype applied,
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataObjectRef.source.target'"
	 * @generated
	 */
	boolean DataObjectRefsourcetarget(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * DataObjectRef::/dataState = DataStoreNode.inState (defined on ObjectNode)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='DataObjectRef.dataState'"
	 * @generated
	 */
	boolean DataObjectRefdataState(DiagnosticChain diagnostics, Map<Object, Object> context);

} // DataObjectReference
