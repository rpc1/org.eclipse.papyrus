/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Céline Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 440230
 *  Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Bug 443235
 *  Mickaël ADAM (ALL4TEC) mickael.adam@all4tec.net - text alignment implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.resources.IResource;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.ResizableLabelLocator;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PointListUtilities;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomBooleanStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomIntStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.databinding.custom.CustomStringStyleObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.BorderDisplayEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.LabelAlignmentEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.LabelPrimarySelectionEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.RefreshTextAlignmentEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.IPapyrusWrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.locator.IPapyrusBorderItemLocator;
import org.eclipse.papyrus.infra.gmfdiag.common.locator.LabelViewConstants;
import org.eclipse.papyrus.infra.gmfdiag.common.locator.PapyrusLabelLocator;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.NamedStyleProperties;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.PositionEnum;


public abstract class PapyrusLabelEditPart extends LabelEditPart implements NamedStyleProperties {

	/**
	 * Default Margin when not present in CSS
	 */
	public static final int DEFAULT_MARGIN = 0;


	/** The external label locator. */
	protected PapyrusLabelLocator papyrusLabelLocator = null;

	/** The affixed label locator. */
	protected IPapyrusBorderItemLocator borderLabelLocator = null;

	/** The labelConstrained Observable */
	private IObservableValue labelConstrainedObservable;

	/** The namedStyle Listener */
	private IChangeListener namedStyleListener = new IChangeListener() {

		@Override
		public void handleChange(ChangeEvent event) {
			refresh();

		}

	};

	/** The position Observable */
	private IObservableValue positionObservable;

	/** The labelOffsetX Observable */
	private IObservableValue labelOffsetXObservable;

	/** The labelOffsety Observable */
	private IObservableValue labelOffsetYObservable;

	/** The leftMargin Observable */
	private IObservableValue leftMarginObservable;

	/** The rightMargin Observable */
	private IObservableValue rightMarginObservable;

	/** The topMargin Observable */
	private IObservableValue topMarginObservable;

	/** The bottomMargin Observable */
	private IObservableValue bottomMarginObservable;

