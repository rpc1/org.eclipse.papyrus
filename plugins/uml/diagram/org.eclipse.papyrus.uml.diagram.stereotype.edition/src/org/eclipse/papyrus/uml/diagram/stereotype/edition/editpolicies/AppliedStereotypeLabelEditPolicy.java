/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Celine Janssens (ALL4TEC) celine.janssens@all4tec.net - Bug 460356 : Refactor Stereotype Display
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpolicies;

import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;

/**
 * @author Céline JANSSENS
 *         This Policy is in charge of create and delete the applied Stereotype Label Node into the Notation model
 */
public class AppliedStereotypeLabelEditPolicy extends AppliedStereotypeNodeLabelDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeLabelEditPolicy"; //$NON-NLS-1$

	/**
	 * Creates a new AppliedStereotype display edit policy
	 */
	public AppliedStereotypeLabelEditPolicy() {
		super();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy#activate()
	 *
	 */
	@Override
	public void activate() {
		// CEJ Auto-generated method stub
		super.activate();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy#refreshStereotypeDisplay()
	 *
	 */
	@Override
	protected void refreshStereotypeDisplay() {
		// nothing
	}




}
