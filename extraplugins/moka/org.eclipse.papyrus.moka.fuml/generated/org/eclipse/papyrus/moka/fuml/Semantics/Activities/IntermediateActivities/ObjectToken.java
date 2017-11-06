/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.moka.fuml.Semantics.Activities.IntermediateActivities;

import org.eclipse.papyrus.moka.fuml.Semantics.Classes.Kernel.Value;

public class ObjectToken extends Token {

	/*
	 * The value carried by this token. A token may have no value, in which case
	 * it is a "null token".
	 */
	public Value value;

	@Override
	public Boolean equals(Token other) {
		// Test if this object token is the same as the other token.
		return this == other;
	}

	@Override
	public Token copy() {
		// Return a new object token with the same value as this token.
		// [Note: the holder of the copy is not set.]
		ObjectToken copy = new ObjectToken();
		copy.value = this.value;
		return copy;
	}

	@Override
	public Boolean isControl() {
		// Return false for an object token.
		return false;
	}

	@Override
	public Value getValue() {
		// Return the value of this object token.
		return this.value;
	}
}
