/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.stereotype.display.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.stereotype.StereotypeLocationEnum;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayCommandExecution;
import org.eclipse.papyrus.uml.diagram.common.stereotype.display.helper.StereotypeDisplayUtil;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class RemoveAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to
 * display
 */
public class RemoveAppliedStereotypePropertiesToDisplayCommand extends RecordingCommand {


	private View view;
	private TransactionalEditingDomain domain;
	private Stereotype stereotype;
	private Property property;
	private String location;

	private static StereotypeDisplayUtil helper = StereotypeDisplayUtil.getInstance();
	private static StereotypeDisplayCommandExecution commandHelper = StereotypeDisplayCommandExecution.getInstance();

	/**
	 * Instantiates a new sets the applied stereotype to display command.
	 *
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param stereotypePropertyList
	 *            the stereotype list
	 */
	public RemoveAppliedStereotypePropertiesToDisplayCommand(TransactionalEditingDomain domain, View view,
			final Property property, final Stereotype stereotype, final String location) {
		super(domain, "Hide a Stereotype Property");
		this.property = property;
		this.stereotype = stereotype;
		this.domain = domain;
		this.view = view;
		this.location = location;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		View propertyView = null;
		if (StereotypeLocationEnum.IN_COMPARTMENT.equals(location)) {
			propertyView = helper.getStereotypeProperty(view, stereotype, property);
		} else if (StereotypeLocationEnum.IN_BRACE.equals(location)) {
			propertyView = helper.getStereotypePropertyInBrace(view, stereotype, property);
		} else if (StereotypeLocationEnum.IN_COMMENT.equals(location)) {
			propertyView = helper.getStereotypePropertyInComment(view, stereotype, property);
		}

		commandHelper.setUserVisibility(domain, propertyView, false);

	}
}
