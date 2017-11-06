/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.nattable.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.nebula.widgets.nattable.layer.ILayerListener;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.nebula.widgets.nattable.selection.event.ISelectionEvent;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;
import org.eclipse.papyrus.infra.tools.util.ListHelper;
import org.eclipse.ui.services.IDisposable;

/**
 *
 * The selection provider used by the table. The returned selection is used to display property views or to do the synchronization in the
 * ModelExplorer
 *
 */
public class TableSelectionProvider implements ISelectionProvider, IDisposable, ILayerListener {

	/**
	 * the selection layer used in the table
	 */
	private SelectionLayer selectionLayer;

	/**
	 * the selection listener
	 */
	private final ILayerListener selectionListener;

	/**
	 * the current selection in the table
	 */
	private ISelection currentSelection;

	/**
	 * the list of listener on the selections
	 */
	private final List<ISelectionChangedListener> listeners;

	/**
	 * the table model manager to use to find selected elements
	 */
	private INattableModelManager manager;

	/**
	 * boolean indicating than the class is disposed
	 */
	private boolean isDisposed = false;

	/**
	 *
	 * Constructor.
	 *
	 * @param manager
	 *            the table model manager to use to find selected elements
	 * @param selectionLayer
	 */
	public TableSelectionProvider(final INattableModelManager manager, final SelectionLayer selectionLayer) {
		this.selectionLayer = selectionLayer;
		this.selectionListener = this;
		this.selectionLayer.addLayerListener(this.selectionListener);
		this.currentSelection = new StructuredSelection();
		this.listeners = new ArrayList<ISelectionChangedListener>();
		this.manager = manager;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 *
	 * @param listener
	 */
	@Override
	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.add(listener);
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 *
	 * @return
	 */
	@Override
	public synchronized ISelection getSelection() {
		return this.currentSelection;
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 *
	 * @param listener
	 */
	@Override
	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 *
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 *
	 * @param selection
	 */
	@Override
	public synchronized void setSelection(final ISelection selection) {
		if (this.currentSelection.equals(selection)) {
			return;
		}
		this.currentSelection = selection;
		final SelectionChangedEvent event = new SelectionChangedEvent(this, this.currentSelection);
		for (final ISelectionChangedListener current : this.listeners) {
			current.selectionChanged(event);
		}
	}

	/**
	 *
	 * @param event
	 *            an event
	 */
	protected/* synchronized */void calculateAndStoreNewSelection(final ILayerEvent event) {
		// the list of the selected elements
		final Collection<Object> selection = new HashSet<Object>();
		final ISelection newSelection;
		if (event instanceof ISelectionEvent) {
			// we are not able to distinguish the 2 ways to select a full axis :
			// - first way : clicking on axis header
			// - second way : clicking on first cell of the axis, Pressing SHIFT, clicking on the last cell of the axis (or selecting each cell of the axis pressing CTRL)
			// so we are not able to know if the user want to select the element represented by the axis OR all values displayed on the axis, without the element represented by the axis
			// we decided to implements this behavior for all kind of selection event :
			// 1- we add in the selection elements represented by fully selected rows
			// 2- we add in the selection elements represented by fully selected columns
			// 3- we add in the selection the contents of selected cell which are not included in the fully selected axis

			final Collection<PositionCoordinate> selectedCells =ListHelper.asList(this.selectionLayer.getSelectedCellPositions());
			final Map<Integer, Object> fullySelectedRows = new HashMap<Integer, Object>();
			final Map<Integer, Object> fullySelectedColumns = new HashMap<Integer, Object>();



			final List<Integer> selectedRowsIndexes = new ArrayList<Integer>();
			for (int i : this.selectionLayer.getFullySelectedRowPositions()) {
				int rowIndex = this.selectionLayer.getRowIndexByPosition(i);
				selectedRowsIndexes.add(new Integer(rowIndex));
				Object el = this.manager.getRowElement(rowIndex);
				if (el != null) {
					fullySelectedRows.put(Integer.valueOf(rowIndex), el);
					el = AxisUtils.getRepresentedElement(el);
					selection.add(el);
				}
			}
			final List<Integer> selectedColumnsIndexes = new ArrayList<Integer>();
			for (int i : this.selectionLayer.getFullySelectedColumnPositions()) {
				int columnIndex = this.selectionLayer.getColumnIndexByPosition(i);
				selectedColumnsIndexes.add(new Integer(columnIndex));
				Object el = this.manager.getColumnElement(columnIndex);
				if (el != null) {
					fullySelectedColumns.put(Integer.valueOf(columnIndex), el);
					el = AxisUtils.getRepresentedElement(el);
					selection.add(el);
				}
			}

			for (final PositionCoordinate cellLocation : selectedCells) {
				final int colPos = cellLocation.getColumnPosition();
				final int rowPos = cellLocation.getRowPosition();
				if (!selectedColumnsIndexes.contains(new Integer(this.selectionLayer.getColumnIndexByPosition(colPos))) && !selectedRowsIndexes.contains(new Integer(this.selectionLayer.getRowIndexByPosition(rowPos)))) {
					final ILayerCell cell = this.selectionLayer.getCellByPosition(colPos, rowPos);
					if (cell != null) {
						final Object value = cell.getDataValue();
						if (value != null) {
							if (value instanceof Collection<?>) {
								final Iterator<?> iter = ((Collection<?>) value).iterator();
								while (iter.hasNext()) {
									final Object current = iter.next();
									selection.add(current);
								}
							} else {
								selection.add(value);
							}
						}
					}
				}
			}
			final TableSelectionWrapper wrapper = new TableSelectionWrapper(selectedCells, fullySelectedRows, fullySelectedColumns);
			newSelection = new TableStructuredSelection(selection.toArray(), wrapper);
		} else {
			newSelection = new StructuredSelection();
		}
		setSelection(newSelection);
	}



	/**
	 *
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 *
	 */
	@Override
	public void dispose() {
		this.isDisposed = true;
		this.manager = null;
		//to be sure, to fix the bug 469376: [Table] Memory Leak : (Tree)NattableWidgetManager, EObjectTreeItemAxis and others objects are not disposed when the table is closed
//		https://bugs.eclipse.org/bugs/show_bug.cgi?id=469376
		setSelection(StructuredSelection.EMPTY);
		
		if (this.selectionLayer != null) {
			this.selectionLayer.removeLayerListener(this.selectionListener);
			this.selectionLayer = null;
		}
		this.listeners.clear();
	}

	/**
	 * @see org.eclipse.nebula.widgets.nattable.layer.ILayerListener#handleLayerEvent(org.eclipse.nebula.widgets.nattable.layer.event.ILayerEvent)
	 *
	 * @param event
	 */
	@Override
	public void handleLayerEvent(ILayerEvent event) {
		if (!isDisposed && event instanceof ISelectionEvent) {
			calculateAndStoreNewSelection(event);
		}
	}
}
