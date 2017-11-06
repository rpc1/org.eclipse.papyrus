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
package org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeatureImpl;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.DeviationAttributeSet;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehicleFeature;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Vehicle Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsDesignVariabilityRationale <em>Is Design Variability Rationale</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsCustomerVisible <em>Is Customer Visible</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#isIsRemoved <em>Is Removed</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehicleFeatureImpl#getDeviationAttributeSet <em>Deviation Attribute Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VehicleFeatureImpl extends FeatureImpl implements VehicleFeature {

	/**
	 * The default value of the '{@link #isIsDesignVariabilityRationale() <em>Is Design Variability Rationale</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isIsDesignVariabilityRationale()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDesignVariabilityRationale() <em>Is Design Variability Rationale</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #isIsDesignVariabilityRationale()
	 * @generated
	 * @ordered
	 */
	protected boolean isDesignVariabilityRationale = IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsCustomerVisible() <em>Is Customer Visible</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isIsCustomerVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CUSTOMER_VISIBLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCustomerVisible() <em>Is Customer Visible</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isIsCustomerVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean isCustomerVisible = IS_CUSTOMER_VISIBLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsRemoved() <em>Is Removed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isIsRemoved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_REMOVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsRemoved() <em>Is Removed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isIsRemoved()
	 * @generated
	 * @ordered
	 */
	protected boolean isRemoved = IS_REMOVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VehicleFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public DeviationAttributeSet basicGetDeviationAttributeSet() {
		DeviationAttributeSet adlDeviationAttributeSet = null;
		if (getBase_NamedElement() != null) {
			Iterator<Element> it = getBase_NamedElement().getOwnedElements().iterator();

			while (it.hasNext()) {
				Element element = it.next();
				adlDeviationAttributeSet = UMLUtil.getStereotypeApplication(element, DeviationAttributeSet.class);
				if (adlDeviationAttributeSet != null) {
					return adlDeviationAttributeSet;
				}
			}
		}

		return adlDeviationAttributeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			return isIsDesignVariabilityRationale();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			return isIsCustomerVisible();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			return isIsRemoved();
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			if (resolve) {
				return getDeviationAttributeSet();
			}
			return basicGetDeviationAttributeSet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			return isDesignVariabilityRationale != IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			return isCustomerVisible != IS_CUSTOMER_VISIBLE_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			return isRemoved != IS_REMOVED_EDEFAULT;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			return basicGetDeviationAttributeSet() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			setIsDesignVariabilityRationale((Boolean) newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			setIsCustomerVisible((Boolean) newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			setIsRemoved((Boolean) newValue);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			setDeviationAttributeSet((DeviationAttributeSet) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VehiclefeaturemodelingPackage.Literals.VEHICLE_FEATURE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE:
			setIsDesignVariabilityRationale(IS_DESIGN_VARIABILITY_RATIONALE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE:
			setIsCustomerVisible(IS_CUSTOMER_VISIBLE_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED:
			setIsRemoved(IS_REMOVED_EDEFAULT);
			return;
		case VehiclefeaturemodelingPackage.VEHICLE_FEATURE__DEVIATION_ATTRIBUTE_SET:
			setDeviationAttributeSet((DeviationAttributeSet) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DeviationAttributeSet getDeviationAttributeSet() {
		DeviationAttributeSet deviationAttributeSet = basicGetDeviationAttributeSet();
		return deviationAttributeSet != null && deviationAttributeSet.eIsProxy() ? (DeviationAttributeSet) eResolveProxy((InternalEObject) deviationAttributeSet) : deviationAttributeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsCustomerVisible() {
		return isCustomerVisible;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsDesignVariabilityRationale() {
		return isDesignVariabilityRationale;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isIsRemoved() {
		return isRemoved;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDeviationAttributeSet(DeviationAttributeSet newDeviationAttributeSet) {
		// TODO: implement this method to set the 'Deviation Attribute Set' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsCustomerVisible(boolean newIsCustomerVisible) {
		boolean oldIsCustomerVisible = isCustomerVisible;
		isCustomerVisible = newIsCustomerVisible;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_CUSTOMER_VISIBLE, oldIsCustomerVisible, isCustomerVisible));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsDesignVariabilityRationale(boolean newIsDesignVariabilityRationale) {
		boolean oldIsDesignVariabilityRationale = isDesignVariabilityRationale;
		isDesignVariabilityRationale = newIsDesignVariabilityRationale;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_DESIGN_VARIABILITY_RATIONALE, oldIsDesignVariabilityRationale, isDesignVariabilityRationale));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsRemoved(boolean newIsRemoved) {
		boolean oldIsRemoved = isRemoved;
		isRemoved = newIsRemoved;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VehiclefeaturemodelingPackage.VEHICLE_FEATURE__IS_REMOVED, oldIsRemoved, isRemoved));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isDesignVariabilityRationale: ");
		result.append(isDesignVariabilityRationale);
		result.append(", isCustomerVisible: ");
		result.append(isCustomerVisible);
		result.append(", isRemoved: ");
		result.append(isRemoved);
		result.append(')');
		return result.toString();
	}

} // VehicleFeatureImpl
