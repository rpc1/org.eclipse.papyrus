/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.LabelSnapBackEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusLabelEditPart;

/**
 * This is an editpart in which we can access to the wrapping label for example
 * it can be use to display stereotype as external node
 */
public abstract class AbstractLabelEditPart extends PapyrusLabelEditPart implements IPapyrusEditPart {

	public AbstractLabelEditPart(View view) {
		super(view);
	}

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public IFigure getPrimaryShape() {
		return getFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SNAP_FEEDBACK_ROLE, new LabelSnapBackEditPolicyExt());
	}

	/**
	 * Overrides default {@link LabelSnapBackEditPolicy} with correct coordination
	 * between {@link #getCommand(Request)} and {@link #getTargetEditPart(Request)}.
	 * 
	 * @see bug 472023
	 */
	private static class LabelSnapBackEditPolicyExt extends LabelSnapBackEditPolicy {

		/**
		 * In contrast to the super-class, this edit-policy does NOT return the host EP as a target
		 * for those requests it does NOT understand.
		 *
		 * @param request
		 * @return
		 */
		@Override
		public EditPart getTargetEditPart(Request request) {
			return understandsRequest(request) ? getHost() : null;
		}

	}

}
