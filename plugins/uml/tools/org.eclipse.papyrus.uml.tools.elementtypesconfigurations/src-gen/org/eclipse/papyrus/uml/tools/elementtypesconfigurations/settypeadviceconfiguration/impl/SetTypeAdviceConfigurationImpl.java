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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfigurationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Type Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl#getValidTypes <em>Valid Types</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl#getCreationTypes <em>Creation Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetTypeAdviceConfigurationImpl extends AdviceBindingConfigurationImpl implements SetTypeAdviceConfiguration {
	/**
	 * The cached value of the '{@link #getValidTypes() <em>Valid Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> validTypes;

	/**
	 * The cached value of the '{@link #getCreationTypes() <em>Creation Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<String> creationTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetTypeAdviceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SetTypeAdviceConfigurationPackage.Literals.SET_TYPE_ADVICE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getValidTypes() {
		if (validTypes == null) {
			validTypes = new EDataTypeUniqueEList<String>(String.class, this, SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES);
		}
		return validTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCreationTypes() {
		if (creationTypes == null) {
			creationTypes = new EDataTypeUniqueEList<String>(String.class, this, SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES);
		}
		return creationTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES:
				return getValidTypes();
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES:
				return getCreationTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES:
				getValidTypes().clear();
				getValidTypes().addAll((Collection<? extends String>)newValue);
				return;
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES:
				getCreationTypes().clear();
				getCreationTypes().addAll((Collection<? extends String>)newValue);
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
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES:
				getValidTypes().clear();
				return;
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES:
				getCreationTypes().clear();
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
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES:
				return validTypes != null && !validTypes.isEmpty();
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES:
				return creationTypes != null && !creationTypes.isEmpty();
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
		result.append(" (validTypes: ");
		result.append(validTypes);
		result.append(", creationTypes: ");
		result.append(creationTypes);
		result.append(')');
		return result.toString();
	}

} //SetTypeAdviceConfigurationImpl
