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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry;
import org.eclipse.papyrus.infra.elementtypesconfigurations.factories.IElementTypeConfigurationFactory;
import org.osgi.framework.Bundle;

public abstract class AbstractElementTypeConfigurationFactory<T extends ElementTypeConfiguration> implements IElementTypeConfigurationFactory<T> {

	protected String getDisplayName(T elementTypeConfiguration) {
		return elementTypeConfiguration.getName();
	}

	protected URL getIconURL(T elementTypeConfiguration) {
		// icon associated to the elementType (GUI)
		IconEntry entry = elementTypeConfiguration.getIconEntry();
		URL iconURL = null;
		if(entry != null) {
			iconURL = getURLFromEntry(entry);
		}
		return iconURL;
	}

	protected String getID(T elementTypeConfiguration) {
		return elementTypeConfiguration.getIdentifier();
	}

	/**
	 * Returns the semantic hint for the elementType from the given configuration
	 */
	protected String getSemanticHint(T elementTypeConfiguration) {
		return elementTypeConfiguration.getHint();
	}

	/**
	 * @param entry
	 * @return
	 */
	protected URL getURLFromEntry(IconEntry entry) {
		Bundle bundle = Platform.getBundle(entry.getBundleId());
		if(bundle == null) {
			return null;
		}
		URL result = bundle.getEntry(entry.getIconPath());
		if(result == null) {
			try {
				result = new URL(entry.getIconPath());
			} catch (MalformedURLException e) {
				result = null;
			}
		}
		return result;
	}
}
