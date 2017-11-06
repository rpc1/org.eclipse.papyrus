/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.tests.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// testTopNodes
	TestCommunicationDiagramChildNode.class,
	TestCommunicationDiagramLink.class
})
public class AllCanonicalTests {

}
