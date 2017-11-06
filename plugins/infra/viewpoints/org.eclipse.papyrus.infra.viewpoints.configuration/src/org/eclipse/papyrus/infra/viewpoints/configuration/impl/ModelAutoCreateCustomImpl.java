/**
 * Copyright (c) 2015 CEA LIST.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Benoit Maggi benoit.maggi@cea.fr - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.viewpoints.configuration.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.viewpoints.configuration.ModelAutoCreate;
import org.eclipse.papyrus.infra.viewpoints.configuration.OwningRule;


public class ModelAutoCreateCustomImpl extends ModelAutoCreateImpl implements ModelAutoCreate {
	
	
	/**
	 * @see org.eclipse.papyrus.infra.viewpoints.configuration.impl.ModelAutoCreateImpl#basicGetOrigin()
	 *
	 * @return
	 */
	@Override
	public EClass basicGetOrigin() {
		OwningRule rule = (OwningRule) this.eContainer();
		EList<ModelAutoCreate> list = rule.getNewModelPath();
		int index = list.indexOf(this);
		if (index == 0) {
			return rule.getElement();
		}
			
		return null; // FIXME used to be : list.get(index - 1).getCreationType();
	}
	
	
}
