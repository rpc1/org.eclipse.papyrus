/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfiguredHintedMetamodelElementType;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;

public class MetamodelTypeFactory extends AbstractElementTypeConfigurationFactory<MetamodelTypeConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public IHintedType createElementType(MetamodelTypeConfiguration configuration) {
		return new ConfiguredHintedMetamodelElementType(getID(configuration), getIconURL(configuration), getDisplayName(configuration), getEClass(configuration), createEditHelper(configuration), getSemanticHint(configuration), configuration);
	}

	protected EClass getEClass(MetamodelTypeConfiguration configuration) {
		return configuration.getEClass();
	}

	protected IEditHelper createEditHelper(MetamodelTypeConfiguration configuration) {
		String editHelperClassName = configuration.getEditHelperClassName();
		if (editHelperClassName == null) {
			return null;
		}
		IEditHelper editHelper = ClassLoaderHelper.newInstance(editHelperClassName, IEditHelper.class);
		return editHelper;
	}
}
