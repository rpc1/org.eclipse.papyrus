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

package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultCreationEditPolicy;
import org.eclipse.papyrus.uml.service.types.helper.ActivityNodeHelper;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;


/**
 * Class provide extended reparent command in case drag&drop from ActivityPartition 
 * or InterruptibleActivityRegion
 */
public class ActivityCompartmentCreationEditPolicy extends DefaultCreationEditPolicy{

	/**
	 * Set in moveRequest additional parameters then reparent from ActivityPartition
	 * or InterruptibleActivityRegion
	 */
	@Override
	protected ICommand getReparentCommand(IGraphicalEditPart gep) {
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label); 
		View container = (View)getHost().getModel();
		EObject context = ViewUtil.resolveSemanticElement(container);
		View view = (View)gep.getModel();
		EObject element = ViewUtil.resolveSemanticElement(view);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();

		// semantic
		if ( element != null ) {
			MoveRequest req = new MoveRequest(editingDomain, context, element);
			EObject currentParentSemantic = ((IGraphicalEditPart)gep.getParent()).resolveSemanticElement();
			if (currentParentSemantic instanceof ActivityPartition) {
				req.setParameter(ActivityNodeHelper.OUT_FROM_PARTITION, currentParentSemantic);
			}
			if (currentParentSemantic instanceof InterruptibleActivityRegion) {
				req.setParameter(ActivityNodeHelper.OUT_FROM_INTERRUPTIBLE_REGION, currentParentSemantic);
			}
			Command moveSemanticCmd = 
				getHost().getCommand(
					new EditCommandRequestWrapper(req));

			
			if (moveSemanticCmd == null) {
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}
			
			cc.compose ( new CommandProxy(moveSemanticCmd) );
		}
		//
		// notation
		cc.compose(getReparentViewCommand(gep));
		return cc;
	}

}
