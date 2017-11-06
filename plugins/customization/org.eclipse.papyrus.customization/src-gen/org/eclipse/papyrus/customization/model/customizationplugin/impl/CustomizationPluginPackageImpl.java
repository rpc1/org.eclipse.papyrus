/**
 */
package org.eclipse.papyrus.customization.model.customizationplugin.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.customization.model.customizationplugin.ConstraintsEnvironment;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginFactory;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate;
import org.eclipse.papyrus.customization.model.customizationplugin.Palette;
import org.eclipse.papyrus.customization.model.customizationplugin.Profile;
import org.eclipse.papyrus.customization.model.customizationplugin.PropertyView;
import org.eclipse.papyrus.customization.model.customizationplugin.PropertyViewEnvironment;
import org.eclipse.papyrus.customization.model.customizationplugin.UICustom;
import org.eclipse.papyrus.customization.model.customizationplugin.UMLModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CustomizationPluginPackageImpl extends EPackageImpl implements CustomizationPluginPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass customizationConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass customizableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass fileBasedCustomizableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass propertyViewEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass uiCustomEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass modelTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass paletteEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass profileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass umlModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass constraintsEnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass propertyViewEnvironmentEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CustomizationPluginPackageImpl() {
		super(eNS_URI, CustomizationPluginFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link CustomizationPluginPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CustomizationPluginPackage init() {
		if (isInited) {
			return (CustomizationPluginPackage) EPackage.Registry.INSTANCE.getEPackage(CustomizationPluginPackage.eNS_URI);
		}

		// Obtain or create and register package
		CustomizationPluginPackageImpl theCustomizationPluginPackage = (CustomizationPluginPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CustomizationPluginPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
				: new CustomizationPluginPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCustomizationPluginPackage.createPackageContents();

		// Initialize created meta-data
		theCustomizationPluginPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCustomizationPluginPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CustomizationPluginPackage.eNS_URI, theCustomizationPluginPackage);
		return theCustomizationPluginPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getCustomizationConfiguration() {
		return customizationConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getCustomizationConfiguration_Plugin() {
		return (EAttribute) customizationConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EReference getCustomizationConfiguration_Elements() {
		return (EReference) customizationConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getCustomizableElement() {
		return customizableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getFileBasedCustomizableElement() {
		return fileBasedCustomizableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getFileBasedCustomizableElement_File() {
		return (EAttribute) fileBasedCustomizableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getPropertyView() {
		return propertyViewEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getUICustom() {
		return uiCustomEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUICustom_LoadByDefault() {
		return (EAttribute) uiCustomEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getModelTemplate() {
		return modelTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getModelTemplate_Language() {
		return (EAttribute) modelTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getModelTemplate_Name() {
		return (EAttribute) modelTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getModelTemplate_Id() {
		return (EAttribute) modelTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getPalette() {
		return paletteEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getProfile() {
		return profileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getProfile_Qualifiednames() {
		return (EAttribute) profileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getProfile_Iconpath() {
		return (EAttribute) profileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getProfile_Description() {
		return (EAttribute) profileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getProfile_Provider() {
		return (EAttribute) profileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getProfile_Name() {
		return (EAttribute) profileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getUMLModel() {
		return umlModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUMLModel_Name() {
		return (EAttribute) umlModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUMLModel_Iconpath() {
		return (EAttribute) umlModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUMLModel_Description() {
		return (EAttribute) umlModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EAttribute getUMLModel_Provider() {
		return (EAttribute) umlModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getConstraintsEnvironment() {
		return constraintsEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EClass getPropertyViewEnvironment() {
		return propertyViewEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CustomizationPluginFactory getCustomizationPluginFactory() {
		return (CustomizationPluginFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		customizationConfigurationEClass = createEClass(CUSTOMIZATION_CONFIGURATION);
		createEAttribute(customizationConfigurationEClass, CUSTOMIZATION_CONFIGURATION__PLUGIN);
		createEReference(customizationConfigurationEClass, CUSTOMIZATION_CONFIGURATION__ELEMENTS);

		customizableElementEClass = createEClass(CUSTOMIZABLE_ELEMENT);

		fileBasedCustomizableElementEClass = createEClass(FILE_BASED_CUSTOMIZABLE_ELEMENT);
		createEAttribute(fileBasedCustomizableElementEClass, FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE);

		propertyViewEClass = createEClass(PROPERTY_VIEW);

		uiCustomEClass = createEClass(UI_CUSTOM);
		createEAttribute(uiCustomEClass, UI_CUSTOM__LOAD_BY_DEFAULT);

		modelTemplateEClass = createEClass(MODEL_TEMPLATE);
		createEAttribute(modelTemplateEClass, MODEL_TEMPLATE__LANGUAGE);
		createEAttribute(modelTemplateEClass, MODEL_TEMPLATE__NAME);
		createEAttribute(modelTemplateEClass, MODEL_TEMPLATE__ID);

		paletteEClass = createEClass(PALETTE);

		profileEClass = createEClass(PROFILE);
		createEAttribute(profileEClass, PROFILE__QUALIFIEDNAMES);
		createEAttribute(profileEClass, PROFILE__ICONPATH);
		createEAttribute(profileEClass, PROFILE__DESCRIPTION);
		createEAttribute(profileEClass, PROFILE__PROVIDER);
		createEAttribute(profileEClass, PROFILE__NAME);

		umlModelEClass = createEClass(UML_MODEL);
		createEAttribute(umlModelEClass, UML_MODEL__NAME);
		createEAttribute(umlModelEClass, UML_MODEL__ICONPATH);
		createEAttribute(umlModelEClass, UML_MODEL__DESCRIPTION);
		createEAttribute(umlModelEClass, UML_MODEL__PROVIDER);

		constraintsEnvironmentEClass = createEClass(CONSTRAINTS_ENVIRONMENT);

		propertyViewEnvironmentEClass = createEClass(PROPERTY_VIEW_ENVIRONMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fileBasedCustomizableElementEClass.getESuperTypes().add(this.getCustomizableElement());
		propertyViewEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		uiCustomEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		modelTemplateEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		paletteEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		profileEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		umlModelEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		constraintsEnvironmentEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());
		propertyViewEnvironmentEClass.getESuperTypes().add(this.getFileBasedCustomizableElement());

		// Initialize classes and features; add operations and parameters
		initEClass(customizationConfigurationEClass, CustomizationConfiguration.class, "CustomizationConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomizationConfiguration_Plugin(), ecorePackage.getEString(), "plugin", null, 1, 1, CustomizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCustomizationConfiguration_Elements(), this.getCustomizableElement(), null, "elements", null, 0, -1, CustomizationConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customizableElementEClass, CustomizableElement.class, "CustomizableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fileBasedCustomizableElementEClass, FileBasedCustomizableElement.class, "FileBasedCustomizableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFileBasedCustomizableElement_File(), ecorePackage.getEString(), "file", null, 1, 1, FileBasedCustomizableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyViewEClass, PropertyView.class, "PropertyView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uiCustomEClass, UICustom.class, "UICustom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUICustom_LoadByDefault(), ecorePackage.getEBoolean(), "loadByDefault", "false", 0, 1, UICustom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTemplateEClass, ModelTemplate.class, "ModelTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelTemplate_Language(), ecorePackage.getEString(), "language", null, 0, 1, ModelTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelTemplate_Name(), ecorePackage.getEString(), "name", null, 0, 1, ModelTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelTemplate_Id(), ecorePackage.getEString(), "id", null, 1, 1, ModelTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paletteEClass, Palette.class, "Palette", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProfile_Qualifiednames(), ecorePackage.getEString(), "qualifiednames", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Iconpath(), ecorePackage.getEString(), "iconpath", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Description(), ecorePackage.getEString(), "description", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProfile_Name(), ecorePackage.getEString(), "name", null, 1, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlModelEClass, UMLModel.class, "UMLModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLModel_Iconpath(), ecorePackage.getEString(), "iconpath", null, 0, 1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLModel_Provider(), ecorePackage.getEString(), "provider", null, 0, 1, UMLModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintsEnvironmentEClass, ConstraintsEnvironment.class, "ConstraintsEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyViewEnvironmentEClass, PropertyViewEnvironment.class, "PropertyViewEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} // CustomizationPluginPackageImpl
