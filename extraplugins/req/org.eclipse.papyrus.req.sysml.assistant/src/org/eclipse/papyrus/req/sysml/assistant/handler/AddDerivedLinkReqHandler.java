/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Patrick Tessier (patrick.tessier@cea.fr) CEA LIST. - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.req.sysml.assistant.handler;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.req.sysml.assistant.command.AddDerivedLinkReqCommand;
import org.eclipse.papyrus.req.sysml.assistant.command.DerivationReqCreateCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Executes the addition of DerivedReqt links
 *
 */
public class AddDerivedLinkReqHandler extends PapyrusAbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		super.execute(event);
		ArrayList<Element> selectedElements = getSelectionSet();
		if (selectedElements.size() == 2) {
			DerivationReqCreateCommand addDerivedLinkReqCommand = new DerivationReqCreateCommand(
					transactionalEditingDomain, (NamedElement) selectedElements.get(1),
					(NamedElement) selectedElements.get(0));
			transactionalEditingDomain.getCommandStack().execute(addDerivedLinkReqCommand);
		} else {

			Element selectedElement = getSelection();
			if (selectedElement != null) {
				AddDerivedLinkReqCommand addDerivedLinkReqCommand = new AddDerivedLinkReqCommand(
						transactionalEditingDomain, selectedElement);
				transactionalEditingDomain.getCommandStack().execute(addDerivedLinkReqCommand);
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return true if the handler is possible
	 */
	@Override
	public boolean isEnabled() {
		Element selectedElement = getSelection();
		if (selectedElement != null) {
			return true;
		} else {
			return false;
		}
	}

}