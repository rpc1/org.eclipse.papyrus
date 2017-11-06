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
package org.eclipse.papyrus.uml.profile.assistants.generator

import javax.inject.Inject
import javax.inject.Singleton
import org.eclipse.papyrus.infra.gmfdiag.assistant.AssistantFactory
import org.eclipse.papyrus.infra.gmfdiag.assistant.ModelingAssistantProvider
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.UML
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.UMLElementTypes
import org.eclipse.uml2.uml.Profile

/**
 * Transformation rule for generating a {@link ModelingAssistantProvider} from a UML {@link Profile}.
 */
@Singleton
class ModelingAssistantProviderRule {
    static extension AssistantFactory assistantFactory = AssistantFactory.eINSTANCE

    @Inject extension Identifiers
    @Inject extension UML
    @Inject extension UMLElementTypes
    @Inject extension FiltersUtil

    @Inject extension PopupAssistantRule
    @Inject extension ConnectionAssistantRule

    def create createModelingAssistantProvider toModelingAssistantProvider(Profile umlProfile) {

        // Initialize the generation of IDs
        umlProfile.setIdentifierBase

        name = umlProfile.name

        umlProfile.allExtensions.forEach [ ext |
            // Add the diagram-specific element types for our profile
            var profileElementTypes = ext.metaclass.diagramSpecificElementTypes.map[ext.toElementTypeID(it)]
            
            // And filters for the same, which the user may employ in edits of the model
            profileElementTypes.forEach[toElementTypeFilter(umlProfile)]
            
            if (!ext.metaclass.EClass.isRelationship) {
                // Popup assistants to create non-relationships
                elementTypeIDs.addAll(profileElementTypes)
                popupAssistants.addAll(ext.metaclass.diagramSpecificElementTypes.map[ext.toPopupAssistant(it)])
            } else {
                // Connection assistants to create relationships
                relationshipTypeIDs.addAll(profileElementTypes)
                connectionAssistants.addAll(ext.metaclass.diagramSpecificElementTypes.map[ext.toConnectionAssistant(it)])
            }
        ]
    }
}
