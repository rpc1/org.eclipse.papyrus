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

package org.eclipse.papyrus.infra.nattable.manager.cell;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 * @author VL222926
 *         This interface provides methods to unset cell values, that is to say to reset values to the default value
 */
public interface IUnsetValueCellManager extends ICellManager {

	/**
	 * @param domain
	 *            the editing domain to use
	 * @param columnElement
	 *            a column element
	 * @param rowElement
	 *            a row element
	 * @param tableManager
	 *            the table manager
	 */
	void unsetCellValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, INattableModelManager tableManager);

	/**
	 * @param domain
	 *            the editing domain to use
	 * @param columnElement
	 *            a column element
	 * @param rowElement
	 *            a row element
	 * @param tableManager
	 *            the table manager
	 */
	Command getUnsetCellValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, INattableModelManager tableManager);

	//not done because only 24 feature are unsettable in UML.ecore, but the generated code is able to do the EMF Unset (SetCommand(domain, edited object, feature, SetCommand.UNSET_VALUE)
	//boolean isUnsettable( Object columnElement, Object rowElement, INattableModelManager tableManager);
}

