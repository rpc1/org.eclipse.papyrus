/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;

/**
 * @author PT202707
 *
 */
public interface IBorderItemWithLocator {
	
	public IBorderItemLocator getNewBorderItemLocator(IFigure mainFigure);

}
