/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;


/**
 * The Class TestActivityDiagramLink use to test link that are contained by the owner of the target and the source
 */
public class TestActivityDiagramLink extends TestLink {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}
}
