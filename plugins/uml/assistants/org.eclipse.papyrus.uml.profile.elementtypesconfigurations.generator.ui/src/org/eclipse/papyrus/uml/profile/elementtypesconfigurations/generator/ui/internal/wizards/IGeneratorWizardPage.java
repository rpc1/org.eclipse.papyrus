/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal.wizards;

import org.eclipse.jface.wizard.IWizardPage;

/**
 * Private protocol common to assistants generator wizard pages.
 */
public interface IGeneratorWizardPage extends IWizardPage {
	/**
	 * Queries whether the current page input is valid and, as a side-effect, sets an error message if necessary.
	 * 
	 * @return whether the current page input is valid
	 */
	boolean validatePage();

	/**
	 * Saves appropriate user inputs in the dialog settings for future invocations of the wizard.
	 */
	void save();
}
