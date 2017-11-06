/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.tests.suites;

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorForSources;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromFlowPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromFlowPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromFlowPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromFlowPortOnSubNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromPortOnBlock;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromPortOnNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromPortOnPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromPortOnSubNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromSubNestedActorPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromSubNestedPart;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromSubNestedProperty;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromSubNestedReference;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromSubNestedValue;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.link.connector.TestLinkCreationConnectorFromValue;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	
	TestLinkCreationConnectorForSources.class,

	// test from port
	TestLinkCreationConnectorFromPortOnBlock.class,
	TestLinkCreationConnectorFromPortOnPart.class,
	TestLinkCreationConnectorFromPortOnNestedPart.class,
	TestLinkCreationConnectorFromPortOnSubNestedPart.class,
	
	// test from flowport
	TestLinkCreationConnectorFromFlowPortOnBlock.class,
	TestLinkCreationConnectorFromFlowPortOnPart.class,
	TestLinkCreationConnectorFromFlowPortOnNestedPart.class,
	TestLinkCreationConnectorFromFlowPortOnSubNestedPart.class,
	
	// test from actor part
	TestLinkCreationConnectorFromActorPart.class,
	TestLinkCreationConnectorFromNestedActorPart.class,
	TestLinkCreationConnectorFromSubNestedActorPart.class,
	
	// test from part
	TestLinkCreationConnectorFromPart.class,
	TestLinkCreationConnectorFromNestedPart.class,
	TestLinkCreationConnectorFromSubNestedPart.class,
	
	// test from property
	TestLinkCreationConnectorFromProperty.class,
	TestLinkCreationConnectorFromNestedProperty.class,
	TestLinkCreationConnectorFromSubNestedProperty.class,
	
	// test from reference
	TestLinkCreationConnectorFromReference.class,
	TestLinkCreationConnectorFromNestedReference.class,
	TestLinkCreationConnectorFromSubNestedReference.class,
	
	// test from value
	TestLinkCreationConnectorFromValue.class,
	TestLinkCreationConnectorFromNestedValue.class,
	TestLinkCreationConnectorFromSubNestedValue.class,
	
})
public class AllCreationConnectorTests {

}
