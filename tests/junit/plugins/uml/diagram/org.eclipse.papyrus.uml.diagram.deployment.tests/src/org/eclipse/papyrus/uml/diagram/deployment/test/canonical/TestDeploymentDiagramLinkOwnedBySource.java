/*****************************************************************************
 * Copyright (c) 2010, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 468646
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.deployment.CreateDeploymentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.deployment.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.deployment.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.deployment.test.IDeploymentDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLinkOwnedBySource;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink use to test link that are contained by the owner of the target and the source
 */
public class TestDeploymentDiagramLinkOwnedBySource extends TestLinkOwnedBySource {

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
	 * Test to manage Generalization
	 */
	@Test
	public void testToManageGeneralization() {
		testToManageLink(UMLElementTypes.Node_2008, UMLElementTypes.Node_2008, UMLElementTypes.Generalization_4003, UMLElementTypes.Package_2009, false);
	}
}
