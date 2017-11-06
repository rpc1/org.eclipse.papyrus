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
package org.eclipse.papyrus.infra.elementtypesconfigurations.impl;

import java.net.URL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredHintedElementType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration;

public class ConfiguredHintedMetamodelElementType extends MetamodelType implements IConfiguredHintedElementType {

	private String semanticHint;

	private ElementTypeConfiguration configuration;

	public ConfiguredHintedMetamodelElementType(String id, URL iconURL, String displayName, EClass eClass, IEditHelper editHelper, String semanticHint, MetamodelTypeConfiguration configuration) {
		super(id, iconURL, displayName, eClass, editHelper);
		this.semanticHint = semanticHint;
		this.configuration = configuration;
	}

	public String getSemanticHint() {
		return semanticHint;
	}

	public void setSemanticHint(String semanticHint) {
		this.semanticHint = semanticHint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Configured Metamodel Type: " + getDisplayName() + " [" + getId() + "]";
	}

	/**
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredHintedElementType#getConfiguration()
	 *
	 * @return
	 */
	@Override
	public ElementTypeConfiguration getConfiguration() {
		return configuration;
	}
}
