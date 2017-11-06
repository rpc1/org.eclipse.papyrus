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
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.locator;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * Non diagram-specific class generated by GMF Tooling.
 */
public class LabelCellEditorLocator implements CellEditorLocator {

	private Label label;

	public LabelCellEditorLocator(Label label) {
		this.label = label;
	}

	public Label getLabel() {
		return label;
	}

	@Override
	public void relocate(CellEditor celleditor) {
		Text text = (Text) celleditor.getControl();
		Rectangle rect = getLabel().getTextBounds().getCopy();
		getLabel().translateToAbsolute(rect);
		if (!text.getFont().isDisposed()) {
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
		}
		if (!rect.equals(new Rectangle(text.getBounds()))) {
			text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}
	}
}
