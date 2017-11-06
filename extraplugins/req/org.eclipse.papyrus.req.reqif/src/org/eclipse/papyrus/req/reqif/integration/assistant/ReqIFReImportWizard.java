/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
package org.eclipse.papyrus.req.reqif.integration.assistant;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.req.reqif.I_SysMLStereotype;
import org.eclipse.papyrus.req.reqif.assistant.ReqIFSelectionPage;
import org.eclipse.papyrus.req.reqif.integration.transformation.ReqIFImporterServiceEdit;
import org.eclipse.papyrus.req.reqif.transformation.ReqIFImporter;
import org.eclipse.papyrus.uml.extensionpoints.utils.Util;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.ui.IImportWizard;
import org.eclipse.uml2.uml.Package;

/**
 * this class is used to do the retro engineering from workspaceplugin. It adds only in the platform dependencies.
 *
 */
public class ReqIFReImportWizard extends AbstractWizardForPapyrus implements IImportWizard {

	protected ReqIFSelectionPage reqifSelectionPage;
	/**
	 * 
	 * Constructor.
	 *
	 */
	public ReqIFReImportWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {

		reqifSelectionPage= new ReqIFSelectionPage((Package)getSelectionSet().get(0));
		this.addPage(reqifSelectionPage);
	}

	@Override
	public boolean performFinish() {

		// get the domain in order to launch the command
		final TransactionalEditingDomain domain = modelSet.getTransactionalEditingDomain();
		IFile reqFile=reqifSelectionPage.getSelectedReqIFFile();
		resourceSet = Util.createTemporaryResourceSet();
		Resource reqIFResource = resourceSet.getResource(URI.createPlatformResourceURI(reqFile.getFullPath().toOSString(), true),true);
		if( reqIFResource.getContents().size()>0){
			if(reqIFResource.getContents().get(0) instanceof ReqIF ){
				final ReqIF importedReqIFModel=(ReqIF)reqIFResource.getContents().get(0);
								
				RecordingCommand cmd= new RecordingCommand(domain, "Re-importReqIF") {

					@Override
					protected void doExecute() {
						ReqIFImporter sysMLReqIFTransfomation= new ReqIFImporterServiceEdit(domain, importedReqIFModel, (Package)getSelectionSet().get(0));
						
						// merge by "id" with UI and delete removed elements
						sysMLReqIFTransfomation.reImportReqIFModel(true, I_SysMLStereotype.REQUIREMENT_ID_ATT, true);
					}
				};
				domain.getCommandStack().execute(cmd);

			}
		}
		return true;
	}

}
