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
 * CEA LIST- Initial API and implementation
 * Nizar GUEDIDI (CEA LIST)- modification
 *
 ****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.part;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.PapyrusDiagramEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCompartmentSemanticEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.policy.CustomDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PasteEditPolicy;


/**
 * 
 * @Generated NOT //change the super class
 */
public class RequirementDiagramEditPart extends PapyrusDiagramEditPart {




	public RequirementDiagramEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new DefaultCreationEditPolicy());
		installEditPolicy(PasteEditPolicy.PASTE_ROLE, new PasteEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultCompartmentSemanticEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDragDropEditPolicy());
	}
}
