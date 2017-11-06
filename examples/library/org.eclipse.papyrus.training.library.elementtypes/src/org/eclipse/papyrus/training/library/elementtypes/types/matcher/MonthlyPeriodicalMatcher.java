/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.training.library.elementtypes.types.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Matcher for periodicals
 */
public class MonthlyPeriodicalMatcher implements IElementMatcher {

	protected static final Integer TWELVE = new Integer(12);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean matches(EObject eObject) {
		if (!(eObject instanceof Class)) {
			return false; // a periodical is at least a UML class => stereotype applies on Class
		}
		Stereotype st = ((Class) eObject).getAppliedStereotype("extlibrary::Periodical");
		if (st == null) {
			return false; // a periodical shoud have a stereotype 
		}
		
		// retrieve stereotype
		return TWELVE.equals(((Class) eObject).getValue(st, "issuesPerYear")); // //$NON-NLS-1$
	}

}
