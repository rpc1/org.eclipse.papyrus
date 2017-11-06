/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.timing.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

/**
 * @generated
 */
public class UMLDomainNavigatorLabelProvider implements ICommonLabelProvider {

	/**
	 * @generated
	 */
	private AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	@Override
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof UMLDomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getImage(((UMLDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof UMLDomainNavigatorItem) {
			return myAdapterFactoryLabelProvider.getText(((UMLDomainNavigatorItem) element).getEObject());
		}
		return null;
	}

	/**
	 * @generated
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.addListener(listener);
	}

	/**
	 * @generated
	 */
	@Override
	public void dispose() {
		myAdapterFactoryLabelProvider.dispose();
	}

	/**
	 * @generated
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		return myAdapterFactoryLabelProvider.isLabelProperty(element, property);
	}

	/**
	 * @generated
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		myAdapterFactoryLabelProvider.removeListener(listener);
	}

	/**
	 * @generated
	 */
	@Override
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	@Override
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	@Override
	public String getDescription(Object anElement) {
		return null;
	}
}