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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.validation.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateSubtreeCommand;

/**
 * Handler for validating a subtree
 */
public class ValidateSubtreeHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		// not useful to cache command, since selected element may change
		EObject selectedElement = getSelectedElement();
		if (selectedElement == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new GMFtoEMFCommandWrapper(new ValidateSubtreeCommand(selectedElement, new EcoreDiagnostician()));
	}
}
