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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.assistant;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.adltool.command.SimpleFeaturesArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.wizard.FeatureArchitectureWizard;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForHandlers;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


/**
 * this handler is used to generate the feature and plugin architecture from workspace
 *
 * @deprecated
 */
@Deprecated
public class ModelFeatureArchitectureFromWorkspaceHandler extends ADLToolAbstractHandler {

	/**
	 *
	 * Constructor.
	 *
	 */
	public ModelFeatureArchitectureFromWorkspaceHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Element selectedElement = getSelection();
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForHandlers.getInstance().getServiceRegistry(event);
		} catch (ServiceException e1) {
			e1.printStackTrace();
		}
		ModelSet modelSet;
		try {
			modelSet = registry.getService(ModelSet.class);
		} catch (ServiceException e) {
			throw new ExecutionException("Can't get ModelSet", e);
		}
		FeatureArchitectureWizard bWizard = new FeatureArchitectureWizard(true);
		WizardDialog wizardDialog = new WizardDialog(new Shell(), bWizard);
		if (wizardDialog.open() == Window.OK) {
			TransactionalEditingDomain dom = modelSet.getTransactionalEditingDomain();
			if (selectedElement instanceof Package) {
				SimpleFeaturesArchitectureSnapshotCommand comd = new SimpleFeaturesArchitectureSnapshotCommand(dom, (Package) selectedElement, bWizard.getSelectedBundle());
				dom.getCommandStack().execute(comd);
			}
		}


		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
