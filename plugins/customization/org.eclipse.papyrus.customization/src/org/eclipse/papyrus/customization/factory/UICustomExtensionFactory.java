/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.customization.messages.Messages;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.UICustom;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.w3c.dom.Element;



public class UICustomExtensionFactory extends FileBasedExtensionFactory {

	public UICustomExtensionFactory() {
		super(Messages.UICustomExtensionFactory_UICustom, "org.eclipse.emf.facet.infra.browser.custom.core.registration", "file", "browserCustomization", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	@Override
	public void addElement(CustomizableElement element, PluginEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency("org.eclipse.emf.facet.infra.browser.custom"); //$NON-NLS-1$
	}

	@Override
	protected Element createExtension(FileBasedCustomizableElement element, PluginEditor editor) {
		Element extension = super.createExtension(element, editor);
		extension.setAttribute("loadByDefault", ((UICustom) element).isLoadByDefault() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return extension;
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/uiCustom/" + getFileName(element); //$NON-NLS-1$
	}

	public EClass getCustomizableElementClass() {
		return CustomizationPluginPackage.eINSTANCE.getUICustom();
	}

}
