/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.diagram.blockdefinition.factory;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.core.view.factories.ViewFactory;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.uml2.uml.Operation;

public class PortViewFactory implements ViewFactory {

	/**
	 * visual ID for stereotype label of border item
	 */
//	protected static final String OPERATION_BORDER_ITEM_STEREOTYPE_LABEL = "Operation_BorderItem_Stereotype_Label";
	/**
	 * visual ID for name label of border item
	 */
	protected static final String OPERATION_BORDER_ITEM_LABEL = "Operation_BorderItem_Label";
	@Override
	public View createView(IAdaptable semanticAdapter, View containerView, String semanticHint, int index,	boolean persisted, PreferencesHint preferencesHint) {
		return createPort((EObject)semanticAdapter.getAdapter(EObject.class), containerView,semanticHint, index, persisted, preferencesHint);
	}
	public Node createPort(EObject domainElement, View containerView,String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		
		Operation o;
		
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(semanticHint);
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Port");
		Node label5125 = createLabel(node, OPERATION_BORDER_ITEM_LABEL);
		label5125.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5125 = (Location)label5125.getLayoutConstraint();
		location5125.setX(25);
		location5125.setY(3);
		return node;
	}
	protected Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

}
