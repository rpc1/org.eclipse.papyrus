/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.constraints.constraints.JavaQuery;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.CreatableEObjectAxisUtils;

/**
 *
 * @author VL222926
 *
 */
public class CanCreateColumnElementContraint implements JavaQuery {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.constraints.constraints.JavaQuery#match(java.lang.Object)
	 *
	 * @param selection
	 * @return
	 */
	@Override
	public boolean match(Object selection) {
		final EObject table = EMFHelper.getEObject(selection);
		return CreatableEObjectAxisUtils.getCreatableElementIds((Table) table, true).size() != 0;
	}

}
