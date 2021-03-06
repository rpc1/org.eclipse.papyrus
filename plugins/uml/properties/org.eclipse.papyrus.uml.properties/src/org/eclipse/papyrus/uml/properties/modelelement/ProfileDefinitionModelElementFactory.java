/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST. and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 417409
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.AbstractModelElementFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;


public class ProfileDefinitionModelElementFactory extends AbstractModelElementFactory<ProfileDefinitionModelElement> {

	@Override
	protected ProfileDefinitionModelElement doCreateFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if (umlSource instanceof Profile) {
			// EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
			return new ProfileDefinitionModelElement((Profile) umlSource);
		}

		Activator.log.warn("Unable to resolve the selected element to a UML Profile"); //$NON-NLS-1$
		return null;
	}

	@Override
	protected void updateModelElement(ProfileDefinitionModelElement modelElement, Object newSourceElement) {
		Element element = org.eclipse.papyrus.uml.tools.utils.UMLUtil.resolveUMLElement(newSourceElement);
		if (!(element instanceof Profile)) {
			throw new IllegalArgumentException("Cannot resolve UML Profile selection: " + newSourceElement);
		}
		modelElement.profile = (Profile) element;
	}
}
