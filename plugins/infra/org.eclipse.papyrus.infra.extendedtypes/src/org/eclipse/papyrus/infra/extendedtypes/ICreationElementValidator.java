/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;


/**
 * Validator used to check if element can be created for a given {@link CreateElementRequest}
 */
public interface ICreationElementValidator {

	/**
	 * @param request
	 * @return
	 */
	public boolean canCreate(CreateElementRequest request);
}
