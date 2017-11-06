/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.services.tracepoints.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.tracepoints.commands.ToggleTracepointCommand;

/**
 * Handler for toggling a tracepoint. Delegates to associated command
 *
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ToggleTracepointHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		// not useful to cache command, since selected element may change
		return new GMFtoEMFCommandWrapper(new ToggleTracepointCommand(getSelectedElement()));
	}
}
