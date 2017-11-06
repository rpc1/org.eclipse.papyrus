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
package org.eclipse.papyrus.elementtypesconfigurations.developer.providers;

import java.io.IOException;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ElementTypesLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof IElementType) {
			if (((IElementType) element).getIconURL() != null) {
				try {
					return new Image(Display.getCurrent(), ((IElementType) element).getIconURL().openStream());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		String result = "";
		if (element instanceof IElementType) {
			result += ((IElementType) element).getId();
		}
		return result;
	}
}
