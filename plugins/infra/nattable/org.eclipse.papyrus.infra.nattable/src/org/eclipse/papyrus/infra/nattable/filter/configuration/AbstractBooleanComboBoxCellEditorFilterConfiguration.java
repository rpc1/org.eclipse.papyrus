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

package org.eclipse.papyrus.infra.nattable.filter.configuration;

import java.util.Arrays;
import java.util.List;

import org.eclipse.nebula.widgets.nattable.config.CellConfigAttributes;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.data.convert.DefaultBooleanDisplayConverter;
import org.eclipse.nebula.widgets.nattable.edit.EditConfigAttributes;
import org.eclipse.nebula.widgets.nattable.edit.editor.ComboBoxCellEditor;
import org.eclipse.nebula.widgets.nattable.edit.editor.ICellEditor;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.nattable.filter.BooleanMatcherEditorFactory;
import org.eclipse.papyrus.infra.nattable.filter.IPapyrusMatcherEditorFactory;
import org.eclipse.papyrus.infra.nattable.manager.cell.ICellManager;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;

/**
 * The abstract class for boolean filter using combo
 *
 */
public abstract class AbstractBooleanComboBoxCellEditorFilterConfiguration implements IFilterConfiguration {

	/**
	 * the avalable values to boolean combo cell editor
	 */
	protected static final List<?> availableValue = Arrays.asList(new Object[] { ICellManager.NOT_AVALAIBLE, Boolean.TRUE, Boolean.FALSE });

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.IFilterConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry, java.lang.Object, java.lang.String, List<Object>)
	 *
	 * @param configRegistry
	 * @param configLabel
	 * @param columnElement
	 */
	@Override
	public void configureFilter(IConfigRegistry configRegistry, Object columnElement, String configLabel) {
		ICellEditor editor = createICellEditor(configRegistry, columnElement, configLabel);
		configRegistry.registerConfigAttribute(EditConfigAttributes.CELL_EDITOR, editor, DisplayMode.NORMAL, configLabel);
		configRegistry.registerConfigAttribute(CellConfigAttributes.DISPLAY_CONVERTER, new DefaultBooleanDisplayConverter(), DisplayMode.NORMAL, configLabel);
		configRegistry.registerConfigAttribute(NattableConfigAttributes.MATCHER_EDITOR_FACTORY, createMatcherFactory(), DisplayMode.NORMAL, configLabel);
	}

	/**
	 * 
	 * @return
	 *         a new matcher factory
	 */
	protected IPapyrusMatcherEditorFactory<Object> createMatcherFactory() {
		return new BooleanMatcherEditorFactory();
	}

	/**
	 * 
	 * @param configRegistry
	 * @param columnElement
	 * @param configLabel
	 * @return
	 *         a new ICellEditor
	 */
	protected ICellEditor createICellEditor(IConfigRegistry configRegistry, Object columnElement, String configLabel) {
		return new ComboBoxCellEditor(availableValue);
	}

	/**
	 * @see org.eclipse.papyrus.infra.nattable.filter.configuration.IFilterConfiguration#getConfigurationDescription()
	 *
	 * @return
	 */
	@Override
	public String getConfigurationDescription() {
		return "This configuration provides an Combo to filter boolean values. Known values are true, false and N/A"; //$//$NON-NLS-1$
	}
}
