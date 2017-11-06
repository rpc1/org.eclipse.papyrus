/**
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 *
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.FCM.Assembly;
import org.eclipse.papyrus.FCM.AutoIndex;
import org.eclipse.papyrus.FCM.AutoIndexPerNode;
import org.eclipse.papyrus.FCM.BindTemplate;
import org.eclipse.papyrus.FCM.BindingHelper;
import org.eclipse.papyrus.FCM.CodeGenOptions;
import org.eclipse.papyrus.FCM.CompImplTemplate;
import org.eclipse.papyrus.FCM.CompToOOmapping;
import org.eclipse.papyrus.FCM.CompilerChain;
import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.ConnectorConfiguration;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.ContainerRuleKind;
import org.eclipse.papyrus.FCM.CopyAttributeValue;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.FCM.FCMFactory;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.Flatten;
import org.eclipse.papyrus.FCM.Fragment;
import org.eclipse.papyrus.FCM.ImplementationGroup;
import org.eclipse.papyrus.FCM.ImplementationProperties;
import org.eclipse.papyrus.FCM.InitPrecedence;
import org.eclipse.papyrus.FCM.InstanceConfigurator;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.InterceptionKind;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.FCM.OperatingSystem;
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.FCM.ProgLanguage;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.FCM.Singleton;
import org.eclipse.papyrus.FCM.Target;
import org.eclipse.papyrus.FCM.TargetArchitecture;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.FCM.TemplatePort;
import org.eclipse.papyrus.FCM.UseInstanceConfigurator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class FCMFactoryImpl extends EFactoryImpl implements FCMFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static FCMFactory init() {
		try {
			FCMFactory theFCMFactory = (FCMFactory) EPackage.Registry.INSTANCE.getEFactory(FCMPackage.eNS_URI);
			if (theFCMFactory != null) {
				return theFCMFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FCMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public FCMFactoryImpl() {
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
		case FCMPackage.TEMPLATE:
			return createTemplate();
		case FCMPackage.BINDING_HELPER:
			return createBindingHelper();
		case FCMPackage.CONFIGURATION_PROPERTY:
			return createConfigurationProperty();
		case FCMPackage.IMPLEMENTATION_GROUP:
			return createImplementationGroup();
		case FCMPackage.ASSEMBLY:
			return createAssembly();
		case FCMPackage.FLATTEN:
			return createFlatten();
		case FCMPackage.COMP_TO_OOMAPPING:
			return createCompToOOmapping();
		case FCMPackage.PROG_LANGUAGE:
			return createProgLanguage();
		case FCMPackage.CODE_GEN_OPTIONS:
			return createCodeGenOptions();
		case FCMPackage.INTERACTION_COMPONENT:
			return createInteractionComponent();
		case FCMPackage.SINGLETON:
			return createSingleton();
		case FCMPackage.CONNECTOR:
			return createConnector();
		case FCMPackage.USE_INSTANCE_CONFIGURATOR:
			return createUseInstanceConfigurator();
		case FCMPackage.INSTANCE_CONFIGURATOR:
			return createInstanceConfigurator();
		case FCMPackage.RULE_APPLICATION:
			return createRuleApplication();
		case FCMPackage.CONTAINER_RULE:
			return createContainerRule();
		case FCMPackage.CONFIG_OPTION:
			return createConfigOption();
		case FCMPackage.TEMPLATE_PORT:
			return createTemplatePort();
		case FCMPackage.PORT:
			return createPort();
		case FCMPackage.PORT_KIND:
			return createPortKind();
		case FCMPackage.DEPLOYMENT_PLAN:
			return createDeploymentPlan();
		case FCMPackage.DERIVED_ELEMENT:
			return createDerivedElement();
		case FCMPackage.COMP_IMPL_TEMPLATE:
			return createCompImplTemplate();
		case FCMPackage.IMPLEMENTATION_PROPERTIES:
			return createImplementationProperties();
		case FCMPackage.OPERATING_SYSTEM:
			return createOperatingSystem();
		case FCMPackage.TARGET_ARCHITECTURE:
			return createTargetArchitecture();
		case FCMPackage.CONFIGURATION:
			return createConfiguration();
		case FCMPackage.INTERCEPTION_RULE:
			return createInterceptionRule();
		case FCMPackage.TARGET:
			return createTarget();
		case FCMPackage.COMPILER_CHAIN:
			return createCompilerChain();
		case FCMPackage.FRAGMENT:
			return createFragment();
		case FCMPackage.COPY_ATTRIBUTE_VALUE:
			return createCopyAttributeValue();
		case FCMPackage.AUTO_INDEX:
			return createAutoIndex();
		case FCMPackage.AUTO_INDEX_PER_NODE:
			return createAutoIndexPerNode();
		case FCMPackage.INIT_PRECEDENCE:
			return createInitPrecedence();
		case FCMPackage.CONNECTOR_CONFIGURATION:
			return createConnectorConfiguration();
		case FCMPackage.BIND_TEMPLATE:
			return createBindTemplate();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case FCMPackage.CONTAINER_RULE_KIND:
			return createContainerRuleKindFromString(eDataType, initialValue);
		case FCMPackage.INTERCEPTION_KIND:
			return createInterceptionKindFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case FCMPackage.CONTAINER_RULE_KIND:
			return convertContainerRuleKindToString(eDataType, instanceValue);
		case FCMPackage.INTERCEPTION_KIND:
			return convertInterceptionKindToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Template createTemplate() {
		TemplateImpl template = new TemplateImpl();
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public BindingHelper createBindingHelper() {
		BindingHelperImpl bindingHelper = new BindingHelperImpl();
		return bindingHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConfigurationProperty createConfigurationProperty() {
		ConfigurationPropertyImpl configurationProperty = new ConfigurationPropertyImpl();
		return configurationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ImplementationGroup createImplementationGroup() {
		ImplementationGroupImpl implementationGroup = new ImplementationGroupImpl();
		return implementationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Assembly createAssembly() {
		AssemblyImpl assembly = new AssemblyImpl();
		return assembly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Flatten createFlatten() {
		FlattenImpl flatten = new FlattenImpl();
		return flatten;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CompToOOmapping createCompToOOmapping() {
		CompToOOmappingImpl compToOOmapping = new CompToOOmappingImpl();
		return compToOOmapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ProgLanguage createProgLanguage() {
		ProgLanguageImpl progLanguage = new ProgLanguageImpl();
		return progLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CodeGenOptions createCodeGenOptions() {
		CodeGenOptionsImpl codeGenOptions = new CodeGenOptionsImpl();
		return codeGenOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public InteractionComponent createInteractionComponent() {
		InteractionComponentImpl interactionComponent = new InteractionComponentImpl();
		return interactionComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Singleton createSingleton() {
		SingletonImpl singleton = new SingletonImpl();
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public UseInstanceConfigurator createUseInstanceConfigurator() {
		UseInstanceConfiguratorImpl useInstanceConfigurator = new UseInstanceConfiguratorImpl();
		return useInstanceConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public InstanceConfigurator createInstanceConfigurator() {
		InstanceConfiguratorImpl instanceConfigurator = new InstanceConfiguratorImpl();
		return instanceConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public RuleApplication createRuleApplication() {
		RuleApplicationImpl ruleApplication = new RuleApplicationImpl();
		return ruleApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ContainerRule createContainerRule() {
		ContainerRuleImpl containerRule = new ContainerRuleImpl();
		return containerRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConfigOption createConfigOption() {
		ConfigOptionImpl configOption = new ConfigOptionImpl();
		return configOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TemplatePort createTemplatePort() {
		TemplatePortImpl templatePort = new TemplatePortImpl();
		return templatePort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PortKind createPortKind() {
		PortKindImpl portKind = new PortKindImpl();
		return portKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public DerivedElement createDerivedElement() {
		DerivedElementImpl derivedElement = new DerivedElementImpl();
		return derivedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CompImplTemplate createCompImplTemplate() {
		CompImplTemplateImpl compImplTemplate = new CompImplTemplateImpl();
		return compImplTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ImplementationProperties createImplementationProperties() {
		ImplementationPropertiesImpl implementationProperties = new ImplementationPropertiesImpl();
		return implementationProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public OperatingSystem createOperatingSystem() {
		OperatingSystemImpl operatingSystem = new OperatingSystemImpl();
		return operatingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TargetArchitecture createTargetArchitecture() {
		TargetArchitectureImpl targetArchitecture = new TargetArchitectureImpl();
		return targetArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public InterceptionRule createInterceptionRule() {
		InterceptionRuleImpl interceptionRule = new InterceptionRuleImpl();
		return interceptionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CompilerChain createCompilerChain() {
		CompilerChainImpl compilerChain = new CompilerChainImpl();
		return compilerChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Fragment createFragment() {
		FragmentImpl fragment = new FragmentImpl();
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CopyAttributeValue createCopyAttributeValue() {
		CopyAttributeValueImpl copyAttributeValue = new CopyAttributeValueImpl();
		return copyAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AutoIndex createAutoIndex() {
		AutoIndexImpl autoIndex = new AutoIndexImpl();
		return autoIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AutoIndexPerNode createAutoIndexPerNode() {
		AutoIndexPerNodeImpl autoIndexPerNode = new AutoIndexPerNodeImpl();
		return autoIndexPerNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public InitPrecedence createInitPrecedence() {
		InitPrecedenceImpl initPrecedence = new InitPrecedenceImpl();
		return initPrecedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConnectorConfiguration createConnectorConfiguration() {
		ConnectorConfigurationImpl connectorConfiguration = new ConnectorConfigurationImpl();
		return connectorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public BindTemplate createBindTemplate() {
		BindTemplateImpl bindTemplate = new BindTemplateImpl();
		return bindTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ContainerRuleKind createContainerRuleKindFromString(EDataType eDataType, String initialValue) {
		ContainerRuleKind result = ContainerRuleKind.get(initialValue);
		if (result == null)
		{
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertContainerRuleKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public InterceptionKind createInterceptionKindFromString(EDataType eDataType, String initialValue) {
		InterceptionKind result = InterceptionKind.get(initialValue);
		if (result == null)
		{
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertInterceptionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public FCMPackage getFCMPackage() {
		return (FCMPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FCMPackage getPackage() {
		return FCMPackage.eINSTANCE;
	}

} // FCMFactoryImpl
