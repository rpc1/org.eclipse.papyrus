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
 *  Christian W. Damus (CEA LIST) - add test for AdapterUtils
 *  Christian W. Damus (CEA) - bug 402525
 *  Christian W. Damus (CEA) - bug 422257
 *  Christian W. Damus (CEA) - bug 399859
 *  Christian W. Damus - bug 456934
 *  Christian W. Damus - bug 468030
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.tests;

import org.eclipse.papyrus.infra.core.contentoutline.NestedEditorDelegatedOutlinePageTest;
import org.eclipse.papyrus.infra.core.language.LanguageServiceTest;
import org.eclipse.papyrus.infra.core.lifecycleevents.LifeCycleEventsProviderTest;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResourceTest;
import org.eclipse.papyrus.infra.core.resource.ModelSetTest;
import org.eclipse.papyrus.infra.core.resource.NestingTransactionalCommandStackTest;
import org.eclipse.papyrus.infra.core.resource.ResourceAdapterTest;
import org.eclipse.papyrus.infra.core.services.ComposedServiceTest;
import org.eclipse.papyrus.infra.core.services.ServicesRegistryTest;
import org.eclipse.papyrus.infra.core.utils.AdapterUtilsTest;
import org.eclipse.papyrus.infra.core.utils.JobBasedFutureTest;
import org.eclipse.papyrus.infra.core.utils.JobExecutorServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({
		// {oep.resource}
		ModelSetTest.class, AbstractModelWithSharedResourceTest.class, NestingTransactionalCommandStackTest.class, ResourceAdapterTest.class,
		// {oep}.core.language
		LanguageServiceTest.class,
		// {oep}.core.services
		ComposedServiceTest.class, ServicesRegistryTest.class,
		// {oep}.core.lifecycleevents
		/* SaveAndDirtyServiceTest.class, */LifeCycleEventsProviderTest.class,
		NestedEditorDelegatedOutlinePageTest.class,
		// {oep}.core.utils
		AdapterUtilsTest.class, JobBasedFutureTest.class, JobExecutorServiceTest.class
})
/**
 * Suite Class for all tests in the plugin
 */
public class AllTests {
	// Junit 4 Test suite
}
