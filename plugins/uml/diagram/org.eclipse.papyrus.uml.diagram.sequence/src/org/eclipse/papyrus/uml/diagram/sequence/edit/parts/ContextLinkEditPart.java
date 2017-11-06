package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.ContextLinkItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CustomAppliedStereotypeContextLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.CustomContextLinkFigure;

/**
 * @generated
 */
public class ContextLinkEditPart extends ConnectionEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 8500;

	/**
	 * @generated
	 */
	public ContextLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ContextLinkItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new CustomAppliedStereotypeContextLinkLabelDisplayEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ConstraintContextAppliedStereotypeEditPart) {
			((ConstraintContextAppliedStereotypeEditPart) childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ConstraintContextAppliedStereotypeEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 *
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 *
	 * @generated
	 */
	@Override
	protected Connection createConnectionFigure() {
		return new CustomContextLinkFigure();
	}

	/**
	 * @generated
	 */
	@Override
	public CustomContextLinkFigure getPrimaryShape() {
		return (CustomContextLinkFigure) getFigure();
	}
}
