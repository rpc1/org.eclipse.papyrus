/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml14.edit.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * Extends org.eclipse.emf.edit.provider.ItemProviderAdapter in order to
 * implement specific SysML itemProvider fonctions
 *
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net
 *         ">arthur.daussy@atos.net</a>"
 *
 */
public class SysMLItemProviderAdapter extends ItemProviderAdapter implements IVisibilityOverlayImage {

	private static final String FULL_OVR16_VISIBILITY_KIND = "full/ovr16/VisibilityKind_"; //$NON-NLS-1$

	public SysMLItemProviderAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * Compose the image with specific visibility logo Copied from UML
	 * implementation
	 *
	 * @param object
	 * @param composedImage
	 * @return {@link ComposedImage}
	 */
	public ComposedImage composeVisibilityImage(Object object, ComposedImage composedImage) {
		NamedElement namedElement = (NamedElement) object;
		if (namedElement.isSetVisibility()) {
			composedImage.getImages().add(UMLEditPlugin.INSTANCE.getImage(FULL_OVR16_VISIBILITY_KIND
					+ namedElement.getVisibility().getName()));
		}
		return composedImage;
	}
}
