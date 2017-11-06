/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener;

/**
 * Listener on ContentChange for Tests.
 * 
 * @author dumoulin
 */
public class ContentChangeListener implements IContentChangedListener {

	/** Count number of change event */
	private int changeCount = 0;

	/**
	 * @return the changeCount
	 */
	public int getChangeCount() {
		return changeCount;
	}

	public void contentChanged(ContentEvent event) {
		changeCount++;
	}

	public void reset() {
		changeCount = 0;
	}
}
