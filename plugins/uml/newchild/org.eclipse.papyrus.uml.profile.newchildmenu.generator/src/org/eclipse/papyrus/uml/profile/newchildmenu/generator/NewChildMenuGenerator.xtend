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
 *  Onder Gurcan (Onder.Gurcan@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.newchildmenu.generator

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
import org.eclipse.papyrus.infra.elementtypesconfigurations.impl.ElementTypeSetConfigurationImpl
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.CreationMenu
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.ElementCreationMenuModelFactory
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.impl.ElementCreationMenuModelFactoryImpl


class NewChildMenuGenerator {
	
	def generate(String parentFolderName, String elementtypesconfigurationsFilePath) {
		var resourceSet = new ResourceSetImpl()
		var elementtypesconfigurationsURI = URI.createURI(elementtypesconfigurationsFilePath)
		var resource = resourceSet.getResource(elementtypesconfigurationsURI, true)
	    var eObject = resource.getContents().get(0)
	    var configurationImpl = eObject as ElementTypeSetConfigurationImpl	    	    
	    var folder = generateElementCreationMenuModel(configurationImpl.name, configurationImpl.elementTypeConfigurations)
	    var folderResource = resourceSet.createResource(URI.createURI(parentFolderName+"/newChildMenu.xmi")); //$NON-NLS-1$
		folderResource.getContents().add(folder);
		folderResource.save(null)	   
	}
	
	def Folder generateElementCreationMenuModel(String profileName, EList<ElementTypeConfiguration> elementTypeConfigurationsList) {
		var ElementCreationMenuModelFactory factory = ElementCreationMenuModelFactoryImpl.init
		var Folder folder = factory.createFolder
		folder.label = profileName
		for (elementTypeConfigurations : elementTypeConfigurationsList) {
			var CreationMenu creationMenu = factory.createCreationMenu()
	    	creationMenu.label = elementTypeConfigurations.name
	    	creationMenu.elementTypeIdRef = elementTypeConfigurations.identifier
	    	folder.menu.add(creationMenu)	
		}	 
		return folder
	}
		
}