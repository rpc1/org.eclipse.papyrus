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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ListValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ApplyStereotypeActionConfigurationFactoryImpl extends EFactoryImpl implements ApplyStereotypeActionConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static ApplyStereotypeActionConfigurationFactory init() {
		try {
			ApplyStereotypeActionConfigurationFactory theApplyStereotypeActionConfigurationFactory = (ApplyStereotypeActionConfigurationFactory) EPackage.Registry.INSTANCE.getEFactory(ApplyStereotypeActionConfigurationPackage.eNS_URI);
			if (theApplyStereotypeActionConfigurationFactory != null) {
				return theApplyStereotypeActionConfigurationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ApplyStereotypeActionConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION:
			return createApplyStereotypeActionConfiguration();
		case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY:
			return createStereotypeToApply();
		case ApplyStereotypeActionConfigurationPackage.FEATURE_TO_SET:
			return createFeatureToSet();
		case ApplyStereotypeActionConfigurationPackage.LIST_VALUE:
			return createListValue();
		case ApplyStereotypeActionConfigurationPackage.CONSTANT_VALUE:
			return createConstantValue();
		case ApplyStereotypeActionConfigurationPackage.QUERY_EXECUTION_VALUE:
			return createQueryExecutionValue();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ApplyStereotypeActionConfiguration createApplyStereotypeActionConfiguration() {
		ApplyStereotypeActionConfigurationImpl applyStereotypeActionConfiguration = new ApplyStereotypeActionConfigurationImpl();
		return applyStereotypeActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public StereotypeToApply createStereotypeToApply() {
		StereotypeToApplyImpl stereotypeToApply = new StereotypeToApplyImpl();
		return stereotypeToApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public FeatureToSet createFeatureToSet() {
		FeatureToSetImpl featureToSet = new FeatureToSetImpl();
		return featureToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ListValue createListValue() {
		ListValueImpl listValue = new ListValueImpl();
		return listValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConstantValue createConstantValue() {
		ConstantValueImpl constantValue = new ConstantValueImpl();
		return constantValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public QueryExecutionValue createQueryExecutionValue() {
		QueryExecutionValueImpl queryExecutionValue = new QueryExecutionValueImpl();
		return queryExecutionValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationPackage getApplyStereotypeActionConfigurationPackage() {
		return (ApplyStereotypeActionConfigurationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ApplyStereotypeActionConfigurationPackage getPackage() {
		return ApplyStereotypeActionConfigurationPackage.eINSTANCE;
	}

} // ApplyStereotypeActionConfigurationFactoryImpl
