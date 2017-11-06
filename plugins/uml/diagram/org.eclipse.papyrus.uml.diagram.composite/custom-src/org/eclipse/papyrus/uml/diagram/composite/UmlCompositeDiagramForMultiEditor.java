/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditor;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

/**
 * <pre>
 * An editor to be used in multitabs editor.
 * This editor extends the original UMLDiagramEditor generated by GMF.
 * </pre>
 */
public class UmlCompositeDiagramForMultiEditor extends UMLDiagramEditor {

	/**
	 * The location of diagram icon in the plug-in
	 */
	private static final String DIAG_IMG_PATH = "icons/obj16/Diagram_CompositeStructure.gif"; //$NON-NLS-1$

	/**
	 * The EditingDomain ID for this diagram
	 */
	private static final String CSD_EDITING_DOMAIN_ID = "org.eclipse.papyrus.uml.diagram.composite.EditingDomain"; //$NON-NLS-1$

	/**
	 * The image descriptor of the diagram icon
	 */
	private static final ImageDescriptor DIAG_IMG_DESC = UMLDiagramEditorPlugin.getBundledImageDescriptor(DIAG_IMG_PATH);

	/** The editor splitter. */
	private Composite splitter;

	private Image titleImage;

	/**
	 * Constructor. Context and required objects are retrieved from the ServiceRegistry.
	 *
	 * @throws BackboneException
	 * @throws ServiceException
	 *
	 */
	public UmlCompositeDiagramForMultiEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws BackboneException, ServiceException {
		super(servicesRegistry, diagram);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		setPartName(getDiagram().getName());
		titleImage = DIAG_IMG_DESC.createImage();
		setTitleImage(titleImage);
	}

	@Override
	public void dispose() {
		if (titleImage != null) {
			titleImage.dispose();
			titleImage = null;
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setInput(IEditorInput input) {
		try {
			// Provide an URI with fragment in order to reuse the same Resource
			// and set the diagram to the fragment.
			URIEditorInput uriInput = new URIEditorInput(EcoreUtil.getURI(getDiagram()));
			doSetInput(uriInput, true);
		} catch (CoreException x) {
			String title = "Problem opening";
			String msg = "Cannot open input element:";
			Shell shell = getSite().getShell();
			ErrorDialog.openError(shell, title, msg, x.getStatus());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createGraphicalViewer(Composite parent) {
		splitter = parent;
		super.createGraphicalViewer(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		splitter.setFocus();
		super.setFocus();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEditingDomainID() {
		return CSD_EDITING_DOMAIN_ID;
	}
}