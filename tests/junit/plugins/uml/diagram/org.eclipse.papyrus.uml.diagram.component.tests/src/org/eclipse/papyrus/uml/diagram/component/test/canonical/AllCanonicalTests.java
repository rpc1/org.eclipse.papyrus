/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.test.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// Top Node
TestComponentDiagramTopNode.class,
// Child Node
TestComponentDiagramPackageChildNode.class,
//child nodes in components
TestComponentDiagramComponentChildNode.class,
//child nodes in interface
TestComponentDiagramChildLabel.class,
// Link
TestComponentDiagramLink.class,
//Link owned by source 
TestComponentDiagramLinkOwnedBySource.class,
// CommentLink
TestComponentDiagramCommentLink.class,
// Constraint Link
TestComponentDiagramConstraintLink.class,
// List compartment duplicates
TestListCompartmentNodeChildDuplicates.class,
// List Compartment Illegal Elements
TestListCompartmentIllegalElements.class,
TestListCompartmentPropertiesOperationsDrop.class,
TestComponentDiagramConnector.class,
TestComponentDiagramPortLink.class,
TestPortLocation.class
// End
})
public class AllCanonicalTests {

}
