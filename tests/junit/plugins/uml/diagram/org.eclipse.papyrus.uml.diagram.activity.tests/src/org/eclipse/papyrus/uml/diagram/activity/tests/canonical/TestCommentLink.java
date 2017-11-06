/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CommentEditPartCN;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CommentLinkEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.junit.Assert;
import org.junit.Test;


public class TestCommentLink extends AbstractPapyrusTestCase {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}

	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}

	@Test
	public void testToCreateCommentLink() {
		IGraphicalEditPart opaque = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart comment = createChild(CommentEditPartCN.VISUAL_ID, getActivityCompartmentEditPart());

		List<IElementType> types = new LinkedList<IElementType>();
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);

		AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
				new AspectUnspecifiedTypeConnectionTool(types).
				new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

		req.setSourceEditPart(comment);
		req.setType((RequestConstants.REQ_CONNECTION_START));

		Command startCommand = comment.getCommand(req);
		Assert.assertNotNull(startCommand);

		req.setStartCommand(startCommand);

		req.setTargetEditPart(opaque);
		req.setType(RequestConstants.REQ_CONNECTION_END);

		Command endCommand = opaque.getCommand(req);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart commentConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(commentConnection instanceof CommentLinkEditPart);
	}
}
