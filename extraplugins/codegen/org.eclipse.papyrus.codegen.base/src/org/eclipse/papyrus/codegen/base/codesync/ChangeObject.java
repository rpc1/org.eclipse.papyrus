/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) Ansgar.Radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.codegen.base.codesync;

import org.eclipse.emf.ecore.EObject;

/**
 * Simple data type that stores the tuple of event-type and associated e-Object
 */
public class ChangeObject {
	/**
	 * The eventType. @link org.eclipse.emf.common.notify.Notification
	 */
	public int eventType;
	
	/**
	 * The associated EObject
	 */
	public EObject eObject;
}
