/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints;



public class TracepointConstants {

	/**
	 * The id of the marker used for tracepoints and breakpoints
	 */
	public static final String tpOrbpMarker = "org.eclipse.papyrus.tporbpmarker"; //$NON-NLS-1$

	public static final String isActive = "isActive"; //$NON-NLS-1$

	/**
	 * if true, marker is a tracepoint. Otherwise it is a breakpoint.
	 */
	public static final String isTracepoint = "isTracepoint"; //$NON-NLS-1$

	public static final String traceAction = "traceAction"; //$NON-NLS-1$

	public static final String traceMechanism = "traceMechanism"; //$NON-NLS-1$
}
