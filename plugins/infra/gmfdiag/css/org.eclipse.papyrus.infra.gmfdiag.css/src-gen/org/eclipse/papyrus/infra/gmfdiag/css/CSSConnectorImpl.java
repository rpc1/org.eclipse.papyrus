/*****************************************************************************
 * Copyright (c) 2012, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 433206
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.impl.ConnectorImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.engine.ExtendedCSSEngine;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.ForceValueHelper;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSConnectorStyle;
import org.eclipse.papyrus.infra.gmfdiag.css.style.CSSView;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSConnectorStyleDelegate;
import org.eclipse.papyrus.infra.gmfdiag.css.style.impl.CSSViewDelegate;

public class CSSConnectorImpl extends ConnectorImpl implements CSSConnectorStyle, CSSView {

	protected ExtendedCSSEngine engine;

	private CSSConnectorStyle connectorStyle;

	private CSSView cssView;

	protected CSSConnectorStyle getConnectorStyle() {
		if (connectorStyle == null) {
			connectorStyle = new CSSConnectorStyleDelegate(this, getEngine());
		}
		return connectorStyle;
	}

	protected ExtendedCSSEngine getEngine() {
		if (engine == null) {
			engine = ((CSSDiagramImpl) getDiagram()).getEngine();
		}
		return engine;
	}

	protected CSSView getCSSView() {
		if (cssView == null) {
			cssView = new CSSViewDelegate(this, getEngine());
		}
		return cssView;
	}


	// ////////////////////////////////////////
	// Forwards accesses to CSS properties //
	// ////////////////////////////////////////


	@Override
	public int getCSSRoundedBendpointsRadius() {
		int value = super.getRoundedBendpointsRadius();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSRoundedBendpointsRadius();
		}
	}

	@Override
	public Routing getCSSRouting() {
		Routing value = super.getRouting();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_Routing(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSRouting();
		}
	}

	@Override
	public Smoothness getCSSSmoothness() {
		Smoothness value = super.getSmoothness();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_Smoothness(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSSmoothness();
		}
	}

	@Override
	public boolean isCSSAvoidObstructions() {
		boolean value = super.isAvoidObstructions();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSAvoidObstructions();
		}
	}

	@Override
	public boolean isCSSClosestDistance() {
		boolean value = super.isClosestDistance();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSClosestDistance();
		}
	}

	@Override
	public JumpLinkStatus getCSSJumpLinkStatus() {
		JumpLinkStatus value = super.getJumpLinkStatus();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSJumpLinkStatus();
		}
	}

	@Override
	public JumpLinkType getCSSJumpLinkType() {
		JumpLinkType value = super.getJumpLinkType();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSJumpLinkType();
		}
	}

	@Override
	public boolean isCSSJumpLinksReverse() {
		boolean value = super.isJumpLinksReverse();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse(), value)) {
			return value;
		} else {
			return getConnectorStyle().isCSSJumpLinksReverse();
		}
	}

	@Override
	public int getCSSLineColor() {
		int value = super.getLineColor();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getLineStyle_LineColor(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSLineColor();
		}
	}

	@Override
	public int getCSSLineWidth() {
		int value = super.getLineWidth();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getLineStyle_LineWidth(), value)) {
			return value;
		} else {
			return getConnectorStyle().getCSSLineWidth();
		}
	}


	@Override
	public int getRoundedBendpointsRadius() {
		// return super.getRoundedBendpointsRadius();
		return getCSSRoundedBendpointsRadius();
	}

	@Override
	public Routing getRouting() {
		// return super.getRouting();
		return getCSSRouting();
	}

	@Override
	public Smoothness getSmoothness() {
		// return super.getSmoothness();
		return getCSSSmoothness();
	}

	@Override
	public boolean isAvoidObstructions() {
		// return super.isAvoidObstructions();
		return isCSSAvoidObstructions();
	}

	@Override
	public boolean isClosestDistance() {
		// return super.isClosestDistance();
		return isCSSClosestDistance();
	}

	@Override
	public JumpLinkStatus getJumpLinkStatus() {
		// return super.getJumpLinkStatus();
		return getCSSJumpLinkStatus();
	}

	@Override
	public JumpLinkType getJumpLinkType() {
		// return super.getJumpLinkType();
		return getCSSJumpLinkType();
	}

	@Override
	public boolean isJumpLinksReverse() {
		// return super.isJumpLinksReverse();
		return isCSSJumpLinksReverse();
	}

	@Override
	public int getLineColor() {
		// return super.getLineColor();
		return getCSSLineColor();
	}

	@Override
	public int getLineWidth() {
		// return super.getLineWidth();
		return getCSSLineWidth();
	}

	@Override
	public boolean isVisible() {
		return isCSSVisible();
	}

	@Override
	public boolean isCSSVisible() {
		boolean value = super.isVisible();

		if (ForceValueHelper.isSet(this, NotationPackage.eINSTANCE.getView_Visible(), value)) {
			return value;
		} else {
			return getCSSView().isCSSVisible();
		}
	}



	// //////////////////////////////////////////////
	// Implements a setter for each CSS property //
	// //////////////////////////////////////////////

	@Override
	public void setVisible(boolean value) {
		super.setVisible(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Visible();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setType(java.lang.String value) {
		super.setType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Type();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setMutable(boolean value) {
		super.setMutable(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getView_Mutable();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setRoundedBendpointsRadius(int value) {
		super.setRoundedBendpointsRadius(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoundedCornersStyle_RoundedBendpointsRadius();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setRouting(Routing value) {
		super.setRouting(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_Routing();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setSmoothness(Smoothness value) {
		super.setSmoothness(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_Smoothness();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setAvoidObstructions(boolean value) {
		super.setAvoidObstructions(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_AvoidObstructions();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setClosestDistance(boolean value) {
		super.setClosestDistance(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_ClosestDistance();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setJumpLinkStatus(JumpLinkStatus value) {
		super.setJumpLinkStatus(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkStatus();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setJumpLinkType(JumpLinkType value) {
		super.setJumpLinkType(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinkType();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setJumpLinksReverse(boolean value) {
		super.setJumpLinksReverse(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getRoutingStyle_JumpLinksReverse();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setLineColor(int value) {
		super.setLineColor(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineColor();
		ForceValueHelper.setValue(this, feature, value);
	}

	@Override
	public void setLineWidth(int value) {
		super.setLineWidth(value);

		EStructuralFeature feature = NotationPackage.eINSTANCE.getLineStyle_LineWidth();
		ForceValueHelper.setValue(this, feature, value);
	}

	// ////////////////////////////////
	// Implements the unset method //
	// ////////////////////////////////

	@Override
	public void eUnset(int featureId) {
		super.eUnset(featureId);

		EStructuralFeature feature = eClass().getEStructuralFeature(featureId);
		ForceValueHelper.unsetValue(this, feature);
	}

	// ////////////////////////////////
	// Implements the getNamedStyle //
	// ////////////////////////////////

	@Override
	public NamedStyle getNamedStyle(EClass eClass, String name) {
		return getCSSNamedStyle(eClass, name);
	}

	@Override
	public NamedStyle getCSSNamedStyle(EClass eClass, String name) {
		NamedStyle userStyle = super.getNamedStyle(eClass, name);
		if (userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSNamedStyle(eClass, name);
	}

	// /////////////////////////////////
	// Implements the getStyle method //
	// /////////////////////////////////

	@Override
	public Style getStyle(EClass eClass) {
		return getCSSStyle(eClass);
	}

	@Override
	public Style getCSSStyle(EClass eClass) {
		Style userStyle = super.getStyle(eClass);
		if (userStyle != null) {
			return userStyle;
		}

		return getCSSView().getCSSStyle(eClass);
	}


}
