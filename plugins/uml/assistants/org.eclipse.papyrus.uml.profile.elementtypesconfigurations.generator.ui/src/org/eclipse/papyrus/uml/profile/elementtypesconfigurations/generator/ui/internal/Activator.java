/*
 * Copyright (c) 2015 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 */
package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the UML Profile Element Types Generator UI plugin.
 */
public final class Activator extends AbstractUIPlugin {
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ui"; //$NON-NLS-1$

	/**
	 * Keep track of the singleton.
	 */
	private static Activator INSTANCE;

	/** Logging helper */
	public static LogHelper log = new LogHelper();

	public Activator() {
		super();
	}

	public static Activator getInstance() {
		return INSTANCE;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		INSTANCE = this;
		log.setPlugin(this);

		super.start(context);
	}

	public ImageDescriptor getIcon(String path) {
		if (!path.startsWith("/")) {
			path = "$nl$/icons/full/" + path; //$NON-NLS-1$
		}
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
