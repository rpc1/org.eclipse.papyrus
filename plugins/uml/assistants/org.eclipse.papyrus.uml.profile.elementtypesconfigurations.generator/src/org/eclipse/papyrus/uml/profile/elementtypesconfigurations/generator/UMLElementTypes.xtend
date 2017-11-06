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

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.emf.ecore.EClass
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry
import org.eclipse.gmf.runtime.emf.type.core.IElementType
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationType
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory
import org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry
import org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration
import org.eclipse.papyrus.infra.elementtypesconfigurations.registries.ElementTypeSetConfigurationRegistry
import org.eclipse.uml2.uml.Class
import org.eclipse.uml2.uml.UMLPackage
import java.util.regex.Pattern

/**
 * Utility extensions for working with and generating objects for the base UML element types specialized by the profile.
 */
@Singleton
class UMLElementTypes {
    private static final Pattern VISUAL_ID_PATTERN = Pattern.compile("\\d{4}");
    
    static extension ElementtypesconfigurationsFactory elementtypesconfigurationsFactory = ElementtypesconfigurationsFactory.
        eINSTANCE

    @Inject extension Identifiers
    @Inject extension UML

    def getElementTypeID(Class metaclass) {
        "org.eclipse.papyrus.uml." + metaclass.name
    }
    
    def getElementTypeConfiguration(Class metaclass) {
        baseUMLElementTypeSet.elementTypeConfigurations.findFirst[identifier == metaclass.elementTypeID]
    }

    def getBaseUMLElementTypeSet() {
        ElementTypeSetConfigurationRegistry.getInstance.getElementTypeSetConfigurations().get(umlElementTypesSet)
    }

    def getBaseUMLElementTypes() {
        baseUMLElementTypeSet.elementTypeConfigurations.map [
            ElementTypeRegistry.getInstance.getType(identifier)
        ].filterNull
    }

    def getEClass(Class metaclass) {
        UMLPackage.eINSTANCE.getEClassifier(metaclass.name) as EClass
    }

    def getIconEntry(Class metaclass) {
        metaclass.elementTypeConfiguration?.iconEntry.copy()
    }

    private def copy(IconEntry prototype) {
        createIconEntry() => [
            bundleId = prototype.bundleId
            iconPath = prototype.iconPath
        ]
    }

    def getBaseElementTypeSet() {
        baseElementTypesSetConfiguration ?: ElementTypeSetConfigurationRegistry.getInstance.getElementTypeSetConfigurations().get(baseElementTypesSet)
    }
    
    def getBaseElementTypes() {
        baseElementTypeSet.elementTypeConfigurations.filter[validType]
    }

    def validType(ElementTypeConfiguration elementType) {
        elementType.metaclass != null;
    }
    
    private def isDiagramSpecific() {
       baseElementTypeSet != baseUMLElementTypeSet 
    }
    
    def isDiagramSpecific(ElementTypeConfiguration type) {
        type.hint.isVisualID
    }
    
    def hasSemanticSupertype(ElementTypeConfiguration type) {
        type.isDiagramSpecific && !suppressSemanticSuperElementTypes
    }
    
    private def isVisualID(String string) {
        !string.nullOrEmpty && VISUAL_ID_PATTERN.matcher(string).matches
    }
    
    def getDiagramSpecificElementTypes(Class metaclass) {
        // If we're based on the UML element types, themselves, then we're not looking for specializations
        if (!diagramSpecific)
            baseUMLElementTypeSet.elementTypeConfigurations.filter [
                validType && (identifier == metaclass.elementTypeID)
            ]
        else
            baseElementTypeSet.elementTypeConfigurations.filter(SpecializationTypeConfiguration).filter [
                validType && specializedTypesID.contains(metaclass.elementTypeID)
            ]
    }

    private def canContain(IElementType containerType, EClass containedEClass) {
        containerType.EClass.EAllContainments.exists[EReferenceType.isSuperTypeOf(containedEClass)]
    }

    private def canContain(ElementTypeConfiguration containerType, EClass containedEClass) {
        ElementTypeRegistry.getInstance.getType(containerType.identifier)?.canContain(containedEClass)
    }

    def dispatch canContainType(ElementTypeConfiguration containerType, ElementTypeConfiguration containedTypeConfiguration) {
        false
    }

