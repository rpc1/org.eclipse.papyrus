/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BPMN Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getBase_Operation <em>Base Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getImplementationRef <em>Implementation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getInMessageRef <em>In Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getOutMessageRef <em>Out Message Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getErrorRef <em>Error Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation()
 * @model
 * @generated
 */
public interface BPMNOperation extends BaseElement {
	/**
	 * Returns the value of the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Operation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Operation</em>' reference.
	 * @see #setBase_Operation(Operation)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

	/**
	 * Returns the value of the '<em><b>Implementation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation Ref</em>' reference.
	 * @see #setImplementationRef(Element)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation_ImplementationRef()
	 * @model ordered="false"
	 * @generated
	 */
	Element getImplementationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getImplementationRef <em>Implementation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation Ref</em>' reference.
	 * @see #getImplementationRef()
	 * @generated
	 */
	void setImplementationRef(Element value);

	/**
	 * Returns the value of the '<em><b>In Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Message Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Message Ref</em>' reference.
	 * @see #setInMessageRef(BPMNMessage)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation_InMessageRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BPMNMessage getInMessageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getInMessageRef <em>In Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Message Ref</em>' reference.
	 * @see #getInMessageRef()
	 * @generated
	 */
	void setInMessageRef(BPMNMessage value);

	/**
	 * Returns the value of the '<em><b>Out Message Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Message Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Message Ref</em>' reference.
	 * @see #setOutMessageRef(BPMNMessage)
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation_OutMessageRef()
	 * @model ordered="false"
	 * @generated
	 */
	BPMNMessage getOutMessageRef();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.bpmn.BPMNProfile.BPMNOperation#getOutMessageRef <em>Out Message Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Message Ref</em>' reference.
	 * @see #getOutMessageRef()
	 * @generated
	 */
	void setOutMessageRef(BPMNMessage value);

	/**
	 * Returns the value of the '<em><b>Error Ref</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.Error}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Ref</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Ref</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getBPMNOperation_ErrorRef()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<org.eclipse.papyrus.bpmn.BPMNProfile.Error> getErrorRef();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BPMN Operation owner must be BPMN Interface.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BPMNOperation.owner'"
	 * @generated
	 */
	boolean BPMNOperationowner(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BPMNOperation::/inMessageRef : BPMNMessage = the first in Operation.ownedParameter with direction = in, and a type that has the BPMNMessage stereotype applied.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BPMNOperation.inMessageRef'"
	 * @generated
	 */
	boolean BPMNOperationinMessageRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BPMNOperation::/outMessageRef : BPMNMessage = the first in Operation.ownedParameter with direction = out or return, and a type that has the BPMNMessage stereotype applied.
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BPMNOperation.outMessageRef'"
	 * @generated
	 */
	boolean BPMNOperationoutMessageRef(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * BPMNOperation::/errorRefs : Error [*] =  Operation.raisedException (defined on Behavioral Feature)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='BPMNOperation.errorRefs'"
	 * @generated
	 */
	boolean BPMNOperationerrorRefs(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BPMNOperation