	public PapyrusLabelEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(BorderDisplayEditPolicy.BORDER_DISPLAY_EDITPOLICY, new BorderDisplayEditPolicy());
		installEditPolicy(LabelAlignmentEditPolicy.LABEL_ALIGNMENT_KEY, new LabelAlignmentEditPolicy());
		installEditPolicy(LabelPrimarySelectionEditPolicy.LABEL_PRIMARY_SELECTION_KEY, new LabelPrimarySelectionEditPolicy());
		installEditPolicy(RefreshTextAlignmentEditPolicy.REFRESH_TEXT_ALIGNMENT_EDITPOLICY, new RefreshTextAlignmentEditPolicy());
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#refreshVisuals()
	 *
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabelMargin();
	}

	/**
	 * Refresh bounds.
	 *
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#refreshBounds()
	 */
	@Override
	public void refreshBounds() {
		// try to handle both of resizable and nonresizable labels
		if (isResizable()) {
			handleResizableRefreshBounds();
		} else {
			handleNonResizableRefreshBoundS();
		}
	}

	/**
	 * Handle non resizable refresh bound s.
	 */
	private void handleNonResizableRefreshBoundS() {
		int dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();

		Point offset = new Point(dx, dy);

		if (getParent() instanceof AbstractConnectionEditPart) {

			AbstractGraphicalEditPart parentEditPart = (AbstractGraphicalEditPart) getParent();

			Connection connectionFigure = ((AbstractConnectionEditPart) getParent()).getConnectionFigure();

			if (papyrusLabelLocator != null) {
				papyrusLabelLocator.setOffset(offset);
			} else {
				papyrusLabelLocator = new PapyrusLabelLocator(connectionFigure, offset, getKeyPoint());
			}
			papyrusLabelLocator.setTextAlignment(getTextAlignment());
			papyrusLabelLocator.setView((View) getModel());
			parentEditPart.setLayoutConstraint(this, getFigure(), papyrusLabelLocator);

		} else {
			setExternalLabelLocator(offset);
			getFigure().getParent().setConstraint(getFigure(), borderLabelLocator);
		}
	}

	/**
	 * @return the papyrusLabelLocator
	 */
	public PapyrusLabelLocator getPapyrusLabelLocator() {
		return papyrusLabelLocator;
	}

	/**
	 * Sets the external label locator.
	 *
	 * @param offset
	 *            the new external label locator
	 */
	private void setExternalLabelLocator(Point offset) {
		if (borderLabelLocator == null) {
			borderLabelLocator = (IPapyrusBorderItemLocator) getBorderItemLocator();

		}
		if (offset != null) {
			borderLabelLocator.setConstraint(new Rectangle(offset.x, offset.y, 0, 0));
		}
		borderLabelLocator.setView((View) getModel());
		borderLabelLocator.setEditpart(this);
		borderLabelLocator.setTextAlignment(getTextAlignment());
	}

	/**
	 * Gets the border item locator.
	 *
	 * @return the border item locator
	 */
	public Object getBorderItemLocator() {
		IFigure parentFigure = getFigure().getParent();
		if (parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
			return constraint;
		}
		return null;
	}

	/**
	 * Gets the text alignment.
	 *
	 * @return the text alignment
	 */
	public int getTextAlignment() {
		// get the value of the CSS property
		View model = (View) getModel();
		StringValueStyle labelAlignment = (StringValueStyle) model.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), TEXT_ALIGNMENT);

		int textAlignment = 0;
		if (labelAlignment != null) {
			if (PositionEnum.LEFT.toString().equals(labelAlignment.getStringValue())) {
				textAlignment = PositionConstants.LEFT;
			}
			if (PositionEnum.RIGHT.toString().equals(labelAlignment.getStringValue())) {
				textAlignment = PositionConstants.RIGHT;
			}
			if (PositionEnum.CENTER.toString().equals(labelAlignment.getStringValue())) {
				textAlignment = PositionConstants.CENTER;
			}
		} else {
			textAlignment = getDefaultTextAlignment();
		}
		return textAlignment;
	}

	/**
	 * Handle resizable refresh bounds.
	 */
	private void handleResizableRefreshBounds() {
		int dx = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_X())).intValue();
		int dy = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getLocation_Y())).intValue();
		int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width())).intValue();
		int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height())).intValue();

		Rectangle rectangle = new Rectangle(dx, dy, width, height);
		if (getParent() instanceof AbstractConnectionEditPart) {
			((AbstractGraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new ResizableLabelLocator(((AbstractConnectionEditPart) getParent()).getConnectionFigure(), rectangle, getKeyPoint()));
		} else {
			getFigure().getParent().setConstraint(getFigure(), new ResizableLabelLocator(getFigure().getParent(), rectangle, getKeyPoint()));
		}
	}

	/**
	 * Checks if is resizable.
	 *
	 * @return true, if is resizable
	 */
	private boolean isResizable() {
		EditPolicy editPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if (editPolicy instanceof ResizableEditPolicy) {
			return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#refresh()
	 *
	 */
	@Override
	public void refresh() {
		super.refresh();
		if (getBorderItemLocator() instanceof IPapyrusBorderItemLocator) {
			// Constrained management
			setExternalLabelLocator(null);
			refreshLabelConstrained();
			refreshLabelOffset();
		}
	}

	/**
	 * Refresh label offset.
	 */
	private void refreshLabelOffset() {
		// get the value of the CSS property
		Object model = getModel();
		if (model instanceof View) {
			int labelOffsetX = NotationUtils.getIntValue((View) getModel(), LABEL_OFFSET_X, getDefaultLabelOffsetX());
			int labelOffsetY = NotationUtils.getIntValue((View) getModel(), LABEL_OFFSET_Y, getDefaultLabelOffsetY());

			// set the value on the locator
			((IPapyrusBorderItemLocator) getBorderItemLocator()).setOffset(new Dimension(labelOffsetX, labelOffsetY));
		}
	}

	/**
	 * Refresh label constrained.
	 */
	private void refreshLabelConstrained() {
		// get the value of the CSS property
		Object model = getModel();
		if (model instanceof View) {
			// set the value on the locator
			((IPapyrusBorderItemLocator) getBorderItemLocator()).setConstrained(isLabelConstrained());
		}
	}

	/**
	 * Checks if is label constrained.
	 *
	 * @return true, if the label is constrained
	 */
	public boolean isLabelConstrained() {
		boolean labelConstrained = NotationUtils.getBooleanValue((View) getModel(), LABEL_CONSTRAINED, getDefaultLabelConstrained());
		return labelConstrained;
	}

	/**
	 * Adds listener to handle named Style modifications.
	 */
	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();

		View view = (View) getModel();
		EditingDomain domain = EMFHelper.resolveEditingDomain(view);

		labelConstrainedObservable = new CustomBooleanStyleObservableValue(view, domain, LABEL_CONSTRAINED);
		labelConstrainedObservable.addChangeListener(namedStyleListener);

		positionObservable = new CustomStringStyleObservableValue(view, domain, POSITION);
		positionObservable.addChangeListener(namedStyleListener);

		labelOffsetXObservable = new CustomIntStyleObservableValue(view, domain, LABEL_OFFSET_X);
		labelOffsetXObservable.addChangeListener(namedStyleListener);

		labelOffsetYObservable = new CustomIntStyleObservableValue(view, domain, LABEL_OFFSET_Y);
		labelOffsetYObservable.addChangeListener(namedStyleListener);

		leftMarginObservable = new CustomIntStyleObservableValue(view, domain, LEFT_MARGIN_PROPERTY);
		leftMarginObservable.addChangeListener(namedStyleListener);

		rightMarginObservable = new CustomIntStyleObservableValue(view, domain, RIGHT_MARGIN_PROPERTY);
		rightMarginObservable.addChangeListener(namedStyleListener);

		topMarginObservable = new CustomIntStyleObservableValue(view, domain, TOP_MARGIN_PROPERTY);
		topMarginObservable.addChangeListener(namedStyleListener);

		bottomMarginObservable = new CustomIntStyleObservableValue(view, domain, BOTTOM_MARGIN_PROPERTY);
		bottomMarginObservable.addChangeListener(namedStyleListener);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeNotationalListeners()
	 *
	 */
	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		labelConstrainedObservable.dispose();
		positionObservable.dispose();
		labelOffsetXObservable.dispose();
		labelOffsetYObservable.dispose();
		leftMarginObservable.dispose();
		rightMarginObservable.dispose();
		topMarginObservable.dispose();
		bottomMarginObservable.dispose();
	}

	/**
	 * Gets the default label offset y.
	 *
	 * @return the default label offset y
	 */
	protected int getDefaultLabelOffsetY() {
		return 0;
	}

	/**
	 * Gets the default label offset x.
	 *
	 * @return the default label offset x
	 */
	protected int getDefaultLabelOffsetX() {
		return 0;
	}

	/**
	 * Gets the default label constrained.
	 *
	 * @return the default label constrained
	 */
	protected boolean getDefaultLabelConstrained() {
		return false;
	}

	/**
	 * Gets the default text alignment.
	 *
	 * @return the default text alignment
	 */
	protected int getDefaultTextAlignment() {
		EditPart parent = getParent();
		if (parent instanceof NodeEditPart || parent instanceof AbstractBorderItemEditPart) {
			return PositionConstants.LEFT;
		} else if (parent instanceof ConnectionEditPart) {
			return PositionConstants.CENTER;
		}
		return PositionConstants.CENTER;
	}


	/**
	 * Refresh label margin.
	 */
	public void refreshLabelMargin() {
		IFigure figure = null;

		int leftMargin = DEFAULT_MARGIN;
		int rightMargin = DEFAULT_MARGIN;
		int topMargin = DEFAULT_MARGIN;
		int bottomMargin = DEFAULT_MARGIN;

		Object model = this.getModel();

		if (model instanceof View) {
			leftMargin = NotationUtils.getIntValue((View) model, LEFT_MARGIN_PROPERTY, DEFAULT_MARGIN);
			rightMargin = NotationUtils.getIntValue((View) model, RIGHT_MARGIN_PROPERTY, DEFAULT_MARGIN);
			topMargin = NotationUtils.getIntValue((View) model, TOP_MARGIN_PROPERTY, DEFAULT_MARGIN);
			bottomMargin = NotationUtils.getIntValue((View) model, BOTTOM_MARGIN_PROPERTY, DEFAULT_MARGIN);
		}

		figure = ((GraphicalEditPart) this).getFigure();

		if (figure instanceof IPapyrusWrappingLabel) {
			((IPapyrusWrappingLabel) figure).setMarginLabel(leftMargin, topMargin, rightMargin, bottomMargin);

			// set margin of locator:
			if (borderLabelLocator != null) {
				borderLabelLocator.setMargin(new Point(leftMargin + rightMargin, topMargin + bottomMargin));
			} else if (papyrusLabelLocator != null) {
				papyrusLabelLocator.setMargin(new Point(leftMargin + rightMargin, topMargin + bottomMargin));
			}
		}
	}

	/**
	 * Workaround for bug #465611, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=465611
	 */
	@Override
	public Object getAdapter(Class key) {
		if (IResource.class == key && getParent() == null) {
			return null;
		}
		return super.getAdapter(key);
	}

	public Point getReferencePoint() {
		if (getParent() instanceof AbstractConnectionEditPart) {
			switch (getKeyPoint()) {
				case ConnectionLocator.TARGET:
					return calculateRefPoint(LabelViewConstants.SOURCE_LOCATION);
				case ConnectionLocator.SOURCE:
					return calculateRefPoint(LabelViewConstants.TARGET_LOCATION);
				case ConnectionLocator.MIDDLE:
					return calculateRefPoint(LabelViewConstants.MIDDLE_LOCATION);
				default:
					return calculateRefPoint(LabelViewConstants.MIDDLE_LOCATION);
			}
		} 
		
		return ((AbstractGraphicalEditPart)getParent()).getFigure().getBounds().getTopLeft();
	}

	private Point calculateRefPoint(int percent) {
		if (getParent() instanceof AbstractConnectionEditPart) {
			PointList ptList = ((Connection)((ConnectionEditPart)getParent()).getFigure()).getPoints();
			Point refPoint = PointListUtilities.calculatePointRelativeToLine(ptList, 0, percent, true);
			return refPoint;
		} else if (getParent() instanceof GraphicalEditPart) {
			return ((AbstractGraphicalEditPart)getParent()).getFigure().getBounds().getTopLeft();
		}
		return null;			
	}
}
