/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE - Initial API and implementation & Bug 458260
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.provider;

import org.eclipse.papyrus.infra.nattable.provider.GenericCellLabelProvider;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.uml2.uml.TypedElement;

/**
 * The cell label provider for the UML typed elements.
 * 
 * @author Nicolas FAUVERGUE
 */
public class UMLTypedElementCellLabelProvider extends GenericCellLabelProvider{
	
	/**
	 * @see org.eclipse.papyrus.infra.nattable.provider.GenericCellLabelProvider#getSingleText(org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService, java.lang.Object)
	 *
	 * Manage the typed element.
	 * {@inheritDoc}
	 */
	@Override
	protected String getElementText(LabelProviderService service, Object value){
		if(value instanceof TypedElement){
			return ((TypedElement) value).getName();
		}
		return super.getElementText(service, value);
	}

}
