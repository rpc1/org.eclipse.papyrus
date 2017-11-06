package org.eclipse.papyrus.uml.nattable.stereotype.display.manager.cell;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;

/**
 * Used to get Rows in the Stereotype Display Tree Table. From the Selection.
 *
 */
public class TableSelectionProviderCellManager implements ICellManager {


	private final static String SELECTION_VIEW = "gmf_custom:/diagramSelectionView"; // $NON-NLS-0$

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		return SELECTION_VIEW.equals(AxisUtils.getRepresentedElement(columnElement));

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getValue(java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	public Object getValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		return EMPTY_STRING;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setValue(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 */
	@Override
	public void setValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {
		// nothing to do

	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement) {

		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getSetStringValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain, java.lang.Object, java.lang.Object, java.lang.String,
	 *      org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 *
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param valueConverter
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetStringValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, String newValue, AbstractStringValueConverter valueConverter, INattableModelManager tableManager) {

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#getOrCreateStringValueConverterClass(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Map, java.lang.String)
	 *
	 * @param tableManager
	 * @param existingConverters
	 * @param multiValueSeparator
	 * @return
	 */
	@Override
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, String multiValueSeparator) {

		return null;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#isCellEditable(java.lang.Object, java.lang.Object, java.util.Map)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param sharedMap
	 * @return
	 */
	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement, Map<?, ?> sharedMap) {

		return false;
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager#setStringValue(java.lang.Object, java.lang.Object, java.lang.String, org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager, java.util.Map)
	 *
	 * @param columnElement
	 * @param rowElement
	 * @param valueAsString
	 * @param valueConverter
	 * @param tableManager
	 * @param sharedMap
	 */
	@Override
	public void setStringValue(Object columnElement, Object rowElement, String valueAsString, AbstractStringValueConverter valueConverter, INattableModelManager tableManager, Map<?, ?> sharedMap) {
		// nothing to do

	}

}
