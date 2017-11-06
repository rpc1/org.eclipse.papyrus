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
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginPackage;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.PluginEditor;


public class ConstraintEnvironmentExtensionFactory extends FileBasedExtensionFactory {

	public ConstraintEnvironmentExtensionFactory() {
		super("Constraint environment", "org.eclipse.papyrus.infra.constraints.ConstraintEnvironment", "environmentModel", "environment", true); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	@Override
	public void addElement(CustomizableElement element, PluginEditor editor) {
		super.addElement(element, editor);

		editor.getManifestEditor().addDependency("org.eclipse.papyrus.infra.constraints"); //$NON-NLS-1$
	}

	@Override
	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/constraintEnvironment/" + getFileName(element); //$NON-NLS-1$
	}

	public EClass getCustomizableElementClass() {
		return CustomizationPluginPackage.eINSTANCE.getConstraintsEnvironment();
	}

}
