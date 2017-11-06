/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelelements.tests;

import org.eclipse.papyrus.junit.framework.classification.tests.AbstractPapyrusTest;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsFactory;
import org.eclipse.papyrus.sysml.modelelements.Problem;
import org.junit.After;
import org.junit.Before;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Problem</b></em>'. <!--
 * end-user-doc -->
 *
 * @generated
 */
public class ProblemTest extends AbstractPapyrusTest {

	/**
	 * The fixture for this Problem test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Problem fixture = null;

	/**
	 * Returns the fixture for this Problem test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Problem getFixture() {
		return fixture;
	}

	/**
	 * Sets the fixture for this Problem test case.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected void setFixture(Problem fixture) {
		this.fixture = fixture;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Before
	public void setUp() throws Exception {
		setFixture(ModelelementsFactory.eINSTANCE.createProblem());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@After
	public void tearDown() throws Exception {
		setFixture(null);
	}

} // ProblemTest
