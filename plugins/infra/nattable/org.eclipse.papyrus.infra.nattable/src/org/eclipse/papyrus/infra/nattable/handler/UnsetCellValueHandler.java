package org.eclipse.papyrus.infra.nattable.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.nebula.widgets.nattable.selection.SelectionLayer;
import org.eclipse.papyrus.infra.nattable.manager.cell.CellManagerFactory;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.TableSelectionWrapper;

/**
 * 
 * This handler is used to unset cell values, that is to say, than we reset the cell value to the default value
 *
 */
public class UnsetCellValueHandler extends AbstractTableHandler {

	/**
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 *
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if (!canUnsetCell(event)) {
			return null;
		}
		TableSelectionWrapper wrapper = getTableSelectionWrapper(event);
		CompoundCommand cc = new CompoundCommand("Unset cell values"); //$NON-NLS-1$
		for (PositionCoordinate current : wrapper.getSelectedCells()) {
			int colPosition = current.getColumnPosition();
			int rowposition = current.getRowPosition();

			INattableModelManager manager = getCurrentNattableModelManager();
			SelectionLayer layer = manager.getBodyLayerStack().getSelectionLayer();
			int colIndex = layer.getColumnIndexByPosition(colPosition);
			int rowIndex = layer.getRowIndexByPosition(rowposition);
			Object columnElement = AxisUtils.getRepresentedElement(manager.getColumnElement(colIndex));
			Object rowElement = AxisUtils.getRepresentedElement(manager.getRowElement(rowIndex));

			Command command = CellManagerFactory.INSTANCE.getUnsetCellValueCommand(getContextEditingDomain(), columnElement, rowElement, manager);
			if (command != null && command.canExecute()) {
				cc.append(command);
			}
		}

		if (!cc.isEmpty() && cc.canExecute()) {
			getContextEditingDomain().getCommandStack().execute(cc);
		}
		return null;
	}


	/**
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 *
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		super.setEnabled(evaluationContext);
		if (isEnabled()) {
			boolean enabled = canUnsetCell(evaluationContext);
			setBaseEnabled(enabled);
		}
	}

	/**
	 * 
	 * @param evaluationContext
	 * 
	 * @return
	 *         <code>true</code> if cells are selected (any selected region must be managed)
	 */
	protected boolean canUnsetCell(Object evaluationContext) {
		final TableSelectionWrapper wrapper = getTableSelectionWrapper(evaluationContext);
		return null != wrapper ? !wrapper.getSelectedCells().isEmpty() : false;
	}
}
