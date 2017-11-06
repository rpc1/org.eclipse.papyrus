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
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Panel displayed when a TemplateParameter is selected
 * @deprecated This view will be replaced by an XWT view for the C++ profile
 */
@Deprecated
public class CppTemplateParameterPanel extends CppAbstractPanel {

	private TemplateParameter selectedTP;

	// document used by the viewer
	@SuppressWarnings("unused")
	private SourceViewer viewerParameter;

	private Group groupParameter;

	private IDocument docParameter;

	public CppTemplateParameterPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public TemplateParameter getSelectedElement() {
		return selectedTP;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if (newElement instanceof TemplateParameter) {
			this.selectedTP = (TemplateParameter) newElement;
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 TemplateParameter");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	@Override
	public Control createContent() {

		// /////////////////////////////////////////////////////////////////////
		// Create save reset buttons with superclass method
		// /////////////////////////////////////////////////////////////////////
		createSaveResetButtons();

		// /////////////////////////////////////////////////////////////////////
		// TemplateParameter declaration
		// /////////////////////////////////////////////////////////////////////
		docParameter = createDocumentC();
		groupParameter = createGroup(
				this
				, "Parameter name"
				, buttonSave
				, null
				, true
				, 0
				, 0
				, true);
		// Use CDT CEditor coloration
		viewerParameter = createViewerC(docParameter, groupParameter);

		// /////////////////////////////////////////////////////////////////////
		// Return control on this composite
		// /////////////////////////////////////////////////////////////////////

		return this;
	}

	/**
	 * Saves the body for an '<code>Property</code>'
	 */
	@Override
	public void save()
	{
		if (selectedTP == null) {
			/* Log.debug("saveBody : selectedProperty is null"); */
		}
		else {
			CommandSupport.exec("C++ template parameter save", new Runnable() {

				@Override
				public void run()
				{
					// Treat Parameter name
					String newB = docParameter.get();
					if (newB.equals("")) {
						StereotypeUtil.unapply(selectedTP, org.eclipse.papyrus.C_Cpp.TemplateParameter.class);
					}
					else {
						org.eclipse.papyrus.C_Cpp.TemplateParameter templateParameter = StereotypeUtil.applyApp(selectedTP, org.eclipse.papyrus.C_Cpp.TemplateParameter.class);
						templateParameter.setName(newB);
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
		if (selectedTP == null) {
			/* Log.debug("resetBody : selectedProperty is null"); */
		} else {

			org.eclipse.papyrus.C_Cpp.TemplateParameter templateParameter = UMLUtil.getStereotypeApplication(selectedTP, org.eclipse.papyrus.C_Cpp.TemplateParameter.class);
			String parameterName = templateParameter != null ? templateParameter.getName() : "";
			docParameter.set(parameterName);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#entryAction()
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
		org.eclipse.papyrus.C_Cpp.TemplateParameter templateParameter = UMLUtil.getStereotypeApplication(selectedTP, org.eclipse.papyrus.C_Cpp.TemplateParameter.class);
		// TODO: use UML template bindings?
		String parameterName = templateParameter != null ? templateParameter.getName() : "";
		if (!docParameter.get().equals(parameterName)) {
			return true;
		}
		return false;
	}
}
