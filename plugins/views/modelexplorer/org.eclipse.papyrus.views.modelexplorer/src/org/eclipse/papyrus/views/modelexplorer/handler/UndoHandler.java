/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - bug 455305
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * Handler for the Undo Action
 *
 *
 *
 */
public class UndoHandler extends AbstractModelExplorerHandler {

	/**
	 *
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			domain.getCommandStack().undo();
		}
		return null;
	}

	/**
	 * @see org.eclipse.core.commands.AbstractHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		EditingDomain domain = getEditingDomain();
		if (domain != null) {
			setBaseEnabled(domain.getCommandStack().canUndo());
		} else {
			setBaseEnabled(false);
		}
	}

}
