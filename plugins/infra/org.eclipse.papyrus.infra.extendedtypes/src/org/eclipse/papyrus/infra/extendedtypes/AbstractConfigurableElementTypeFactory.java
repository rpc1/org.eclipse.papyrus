/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.types.ExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.osgi.framework.Bundle;

/**
 * Factory to create element type from its {@link ElementTypeConfiguration}
 */
public abstract class AbstractConfigurableElementTypeFactory<T extends ElementTypeConfiguration> implements IExtendedElementTypeFactory<T> {

	/**
	 * {@inheritDoc}
	 */
	public IExtendedHintedElementType createElementType(T configuration) {
		String id = configuration.getIdentifier();
		// display name of the element Type (used mainly in GUIs)
		String displayName = configuration.getName();
		// Specialized element types
		List<IElementType> specializedTypes = new ArrayList<IElementType>(configuration.getSpecializedTypesID().size());
		for (String specializedTypeId : configuration.getSpecializedTypesID()) {
			IElementType specializedType = ElementTypeRegistry.getInstance().getType(specializedTypeId);
			specializedTypes.add(specializedType);
		}
		IElementType[] elementTypes = specializedTypes.toArray(new IElementType[] {});
		// icon associated to the element Type (GUI)
		IconEntry entry = configuration.getIconEntry();
		URL iconURL = null;
		if (entry != null) {
			iconURL = getURLFromEntry(entry);
		}
		IExtendedHintedElementType type = new ExtendedHintedElementType(id, iconURL, displayName, elementTypes, createElementMatcher(configuration), createContainerDescriptor(configuration), createEditHelperAdvice(configuration),
				getSemanticHint(configuration), createElementCreationValidator(configuration));
		return type;
	}

	/**
	 * Returns the semantic hint for the element type from the given configuration
	 */
	protected String getSemanticHint(T configuration) {
		return configuration.getHint();
	}

	/**
	 * @param configuration
	 * @return
	 */
	protected abstract IEditHelperAdvice createEditHelperAdvice(T configuration);

	/**
	 * @param configuration
	 * @return
	 */
	protected abstract IContainerDescriptor createContainerDescriptor(T configuration);

	/**
	 * Creates the element matcher for the given configuration
	 *
	 * @param configuration
	 *            the configuration from which element matcher should be created
	 * @return the new element matcher for the created element type
	 */
	protected IElementMatcher createElementMatcher(T configuration) {
		MatcherConfiguration matcherConfiguration = configuration.getMatcherConfiguration();
		if (matcherConfiguration == null) {
			return null;
		}
		// create matcher from the configuration
		IElementMatcher matcher = ConfigurableElementMatcherFactoryRegistry.getInstance().createElementMatcher(matcherConfiguration);
		return matcher;
	}

	/**
	 * {@inheritDoc}
	 */
	public abstract ICreationElementValidator createElementCreationValidator(T configuration);

	/**
	 * @param entry
	 * @return
	 */
	protected URL getURLFromEntry(IconEntry entry) {
		Bundle bundle = Platform.getBundle(entry.getBundleId());
		if (bundle == null) {
			return null;
		}
		URL result = bundle.getEntry(entry.getIconPath());
		if (result == null) {
			try {
				result = new URL(entry.getIconPath());
			} catch (MalformedURLException e) {
				result = null;
			}
		}
		return result;
	}
}
