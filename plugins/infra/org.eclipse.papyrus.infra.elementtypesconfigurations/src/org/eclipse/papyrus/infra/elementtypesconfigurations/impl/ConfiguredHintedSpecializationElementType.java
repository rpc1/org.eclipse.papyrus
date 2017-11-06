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

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IConfiguredHintedElementType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;


public class ConfiguredHintedSpecializationElementType extends SpecializationType implements IConfiguredHintedElementType {

	private String semanticHint;

	private ElementTypeConfiguration configuration;

	/**
	 * @param id
	 * @param iconURL
	 * @param displayName
	 * @param elementTypes
	 * @param matcher
	 * @param descriptor
	 * @param editHelperAdvice
	 * @param iElementCreationValidator
	 */
	public ConfiguredHintedSpecializationElementType(String id, URL iconURL, String displayName, IElementType[] elementTypes, IElementMatcher matcher, IContainerDescriptor containerDescriptor, IEditHelperAdvice editHelperAdvice, String semanticHint,
			SpecializationTypeConfiguration configuration) {
		super(id, iconURL, displayName, elementTypes, matcher, containerDescriptor, editHelperAdvice);
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
		return "Configured Specialization Type: " + getDisplayName() + " [" + getId() + "]";
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
