/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 459174
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.factories.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IAdviceBindingDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ConfiguredHintedSpecializationElementType;
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.NullEditHelperAdvice;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.AdviceConfigurationTypeRegistry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ContainerConfigurationTypeRegistry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.MatcherConfigurationTypeRegistry;

public class SpecializationTypeFactory extends AbstractElementTypeConfigurationFactory<SpecializationTypeConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IHintedType createElementType(SpecializationTypeConfiguration elementTypeConfiguration) {
		return new ConfiguredHintedSpecializationElementType(getID(elementTypeConfiguration), getIconURL(elementTypeConfiguration), getDisplayName(elementTypeConfiguration), getSpecializedID(elementTypeConfiguration),
				createElementMatcher(elementTypeConfiguration), createContainerDescriptor(elementTypeConfiguration), getEditHelperAdvice(elementTypeConfiguration), getSemanticHint(elementTypeConfiguration), elementTypeConfiguration);
	}

	protected IEditHelperAdvice getEditHelperAdvice(SpecializationTypeConfiguration elementTypeConfiguration) {
		EditHelperAdviceConfiguration editHelperAdviceConfiguration = elementTypeConfiguration.getEditHelperAdviceConfiguration();
		if (editHelperAdviceConfiguration == null) {
			return NullEditHelperAdvice.getInstance();
		}
		IAdviceBindingDescriptor editHelperAdviceDescriptor = AdviceConfigurationTypeRegistry.getInstance().getEditHelperAdviceDecriptor(editHelperAdviceConfiguration);
		return editHelperAdviceDescriptor.getEditHelperAdvice();
	}

	protected IContainerDescriptor createContainerDescriptor(SpecializationTypeConfiguration elementTypeConfiguration) {
		ContainerConfiguration containerConfiguration = elementTypeConfiguration.getContainerConfiguration();
		if (containerConfiguration == null) {
			return null;
		}
		IContainerDescriptor containerDescriptor = ContainerConfigurationTypeRegistry.getInstance().getContainerDescriptor(containerConfiguration);
		return containerDescriptor;
	}

	protected IElementType[] getSpecializedID(SpecializationTypeConfiguration elementTypeConfiguration) {
		// Specialized elementTypes
		List<IElementType> specializedTypes = new ArrayList<IElementType>((elementTypeConfiguration).getSpecializedTypesID().size());
		for (String specializedTypeId : (elementTypeConfiguration).getSpecializedTypesID()) {
			IElementType specializedType = ElementTypeRegistry.getInstance().getType(specializedTypeId);
			if (specializedType != null)
			{
				specializedTypes.add(specializedType);
			} else {
				Activator.log.info("Unable to add specialization \"" + getID(elementTypeConfiguration) + "\" to \"" + specializedTypeId + "\"");
			}
		}
		IElementType[] elementTypes = specializedTypes.toArray(new IElementType[] {});
		return elementTypes;
	}

	protected IElementMatcher createElementMatcher(SpecializationTypeConfiguration configuration) {
		MatcherConfiguration matcherConfiguration = configuration.getMatcherConfiguration();
		if (matcherConfiguration == null) {
			return null;
		}
		IElementMatcher matcher = MatcherConfigurationTypeRegistry.getInstance().getMatcher(matcherConfiguration);
		return matcher;
	}
}
