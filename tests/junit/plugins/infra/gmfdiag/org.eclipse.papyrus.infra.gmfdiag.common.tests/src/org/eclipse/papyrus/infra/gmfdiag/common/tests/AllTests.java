/*
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus (CEA) - initial API and implementation
 *  Christian W. Damus - bug 465416
 */
package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import org.eclipse.papyrus.infra.gmfdiag.common.sync.tests.SyncTests;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Master test suite for this test fragment.
 */
@RunWith(Suite.class)
@SuiteClasses({
		// {oep.commands}
		LoadExpansionModel.class,
		ExpansionAddCompartment.class,
		ExpansionAddChildLabel.class,
		ExpansionAddBorderItem.class,
		ExpansionAddCompartmentWithKind.class,
		ExpansionAddLink.class,
		ExpansionDropElements.class,
		AssistantUsage.class,
		GMFUnsafeTest.class,
		SyncTests.class
})
public class AllTests {

}
