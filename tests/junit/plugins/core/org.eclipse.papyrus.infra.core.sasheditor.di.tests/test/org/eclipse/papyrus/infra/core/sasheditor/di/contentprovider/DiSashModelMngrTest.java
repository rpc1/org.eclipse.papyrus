/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 */
public class DiSashModelMngrTest extends AbstractPapyrusTest {

	/**
	 * A fake factory for testing.
	 */
	protected IPageModelFactory fakeModelFactory;

	/**
	 * @see junit.framework.TestCase#setUp()
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fakeModelFactory = new FakeModelFactory();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 *
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//Nothing
	}

	protected Resource createDiSashModelResource() {
		// Create di resource
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(new File("tempfile.di").getAbsolutePath());

		Resource diResource = resourceSet.createResource(fileURI);
		return diResource;
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr#DiSashModelMngr(org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory)}
	 * .
	 */
	@Test
	public void testDiSashModelMngrIPageModelFactory() {

		DiSashModelMngr modelMngr = new DiSashModelMngr(fakeModelFactory);

		assertNotNull("retrieve ContentProvider", modelMngr.getISashWindowsContentProvider());
		assertNotNull("retrieve PageMngr", modelMngr.getIPageMngr());
		assertNotNull("model created", modelMngr.getDiSashWindowsMngr());
		assertNotNull("default folder is set", modelMngr.getDiSashWindowsMngr().getSashModel().getCurrentSelection());
		//
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr#DiSashModelMngr(org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory, org.eclipse.emf.ecore.resource.Resource)}
	 * .
	 */
	@Test
	public void testDiSashModelMngrIPageModelFactoryResource() {
		Resource resource = createDiSashModelResource();

		DiSashModelMngr modelMngr = new DiSashModelMngr(fakeModelFactory, resource);

		assertNotNull("retrieve ContentProvider", modelMngr.getISashWindowsContentProvider());
		assertNotNull("retrieve PageMngr", modelMngr.getIPageMngr());
		assertNotNull("model created", modelMngr.getDiSashWindowsMngr());
		assertNotNull("default folder is set", modelMngr.getDiSashWindowsMngr().getSashModel().getCurrentSelection());
		assertNotNull("event provider is created", modelMngr.getSashModelContentChangedProvider());
		// Check resource

		assertNotNull("model attached to resource", lookupSashModel(resource));

	}


	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr#DiSashModelMngr(org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory, org.eclipse.papyrus.sashwindows.di.DiSashModel)}
	 * .
	 */
	@Test
	public void testDiSashModelMngrIPageModelFactoryDiSashModel() {
		SashWindowsMngr diSashModel = DiUtils.createDefaultSashWindowsMngr();

		DiSashModelMngr modelMngr = new DiSashModelMngr(fakeModelFactory, diSashModel);

		assertNotNull("retrieve ContentProvider", modelMngr.getISashWindowsContentProvider());
		assertNotNull("retrieve PageMngr", modelMngr.getIPageMngr());
		assertNotNull("model created", modelMngr.getDiSashWindowsMngr());
		assertNotNull("default folder is set", modelMngr.getDiSashWindowsMngr().getSashModel().getCurrentSelection());
		assertNotNull("event provider is created", modelMngr.getSashModelContentChangedProvider());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr#getIPageMngr()}.
	 */
	@Test
	public void testGetIPageMngr() {
		DiSashModelMngr modelMngr = new DiSashModelMngr(fakeModelFactory);

		assertNotNull("retrieve PageMngr", modelMngr.getIPageMngr());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.DiSashModelMngr#getISashWindowsContentProvider()}.
	 */
	@Test
	public void testGetISashWindowsContentProvider() {
		DiSashModelMngr modelMngr = new DiSashModelMngr(fakeModelFactory);

		assertNotNull("retrieve ContentProvider", modelMngr.getISashWindowsContentProvider());
	}

	/**
	 * Lookup for the SashModel object in the resource
	 *
	 * @param diResource
	 * @return
	 */
	private SashWindowsMngr lookupSashModel(Resource diResource) {

		return DiUtils.lookupSashWindowsMngr(diResource);
	}

}
