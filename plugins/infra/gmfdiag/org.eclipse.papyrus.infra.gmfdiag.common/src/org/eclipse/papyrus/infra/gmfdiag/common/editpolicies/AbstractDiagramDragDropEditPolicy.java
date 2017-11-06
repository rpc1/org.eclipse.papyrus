/*****************************************************************************
 * Copyright (c) 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;

/**
 * This class is used to group all default Drag&drop behavior in Papyrus.
 */
public abstract class AbstractDiagramDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/** The specific drop. */
	private Set<Integer> specificDrop = null;

	/**
	 * The list of visualID that the policy manages.
	 */
	protected abstract Set<Integer> getDroppableElementVisualId();
		
	
	/**
	 * Gets elements visual id that can be dropped in the diagram
	 */
	protected Set<Integer> getSpecificDrop() {
		if (specificDrop == null) {
			specificDrop = getDroppableElementVisualId();
		}
		return specificDrop;
	}


}
