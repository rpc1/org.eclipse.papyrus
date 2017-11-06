/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.wizards.GeneratorWizard;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.uml2.uml.Profile;

/**
 * @author damus
 *
 */
public class GenerateElementTypesHandler extends AbstractHandler {

	/**
	 * Constructor.
	 *
	 */
	public GenerateElementTypesHandler() {
		super();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection sselection = (IStructuredSelection) selection;
			if (!sselection.isEmpty()) {
				EObject eObject = EMFHelper.getEObject(sselection.getFirstElement());
				if (eObject instanceof Profile) {
					IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindowChecked(event).getActivePage();
					GeneratorWizard wizard = new GeneratorWizard(page, (Profile) eObject);
					WizardDialog dlg = new WizardDialog(HandlerUtil.getActiveShellChecked(event), wizard);
					dlg.open();
				}
			}
		}

		return null;
	}

}
