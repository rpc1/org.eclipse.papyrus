/*****************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;

/**
 *
 * @author vl222926
 *
 */
public class ColumnMasterDisconnectRowSlaveHandler extends AbstractDisconnectSlaveHandler {

	/**
	 *
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractDisconnectSlaveHandler#getAxisProviderToEdit()
	 *
	 * @return
	 */
	@Override
	protected AbstractAxisProvider getAxisProviderToEdit() {
		INattableModelManager currentNattableModelManager = getCurrentNattableModelManager();
		if (currentNattableModelManager == null ) {
			return null;
		}
		return AxisUtils.getAxisProviderUsedForColumns(currentNattableModelManager);
	}

}
