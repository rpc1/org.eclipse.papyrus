/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.inject.AbstractModule;

/**
 * The base Guice injector module for the UML Profile to Element Types Set Configuration transformation.
 */
public class GeneratorModule extends AbstractModule {
	private final Identifiers identifiers;

	public GeneratorModule(Identifiers identifiers) {
		super();

		this.identifiers = identifiers;
	}

	@Override
	protected void configure() {
		// bind transformation parameters
		bindInputType();
		bindOutputType();

		// bind extensions
		bindIdentifiers();
		bindUMLElementTypes();

		// bind transformation rules
		bindConfigurationSetRule();
		bindElementTypeRule();
		bindApplyStereotypeAdviceRule();
	}

	protected void bindInputType() {
		bind(EClass.class).annotatedWith(InputModel.class).toInstance(UMLPackage.Literals.PROFILE);
	}

	protected void bindOutputType() {
		bind(EClass.class).annotatedWith(OutputModel.class).toInstance(ElementtypesconfigurationsPackage.Literals.ELEMENT_TYPE_SET_CONFIGURATION);
	}

	protected void bindIdentifiers() {
		bind(Identifiers.class).toInstance(identifiers);
	}

	protected void bindUMLElementTypes() {
		// Pass
	}

	protected void bindConfigurationSetRule() {
		// Pass
	}

	protected void bindElementTypeRule() {
		// Pass
	}

	protected void bindApplyStereotypeAdviceRule() {
		// Pass
	}
}
