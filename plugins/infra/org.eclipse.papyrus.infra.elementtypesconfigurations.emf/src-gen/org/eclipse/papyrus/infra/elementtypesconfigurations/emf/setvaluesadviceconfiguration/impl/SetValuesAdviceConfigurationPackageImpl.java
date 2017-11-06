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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.ConstantValue;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.DynamicValue;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.FeatureToSet;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.FeatureValue;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.ListValue;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.SetValuesAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.SetValuesAdviceConfigurationFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.SetValuesAdviceConfigurationPackage;

import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SetValuesAdviceConfigurationPackageImpl extends EPackageImpl implements SetValuesAdviceConfigurationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setValuesAdviceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureToSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dynamicValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryExecutionValueEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.setvaluesadviceconfiguration.SetValuesAdviceConfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SetValuesAdviceConfigurationPackageImpl() {
		super(eNS_URI, SetValuesAdviceConfigurationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SetValuesAdviceConfigurationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SetValuesAdviceConfigurationPackage init() {
		if (isInited) return (SetValuesAdviceConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(SetValuesAdviceConfigurationPackage.eNS_URI);

		// Obtain or create and register package
		SetValuesAdviceConfigurationPackageImpl theSetValuesAdviceConfigurationPackage = (SetValuesAdviceConfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SetValuesAdviceConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SetValuesAdviceConfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ElementtypesconfigurationsPackage.eINSTANCE.eClass();
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSetValuesAdviceConfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theSetValuesAdviceConfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSetValuesAdviceConfigurationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SetValuesAdviceConfigurationPackage.eNS_URI, theSetValuesAdviceConfigurationPackage);
		return theSetValuesAdviceConfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetValuesAdviceConfiguration() {
		return setValuesAdviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSetValuesAdviceConfiguration_FeaturesToSet() {
		return (EReference)setValuesAdviceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureToSet() {
		return featureToSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureToSet_FeatureName() {
		return (EAttribute)featureToSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureToSet_Value() {
		return (EReference)featureToSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureValue() {
		return featureValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDynamicValue() {
		return dynamicValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantValue() {
		return constantValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstantValue_ValueInstance() {
		return (EReference)constantValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListValue() {
		return listValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListValue_Values() {
		return (EReference)listValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryExecutionValue() {
		return queryExecutionValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetValuesAdviceConfigurationFactory getSetValuesAdviceConfigurationFactory() {
		return (SetValuesAdviceConfigurationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		setValuesAdviceConfigurationEClass = createEClass(SET_VALUES_ADVICE_CONFIGURATION);
		createEReference(setValuesAdviceConfigurationEClass, SET_VALUES_ADVICE_CONFIGURATION__FEATURES_TO_SET);

		featureToSetEClass = createEClass(FEATURE_TO_SET);
		createEAttribute(featureToSetEClass, FEATURE_TO_SET__FEATURE_NAME);
		createEReference(featureToSetEClass, FEATURE_TO_SET__VALUE);

		featureValueEClass = createEClass(FEATURE_VALUE);

		dynamicValueEClass = createEClass(DYNAMIC_VALUE);

		constantValueEClass = createEClass(CONSTANT_VALUE);
		createEReference(constantValueEClass, CONSTANT_VALUE__VALUE_INSTANCE);

		listValueEClass = createEClass(LIST_VALUE);
		createEReference(listValueEClass, LIST_VALUE__VALUES);

		queryExecutionValueEClass = createEClass(QUERY_EXECUTION_VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ElementtypesconfigurationsPackage theElementtypesconfigurationsPackage = (ElementtypesconfigurationsPackage)EPackage.Registry.INSTANCE.getEPackage(ElementtypesconfigurationsPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		setValuesAdviceConfigurationEClass.getESuperTypes().add(theElementtypesconfigurationsPackage.getAdviceBindingConfiguration());
		dynamicValueEClass.getESuperTypes().add(this.getFeatureValue());
		constantValueEClass.getESuperTypes().add(this.getFeatureValue());
		listValueEClass.getESuperTypes().add(this.getFeatureValue());
		queryExecutionValueEClass.getESuperTypes().add(this.getDynamicValue());

		// Initialize classes and features; add operations and parameters
		initEClass(setValuesAdviceConfigurationEClass, SetValuesAdviceConfiguration.class, "SetValuesAdviceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetValuesAdviceConfiguration_FeaturesToSet(), this.getFeatureToSet(), null, "featuresToSet", null, 0, -1, SetValuesAdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureToSetEClass, FeatureToSet.class, "FeatureToSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeatureToSet_FeatureName(), theEcorePackage.getEString(), "featureName", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureToSet_Value(), this.getFeatureValue(), null, "value", null, 1, 1, FeatureToSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureValueEClass, FeatureValue.class, "FeatureValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dynamicValueEClass, DynamicValue.class, "DynamicValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantValue_ValueInstance(), theUMLPackage.getValueSpecification(), null, "valueInstance", null, 0, 1, ConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listValueEClass, ListValue.class, "ListValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListValue_Values(), this.getFeatureValue(), null, "values", null, 0, -1, ListValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryExecutionValueEClass, QueryExecutionValue.class, "QueryExecutionValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SetValuesAdviceConfigurationPackageImpl
