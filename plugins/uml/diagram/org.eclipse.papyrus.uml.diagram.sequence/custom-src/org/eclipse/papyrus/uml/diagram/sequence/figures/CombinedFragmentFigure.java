/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   C�line Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 440230 : Label Margin
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.PapyrusWrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RectangularShadowBorder;

/**
 * Change super type to support displaying stereotypes, modified by [Jin Liu(jin.liu@soyatec.com)]
 */
public class CombinedFragmentFigure extends StereotypeInteractionFigure {

	private WrappingLabel titleLabel;
	private RectangleFigure header;

	@Override
	protected void createContents() {
		super.createContents();
		setShadow(false);
		interactionContentPane.setOutline(false);
		interactionContentPane.setOpaque(false);
		interactionContentPane.setBorder(null);
	}

	@Override
	protected RectangleFigure createHeader() {
		header = super.createHeader();
		titleLabel = new PapyrusWrappingLabel();
		titleLabel.setAlignment(PositionConstants.RIGHT);
		titleLabel.setBorder(new MarginBorder(3, 0, 0, 3));
		titleLabel.setTextWrap(false);
		header.add(titleLabel, BorderLayout.RIGHT);
		return header;
	}

	public WrappingLabel getTitleLabel() {
		return titleLabel;
	}

	public IFigure getHeaderContainer() {
		return header;
	}
	
	@Override
	public void setShadow(boolean shadow) {
		final int BORDER_WIDTH = 3;
		
		if (!shadow) {
			super.setShadow(shadow);
		} else {
			RectangularShadowBorder b = new RectangularShadowBorder(BORDER_WIDTH, getForegroundColor()) {
				@Override
				public Insets getInsets(IFigure figure) {
					return new Insets(1, 1, 1, 1);
				}
			};
			setBorder(b);
		}

		Rectangle figureRect = new Rectangle(getBounds()).expand(new Insets(0, 0, BORDER_WIDTH, BORDER_WIDTH));
		IFigure parent = getParent();
		while (parent != null) {
			if (parent.getBounds().contains(figureRect)) {
				parent.revalidate();
				parent.repaint();
				break;
			}
			parent = parent.getParent();
		}
	}
	
}
