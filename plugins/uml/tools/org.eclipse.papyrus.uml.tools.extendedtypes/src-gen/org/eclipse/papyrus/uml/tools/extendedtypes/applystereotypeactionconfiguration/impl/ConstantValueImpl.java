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
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.ConstantValueImpl#getValueInstance <em>Value Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantValueImpl extends FeatureValueImpl implements ConstantValue {
	/**
	 * The cached value of the '{@link #getValueInstance() <em>Value Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getValueInstance()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification valueInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ConstantValueImpl() {
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
		return ApplyStereotypeActionConfigurationPackage.Literals.CONSTANT_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ValueSpecification getValueInstance() {
		return valueInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetValueInstance(ValueSpecification newValueInstance, NotificationChain msgs) {
		ValueSpecification oldValueInstance = valueInstance;
		valueInstance = newValueInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE, oldValueInstance, newValueInstance);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setValueInstance(ValueSpecification newValueInstance) {
		if (newValueInstance != valueInstance) {
			NotificationChain msgs = null;
			if (valueInstance != null) {
				msgs = ((InternalEObject) valueInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE, null, msgs);
			}
			if (newValueInstance != null) {
				msgs = ((InternalEObject) newValueInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE, null, msgs);
			}
			msgs = basicSetValueInstance(newValueInstance, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE, newValueInstance, newValueInstance));
		}
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
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE:
			return basicSetValueInstance(null, msgs);
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
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE:
			return getValueInstance();
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
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE:
			setValueInstance((ValueSpecification) newValue);
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
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE:
			setValueInstance((ValueSpecification) null);
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
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE__VALUE_INSTANCE:
			return valueInstance != null;
		}
		return super.eIsSet(featureID);
	}

} // ConstantValueImpl
