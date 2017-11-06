/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.impl;

import SoaML.Collaboration;
import SoaML.SoaMLPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SoaML.impl.CollaborationImpl#getBase_Collaboration <em>Base Collaboration</em>}</li>
 *   <li>{@link SoaML.impl.CollaborationImpl#isStrict <em>Is Strict</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollaborationImpl extends MinimalEObjectImpl.Container implements Collaboration {
	/**
	 * The cached value of the '{@link #getBase_Collaboration() <em>Base Collaboration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Collaboration()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Collaboration base_Collaboration;

	/**
	 * The default value of the '{@link #isStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_STRICT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isStrict() <em>Is Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected boolean isStrict = IS_STRICT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollaborationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SoaMLPackage.Literals.COLLABORATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Collaboration getBase_Collaboration() {
		if (base_Collaboration != null && base_Collaboration.eIsProxy()) {
			InternalEObject oldBase_Collaboration = (InternalEObject)base_Collaboration;
			base_Collaboration = (org.eclipse.uml2.uml.Collaboration)eResolveProxy(oldBase_Collaboration);
			if (base_Collaboration != oldBase_Collaboration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SoaMLPackage.COLLABORATION__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
			}
		}
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Collaboration basicGetBase_Collaboration() {
		return base_Collaboration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Collaboration(org.eclipse.uml2.uml.Collaboration newBase_Collaboration) {
		org.eclipse.uml2.uml.Collaboration oldBase_Collaboration = base_Collaboration;
		base_Collaboration = newBase_Collaboration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaMLPackage.COLLABORATION__BASE_COLLABORATION, oldBase_Collaboration, base_Collaboration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrict() {
		return isStrict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsStrict(boolean newIsStrict) {
		boolean oldIsStrict = isStrict;
		isStrict = newIsStrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SoaMLPackage.COLLABORATION__IS_STRICT, oldIsStrict, isStrict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SoaMLPackage.COLLABORATION__BASE_COLLABORATION:
				if (resolve) return getBase_Collaboration();
				return basicGetBase_Collaboration();
			case SoaMLPackage.COLLABORATION__IS_STRICT:
				return isStrict();
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
			case SoaMLPackage.COLLABORATION__BASE_COLLABORATION:
				setBase_Collaboration((org.eclipse.uml2.uml.Collaboration)newValue);
				return;
			case SoaMLPackage.COLLABORATION__IS_STRICT:
				setIsStrict((Boolean)newValue);
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
			case SoaMLPackage.COLLABORATION__BASE_COLLABORATION:
				setBase_Collaboration((org.eclipse.uml2.uml.Collaboration)null);
				return;
			case SoaMLPackage.COLLABORATION__IS_STRICT:
				setIsStrict(IS_STRICT_EDEFAULT);
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
			case SoaMLPackage.COLLABORATION__BASE_COLLABORATION:
				return base_Collaboration != null;
			case SoaMLPackage.COLLABORATION__IS_STRICT:
				return isStrict != IS_STRICT_EDEFAULT;
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
		result.append(" (isStrict: ");
		result.append(isStrict);
		result.append(')');
		return result.toString();
	}

} //CollaborationImpl
