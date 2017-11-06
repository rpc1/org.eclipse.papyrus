/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GMFT_BasedRepresentation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>GMFT Based Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.GMFT_BasedRepresentationImpl#getReusedID <em>Reused ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GMFT_BasedRepresentationImpl extends RepresentationImpl implements GMFT_BasedRepresentation {
	/**
	 * The default value of the '{@link #getReusedID() <em>Reused ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReusedID()
	 * @generated
	 * @ordered
	 */
	protected static final String REUSED_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReusedID() <em>Reused ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReusedID()
	 * @generated
	 * @ordered
	 */
	protected String reusedID = REUSED_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GMFT_BasedRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionmodelPackage.Literals.GMFT_BASED_REPRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getReusedID() {
		return reusedID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReusedID(String newReusedID) {
		String oldReusedID = reusedID;
		reusedID = newReusedID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID, oldReusedID, reusedID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				return getReusedID();
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
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				setReusedID((String)newValue);
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
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				setReusedID(REUSED_ID_EDEFAULT);
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
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION__REUSED_ID:
				return REUSED_ID_EDEFAULT == null ? reusedID != null : !REUSED_ID_EDEFAULT.equals(reusedID);
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
		result.append(" (reusedID: ");
		result.append(reusedID);
		result.append(')');
		return result.toString();
	}

} //GMFT_BasedRepresentationImpl
