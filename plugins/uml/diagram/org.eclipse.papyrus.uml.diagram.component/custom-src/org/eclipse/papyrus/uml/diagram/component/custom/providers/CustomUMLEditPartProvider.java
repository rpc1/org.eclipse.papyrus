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
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.providers;

import org.eclipse.papyrus.uml.diagram.component.custom.factory.CustomUMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLEditPartProvider;

public class CustomUMLEditPartProvider extends UMLEditPartProvider {

	public CustomUMLEditPartProvider() {
		setFactory(new CustomUMLEditPartFactory());
		setAllowCaching(true);
	}

}