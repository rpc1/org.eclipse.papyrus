package org.eclipse.papyrus.cpp.codegen.xtend

/*******************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
 
 import org.eclipse.uml2.uml.NamedElement
import org.eclipse.papyrus.C_Cpp.Include
import org.eclipse.uml2.uml.util.UMLUtil
import org.eclipse.papyrus.codegen.base.GenUtils

/**
 * @author Önder GÜRCAN (onder.gurcan@cea.fr)
 */
class CppIncludeUtil {
	static def includeDirective(String path) {
		if ((path != null) && (path.length > 0))
			return '''#include ''' + '"' + path + '"'
	}

	static def CppIncludeHeader(NamedElement ne) {
		if (GenUtils.hasStereotype(ne, Include)) {
			UMLUtil.getStereotypeApplication(ne, Include)
			var header = UMLUtil.getStereotypeApplication(ne, Include).header
			if ((header != null) && (header.length > 0)) {
				var includeHeader = constIncludeHeaderStart + GenUtils.cleanCR(header) + '\n' +
					constIncludeHeaderEnd
				return includeHeader
			}
		}
	}

	static def constIncludeHeaderStart() '''
		// Include from Include stereotype (header)
	'''

	static def constIncludeHeaderEnd() '''
		// End of Include stereotype (header)
	'''
	
	static def CppIncludePreBody(NamedElement ne) {
		if (GenUtils.hasStereotype(ne, Include)) {
			var String preBody = UMLUtil.getStereotypeApplication(ne, Include).preBody
			if ((preBody != null) && (preBody.length > 0)) {
				var includePreBody = constIncludePreBodyStart + GenUtils.cleanCR(preBody) + '\n' +
					constIncludePreBodyEnd
				return includePreBody
			}
		}
	}
	
	static def constIncludePreBodyStart() '''
		// Include from Include stereotype (pre-body)
	'''

	static def constIncludePreBodyEnd() '''
		// End of Include stereotype (pre-body)
	'''
	
	static def CppIncludeBody(NamedElement ne) {
		if (GenUtils.hasStereotype(ne, Include)) {
			var String body = UMLUtil.getStereotypeApplication(ne, Include).body
			if ((body != null) && (body.length > 0)) {
				var includeBody = constIncludeBodyStart + GenUtils.cleanCR(body) + '\n' +
					constIncludeBodyEnd
				return includeBody
			}
		}
	}
	
	static def constIncludeBodyStart() '''
		// Include from Include declaration (body)
	'''

	static def constIncludeBodyEnd() '''
		// End of Include declaration (body)
	'''

}
