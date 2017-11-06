/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IndirectMaskLabelEditPolicy;

/**
 * this edit policy is used to update the label of the property from the primary shape not directly from the label
 *
 */
public class IndirectPropertyLabelEditPolicy extends PropertyLabelEditPolicy implements IndirectMaskLabelEditPolicy {


	/**
	 * Returns the view controlled by the host edit part
	 *
	 * @return the view controlled by the host edit part
	 */
	@Override
	protected View getView() {
		EditPart host = getHost();
		if (host == null) {
			return null;
		}

		Object hostView = host.getModel();
		if (hostView instanceof View) {
			Object parentView = ((View) hostView).eContainer();
			if (parentView instanceof View) {
				return (View) parentView;
			}
			return null;
		}
		return null;
	}

}