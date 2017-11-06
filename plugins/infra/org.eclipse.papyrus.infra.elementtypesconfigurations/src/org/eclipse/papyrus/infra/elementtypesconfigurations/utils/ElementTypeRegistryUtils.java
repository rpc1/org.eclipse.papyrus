/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus - bug 459174
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.elementtypesconfigurations.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.ClientContext;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IAdviceBindingDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.elementtypesconfigurations.Activator;
import org.eclipse.papyrus.infra.services.edit.internal.context.TypeContext;

public class ElementTypeRegistryUtils {

	static public IElementType getType(IClientContext context, String elementTypeID) {
		IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(context);
		for (IElementType iElementType : elementTypes) {
			if (iElementType.getId().equals(elementTypeID)) {
				return iElementType;
			}
		}
		return null;
	}

	static public void registerAdviceBinding(IAdviceBindingDescriptor adviceDescriptor) {
		ElementTypeRegistry.getInstance().registerAdvice(adviceDescriptor);
	}

	static public void removeAdviceDescriptorFromBindings(IAdviceBindingDescriptor adviceDescriptor) {
		ElementTypeRegistry.getInstance().deregisterAdvice(adviceDescriptor);
	}

	static public void unBindID(IClientContext context, String typeId) {
		if (context instanceof ClientContext) {
			((ClientContext) context).unbindId(typeId);
		} else if (context != null) {
			Activator.log.warn("Cannot unbind type ID from context of unknown class: " + context.getClass().getName());
		}
	}

	static public List<IElementType> getElementTypesBySemanticHint(String semanticHint) {
		List<IElementType> matchingElementTypes = new ArrayList<IElementType>();

		IClientContext context;
		try {
			context = TypeContext.getContext();
			IElementType[] elementTypes = ElementTypeRegistry.getInstance().getElementTypes(context);

			for (IElementType iElementType : elementTypes) {
				if (iElementType instanceof IHintedType) {
					if (((IHintedType) iElementType).getSemanticHint().equals(semanticHint)) {
						matchingElementTypes.add(iElementType);
					}
				}
			}
		} catch (ServiceException e1) {
			Activator.log.error(e1);
		}



		return matchingElementTypes;
	}
}
