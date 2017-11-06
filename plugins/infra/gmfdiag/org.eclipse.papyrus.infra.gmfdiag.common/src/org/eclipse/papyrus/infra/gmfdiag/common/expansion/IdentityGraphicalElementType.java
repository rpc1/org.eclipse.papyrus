/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.expansion;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.IGraphicalTypeRegistry;

/**
 * This class is used to know all graphical type that can be added in the diagram.
 * By default it accepts all. This is the ExpandViewProvider that verify the job
 * #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_010
 *
 */
public class IdentityGraphicalElementType implements  IGraphicalTypeRegistry {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEdgeGraphicalType(EObject domainElement) {
		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEdgeGraphicalType(IElementType elementType) {
		if (elementType instanceof IHintedType) {
			String semanticHint = ((IHintedType) elementType).getSemanticHint();
			return getEdgeGraphicalType(semanticHint);
		}
		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getEdgeGraphicalType(String proposedType) {
			return proposedType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNodeGraphicalType(EObject domainElement, String containerType) {
		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNodeGraphicalType(IElementType elementType, String containerType) {
		if (elementType instanceof IHintedType) {
			String semanticHint = ((IHintedType) elementType).getSemanticHint();
			return getNodeGraphicalType(semanticHint, containerType);
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNodeGraphicalType(String proposedType, String containerType) {
			return proposedType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isKnownEdgeType(String type) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isKnownNodeType(String type) {
		return true;
	}
}
