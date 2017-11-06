/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.parts.StateEditPart;

public class CustomStateEditPart extends StateEditPart {

	public CustomStateEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);

	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#getDefaultCornerHeight()
	 *
	 * @return
	 */
	@Override
	protected int getDefaultCornerHeight() {
		return 20;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.RoundedCompartmentEditPart#getDefaultCornerWidth()
	 *
	 * @return
	 */
	@Override
	protected int getDefaultCornerWidth() {
		return 20;
	}

	/**
	 * obtain the state compartment view when the view of the state is given.
	 * 
	 * @param stateView
	 *            the view of the state
	 * @return the view representing the state compartment
	 */
	public static View getStateCompartmentView(View stateView) {
		for (Object viewObj : stateView.getChildren()) {
			if (viewObj instanceof View) {
				View view = (View) viewObj;
				if (view.getType().equals("" + StateCompartmentEditPart.VISUAL_ID)) { //$NON-NLS-1$
					return view;
				}
			}
		}
		return null;
	}
}
