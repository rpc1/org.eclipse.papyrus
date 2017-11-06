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

package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.uml2.uml.Constraint;

/**
 * Custom context link semantic edit policy that provides removing a context from constrained element
 * during delete/hide context link command
 */
public class ContextLinkSemanticEditPolicy extends DefaultSemanticEditPolicy {

	@Override
	public Command getCommand(Request request) {
		if (isContextLinkHideRequest(request)) {
			EObject context = ViewUtil.resolveSemanticElement(((Edge) getHost().getModel()).getSource());
			EObject referenceObject = resolveSemanticElement(getHost().getParent());
			DestroyReferenceRequest req = new DestroyReferenceRequest(((IGraphicalEditPart) getHost()).getEditingDomain(), context, null, referenceObject, false);
			return getSemanticCommand(req);
		}
		return super.getCommand(request);
	}

	@Override
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		EObject context = req.getContainer();
		return super.getDestroyReferenceCommand(req, context);
	}

	@Override
	protected IEditCommandRequest completeRequest(IEditCommandRequest request) {
		return request;
	}

	private boolean isContextLinkHideRequest(Request request) {
		if (!REQ_DELETE.equals(request.getType())) {
			return false;
		}
		View hostView = ((IGraphicalEditPart) getHost()).getNotationView();
		if (false == hostView instanceof Connector) {
			return false;
		}
		EObject hostElement = ((IGraphicalEditPart) getHost()).resolveSemanticElement();
		EObject sourceElement = ((Connector) hostView).getSource().getElement();
		return hostElement == null && sourceElement instanceof Constraint;
	}

	private EObject resolveSemanticElement(EditPart editPart) {
		if (editPart == null) {
			return null;
		}
		if (editPart instanceof RootEditPart) {
			return ViewUtil.resolveSemanticElement((View) ((RootEditPart) editPart).getContents().getModel());
		}
		return ((IGraphicalEditPart) editPart).resolveSemanticElement();
	}

}
