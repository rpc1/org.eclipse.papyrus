/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.custom;

import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.changeVisibility;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.AbstractTest;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.utils.TestPrepareUtils;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element Drop test (via palette tools) on Block.
 */
public class TestNodeDropOnBlockFlowPortCompartment extends AbstractTest {

	public static View containerView;

	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			View elementView = TestPrepareUtils.createGraphicalNode(SysMLElementTypes.BLOCK, SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_CLASSIFIER_ID, getDiagramView());
			containerView = ViewUtil.getChildBySemanticHint(elementView, SysMLGraphicalTypes.COMPARTMENT_SYSML_FLOWPORT_AS_LIST_ID);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}

			// Ensure the compartment is visible (required for EditPart to be found)
			if(!containerView.isVisible()) {
				changeVisibility(containerView);
			}

		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void testDropActor() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ACTOR, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropActorPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.ACTOR_PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropActorPartContained() throws Exception {
		dropFromModelExplorer(SysMLElementTypes.ACTOR_PART_PROPERTY, containerView, false);
	}

	@Test
	public void testDropBlock() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropComment() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.COMMENT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropCommentContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.COMMENT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintBlock() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraint() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.CONSTRAINT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.CONSTRAINT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.CONSTRAINT_BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropConstraintPropertyContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.CONSTRAINT_PROPERTY, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropDataType() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.DATA_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropDimension() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.DIMENSION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropEnumeration() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropEnumerationLiteral() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.ENUMERATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.ENUMERATION_LITERAL, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowPort() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowPortContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PORT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, true);
	}

	@Test
	public void testDropFlowProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropFlowSpecification() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.FLOW_SPECIFICATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropInstanceSpecification() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropInterface() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.INTERFACE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropModel() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.MODEL, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropOperation() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.OPERATION, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropOperationContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.OPERATION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPackage() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PACKAGE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPart() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPartContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.PART_PROPERTY, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPort() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PORT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPortContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PORT, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPrimitiveType() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PRIMITIVE_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropProperty() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropPropertyContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.PROPERTY, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReception() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.RECEPTION, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReceptionContained() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.RECEPTION, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReference() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropReferenceContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.REFERENCE_PROPERTY, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropSignal() throws Exception {
		EObject droppedElement = createElement(UMLElementTypes.SIGNAL, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropSlot() throws Exception {
		EObject intermediateContainer = createElement(UMLElementTypes.INSTANCE_SPECIFICATION, getDiagramView());
		EObject droppedElement = createElement(UMLElementTypes.SLOT, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropUnit() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.UNIT, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropValue() throws Exception {
		EObject intermediateContainer = createElement(SysMLElementTypes.BLOCK, getDiagramView());
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, intermediateContainer);
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropValueContained() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_PROPERTY, ViewUtil.getContainerView(containerView));
		dropFromModelExplorer(droppedElement, containerView, false);
	}

	@Test
	public void testDropValueType() throws Exception {
		EObject droppedElement = createElement(SysMLElementTypes.VALUE_TYPE, getDiagramView());
		dropFromModelExplorer(droppedElement, containerView, false);
	}
}
