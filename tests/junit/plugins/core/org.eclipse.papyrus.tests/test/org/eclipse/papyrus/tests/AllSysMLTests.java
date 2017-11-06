/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 451230
 *
 *****************************************************************************/
package org.eclipse.papyrus.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.junit.framework.runner.AllTestsRunner;
import org.eclipse.papyrus.junit.framework.runner.FragmentTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.ITestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.PluginTestSuiteClass;
import org.eclipse.papyrus.junit.framework.runner.SuiteSpot;
import org.junit.runner.RunWith;

@RunWith(AllTestsRunner.class)
public class AllSysMLTests {

	@SuiteSpot
	public static final List<ITestSuiteClass> suiteClasses;

	static {
		suiteClasses = new ArrayList<ITestSuiteClass>();

		/* sysml */
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.tests.SysmlAllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.sysml.service.types.Activator.PLUGIN_ID, "org.eclipse.papyrus.sysml.service.types.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.modelexplorer.tests.suites.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass(org.eclipse.papyrus.sysml.diagram.internalblock.Activator.PLUGIN_ID, "org.eclipse.papyrus.sysml.diagram.internalblock.tests.suites.AllTests"));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.sysml.diagram.blockdefinition", "org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.diagram.requirement.test.AllTests.class));
		suiteClasses.add(new FragmentTestSuiteClass("org.eclipse.papyrus.sysml.diagram.parametric", "org.eclipse.papyrus.sysml.diagram.parametric.tests.suites.AllTests"));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.nattable.requirement.tests.tests.AllTests.class));
		suiteClasses.add(new PluginTestSuiteClass(org.eclipse.papyrus.sysml.nattable.allocation.tests.tests.AllTests.class));
	}
}
