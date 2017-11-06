/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.training.library.tests.palette;

import org.eclipse.papyrus.junit.utils.tests.AbstractEMFResourceTest;
import org.junit.Test;

/**
 * Test the palette model :
 * - validate the model
 */
public class PaletteTest extends AbstractEMFResourceTest {

	public static final String PALETTE_PATH = org.eclipse.papyrus.training.library.palette.Activator.PLUGIN_ID + "/palettes/extlibrary.classdiagram.paletteconfiguration"; // $NON-NLS-0$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getFileUri() {
		return PALETTE_PATH;
	}

	@Test
	public void validateResource() {
		doValidateResource();
	}

}