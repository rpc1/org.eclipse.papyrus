/*******************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement
 * with the CEA.
 *
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.papyrusgmfgenextension.popupaction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;

/**
 * Implementation class for AddSemanticElementTypeInGenericTopNode action
 */
public class UpdateElementTypeToMatchGenericType extends Action {

	private static final String GENERIC_UML_GMFGEN = "GenericUML.gmfgen";

	/** prefix for Metamodel type identifier */
	private static final String ORG_ECLIPSE_PAPYRUS_UML = "org.eclipse.papyrus.uml.";

	public static final String GEN_CLASS_RT_CLASS = "Node"; //$NON-NLS-1$

	public static final String GEN_CLASS_FACET_META_FEATURE = "NamedElement"; //$NON-NLS-1$

	public static final String GEN_FEATURE_FACET_META_FEATURE = "name"; //$NON-NLS-1$

	public static final String URI_NOTATION_GENMODEL = "org.eclipse.gmf.runtime.notation/model/notation.genmodel"; //$NON-NLS-1$

	public static final String URI_UML_GENMODEL = "org.eclipse.uml2.uml/model/UML.genmodel"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// NO OP
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		// Parse selected GenLink(s) and add the desired CustomBehavior
		Iterator<EObject> it = getSelectedEObject().iterator();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof SpecializationType) {
				SpecializationType specializationType = (SpecializationType) eObject;
				Resource genericTypeResource = getGenericTypeResource(specializationType.eResource().getResourceSet());
				if (genericTypeResource == null) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "no " + GENERIC_UML_GMFGEN + " resource has been found.");
					return;
				}
				// retrieve associated metaclass
				GenClass metaclass = specializationType.getMetamodelType().getMetaClass();
				String id = specializationType.getUniqueIdentifier();
				String displayName = specializationType.getDisplayName();
				// check precondition before creating a duplicate
				if (metaclass == null) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "metaclass is null");
				} else {
					// create the specialization type and update it
					SpecializationType newType = GMFGenFactory.eINSTANCE.createSpecializationType();
					newType.setUniqueIdentifier(id);
					newType.setDefinedExternally(false);
					newType.setDisplayName(displayName);

					// find generic element type
					EClass eClass = metaclass.getEcoreClass();

					Iterator<EObject> genericTypes = genericTypeResource.getAllContents();
					while (genericTypes.hasNext()) {
						EObject object = genericTypes.next();
						if (object instanceof MetamodelType) {
							MetamodelType type = ((MetamodelType) object);
							if (type.getMetaClass().getEcoreClass().equals(eClass)) {
								newType.setMetamodelType(type);
							}
						}
					}

					// replace existing type
					GenCommonBase commonBase = specializationType.getDiagramElement();
					commonBase.setElementType(newType);
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Generation", "Specialization type was created and has replaced the specialization type\n" + newType);
				}
			} else if (eObject instanceof MetamodelType) {
				MetamodelType metamodelType = (MetamodelType) eObject;
				Resource genericTypeResource = getGenericTypeResource(metamodelType.eResource().getResourceSet());
				if (genericTypeResource == null) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "no " + GENERIC_UML_GMFGEN + " resource has been found.");
					return;
				}
				// retrieve associated metaclass
				GenClass metaclass = metamodelType.getMetaClass();
				String id = metamodelType.getUniqueIdentifier();
				String displayName = metamodelType.getDisplayName();
				// check precondition before creating a duplicate
				if (metaclass == null) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "metaclass is null");
				} else {
					// create the specialization type and update it
					SpecializationType newType = GMFGenFactory.eINSTANCE.createSpecializationType();
					newType.setUniqueIdentifier(id);
					newType.setDefinedExternally(false);
					newType.setDisplayName(displayName);

					// find generic element type
					EClass eClass = metaclass.getEcoreClass();

					Iterator<EObject> genericTypes = genericTypeResource.getAllContents();
					while (genericTypes.hasNext()) {
						EObject object = genericTypes.next();
						if (object instanceof MetamodelType) {
							MetamodelType type = ((MetamodelType) object);
							if (type.getMetaClass().getEcoreClass().equals(eClass)) {
								newType.setMetamodelType(type);
							}
						}
					}

					// replace existing type
					GenCommonBase commonBase = metamodelType.getDiagramElement();
					commonBase.setElementType(newType);
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Generation", "Specialization type was created and has replaced the metamodel type\n" + newType);
				}
			}
		}
	}

	/**
	 * @param resourceSet
	 * @return
	 */
	protected Resource getGenericTypeResource(ResourceSet resourceSet) {
		for (Resource resource : resourceSet.getResources()) {
			URI resourceURI = resource.getURI();
			String resourceName = resourceURI.segment(resourceURI.segmentCount() - 1);
			if (GENERIC_UML_GMFGEN.equals(resourceName)) {
				return resource;
			}
		}
		return null;
	}

	protected MetamodelType getGenericType(ResourceSet resourceSet, EClass eClass) {
		return null;
	}

	/**
	 * Returns all the UML {@link GenClass} that are related to UML constructs which are not abstract
	 *
	 * @param resourceSet
	 * @return
	 */
	protected List<GenClass> getAllUMLConcreteClasses(ResourceSet resourceSet) {
		Resource umlResource = resourceSet.getResource(URI.createPlatformPluginURI(URI_UML_GENMODEL, false), true);
		List<GenClass> classes = new ArrayList<GenClass>();
		Iterator<EObject> it = umlResource.getAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next instanceof GenClass) {
				GenClass genClass = (GenClass) next;
				EClass umlEClass = genClass.getEcoreClass();
				if (umlEClass != null && !umlEClass.isAbstract() && !umlEClass.isInterface()) {
					classes.add(genClass);
				}
			}
		}
		return classes;
	}

	/**
	 * Returns the top level node that corresponds to this metaclass
	 *
	 * @param metaclassName
	 *            name of the metaclass for which element type has to be defined
	 * @return the top level node found or <code>null</code>;
	 */
	protected GenTopLevelNode findTopLevelNode(GenDiagram genDiagram, GenClass genClass) {
		for (GenTopLevelNode topNode : genDiagram.getTopLevelNodes()) {
			TypeModelFacet facet = topNode.getModelFacet();
			if (facet != null) {
				if (genClass.equals(facet.getMetaClass())) {
					return topNode;
				}
				;
			}
		}
		return null;
	}

	protected void updateToplevelNode(GenTopLevelNode topLevelNode, ResourceSet resourceSet, GenClass genClass) {
		String metaclassName = genClass.getEcoreClass().getName();
		topLevelNode.setDiagramRunTimeClass(getNodeViewClass(resourceSet));
		TypeModelFacet typeModelFacet = topLevelNode.getModelFacet();
		if (typeModelFacet == null) {
			typeModelFacet = GMFGenFactory.eINSTANCE.createTypeModelFacet();
			topLevelNode.setModelFacet(typeModelFacet);
		}
		typeModelFacet.setMetaClass(genClass);
		ElementType type = topLevelNode.getElementType();
		if (type == null) {
			type = GMFGenFactory.eINSTANCE.createMetamodelType();
			topLevelNode.setElementType(type);
		}
		type.setDefinedExternally(true);
		type.setDisplayName(metaclassName + "_Semantic");
		type.setUniqueIdentifier(ORG_ECLIPSE_PAPYRUS_UML + metaclassName);
	}

	public GenTopLevelNode createNewTopNode(GenDiagram genDiagram, String metaclassName) {
		GenTopLevelNode topLevelNode = GMFGenFactory.eINSTANCE.createGenTopLevelNode();
		return topLevelNode;
	}

	protected GenClass getNodeViewClass(ResourceSet resourceSet) {
		URI uri_notation = URI.createPlatformPluginURI(URI_NOTATION_GENMODEL, false);
		Resource notation = resourceSet.getResource(uri_notation, true);
		return findGenClass(notation, GEN_CLASS_RT_CLASS);
	}

	protected GenClass getMetaclassGenClass(ResourceSet resourceSet, String metaclassName) {
		URI uri_uml = URI.createPlatformPluginURI(URI_UML_GENMODEL, false);
		Resource umlResource = resourceSet.getResource(uri_uml, true);
		return findGenClass(umlResource, metaclassName);
	}
}
