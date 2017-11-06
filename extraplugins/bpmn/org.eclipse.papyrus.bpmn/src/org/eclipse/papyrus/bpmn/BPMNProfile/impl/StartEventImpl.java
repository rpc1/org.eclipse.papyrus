/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.StartEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Start Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.StartEventImpl#isInterrupting <em>Is Interrupting</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StartEventImpl extends CatchEventImpl implements StartEvent {
	/**
	 * The default value of the '{@link #isInterrupting() <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterrupting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INTERRUPTING_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isInterrupting() <em>Is Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInterrupting()
	 * @generated
	 * @ordered
	 */
	protected boolean isInterrupting = IS_INTERRUPTING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getStartEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterrupting() {
		return isInterrupting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInterrupting(boolean newIsInterrupting) {
		boolean oldIsInterrupting = isInterrupting;
		isInterrupting = newIsInterrupting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.START_EVENT__IS_INTERRUPTING, oldIsInterrupting, isInterrupting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.START_EVENT__IS_INTERRUPTING:
				return isInterrupting();
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
			case BPMNProfilePackage.START_EVENT__IS_INTERRUPTING:
				setIsInterrupting((Boolean)newValue);
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
			case BPMNProfilePackage.START_EVENT__IS_INTERRUPTING:
				setIsInterrupting(IS_INTERRUPTING_EDEFAULT);
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
			case BPMNProfilePackage.START_EVENT__IS_INTERRUPTING:
				return isInterrupting != IS_INTERRUPTING_EDEFAULT;
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
		result.append(" (isInterrupting: ");
		result.append(isInterrupting);
		result.append(')');
		return result.toString();
	}

} //StartEventImpl
