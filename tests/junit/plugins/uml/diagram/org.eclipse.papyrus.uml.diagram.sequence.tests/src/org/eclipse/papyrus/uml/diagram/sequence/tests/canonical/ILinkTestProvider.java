/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
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
package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;

public interface ILinkTestProvider extends IChildTestProvider {

	int getEdgesSize();

	Point getConnectionSourceLocation(EditPart source);

	Point getConnectionTargetLocation(EditPart target);

	void setUp();
}
