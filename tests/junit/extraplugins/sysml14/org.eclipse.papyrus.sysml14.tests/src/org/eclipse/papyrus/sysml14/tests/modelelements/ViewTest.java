/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 422257
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.tests.modelelements;

import static org.junit.Assert.fail;

import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.junit.utils.rules.HouseKeeper;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml14.modelelements.View;
import org.eclipse.papyrus.sysml14.modelelements.ViewPoint;
import org.eclipse.papyrus.sysml14.tests.SysMLTestResources;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * A test case for the model object '<em><b>View</b></em>'.
 * <p>
 * The following features are tested:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.View#getViewPoint() <em>View Point</em>}</li>
 * </ul>
 * </p>
 */
public class ViewTest extends AbstractPapyrusTest {

	@Rule
	public final HouseKeeper houseKeeper = new HouseKeeper();
	
	protected View fixture = null;

	protected Package p0 = null;

	protected Package p1 = null;

	protected Class c1 = null;

	protected ViewPoint vp1 = null;

	protected View v0 = null;

	protected View v1 = null;

	protected Model model = null;

	/**
	 * Returns the fixture for this View test case.
	 */
	protected View getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this View test case.
	 */
	protected void setFixture(View fixture) {
		this.fixture = fixture;
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		setFixture(ModelelementsFactory.eINSTANCE.createView());

		// Prepare test
		model = SysMLTestResources.createSysMLModel(houseKeeper.createResourceSet());
		if(model == null) {
			fail();
		}

		if(model.getAppliedProfiles().isEmpty()) {
			fail();
		}

		// Create packages
		p0 = model.createNestedPackage("p0");
		p1 = model.createNestedPackage("p1");

		// Create classes
		c1 = model.createOwnedClass("c1", false);

		// Add View stereotype

		v0 = (View)StereotypeApplicationHelper.INSTANCE.applyStereotype(p0, ModelelementsPackage.eINSTANCE.getView());
		v1 = (View)StereotypeApplicationHelper.INSTANCE.applyStereotype(p1, ModelelementsPackage.eINSTANCE.getView());

		// Add ViewPoint stereotype
		vp1 = (ViewPoint)StereotypeApplicationHelper.INSTANCE.applyStereotype(c1, ModelelementsPackage.eINSTANCE.getViewPoint());

		// Add Abstractions with allocate stereotype
		// v1 (p1) -> vp1 (c1)
		Abstraction v1_vp1 = UMLFactory.eINSTANCE.createAbstraction();
		v1_vp1.getClients().add(p1);
		v1_vp1.getSuppliers().add(c1);
		model.getPackagedElements().add(v1_vp1);

		StereotypeApplicationHelper.INSTANCE.applyStereotype(v1_vp1, ModelelementsPackage.eINSTANCE.getConform());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 * <em>View Point</em>}' feature getter. 
	 * @see org.eclipse.papyrus.sysml.modelelements.View#getViewPoint()
	 */
	@Test
	public void testGetViewPoint() {

		// Verifies : v0.getViewPoint = []
		if(v0.getViewPoint() != null) {
			fail();
		}

		// Verifies : v1.getViewPoint = vp1
		if(!v1.getViewPoint().equals(vp1)) {
			fail();
		}
	}

}
