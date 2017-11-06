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
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl#getContainerMatcherConfiguration <em>Container Matcher Configuration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl#getEContainmentFeatures <em>EContainment Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContainerConfigurationImpl extends MinimalEObjectImpl.Container implements ContainerConfiguration {
	/**
	 * The cached value of the '{@link #getContainerMatcherConfiguration() <em>Container Matcher Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerMatcherConfiguration()
	 * @generated
	 * @ordered
	 */
	protected MatcherConfiguration containerMatcherConfiguration;

	/**
	 * The cached value of the '{@link #getEContainmentFeatures() <em>EContainment Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainmentFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> eContainmentFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContainerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementtypesconfigurationsPackage.Literals.CONTAINER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatcherConfiguration getContainerMatcherConfiguration() {
		return containerMatcherConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainerMatcherConfiguration(MatcherConfiguration newContainerMatcherConfiguration, NotificationChain msgs) {
		MatcherConfiguration oldContainerMatcherConfiguration = containerMatcherConfiguration;
		containerMatcherConfiguration = newContainerMatcherConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION, oldContainerMatcherConfiguration, newContainerMatcherConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerMatcherConfiguration(MatcherConfiguration newContainerMatcherConfiguration) {
		if (newContainerMatcherConfiguration != containerMatcherConfiguration) {
			NotificationChain msgs = null;
			if (containerMatcherConfiguration != null)
				msgs = ((InternalEObject)containerMatcherConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION, null, msgs);
			if (newContainerMatcherConfiguration != null)
				msgs = ((InternalEObject)newContainerMatcherConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION, null, msgs);
			msgs = basicSetContainerMatcherConfiguration(newContainerMatcherConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION, newContainerMatcherConfiguration, newContainerMatcherConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getEContainmentFeatures() {
		if (eContainmentFeatures == null) {
			eContainmentFeatures = new EObjectResolvingEList<EReference>(EReference.class, this, ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES);
		}
		return eContainmentFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION:
				return basicSetContainerMatcherConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION:
				return getContainerMatcherConfiguration();
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES:
				return getEContainmentFeatures();
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
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION:
				setContainerMatcherConfiguration((MatcherConfiguration)newValue);
				return;
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES:
				getEContainmentFeatures().clear();
				getEContainmentFeatures().addAll((Collection<? extends EReference>)newValue);
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
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION:
				setContainerMatcherConfiguration((MatcherConfiguration)null);
				return;
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES:
				getEContainmentFeatures().clear();
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
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION:
				return containerMatcherConfiguration != null;
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES:
				return eContainmentFeatures != null && !eContainmentFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ContainerConfigurationImpl
