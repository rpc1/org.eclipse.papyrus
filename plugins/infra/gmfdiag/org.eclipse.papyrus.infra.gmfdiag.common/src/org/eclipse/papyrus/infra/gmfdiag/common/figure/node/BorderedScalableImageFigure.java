/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *      Mickael ADAM (ALL4TEC) - mickael.adam@all4tec.net - implementation of layout BorderedLayoutManager to provide maintain ratio and color set
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.FigureUtils;
import org.w3c.dom.Document;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGSVGElement;

/**
 * Scalable Image figure that will be aligned in the middle/center and keep its own ratio.
 *
 * It is also used to serve as specific implementation in Papyrus, as debug items can be easily added.
 */
public class BorderedScalableImageFigure extends ScalableImageFigure {

	private RenderedImage lastRenderedImage;

	public BorderedScalableImageFigure(RenderedImage renderedImage, boolean useDefaultImageSize, boolean useOriginalColors, boolean antiAlias) {
		super(renderedImage, useDefaultImageSize, useOriginalColors, antiAlias);
		// set a layout manager to override maintain ratio behavior
		setLayoutManager(new BorderedLayoutManager());
		lastRenderedImage = renderedImage;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		if (!lastRenderedImage.getSWTImage().isDisposed()) { // Fix bug 462850

			// Get the parent bounds
			Rectangle parentBounds = getParent().getBounds().getCopy();

			// Get the main figure where are color informations.
			IRoundedRectangleFigure roundedCompartmentFigure = getMainFigure();

			// Set the color from the color of the parent
			if (roundedCompartmentFigure != null) {
				setBackgroundColor(roundedCompartmentFigure.getBackgroundColor());
				setForegroundColor(roundedCompartmentFigure.getForegroundColor());
			} else {
				// Set the color from the color of the parent
				setBackgroundColor(getParent().getBackgroundColor());
				setForegroundColor(getParent().getForegroundColor());
			}

			// set the clip of the graphics to the parent clip
			graphics.setClip(parentBounds);
			super.paintFigure(graphics);
		}
	}

	/**
	 * Gets the main figure.
	 * 
	 * @return the roundedRectangleFigure
	 */
	private IRoundedRectangleFigure getMainFigure() {
		// If it's called by SVGNodePlate, the parent have not always the foreground color, need to locate
		SVGNodePlateFigure svgNodePlate = FigureUtils.findParentFigureInstance(this, SVGNodePlateFigure.class);
		return svgNodePlate == null ? null : FigureUtils.findChildFigureInstance(svgNodePlate, IRoundedRectangleFigure.class);
	}

	class BorderedLayoutManager extends AbstractLayout {

		/**
		 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
		 *
		 * @param container
		 */
		@Override
		public void layout(IFigure container) {
			// Look for a ScrollBarPane to hide ScrollPane
			IFigure scrollPaneFigure = FigureUtils.findParentFigureInstance(container, ScrollPane.class);

			// Hide the ScrollBar if a ScrollPan is found
			if (scrollPaneFigure instanceof ScrollPane) {
				((ScrollPane) scrollPaneFigure).setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
			}

			// if there is aspect ratio and only one figure is set
			if (isMaintainAspectRatio() && container.getParent().getChildren().size() == 1) {
				// If the ration is maintained
				ScalableCompartmentFigure scalableCompartmentFigure = FigureUtils.findParentFigureInstance(container, ScalableCompartmentFigure.class);

				// Get the document to calculate ratio
				ScalableImageFigure scalableImage = FigureUtils.findChildFigureInstance(getParent(), ScalableImageFigure.class);
				double ratio = 1;
				RenderedImage renderedImage = scalableImage.getRenderedImage();
				if (renderedImage instanceof org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.svg.SVGImage) {
					org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.svg.SVGImage img = (org.eclipse.gmf.runtime.draw2d.ui.render.awt.internal.svg.SVGImage) renderedImage;
					final PrecisionDimension svgDimension = getSvgDimension(img.getDocument());
					ratio = svgDimension.preciseWidth() / svgDimension.preciseHeight();
				}

				Rectangle scalableCompartmentBounds = scalableCompartmentFigure != null ? scalableCompartmentBounds = scalableCompartmentFigure.getBounds() : container.getBounds();

				Point center = new Point(scalableCompartmentBounds.x + scalableCompartmentBounds.width / 2, scalableCompartmentBounds.y + scalableCompartmentBounds.height / 2);

				int width = 0;
				int height = 0;
				int y = 0;
				int x = 0;

				// Case width>height
				if (scalableCompartmentBounds.width > scalableCompartmentBounds.height) {
					if (scalableCompartmentBounds.width > scalableCompartmentBounds.height * ratio) {
						width = (int) (scalableCompartmentBounds.height * ratio);
						height = scalableCompartmentBounds.height;
					} else {
						width = scalableCompartmentBounds.width;
						height = (int) (scalableCompartmentBounds.width / ratio);
					}

				} else {// Case height>width
					if (scalableCompartmentBounds.height < scalableCompartmentBounds.width / ratio) {
						width = (int) (scalableCompartmentBounds.height * ratio);
						height = scalableCompartmentBounds.height;
					} else {
						width = scalableCompartmentBounds.width;
						height = (int) (scalableCompartmentBounds.width / ratio);
					}
				}
				y = center.y - height / 2;
				x = center.x - width / 2;
				container.setBounds(new Rectangle(x, y, width, height));
			} else {
				// Set bounds
				if (scrollPaneFigure instanceof ScrollPane) {
					container.setBounds(scrollPaneFigure.getBounds());
				}
			}
		}

		/**
		 * Transforms the given SVG animated length to a base value, assuming the units in the SVG are pixels
		 *
		 * @param length
		 *            The SVG length
		 * @return The base value as a double
		 */
		private double getValueOf(SVGAnimatedLength length) {
			if (length == null) {
				return 0;
			}
			SVGLength base = length.getBaseVal();
			if (base == null) {
				return 0;
			}
			return base.getValue();
		}

		/**
		 * Gets the dimension of the SVG document, assuming the units in the SVG are pixels
		 *
		 * @param document
		 *            The SVG document
		 * @return The equivalent Draw2D dimension
		 */
		private PrecisionDimension getSvgDimension(Document document) {
			double svgWidth = 0;
			double svgHeight = 0;
			if (document.getDocumentElement() instanceof SVGSVGElement) {
				SVGSVGElement svgElement = (SVGSVGElement) document.getDocumentElement();
				if (svgElement != null) {
					svgWidth = getValueOf(svgElement.getWidth());
					svgHeight = getValueOf(svgElement.getHeight());
				}
			}
			return new PrecisionDimension(svgWidth, svgHeight);
		}

		/**
		 * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure, int, int)
		 *
		 * @param container
		 * @param wHint
		 * @param hHint
		 * @return
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
