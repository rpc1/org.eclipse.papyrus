/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CompensateEventDefinition;

import org.eclipse.uml2.uml.CallEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compensate Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CompensateEventDefinitionImpl#isWaitForCompletion <em>Wait For Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CompensateEventDefinitionImpl#getActivityRef <em>Activity Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.CompensateEventDefinitionImpl#getBase_CallEvent <em>Base Call Event</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompensateEventDefinitionImpl extends EventDefinitionImpl implements CompensateEventDefinition {
	/**
	 * The default value of the '{@link #isWaitForCompletion() <em>Wait For Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaitForCompletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WAIT_FOR_COMPLETION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isWaitForCompletion() <em>Wait For Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWaitForCompletion()
	 * @generated
	 * @ordered
	 */
	protected boolean waitForCompletion = WAIT_FOR_COMPLETION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActivityRef() <em>Activity Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNActivity activityRef;

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
	protected CompensateEventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getCompensateEventDefinition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWaitForCompletion() {
		return waitForCompletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWaitForCompletion(boolean newWaitForCompletion) {
		boolean oldWaitForCompletion = waitForCompletion;
		waitForCompletion = newWaitForCompletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION, oldWaitForCompletion, waitForCompletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNActivity getActivityRef() {
		if (activityRef != null && activityRef.eIsProxy()) {
			InternalEObject oldActivityRef = (InternalEObject)activityRef;
			activityRef = (BPMNActivity)eResolveProxy(oldActivityRef);
			if (activityRef != oldActivityRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF, oldActivityRef, activityRef));
			}
		}
		return activityRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNActivity basicGetActivityRef() {
		return activityRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityRef(BPMNActivity newActivityRef) {
		BPMNActivity oldActivityRef = activityRef;
		activityRef = newActivityRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF, oldActivityRef, activityRef));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT, oldBase_CallEvent, base_CallEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION:
				return isWaitForCompletion();
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF:
				if (resolve) return getActivityRef();
				return basicGetActivityRef();
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION:
				setWaitForCompletion((Boolean)newValue);
				return;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF:
				setActivityRef((BPMNActivity)newValue);
				return;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION:
				setWaitForCompletion(WAIT_FOR_COMPLETION_EDEFAULT);
				return;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF:
				setActivityRef((BPMNActivity)null);
				return;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT:
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
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__WAIT_FOR_COMPLETION:
				return waitForCompletion != WAIT_FOR_COMPLETION_EDEFAULT;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__ACTIVITY_REF:
				return activityRef != null;
			case BPMNProfilePackage.COMPENSATE_EVENT_DEFINITION__BASE_CALL_EVENT:
				return base_CallEvent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (waitForCompletion: ");
		result.append(waitForCompletion);
		result.append(')');
		return result.toString();
	}

} //CompensateEventDefinitionImpl
