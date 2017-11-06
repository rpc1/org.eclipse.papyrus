/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Conversation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.SubConversation#getConversationNodes <em>Conversation Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSubConversation()
 * @model
 * @generated
 */
public interface SubConversation extends ConversationNode {
	/**
	 * Returns the value of the '<em><b>Conversation Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conversation Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conversation Nodes</em>' reference list.
	 * @see org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage#getSubConversation_ConversationNodes()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<ConversationNode> getConversationNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * SubConversation can link only collaboration properties (BPMN participants) and actions (BPMN events and BPMN activities)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/2.0.0/UML originalName='SubConversation.connected.elements'"
	 * @generated
	 */
	boolean SubConversationconnectedelements(DiagnosticChain diagnostics, Map<Object, Object> context);

} // SubConversation
