package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Helper for nested classifier labels displaying
 */
public class NestedStereotypeLabelHelper extends StereotypedElementLabelHelper {

	private static NestedStereotypeLabelHelper myHelper;

	/**
	 * {@inheritDoc}
	 */
	public static NestedStereotypeLabelHelper getInstance() {
		if (myHelper == null) {
			myHelper = new NestedStereotypeLabelHelper();
		}
		return myHelper;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.helper.StereotypedElementLabelHelper#elementLabel(org.eclipse.gef.GraphicalEditPart)
	 *
	 * @param editPart
	 * @return
	 */
	@Override
	protected String elementLabel(GraphicalEditPart editPart) {
		NamedElement namedElement = getUMLElement(editPart);
		return namedElement == null ? "" : namedElement.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public NamedElement getUMLElement(GraphicalEditPart editPart) {
		if (editPart instanceof UMLCompartmentEditPart && editPart.getModel() instanceof View) {
			View view = (View) editPart.getModel();
			if (view.getElement() instanceof NamedElement) {
				return (NamedElement) view.getElement();
			}
		}
		return null;
	}
}