    def dispatch canContainType(ElementTypeConfiguration containerType, MetamodelTypeConfiguration containedTypeConfiguration) {
        containerType.canContain(containedTypeConfiguration.EClass)
    }

    def dispatch canContainType(ElementTypeConfiguration containerType, SpecializationTypeConfiguration containedTypeConfiguration) {
        containedTypeConfiguration.specializedTypesID.exists [ supertype |
            containerType.canContain(ElementTypeRegistry.getInstance.getType(supertype).EClass)
        ]
    }

    def isRelationship(IElementType elementType) {
        // If the EClass is null, then assume it's something like the Constraint::annotatedElement reference type
        // which is like a relationship
        (elementType.EClass == null) || elementType.EClass.relationship
    }

    def isRelationship(ElementTypeConfiguration elementType) {
        // If the EClass is null, then assume it's something like the Constraint::annotatedElement reference type
        // which is like a relationship
        (elementType.metaclass == null) || elementType.metaclass.relationship
    }
    
    private def dispatch EClass getMetaclass(ElementTypeConfiguration elementType) {
        null
    }
    
    private def dispatch EClass getMetaclass(SpecializationTypeConfiguration elementType) {
        var IElementType registered = ElementTypeRegistry.instance.getType(elementType.identifier)
        if (registered != null) {
            registered.metaclass
        } else {
            elementType.specializedTypesID.map[ElementTypeRegistry.instance.getType(it)].filterNull.head?.EClass
        }
    }
    
    private def dispatch EClass getMetaclass(MetamodelTypeConfiguration elementType) {
        elementType.EClass
    }

    private def dispatch EClass getMetaclass(IElementType elementType) {
        null
    }

    private def dispatch EClass getMetaclass(IMetamodelType elementType) {
        elementType.EClass
    }
    
    private def dispatch EClass getMetaclass(ISpecializationType elementType) {
        elementType.metamodelType?.EClass
    }

    private def canSourceTo(IElementType sourceType, EClass relationshipEClass) {
        relationshipEClass.sourceReferences.exists[EReferenceType.isSuperTypeOf(sourceType.EClass)]
    }

    private def canSourceTo(ElementTypeConfiguration sourceType, EClass relationshipEClass) {
        ElementTypeRegistry.getInstance.getType(sourceType?.identifier)?.canSourceTo(relationshipEClass)
    }

    def dispatch canSourceToType(ElementTypeConfiguration sourceType, ElementTypeConfiguration relationshipTypeConfiguration) {
        false
    }

    def dispatch canSourceToType(ElementTypeConfiguration sourceType, MetamodelTypeConfiguration relationshipTypeConfiguration) {
        sourceType.canSourceTo(relationshipTypeConfiguration.EClass)
    }

    def dispatch canSourceToType(ElementTypeConfiguration sourceType, SpecializationTypeConfiguration relationshipTypeConfiguration) {
        relationshipTypeConfiguration.specializedTypesID.exists [ supertypeID |
            val supertype = ElementTypeRegistry.getInstance.getType(supertypeID)
            (supertype != null) && supertype.EClass.isRelationship && sourceType.canSourceTo(supertype.EClass)
        ]
    }

    private def canTargetFrom(IElementType targetType, EClass relationshipEClass) {
        relationshipEClass.targetReferences.exists[EReferenceType.isSuperTypeOf(targetType.EClass)]
    }

    private def canTargetFrom(ElementTypeConfiguration targetType, EClass relationshipEClass) {
        ElementTypeRegistry.getInstance.getType(targetType?.identifier)?.canTargetFrom(relationshipEClass)
    }

    def dispatch canTargetFromType(ElementTypeConfiguration targetType, ElementTypeConfiguration relationshipTypeConfiguration) {
        false
    }

    def dispatch canTargetFromType(ElementTypeConfiguration targetType, MetamodelTypeConfiguration relationshipTypeConfiguration) {
        targetType.canTargetFrom(relationshipTypeConfiguration.EClass)
    }

    def dispatch canTargetFromType(ElementTypeConfiguration targetType, SpecializationTypeConfiguration relationshipTypeConfiguration) {
        relationshipTypeConfiguration.specializedTypesID.exists [ supertypeID |
            val supertype = ElementTypeRegistry.getInstance.getType(supertypeID)
            (supertype != null) && supertype.EClass.isRelationship && targetType.canTargetFrom(supertype.EClass)
        ]
    }
}
