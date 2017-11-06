/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
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

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.tests;

import static org.eclipse.papyrus.junit.matchers.MoreMatchers.isEmpty;
import static org.eclipse.papyrus.junit.matchers.MoreMatchers.regexContains;
import static org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.tests.GenOption.SUPPRESS_SEMANTIC_SUPERTYPE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Test cases for diagram-specific element types generation for UML profiles with the option to suppress the generation
 * of the semantic supertype reference.
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=461717
 */
@PluginResource("/resources/j2ee.profile.uml")
@BaseElementTypes("org.eclipse.papyrus.uml.diagram.usecase.elementTypeSet")
@GenOptions(SUPPRESS_SEMANTIC_SUPERTYPE)
public class DiagramSpecificElementTypesGenerationBug461717Test {

	@ClassRule
	public static final ModelGenFixture fixture = new ModelGenFixture();

	public DiagramSpecificElementTypesGenerationBug461717Test() {
		super();
	}

	/**
	 * Verifies that diagram-specific element types are generated with only the visual parent
	 * when the semantic parent is suppressed.
	 */
	@Test
	public void elementTypeSpecializedTypes() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> specializationTypes = fixture.assertAllSpecializationTypes(userActor);
		assertThat("No specialization types generated", specializationTypes, not(isEmpty()));

		String idPrefix = fixture.prefix + ".User_";

		for (SpecializationTypeConfiguration next : specializationTypes) {
			assertThat(next.getIdentifier(), startsWith(idPrefix));

			List<String> specializedTypeIDs = next.getSpecializedTypesID();
			assertThat(specializedTypeIDs.size(), is(1));
			assertThat(specializedTypeIDs.get(0), regexContains("Actor_\\d{4}$")); // a visual ID
		}
	}

	/**
	 * Verifies that diagram-specific element types are generated with stereotype matchers
	 * when the semantic parent is suppressed.
	 */
	@Test
	public void stereotypeMatcherGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<SpecializationTypeConfiguration> types = fixture.assertAllSpecializationTypes(userActor);
		for (SpecializationTypeConfiguration type : types) {
			StereotypeApplicationMatcherConfiguration matcher = fixture.assertStereotypeMatcher(type);
			assertThat(matcher.getStereotypesQualifiedNames(), hasItem("j2ee::User"));
		}
	}

	/**
	 * Verifies that diagram-specific element types are generated with apply-stereotype advice
	 * when the semantic parent is suppressed.
	 */
	@Test
	public void stereotypeAdviceGenerated() {
		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		List<ApplyStereotypeAdviceConfiguration> advices = fixture.assertAllApplyStereotypeAdvices(userActor);
		for (ApplyStereotypeAdviceConfiguration advice : advices) {
			String visualID = advice.getIdentifier().substring(advice.getIdentifier().lastIndexOf('_') + 1);
			assertThat(advice.getTarget(), is(fixture.getElementTypeConfiguration(userActor, visualID)));
			assertThat(advice.getStereotypesToApply(), not(isEmpty()));
			assertThat(advice.getStereotypesToApply().get(0).getRequiredProfiles(), hasItem("j2ee"));
			assertThat(advice.getStereotypesToApply().get(0).getStereotypeQualifiedName(), is("j2ee::User"));
		}
	}
}
