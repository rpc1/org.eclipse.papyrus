/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNSignal;
import org.eclipse.papyrus.bpmn.BPMNProfile.SignalEventDefinition;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SignalEventDefinitionImpl#getSignalRef <em>Signal Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.SignalEventDefinitionImpl#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SignalEventDefinitionImpl extends EventDefinitionImpl implements SignalEventDefinition {
	/**
	 * The cached value of the '{@link #getSignalRef() <em>Signal Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignalRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNSignal signalRef;

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
	protected SignalEventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getSignalEventDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNSignal getSignalRef() {
		if (signalRef != null && signalRef.eIsProxy()) {
			InternalEObject oldSignalRef = (InternalEObject)signalRef;
			signalRef = (BPMNSignal)eResolveProxy(oldSignalRef);
			if (signalRef != oldSignalRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF, oldSignalRef, signalRef));
			}
		}
		return signalRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNSignal basicGetSignalRef() {
		return signalRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignalRef(BPMNSignal newSignalRef) {
		BPMNSignal oldSignalRef = signalRef;
		signalRef = newSignalRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF, oldSignalRef, signalRef));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF:
				if (resolve) return getSignalRef();
				return basicGetSignalRef();
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF:
				setSignalRef((BPMNSignal)newValue);
				return;
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF:
				setSignalRef((BPMNSignal)null);
				return;
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__SIGNAL_REF:
				return signalRef != null;
			case BPMNProfilePackage.SIGNAL_EVENT_DEFINITION__BASE_CALL_EVENT:
				return base_CallEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //SignalEventDefinitionImpl
