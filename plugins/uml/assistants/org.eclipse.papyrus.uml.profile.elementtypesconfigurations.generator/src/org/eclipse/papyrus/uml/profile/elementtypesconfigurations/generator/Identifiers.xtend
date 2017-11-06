/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator

import static extension org.eclipse.uml2.common.util.UML2Util.getValidJavaIdentifier

import org.eclipse.xtend.lib.annotations.Accessors
import javax.inject.Singleton
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration
import javax.inject.Inject
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration
import org.eclipse.emf.common.notify.AdapterFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.provider.IItemLabelProvider
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.common.util.ResourceLocator

/**
 * Utility extensions for working with and generating unique identifiers in the element types model.
 */
@Singleton
class Identifiers {
    @Inject extension UMLElementTypes
    
    @Accessors
    String prefix

    @Accessors
    final String umlElementTypesSet = "org.eclipse.papyrus.uml.service.types.UMLElementTypeSet"
    
    @Accessors
    String baseElementTypesSet = umlElementTypesSet
    
    @Accessors
    ElementTypeSetConfiguration baseElementTypesSetConfiguration
    
    @Accessors
    boolean suppressSemanticSuperElementTypes
    
    @Accessors
    AdapterFactory adapterFactory
    
    String identifierBase

    def setIdentifierBase(org.eclipse.uml2.uml.Package umlPackage) {
        identifierBase = prefix
    }

    def getQualified(String id) {
        identifierBase + "." + id
    }
    
    def toElementTypeID(ImpliedExtension umlExtension, ElementTypeConfiguration supertype) {
        val stereo = umlExtension.stereotype
        var name = if (stereo.allExtendedMetaclasses.size <= 1) stereo.name else stereo.name + "_" + umlExtension.metaclass.name
        name.validJavaIdentifier.qualified + supertype.hintSuffix
    }
    
    def toElementTypeName(ImpliedExtension umlExtension, ElementTypeConfiguration supertype) {
        val stereo = umlExtension.stereotype
        val discriminators = newArrayList() => [
            if (stereo.extensions.size > 1) add(umlExtension.metaclass.name)    
            if (!supertype.hint.nullOrEmpty && (umlExtension.metaclass.diagramSpecificElementTypes.size > 1)) add(supertype.hint)
        ]
        
        if (discriminators.nullOrEmpty) 
        	if (stereo.allExtendedMetaclasses.size <= 1) stereo.name 
        	else stereo.name + " " + umlExtension.metaclass.name 
        else stereo.name + discriminators.join(" (", ", ", ")")[toString]
    }
    
    def dispatch hintSuffix(ElementTypeConfiguration elementType) {
        ""
    }
    
    def dispatch hintSuffix(SpecializationTypeConfiguration elementType) {
        if (elementType.hint.nullOrEmpty) "" else "_" + elementType.hint
    }
    
    def dispatch getLabel(EObject object) {
        val labels = adapterFactory?.adapt(object, IItemLabelProvider) as IItemLabelProvider
        labels?.getText(object)
    }
    
    def dispatch getLabel(EClassifier eClassifier) {
        try {
            eClassifier.resourceLocator?.getString("_UI_" + eClassifier.name + "_type")
        } catch (Exception e) {
            eClassifier.name
        }
    }
    
    private def ResourceLocator getResourceLocator(EObject object) {
        switch adapter : adapterFactory?.adapt(object, IItemLabelProvider) {
            ResourceLocator : adapter
        }
    }
}
