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
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
import org.eclipse.papyrus.infra.filters.Filter
import org.eclipse.papyrus.infra.gmfdiag.assistant.AssistantFactory
import org.eclipse.papyrus.infra.gmfdiag.assistant.ConnectionAssistant
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.Identifiers
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.UML
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.UMLElementTypes
import org.eclipse.papyrus.uml.profile.elementtypesconfigurations.generator.ImpliedExtension

/**
 * Transformation rule for generating a {@link ConnectionAssistant} from a UML {@link Extension}.
 */
@Singleton
class ConnectionAssistantRule {
    static extension AssistantFactory assistantFactory = AssistantFactory.eINSTANCE

    @Inject extension Identifiers
    @Inject extension UMLElementTypes
    @Inject extension FiltersUtil
    @Inject extension UML

    def create createConnectionAssistant toConnectionAssistant(ImpliedExtension umlExtension, ElementTypeConfiguration basetype) {
        elementTypeID = umlExtension.toElementTypeID(basetype)
        ownedSourceFilter = basetype.createPossibleSourcesFilter(umlExtension).reduce().andProfileApplied(umlExtension.profile)
        ownedTargetFilter = basetype.createPossibleTargetsFilter(umlExtension).reduce().andProfileApplied(umlExtension.profile)
    }

    private def createPossibleSourcesFilter(ElementTypeConfiguration basetype, ImpliedExtension umlExtension) {
        // Don't assist in creating connections from/to connections (relationships)
        baseElementTypes.filter[!relationship].fold(null) [ Filter filter, elementType |
            if (elementType.canSourceToType(basetype))
                filter || elementType.toFilter(umlExtension.profile)
            else
                filter
        ]
    }

    private def createPossibleTargetsFilter(ElementTypeConfiguration basetype, ImpliedExtension umlExtension) {
        // Don't assist in creating connections from/to connections (relationships)
        baseElementTypes.filter[!relationship].fold(null) [ Filter filter, elementType |
            if (elementType.canTargetFromType(basetype))
                filter || elementType.toFilter(umlExtension.profile)
            else
                filter
        ]
    }
}
