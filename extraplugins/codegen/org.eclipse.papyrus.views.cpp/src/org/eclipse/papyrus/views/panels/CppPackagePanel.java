/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.panels;

import org.eclipse.jface.text.IDocument;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Panel displayed when a Package is selected
 * @deprecated This view will be replaced by an XWT view for the C++ profile
 */
@Deprecated
public class CppPackagePanel extends CppAbstractPanel {

	// document used by the viewer for header include
	private IDocument headerDocument;

	// private SourceViewer headerViewer;
	private Group headerGroup;

	// Current selection
	private Package selectedPackage;

	/**
	 * Default constructor
	 *
	 * @param parent
	 *            the composite parent of this panel
	 * @param style
	 *            the SWT style of this panel
	 */
	public CppPackagePanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public org.eclipse.uml2.uml.Package getSelectedElement() {
		return selectedPackage;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if (newElement instanceof Package) {
			this.selectedPackage = (Package) newElement;
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 Package");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContentHI()
	 */
	@Override
	public Control createContent() {

		// /////////////////////////////////////////////////////////////////////
		// Create a composite that contain the "Save/Cancel" buttons
		// /////////////////////////////////////////////////////////////////////
		createSaveResetButtons();

		// /////////////////////////////////////////////////////////////////////
		// Package header declaration
		// /////////////////////////////////////////////////////////////////////
		headerDocument = createDocumentC();
		headerGroup = createGroup(
				this
				, "Header include declarations"
				, buttonSave
				, null
				, true
				, 0
				, 0
				, true);
		// Use CDT CEditor coloration
		// headerViewer
		createViewerC(headerDocument, headerGroup);

		// /////////////////////////////////////////////////////////////////////
		return this;
	}

	/**
	 * Saves the include declarations for a '<code>Package</code>'
	 */
	@Override
	public void save()
	{
		if (selectedPackage == null) {
			/* Log.debug("saveBody : selectedPackage is null"); */
		}
		else {
			CommandSupport.exec("C++ package save", new Runnable() {

				@Override
				public void run()
				{
					if (headerDocument.get().equals("")) {
						StereotypeUtil.unapply(selectedPackage, Include.class);
					} else {
						Include cppInclude = StereotypeUtil.applyApp(selectedPackage, Include.class);
						cppInclude.setHeader(headerDocument.get());
					}
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#refreshPanel()
	 */
	@Override
	protected void refreshPanel() {
		if (selectedPackage != null) {
			Include cppInclude = UMLUtil.getStereotypeApplication(selectedPackage, Include.class);
			if (cppInclude != null) {
				headerDocument.set(cppInclude.getHeader());
			}
			else {
				headerDocument.set("");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#entryAction()
	 */
	@Override
	public void entryAction() {
		super.entryAction();
		reset();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#checkModifications()
	 */
	@Override
	public boolean checkModifications() {
		String headerInModel = "";
		Include cppInclude = UMLUtil.getStereotypeApplication(selectedPackage, Include.class);
		if (cppInclude != null) {
			headerInModel = cppInclude.getHeader();
		}
		return (!(headerDocument.get().equals(headerInModel)));
	}
}
