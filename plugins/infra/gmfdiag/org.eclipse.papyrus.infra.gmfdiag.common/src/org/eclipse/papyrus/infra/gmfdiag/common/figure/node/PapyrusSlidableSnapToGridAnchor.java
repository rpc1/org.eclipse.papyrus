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

package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.tooling.runtime.linklf.DiagramGridSpec;
import org.eclipse.gmf.tooling.runtime.linklf.SlidableSnapToGridAnchor;

/**
 * Internal class to manage anchors snappable to grid
 */
public class PapyrusSlidableSnapToGridAnchor extends SlidableSnapToGridAnchor {

	private EditPart editPart;

	/**
	 * Constructor.
	 *
	 * @param f
	 * @param p
	 */
	public PapyrusSlidableSnapToGridAnchor(NodeFigure f, PrecisionPoint p) {
		super(f, p);
	}

	/**
	 * If grid provider had been set up and has grid enabled then returns active
	 * grid specification in absolute coordinates. Otherwise returns null.
	 * 
	 * @return <code>null</code> if no active grid or grid provider had not been
	 *         set up.
	 */
	protected Rectangle getAbsoluteGridSpec() {
		if (editPart == null) {
			return null;
		} else {
			EditPartViewer viewer = editPart.getViewer();
			return viewer == null ? null : DiagramGridSpec
					.getAbsoluteGridSpec(viewer);
		}
	}

	public void setEditPart(EditPart editPart) {
		this.editPart = editPart;
	}

	/**
	 * @see org.eclipse.gmf.tooling.runtime.linklf.SlidableSnapToGridAnchor#setEditPartViewer(org.eclipse.gef.EditPartViewer)
	 *
	 * @param viewer
	 */
	@Override
	public void setEditPartViewer(EditPartViewer viewer) {
		throw new UnsupportedOperationException("This method should never be invoked inside Papyrus");
	}

}
