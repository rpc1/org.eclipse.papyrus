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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ElementtypesconfigurationsPackageImpl extends EPackageImpl implements ElementtypesconfigurationsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementTypeSetConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iconEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matcherConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adviceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass adviceBindingConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelTypeConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass editHelperAdviceConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum inheritanceKindEEnum = null;

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
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ElementtypesconfigurationsPackageImpl() {
		super(eNS_URI, ElementtypesconfigurationsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ElementtypesconfigurationsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ElementtypesconfigurationsPackage init() {
		if (isInited) return (ElementtypesconfigurationsPackage)EPackage.Registry.INSTANCE.getEPackage(ElementtypesconfigurationsPackage.eNS_URI);

		// Obtain or create and register package
		ElementtypesconfigurationsPackageImpl theElementtypesconfigurationsPackage = (ElementtypesconfigurationsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ElementtypesconfigurationsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ElementtypesconfigurationsPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theElementtypesconfigurationsPackage.createPackageContents();

		// Initialize created meta-data
		theElementtypesconfigurationsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theElementtypesconfigurationsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ElementtypesconfigurationsPackage.eNS_URI, theElementtypesconfigurationsPackage);
		return theElementtypesconfigurationsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementTypeSetConfiguration() {
		return elementTypeSetConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementTypeSetConfiguration_ElementTypeConfigurations() {
		return (EReference)elementTypeSetConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementTypeSetConfiguration_AdviceBindingsConfigurations() {
		return (EReference)elementTypeSetConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementTypeSetConfiguration_MetamodelNsURI() {
		return (EAttribute)elementTypeSetConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementTypeConfiguration() {
		return elementTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementTypeConfiguration_Hint() {
		return (EAttribute)elementTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementTypeConfiguration_Kind() {
		return (EAttribute)elementTypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementTypeConfiguration_IconEntry() {
		return (EReference)elementTypeConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIconEntry() {
		return iconEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconEntry_IconPath() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIconEntry_BundleId() {
		return (EAttribute)iconEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationElement() {
		return configurationElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationElement_Name() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationElement_Description() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationElement_Identifier() {
		return (EAttribute)configurationElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatcherConfiguration() {
		return matcherConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatcherConfiguration_MatcherClassName() {
		return (EAttribute)matcherConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdviceConfiguration() {
		return adviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdviceConfiguration_EditHelperAdviceClassName() {
		return (EAttribute)adviceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdviceConfiguration_Before() {
		return (EAttribute)adviceConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdviceConfiguration_After() {
		return (EAttribute)adviceConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdviceConfiguration_Inheritance() {
		return (EAttribute)adviceConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdviceBindingConfiguration() {
		return adviceBindingConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdviceBindingConfiguration_Target() {
		return (EReference)adviceBindingConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdviceBindingConfiguration_ContainerConfiguration() {
		return (EReference)adviceBindingConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdviceBindingConfiguration_MatcherConfiguration() {
		return (EReference)adviceBindingConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecializationTypeConfiguration() {
		return specializationTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecializationTypeConfiguration_SpecializedTypesID() {
		return (EAttribute)specializationTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationTypeConfiguration_EditHelperAdviceConfiguration() {
		return (EReference)specializationTypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationTypeConfiguration_ContainerConfiguration() {
		return (EReference)specializationTypeConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationTypeConfiguration_MatcherConfiguration() {
		return (EReference)specializationTypeConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerConfiguration() {
		return containerConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerConfiguration_ContainerMatcherConfiguration() {
		return (EReference)containerConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerConfiguration_EContainmentFeatures() {
		return (EReference)containerConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelTypeConfiguration() {
		return metamodelTypeConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetamodelTypeConfiguration_EClass() {
		return (EReference)metamodelTypeConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodelTypeConfiguration_EditHelperClassName() {
		return (EAttribute)metamodelTypeConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEditHelperAdviceConfiguration() {
		return editHelperAdviceConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEditHelperAdviceConfiguration_Target() {
		return (EReference)editHelperAdviceConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInheritanceKind() {
		return inheritanceKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementtypesconfigurationsFactory getElementtypesconfigurationsFactory() {
		return (ElementtypesconfigurationsFactory)getEFactoryInstance();
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
		elementTypeSetConfigurationEClass = createEClass(ELEMENT_TYPE_SET_CONFIGURATION);
		createEReference(elementTypeSetConfigurationEClass, ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS);
		createEReference(elementTypeSetConfigurationEClass, ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS);
		createEAttribute(elementTypeSetConfigurationEClass, ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI);

		elementTypeConfigurationEClass = createEClass(ELEMENT_TYPE_CONFIGURATION);
		createEAttribute(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__HINT);
		createEAttribute(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__KIND);
		createEReference(elementTypeConfigurationEClass, ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY);

		iconEntryEClass = createEClass(ICON_ENTRY);
		createEAttribute(iconEntryEClass, ICON_ENTRY__ICON_PATH);
		createEAttribute(iconEntryEClass, ICON_ENTRY__BUNDLE_ID);

		configurationElementEClass = createEClass(CONFIGURATION_ELEMENT);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__NAME);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__DESCRIPTION);
		createEAttribute(configurationElementEClass, CONFIGURATION_ELEMENT__IDENTIFIER);

		matcherConfigurationEClass = createEClass(MATCHER_CONFIGURATION);
		createEAttribute(matcherConfigurationEClass, MATCHER_CONFIGURATION__MATCHER_CLASS_NAME);

		adviceConfigurationEClass = createEClass(ADVICE_CONFIGURATION);
		createEAttribute(adviceConfigurationEClass, ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME);
		createEAttribute(adviceConfigurationEClass, ADVICE_CONFIGURATION__BEFORE);
		createEAttribute(adviceConfigurationEClass, ADVICE_CONFIGURATION__AFTER);
		createEAttribute(adviceConfigurationEClass, ADVICE_CONFIGURATION__INHERITANCE);

		adviceBindingConfigurationEClass = createEClass(ADVICE_BINDING_CONFIGURATION);
		createEReference(adviceBindingConfigurationEClass, ADVICE_BINDING_CONFIGURATION__TARGET);
		createEReference(adviceBindingConfigurationEClass, ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION);
		createEReference(adviceBindingConfigurationEClass, ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION);

		specializationTypeConfigurationEClass = createEClass(SPECIALIZATION_TYPE_CONFIGURATION);
		createEAttribute(specializationTypeConfigurationEClass, SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID);
		createEReference(specializationTypeConfigurationEClass, SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION);
		createEReference(specializationTypeConfigurationEClass, SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION);
		createEReference(specializationTypeConfigurationEClass, SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION);

		containerConfigurationEClass = createEClass(CONTAINER_CONFIGURATION);
		createEReference(containerConfigurationEClass, CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION);
		createEReference(containerConfigurationEClass, CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES);

		metamodelTypeConfigurationEClass = createEClass(METAMODEL_TYPE_CONFIGURATION);
		createEReference(metamodelTypeConfigurationEClass, METAMODEL_TYPE_CONFIGURATION__ECLASS);
		createEAttribute(metamodelTypeConfigurationEClass, METAMODEL_TYPE_CONFIGURATION__EDIT_HELPER_CLASS_NAME);

		editHelperAdviceConfigurationEClass = createEClass(EDIT_HELPER_ADVICE_CONFIGURATION);
		createEReference(editHelperAdviceConfigurationEClass, EDIT_HELPER_ADVICE_CONFIGURATION__TARGET);

		// Create enums
		inheritanceKindEEnum = createEEnum(INHERITANCE_KIND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		elementTypeSetConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		elementTypeConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		adviceConfigurationEClass.getESuperTypes().add(this.getConfigurationElement());
		adviceBindingConfigurationEClass.getESuperTypes().add(this.getAdviceConfiguration());
		specializationTypeConfigurationEClass.getESuperTypes().add(this.getElementTypeConfiguration());
		metamodelTypeConfigurationEClass.getESuperTypes().add(this.getElementTypeConfiguration());
		editHelperAdviceConfigurationEClass.getESuperTypes().add(this.getAdviceConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementTypeSetConfigurationEClass, ElementTypeSetConfiguration.class, "ElementTypeSetConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTypeSetConfiguration_ElementTypeConfigurations(), this.getElementTypeConfiguration(), null, "elementTypeConfigurations", null, 0, -1, ElementTypeSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeSetConfiguration_AdviceBindingsConfigurations(), this.getAdviceBindingConfiguration(), null, "adviceBindingsConfigurations", null, 0, -1, ElementTypeSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementTypeSetConfiguration_MetamodelNsURI(), ecorePackage.getEString(), "metamodelNsURI", null, 1, 1, ElementTypeSetConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTypeConfigurationEClass, ElementTypeConfiguration.class, "ElementTypeConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementTypeConfiguration_Hint(), ecorePackage.getEString(), "hint", "", 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementTypeConfiguration_Kind(), ecorePackage.getEString(), "kind", "org.eclipse.gmf.runtime.emf.type.core.IHintedType", 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTypeConfiguration_IconEntry(), this.getIconEntry(), null, "iconEntry", null, 0, 1, ElementTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iconEntryEClass, IconEntry.class, "IconEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIconEntry_IconPath(), ecorePackage.getEString(), "iconPath", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIconEntry_BundleId(), ecorePackage.getEString(), "bundleId", null, 0, 1, IconEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationElementEClass, ConfigurationElement.class, "ConfigurationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationElement_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1, ConfigurationElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matcherConfigurationEClass, MatcherConfiguration.class, "MatcherConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatcherConfiguration_MatcherClassName(), ecorePackage.getEString(), "matcherClassName", null, 1, 1, MatcherConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceConfigurationEClass, AdviceConfiguration.class, "AdviceConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdviceConfiguration_EditHelperAdviceClassName(), ecorePackage.getEString(), "editHelperAdviceClassName", null, 1, 1, AdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceConfiguration_Before(), ecorePackage.getEString(), "before", null, 0, -1, AdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceConfiguration_After(), ecorePackage.getEString(), "after", null, 0, -1, AdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdviceConfiguration_Inheritance(), this.getInheritanceKind(), "inheritance", null, 1, 1, AdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(adviceBindingConfigurationEClass, AdviceBindingConfiguration.class, "AdviceBindingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdviceBindingConfiguration_Target(), this.getElementTypeConfiguration(), null, "target", null, 1, 1, AdviceBindingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdviceBindingConfiguration_ContainerConfiguration(), this.getContainerConfiguration(), null, "containerConfiguration", null, 0, 1, AdviceBindingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdviceBindingConfiguration_MatcherConfiguration(), this.getMatcherConfiguration(), null, "matcherConfiguration", null, 0, 1, AdviceBindingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationTypeConfigurationEClass, SpecializationTypeConfiguration.class, "SpecializationTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecializationTypeConfiguration_SpecializedTypesID(), ecorePackage.getEString(), "specializedTypesID", null, 1, -1, SpecializationTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationTypeConfiguration_EditHelperAdviceConfiguration(), this.getEditHelperAdviceConfiguration(), this.getEditHelperAdviceConfiguration_Target(), "editHelperAdviceConfiguration", null, 0, 1, SpecializationTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationTypeConfiguration_ContainerConfiguration(), this.getContainerConfiguration(), null, "containerConfiguration", null, 0, 1, SpecializationTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationTypeConfiguration_MatcherConfiguration(), this.getMatcherConfiguration(), null, "matcherConfiguration", null, 0, 1, SpecializationTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerConfigurationEClass, ContainerConfiguration.class, "ContainerConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerConfiguration_ContainerMatcherConfiguration(), this.getMatcherConfiguration(), null, "containerMatcherConfiguration", null, 0, 1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainerConfiguration_EContainmentFeatures(), ecorePackage.getEReference(), null, "eContainmentFeatures", null, 0, -1, ContainerConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metamodelTypeConfigurationEClass, MetamodelTypeConfiguration.class, "MetamodelTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetamodelTypeConfiguration_EClass(), ecorePackage.getEClass(), null, "eClass", null, 0, 1, MetamodelTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetamodelTypeConfiguration_EditHelperClassName(), ecorePackage.getEString(), "editHelperClassName", null, 0, 1, MetamodelTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(editHelperAdviceConfigurationEClass, EditHelperAdviceConfiguration.class, "EditHelperAdviceConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEditHelperAdviceConfiguration_Target(), this.getSpecializationTypeConfiguration(), this.getSpecializationTypeConfiguration_EditHelperAdviceConfiguration(), "target", null, 1, 1, EditHelperAdviceConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(inheritanceKindEEnum, InheritanceKind.class, "InheritanceKind");
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.NONE);
		addEEnumLiteral(inheritanceKindEEnum, InheritanceKind.ALL);

		// Create resource
		createResource(eNS_URI);
	}

} //ElementtypesconfigurationsPackageImpl
