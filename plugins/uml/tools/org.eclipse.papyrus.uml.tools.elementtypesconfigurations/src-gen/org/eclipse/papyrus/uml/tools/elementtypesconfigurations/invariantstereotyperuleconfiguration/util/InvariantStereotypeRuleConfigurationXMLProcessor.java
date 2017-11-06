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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.invariantstereotyperuleconfiguration.InvariantStereotypeRuleConfigurationPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InvariantStereotypeRuleConfigurationXMLProcessor extends XMLProcessor
{

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvariantStereotypeRuleConfigurationXMLProcessor()
	{
		super((EPackage.Registry.INSTANCE));
		InvariantStereotypeRuleConfigurationPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the InvariantStereotypeRuleConfigurationResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations()
	{
		if (registrations == null)
		{
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new InvariantStereotypeRuleConfigurationResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new InvariantStereotypeRuleConfigurationResourceFactoryImpl());
		}
		return registrations;
	}

} //InvariantStereotypeRuleConfigurationXMLProcessor
