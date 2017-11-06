/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.celleditor.config;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.IDisplayConverter;
import org.eclipse.nebula.widgets.nattable.data.validate.IDataValidator;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.painter.cell.ICellPainter;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

/**
 * Bridge between the old {@link IAxisCellEditorConfiguration} and the new {@link ICellAxisConfiguration}
 *
 * CellEditors which extend this class can be declared on the org.eclipse.papyrus.infra.nattable.celleditor.configuration
 * extension point, using any of the following elements:
 * - configuration (Old one)
 * - cellAxisConfiguration (New one)
 *
 * @author Camille Letavernier
 *
 */
public abstract class AbstractCellAxisConfiguration implements ICellAxisConfiguration, IAxisCellEditorConfiguration {

	protected static final INattableModelManager getModelManager(IConfigRegistry fromRegistry) {
		return fromRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
	}

	protected static final Table getTable(IConfigRegistry fromRegistry) {
		INattableModelManager manager = getModelManager(fromRegistry);
		if (manager == null) {
			return null;
		}
		return manager.getTable();
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.ICellAxisConfiguration#configureCellEditor(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object, java.lang.String)
	 *
	 * @param configRegistry
	 * @param axis
	 * @param configLabel
	 */
	@Override
	public void configureCellEditor(IConfigRegistry configRegistry, Object axis, String configLabel) {
		final INattableModelManager modelManager = getModelManager(configRegistry);
		final Table table = modelManager.getTable();

		final String displayMode = getDisplayMode(table, axis);

		final ICellPainter painter = getCellPainter(table, axis);
		final ICellEditor editor = getICellEditor(table, axis, modelManager.getTableAxisElementProvider());
		final IDisplayConverter converter = getDisplayConvert(table, axis, new EMFLabelProvider());// TODO : label provider
		final IDataValidator validator = getDataValidator(table, axis);

		if (painter != null) {
			configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER, painter, displayMode, configLabel);
		}

		if (editor != null) {
			configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, editor, displayMode, configLabel);
		}

		if (converter != null) {
			configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, converter, displayMode, configLabel);
		}

		if (validator != null) {
			configRegistry.registerConfigAttribute(EditConfigAttributes.DATA_VALIDATOR, validator, displayMode, configLabel);
		}
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration#getDataValidator(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 *
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public IDataValidator getDataValidator(Table table, Object axisElement) {
		return null; // To be overridden by clients if necessary
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration#getDisplayConvert(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object, org.eclipse.jface.viewers.ILabelProvider)
	 *
	 * @param table
	 * @param axisElement
	 * @param provider
	 * @return
	 */
	@Override
	public IDisplayConverter getDisplayConvert(Table table, Object axisElement, ILabelProvider provider) {
		return null; // To be overridden by clients if necessary
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.config.IAxisCellEditorConfiguration#getDisplayMode(org.eclipse.papyrus.infra.nattable.model.nattable.Table, java.lang.Object)
	 *
	 * @param table
	 * @param axisElement
	 * @return
	 */
	@Override
	public String getDisplayMode(Table table, Object axisElement) {
		return DisplayMode.NORMAL; // To be overridden by clients if necessary
	}


}
