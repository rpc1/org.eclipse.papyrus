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

import static org.eclipse.uml2.uml.UMLPackage.Literals.*

import javax.inject.Singleton
import org.eclipse.uml2.uml.NamedElement
import org.eclipse.uml2.uml.Stereotype
import org.eclipse.uml2.uml.Profile
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EReference
import java.util.Set

/**
 * Utility extensions for working with UML models and elements.
 */
@Singleton
class UML {
    
    // Each of these corresponds to a case in the getSourceReferences(...) and getTargetReferences(...) extensions
    final Set<EClass> relationshipLikeUMLMetaclasses = #{ RELATIONSHIP, GENERALIZATION_SET, CONNECTOR, ACTIVITY_EDGE, TRANSITION, MESSAGE }

    def dispatch getProfile(Profile element) {
        element
    }
    
    def dispatch getProfile(NamedElement element) {
        element.allOwningPackages.filter(Profile).head
    }
    
    def dispatch getProfile(ImpliedExtension umlExtension) {
        umlExtension.stereotype.profile
    }

    def dispatch Profile getRootProfile(Profile element) {
        element.namespace?.rootProfile ?: element
    }
    def dispatch getRootProfile(NamedElement element) {
        element.allOwningPackages.filter(Profile).last
    }
    
    def Iterable<ImpliedExtension> getAllExtensions(org.eclipse.uml2.uml.Package package_) {
        package_.ownedTypes.filter(Stereotype).map[impliedExtensions].flatten
            + package_.nestedPackages.map[allExtensions].flatten
    }
    
    def Iterable<ImpliedExtension> impliedExtensions(Stereotype stereotype) {
        stereotype.allExtendedMetaclasses.map[new ImpliedExtension(stereotype, it)]
    }
    
    def isRelationship(EClass eClass) {
        relationshipLikeUMLMetaclasses.exists[isSuperTypeOf(eClass)]
    }
    
    def getSourceReferences(EClass relationshipClass) {
        switch relationshipClass {
        case DIRECTED_RELATIONSHIP.isSuperTypeOf(relationshipClass):
            relationshipClass.EAllReferences.filter[!derived && changeable && subsets(DIRECTED_RELATIONSHIP__SOURCE)]
        case ASSOCIATION.isSuperTypeOf(relationshipClass):
            // ends are both source and target
            #[ASSOCIATION__END_TYPE]
        case CONNECTOR.isSuperTypeOf(relationshipClass):
            // ends are both source and target
            #[CONNECTOR__END]
        case ACTIVITY_EDGE.isSuperTypeOf(relationshipClass):
            #[ACTIVITY_EDGE__SOURCE]
        case TRANSITION.isSuperTypeOf(relationshipClass):
            #[TRANSITION__SOURCE]
        case MESSAGE.isSuperTypeOf(relationshipClass):
            #[MESSAGE__SEND_EVENT]
        case GENERALIZATION_SET.isSuperTypeOf(relationshipClass):
            // generalization sets just connect a bunch of generalizations
            #[GENERALIZATION_SET__GENERALIZATION]
        default:
            #[]
        }
    }
    
    def getTargetReferences(EClass relationshipClass) {
        switch relationshipClass {
        case DIRECTED_RELATIONSHIP.isSuperTypeOf(relationshipClass):
            relationshipClass.EAllReferences.filter[!derived && changeable && subsets(DIRECTED_RELATIONSHIP__TARGET)]
        case ASSOCIATION.isSuperTypeOf(relationshipClass):
            // ends are both source and target
            #[ASSOCIATION__END_TYPE]
        case CONNECTOR.isSuperTypeOf(relationshipClass):
            // ends are both source and target
            #[CONNECTOR__END]
        case ACTIVITY_EDGE.isSuperTypeOf(relationshipClass):
            #[ACTIVITY_EDGE__TARGET]
        case TRANSITION.isSuperTypeOf(relationshipClass):
            #[TRANSITION__TARGET]
        case MESSAGE.isSuperTypeOf(relationshipClass):
            #[MESSAGE__RECEIVE_EVENT]
        case GENERALIZATION_SET.isSuperTypeOf(relationshipClass):
            // generalization sets just connect a bunch of generalizations
            #[GENERALIZATION_SET__GENERALIZATION]
        default:
            #[]
        }   
    }
    
    def subsets(EReference subset, EReference superset) {
        subset.getEAnnotation("subsets")?.references?.contains(superset)
    }
}
