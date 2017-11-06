/**
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Ansgar Radermacher - Initial API and implementation
 *
 */

package org.eclipse.papyrus.FCM.util;

import org.eclipse.papyrus.FCM.Port;
import org.eclipse.uml2.uml.Interface;

/**
 * Interface used by extension point for evaluation of interface mappings
 *
 */
public interface IMappingRule {
	/**
	 * Return a list of provided interfaces for a given port
	 *
	 * @param p
	 *            the port
	 * @param update
	 *            if true, make model updates during calculation of derived interface
	 * @return the list of provided interfaces
	 */
	public Interface getProvided(Port p, boolean update);

	/**
	 * Return a list of provided interfaces for a given port
	 *
	 * @param p
	 *            the port
	 * @param update
	 *            if true, make model updates during calculation of derived interface
	 * @return the list of provided interfaces
	 */
	public Interface getRequired(Port p, boolean update);

	/**
	 * check whether a port needs to be updated (recalculation of its derived interfaces)
	 *
	 * @return true, if update is required, false otherwise
	 */
	public boolean needsUpdate(Port p);
}
