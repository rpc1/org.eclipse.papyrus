/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EANumerical;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.RangeableValueType;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rangeable Value Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl#getAccuracy <em>Accuracy</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl#getResolution <em>Resolution</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl#getSignificantDigits <em>Significant Digits</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.RangeableValueTypeImpl#getBaseRangeable <em>Base Rangeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeableValueTypeImpl extends EADatatypeImpl implements RangeableValueType {
	/**
	 * The default value of the '{@link #getAccuracy() <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAccuracy()
	 * @generated
	 * @ordered
	 */
	protected static final Float ACCURACY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAccuracy() <em>Accuracy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAccuracy()
	 * @generated
	 * @ordered
	 */
	protected Float accuracy = ACCURACY_EDEFAULT;

	/**
	 * The default value of the '{@link #getResolution() <em>Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getResolution()
	 * @generated
	 * @ordered
	 */
	protected static final Float RESOLUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResolution() <em>Resolution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getResolution()
	 * @generated
	 * @ordered
	 */
	protected Float resolution = RESOLUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSignificantDigits() <em>Significant Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSignificantDigits()
	 * @generated
	 * @ordered
	 */
	protected static final int SIGNIFICANT_DIGITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSignificantDigits() <em>Significant Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSignificantDigits()
	 * @generated
	 * @ordered
	 */
	protected int significantDigits = SIGNIFICANT_DIGITS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBaseRangeable() <em>Base Rangeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBaseRangeable()
	 * @generated
	 * @ordered
	 */
	protected EANumerical baseRangeable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected RangeableValueTypeImpl() {
		super();
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
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__ACCURACY:
			return getAccuracy();
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__RESOLUTION:
			return getResolution();
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS:
			return getSignificantDigits();
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE:
			if (resolve) {
				return getBaseRangeable();
			}
			return basicGetBaseRangeable();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__ACCURACY:
			return ACCURACY_EDEFAULT == null ? accuracy != null : !ACCURACY_EDEFAULT.equals(accuracy);
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__RESOLUTION:
			return RESOLUTION_EDEFAULT == null ? resolution != null : !RESOLUTION_EDEFAULT.equals(resolution);
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS:
			return significantDigits != SIGNIFICANT_DIGITS_EDEFAULT;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE:
			return baseRangeable != null;
		}
		return super.eIsSet(featureID);
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
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__ACCURACY:
			setAccuracy((Float) newValue);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__RESOLUTION:
			setResolution((Float) newValue);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS:
			setSignificantDigits((Integer) newValue);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE:
			setBaseRangeable((EANumerical) newValue);
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
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.RANGEABLE_VALUE_TYPE;
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
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__ACCURACY:
			setAccuracy(ACCURACY_EDEFAULT);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__RESOLUTION:
			setResolution(RESOLUTION_EDEFAULT);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS:
			setSignificantDigits(SIGNIFICANT_DIGITS_EDEFAULT);
			return;
		case DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE:
			setBaseRangeable((EANumerical) null);
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
	public Float getAccuracy() {
		return accuracy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Float getResolution() {
		return resolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getSignificantDigits() {
		return significantDigits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setAccuracy(Float newAccuracy) {
		Float oldAccuracy = accuracy;
		accuracy = newAccuracy;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.RANGEABLE_VALUE_TYPE__ACCURACY, oldAccuracy, accuracy));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setResolution(Float newResolution) {
		Float oldResolution = resolution;
		resolution = newResolution;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.RANGEABLE_VALUE_TYPE__RESOLUTION, oldResolution, resolution));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSignificantDigits(int newSignificantDigits) {
		int oldSignificantDigits = significantDigits;
		significantDigits = newSignificantDigits;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.RANGEABLE_VALUE_TYPE__SIGNIFICANT_DIGITS, oldSignificantDigits, significantDigits));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EANumerical getBaseRangeable() {
		if (baseRangeable != null && baseRangeable.eIsProxy()) {
			InternalEObject oldBaseRangeable = (InternalEObject) baseRangeable;
			baseRangeable = (EANumerical) eResolveProxy(oldBaseRangeable);
			if (baseRangeable != oldBaseRangeable) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE, oldBaseRangeable, baseRangeable));
				}
			}
		}
		return baseRangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EANumerical basicGetBaseRangeable() {
		return baseRangeable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBaseRangeable(EANumerical newBaseRangeable) {
		EANumerical oldBaseRangeable = baseRangeable;
		baseRangeable = newBaseRangeable;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.RANGEABLE_VALUE_TYPE__BASE_RANGEABLE, oldBaseRangeable, baseRangeable));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (accuracy: ");
		result.append(accuracy);
		result.append(", resolution: ");
		result.append(resolution);
		result.append(", significantDigits: ");
		result.append(significantDigits);
		result.append(')');
		return result.toString();
	}

} // RangeableValueTypeImpl
