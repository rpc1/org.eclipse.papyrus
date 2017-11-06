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
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration;
import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.stereotypeapplicationmatcherconfiguration.StereotypeApplicationMatcherConfiguration;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * Test cases for the basics of element types generation for UML profiles.
 */
@PluginResource("/resources/j2ee.profile.uml")
public class BasicElementTypesGenerationTest {

	@ClassRule
	public static final ModelGenFixture fixture = new ModelGenFixture();

	public BasicElementTypesGenerationTest() {
		super();
	}

	@Test
	public void elementTypesGenerated() {
		Pair<Stereotype, Class> beanClass = fixture.getMetaclassExtension("Bean", "Class");
		fixture.assertSpecializationType(beanClass);
		assertThat(fixture.getElementTypeSet().getMetamodelNsURI(), is(UMLPackage.eNS_URI));
	}

	/**
	 * Verifies that non-diagram-specific element types are generated with only a semantic parent (no visual parent).
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=461717
	 */
	@Test
	public void elementTypeSpecializedTypes_bug461717() {
		Pair<Stereotype, Class> beanClass = fixture.getMetaclassExtension("Bean", "Class");
		SpecializationTypeConfiguration specialization = fixture.assertSpecializationType(beanClass);

		assertThat(specialization.getIdentifier(), is(fixture.prefix + ".Bean"));

		List<String> specializedTypeIDs = specialization.getSpecializedTypesID();
		assertThat(specializedTypeIDs.size(), is(1));
		assertThat(specializedTypeIDs.get(0), is(UMLElementTypes.CLASS.getId()));
	}

	@Test
	public void multipleElementTypesForOneStereotypeGenerated() {
		Pair<Stereotype, Class> accessClass = fixture.getMetaclassExtension("AccessControlled", "Class");
		Pair<Stereotype, Class> accessProperty = fixture.getMetaclassExtension("AccessControlled", "Property");
		assertThat(fixture.assertSpecializationType(accessClass), not(fixture.assertSpecializationType(accessProperty)));
	}

	@Test
	public void iconGenerated() {
		Pair<Stereotype, Class> beanClass = fixture.getMetaclassExtension("Bean", "Class");
		SpecializationTypeConfiguration type = fixture.assertSpecializationType(beanClass);
		IconEntry icon = type.getIconEntry();
		assertThat(icon.getBundleId(), is(UMLEditPlugin.getPlugin().getSymbolicName()));
		assertThat(icon.getIconPath(), containsString("obj16/Class.gif"));
	}

	@Test
	public void stereotypeMatcherGenerated() {
		Pair<Stereotype, Class> beanClass = fixture.getMetaclassExtension("Bean", "Class");
		SpecializationTypeConfiguration type = fixture.assertSpecializationType(beanClass);
		StereotypeApplicationMatcherConfiguration matcher = fixture.assertStereotypeMatcher(type);
		assertThat(matcher.getStereotypesQualifiedNames(), hasItem("j2ee::Bean"));
	}

	@Test
	public void stereotypeAdviceGenerated() {
		Pair<Stereotype, Class> beanClass = fixture.getMetaclassExtension("Bean", "Class");
		ApplyStereotypeAdviceConfiguration advice = fixture.assertApplyStereotypeAdvice(beanClass);
		assertThat(advice.getTarget(), is(fixture.getElementTypeConfiguration(beanClass)));
		assertThat(advice.getStereotypesToApply(), not(isEmpty()));
		assertThat(advice.getStereotypesToApply().get(0).getRequiredProfiles(), hasItem("j2ee"));
		assertThat(advice.getStereotypesToApply().get(0).getStereotypeQualifiedName(), is("j2ee::Bean"));
	}
}
