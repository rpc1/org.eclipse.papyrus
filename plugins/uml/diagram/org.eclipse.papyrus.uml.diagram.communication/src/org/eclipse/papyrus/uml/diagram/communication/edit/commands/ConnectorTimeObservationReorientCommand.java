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
package org.eclipse.papyrus.uml.diagram.communication.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.papyrus.uml.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * @generated
 */
public class ConnectorTimeObservationReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public ConnectorTimeObservationReorientCommand(ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (false == referenceOwner instanceof TimeObservation) {
			return false;
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof NamedElement && newEnd instanceof TimeObservation)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTimeObservationEvent_8013(getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NamedElement && newEnd instanceof NamedElement)) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistTimeObservationEvent_8013(getOldSource(), getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().setEvent(
				null
				);
		getNewSource().setEvent(
				getOldTarget()
				);
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setEvent(
				getNewTarget()
				);
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected TimeObservation getOldSource() {
		return (TimeObservation) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected TimeObservation getNewSource() {
		return (TimeObservation) newEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getOldTarget() {
		return (NamedElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NamedElement getNewTarget() {
		return (NamedElement) newEnd;
	}
}