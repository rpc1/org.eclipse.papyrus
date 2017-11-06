/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.tools.utils;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * util class to display name of instancespecification
 *
 */
public class InstanceSpecificationUtil {

	/**
	 * return the custom label of the operation, given UML2 specification and a custom style.
	 *
	 * @param style
	 *            the integer representing the style of the label
	 *
	 * @return the string corresponding to the label of the operation
	 */
	public static String getCustomLabel(InstanceSpecification instance, Collection<String> maskValues) {
		StringBuffer buffer = new StringBuffer();

		// name
		if (maskValues.contains(ICustomAppearance.DISP_NAME)) {
			buffer.append(NamedElementUtil.getName(instance));
		}

		// classifier
		if (maskValues.contains(ICustomAppearance.DISP_TYPE)) {
			if (!getTypesAsString(instance).equals("")) {
				buffer.append(": ");
				buffer.append(getTypesAsString(instance));
			}
		}

		// Workaround: empty label leads to invalid layout.
		// FIXME: Fix the layout instead
		if (buffer.length() == 0) {
			buffer.append(" "); // Add a whitespace to avoid layout issues
		}
		//

		return buffer.toString();
	}

	/**
	 * Returns the list of classifier for an instance specification as a string
	 *
	 * @return a string containing all classifier separated by commas
	 */
	private static String getTypesAsString(InstanceSpecification instance) {
		StringBuffer typeString = new StringBuffer();
		if (instance != null){
			Iterator<Classifier> classifierIterator = instance.getClassifiers().iterator();
			boolean firstParameter = true;
			while (classifierIterator.hasNext()) {
				Classifier classifier = classifierIterator.next();
				// get the label for this Classifier
				String classifierName = NamedElementUtil.getName(classifier);
				if (classifierName!= null && !"".equals(classifierName.trim())) { //$NON-NLS-1$
					if (!firstParameter) {
						typeString.append(", ");
					}
					typeString.append(classifierName);
					firstParameter = false;
				}
			}			
		}
		return typeString.toString();
	}
}
