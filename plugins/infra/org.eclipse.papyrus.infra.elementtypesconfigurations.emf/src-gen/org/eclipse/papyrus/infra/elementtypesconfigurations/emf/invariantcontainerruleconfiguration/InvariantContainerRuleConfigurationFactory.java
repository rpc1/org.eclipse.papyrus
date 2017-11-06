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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.InvariantContainerRuleConfigurationPackage
 * @generated
 */
public interface InvariantContainerRuleConfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InvariantContainerRuleConfigurationFactory eINSTANCE = org.eclipse.papyrus.infra.elementtypesconfigurations.emf.invariantcontainerruleconfiguration.impl.InvariantContainerRuleConfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Invariant Container Rule Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invariant Container Rule Configuration</em>'.
	 * @generated
	 */
	InvariantContainerRuleConfiguration createInvariantContainerRuleConfiguration();

	/**
	 * Returns a new object of class '<em>Hierarchy Permission</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hierarchy Permission</em>'.
	 * @generated
	 */
	HierarchyPermission createHierarchyPermission();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InvariantContainerRuleConfigurationPackage getInvariantContainerRuleConfigurationPackage();

} //InvariantContainerRuleConfigurationFactory
