/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.CreateActivityDiagramCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.junit.Test;


public  class TestActivityAffixedChildNode extends AbstractTestActivityAffixedChildNode{

	
	/**
	 * Test to manageActivityParameterNode
	 */
	@Test
	public void testToManageActivityParameterNode() {
		testToManageChildNode(UMLElementTypes.ActivityParameterNode_3059,5);
	}

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new CreateActivityDiagramCommand();
	}

}