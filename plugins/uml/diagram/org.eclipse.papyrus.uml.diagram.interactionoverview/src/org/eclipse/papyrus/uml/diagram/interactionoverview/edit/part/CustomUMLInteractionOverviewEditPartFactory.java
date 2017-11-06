/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.activity.edit.part.CustomUMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.activity.edit.parts.CallBehaviorActionEditPart;

public class CustomUMLInteractionOverviewEditPartFactory extends CustomUMLEditPartFactory {

	@Override
	public EditPart createEditPart(final EditPart context, final Object model) {
		if (model instanceof View) {
			final View view = (View) model;
			int visualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view);
			if (visualID != -1) {
				switch (visualID) {
				case CustomActivityEditPartTN.VISUAL_ID:// 2001
					return new CustomActivityEditPartTN(view);
				case CallBehaviorActionEditPart.VISUAL_ID: // 3008
				case CustomInteractionUseEditPartCN.INTERACTIONUSE_VISUAL_ID:// 5005
					return new CustomInteractionUseEditPartCN(view);
				case CustomInteractionUseNameEditPart.VISUAL_ID:
					return new CustomInteractionUseNameEditPart(view);// 5004
				case CallBehaviorActionAsInteractionEditPart.INTERACTION_VISUAL_ID:
					return new CallBehaviorActionAsInteractionEditPart(view);// 5000
				default:
					// when adding cases to this switch, also add the corresponding
					// IDs in the extension
					// org.eclipse.gmf.runtime.diagram.ui.editpartProviders
				}
			} else {
				visualID = org.eclipse.papyrus.uml.diagram.activity.part.UMLVisualIDRegistry.getVisualID(view);
				switch (visualID) {
				case CallBehaviorActionAsInteractionEditPart.INTERACTION_VISUAL_ID:
					return new CallBehaviorActionAsInteractionEditPart(view);// 5000
				case CallBehaviorActionEditPart.VISUAL_ID: // 3008
				case CustomInteractionUseEditPartCN.INTERACTIONUSE_VISUAL_ID:// 5005
					return new CustomInteractionUseEditPartCN(view);
				default:
				}
			}
		}
		return super.createEditPart(context, model);
	}
}
