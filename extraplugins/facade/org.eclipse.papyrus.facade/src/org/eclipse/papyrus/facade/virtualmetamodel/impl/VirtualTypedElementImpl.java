/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualClassifier;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualTypedElementImpl#getLower <em>Lower</em>}</li>
 * <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualTypedElementImpl#getUpper <em>Upper</em>}</li>
 * <li>{@link org.eclipse.papyrus.facade.virtualmetamodel.impl.VirtualTypedElementImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class VirtualTypedElementImpl extends VirtualElementImpl implements VirtualTypedElement {
	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final int LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected int lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected int upper = UPPER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected VirtualClassifier type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualTypedElementImpl() {
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
		return VirtualmetamodelPackage.Literals.VIRTUAL_TYPED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setLower(int newLower) {
		int oldLower = lower;
		lower = newLower;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__LOWER, oldLower, lower));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setUpper(int newUpper) {
		int oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__UPPER, oldUpper, upper));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public VirtualClassifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (VirtualClassifier) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE, oldType, type));
				}
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public VirtualClassifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setType(VirtualClassifier newType) {
		VirtualClassifier oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE, oldType, type));
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
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__LOWER:
			return getLower();
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__UPPER:
			return getUpper();
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE:
			if (resolve) {
				return getType();
			}
			return basicGetType();
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
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__LOWER:
			setLower((Integer) newValue);
			return;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__UPPER:
			setUpper((Integer) newValue);
			return;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE:
			setType((VirtualClassifier) newValue);
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
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__LOWER:
			setLower(LOWER_EDEFAULT);
			return;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__UPPER:
			setUpper(UPPER_EDEFAULT);
			return;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE:
			setType((VirtualClassifier) null);
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
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__LOWER:
			return lower != LOWER_EDEFAULT;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__UPPER:
			return upper != UPPER_EDEFAULT;
		case VirtualmetamodelPackage.VIRTUAL_TYPED_ELEMENT__TYPE:
			return type != null;
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
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(')');
		return result.toString();
	}

} // VirtualTypedElementImpl
