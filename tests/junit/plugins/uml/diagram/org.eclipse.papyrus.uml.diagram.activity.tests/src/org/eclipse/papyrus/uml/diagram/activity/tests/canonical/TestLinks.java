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

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.AcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ActivityParameterNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.BroadcastSignalActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ControlFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CreateLinkActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InitialNodeEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.InputPinInCreateLinkActionAsInputValueEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ObjectFlowEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OpaqueActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInAcceptEventActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.OutputPinInOpaqueActEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReadExtentActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ReduceActionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.ValuePinInReduceActionAsCollectionEditPart;
import org.eclipse.papyrus.uml.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.activity.tests.IActivityDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.junit.Assert;
import org.junit.Test;

public class TestLinks extends AbstractPapyrusTestCase {

	@Override
	protected String getProjectName() {
		return IActivityDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IActivityDiagramTestsConstants.FILE_NAME;
	}

	protected Command createLinkCommand(IGraphicalEditPart start, IGraphicalEditPart end, IElementType type) {
		List<IElementType> types = new LinkedList<IElementType>();
		types.add(type);

		AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
				new AspectUnspecifiedTypeConnectionTool(types).
				new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

		req.setSourceEditPart(start);
		req.setType((RequestConstants.REQ_CONNECTION_START));

		Command startCommand = start.getCommand(req);
		Assert.assertNotNull(startCommand);

		req.setStartCommand(startCommand);

		req.setTargetEditPart(end);
		req.setType(RequestConstants.REQ_CONNECTION_END);

		Command endCommand = end.getCommand(req);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());
		return endCommand;
	}

	protected void doReconnect(ReconnectRequest req) {
		Command reorientCommand = req.getTarget().getCommand(req);
		Assert.assertNotNull(reorientCommand);
		Assert.assertTrue(reorientCommand.canExecute());

		executeOnUIThread(reorientCommand);
	}

	@Test
	public void testNoExecutableNodeFlowLink() {
		IGraphicalEditPart acceptEventActionEP = createChild(AcceptEventActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart outputPinInAcceptEventAction = createChild(OutputPinInAcceptEventActionEditPart.VISUAL_ID, acceptEventActionEP);

		IGraphicalEditPart reduceActionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());

		List<IElementType> types = new LinkedList<IElementType>();
		types.add(UMLElementTypes.ObjectFlow_4003);

		AspectUnspecifiedTypeConnectionTool.CreateAspectUnspecifiedTypeConnectionRequest req =
				new AspectUnspecifiedTypeConnectionTool(types).
				new CreateAspectUnspecifiedTypeConnectionRequest(types, false, getDiagramEditPart().getDiagramPreferencesHint());

		req.setSourceEditPart(outputPinInAcceptEventAction);
		req.setType((RequestConstants.REQ_CONNECTION_START));

		Command startCommand = outputPinInAcceptEventAction.getCommand(req);
		Assert.assertNotNull(startCommand);

		req.setStartCommand(startCommand);

		req.setTargetEditPart(reduceActionEP);
		req.setType(RequestConstants.REQ_CONNECTION_END);

		Command endCommand = reduceActionEP.getCommand(req);
		Assert.assertNull(endCommand);
	}

	@Test
	public void testCreateObjectFlowLinkFromPinToPin() {
		IGraphicalEditPart acceptEventActionEP = createChild(AcceptEventActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart outputPinInAcceptEventAction = createChild(OutputPinInAcceptEventActionEditPart.VISUAL_ID, acceptEventActionEP);

		IGraphicalEditPart reduceActionEP = createChild(ReduceActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart inputPinInReduceAction = createChild(ValuePinInReduceActionAsCollectionEditPart.VISUAL_ID, reduceActionEP);

		Command endCommand = createLinkCommand(outputPinInAcceptEventAction, inputPinInReduceAction, UMLElementTypes.ObjectFlow_4003);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart objectFlowConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(objectFlowConnection instanceof ObjectFlowEditPart);
	}

	@Test
	public void testCreateControlFlowLink() {
		IGraphicalEditPart initialNodeEP = createChild(InitialNodeEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart readExtentctionEP = createChild(ReadExtentActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());

		Command endCommand = createLinkCommand(initialNodeEP, readExtentctionEP, UMLElementTypes.ControlFlow_4004);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart controlFlowConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(controlFlowConnection instanceof ControlFlowEditPart);
	}

	@Test
	public void testObjectFlowLinkReorient() {
		IGraphicalEditPart parameterNodeEP = createChild(ActivityParameterNodeEditPart.VISUAL_ID, (IGraphicalEditPart)getActivityCompartmentEditPart().getParent());
		IGraphicalEditPart opaqueEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());

		IGraphicalEditPart createLinkACtionEP = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart newTargetEP = createChild(InputPinInCreateLinkActionAsInputValueEditPart.VISUAL_ID, createLinkACtionEP);

		Command endCommand = createLinkCommand(opaqueEP, parameterNodeEP, UMLElementTypes.ObjectFlow_4003);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart objectFlowConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(objectFlowConnection instanceof ObjectFlowEditPart);

		ObjectFlowEditPart objectFlowEP = (ObjectFlowEditPart)objectFlowConnection;

		ReconnectRequest reconnect = getReconnectRequest(newTargetEP, objectFlowEP, RequestConstants.REQ_RECONNECT_TARGET);

		Command reorientCommand = reconnect.getTarget().getCommand(reconnect);
		Assert.assertNotNull(reorientCommand);
		Assert.assertTrue(reorientCommand.canExecute());

		executeOnUIThread(reorientCommand);
		Assert.assertEquals(newTargetEP, objectFlowEP.getTarget());
	}

	@Test
	public void testObjectFlowLinkReorientSourceFromPinToAction() {
		IGraphicalEditPart opaqueEP = createChild(OpaqueActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart outputPinInOpaqueEP = createChild(OutputPinInOpaqueActEditPart.VISUAL_ID, opaqueEP);

		IGraphicalEditPart createLinkACtionEP = createChild(CreateLinkActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());

		Command endCommand = createLinkCommand(outputPinInOpaqueEP, opaqueEP, UMLElementTypes.ObjectFlow_4003);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart objectFlowConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(objectFlowConnection instanceof ObjectFlowEditPart);

		ObjectFlowEditPart objectFlowEP = (ObjectFlowEditPart)objectFlowConnection;

		ReconnectRequest reconnect = getReconnectRequest(createLinkACtionEP, objectFlowEP, RequestConstants.REQ_RECONNECT_SOURCE);

		Command reorientCommand = reconnect.getTarget().getCommand(reconnect);
		Assert.assertNotNull(reorientCommand);
		Assert.assertFalse(reorientCommand.canExecute());
	}

	@Test
	public void testControlFlowLinkReorient() {
		IGraphicalEditPart parameterNodeEP = createChild(ActivityParameterNodeEditPart.VISUAL_ID, (IGraphicalEditPart)getActivityCompartmentEditPart().getParent());
		IGraphicalEditPart broadCastSignalActionEP = createChild(BroadcastSignalActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());
		IGraphicalEditPart acceptEventActionEP = createChild(AcceptEventActionEditPart.VISUAL_ID, getActivityCompartmentEditPart());

		Command endCommand = createLinkCommand(parameterNodeEP, broadCastSignalActionEP, UMLElementTypes.ControlFlow_4004);
		Assert.assertNotNull(endCommand);
		Assert.assertTrue(endCommand.canExecute());

		executeOnUIThread(endCommand);
		Assert.assertEquals(1, getDiagramEditPart().getConnections().size());
		IGraphicalEditPart controlFlowConnection = (IGraphicalEditPart) getDiagramEditPart().getConnections().get(0);
		Assert.assertTrue(controlFlowConnection instanceof ControlFlowEditPart);

		ControlFlowEditPart controlFlowEP = (ControlFlowEditPart)controlFlowConnection;

		ReconnectRequest reconnectTarget = getReconnectRequest(acceptEventActionEP, controlFlowEP, RequestConstants.REQ_RECONNECT_TARGET);

		Command reorientTargetCommand = reconnectTarget.getTarget().getCommand(reconnectTarget);
		Assert.assertNotNull(reorientTargetCommand);
		Assert.assertTrue(reorientTargetCommand.canExecute());

		executeOnUIThread(reorientTargetCommand);
		Assert.assertEquals(acceptEventActionEP, controlFlowEP.getTarget());
		
		ReconnectRequest reconnectSource = getReconnectRequest(broadCastSignalActionEP, controlFlowEP, RequestConstants.REQ_RECONNECT_SOURCE);

		Command reorientSourceCommand = reconnectSource.getTarget().getCommand(reconnectSource);
		Assert.assertNotNull(reorientSourceCommand);
		Assert.assertTrue(reorientSourceCommand.canExecute());

		executeOnUIThread(reorientSourceCommand);
		Assert.assertEquals(acceptEventActionEP, controlFlowEP.getTarget());
	}

	protected ReconnectRequest getReconnectRequest(IGraphicalEditPart targetEP, ConnectionEditPart connectionEP, String reqType) {
		ReconnectRequest reconnect = new ReconnectRequest();
		reconnect.setTargetEditPart(targetEP);
		reconnect.setConnectionEditPart(connectionEP);
		reconnect.setType(reqType);
		return reconnect;
	}
}