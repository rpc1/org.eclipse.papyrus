package org.eclipse.papyrus.uml.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;

public class ShapeCompartmentWithoutScrollbarsEditPart extends ShapeCompartmentEditPart {

	public ShapeCompartmentWithoutScrollbarsEditPart(View view) {
		super(view);
	}

	/**
	 * remove the bottom border, remove scrollbars
	 */
	@Override
	public IFigure createFigure() {
		return setupNoScrolls((ShapeCompartmentFigure) super.createFigure());
	}

	private IFigure setupNoScrolls(ShapeCompartmentFigure figure) {
		figure.setTitleVisibility(false);
		// remove the top border
		figure.setBorder(null);
		// remove scrollbars
		figure.getScrollPane().setHorizontalScrollBar(null);
		figure.getScrollPane().setVerticalScrollBar(null);
		figure.getScrollPane().setScrollBarVisibility(ScrollPane.NEVER);
		// result.getScrollPane().getViewport().setContentsTracksHeight(true);
		return figure;
	}

}
