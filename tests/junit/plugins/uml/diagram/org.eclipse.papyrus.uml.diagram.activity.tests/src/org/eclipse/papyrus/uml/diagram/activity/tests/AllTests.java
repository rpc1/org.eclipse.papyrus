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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tests;

import org.eclipse.papyrus.uml.diagram.activity.tests.canonical.AllCanonicalTests;
import org.eclipse.papyrus.uml.diagram.activity.tests.edit.helper.ExpansionRegionHelperTest;
import org.eclipse.papyrus.uml.diagram.activity.tests.edit.part.ExpansionRegionCompartmentEPTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All tests together.
 */
@RunWith(Suite.class)
@SuiteClasses({
	// canonical
AllCanonicalTests.class,
ExpansionRegionHelperTest.class,
ExpansionRegionCompartmentEPTest.class

})
public class AllTests {

}
