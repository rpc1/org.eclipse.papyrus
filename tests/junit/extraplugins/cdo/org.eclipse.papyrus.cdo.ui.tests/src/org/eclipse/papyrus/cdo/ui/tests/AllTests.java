/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 443830
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.ui.tests;

import org.eclipse.papyrus.cdo.internal.ui.editors.tests.BasicEditorTest;
import org.eclipse.papyrus.cdo.internal.ui.editors.tests.DawnEditorAdapterTest;
import org.eclipse.papyrus.cdo.internal.ui.markers.tests.CDOPapyrusMarkerTest;
import org.eclipse.papyrus.cdo.internal.ui.markers.tests.ModelValidationMarkersTest;
import org.eclipse.papyrus.cdo.internal.ui.views.tests.ItemProviderFilterRegistryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * This is the AllTests type. Enjoy.
 */
@RunWith(Suite.class)
@SuiteClasses({ BasicEditorTest.class, DawnEditorAdapterTest.class, //
		ModelValidationMarkersTest.class, CDOPapyrusMarkerTest.class, //
		ItemProviderFilterRegistryTest.class })
public class AllTests {

	public AllTests() {
		super();
	}

}
