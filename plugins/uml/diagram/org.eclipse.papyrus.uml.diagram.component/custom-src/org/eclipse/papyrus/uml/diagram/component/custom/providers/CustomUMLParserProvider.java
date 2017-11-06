package org.eclipse.papyrus.uml.diagram.component.custom.providers;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.papyrus.uml.diagram.common.parser.stereotype.AppliedStereotypeParser;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.AbstractionEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.ManifestationEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionAppliedStereotypeEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.SubstitutionEditPart;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLParserProvider;

public class CustomUMLParserProvider extends UMLParserProvider {

	public CustomUMLParserProvider() {
		super();
	}

	protected IParser getAppliedStereotypeParser(String defaultEditString) {
		return new AppliedStereotypeParser(defaultEditString);
	}

	@Override
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("abstraction"); //$NON-NLS-1$
		case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("manifestation"); //$NON-NLS-1$
		case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
			return getAppliedStereotypeParser("substitution"); //$NON-NLS-1$
		}
		return super.getParser(visualID);
	}
}
