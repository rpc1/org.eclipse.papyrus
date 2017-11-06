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
package org.eclipse.papyrus.infra.elementtypesconfigurations.extensionpoints;

import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;

public interface IElementTypeSetExtensionPoint {

	/** ID of the extension point */
	public final static String EXTENSION_POINT_ID = Activator.PLUGIN_ID + ".elementTypeSetConfiguration";

	/** attribute: path to the model file in the bundle */
	public static final String PATH = "path";

	/** attribute: identifier of the contribution */
	public static final String ID = "id";
}
