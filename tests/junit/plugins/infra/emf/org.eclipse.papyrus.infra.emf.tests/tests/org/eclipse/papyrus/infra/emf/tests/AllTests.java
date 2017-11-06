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
 *   Christian W. Damus - bug 399859
 *   Christian W. Damus - bug 465416
 *
 */
package org.eclipse.papyrus.infra.emf.tests;

import org.eclipse.papyrus.infra.emf.advice.ReadOnlyObjectEditAdviceTest;
import org.eclipse.papyrus.infra.emf.edit.domain.PapyrusTransactionalEditingDomainTest;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndexTest;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * The test suite for the {@code org.eclipse.papyrus.infra.emf} plug-in.
 */
@RunWith(Suite.class)
@SuiteClasses({
		// oep.infra.emf.advice
		ReadOnlyObjectEditAdviceTest.class,
		// oep.infra.emf.edit.domain
		PapyrusTransactionalEditingDomainTest.class,
		// oep.infra.emf.utils
		ServiceUtilsForResourceTest.class,
		// oep.infra.emf.resource.index
		WorkspaceModelIndexTest.class
})
public class AllTests {

	public AllTests() {
		super();
	}

}
