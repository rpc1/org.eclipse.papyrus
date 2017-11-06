/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand.NonDirtying;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.clipboard.PapyrusClipboard;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PastePreferencesPage;

/**
 * Command that puts a list of object in the clipboard
 */
public class DefaultDiagramCopyCommand extends AbstractOverrideableCommand implements NonDirtying {

	/** list of objects to put in the clipboard */
	private final Collection<Object> objectsToPutInClipboard;

	public Collection<Object> getObjectsToPutInClipboard() {
		return objectsToPutInClipboard;
	}

	/** old list of the clipboard, for undo */
	private Collection<Object> oldClipboardContent;

	/**
	 * Creates a new Command that set the new content of the clipboard
	 *
	 * @param domain
	 *            editing domain for which the clipboard is set.
	 */
	public DefaultDiagramCopyCommand(EditingDomain domain, PapyrusClipboard<Object> papyrusClipboard, Collection<IGraphicalEditPart> pObjectsToPutInClipboard) {
		super(domain);
		objectsToPutInClipboard = new ArrayList<Object>();
		Boolean keepReferences = Activator.getInstance().getPreferenceStore().getBoolean(PastePreferencesPage.KEEP_EXTERNAL_REFERENCES);
		EcoreUtil.Copier copier = new EcoreUtil.Copier(Boolean.TRUE, keepReferences);
		List<EObject> objectToCopy = new ArrayList<EObject>();

		if (pObjectsToPutInClipboard != null) {
			for (IGraphicalEditPart iGraphicalEditPart : pObjectsToPutInClipboard) {
				View notationView = iGraphicalEditPart.getNotationView();
				EObject element = notationView.getElement();
				objectToCopy.add(notationView);
				objectToCopy.add(element);
			}
		}

		List<EObject> filterDescendants = EcoreUtil.filterDescendants(objectToCopy);
		copier.copyAll(filterDescendants);
		copier.copyReferences();

		Map<EObject, Object> mapInternalCopyInClipboard = new HashMap<EObject, Object>();
		mapInternalCopyInClipboard.putAll(copier);
		papyrusClipboard.addAllInternalCopyInClipboard(mapInternalCopyInClipboard);


		if (pObjectsToPutInClipboard != null && !pObjectsToPutInClipboard.isEmpty()) {
			IGraphicalEditPart next = pObjectsToPutInClipboard.iterator().next();
			Diagram diagram = next.getNotationView().getDiagram();
			if(diagram != null){
				papyrusClipboard.setContainerType(diagram.getType());
			}
		}

	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doExecute() {
		oldClipboardContent = domain.getClipboard();
		domain.setClipboard(objectsToPutInClipboard);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doUndo() {
		domain.setClipboard(oldClipboardContent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doRedo() {
		domain.setClipboard(objectsToPutInClipboard);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean prepare() {
		return domain != null;
	}

}
