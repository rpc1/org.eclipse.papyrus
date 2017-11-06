/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Bug 476318
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.constraints;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.CreatableEObjectAxisUtils;

/**
 * This allows to define the constraint to not create the paste properties.
 */
public class CantCreateRowElementContraint extends HasTreeFillingConfigurationConstraint {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.properties.constraints.HasTreeFillingConfigurationConstraint#match(java.lang.Object)
	 */
	@Override
	public boolean match(final Object selection) {
		final EObject table = EMFHelper.getEObject(selection);
		return !super.match(selection) && 0 == CreatableEObjectAxisUtils.getCreatableElementIds((Table) table, false).size();
	}

}
