/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Christian W. Damus - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.canonical;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * Custom semantic children strategy for structured classifiers presented (usually as the frame)
 * in a composite structure diagram.
 */
public class StructuredClassifierSemanticChildrenStrategy extends DefaultUMLSemanticChildrenStrategy {

	public StructuredClassifierSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticChildren(EObject semanticFromEditPart, View viewFromEditPart) {
		List<? extends EObject> result;

		StructuredClassifier composite = (semanticFromEditPart instanceof StructuredClassifier) ? (StructuredClassifier) semanticFromEditPart : null;
		if (composite == null) {
			result = super.getCanonicalSemanticChildren(semanticFromEditPart, viewFromEditPart);
		} else {
			// The children of a structured classifier that we present are only its structural
			// features (parts, ports, connectors), remembering that connectors are handled by
			// the getCanonicalSemanticConnections(...) method for connectable elements
			result = new java.util.ArrayList<>(composite.getOwnedAttributes());
		}

		return result;
	}
}
