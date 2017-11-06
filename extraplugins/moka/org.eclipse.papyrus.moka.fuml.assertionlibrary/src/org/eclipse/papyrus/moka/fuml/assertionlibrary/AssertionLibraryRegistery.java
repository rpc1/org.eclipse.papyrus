/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.moka.fuml.assertionlibrary;

import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertEquals;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertFalse;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertList;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.basic.AssertTrue;
import org.eclipse.papyrus.moka.fuml.assertionlibrary.reporting.GenerateTestReport;
import org.eclipse.papyrus.moka.fuml.registry.AbstractOpaqueBehaviorExecutionRegistry;

public class AssertionLibraryRegistery extends AbstractOpaqueBehaviorExecutionRegistry {

	/**
	 * Declared Name of the registered library
	 */
	public final static String ASSERTION_LIBRARY = "AssertionLibrary";

	/**
	 * List of qualified names of model elements (OpaqueBehavior) representing assertions
	 */
	public final static String ASSERT_EQUALS = "AssertionLibrary::AssertEquals";

	public final static String ASSERT_FALSE = "AssertionLibrary::AssertFalse";

	public final static String ASSERT_TRUE = "AssertionLibrary::AssertTrue";

	public final static String ASSERT_LIST = "AssertionLibrary::AssertList";

	/**
	 * Qualified name of the OpaqueBehavior responsible for generating a test report"
	 */
	public final static String GENERATE_TEST_REPORT = "AssertionLibrary::GenerateTestReport";

	@Override
	/**
	 * Register OpaqueBehaviorExecution implementing the behaviors associated
	 * to OpaqueBehavior assertions
	 */
	public void registerOpaqueBehaviorExecutions(Locus locus) {
		this.locus = locus;
		this.buildOpaqueBehaviorsMap(ASSERTION_LIBRARY);
		this.registerOpaqueBehaviorExecution(new AssertEquals(), ASSERT_EQUALS);
		this.registerOpaqueBehaviorExecution(new AssertFalse(), ASSERT_FALSE);
		this.registerOpaqueBehaviorExecution(new AssertTrue(), ASSERT_TRUE);
		this.registerOpaqueBehaviorExecution(new AssertList(), ASSERT_LIST);
		this.registerOpaqueBehaviorExecution(new GenerateTestReport(), GENERATE_TEST_REPORT);
	}
}
