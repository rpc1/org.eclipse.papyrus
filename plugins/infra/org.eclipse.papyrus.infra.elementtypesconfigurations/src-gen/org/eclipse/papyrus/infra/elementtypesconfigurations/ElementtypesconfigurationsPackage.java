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
package org.eclipse.papyrus.infra.elementtypesconfigurations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory
 * @model kind="package"
 * @generated
 */
public interface ElementtypesconfigurationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "elementtypesconfigurations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "elementtypesconfigurations";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.papyrus.infra.elementtypesconfigurations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ElementtypesconfigurationsPackage eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfigurationElementImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getConfigurationElement()
	 * @generated
	 */
	int CONFIGURATION_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT__IDENTIFIER = 2;

	/**
	 * The number of structural features of the '<em>Configuration Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Configuration Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl <em>Element Type Set Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getElementTypeSetConfiguration()
	 * @generated
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Element Type Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Advice Bindings Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Metamodel Ns URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element Type Set Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Element Type Set Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_SET_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl <em>Element Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getElementTypeConfiguration()
	 * @generated
	 */
	int ELEMENT_TYPE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__HINT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__KIND = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Element Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TYPE_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.IconEntryImpl <em>Icon Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.IconEntryImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getIconEntry()
	 * @generated
	 */
	int ICON_ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__ICON_PATH = 0;

	/**
	 * The feature id for the '<em><b>Bundle Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY__BUNDLE_ID = 1;

	/**
	 * The number of structural features of the '<em>Icon Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Icon Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MatcherConfigurationImpl <em>Matcher Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MatcherConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getMatcherConfiguration()
	 * @generated
	 */
	int MATCHER_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Matcher Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHER_CONFIGURATION__MATCHER_CLASS_NAME = 0;

	/**
	 * The number of structural features of the '<em>Matcher Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHER_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Matcher Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCHER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl <em>Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getAdviceConfiguration()
	 * @generated
	 */
	int ADVICE_CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__NAME = CONFIGURATION_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__DESCRIPTION = CONFIGURATION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__IDENTIFIER = CONFIGURATION_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME = CONFIGURATION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__BEFORE = CONFIGURATION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__AFTER = CONFIGURATION_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION__INHERITANCE = CONFIGURATION_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_CONFIGURATION_OPERATION_COUNT = CONFIGURATION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl <em>Advice Binding Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getAdviceBindingConfiguration()
	 * @generated
	 */
	int ADVICE_BINDING_CONFIGURATION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__NAME = ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__DESCRIPTION = ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__IDENTIFIER = ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME = ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__BEFORE = ADVICE_CONFIGURATION__BEFORE;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__AFTER = ADVICE_CONFIGURATION__AFTER;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__INHERITANCE = ADVICE_CONFIGURATION__INHERITANCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__TARGET = ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION = ADVICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION = ADVICE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Advice Binding Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT = ADVICE_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Advice Binding Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADVICE_BINDING_CONFIGURATION_OPERATION_COUNT = ADVICE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.SpecializationTypeConfigurationImpl <em>Specialization Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.SpecializationTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getSpecializationTypeConfiguration()
	 * @generated
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__NAME = ELEMENT_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__HINT = ELEMENT_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__KIND = ELEMENT_TYPE_CONFIGURATION__KIND;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>Specialized Types ID</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Specialization Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Specialization Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_TYPE_CONFIGURATION_OPERATION_COUNT = ELEMENT_TYPE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl <em>Container Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getContainerConfiguration()
	 * @generated
	 */
	int CONTAINER_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Container Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>EContainment Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES = 1;

	/**
	 * The number of structural features of the '<em>Container Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Container Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_CONFIGURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MetamodelTypeConfigurationImpl <em>Metamodel Type Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MetamodelTypeConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getMetamodelTypeConfiguration()
	 * @generated
	 */
	int METAMODEL_TYPE_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__NAME = ELEMENT_TYPE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__DESCRIPTION = ELEMENT_TYPE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__IDENTIFIER = ELEMENT_TYPE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__HINT = ELEMENT_TYPE_CONFIGURATION__HINT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__KIND = ELEMENT_TYPE_CONFIGURATION__KIND;

	/**
	 * The feature id for the '<em><b>Icon Entry</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__ICON_ENTRY = ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__ECLASS = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edit Helper Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION__EDIT_HELPER_CLASS_NAME = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Metamodel Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION_FEATURE_COUNT = ELEMENT_TYPE_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Metamodel Type Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METAMODEL_TYPE_CONFIGURATION_OPERATION_COUNT = ELEMENT_TYPE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.EditHelperAdviceConfigurationImpl <em>Edit Helper Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.EditHelperAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getEditHelperAdviceConfiguration()
	 * @generated
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__NAME = ADVICE_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__DESCRIPTION = ADVICE_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__IDENTIFIER = ADVICE_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME = ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__BEFORE = ADVICE_CONFIGURATION__BEFORE;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__AFTER = ADVICE_CONFIGURATION__AFTER;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__INHERITANCE = ADVICE_CONFIGURATION__INHERITANCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION__TARGET = ADVICE_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edit Helper Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION_FEATURE_COUNT = ADVICE_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Edit Helper Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDIT_HELPER_ADVICE_CONFIGURATION_OPERATION_COUNT = ADVICE_CONFIGURATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind <em>Inheritance Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getInheritanceKind()
	 * @generated
	 */
	int INHERITANCE_KIND = 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration <em>Element Type Set Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Type Set Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration
	 * @generated
	 */
	EClass getElementTypeSetConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getElementTypeConfigurations <em>Element Type Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Type Configurations</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getElementTypeConfigurations()
	 * @see #getElementTypeSetConfiguration()
	 * @generated
	 */
	EReference getElementTypeSetConfiguration_ElementTypeConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getAdviceBindingsConfigurations <em>Advice Bindings Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Advice Bindings Configurations</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getAdviceBindingsConfigurations()
	 * @see #getElementTypeSetConfiguration()
	 * @generated
	 */
	EReference getElementTypeSetConfiguration_AdviceBindingsConfigurations();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getMetamodelNsURI <em>Metamodel Ns URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Metamodel Ns URI</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration#getMetamodelNsURI()
	 * @see #getElementTypeSetConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeSetConfiguration_MetamodelNsURI();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration <em>Element Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
	 * @generated
	 */
	EClass getElementTypeConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getHint <em>Hint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hint</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getHint()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeConfiguration_Hint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getKind()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EAttribute getElementTypeConfiguration_Kind();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getIconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration#getIconEntry()
	 * @see #getElementTypeConfiguration()
	 * @generated
	 */
	EReference getElementTypeConfiguration_IconEntry();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Entry</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry
	 * @generated
	 */
	EClass getIconEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry#getIconPath()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_IconPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry#getBundleId <em>Bundle Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Id</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry#getBundleId()
	 * @see #getIconEntry()
	 * @generated
	 */
	EAttribute getIconEntry_BundleId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Element</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement
	 * @generated
	 */
	EClass getConfigurationElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getName()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getDescription()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement#getIdentifier()
	 * @see #getConfigurationElement()
	 * @generated
	 */
	EAttribute getConfigurationElement_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration
	 * @generated
	 */
	EClass getMatcherConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration#getMatcherClassName <em>Matcher Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matcher Class Name</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration#getMatcherClassName()
	 * @see #getMatcherConfiguration()
	 * @generated
	 */
	EAttribute getMatcherConfiguration_MatcherClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration <em>Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration
	 * @generated
	 */
	EClass getAdviceConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getEditHelperAdviceClassName <em>Edit Helper Advice Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edit Helper Advice Class Name</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getEditHelperAdviceClassName()
	 * @see #getAdviceConfiguration()
	 * @generated
	 */
	EAttribute getAdviceConfiguration_EditHelperAdviceClassName();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Before</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getBefore()
	 * @see #getAdviceConfiguration()
	 * @generated
	 */
	EAttribute getAdviceConfiguration_Before();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>After</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getAfter()
	 * @see #getAdviceConfiguration()
	 * @generated
	 */
	EAttribute getAdviceConfiguration_After();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getInheritance <em>Inheritance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inheritance</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration#getInheritance()
	 * @see #getAdviceConfiguration()
	 * @generated
	 */
	EAttribute getAdviceConfiguration_Inheritance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration <em>Advice Binding Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Advice Binding Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration
	 * @generated
	 */
	EClass getAdviceBindingConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getTarget()
	 * @see #getAdviceBindingConfiguration()
	 * @generated
	 */
	EReference getAdviceBindingConfiguration_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getContainerConfiguration <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getContainerConfiguration()
	 * @see #getAdviceBindingConfiguration()
	 * @generated
	 */
	EReference getAdviceBindingConfiguration_ContainerConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration#getMatcherConfiguration()
	 * @see #getAdviceBindingConfiguration()
	 * @generated
	 */
	EReference getAdviceBindingConfiguration_MatcherConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration <em>Specialization Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration
	 * @generated
	 */
	EClass getSpecializationTypeConfiguration();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getSpecializedTypesID <em>Specialized Types ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Specialized Types ID</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getSpecializedTypesID()
	 * @see #getSpecializationTypeConfiguration()
	 * @generated
	 */
	EAttribute getSpecializationTypeConfiguration_SpecializedTypesID();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getEditHelperAdviceConfiguration <em>Edit Helper Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Edit Helper Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getEditHelperAdviceConfiguration()
	 * @see #getSpecializationTypeConfiguration()
	 * @generated
	 */
	EReference getSpecializationTypeConfiguration_EditHelperAdviceConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getContainerConfiguration <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getContainerConfiguration()
	 * @see #getSpecializationTypeConfiguration()
	 * @generated
	 */
	EReference getSpecializationTypeConfiguration_ContainerConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getMatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration#getMatcherConfiguration()
	 * @see #getSpecializationTypeConfiguration()
	 * @generated
	 */
	EReference getSpecializationTypeConfiguration_MatcherConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration
	 * @generated
	 */
	EClass getContainerConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration#getContainerMatcherConfiguration <em>Container Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Container Matcher Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration#getContainerMatcherConfiguration()
	 * @see #getContainerConfiguration()
	 * @generated
	 */
	EReference getContainerConfiguration_ContainerMatcherConfiguration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration#getEContainmentFeatures <em>EContainment Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EContainment Features</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration#getEContainmentFeatures()
	 * @see #getContainerConfiguration()
	 * @generated
	 */
	EReference getContainerConfiguration_EContainmentFeatures();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration <em>Metamodel Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metamodel Type Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration
	 * @generated
	 */
	EClass getMetamodelTypeConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration#getEClass()
	 * @see #getMetamodelTypeConfiguration()
	 * @generated
	 */
	EReference getMetamodelTypeConfiguration_EClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration#getEditHelperClassName <em>Edit Helper Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edit Helper Class Name</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration#getEditHelperClassName()
	 * @see #getMetamodelTypeConfiguration()
	 * @generated
	 */
	EAttribute getMetamodelTypeConfiguration_EditHelperClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration <em>Edit Helper Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edit Helper Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration
	 * @generated
	 */
	EClass getEditHelperAdviceConfiguration();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration#getTarget()
	 * @see #getEditHelperAdviceConfiguration()
	 * @generated
	 */
	EReference getEditHelperAdviceConfiguration_Target();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind <em>Inheritance Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Inheritance Kind</em>'.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind
	 * @generated
	 */
	EEnum getInheritanceKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ElementtypesconfigurationsFactory getElementtypesconfigurationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl <em>Element Type Set Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getElementTypeSetConfiguration()
		 * @generated
		 */
		EClass ELEMENT_TYPE_SET_CONFIGURATION = eINSTANCE.getElementTypeSetConfiguration();

		/**
		 * The meta object literal for the '<em><b>Element Type Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_TYPE_SET_CONFIGURATION__ELEMENT_TYPE_CONFIGURATIONS = eINSTANCE.getElementTypeSetConfiguration_ElementTypeConfigurations();

		/**
		 * The meta object literal for the '<em><b>Advice Bindings Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_TYPE_SET_CONFIGURATION__ADVICE_BINDINGS_CONFIGURATIONS = eINSTANCE.getElementTypeSetConfiguration_AdviceBindingsConfigurations();

		/**
		 * The meta object literal for the '<em><b>Metamodel Ns URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_TYPE_SET_CONFIGURATION__METAMODEL_NS_URI = eINSTANCE.getElementTypeSetConfiguration_MetamodelNsURI();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl <em>Element Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getElementTypeConfiguration()
		 * @generated
		 */
		EClass ELEMENT_TYPE_CONFIGURATION = eINSTANCE.getElementTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Hint</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_TYPE_CONFIGURATION__HINT = eINSTANCE.getElementTypeConfiguration_Hint();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_TYPE_CONFIGURATION__KIND = eINSTANCE.getElementTypeConfiguration_Kind();

		/**
		 * The meta object literal for the '<em><b>Icon Entry</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_TYPE_CONFIGURATION__ICON_ENTRY = eINSTANCE.getElementTypeConfiguration_IconEntry();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.IconEntryImpl <em>Icon Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.IconEntryImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getIconEntry()
		 * @generated
		 */
		EClass ICON_ENTRY = eINSTANCE.getIconEntry();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_ENTRY__ICON_PATH = eINSTANCE.getIconEntry_IconPath();

		/**
		 * The meta object literal for the '<em><b>Bundle Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_ENTRY__BUNDLE_ID = eINSTANCE.getIconEntry_BundleId();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfigurationElementImpl <em>Configuration Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfigurationElementImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getConfigurationElement()
		 * @generated
		 */
		EClass CONFIGURATION_ELEMENT = eINSTANCE.getConfigurationElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_ELEMENT__NAME = eINSTANCE.getConfigurationElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_ELEMENT__DESCRIPTION = eINSTANCE.getConfigurationElement_Description();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_ELEMENT__IDENTIFIER = eINSTANCE.getConfigurationElement_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MatcherConfigurationImpl <em>Matcher Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MatcherConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getMatcherConfiguration()
		 * @generated
		 */
		EClass MATCHER_CONFIGURATION = eINSTANCE.getMatcherConfiguration();

		/**
		 * The meta object literal for the '<em><b>Matcher Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCHER_CONFIGURATION__MATCHER_CLASS_NAME = eINSTANCE.getMatcherConfiguration_MatcherClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl <em>Advice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getAdviceConfiguration()
		 * @generated
		 */
		EClass ADVICE_CONFIGURATION = eINSTANCE.getAdviceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Edit Helper Advice Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME = eINSTANCE.getAdviceConfiguration_EditHelperAdviceClassName();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVICE_CONFIGURATION__BEFORE = eINSTANCE.getAdviceConfiguration_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVICE_CONFIGURATION__AFTER = eINSTANCE.getAdviceConfiguration_After();

		/**
		 * The meta object literal for the '<em><b>Inheritance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADVICE_CONFIGURATION__INHERITANCE = eINSTANCE.getAdviceConfiguration_Inheritance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl <em>Advice Binding Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.AdviceBindingConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getAdviceBindingConfiguration()
		 * @generated
		 */
		EClass ADVICE_BINDING_CONFIGURATION = eINSTANCE.getAdviceBindingConfiguration();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVICE_BINDING_CONFIGURATION__TARGET = eINSTANCE.getAdviceBindingConfiguration_Target();

		/**
		 * The meta object literal for the '<em><b>Container Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION = eINSTANCE.getAdviceBindingConfiguration_ContainerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Matcher Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION = eINSTANCE.getAdviceBindingConfiguration_MatcherConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.SpecializationTypeConfigurationImpl <em>Specialization Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.SpecializationTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getSpecializationTypeConfiguration()
		 * @generated
		 */
		EClass SPECIALIZATION_TYPE_CONFIGURATION = eINSTANCE.getSpecializationTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>Specialized Types ID</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID = eINSTANCE.getSpecializationTypeConfiguration_SpecializedTypesID();

		/**
		 * The meta object literal for the '<em><b>Edit Helper Advice Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION = eINSTANCE.getSpecializationTypeConfiguration_EditHelperAdviceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Container Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION = eINSTANCE.getSpecializationTypeConfiguration_ContainerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Matcher Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION = eINSTANCE.getSpecializationTypeConfiguration_MatcherConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl <em>Container Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ContainerConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getContainerConfiguration()
		 * @generated
		 */
		EClass CONTAINER_CONFIGURATION = eINSTANCE.getContainerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Container Matcher Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_CONFIGURATION__CONTAINER_MATCHER_CONFIGURATION = eINSTANCE.getContainerConfiguration_ContainerMatcherConfiguration();

		/**
		 * The meta object literal for the '<em><b>EContainment Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_CONFIGURATION__ECONTAINMENT_FEATURES = eINSTANCE.getContainerConfiguration_EContainmentFeatures();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MetamodelTypeConfigurationImpl <em>Metamodel Type Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.MetamodelTypeConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getMetamodelTypeConfiguration()
		 * @generated
		 */
		EClass METAMODEL_TYPE_CONFIGURATION = eINSTANCE.getMetamodelTypeConfiguration();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METAMODEL_TYPE_CONFIGURATION__ECLASS = eINSTANCE.getMetamodelTypeConfiguration_EClass();

		/**
		 * The meta object literal for the '<em><b>Edit Helper Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METAMODEL_TYPE_CONFIGURATION__EDIT_HELPER_CLASS_NAME = eINSTANCE.getMetamodelTypeConfiguration_EditHelperClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.impl.EditHelperAdviceConfigurationImpl <em>Edit Helper Advice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.EditHelperAdviceConfigurationImpl
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getEditHelperAdviceConfiguration()
		 * @generated
		 */
		EClass EDIT_HELPER_ADVICE_CONFIGURATION = eINSTANCE.getEditHelperAdviceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDIT_HELPER_ADVICE_CONFIGURATION__TARGET = eINSTANCE.getEditHelperAdviceConfiguration_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind <em>Inheritance Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.InheritanceKind
		 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementtypesconfigurationsPackageImpl#getInheritanceKind()
		 * @generated
		 */
		EEnum INHERITANCE_KIND = eINSTANCE.getInheritanceKind();

	}

} //ElementtypesconfigurationsPackage
