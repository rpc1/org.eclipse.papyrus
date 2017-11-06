/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

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

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNActivity;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BoundaryEvent;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boundary Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BoundaryEventImpl#isCancelActivity <em>Cancel Activity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BoundaryEventImpl#getAttachedToRef <em>Attached To Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BoundaryEventImpl extends CatchEventImpl implements BoundaryEvent {
	/**
	 * The default value of the '{@link #isCancelActivity() <em>Cancel Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCancelActivity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CANCEL_ACTIVITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCancelActivity() <em>Cancel Activity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCancelActivity()
	 * @generated
	 * @ordered
	 */
	protected boolean cancelActivity = CANCEL_ACTIVITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttachedToRef() <em>Attached To Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachedToRef()
	 * @generated
	 * @ordered
	 */
	protected BPMNActivity attachedToRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BoundaryEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBoundaryEvent();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCancelActivity() {
		return cancelActivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCancelActivity(boolean newCancelActivity) {
		boolean oldCancelActivity = cancelActivity;
		cancelActivity = newCancelActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BOUNDARY_EVENT__CANCEL_ACTIVITY, oldCancelActivity, cancelActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNActivity getAttachedToRef() {
		if (attachedToRef != null && attachedToRef.eIsProxy()) {
			InternalEObject oldAttachedToRef = (InternalEObject)attachedToRef;
			attachedToRef = (BPMNActivity)eResolveProxy(oldAttachedToRef);
			if (attachedToRef != oldAttachedToRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF, oldAttachedToRef, attachedToRef));
			}
		}
		return attachedToRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BPMNActivity basicGetAttachedToRef() {
		return attachedToRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttachedToRef(BPMNActivity newAttachedToRef) {
		BPMNActivity oldAttachedToRef = attachedToRef;
		attachedToRef = newAttachedToRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF, oldAttachedToRef, attachedToRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean boundaryEventattachedToRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.BOUNDARY_EVENT__BOUNDARY_EVENTATTACHED_TO_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "boundaryEventattachedToRef", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				return isCancelActivity();
			case BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF:
				if (resolve) return getAttachedToRef();
				return basicGetAttachedToRef();
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
			case BPMNProfilePackage.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				setCancelActivity((Boolean)newValue);
				return;
			case BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF:
				setAttachedToRef((BPMNActivity)newValue);
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
			case BPMNProfilePackage.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				setCancelActivity(CANCEL_ACTIVITY_EDEFAULT);
				return;
			case BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF:
				setAttachedToRef((BPMNActivity)null);
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
			case BPMNProfilePackage.BOUNDARY_EVENT__CANCEL_ACTIVITY:
				return cancelActivity != CANCEL_ACTIVITY_EDEFAULT;
			case BPMNProfilePackage.BOUNDARY_EVENT__ATTACHED_TO_REF:
				return attachedToRef != null;
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
			case BPMNProfilePackage.BOUNDARY_EVENT___BOUNDARY_EVENTATTACHED_TO_REF__DIAGNOSTICCHAIN_MAP:
				return boundaryEventattachedToRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (cancelActivity: ");
		result.append(cancelActivity);
		result.append(')');
		return result.toString();
	}

} //BoundaryEventImpl
