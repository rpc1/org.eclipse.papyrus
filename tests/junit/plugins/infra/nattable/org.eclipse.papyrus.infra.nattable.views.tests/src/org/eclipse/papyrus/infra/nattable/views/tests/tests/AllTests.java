/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Quentin Le Menez (CEA LIST) quentin.lemenez@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.views.tests.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RevealViewsTableTest.class, TableCreationTest.class, OpenTableTest.class, TableVerifyContents.class, TableCreationTest2.class })
public class AllTests {

	// JUnit 4 test suite

	/** The type of the requirement table */
	public static final String VIEWS_TABLE_ID = "PapyrusViewsTable"; //$NON-NLS-1$

	/** the creation command tested for the requirement table */
	public static final String COMMAND_ID = "org.eclipse.papyrus.infra.nattable.page.editor.create.withoutdialog.command"; //$NON-NLS-1$
}
