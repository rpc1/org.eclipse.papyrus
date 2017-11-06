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

package org.eclipse.papyrus.uml.diagram.statemachine.custom.helpers.advice;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;


public class PseudostateKindInitializerAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		if (false == request.getElementToConfigure() instanceof Pseudostate) {
			return null;
		}
		Pseudostate pseudo = (Pseudostate) request.getElementToConfigure();

		IElementType type = request.getTypeToConfigure();
		if (type == null) {
			return null;
		}

		PseudostateKind kind = getPseudostateKindForType(type);
		if (kind == null) {
			return null;
		}
		return new SetPseudostateKindCommand(kind, pseudo, request);
	}

	protected PseudostateKind getPseudostateKindForType(IElementType type) {
		List<IElementType> superTypes = Arrays.asList(type.getAllSuperTypes());
		if (UMLElementTypes.Pseudostate_8000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_8000)) {
			return PseudostateKind.INITIAL_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_9000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_9000)) {
			return PseudostateKind.JOIN_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_10000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_10000)) {
			return PseudostateKind.FORK_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_11000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_11000)) {
			return PseudostateKind.CHOICE_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_12000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_12000)) {
			return PseudostateKind.JUNCTION_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_13000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_13000)) {
			return PseudostateKind.SHALLOW_HISTORY_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_14000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_14000)) {
			return PseudostateKind.DEEP_HISTORY_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_15000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_15000)) {
			return PseudostateKind.TERMINATE_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_16000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_16000)) {
			return PseudostateKind.ENTRY_POINT_LITERAL;
		}
		if (UMLElementTypes.Pseudostate_17000.equals(type) || superTypes.contains(UMLElementTypes.Pseudostate_17000)) {
			return PseudostateKind.EXIT_POINT_LITERAL;
		}
		return null;
	}

	private static class SetPseudostateKindCommand extends ConfigureElementCommand {

		private final PseudostateKind myKind;

		protected SetPseudostateKindCommand(PseudostateKind kind , EObject elementToEdit, ConfigureRequest request) {
			super(request);
			myKind = kind;
		}

		@Override
		public boolean canExecute() {
			if (false == getElementToEdit() instanceof Pseudostate) {
				return false;
			}
			if (myKind == null) {
				return false;
			}
			return super.canExecute();
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if (!canExecute()) {
				return CommandResult.newErrorCommandResult("Command can't be executed");
			}
			Pseudostate pseudo = (Pseudostate) getElementToEdit();
			pseudo.setKind(myKind);

			// we have to reset initialized name because it depends on kind
			//reset old name
			String oldName = pseudo.getName();
			pseudo.setName(null);
			
			String initializedName = NamedElementUtil.getDefaultNameWithIncrement(pseudo, pseudo.eContainer().eContents());
			initializedName = initializedName != null ? initializedName : oldName;
			pseudo.setName(initializedName);
			return CommandResult.newOKCommandResult();
		}
	}
}