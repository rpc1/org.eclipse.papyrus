/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.composites.Semantics.Loci.LociL3;

// Imports
import org.eclipse.papyrus.moka.composites.Semantics.CompositeStructures.StructuredClasses.CS_Object;
import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Object_;
import org.eclipse.papyrus.moka.fuml.Semantics.Loci.LociL1.Locus;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;


public class CS_Locus extends Locus {

	@Override
	public Object_ instantiate(Class type) {
		// Extends fUML semantics by instantiating a CS_Object
		// in the case where type is not a Behavior.
		// Otherwise behaves like in fUML

		Object_ object = null;

		if (type instanceof Behavior) {
			object = super.instantiate(type);
		} else {
			object = new CS_Object();
			object.types.add(type);
			object.createFeatureValues();
			this.add(object);
		}

		return object;
	}
}
