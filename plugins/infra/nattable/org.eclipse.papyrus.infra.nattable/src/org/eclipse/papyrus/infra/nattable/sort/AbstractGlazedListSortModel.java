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

package org.eclipse.papyrus.infra.nattable.sort;

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.sort.ISortModel;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.ui.services.IDisposable;

/**
 * @author VL222926
 *
 */
public abstract class AbstractGlazedListSortModel implements ISortModel, ILayerListener, IDisposable {

	/**
	 * the table manager
	 */
	private INattableModelManager tableManager;

	/**
	 * 
	 * Constructor.
	 *
	 * @param manager
	 * the table manager to use
	 */
	public AbstractGlazedListSortModel(final INattableModelManager manager) {
		this.tableManager = manager;
	}

	/**
	 * 
	 * @return
	 *         the table manager to use
	 */
	protected final INattableModelManager getTableManager() {
		return this.tableManager;
	}

	/**
	 * 
	 * @return
	 *         the config registry to use
	 */
	protected final IConfigRegistry getIConfigRegistry() {
		NatTable natTable = (NatTable) this.tableManager.getAdapter(NatTable.class);
		return natTable.getConfigRegistry();
	}

	/**
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 *
	 */
	@Override
	public void dispose() {
		this.tableManager = null;
	}
}
