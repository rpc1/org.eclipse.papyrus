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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetTypeAdviceConfigurationFactoryImpl extends EFactoryImpl implements SetTypeAdviceConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SetTypeAdviceConfigurationFactory init() {
		try {
			SetTypeAdviceConfigurationFactory theSetTypeAdviceConfigurationFactory = (SetTypeAdviceConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(SetTypeAdviceConfigurationPackage.eNS_URI);
			if (theSetTypeAdviceConfigurationFactory != null) {
				return theSetTypeAdviceConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SetTypeAdviceConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeAdviceConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SetTypeAdviceConfigurationPackage.SET_TYPE_ADVICE_CONFIGURATION: return createSetTypeAdviceConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeAdviceConfiguration createSetTypeAdviceConfiguration() {
		SetTypeAdviceConfigurationImpl setTypeAdviceConfiguration = new SetTypeAdviceConfigurationImpl();
		return setTypeAdviceConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeAdviceConfigurationPackage getSetTypeAdviceConfigurationPackage() {
		return (SetTypeAdviceConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SetTypeAdviceConfigurationPackage getPackage() {
		return SetTypeAdviceConfigurationPackage.eINSTANCE;
	}

} //SetTypeAdviceConfigurationFactoryImpl
