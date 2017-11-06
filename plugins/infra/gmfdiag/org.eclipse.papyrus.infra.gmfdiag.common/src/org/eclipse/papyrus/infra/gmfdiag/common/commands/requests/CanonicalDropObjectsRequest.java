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

package org.eclipse.papyrus.infra.gmfdiag.common.commands.requests;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;

/**
 * A request to drop objects into an {@link EditPart} as canonical children,
 * which is a "canonical drop".
 */
public class CanonicalDropObjectsRequest extends Request {
	/** The request type for the "canonical drop" command. */
	public static final String REQ_CANONICAL_DROP_OBJECTS = "org.eclipse.papyrus.CANONICAL_DROP_OBJECTS";

	private final DropObjectsRequest dropRequest;

	/**
	 * Initializes me with a {@code dropRequest} that I encapsulate as a "canonical drop".
	 * 
	 * @param dropRequest
	 *            the drop request to encapsulate
	 */
	public CanonicalDropObjectsRequest(DropObjectsRequest dropRequest) {
		super(REQ_CANONICAL_DROP_OBJECTS);

		this.dropRequest = dropRequest;
	}

	/**
	 * Obtains the request that provides details of the "canonical drop".
	 * Edit policies may choose to forward this to other edit policies if they need to.
	 * 
	 * @return the drop request
	 */
	public final DropObjectsRequest getDropObjectsRequest() {
		return dropRequest;
	}
}
