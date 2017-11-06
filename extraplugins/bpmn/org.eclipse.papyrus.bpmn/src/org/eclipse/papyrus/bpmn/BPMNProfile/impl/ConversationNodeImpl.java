/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ConversationNode;
import org.eclipse.papyrus.bpmn.BPMNProfile.CorrelationKey;
import org.eclipse.papyrus.bpmn.BPMNProfile.MessageFlow;
import org.eclipse.papyrus.bpmn.BPMNProfile.Participant;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.InformationFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conversation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl#getBase_InformationFlow <em>Base Information Flow</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl#getMessageFlowRefs <em>Message Flow Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl#getCorrelationKeys <em>Correlation Keys</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ConversationNodeImpl#getParticipantRefs <em>Participant Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ConversationNodeImpl extends InteractionNodeImpl implements ConversationNode {
	/**
	 * The cached value of the '{@link #getBase_InformationFlow() <em>Base Information Flow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InformationFlow()
	 * @generated
	 * @ordered
	 */
	protected InformationFlow base_InformationFlow;

	/**
	 * The cached value of the '{@link #getMessageFlowRefs() <em>Message Flow Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageFlowRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageFlow> messageFlowRefs;

	/**
	 * The cached value of the '{@link #getCorrelationKeys() <em>Correlation Keys</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationKeys()
	 * @generated
	 * @ordered
	 */
	protected EList<CorrelationKey> correlationKeys;

	/**
	 * The cached value of the '{@link #getParticipantRefs() <em>Participant Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipantRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participantRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConversationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getConversationNode();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationFlow getBase_InformationFlow() {
		if (base_InformationFlow != null && base_InformationFlow.eIsProxy()) {
			InternalEObject oldBase_InformationFlow = (InternalEObject)base_InformationFlow;
			base_InformationFlow = (InformationFlow)eResolveProxy(oldBase_InformationFlow);
			if (base_InformationFlow != oldBase_InformationFlow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW, oldBase_InformationFlow, base_InformationFlow));
			}
		}
		return base_InformationFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InformationFlow basicGetBase_InformationFlow() {
		return base_InformationFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InformationFlow(InformationFlow newBase_InformationFlow) {
		InformationFlow oldBase_InformationFlow = base_InformationFlow;
		base_InformationFlow = newBase_InformationFlow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW, oldBase_InformationFlow, base_InformationFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageFlow> getMessageFlowRefs() {
		if (messageFlowRefs == null) {
			messageFlowRefs = new EObjectResolvingEList<MessageFlow>(MessageFlow.class, this, BPMNProfilePackage.CONVERSATION_NODE__MESSAGE_FLOW_REFS);
		}
		return messageFlowRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CorrelationKey> getCorrelationKeys() {
		if (correlationKeys == null) {
			correlationKeys = new EObjectResolvingEList<CorrelationKey>(CorrelationKey.class, this, BPMNProfilePackage.CONVERSATION_NODE__CORRELATION_KEYS);
		}
		return correlationKeys;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getParticipantRefs() {
		if (participantRefs == null) {
			participantRefs = new EObjectResolvingEList<Participant>(Participant.class, this, BPMNProfilePackage.CONVERSATION_NODE__PARTICIPANT_REFS);
		}
		return participantRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean ConversationNodeparticipantRefs(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.CONVERSATION_NODE__CONVERSATION_NODEPARTICIPANT_REFS,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "ConversationNodeparticipantRefs", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW:
				if (resolve) return getBase_InformationFlow();
				return basicGetBase_InformationFlow();
			case BPMNProfilePackage.CONVERSATION_NODE__MESSAGE_FLOW_REFS:
				return getMessageFlowRefs();
			case BPMNProfilePackage.CONVERSATION_NODE__CORRELATION_KEYS:
				return getCorrelationKeys();
			case BPMNProfilePackage.CONVERSATION_NODE__PARTICIPANT_REFS:
				return getParticipantRefs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW:
				setBase_InformationFlow((InformationFlow)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__MESSAGE_FLOW_REFS:
				getMessageFlowRefs().clear();
				getMessageFlowRefs().addAll((Collection<? extends MessageFlow>)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				getCorrelationKeys().addAll((Collection<? extends CorrelationKey>)newValue);
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__PARTICIPANT_REFS:
				getParticipantRefs().clear();
				getParticipantRefs().addAll((Collection<? extends Participant>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW:
				setBase_InformationFlow((InformationFlow)null);
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__MESSAGE_FLOW_REFS:
				getMessageFlowRefs().clear();
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__CORRELATION_KEYS:
				getCorrelationKeys().clear();
				return;
			case BPMNProfilePackage.CONVERSATION_NODE__PARTICIPANT_REFS:
				getParticipantRefs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.CONVERSATION_NODE__BASE_INFORMATION_FLOW:
				return base_InformationFlow != null;
			case BPMNProfilePackage.CONVERSATION_NODE__MESSAGE_FLOW_REFS:
				return messageFlowRefs != null && !messageFlowRefs.isEmpty();
			case BPMNProfilePackage.CONVERSATION_NODE__CORRELATION_KEYS:
				return correlationKeys != null && !correlationKeys.isEmpty();
			case BPMNProfilePackage.CONVERSATION_NODE__PARTICIPANT_REFS:
				return participantRefs != null && !participantRefs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.CONVERSATION_NODE___CONVERSATION_NODEPARTICIPANT_REFS__DIAGNOSTICCHAIN_MAP:
				return ConversationNodeparticipantRefs((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //ConversationNodeImpl
