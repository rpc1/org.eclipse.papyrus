/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.Escalation;
import org.eclipse.papyrus.bpmn.BPMNProfile.EscalationEventDefinition;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Escalation Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationEventDefinitionImpl#getEscalationRef <em>Escalation Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.EscalationEventDefinitionImpl#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EscalationEventDefinitionImpl extends EventDefinitionImpl implements EscalationEventDefinition {
	/**
	 * The cached value of the '{@link #getEscalationRef() <em>Escalation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationRef()
	 * @generated
	 * @ordered
	 */
	protected Escalation escalationRef;

	/**
	 * The cached value of the '{@link #getBase_CallEvent() <em>Base Call Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_CallEvent()
	 * @generated
	 * @ordered
	 */
	protected CallEvent base_CallEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EscalationEventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getEscalationEventDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Escalation getEscalationRef() {
		if (escalationRef != null && escalationRef.eIsProxy()) {
			InternalEObject oldEscalationRef = (InternalEObject)escalationRef;
			escalationRef = (Escalation)eResolveProxy(oldEscalationRef);
			if (escalationRef != oldEscalationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF, oldEscalationRef, escalationRef));
			}
		}
		return escalationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Escalation basicGetEscalationRef() {
		return escalationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscalationRef(Escalation newEscalationRef) {
		Escalation oldEscalationRef = escalationRef;
		escalationRef = newEscalationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF, oldEscalationRef, escalationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallEvent getBase_CallEvent() {
		if (base_CallEvent != null && base_CallEvent.eIsProxy()) {
			InternalEObject oldBase_CallEvent = (InternalEObject)base_CallEvent;
			base_CallEvent = (CallEvent)eResolveProxy(oldBase_CallEvent);
			if (base_CallEvent != oldBase_CallEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
			}
		}
		return base_CallEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallEvent basicGetBase_CallEvent() {
		return base_CallEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_CallEvent(CallEvent newBase_CallEvent) {
		CallEvent oldBase_CallEvent = base_CallEvent;
		base_CallEvent = newBase_CallEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF:
				if (resolve) return getEscalationRef();
				return basicGetEscalationRef();
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT:
				if (resolve) return getBase_CallEvent();
				return basicGetBase_CallEvent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF:
				setEscalationRef((Escalation)newValue);
				return;
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT:
				setBase_CallEvent((CallEvent)newValue);
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
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF:
				setEscalationRef((Escalation)null);
				return;
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT:
				setBase_CallEvent((CallEvent)null);
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
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__ESCALATION_REF:
				return escalationRef != null;
			case BPMNProfilePackage.ESCALATION_EVENT_DEFINITION__BASE_CALL_EVENT:
				return base_CallEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //EscalationEventDefinitionImpl
