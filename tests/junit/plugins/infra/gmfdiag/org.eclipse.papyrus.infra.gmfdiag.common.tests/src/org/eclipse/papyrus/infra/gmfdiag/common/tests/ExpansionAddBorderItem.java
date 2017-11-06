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
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.tests;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.ChildrenListRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.DiagramExpansionSingleton;
import org.eclipse.papyrus.infra.gmfdiag.common.expansion.DiagramExpansionsRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * this Test is used to test if it is possible to add compartment
 * see #Test T004-Add Border Item
 * 
 *
 */
public class ExpansionAddBorderItem extends AbstractEditorTest{

	/**
	 * 
	 */
	protected static final String INTERFACE_BORDER_ITEM = "Interface_BorderItem";
	/**
	 * 
	 */
	protected static final String NESTED_INTERFACE_LABEL = "Interface_Label";

	public void openDiagram(IMultiDiagramEditor editor, final String name) {

		try {
			ModelSet modelSet = ServiceUtils.getInstance().getModelSet(editor.getServicesRegistry());
			NotationModel notation = (NotationModel) modelSet.getModel(NotationModel.MODEL_ID);
			Diagram diagram = notation.getDiagram(name);
			ServiceUtils.getInstance().getIPageManager(editor.getServicesRegistry()).openPage(diagram);
			flushDisplayEvents();
		} catch (Exception e) {
			throw new IllegalStateException("Cannot initialize test", e);
		}

	}

	/**
	 * 
	 */
	protected static final String CLASS_DIAGRAM_TYPE = "Class Diagram";
	/**
	 * 
	 */
	protected static final String CLASS_VISUALID = "2008";
	/**
	 * 
	 */
	protected static final String IMPLEMENTED_INTERFACES_HINT = "Implemented Interfaces";

	@Test
	public void load_DiagramExpansion() {
		//loading
		DiagramExpansionsRegistry diagramExpansionsRegistry=  loadXMIExpansionModel("AddBorderItem.xmi");
		Assert.assertEquals("Size ot the registry must be equals to 1",1,diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 1",1,diagramExpansionsRegistry.mapChildreen.size());

		//test the data structure that is interpreted by the framework
		ChildrenListRepresentation childrenListRepresentation= diagramExpansionsRegistry.mapChildreen.get(CLASS_DIAGRAM_TYPE);
		System.out.println(childrenListRepresentation);
		Assert.assertNotNull("A usage contex has been defined for "+CLASS_DIAGRAM_TYPE , childrenListRepresentation);
		Assert.assertNotNull("The class has been redefined",childrenListRepresentation.IDMap.get(CLASS_VISUALID));
		
		Assert.assertNotNull("The BorderItem of class has been added",childrenListRepresentation.IDMap.get(INTERFACE_BORDER_ITEM));
		List<String> the_2008_Children=childrenListRepresentation.parentChildrenRelation.get(CLASS_VISUALID);
		Assert.assertEquals("2008 can have a new compartment",1, the_2008_Children.size());
		Assert.assertEquals("2008 has to contain "+INTERFACE_BORDER_ITEM,INTERFACE_BORDER_ITEM, the_2008_Children.get(0));
		
		// the model is valid 
		//now launch a class diagram

		try {
			initModel("ExpansionModelProject", "ExpansionModelTest", getBundle());
			openDiagram(editor, "NewDiagram");
			DiagramEditPart diagramEditPart = (DiagramEditPart)editor.getAdapter(DiagramEditPart.class);
			Assert.assertNotNull("The diagram must be opened", diagramEditPart);
			IGraphicalEditPart classEditPart =(IGraphicalEditPart)diagramEditPart.getChildren().get(0);
			Assert.assertNotNull("A Class edit Part must exist", classEditPart);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	protected DiagramExpansionsRegistry loadXMIExpansionModel(String filename) {
		DiagramExpansionsRegistry diagramExpansionsRegistry= DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();
		diagramExpansionsRegistry.clear();
		Assert.assertEquals("Size ot the registry must be equals to 0",0,diagramExpansionsRegistry.getDiagramExpansions().size());
		Assert.assertEquals("Size ot the map childreen must be equals to 0",0,diagramExpansionsRegistry.mapChildreen.size());
		URI badContextExpansion = URI.createPlatformPluginURI("org.eclipse.papyrus.infra.gmfdiag.common.tests", true);
		badContextExpansion=badContextExpansion.appendSegment("models");
		badContextExpansion=badContextExpansion.appendSegment(filename);

		diagramExpansionsRegistry.loadExpansion(badContextExpansion);

		return diagramExpansionsRegistry;
	}
	/**
	 * @see org.eclipse.papyrus.junit.utils.tests.AbstractEditorTest#getSourcePath()
	 *
	 * @return
	 */
	@Override
	protected String getSourcePath() {
		return "models/";
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.infra.gmfdiag.common.Activator.getInstance().getBundle();
	}
}
