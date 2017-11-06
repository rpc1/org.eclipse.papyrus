/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import org.eclipse.uml2.uml.DataStoreNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Store Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#get_dataStore <em>data Store</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#getBase_DataStoreNode <em>Base Data Store Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataStoreReference()
 * @model
 * @generated
 */
public interface DataStoreReference extends FlowElement, ItemAwareElement {
	/**
	 * Returns the value of the '<em><b>data Store</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>data Store</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>data Store</em>' reference.
	 * @see #set_dataStore(DataStore)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataStoreReference__dataStore()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName=' dataStore'"
	 * @generated
	 */
	DataStore get_dataStore();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#get_dataStore <em>data Store</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>data Store</em>' reference.
	 * @see #get_dataStore()
	 * @generated
	 */
	void set_dataStore(DataStore value);

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
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getDataStoreReference_Base_DataStoreNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataStoreNode getBase_DataStoreNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.DataStoreReference#getBase_DataStoreNode <em>Base Data Store Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Data Store Node</em>' reference.
	 * @see #getBase_DataStoreNode()
	 * @generated
	 */
	void setBase_DataStoreNode(DataStoreNode value);

} // DataStoreReference
