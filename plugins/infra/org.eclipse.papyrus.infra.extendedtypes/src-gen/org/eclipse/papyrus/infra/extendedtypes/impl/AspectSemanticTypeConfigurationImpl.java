/**
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
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.extendedtypes.AspectSemanticTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect Semantic Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.AspectSemanticTypeConfigurationImpl#getActionConfiguration <em>Action Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AspectSemanticTypeConfigurationImpl extends SemanticTypeConfigurationImpl implements AspectSemanticTypeConfiguration {

	/**
	 * The cached value of the '{@link #getActionConfiguration() <em>Action Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getActionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticActionConfiguration> actionConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AspectSemanticTypeConfigurationImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getAspectSemanticTypeConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<SemanticActionConfiguration> getActionConfiguration() {
		if (actionConfiguration == null) {
			actionConfiguration = new EObjectContainmentEList<SemanticActionConfiguration>(SemanticActionConfiguration.class, this, ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION);
		}
		return actionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION:
			return ((InternalEList<?>) getActionConfiguration()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION:
			return getActionConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION:
			getActionConfiguration().clear();
			getActionConfiguration().addAll((Collection<? extends SemanticActionConfiguration>) newValue);
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
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION:
			getActionConfiguration().clear();
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
		case ExtendedtypesPackage.ASPECT_SEMANTIC_TYPE_CONFIGURATION__ACTION_CONFIGURATION:
			return actionConfiguration != null && !actionConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}
} // AspectSemanticTypeConfigurationImpl
