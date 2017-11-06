/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.communication.custom.canonical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.canonical.DefaultUMLSemanticChildrenStrategy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.MessageEnd;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Custom semantic-children strategy for lifelines in communication diagrams.
 */
public class LifelineSemanticChildrenStrategy extends DefaultUMLSemanticChildrenStrategy {

	public LifelineSemanticChildrenStrategy() {
		super();
	}

	@Override
	public List<? extends EObject> getCanonicalSemanticConnections(EObject semanticFromEditPart, View viewFromEditPart) {
		// We only have messages connected to lifelines in communication diagrams
		List<? extends EObject> result = null;

		Lifeline lifeline = (semanticFromEditPart instanceof Lifeline) ? (Lifeline) semanticFromEditPart : null;
		if (lifeline != null) {
			List<Element> messages = new ArrayList<Element>();
			result = messages;

			for (MessageEnd next : getMessageEnds(lifeline)) {
				if (next.getMessage() != null) {
					messages.add(next.getMessage());
				}
			}
		}

		return result;
	}

	Iterable<MessageEnd> getMessageEnds(Lifeline lifeline) {
		return Iterables.filter(lifeline.getCoveredBys(), MessageEnd.class);
	}

	@Override
	public Collection<? extends EObject> getCanonicalDependents(EObject semanticFromEditPart, View viewFromEditPart) {
		List<? extends EObject> result = null;

		Lifeline lifeline = (semanticFromEditPart instanceof Lifeline) ? (Lifeline) semanticFromEditPart : null;
		if (lifeline != null) {
			result = Lists.newArrayList(getMessageEnds(lifeline));
		}

		return result;
	}
}
