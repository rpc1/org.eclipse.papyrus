/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.elementtypesconfigurations.developer.view;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.elementtypesconfigurations.developer.providers.ElementTypesContentProvider;
import org.eclipse.papyrus.elementtypesconfigurations.developer.providers.ElementTypesDetailsContentProvider;
import org.eclipse.papyrus.elementtypesconfigurations.developer.providers.ElementTypesLabelProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

public class RegistredElementTypesView extends ViewPart {

	IClientContext context = null;
	ListViewer listViewer = null;
	SashForm sash = null;
	FilteredTree tree = null;

	public RegistredElementTypesView() {
		try {
			context = TypeContext.getContext();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		Button button = new Button(parent, SWT.NONE);
		button.setText("Refresh");
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(context);
				tree.getViewer().setInput(elementTypes);
			}

		});
		sash = new SashForm(parent, SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tree = new FilteredTree(sash, SWT.BORDER, new PatternFilter(), true);
		tree.getViewer().setLabelProvider(new ElementTypesLabelProvider());
		tree.getViewer().setContentProvider(new ElementTypesContentProvider());
		listViewer = new ListViewer(sash);
		listViewer.setLabelProvider(new LabelProvider());
		listViewer.setContentProvider(new ElementTypesDetailsContentProvider());


		IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(context);
		tree.getViewer().setInput(elementTypes);

		tree.getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection)
				{
					listViewer.setInput(((IStructuredSelection) event.getSelection()).getFirstElement());
				}

			}
		});
	}

	@Override
	public void setFocus() {

	}
}
