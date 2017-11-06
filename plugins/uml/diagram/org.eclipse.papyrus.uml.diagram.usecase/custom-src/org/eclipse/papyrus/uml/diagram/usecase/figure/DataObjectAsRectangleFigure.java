package org.eclipse.papyrus.uml.diagram.usecase.figure;

import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

public class DataObjectAsRectangleFigure extends NodeNamedElementFigure {

	private org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel fDataObjectAsRectangleFigure_name;

	public DataObjectAsRectangleFigure() {
		org.eclipse.draw2d.ToolbarLayout layoutThis = new org.eclipse.draw2d.ToolbarLayout();
		layoutThis.setStretchMinorAxis(true);
		layoutThis.setMinorAlignment(OrderedLayout.ALIGN_CENTER);
		layoutThis.setSpacing(0);
		layoutThis.setHorizontal(false);
		this.setLayoutManager(layoutThis);
		this.setLineWidth(1);
		createContents();
	}

	private void createContents() {
		org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel dataObjectAsRectangleFigure_fixed_dataObject0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel();
		dataObjectAsRectangleFigure_fixed_dataObject0.setText("\u00ABdataObject\u00BB");
		this.add(dataObjectAsRectangleFigure_fixed_dataObject0);
		org.eclipse.draw2d.RectangleFigure dataObjectAsRectangleFigure_NameContainer0 = new org.eclipse.draw2d.RectangleFigure();
		dataObjectAsRectangleFigure_NameContainer0.setFill(false);
		dataObjectAsRectangleFigure_NameContainer0.setOutline(false);
		dataObjectAsRectangleFigure_NameContainer0.setLineWidth(1);
		this.add(dataObjectAsRectangleFigure_NameContainer0);
		org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout layoutDataObjectAsRectangleFigure_NameContainer0 = new org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout();
		dataObjectAsRectangleFigure_NameContainer0.setLayoutManager(layoutDataObjectAsRectangleFigure_NameContainer0);
		fDataObjectAsRectangleFigure_name = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel();
		fDataObjectAsRectangleFigure_name.setText("");
		dataObjectAsRectangleFigure_NameContainer0.add(fDataObjectAsRectangleFigure_name);
	}

	private boolean myUseLocalCoordinates = false;

	@Override
	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	public org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel getDataObjectAsRectangleFigure_name() {
		return fDataObjectAsRectangleFigure_name;
	}
}
