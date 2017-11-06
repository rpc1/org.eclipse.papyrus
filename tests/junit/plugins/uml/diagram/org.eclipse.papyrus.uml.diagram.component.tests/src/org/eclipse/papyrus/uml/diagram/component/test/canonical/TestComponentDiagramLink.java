/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.test.canonical;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.FailingTest;
import org.eclipse.papyrus.uml.diagram.component.CreateComponentDiagramCommand;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.component.test.IComponentDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.junit.Test;

/**
 * The Class TestComponentDiagramLink.
 */
public class TestComponentDiagramLink extends TestLink {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}
	
	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateComponentDiagramCommand();
	}
	
	@Override
	protected String getProjectName() {
		return IComponentDiagramTestsConstants.PROJECT_NAME;
	}

	@Override
	protected String getFileName() {
		return IComponentDiagramTestsConstants.FILE_NAME;
	}

	/**
	 * Test to manage Abstraction
	 */
	@Test
	@FailingTest
	public void testToManageAbstraction() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Abstraction_4013, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Dependency
	 */
	@Test
	@FailingTest
	public void testToManageDependency() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_3200, true);

	}

	/**
	 * Test to manage Manifestation
	 */
	@Test
	@FailingTest
	public void testToManageManifestation() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.Manifestation_4014, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Usage
	 */
	@Test
	@FailingTest
	public void testToManageUsage() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.Usage_4001, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Interface Realization
	 */
	@Test
	@FailingTest
	public void testToManageInterfaceRealization() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Interface_3205, UMLElementTypes.InterfaceRealization_4006, UMLElementTypes.Package_3200, true);
	}

	/**
	 * Test to manage Component Realization
	 */
	@Test
	@FailingTest
	public void testToManageComponentRealization() {
		testToManageLink(UMLElementTypes.Component_2002, UMLElementTypes.Component_2002, UMLElementTypes.ComponentRealization_4007, UMLElementTypes.Package_3200, true);
	}

}
