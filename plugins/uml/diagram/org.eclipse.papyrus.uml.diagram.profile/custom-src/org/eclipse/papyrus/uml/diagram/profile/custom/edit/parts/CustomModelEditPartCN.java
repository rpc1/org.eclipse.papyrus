/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageFigure;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.ModelEditPartCN;

/**
 * this a specific editpart used to overload the method createNodePlate
 */
public class CustomModelEditPartCN extends ModelEditPartCN {

	protected static final String ICONS_PATH = "icons/Triangle.gif"; //$NON-NLS-1$

	public CustomModelEditPartCN(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IFigure createNodeShape() {
		primaryShape = new PackageFigure();
		((PackageFigure) primaryShape).setTagIcon(Activator.getPluginIconImage(Activator.ID, ICONS_PATH));
		return primaryShape;
	}
}