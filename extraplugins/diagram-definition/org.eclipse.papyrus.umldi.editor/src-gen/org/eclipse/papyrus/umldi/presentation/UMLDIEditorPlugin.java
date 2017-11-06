/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.umldi.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.dd.provider.DDEditPlugin;
import org.eclipse.uml2.uml.edit.UMLEditPlugin;

/**
 * This is the central singleton for the UMLDI editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public final class UMLDIEditorPlugin extends EMFPlugin {

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final UMLDIEditorPlugin INSTANCE = new UMLDIEditorPlugin();

	/**
	 * The id of the transform button image
	 */
	public static final String IMAGE_TRANSFORM = "Transform";

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UMLDIEditorPlugin() {
		super(new ResourceLocator[]{ DDEditPlugin.INSTANCE, EcoreEditPlugin.INSTANCE, UMLEditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public Implementation() {
			super();
			// Remember the static instance.
			//
			plugin = this;
		}

		@Override
		protected void initializeImageRegistry(ImageRegistry reg) {
			super.initializeImageRegistry(reg);
			reg.put(IMAGE_TRANSFORM, ImageDescriptor.createFromURL(getBundle().getEntry("icons/Transform.png")));
		}
	}

	public static ImageDescriptor getImageDescriptor(String id) {
		return getPlugin().getImageRegistry().getDescriptor(id);
	}
}
