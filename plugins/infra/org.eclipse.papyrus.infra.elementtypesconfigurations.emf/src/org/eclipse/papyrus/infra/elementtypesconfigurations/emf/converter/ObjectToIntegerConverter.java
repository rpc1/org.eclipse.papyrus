/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.converter;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Converter from an object to an integer
 */
public class ObjectToIntegerConverter extends Converter implements IConverter {

	/**
	 * Default constructor.
	 */
	public ObjectToIntegerConverter() {
		super(Object.class, Integer.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer convert(Object fromObject) {
		if(fromObject == null) {
			return null;
		}

		if(fromObject instanceof Integer) {
			return (Integer)fromObject;
		}

		if(fromObject instanceof String) {
			return Integer.parseInt((String)fromObject);
		}

		return null;
	}

}
