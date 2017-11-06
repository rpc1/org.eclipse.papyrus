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

package org.eclipse.papyrus.uml.profile.assistants.generator;

import org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.AbstractGenerator;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers;
import org.eclipse.uml2.uml.Profile;

import com.google.inject.Inject;

/**
 * The generator facade for the UML Profile to Modeling Assistant Provider transformation.
 */
public class ModelingAssistantsGenerator extends AbstractGenerator<Profile, ModelingAssistantProvider> {

	@Inject
	private ModelingAssistantProviderRule mainRule;

	public ModelingAssistantsGenerator(Identifiers identifiers) {
		this(new GeneratorModule(identifiers));
	}

	public ModelingAssistantsGenerator(GeneratorModule module) {
		super(module);
	}

	@Override
	protected ModelingAssistantProvider generate(Profile profile) {
		return mainRule.toModelingAssistantProvider(profile);
	}
}
