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
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.deployment.test.IDeploymentDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink.
 */
public class TestDeploymentDiagramLink extends TestLink {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateDeploymentDiagramCommand();
	}

	@Override
	protected String getProjectName() {
		return IDeploymentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IDeploymentDiagramTestsConstants.FILE_NAME;
	}
	
	/**
	 * Test to manage Dependency
	 */

	@Test
	@FailingTest
	public void testToManageDependency() {
		testToManageLink(UMLElementTypes.Node_2008, UMLElementTypes.Node_2008, UMLElementTypes.Dependency_4004, UMLElementTypes.Package_2009, true);
	}
	/**
	* Test to manage component.
	*/
	@Test
	@FailingTest
	public void testToManifestation() {
	testToManageLink(UMLElementTypes.Package_2009, UMLElementTypes.Package_2009, UMLElementTypes.Manifestation_4002, UMLElementTypes.Package_2009, true);
	}

}
