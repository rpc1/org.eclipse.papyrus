/**
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedCompartmentFigure;

/**
 * Represents a classifier.
 */
public class StateFigure extends RoundedCompartmentFigure {

	protected String submachineStateName = "";

	protected boolean isSubmachineState = false;

	/** The State Compartment */
	private final static String STATE_COMPARTMENT = "stateCompartment";

	/** The List of Compartment */
	private final static List<String> COMPARTMENT = new ArrayList<String>() {

		private static final long serialVersionUID = 1L;
		{
			add(STATE_COMPARTMENT);
		}
	};

	/**
	 * Default Constructor
	 */
	public StateFigure() {
		this(null);
	}

	/**
	 * Create a new StateMachine figure with the given tag
	 *
	 * @param tagLabel
	 *            a String that will be displayed at the top of the figure
	 */
	public StateFigure(String tagLabel) {
		super(COMPARTMENT, tagLabel);
	}

	public void setSubmachineStateName(String text) {
		submachineStateName = text;
	}

	public void setIsSubmachineState(boolean b) {
		isSubmachineState = b;
	}

	/**
	 * Get the state compartment figure
	 *
	 * @return
	 */
	public RectangleFigure getStateCompartmentFigure() {
		return getCompartment(STATE_COMPARTMENT);
	}

}