/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.HierarchyPermission;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Hierarchy Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl.HierarchyPermissionImpl#getContainerType <em>Container Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl.HierarchyPermissionImpl#isPermitted <em>Permitted</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl.HierarchyPermissionImpl#isStrict <em>Strict</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HierarchyPermissionImpl extends MinimalEObjectImpl.Container implements HierarchyPermission {
	/**
	 * The default value of the '{@link #getContainerType() <em>Container Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTAINER_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainerType() <em>Container Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerType()
	 * @generated
	 * @ordered
	 */
	protected String containerType = CONTAINER_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isPermitted() <em>Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPermitted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERMITTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPermitted() <em>Permitted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPermitted()
	 * @generated
	 * @ordered
	 */
	protected boolean permitted = PERMITTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isStrict() <em>Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRICT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStrict() <em>Strict</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrict()
	 * @generated
	 * @ordered
	 */
	protected boolean strict = STRICT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HierarchyPermissionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InvariantContainerRuleConfigurationPackage.Literals.HIERARCHY_PERMISSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContainerType() {
		return containerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerType(String newContainerType) {
		String oldContainerType = containerType;
		containerType = newContainerType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__CONTAINER_TYPE, oldContainerType, containerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPermitted() {
		return permitted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermitted(boolean newPermitted) {
		boolean oldPermitted = permitted;
		permitted = newPermitted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__PERMITTED, oldPermitted, permitted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStrict() {
		return strict;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStrict(boolean newStrict) {
		boolean oldStrict = strict;
		strict = newStrict;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__STRICT, oldStrict, strict));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__CONTAINER_TYPE:
				return getContainerType();
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__PERMITTED:
				return isPermitted();
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__STRICT:
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
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__CONTAINER_TYPE:
				setContainerType((String)newValue);
				return;
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__PERMITTED:
				setPermitted((Boolean)newValue);
				return;
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__STRICT:
				setStrict((Boolean)newValue);
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
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__CONTAINER_TYPE:
				setContainerType(CONTAINER_TYPE_EDEFAULT);
				return;
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__PERMITTED:
				setPermitted(PERMITTED_EDEFAULT);
				return;
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__STRICT:
				setStrict(STRICT_EDEFAULT);
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
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__CONTAINER_TYPE:
				return CONTAINER_TYPE_EDEFAULT == null ? containerType != null : !CONTAINER_TYPE_EDEFAULT.equals(containerType);
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__PERMITTED:
				return permitted != PERMITTED_EDEFAULT;
			case InvariantContainerRuleConfigurationPackage.HIERARCHY_PERMISSION__STRICT:
				return strict != STRICT_EDEFAULT;
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
		result.append(" (containerType: ");
		result.append(containerType);
		result.append(", permitted: ");
		result.append(permitted);
		result.append(", strict: ");
		result.append(strict);
		result.append(')');
		return result.toString();
	}

} //HierarchyPermissionImpl
