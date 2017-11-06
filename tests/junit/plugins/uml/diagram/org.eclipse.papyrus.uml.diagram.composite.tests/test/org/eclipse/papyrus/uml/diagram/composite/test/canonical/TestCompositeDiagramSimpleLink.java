/*****************************************************************************
 * Copyright (c) 2014, 2015 CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *  Christian W. Damus - bug 468646
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.test.canonical;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.junit.framework.classification.InteractiveTest;
import org.eclipse.papyrus.uml.diagram.composite.CreateCompositeDiagramCommand;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.composite.test.ICompositeDiagramTestsConstants;
import org.eclipse.papyrus.uml.diagram.tests.canonical.TestLink;
import org.junit.Test;

/**
 * The Class TestCompositeDiagramLink use to test link.
 */
public class TestCompositeDiagramSimpleLink extends TestLink {

	@Override
	public DiagramUpdater getDiagramUpdater() {
		return UMLDiagramUpdater.INSTANCE;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getDiagramCommandCreation()
	 *
	 * @return
	 */

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new CreateCompositeDiagramCommand();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getProjectName()
	 *
	 * @return
	 */

	@Override
	protected String getProjectName() {
		return ICompositeDiagramTestsConstants.PROJECT_NAME;
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.tests.canonical.AbstractPapyrusTestCase#getFileName()
	 *
	 * @return
	 */

	@Override
	protected String getFileName() {
		return ICompositeDiagramTestsConstants.FILE_NAME;
	}


	/**
	 * Test to manage class usage.
	 */
	@Test
	public void testToManageClassUsage() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Usage_4008, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage class dependency.
	 */
	@Test
	public void testToManageClassDependency() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage class abstraction.
	 */
	@Test
	public void testToManageClassAbstraction() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Abstraction_4007, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage class realization.
	 */
	@Test
	public void testToManageClassRealization() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Realization_4006, UMLElementTypes.Package_1000, true);
	}

	// Activity
	/**
	 * Test to manage activity usage.
	 */
	@Test
	public void testToManageActivityUsage() {
		testToManageLink(UMLElementTypes.Activity_2060, UMLElementTypes.Activity_2060, UMLElementTypes.Usage_4008, UMLElementTypes.Package_1000, true);
	}



	/**
	 * Test to manage activity dependency.
	 */
	@Test
	public void testToManageActivityDependency() {
		testToManageLink(UMLElementTypes.Activity_2060, UMLElementTypes.Activity_2060, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage activity abstraction.
	 */
	@Test
	public void testToManageActivityAbstraction() {
		testToManageLink(UMLElementTypes.Activity_2060, UMLElementTypes.Activity_2060, UMLElementTypes.Abstraction_4007, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage activity realization.
	 */
	@Test
	public void testToManageActivityRealization() {
		testToManageLink(UMLElementTypes.Activity_2060, UMLElementTypes.Activity_2060, UMLElementTypes.Realization_4006, UMLElementTypes.Package_1000, true);
	}


	// State Machine
	/**
	 * Test to manage state machine usage.
	 */
	@Test
	public void testToManageStateMachineUsage() {
		testToManageLink(UMLElementTypes.StateMachine_2063, UMLElementTypes.StateMachine_2063, UMLElementTypes.Usage_4008, UMLElementTypes.Package_1000, true);
	}


	/**
	 * Test to manage state machine dependency.
	 */
	@Test
	public void testToManageStateMachineDependency() {
		testToManageLink(UMLElementTypes.StateMachine_2063, UMLElementTypes.StateMachine_2063, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage state machine abstraction.
	 */
	@Test
	public void testToManageStateMachineAbstraction() {
		testToManageLink(UMLElementTypes.StateMachine_2063, UMLElementTypes.StateMachine_2063, UMLElementTypes.Abstraction_4007, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage state machine realization.
	 */
	@Test
	public void testToManageStateMachineRealization() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Realization_4006, UMLElementTypes.Package_1000, true);
	}


	// Collaboration
	/**
	 * Test to manage collaboration usage.
	 */
	@Test
	public void testToManageCollaborationUsage() {
		testToManageLink(UMLElementTypes.Collaboration_2075, UMLElementTypes.Collaboration_2075, UMLElementTypes.Usage_4008, UMLElementTypes.Package_1000, true);
	}


	/**
	 * Test to manage collaboration dependency.
	 */
	@Test
	public void testToManageCollaborationDependency() {
		testToManageLink(UMLElementTypes.Collaboration_2075, UMLElementTypes.Collaboration_2075, UMLElementTypes.Dependency_4010, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage collaboration abstraction.
	 */
	@Test
	public void testToManageCollaborationAbstraction() {
		testToManageLink(UMLElementTypes.Collaboration_2075, UMLElementTypes.Collaboration_2075, UMLElementTypes.Abstraction_4007, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage collaboration realization.
	 */
	@Test
	public void testToManageCollaborationRealization() {
		testToManageLink(UMLElementTypes.Collaboration_2075, UMLElementTypes.Collaboration_2075, UMLElementTypes.Realization_4006, UMLElementTypes.Package_1000, true);
	}


	/**
	 * Test to manage component.
	 */
	@Test
	public void testToRealization() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Realization_4006, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToManifestation() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Manifestation_4012, UMLElementTypes.Package_1000, false);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToAbstraction() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Abstraction_4007, UMLElementTypes.Package_1000, true);
	}

	/**
	 * Test to manage component.
	 */
	@Test
	public void testToUsage() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.Usage_4008, UMLElementTypes.Package_1000, true);
	}


	/**
	 * Test to manage component.
	 */
	@Test
	@InteractiveTest
	public void testToInformationFlow() {
		testToManageLink(UMLElementTypes.Class_2073, UMLElementTypes.Class_2073, UMLElementTypes.InformationFlow_4021, UMLElementTypes.Package_1000, true);
	}


}
