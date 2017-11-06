/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.ErrorEventDefinition;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Error Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorEventDefinitionImpl#getErrorRef <em>Error Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.ErrorEventDefinitionImpl#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorEventDefinitionImpl extends EventDefinitionImpl implements ErrorEventDefinition {
	/**
	 * The cached value of the '{@link #getErrorRef() <em>Error Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorRef()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.papyrus.bpmn.BPMNProfile.Error errorRef;

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
	protected ErrorEventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getErrorEventDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.bpmn.BPMNProfile.Error getErrorRef() {
		if (errorRef != null && errorRef.eIsProxy()) {
			InternalEObject oldErrorRef = (InternalEObject)errorRef;
			errorRef = (org.eclipse.papyrus.bpmn.BPMNProfile.Error)eResolveProxy(oldErrorRef);
			if (errorRef != oldErrorRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF, oldErrorRef, errorRef));
			}
		}
		return errorRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.papyrus.bpmn.BPMNProfile.Error basicGetErrorRef() {
		return errorRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorRef(org.eclipse.papyrus.bpmn.BPMNProfile.Error newErrorRef) {
		org.eclipse.papyrus.bpmn.BPMNProfile.Error oldErrorRef = errorRef;
		errorRef = newErrorRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF, oldErrorRef, errorRef));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF:
				if (resolve) return getErrorRef();
				return basicGetErrorRef();
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF:
				setErrorRef((org.eclipse.papyrus.bpmn.BPMNProfile.Error)newValue);
				return;
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF:
				setErrorRef((org.eclipse.papyrus.bpmn.BPMNProfile.Error)null);
				return;
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__ERROR_REF:
				return errorRef != null;
			case BPMNProfilePackage.ERROR_EVENT_DEFINITION__BASE_CALL_EVENT:
				return base_CallEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //ErrorEventDefinitionImpl
