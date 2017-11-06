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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;

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
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface SetTypeAdviceConfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "settypeadviceconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/infra/elementtypesconfigurations/uml/settypeadvice/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "settypeadviceconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SetTypeAdviceConfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl <em>Set Type Advice Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationPackageImpl#getSetTypeAdviceConfiguration()
	 * @generated
	 */
	int SET_TYPE_ADVICE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__NAME = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__DESCRIPTION = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__IDENTIFIER = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Edit Helper Advice Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__EDIT_HELPER_ADVICE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__BEFORE = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__BEFORE;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__AFTER = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__AFTER;

	/**
	 * The feature id for the '<em><b>Inheritance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__INHERITANCE = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__INHERITANCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__TARGET = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__TARGET;

	/**
	 * The feature id for the '<em><b>Container Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__CONTAINER_CONFIGURATION = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__CONTAINER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Matcher Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__MATCHER_CONFIGURATION = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION__MATCHER_CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Valid Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creation Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Set Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION_FEATURE_COUNT = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Set Type Advice Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_ADVICE_CONFIGURATION_OPERATION_COUNT = ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration <em>Set Type Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type Advice Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration
	 * @generated
	 */
	EClass getSetTypeAdviceConfiguration();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getValidTypes <em>Valid Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Valid Types</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getValidTypes()
	 * @see #getSetTypeAdviceConfiguration()
	 * @generated
	 */
	EAttribute getSetTypeAdviceConfiguration_ValidTypes();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getCreationTypes <em>Creation Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Creation Types</em>'.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.SetTypeAdviceConfiguration#getCreationTypes()
	 * @see #getSetTypeAdviceConfiguration()
	 * @generated
	 */
	EAttribute getSetTypeAdviceConfiguration_CreationTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SetTypeAdviceConfigurationFactory getSetTypeAdviceConfigurationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl <em>Set Type Advice Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationImpl
		 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.settypeadviceconfiguration.impl.SetTypeAdviceConfigurationPackageImpl#getSetTypeAdviceConfiguration()
		 * @generated
		 */
		EClass SET_TYPE_ADVICE_CONFIGURATION = eINSTANCE.getSetTypeAdviceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Valid Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TYPE_ADVICE_CONFIGURATION__VALID_TYPES = eINSTANCE.getSetTypeAdviceConfiguration_ValidTypes();

		/**
		 * The meta object literal for the '<em><b>Creation Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_TYPE_ADVICE_CONFIGURATION__CREATION_TYPES = eINSTANCE.getSetTypeAdviceConfiguration_CreationTypes();

	}

} //SetTypeAdviceConfigurationPackage
