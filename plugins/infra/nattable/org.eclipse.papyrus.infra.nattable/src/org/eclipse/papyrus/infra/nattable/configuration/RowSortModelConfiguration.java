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

package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.sort.ISortModel;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

/**
 * @author VL222926
 *         This class allows to register the sort model used by nattable
 */
public class RowSortModelConfiguration extends AbstractRegistryConfiguration {

	/**
	 * the sort model used by the table
	 */
	private final ISortModel sortModel;

	/**
	 * Constructor.
	 *
	 */
	public RowSortModelConfiguration(ISortModel sortModel) {
		this.sortModel = sortModel;
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 *
	 * @param configRegistry
	 */
	@Override
	public void configureRegistry(IConfigRegistry configRegistry) {
		configRegistry.registerConfigAttribute(NattableConfigAttributes.ROW_SORT_MODEl, this.sortModel);
	}
}