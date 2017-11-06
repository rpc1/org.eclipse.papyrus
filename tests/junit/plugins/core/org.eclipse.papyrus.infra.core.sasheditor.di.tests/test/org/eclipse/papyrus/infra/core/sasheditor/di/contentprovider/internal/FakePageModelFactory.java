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

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;


/**
 * @author dumoulin
 */
public class FakePageModelFactory implements IPageModelFactory {

	/**
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory#createIPageModel(java.lang.Object)
	 * 
	 * @param pageIdentifier
	 * @return
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

}
