/*****************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST, Christian W. Damus, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *  Christian W. Damus - bug 399859
 *  Christian W. Damus - bug 456934
 *  Christian W. Damus - bug 469464
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.decoratormodel;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.uml.decoratormodel.internal.resource.DecoratorModelIndex;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.decoratormodel"; //$NON-NLS-1$

	public static final String TRACE_INDEX = "index"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** logger helper */
	public static LogHelper log;

	public Activator() {
		super();
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(this);

		// Kick the index
		DecoratorModelIndex.getInstance();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// Shut down the index
		DecoratorModelIndex.getInstance().dispose();

		plugin = null;
		log = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
