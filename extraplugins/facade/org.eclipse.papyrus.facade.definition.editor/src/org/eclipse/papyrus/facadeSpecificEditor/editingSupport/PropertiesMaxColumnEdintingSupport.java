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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor.editingSupport;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualTypedElement;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.MultiplicityElement;

public class PropertiesMaxColumnEdintingSupport extends EditingSupport {

	protected AdapterFactoryEditingDomain editingDomain;

	protected Composite parent;

	public PropertiesMaxColumnEdintingSupport(ColumnViewer viewer, AdapterFactoryEditingDomain editingDomain, Composite parent) {
		super(viewer);
		this.editingDomain = editingDomain;
		this.parent = parent;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 *
	 * @param element
	 * @param value
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if (element instanceof VirtualTypedElement) {

			try {

				if (((VirtualTypedElement) element).getRepresentedElement() instanceof MultiplicityElement || ((VirtualTypedElement) element).getRepresentedElement() instanceof ETypedElement) {
					boolean isOk = false;
					int intValue = Integer.valueOf((String) value);

					if (intValue >= -1) {
						int upperReference = 0;

						if (((VirtualTypedElement) element).getRepresentedElement() instanceof MultiplicityElement) {
							upperReference = ((MultiplicityElement) ((VirtualTypedElement) element).getRepresentedElement()).getUpper();

						} else if (((VirtualTypedElement) element).getRepresentedElement() instanceof ETypedElement) {
							upperReference = ((ETypedElement) ((VirtualTypedElement) element).getRepresentedElement()).getUpperBound();
						}

						if (upperReference != -1) {
							if (intValue != -1) {
								if (intValue <= upperReference) {
									isOk = true;
								}
							}

						} else {
							isOk = true;
						}

						if (isOk) {
							SetCommand command = new SetCommand(editingDomain, (VirtualTypedElement) element, VirtualmetamodelPackage.eINSTANCE.getVirtualTypedElement_Upper(), intValue);
							editingDomain.getCommandStack().execute(command);
							getViewer().refresh();
						} else {
							MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PropertiesMaxColumnEdintingSupport_0, Messages.PropertiesMaxColumnEdintingSupport_1 + upperReference);
						}
					} else {
						MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PropertiesMaxColumnEdintingSupport_2, Messages.PropertiesMaxColumnEdintingSupport_3);
					}
				}

			} catch (NumberFormatException ex) {
				MessageDialog.openWarning(Display.getCurrent().getActiveShell(), Messages.PropertiesMaxColumnEdintingSupport_4, Messages.PropertiesMaxColumnEdintingSupport_5);
			}
		}
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected Object getValue(Object element) {
		if (element instanceof VirtualTypedElement) {

			return ((VirtualTypedElement) element).getUpper() + ""; //$NON-NLS-1$

		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		if (element instanceof VirtualTypedElement) {
			return new TextCellEditor(parent);
		}

		return null;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 *
	 * @param element
	 * @return
	 */
	@Override
	protected boolean canEdit(Object element) {
		if (element instanceof VirtualProperty) {
			return true;
		}

		return false;
	}

}
