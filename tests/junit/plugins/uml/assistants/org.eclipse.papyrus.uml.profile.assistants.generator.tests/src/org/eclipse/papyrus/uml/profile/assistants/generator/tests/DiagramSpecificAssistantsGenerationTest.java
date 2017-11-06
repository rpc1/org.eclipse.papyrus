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

package org.eclipse.papyrus.uml.profile.assistants.generator.tests;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFFunctions;
import org.eclipse.papyrus.infra.filters.CompoundFilter;
import org.eclipse.papyrus.infra.filters.Filter;
import org.eclipse.papyrus.infra.gmfdiag.assistant.AssistantPackage;
import org.eclipse.papyrus.infra.gmfdiag.assistant.ConnectionAssistant;
import org.eclipse.papyrus.infra.gmfdiag.assistant.ElementTypeFilter;
import org.eclipse.papyrus.infra.gmfdiag.assistant.PopupAssistant;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.tests.BaseElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.xtext.xbase.lib.Pair;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.ClassRule;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * Test cases for diagram-specific diagram assistants generation for UML profiles.
 */
@PluginResource("/resources/j2ee.profile.uml")
@BaseElementTypes("org.eclipse.papyrus.uml.diagram.usecase.elementTypeSet")
public class DiagramSpecificAssistantsGenerationTest {

	@ClassRule
	public static final ModelGenFixture fixture = new ModelGenFixture();

	public DiagramSpecificAssistantsGenerationTest() {
		super();
	}

	@Test
	public void popupsGenerated() {
		Pair<Stereotype, Class> branchPoint = fixture.getMetaclassExtension("BranchPoint", "ExtensionPoint");
		fixture.assertAllPopupAssistants(branchPoint);
	}

	@Test
	public void connectionsGenerated() {
		Pair<Stereotype, Class> webAssociation = fixture.getMetaclassExtension("Web", "Association");
		fixture.assertAllConnectionAssistants(webAssociation);
	}

	@Test
	public void distinctPopupHintsGenerated() {
		Pair<Stereotype, Class> branchPoint = fixture.getMetaclassExtension("BranchPoint", "ExtensionPoint");
		List<PopupAssistant> popups = fixture.assertAllPopupAssistants(branchPoint);
		Set<Integer> hints = ImmutableSet.copyOf(transform(popups, visualIDFunction()));
		assertThat(hints, hasItems(3007, 3008));
	}

	@Test
	public void distinctConnectionHintsGenerated() {
		Pair<Stereotype, Class> webAssociation = fixture.getMetaclassExtension("Web", "Association");
		List<ConnectionAssistant> connections = fixture.assertAllConnectionAssistants(webAssociation);
		Set<Integer> hints = ImmutableSet.copyOf(transform(connections, visualIDFunction()));
		assertThat(hints, hasItems(4011));
	}


	@SuppressWarnings("unchecked")
	@Test
	public void popupFilters() {
		Pair<Stereotype, Class> branchPoint = fixture.getMetaclassExtension("BranchPoint", "ExtensionPoint");
		List<PopupAssistant> popups = fixture.assertAllPopupAssistants(branchPoint);

		Pair<Stereotype, Class> webScenarioUseCase = fixture.getMetaclassExtension("WebScenario", "UseCase");
		ElementTypeFilter filter2013 = fixture.assertMetaclassFilter(webScenarioUseCase, 2013);
		ElementTypeFilter filter2014 = fixture.assertMetaclassFilter(webScenarioUseCase, 2014);

		assertThat(transform(popups, EMFFunctions.getFeature(AssistantPackage.Literals.POPUP_ASSISTANT__FILTER, Filter.class)), //
				hasItems(includes(filter2013), includes(filter2014)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void connectionSourceFilters() {
		Pair<Stereotype, Class> webAssociation = fixture.getMetaclassExtension("Web", "Association");
		List<ConnectionAssistant> connections = fixture.assertAllConnectionAssistants(webAssociation);

		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		ElementTypeFilter filter2011 = fixture.assertMetaclassFilter(userActor, 2011);
		Pair<Stereotype, Class> webScenarioUseCase = fixture.getMetaclassExtension("WebScenario", "UseCase");
		ElementTypeFilter filter2013 = fixture.assertMetaclassFilter(webScenarioUseCase, 2013);

		assertThat(transform(connections, EMFFunctions.getFeature(AssistantPackage.Literals.CONNECTION_ASSISTANT__SOURCE_FILTER, Filter.class)), //
				hasItems(includes(filter2011), includes(filter2013)));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void connectionTargetFilters() {
		Pair<Stereotype, Class> webAssociation = fixture.getMetaclassExtension("Web", "Association");
		List<ConnectionAssistant> connections = fixture.assertAllConnectionAssistants(webAssociation);

		Pair<Stereotype, Class> userActor = fixture.getMetaclassExtension("User", "Actor");
		ElementTypeFilter filter2011 = fixture.assertMetaclassFilter(userActor, 2011);
		Pair<Stereotype, Class> webScenarioUseCase = fixture.getMetaclassExtension("WebScenario", "UseCase");
		ElementTypeFilter filter2013 = fixture.assertMetaclassFilter(webScenarioUseCase, 2013);

		assertThat(transform(connections, EMFFunctions.getFeature(AssistantPackage.Literals.CONNECTION_ASSISTANT__TARGET_FILTER, Filter.class)), //
				hasItems(includes(filter2011), includes(filter2013)));
	}

	//
	// Test framework
	//

	static Function<String, String> suffixFunction() {
		return new Function<String, String>() {
			final Pattern suffix = Pattern.compile("[._]([0-9a-zA-Z]+)$");

			@Override
			public String apply(String input) {
				Matcher m = suffix.matcher(input);
				return m.find() ? m.group(1) : null;
			}
		};
	}

	static Function<EObject, Integer> visualIDFunction() {
		Function<String, Integer> parse = new Function<String, Integer>() {
			@Override
			public Integer apply(String input) {
				return Integer.valueOf(input);
			}
		};
		return Functions.compose(parse, Functions.compose(suffixFunction(), EMFFunctions.getFeature(AssistantPackage.Literals.ASSISTANT__ELEMENT_TYPE_ID, String.class)));
	}

	static org.hamcrest.Matcher<Filter> includes(final Filter filter) {
		return new BaseMatcher<Filter>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("includes filter ").appendValue(filter.getName());
			}

			@Override
			public boolean matches(Object item) {
				boolean result = item == filter;
				if (!result && (item instanceof CompoundFilter)) {
					result = includes((CompoundFilter) item, filter);
				}
				return result;
			}

			private boolean includes(CompoundFilter compound, Filter filter) {
				Set<Filter> atoms = closureOfAtoms(compound, Sets.<Filter> newHashSet());
				return atoms.contains(filter);
			}

			private Set<Filter> closureOfAtoms(CompoundFilter compound, Set<Filter> result) {
				Iterables.addAll(result, filter(compound.getFilters(), Predicates.not(Predicates.instanceOf(CompoundFilter.class))));
				for (CompoundFilter next : filter(compound.getFilters(), CompoundFilter.class)) {
					closureOfAtoms(next, result);
				}
				return result;
			}
		};
	}
}
