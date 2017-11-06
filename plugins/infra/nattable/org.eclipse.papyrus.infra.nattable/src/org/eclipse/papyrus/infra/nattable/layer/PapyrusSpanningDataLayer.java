/*****************************************************************************
 * Copyright (c) 2014-2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Camille Letavernier - CEA LIST - Bug 464168 - Use the Context's EditingDomain
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.nattable.layer;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.coordinate.Range;
import org.eclipse.nebula.widgets.nattable.data.ISpanningDataProvider;
import org.eclipse.nebula.widgets.nattable.layer.SpanningDataLayer;
import org.eclipse.nebula.widgets.nattable.util.ArrayUtil;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;

/**
 *
 * @author QL238289
 * @see org.eclipse.nebula.widgets.nattable.layer.SpanningDataLayer
 *
 *
 */
public class PapyrusSpanningDataLayer extends SpanningDataLayer {

	private TransactionalEditingDomain contextDomain;

	private INattableModelManager manager;

	/**
	 * Constructor.
	 *
	 * @param dataProvider
	 * @param defaultColumnWidth
	 * @param defaultRowHeight
	 */
	public PapyrusSpanningDataLayer(final TransactionalEditingDomain contextDomain, ISpanningDataProvider dataProvider, int defaultColumnWidth, int defaultRowHeight) {
		super(dataProvider, defaultColumnWidth, defaultRowHeight);
		this.contextDomain = contextDomain;

	}

	/**
	 * Constructor.
	 *
	 * @param dataProvider
	 */
	public PapyrusSpanningDataLayer(final TransactionalEditingDomain contextDomain, ISpanningDataProvider dataProvider) {
		super(dataProvider);
		this.contextDomain = contextDomain;
	}


	/**
	 * Constructor.
	 *
	 * @param contextEditingDomain
	 * @param manager
	 * @param spanProvider
	 * @param defaultCellWidth
	 * @param defaultCellHeight
	 */
	public PapyrusSpanningDataLayer(TransactionalEditingDomain contextEditingDomain, INattableModelManager manager,
			ISpanningDataProvider spanProvider, int defaultCellWidth, int defaultCellHeight) {
		super(spanProvider, defaultCellWidth, defaultCellHeight);
		this.contextDomain = contextEditingDomain;
		this.manager = manager;
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.SpanningDataLayer#setDataValue(int, int, java.lang.Object)
	 *
	 * @param columnIndex
	 * @param rowIndex
	 * @param newValue
	 */
	@Override
	public void setDataValue(final int columnIndex, final int rowIndex, final Object newValue) {
		RecordingCommand recordUpdate = new RecordingCommand(this.contextDomain) {

			@Override
			protected void doExecute() {
				// AbstractCellManager's setValue() takes care of the compatibility between the cell and the edit types
				// 469109: [Tree Table] set value problem when categories are hidden
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=469109
				PapyrusSpanningDataLayer.super.setDataValue(columnIndex, rowIndex, newValue);
			}
		};
		this.contextDomain.getCommandStack().execute(recordUpdate);
	}
}
