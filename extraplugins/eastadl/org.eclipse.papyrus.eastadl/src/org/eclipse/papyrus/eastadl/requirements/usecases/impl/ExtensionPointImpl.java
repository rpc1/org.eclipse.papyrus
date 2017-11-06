/**
 */
package org.eclipse.papyrus.eastadl.requirements.usecases.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.requirements.usecases.ExtensionPoint;
import org.eclipse.papyrus.eastadl.requirements.usecases.UsecasesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.usecases.impl.ExtensionPointImpl#getBase_ExtensionPoint <em>Base Extension Point</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionPointImpl extends RedefinableElementImpl implements ExtensionPoint {
	/**
	 * The cached value of the '{@link #getBase_ExtensionPoint() <em>Base Extension Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBase_ExtensionPoint()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.ExtensionPoint base_ExtensionPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ExtensionPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsecasesPackage.Literals.EXTENSION_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.ExtensionPoint getBase_ExtensionPoint() {
		if (base_ExtensionPoint != null && base_ExtensionPoint.eIsProxy()) {
			InternalEObject oldBase_ExtensionPoint = (InternalEObject) base_ExtensionPoint;
			base_ExtensionPoint = (org.eclipse.uml2.uml.ExtensionPoint) eResolveProxy(oldBase_ExtensionPoint);
			if (base_ExtensionPoint != oldBase_ExtensionPoint) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT, oldBase_ExtensionPoint, base_ExtensionPoint));
				}
			}
		}
		return base_ExtensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public org.eclipse.uml2.uml.ExtensionPoint basicGetBase_ExtensionPoint() {
		return base_ExtensionPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBase_ExtensionPoint(org.eclipse.uml2.uml.ExtensionPoint newBase_ExtensionPoint) {
		org.eclipse.uml2.uml.ExtensionPoint oldBase_ExtensionPoint = base_ExtensionPoint;
		base_ExtensionPoint = newBase_ExtensionPoint;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT, oldBase_ExtensionPoint, base_ExtensionPoint));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT:
			if (resolve) {
				return getBase_ExtensionPoint();
			}
			return basicGetBase_ExtensionPoint();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT:
			setBase_ExtensionPoint((org.eclipse.uml2.uml.ExtensionPoint) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT:
			setBase_ExtensionPoint((org.eclipse.uml2.uml.ExtensionPoint) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case UsecasesPackage.EXTENSION_POINT__BASE_EXTENSION_POINT:
			return base_ExtensionPoint != null;
		}
		return super.eIsSet(featureID);
	}

} // ExtensionPointImpl