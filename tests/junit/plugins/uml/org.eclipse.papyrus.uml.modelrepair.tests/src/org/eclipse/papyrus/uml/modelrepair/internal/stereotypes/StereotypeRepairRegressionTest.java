/*
 * Copyright (c) 2014, 2015 CEA, Christian W. Damus, and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 455248
 *   Christian W. Damus - bug 455329
 *   Christian W. Damus - bug 436666
 *   Christian W. Damus - bug 458736
 *   Christian W. Damus - bug 459488
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.stereotypes;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.core.utils.TransactionHelper;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.junit.utils.rules.ModelSetFixture;
import org.eclipse.papyrus.junit.utils.rules.PluginResource;
import org.eclipse.papyrus.uml.modelrepair.ui.IZombieStereotypePresenter;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;


/**
 * Specific bug regression tests for the {@link StereotypeApplicationRepairSnippet} class and its dependencies.
 */
public class StereotypeRepairRegressionTest extends AbstractPapyrusTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();

	@Rule
	public final ModelSetFixture modelSet = new ModelSetFixture();

	// Ensure that the cache is purged after each text execution (don't rely on the UI thread)
	@Rule
	public final ReadOnlyCacheRule readonly = new ReadOnlyCacheRule();

	private StereotypeApplicationRepairSnippet fixture;

	private TestPresenter presenter; // For tests that use it

	private ZombieStereotypesDescriptor zombies;

	private Package model;

	public StereotypeRepairRegressionTest() {
		super();
	}

	/**
	 * Tests that a scenario involving nested profiles and profile applications in nested packages that are all actually
	 * well-formed does not trigger the repair function.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=434302
	 */
	@Test
	@PluginResource("/resources/regression/bug434302/nested-profiles.uml")
	public void nestedProfilesAndNestedApplicationsWellFormed_bug434302() {
		assertThat("Should not have found zombie stereotypes", zombies, nullValue());
	}

	/**
	 * Tests that a scenario involving a nested profile gone AWOL in profile applications in a nested packages is
	 * correctly repaired.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=434302
	 */
	@Test
	@PluginResource("/resources/regression/bug434302/nested-profiles-nonamespace.uml")
	public void nestedProfileApplicationsMissingNamespace_bug434302() {
		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.APPLY_LATEST_PROFILE_DEFINITION));

		repair(schema, action);

		assertThat("Profile was applied to root package", model.getAppliedProfile("Profile::Nested2"), nullValue());

		Package nested = model.getNestedPackage("Package2");
		Profile profile = nested.getAppliedProfile("Profile::Nested2");
		ProfileApplication application = nested.getProfileApplication(profile);
		assertThat("Profile was not re-applied to nested package", application.getAppliedDefinition(), is(profile.getDefinition()));

		// Verify the stereotype instance that was migrated
		Stereotype stereo = profile.getOwnedStereotype("Stereo2");
		Class class2 = (Class) nested.getOwnedType("Class2");
		Property class1 = class2.getAttribute("class1", null);
		assertThat(class1.getValue(stereo, "weight"), is((Object) 15));
	}

	/**
	 * Tests that a scenario involving a single nested profile schema declaration gone AWOL in two different profile applications
	 * in two different nested packages is correctly repaired.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=434302
	 */
	@Test
	@PluginResource("/resources/regression/bug434302/nested-profiles-2pkgs1profile.uml")
	public void nestedProfileApplications2Pkgs1Profile_bug434302() {
		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.APPLY_LATEST_PROFILE_DEFINITION));

		repair(schema, action);

		assertThat("Profile was applied to root package", model.getAppliedProfile("Profile::Nested1"), nullValue());

		Package nested = model.getNestedPackage("Package1");
		Profile profile = nested.getAppliedProfile("Profile::Nested1");
		ProfileApplication application = nested.getProfileApplication(profile);
		assertThat("Profile was not re-applied to first nested package", application.getAppliedDefinition(), is(profile.getDefinition()));

		// Verify the stereotype instance that was migrated
		Stereotype stereo = profile.getOwnedStereotype("Stereo1");
		Class class1 = (Class) nested.getOwnedType("Class1");
		assertThat(class1.getValue(stereo, "tag"), is((Object) "new version"));
		assertThat(class1.getValue(stereo, "reportable"), is((Object) true));

		nested = model.getNestedPackage("Package3");
		profile = nested.getAppliedProfile("Profile::Nested1");
		application = nested.getProfileApplication(profile);
		assertThat("Profile was not re-applied to second nested package", application.getAppliedDefinition(), is(profile.getDefinition()));

		// Verify the stereotype instance that was migrated
		stereo = profile.getOwnedStereotype("Stereo1");
		Class class4 = (Class) nested.getNestedPackage("p1").getOwnedType("Class4");
		assertThat(class4.getValue(stereo, "tag"), is((Object) "deeply nested"));
		assertThat(class4.getValue(stereo, "reportable"), is((Object) true));
	}

	/**
	 * Tests that a scenario involving well-formed stereotypes contained in a simple package nested in a profile
	 * does not trigger the repair function.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436666
	 */
	@Test
	@Bug("436666")
	@PluginResource("/resources/regression/bug436666/model2.uml")
	public void nestedPackageInProfileIsOK_bug436666() {
		assertThat("Should not have found zombie stereotypes", zombies, nullValue());
	}

	/**
	 * Tests that a scenario involving stereotypes from a nested EPackage gone AWOL, which EPackage is defined by a nested
	 * simple package in the UML profile, is correctly repaired.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436666
	 */
	@Test
	@Bug("436666")
	@PluginResource("/resources/regression/bug436666/model2-missing-schemalocation.uml")
	public void nestedPackageSchemaMissing_bug436666() {
		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.APPLY_LATEST_PROFILE_DEFINITION));

		repair(schema, action);

		Profile profile = model.getAppliedProfile("Profile");
		Package nested = profile.getNestedPackage("Package1");

		// Verify the stereotype instances that were repaired
		Class class1 = (Class) model.getOwnedType("Class1");
		Stereotype stereo1 = nested.getOwnedStereotype("Stereotype1");
		Stereotype stereo2 = nested.getOwnedStereotype("Stereotype2");
		assertThat(class1.isStereotypeApplied(stereo1), is(true));
		assertThat(class1.getValue(stereo1, "tag1"), is((Object) "value for tag1 from nested package"));
		assertThat(class1.isStereotypeApplied(stereo2), is(true));
		assertThat(class1.getValue(stereo2, "tag2"), is((Object) true));
	}

	/**
	 * Tests that a scenario involving non-UML root elements that are recognizably not stereotype
	 * applications do not trigger the repair function.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436666
	 */
	@Test
	@Bug("436666bis")
	@PluginResource("/resources/regression/bug436666/model-with-stylesheet.uml")
	public void nonStereotypeApplicationsAreOK_bug436666() {
		assertThat("Should not have found zombie stereotypes", zombies, nullValue());
	}

	/**
	 * Tests that a sub-united model in which package units do not repeat profile applications,
	 * but rather just inherit them from parent units, such as might be imported from some other
	 * UML tool, does not falsely trigger repair.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=455248
	 */
	@Test
	@Bug("455248")
	@PluginResource("/resources/regression/bug455248/model.uml")
	public void packageUnitWithoutOwnProfileApplication_bug455248() {
		assertThat("Should not have found zombie stereotypes", zombies, nullValue());
	}

	/**
	 * Tests that a model applying a registered dynamic profile does not detect spurious broken
	 * stereotype applications.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=455329
	 */
	@Test
	@Bug("455329")
	@PluginResource("/resources/regression/bug455329/model.uml")
	public void registeredDynamicProfie_bug455329() {
		assertThat("Should not have found zombie stereotypes", zombies, nullValue());
	}

	/**
	 * Tests that orphaned stereotype instances are correctly detected where they are of the currently applied profile schema.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436666
	 */
	@Test
	@Bug("436666")
	@PluginResource("/resources/regression/bug436666/orphans-of-valid-schema.uml")
	public void orphansOfValidSchema_bug436666() {
		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.DELETE));

		repair(schema, action);

		// The stereotype applications were deleted
		assertThat(model.eResource().getContents(), is(ECollections.singletonEList((EObject) model)));
	}

	/**
	 * Tests that orphaned stereotype instances are correctly detected where they are of a profile version that is not currently applied.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=436666
	 */
	@Test
	@Bug("436666")
	@PluginResource("/resources/regression/bug436666/orphans-of-wrong-profile-version.uml")
	public void orphansOfWrongProfileVersion_bug436666() {
		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.DELETE));

		repair(schema, action);

		// The stereotype applications were deleted
		assertThat(model.eResource().getContents(), is(ECollections.singletonEList((EObject) model)));
	}

	/**
	 * Tests that a sub-united model in which package units do not repeat profile applications,
	 * but rather just inherit them from parent units, such as might be imported from some other
	 * UML tool, does not falsely trigger repair in the case where sub-units are lazily loaded
	 * by cross-references after the main model has been loaded.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=458736
	 */
	@Test
	@Bug("458736")
	@PluginResource("/resources/regression/bug458736/container.uml")
	public void crossReferencedPackageUnitWithoutOwnProfileApplication_bug458736() throws InterruptedException {
		// Resolving the imported package with its sub-unit shouldn't find zombies.
		resolveSubunitsAndWaitForAsyncAnalysis();

		assertThat("Should not have found zombie stereotypes after resolving cross-references", zombies, nullValue());
	}

	/**
	 * Tests that a scenario involving a malformed XSI schema-location for a profile schema in a non-package model fragment
	 * (sub-unit resource) is correctly detected and repaired.
	 * 
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=459488
	 */
	@Test
	@Bug("459488")
	@PluginResource("/resources/regression/bug459488/model.di")
	public void badSchemaLocationInNonPackageFragment_bug459488() throws InterruptedException {
		// Load the sub-unit, triggering (we hope) repair
		resolveSubunitsAndWaitForAsyncAnalysis();

		IAdaptable schema = getOnlyZombieSchema();
		IRepairAction action = zombies.getSuggestedRepairAction(schema);
		assertThat("Wrong suggested repair action", action.kind(), is(IRepairAction.Kind.APPLY_LATEST_PROFILE_DEFINITION));

		repair(schema, action);

		// Verify the stereotype application that was migrated
		Class class1 = (Class) model.getOwnedType("Class1");
		Stereotype stereotype1 = class1.getAppliedStereotype("profile::Stereotype1");
		assertThat("Stereotype1 does not seem to be applied", stereotype1, notNullValue());

		// And that the migrated stereotype application is in the correct resource (the sub-model unit)
		assertThat("Stereotype1 application in wrong resource", class1.getStereotypeApplication(stereotype1).eResource(), is(class1.eResource()));
	}

	//
	// Test framework
	//

	@Before
	public void createFixture() throws Exception {
		model = modelSet.getModel();

		// Look for fixture-method correlation
		Method fixtureMethod = null;
		Method test = getClass().getMethod(this.houseKeeper.getTestName());
		if (test.isAnnotationPresent(Bug.class)) {
			String bug = test.getAnnotation(Bug.class).value()[0];
			for (Method next : getClass().getDeclaredMethods()) {
				if (next.isAnnotationPresent(Bug.class) && StereotypeApplicationRepairSnippet.class.isAssignableFrom(next.getReturnType())) {
					Set<String> bugs = ImmutableSet.copyOf(next.getAnnotation(Bug.class).value());
					if (bugs.contains(bug)) {
						fixtureMethod = next;
						break;
					}
				}
			}
		}

		if (fixtureMethod == null) {
			fixture = createDefaultFixture();
		} else {
			fixture = (StereotypeApplicationRepairSnippet) fixtureMethod.invoke(this);
		}

		fixture.start(modelSet.getResourceSet());
		houseKeeper.setField("zombies", fixture.getZombieStereotypes(modelSet.getModelResource(), modelSet.getModel()));
	}

	protected StereotypeApplicationRepairSnippet createDefaultFixture() {
		final Profile rootProfile = model.getAppliedProfile("Profile");
		final Profile nested1 = model.getNestedPackage("Package1").getAppliedProfile("Profile::Nested1");
		final Profile nested2 = model.getNestedPackage("Package2").getAppliedProfile("Profile::Nested2");

		return houseKeeper.cleanUpLater(new StereotypeApplicationRepairSnippet(null, new Function<EPackage, Profile>() {

			@Override
			public Profile apply(EPackage input) {
				Profile result = null;

				// Check starts-with to account for _1, _2, etc. suffixes
				if (input.getNsPrefix().startsWith("Nested2")) {
					result = nested2;
				} else if (input.getNsPrefix().startsWith("Nested1")) {
					result = nested1;
				} else if (input.getNsPrefix().startsWith("Profile")) {
					result = rootProfile;
				}

				return result;
			}
		}), "dispose", modelSet.getResourceSet());
	}

	@Bug("436666")
	protected StereotypeApplicationRepairSnippet createBug436666Fixture() {
		final Profile rootProfile = model.getAppliedProfile("Profile");
		final Profile nestedProfile = model.getAppliedProfile("Profile::Profile1");

		return houseKeeper.cleanUpLater(new StereotypeApplicationRepairSnippet(null, new Function<EPackage, Profile>() {

			@Override
			public Profile apply(EPackage input) {
				Profile result = null;

				// Check starts-with to account for _1, _2, etc. suffixes
				if (input.getNsPrefix().startsWith("Profile1")) {
					result = nestedProfile;
				} else if (input.getNsPrefix().startsWith("Profile")) {
					result = rootProfile;
				}

				return result;
			}
		}), "dispose", modelSet.getResourceSet());
	}

	@Bug({ "436666bis", "455248", "455329" })
	protected StereotypeApplicationRepairSnippet createSimpleFixture() {
		return houseKeeper.cleanUpLater(new StereotypeApplicationRepairSnippet(null, Functions.constant((Profile) null)), "dispose", modelSet.getResourceSet());
	}

	@Bug("458736")
	protected StereotypeApplicationRepairSnippet createPresenterFixture() {
		TestPresenter presenter = houseKeeper.setField("presenter", new TestPresenter());
		return houseKeeper.cleanUpLater(new StereotypeApplicationRepairSnippet(Functions.constant(presenter)), "dispose", modelSet.getResourceSet());
	}

	@Bug("459488")
	protected StereotypeApplicationRepairSnippet createLocalProfileFixture() throws CoreException {
		// Get the profile to supply for repairing
		URI profileURI = null;
		for (IFile next : Iterables.filter(Arrays.asList(modelSet.getProject().getProject().members()), IFile.class)) {
			if (next.getName().endsWith(".profile.uml")) {
				// This looks like our "local profile"
				profileURI = URI.createPlatformResourceURI(next.getFullPath().toString(), true);
				break;
			}
		}
		assertThat("No profile resource found in test project", profileURI, notNullValue());
		Profile profile = UML2Util.load(modelSet.getResourceSet(), profileURI, UMLPackage.Literals.PROFILE);

		// And set up a presenter to enable incremental repair as resources are loaded
		TestPresenter presenter = houseKeeper.setField("presenter", new TestPresenter());

		return houseKeeper.cleanUpLater(new StereotypeApplicationRepairSnippet(Functions.constant(presenter), Functions.constant(profile)), "dispose", modelSet.getResourceSet());
	}

	void repair(final IAdaptable schema, final IRepairAction action) {
		try {
			TransactionHelper.run(modelSet.getEditingDomain(), new Runnable() {

				@Override
				public void run() {
					zombies.repair(schema, action, null, null);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			fail("Failed to run repair action: " + e.getLocalizedMessage());
		}
	}

	IAdaptable getOnlyZombieSchema() {
		assertThat("No zombie packages found", zombies, notNullValue());
		Collection<? extends IAdaptable> schemata = zombies.getZombieSchemas();
		assertThat("Wrong number of zombie packages", schemata.size(), is(1));
		return schemata.iterator().next();
	}

	void resolveSubunitsAndWaitForAsyncAnalysis() throws InterruptedException {
		// The transaction context is crucial for ensuring asynchronous calculation of zombies because
		// our test presenter relies on runExclusive for mutual exclusion
		modelSet.getEditingDomain().runExclusive(new Runnable() {

			@Override
			public void run() {
				// Ensure that we don't get a false positive
				zombies = null;

				// Make sure the sub-units aren't loaded
				for (Resource next : Iterables.filter(modelSet.getResourceSet().getResources(), Predicates.not(Predicates.equalTo(modelSet.getModelResource())))) {
					next.unload();
				}

				// Forget about any read-only resource states before loading again
				readonly.clearCache();

				EcoreUtil.resolveAll(modelSet.getResourceSet());
			}
		});

		// Wait for the asynchronous analysis to finish
		Synchronizer sync = new Synchronizer();
		presenter.asyncAddZombies(sync);
		sync.await();
	}

	//
	// Nested types
	//

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	private @interface Bug {
		String[] value();
	}

	class TestPresenter implements IZombieStereotypePresenter {

		private ExecutorService executor;

		@Override
		public void dispose() {
			if (executor != null) {
				executor.shutdown();
				executor = null;
			}
		}

		@Override
		public Function<? super EPackage, Profile> getDynamicProfileSupplier() {
			return Functions.constant((Profile) null);
		}

		@Override
		public void addZombies(ZombieStereotypesDescriptor zombies) {
			// Not much of a presentation!
			StereotypeRepairRegressionTest.this.zombies = zombies;
		}

		@Override
		public void asyncAddZombies(final Runnable runnable) {
			if (executor == null) {
				executor = Executors.newSingleThreadExecutor();
			}

			Runnable transactionWrapper = new Runnable() {

				@Override
				public void run() {
					try {
						modelSet.getEditingDomain().runExclusive(runnable);
					} catch (InterruptedException e) {
						fail("Test interrupted");
					}
				}
			};

			executor.execute(transactionWrapper);
		}

		@Override
		public boolean isPending() {
			// We never actually engage a repair session
			return false;
		}

		@Override
		public void awaitPending(boolean expected) throws InterruptedException {
			// Pass
		}

		@Override
		public void onPendingDone(Runnable runnable) {
			// Never pending, so do it now
			runnable.run();
		}
	}

	private static class Synchronizer implements Runnable {
		private final CountDownLatch latch = new CountDownLatch(1);

		@Override
		public void run() {
			latch.countDown();
		}

		void await() throws InterruptedException {
			latch.await();
		}
	}
}
