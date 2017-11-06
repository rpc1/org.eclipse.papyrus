package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationEditPart;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLLinkDescriptor;
import org.eclipse.papyrus.uml.diagram.profile.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;


public class CustomUMLDiagramUpdater extends UMLDiagramUpdater {

	public static final CustomUMLDiagramUpdater INSTANCE = new CustomUMLDiagramUpdater();

	private CustomUMLDiagramUpdater() {
		// to prevent instantiation
		super();
	}

	@Override
	protected Collection<UMLLinkDescriptor> getContainedTypeModelFacetLinks_Association_4001(Package container) {
		LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
		for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
				continue;
			}
			List<?> targets = link.getEndTypes();
			if (targets.size() < 2) {
				continue;
			}
			Object source = targets.get(0);
			Object target = targets.get(1);
			if (false == target instanceof Type) {
				continue;
			}
			if (false == source instanceof Type) {
				continue;
			}
			result.add(new UMLLinkDescriptor((Type) source, (Type) target, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	@Override
	protected Collection<UMLLinkDescriptor> getIncomingTypeModelFacetLinks_Association_4001(Type target, CrossReferenceAdapter crossReferencer) {
		return new TypeModelFacetLinksRetriever_Association_4001(target).getTypeModelFacetLinks_Association_4001();
	}

	@Override
	protected Collection<UMLLinkDescriptor> getOutgoingTypeModelFacetLinks_Association_4001(Type source) {
		return new TypeModelFacetLinksRetriever_Association_4001(source).getTypeModelFacetLinks_Association_4001();
	}

	private static class TypeModelFacetLinksRetriever_Association_4001 {
		private final Type myRoot;

		public TypeModelFacetLinksRetriever_Association_4001(Type root) {
			myRoot = root;
		}

		public Collection<UMLLinkDescriptor> getTypeModelFacetLinks_Association_4001() {
			Package container = null;
			// Find container element for the link.
			// Climb up by containment hierarchy starting from the source
			// and return the first element that is instance of the container class.
			for (EObject element = myRoot; element != null && container == null; element = element.eContainer()) {
				if (element instanceof Package) {
					container = (Package) element;
				}
			}
			if (container == null) {
				return Collections.emptyList();
			}
			LinkedList<UMLLinkDescriptor> result = new LinkedList<UMLLinkDescriptor>();
			for (Iterator<?> links = container.getPackagedElements().iterator(); links.hasNext();) {
				EObject linkObject = (EObject) links.next();
				if (false == linkObject instanceof Association) {
					continue;
				}
				Association link = (Association) linkObject;
				if (AssociationEditPart.VISUAL_ID != UMLVisualIDRegistry.getLinkWithClassVisualID(link)) {
					continue;
				}
				List<?> ends = link.getEndTypes();
				if (ends == null || ends.isEmpty()) {
					continue;
				}
				if (ends.size() < 2) {
					continue;
				}
				Object source = ends.get(0);
				Object target = ends.get(1);
				if (false == target instanceof Type) {
					continue;
				}
				if (false == source instanceof Type) {
					continue;
				}
				result.add(new UMLLinkDescriptor((Type) source, (Type) target, link, UMLElementTypes.Association_4001, AssociationEditPart.VISUAL_ID));
			}
			return result;
		}
	}
}
