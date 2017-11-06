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
package org.eclipse.papyrus.uml.diagram.composite.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.reconciler.DiagramVersioningUtils;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @generated
 */
public class UMLViewProvider extends AbstractProvider implements IViewProvider {

	/**
	 * @generated
	 */
	public final boolean provides(IOperation operation) {
		if(operation instanceof CreateViewForKindOperation) {
			return provides((CreateViewForKindOperation)operation);
		}
		assert operation instanceof CreateViewOperation;
		if(operation instanceof CreateDiagramViewOperation) {
			return provides((CreateDiagramViewOperation)operation);
		} else if(operation instanceof CreateEdgeViewOperation) {
			return provides((CreateEdgeViewOperation)operation);
		} else if(operation instanceof CreateNodeViewOperation) {
			return provides((CreateNodeViewOperation)operation);
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateViewForKindOperation op) {
		/*
				if (op.getViewKind() == Node.class)
					return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
				if (op.getViewKind() == Edge.class)
					return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
		 */
		// check Diagram Type should be the class diagram
		String modelID = UMLVisualIDRegistry.getModelID(op.getContainerView());
		if(!getDiagramProvidedId().equals(modelID)) {
			return false;
		}
		int visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
		if(Node.class.isAssignableFrom(op.getViewKind())) {
			return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
		}
		return true;
	}

	/**
	 * @generated
	 */
	protected String getDiagramProvidedId() {
		/*
		 * Indicates for which diagram this provider works for.
		 * <p>
		 * This method can be overloaded when diagram editor inherits from another one, but should never be <code>null</code>
		 * </p>
		 * 
		 * @return the unique identifier of the diagram for which views are provided.
		 */
		return CompositeStructureDiagramEditPart.MODEL_ID;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateDiagramViewOperation op) {
		return CompositeStructureDiagramEditPart.MODEL_ID.equals(op.getSemanticHint()) && UMLVisualIDRegistry.getDiagramVisualID(getSemanticElement(op.getSemanticAdapter())) != -1;
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateNodeViewOperation op) {
		if(op.getContainerView() == null) {
			return false;
		}
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		int visualID;
		if(op.getSemanticHint() == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if(elementType != null || domainElement == null) {
				return false;
			}
			visualID = UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(op.getSemanticHint());
			if(elementType != null) {
				if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
					return false; // foreign element type
				}
				String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
				if(!op.getSemanticHint().equals(elementTypeHint)) {
					return false; // if semantic hint is specified it should be the same as in element type
				}
				//if (domainElement != null && visualID != org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
				//	return false; // visual id for node EClass should match visual id from element type
				//}
			} else {
				if(!CompositeStructureDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(op.getContainerView()))) {
					return false; // foreign diagram
				}
				switch(visualID) {
				case BehaviorPortEditPart.VISUAL_ID:
					break; // pure design element
				case ActivityCompositeEditPart.VISUAL_ID:
				case InteractionCompositeEditPart.VISUAL_ID:
				case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
				case StateMachineCompositeEditPart.VISUAL_ID:
				case FunctionBehaviorCompositeEditPart.VISUAL_ID:
				case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
				case ComponentCompositeEditPart.VISUAL_ID:
				case DeviceCompositeEditPart.VISUAL_ID:
				case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
				case NodeCompositeEditPart.VISUAL_ID:
				case ClassCompositeEditPart.VISUAL_ID:
				case PrimitiveTypeEditPart.VISUAL_ID:
				case EnumerationEditPart.VISUAL_ID:
				case DataTypeEditPart.VISUAL_ID:
				case SignalEventEditPart.VISUAL_ID:
				case CallEventEditPart.VISUAL_ID:
				case AnyReceiveEventEditPart.VISUAL_ID:
				case ChangeEventEditPart.VISUAL_ID:
				case TimeEventEditPart.VISUAL_ID:
				case DurationObservationEditPart.VISUAL_ID:
				case TimeObservationEditPart.VISUAL_ID:
				case LiteralBooleanEditPart.VISUAL_ID:
				case LiteralIntegerEditPart.VISUAL_ID:
				case LiteralNullEditPart.VISUAL_ID:
				case LiteralStringEditPart.VISUAL_ID:
				case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
				case StringExpressionEditPart.VISUAL_ID:
				case OpaqueExpressionEditPart.VISUAL_ID:
				case TimeExpressionEditPart.VISUAL_ID:
				case ExpressionEditPart.VISUAL_ID:
				case DurationEditPart.VISUAL_ID:
				case TimeIntervalEditPart.VISUAL_ID:
				case DurationIntervalEditPart.VISUAL_ID:
				case IntervalEditPart.VISUAL_ID:
				case InstanceValueEditPart.VISUAL_ID:
				case TimeConstraintEditPart.VISUAL_ID:
				case IntervalConstraintEditPart.VISUAL_ID:
				case InteractionConstraintEditPart.VISUAL_ID:
				case ConstraintEditPart.VISUAL_ID:
				case PortEditPart.VISUAL_ID:
				case ParameterEditPart.VISUAL_ID:
				case PropertyPartEditPartCN.VISUAL_ID:
				case CollaborationRoleEditPartCN.VISUAL_ID:
				case CollaborationUseEditPartCN.VISUAL_ID:
				case CollaborationCompositeEditPartCN.VISUAL_ID:
				case InterfaceEditPartCN.VISUAL_ID:
				case ActorEditPartCN.VISUAL_ID:
				case DeploymentSpecificationEditPartCN.VISUAL_ID:
				case ArtifactEditPartCN.VISUAL_ID:
				case InformationItemEditPartCN.VISUAL_ID:
				case SignalEditPartCN.VISUAL_ID:
				case UseCaseEditPartCN.VISUAL_ID:
				case CommentEditPartCN.VISUAL_ID:
				case EnumerationLiteralEditPartCLN.VISUAL_ID:
				case CollaborationCompositeEditPart.VISUAL_ID:
				case InterfaceEditPart.VISUAL_ID:
				case ActorEditPart.VISUAL_ID:
				case DeploymentSpecificationEditPart.VISUAL_ID:
				case ArtifactEditPart.VISUAL_ID:
				case InformationItemEditPart.VISUAL_ID:
				case SignalEditPart.VISUAL_ID:
				case UseCaseEditPart.VISUAL_ID:
				case CommentEditPart.VISUAL_ID:
				case DurationConstraintEditPart.VISUAL_ID:
				case ActivityCompositeEditPartCN.VISUAL_ID:
				case InteractionCompositeEditPartCN.VISUAL_ID:
				case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
				case StateMachineCompositeEditPartCN.VISUAL_ID:
				case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
				case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
				case ComponentCompositeEditPartCN.VISUAL_ID:
				case DeviceCompositeEditPartCN.VISUAL_ID:
				case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
				case NodeCompositeEditPartCN.VISUAL_ID:
				case ClassCompositeEditPartCN.VISUAL_ID:
				case PrimitiveTypeEditPartCN.VISUAL_ID:
				case EnumerationEditPartCN.VISUAL_ID:
				case DataTypeEditPartCN.VISUAL_ID:
				case DurationConstraintEditPartCN.VISUAL_ID:
				case TimeConstraintEditPartCN.VISUAL_ID:
				case IntervalConstraintEditPartCN.VISUAL_ID:
				case InteractionConstraintEditPartCN.VISUAL_ID:
				case ConstraintEditPartCN.VISUAL_ID:
				case PropertyEditPartCLN.VISUAL_ID:
				case OperationEditPartCLN.VISUAL_ID:
					if(domainElement == null || visualID != UMLVisualIDRegistry.getNodeVisualID(op.getContainerView(), domainElement)) {
						return false; // visual id in semantic hint should match visual id for domain element
					}
					break;
				default:
					return false;
				}
			}
		}
		return UMLVisualIDRegistry.canCreateNode(op.getContainerView(), visualID);
	}

	/**
	 * @generated
	 */
	protected boolean provides(CreateEdgeViewOperation op) {
		IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
		//RS: add code for extended types creation
		if(elementType instanceof IExtendedHintedElementType) {
			IElementType closestNonExtendedType = ElementTypeUtils.getClosestDiagramType(elementType);
			if(!UMLElementTypes.isKnownElementType(closestNonExtendedType) || (!(closestNonExtendedType instanceof IHintedType))) {
				return false; // foreign element type.
			}
		} else {
			if(!UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof IHintedType))) {
				return false; // foreign element type
			}
		}
		//if (!org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes.isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
		//	return false; // foreign element type
		//}
		// END R.S.
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		if(elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
			return false; // our hint is visual id and must be specified, and it should be the same as in element type
		}
		//int visualID = org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getVisualID(elementTypeHint);
		//org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
		//if (domainElement != null && visualID != org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
		//	return false; // visual id for link EClass should match visual id from element type
		//}
		return true;
	}

	/**
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public Diagram createDiagram(IAdaptable semanticAdapter, String diagramKind, PreferencesHint preferencesHint) {
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		DiagramVersioningUtils.stampCurrentVersion(diagram);
		diagram.getStyles().add(NotationFactory.eINSTANCE.createDiagramStyle());
		diagram.setType(CompositeStructureDiagramEditPart.MODEL_ID);
		diagram.setElement(getSemanticElement(semanticAdapter));
		diagram.setMeasurementUnit(MeasurementUnit.PIXEL_LITERAL);
		return diagram;
	}

	/**
	 * @generated
	 */
	public Node createNode(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		final EObject domainElement = getSemanticElement(semanticAdapter);
		final int visualID;
		if(semanticHint == null) {
			visualID = UMLVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		} else {
			visualID = UMLVisualIDRegistry.getVisualID(semanticHint);
		}
		switch(visualID) {
		case ActivityCompositeEditPart.VISUAL_ID:
			return createActivity_2060(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionCompositeEditPart.VISUAL_ID:
			return createInteraction_2061(domainElement, containerView, index, persisted, preferencesHint);
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			return createProtocolStateMachine_2062(domainElement, containerView, index, persisted, preferencesHint);
		case StateMachineCompositeEditPart.VISUAL_ID:
			return createStateMachine_2063(domainElement, containerView, index, persisted, preferencesHint);
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			return createFunctionBehavior_2064(domainElement, containerView, index, persisted, preferencesHint);
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			return createOpaqueBehavior_2065(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentCompositeEditPart.VISUAL_ID:
			return createComponent_2069(domainElement, containerView, index, persisted, preferencesHint);
		case DeviceCompositeEditPart.VISUAL_ID:
			return createDevice_2070(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			return createExecutionEnvironment_2071(domainElement, containerView, index, persisted, preferencesHint);
		case NodeCompositeEditPart.VISUAL_ID:
			return createNode_2072(domainElement, containerView, index, persisted, preferencesHint);
		case ClassCompositeEditPart.VISUAL_ID:
			return createClass_2073(domainElement, containerView, index, persisted, preferencesHint);
		case CollaborationCompositeEditPart.VISUAL_ID:
			return createCollaboration_2075(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPart.VISUAL_ID:
			return createInterface_2076(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPart.VISUAL_ID:
			return createPrimitiveType_2066(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPart.VISUAL_ID:
			return createEnumeration_2067(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPart.VISUAL_ID:
			return createDataType_2068(domainElement, containerView, index, persisted, preferencesHint);
		case ActorEditPart.VISUAL_ID:
			return createActor_2077(domainElement, containerView, index, persisted, preferencesHint);
		case DeploymentSpecificationEditPart.VISUAL_ID:
			return createDeploymentSpecification_2078(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPart.VISUAL_ID:
			return createArtifact_2079(domainElement, containerView, index, persisted, preferencesHint);
		case InformationItemEditPart.VISUAL_ID:
			return createInformationItem_2080(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPart.VISUAL_ID:
			return createSignal_2081(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseEditPart.VISUAL_ID:
			return createUseCase_2082(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEventEditPart.VISUAL_ID:
			return createSignalEvent_2083(domainElement, containerView, index, persisted, preferencesHint);
		case CallEventEditPart.VISUAL_ID:
			return createCallEvent_2084(domainElement, containerView, index, persisted, preferencesHint);
		case AnyReceiveEventEditPart.VISUAL_ID:
			return createAnyReceiveEvent_2085(domainElement, containerView, index, persisted, preferencesHint);
		case ChangeEventEditPart.VISUAL_ID:
			return createChangeEvent_2088(domainElement, containerView, index, persisted, preferencesHint);
		case TimeEventEditPart.VISUAL_ID:
			return createTimeEvent_2089(domainElement, containerView, index, persisted, preferencesHint);
		case DurationObservationEditPart.VISUAL_ID:
			return createDurationObservation_2093(domainElement, containerView, index, persisted, preferencesHint);
		case TimeObservationEditPart.VISUAL_ID:
			return createTimeObservation_2094(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralBooleanEditPart.VISUAL_ID:
			return createLiteralBoolean_2095(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralIntegerEditPart.VISUAL_ID:
			return createLiteralInteger_2096(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralNullEditPart.VISUAL_ID:
			return createLiteralNull_2097(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralStringEditPart.VISUAL_ID:
			return createLiteralString_2098(domainElement, containerView, index, persisted, preferencesHint);
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			return createLiteralUnlimitedNatural_2099(domainElement, containerView, index, persisted, preferencesHint);
		case StringExpressionEditPart.VISUAL_ID:
			return createStringExpression_2100(domainElement, containerView, index, persisted, preferencesHint);
		case OpaqueExpressionEditPart.VISUAL_ID:
			return createOpaqueExpression_2101(domainElement, containerView, index, persisted, preferencesHint);
		case TimeExpressionEditPart.VISUAL_ID:
			return createTimeExpression_2102(domainElement, containerView, index, persisted, preferencesHint);
		case ExpressionEditPart.VISUAL_ID:
			return createExpression_2103(domainElement, containerView, index, persisted, preferencesHint);
		case DurationEditPart.VISUAL_ID:
			return createDuration_2104(domainElement, containerView, index, persisted, preferencesHint);
		case TimeIntervalEditPart.VISUAL_ID:
			return createTimeInterval_2105(domainElement, containerView, index, persisted, preferencesHint);
		case DurationIntervalEditPart.VISUAL_ID:
			return createDurationInterval_2106(domainElement, containerView, index, persisted, preferencesHint);
		case IntervalEditPart.VISUAL_ID:
			return createInterval_2107(domainElement, containerView, index, persisted, preferencesHint);
		case InstanceValueEditPart.VISUAL_ID:
			return createInstanceValue_2108(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPart.VISUAL_ID:
			return createComment_2109(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintEditPart.VISUAL_ID:
			return createDurationConstraint_2110(domainElement, containerView, index, persisted, preferencesHint);
		case TimeConstraintEditPart.VISUAL_ID:
			return createTimeConstraint_2111(domainElement, containerView, index, persisted, preferencesHint);
		case IntervalConstraintEditPart.VISUAL_ID:
			return createIntervalConstraint_2112(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionConstraintEditPart.VISUAL_ID:
			return createInteractionConstraint_2113(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPart.VISUAL_ID:
			return createConstraint_2114(domainElement, containerView, index, persisted, preferencesHint);
		case BehaviorPortEditPart.VISUAL_ID:
			return createNode_3121(domainElement, containerView, index, persisted, preferencesHint);
		case PortEditPart.VISUAL_ID:
			return createPort_3069(domainElement, containerView, index, persisted, preferencesHint);
		case ParameterEditPart.VISUAL_ID:
			return createParameter_3088(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyPartEditPartCN.VISUAL_ID:
			return createProperty_3070(domainElement, containerView, index, persisted, preferencesHint);
		case CollaborationRoleEditPartCN.VISUAL_ID:
			return createConnectableElement_3115(domainElement, containerView, index, persisted, preferencesHint);
		case CollaborationUseEditPartCN.VISUAL_ID:
			return createCollaborationUse_3071(domainElement, containerView, index, persisted, preferencesHint);
		case ActivityCompositeEditPartCN.VISUAL_ID:
			return createActivity_3072(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionCompositeEditPartCN.VISUAL_ID:
			return createInteraction_3073(domainElement, containerView, index, persisted, preferencesHint);
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			return createProtocolStateMachine_3074(domainElement, containerView, index, persisted, preferencesHint);
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			return createStateMachine_3075(domainElement, containerView, index, persisted, preferencesHint);
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			return createFunctionBehavior_3076(domainElement, containerView, index, persisted, preferencesHint);
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			return createOpaqueBehavior_3077(domainElement, containerView, index, persisted, preferencesHint);
		case ComponentCompositeEditPartCN.VISUAL_ID:
			return createComponent_3081(domainElement, containerView, index, persisted, preferencesHint);
		case DeviceCompositeEditPartCN.VISUAL_ID:
			return createDevice_3082(domainElement, containerView, index, persisted, preferencesHint);
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			return createExecutionEnvironment_3083(domainElement, containerView, index, persisted, preferencesHint);
		case NodeCompositeEditPartCN.VISUAL_ID:
			return createNode_3084(domainElement, containerView, index, persisted, preferencesHint);
		case ClassCompositeEditPartCN.VISUAL_ID:
			return createClass_3085(domainElement, containerView, index, persisted, preferencesHint);
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			return createCollaboration_3086(domainElement, containerView, index, persisted, preferencesHint);
		case InterfaceEditPartCN.VISUAL_ID:
			return createInterface_3087(domainElement, containerView, index, persisted, preferencesHint);
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			return createPrimitiveType_3078(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationEditPartCN.VISUAL_ID:
			return createEnumeration_3079(domainElement, containerView, index, persisted, preferencesHint);
		case DataTypeEditPartCN.VISUAL_ID:
			return createDataType_3080(domainElement, containerView, index, persisted, preferencesHint);
		case ActorEditPartCN.VISUAL_ID:
			return createActor_3091(domainElement, containerView, index, persisted, preferencesHint);
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			return createDeploymentSpecification_3092(domainElement, containerView, index, persisted, preferencesHint);
		case ArtifactEditPartCN.VISUAL_ID:
			return createArtifact_3093(domainElement, containerView, index, persisted, preferencesHint);
		case InformationItemEditPartCN.VISUAL_ID:
			return createInformationItem_3094(domainElement, containerView, index, persisted, preferencesHint);
		case SignalEditPartCN.VISUAL_ID:
			return createSignal_3095(domainElement, containerView, index, persisted, preferencesHint);
		case UseCaseEditPartCN.VISUAL_ID:
			return createUseCase_3096(domainElement, containerView, index, persisted, preferencesHint);
		case CommentEditPartCN.VISUAL_ID:
			return createComment_3097(domainElement, containerView, index, persisted, preferencesHint);
		case DurationConstraintEditPartCN.VISUAL_ID:
			return createDurationConstraint_3116(domainElement, containerView, index, persisted, preferencesHint);
		case TimeConstraintEditPartCN.VISUAL_ID:
			return createTimeConstraint_3117(domainElement, containerView, index, persisted, preferencesHint);
		case IntervalConstraintEditPartCN.VISUAL_ID:
			return createIntervalConstraint_3118(domainElement, containerView, index, persisted, preferencesHint);
		case InteractionConstraintEditPartCN.VISUAL_ID:
			return createInteractionConstraint_3119(domainElement, containerView, index, persisted, preferencesHint);
		case ConstraintEditPartCN.VISUAL_ID:
			return createConstraint_3120(domainElement, containerView, index, persisted, preferencesHint);
		case PropertyEditPartCLN.VISUAL_ID:
			return createProperty_3101(domainElement, containerView, index, persisted, preferencesHint);
		case OperationEditPartCLN.VISUAL_ID:
			return createOperation_3102(domainElement, containerView, index, persisted, preferencesHint);
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			return createEnumerationLiteral_3066(domainElement, containerView, index, persisted, preferencesHint);
		}
		// can't happen, provided #provides(CreateNodeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Edge createEdge(IAdaptable semanticAdapter, View containerView, String semanticHint, int index, boolean persisted, PreferencesHint preferencesHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		String elementTypeHint = ((IHintedType)elementType).getSemanticHint();
		switch(UMLVisualIDRegistry.getVisualID(elementTypeHint)) {
		case BehaviorPortLinkEditPart.VISUAL_ID:
			return createLink_4022(containerView, index, persisted, preferencesHint);
		case LinkDescriptorEditPart.VISUAL_ID:
			return createLink_4001(containerView, index, persisted, preferencesHint);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return createCommentAnnotatedElement_4002(containerView, index, persisted, preferencesHint);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return createConstraintConstrainedElement_4003(containerView, index, persisted, preferencesHint);
		case ComponentRealizationEditPart.VISUAL_ID:
			return createComponentRealization_4004(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case InterfaceRealizationEditPart.VISUAL_ID:
			return createInterfaceRealization_4005(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case SubstitutionEditPart.VISUAL_ID:
			return createSubstitution_4011(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case RealizationEditPart.VISUAL_ID:
			return createRealization_4006(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ManifestationEditPart.VISUAL_ID:
			return createManifestation_4012(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case AbstractionEditPart.VISUAL_ID:
			return createAbstraction_4007(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case UsageEditPart.VISUAL_ID:
			return createUsage_4008(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DeploymentEditPart.VISUAL_ID:
			return createDeployment_4009(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case RoleBindingEditPart.VISUAL_ID:
			return createDependency_4017(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case DependencyEditPart.VISUAL_ID:
			return createDependency_4010(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case ConnectorEditPart.VISUAL_ID:
			return createConnector_4013(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case GeneralizationEditPart.VISUAL_ID:
			return createGeneralization_4015(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		case TimeObservationEventEditPart.VISUAL_ID:
			return createTimeObservationEvent_4018(containerView, index, persisted, preferencesHint);
		case DurationObservationEventEditPart.VISUAL_ID:
			return createDurationObservationEvent_4019(containerView, index, persisted, preferencesHint);
		case RepresentationEditPart.VISUAL_ID:
			return createInformationItemRepresented_4020(containerView, index, persisted, preferencesHint);
		case InformationFlowEditPart.VISUAL_ID:
			return createInformationFlow_4021(getSemanticElement(semanticAdapter), containerView, index, persisted, preferencesHint);
		}
		// can never happen, provided #provides(CreateEdgeViewOperation) is correct
		return null;
	}

	/**
	 * @generated
	 */
	public Node createActivity_2060(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Activity");
		Node label5112 = createLabel(node, UMLVisualIDRegistry.getType(ActivityCompositeNameEditPart.VISUAL_ID));
		Node label6079 = createLabel(node, UMLVisualIDRegistry.getType(ActivityCompositeFloatingLabelEditPart.VISUAL_ID));
		label6079.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6079 = (Location)label6079.getLayoutConstraint();
		location6079.setX(0);
		location6079.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Activity");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteraction_2061(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interaction");
		Node label5113 = createLabel(node, UMLVisualIDRegistry.getType(InteractionCompositeNameEditPart.VISUAL_ID));
		Node label6080 = createLabel(node, UMLVisualIDRegistry.getType(InteractionCompositeFloatingLabelEditPart.VISUAL_ID));
		label6080.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6080 = (Location)label6080.getLayoutConstraint();
		location6080.setX(0);
		location6080.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(InteractionCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Interaction");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProtocolStateMachine_2062(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ProtocolStateMachine");
		Node label5114 = createLabel(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeNameEditPart.VISUAL_ID));
		Node label6081 = createLabel(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeFloatingLabelEditPart.VISUAL_ID));
		label6081.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6081 = (Location)label6081.getLayoutConstraint();
		location6081.setX(0);
		location6081.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ProtocolStateMachine");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStateMachine_2063(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StateMachineCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StateMachine");
		Node label5115 = createLabel(node, UMLVisualIDRegistry.getType(StateMachineCompositeNameEditPart.VISUAL_ID));
		Node label6082 = createLabel(node, UMLVisualIDRegistry.getType(StateMachineCompositeFloatingLabelEditPart.VISUAL_ID));
		label6082.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6082 = (Location)label6082.getLayoutConstraint();
		location6082.setX(0);
		location6082.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(StateMachineCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "StateMachine");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createFunctionBehavior_2064(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(FunctionBehaviorCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "FunctionBehavior");
		Node label5116 = createLabel(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeNameEditPart.VISUAL_ID));
		Node label6083 = createLabel(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeFloatingLabelEditPart.VISUAL_ID));
		label6083.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6083 = (Location)label6083.getLayoutConstraint();
		location6083.setX(0);
		location6083.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "FunctionBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOpaqueBehavior_2065(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OpaqueBehavior");
		Node label5117 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeNameEditPart.VISUAL_ID));
		Node label6084 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeFloatingLabelEditPart.VISUAL_ID));
		label6084.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6084 = (Location)label6084.getLayoutConstraint();
		location6084.setX(0);
		location6084.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "OpaqueBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_2069(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5121 = createLabel(node, UMLVisualIDRegistry.getType(ComponentCompositeNameEditPart.VISUAL_ID));
		Node label6085 = createLabel(node, UMLVisualIDRegistry.getType(ComponentCompositeFloatingLabelEditPart.VISUAL_ID));
		label6085.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6085 = (Location)label6085.getLayoutConstraint();
		location6085.setX(0);
		location6085.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_2070(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeviceCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Device");
		Node label5122 = createLabel(node, UMLVisualIDRegistry.getType(DeviceCompositeNameEditPart.VISUAL_ID));
		Node label6086 = createLabel(node, UMLVisualIDRegistry.getType(DeviceCompositeFloatingLabelEditPart.VISUAL_ID));
		label6086.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6086 = (Location)label6086.getLayoutConstraint();
		location6086.setX(0);
		location6086.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(DeviceCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Device");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_2071(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExecutionEnvironment");
		Node label5123 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeNameEditPart.VISUAL_ID));
		Node label6087 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeFloatingLabelEditPart.VISUAL_ID));
		label6087.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6087 = (Location)label6087.getLayoutConstraint();
		location6087.setX(0);
		location6087.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ExecutionEnvironment");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_2072(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NodeCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Node");
		Node label5124 = createLabel(node, UMLVisualIDRegistry.getType(NodeCompositeNameEditPart.VISUAL_ID));
		Node label6088 = createLabel(node, UMLVisualIDRegistry.getType(NodeCompositeFloatingLabelEditPart.VISUAL_ID));
		label6088.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6088 = (Location)label6088.getLayoutConstraint();
		location6088.setX(0);
		location6088.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(NodeCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Node");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_2073(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		Node label5156 = createLabel(node, UMLVisualIDRegistry.getType(ClassCompositeNameEditPart.VISUAL_ID));
		Node label6089 = createLabel(node, UMLVisualIDRegistry.getType(ClassCompositeFloatingLabelEditPart.VISUAL_ID));
		label6089.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6089 = (Location)label6089.getLayoutConstraint();
		location6089.setX(0);
		location6089.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCollaboration_2075(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CollaborationCompositeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Collaboration");
		Node label5158 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationCompositeNameEditPart.VISUAL_ID));
		Node label6090 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationCompositeFloatingLabelEditPart.VISUAL_ID));
		label6090.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6090 = (Location)label6090.getLayoutConstraint();
		location6090.setX(0);
		location6090.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(CollaborationCompositeCompartmentEditPart.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Collaboration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_2076(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		Node label5159 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPart.VISUAL_ID));
		Node label6091 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceFloatingLabelEditPart.VISUAL_ID));
		label6091.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6091 = (Location)label6091.getLayoutConstraint();
		location6091.setX(0);
		location6091.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_2066(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "PrimitiveType");
		Node label5118 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPart.VISUAL_ID));
		Node label6092 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeFloatingLabelEditPart.VISUAL_ID));
		label6092.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6092 = (Location)label6092.getLayoutConstraint();
		location6092.setX(0);
		location6092.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_2067(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Enumeration");
		Node label5119 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPart.VISUAL_ID));
		Node label6093 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationFloatingLabelEditPart.VISUAL_ID));
		label6093.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6093 = (Location)label6093.getLayoutConstraint();
		location6093.setX(0);
		location6093.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Enumeration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_2068(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DataType");
		Node label5120 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPart.VISUAL_ID));
		Node label6094 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeFloatingLabelEditPart.VISUAL_ID));
		label6094.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6094 = (Location)label6094.getLayoutConstraint();
		location6094.setX(0);
		location6094.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartmentEditPart.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartmentEditPart.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "DataType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_2077(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		Node label5160 = createLabel(node, UMLVisualIDRegistry.getType(ActorNameEditPart.VISUAL_ID));
		Node label6095 = createLabel(node, UMLVisualIDRegistry.getType(ActorFloatingLabelEditPart.VISUAL_ID));
		label6095.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6095 = (Location)label6095.getLayoutConstraint();
		location6095.setX(0);
		location6095.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDeploymentSpecification_2078(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeploymentSpecificationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DeploymentSpecification");
		Node label5161 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationNameEditPart.VISUAL_ID));
		Node label6096 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationFloatingLabelEditPart.VISUAL_ID));
		label6096.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6096 = (Location)label6096.getLayoutConstraint();
		location6096.setX(0);
		location6096.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_2079(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");
		Node label5162 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactNameEditPart.VISUAL_ID));
		Node label6097 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactFloatingLabelEditPart.VISUAL_ID));
		label6097.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6097 = (Location)label6097.getLayoutConstraint();
		location6097.setX(0);
		location6097.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInformationItem_2080(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InformationItemEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InformationItem");
		Node label5163 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemNameEditPart.VISUAL_ID));
		Node label6098 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemFloatingLabelEditPart.VISUAL_ID));
		label6098.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6098 = (Location)label6098.getLayoutConstraint();
		location6098.setX(0);
		location6098.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_2081(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Signal");
		Node label5164 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPart.VISUAL_ID));
		Node label6099 = createLabel(node, UMLVisualIDRegistry.getType(SignalFloatingLabelEditPart.VISUAL_ID));
		label6099.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6099 = (Location)label6099.getLayoutConstraint();
		location6099.setX(0);
		location6099.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_2082(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		Node label5165 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseNameEditPart.VISUAL_ID));
		Node label6100 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseFloatingLabelEditPart.VISUAL_ID));
		label6100.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6100 = (Location)label6100.getLayoutConstraint();
		location6100.setX(0);
		location6100.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignalEvent_2083(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEventEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "SignalEvent");
		Node label5166 = createLabel(node, UMLVisualIDRegistry.getType(SignalEventNameEditPart.VISUAL_ID));
		Node label6101 = createLabel(node, UMLVisualIDRegistry.getType(SignalEventFloatingLabelEditPart.VISUAL_ID));
		label6101.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6101 = (Location)label6101.getLayoutConstraint();
		location6101.setX(0);
		location6101.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCallEvent_2084(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CallEventEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CallEvent");
		Node label5167 = createLabel(node, UMLVisualIDRegistry.getType(CallEventNameEditPart.VISUAL_ID));
		Node label6102 = createLabel(node, UMLVisualIDRegistry.getType(CallEventFloatingLabelEditPart.VISUAL_ID));
		label6102.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6102 = (Location)label6102.getLayoutConstraint();
		location6102.setX(0);
		location6102.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createAnyReceiveEvent_2085(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(AnyReceiveEventEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "AnyReceiveEvent");
		Node label5168 = createLabel(node, UMLVisualIDRegistry.getType(AnyReceiveEventNameEditPart.VISUAL_ID));
		Node label6103 = createLabel(node, UMLVisualIDRegistry.getType(AnyReceiveEventFloatingLabelEditPart.VISUAL_ID));
		label6103.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6103 = (Location)label6103.getLayoutConstraint();
		location6103.setX(0);
		location6103.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createChangeEvent_2088(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ChangeEventEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ChangeEvent");
		Node label5171 = createLabel(node, UMLVisualIDRegistry.getType(ChangeEventNameEditPart.VISUAL_ID));
		Node label6104 = createLabel(node, UMLVisualIDRegistry.getType(ChangeEventFloatingLabelEditPart.VISUAL_ID));
		label6104.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6104 = (Location)label6104.getLayoutConstraint();
		location6104.setX(0);
		location6104.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeEvent_2089(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeEventEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeEvent");
		Node label5172 = createLabel(node, UMLVisualIDRegistry.getType(TimeEventNameEditPart.VISUAL_ID));
		Node label6105 = createLabel(node, UMLVisualIDRegistry.getType(TimeEventFloatingLabelEditPart.VISUAL_ID));
		label6105.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6105 = (Location)label6105.getLayoutConstraint();
		location6105.setX(0);
		location6105.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationObservation_2093(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationObservation");
		Node label5151 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationNameEditPart.VISUAL_ID));
		label5151.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5151 = (Location)label5151.getLayoutConstraint();
		location5151.setX(25);
		location5151.setY(3);
		Node label5152 = createLabel(node, UMLVisualIDRegistry.getType(DurationObservationStereotypeLabelEditPart.VISUAL_ID));
		label5152.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5152 = (Location)label5152.getLayoutConstraint();
		location5152.setX(25);
		location5152.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeObservation_2094(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeObservationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeObservation");
		Node label5142 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationNameEditPart.VISUAL_ID));
		label5142.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5142 = (Location)label5142.getLayoutConstraint();
		location5142.setX(25);
		location5142.setY(3);
		Node label5143 = createLabel(node, UMLVisualIDRegistry.getType(TimeObservationStereotypeLabelEditPart.VISUAL_ID));
		label5143.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5143 = (Location)label5143.getLayoutConstraint();
		location5143.setX(25);
		location5143.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralBoolean_2095(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LiteralBooleanEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LiteralBoolean");
		Node label5178 = createLabel(node, UMLVisualIDRegistry.getType(LiteralBooleanNameEditPart.VISUAL_ID));
		Node label6106 = createLabel(node, UMLVisualIDRegistry.getType(LiteralBooleanFloatingLabelEditPart.VISUAL_ID));
		label6106.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6106 = (Location)label6106.getLayoutConstraint();
		location6106.setX(0);
		location6106.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralInteger_2096(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LiteralIntegerEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LiteralInteger");
		Node label5179 = createLabel(node, UMLVisualIDRegistry.getType(LiteralIntegerNameEditPart.VISUAL_ID));
		Node label6107 = createLabel(node, UMLVisualIDRegistry.getType(LiteralIntegerFloatingLabelEditPart.VISUAL_ID));
		label6107.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6107 = (Location)label6107.getLayoutConstraint();
		location6107.setX(0);
		location6107.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralNull_2097(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LiteralNullEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LiteralNull");
		Node label5180 = createLabel(node, UMLVisualIDRegistry.getType(LiteralNullNameEditPart.VISUAL_ID));
		Node label6108 = createLabel(node, UMLVisualIDRegistry.getType(LiteralNullFloatingLabelEditPart.VISUAL_ID));
		label6108.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6108 = (Location)label6108.getLayoutConstraint();
		location6108.setX(0);
		location6108.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralString_2098(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LiteralStringEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LiteralString");
		Node label5181 = createLabel(node, UMLVisualIDRegistry.getType(LiteralStringNameEditPart.VISUAL_ID));
		Node label6109 = createLabel(node, UMLVisualIDRegistry.getType(LiteralStringFloatingLabelEditPart.VISUAL_ID));
		label6109.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6109 = (Location)label6109.getLayoutConstraint();
		location6109.setX(0);
		location6109.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createLiteralUnlimitedNatural_2099(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(LiteralUnlimitedNaturalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "LiteralUnlimitedNatural");
		Node label5182 = createLabel(node, UMLVisualIDRegistry.getType(LiteralUnlimitedNaturalNameEditPart.VISUAL_ID));
		Node label6110 = createLabel(node, UMLVisualIDRegistry.getType(LiteralUnlimitedNaturalFloatingLabelEditPart.VISUAL_ID));
		label6110.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6110 = (Location)label6110.getLayoutConstraint();
		location6110.setX(0);
		location6110.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStringExpression_2100(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StringExpressionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StringExpression");
		Node label5183 = createLabel(node, UMLVisualIDRegistry.getType(StringExpressionNameEditPart.VISUAL_ID));
		Node label6111 = createLabel(node, UMLVisualIDRegistry.getType(StringExpressionFloatingLabelEditPart.VISUAL_ID));
		label6111.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6111 = (Location)label6111.getLayoutConstraint();
		location6111.setX(0);
		location6111.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOpaqueExpression_2101(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OpaqueExpressionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OpaqueExpression");
		Node label5184 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueExpressionNameEditPart.VISUAL_ID));
		Node label6112 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueExpressionFloatingLabelEditPart.VISUAL_ID));
		label6112.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6112 = (Location)label6112.getLayoutConstraint();
		location6112.setX(0);
		location6112.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeExpression_2102(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeExpressionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeExpression");
		Node label5185 = createLabel(node, UMLVisualIDRegistry.getType(TimeExpressionNameEditPart.VISUAL_ID));
		Node label6113 = createLabel(node, UMLVisualIDRegistry.getType(TimeExpressionFloatingLabelEditPart.VISUAL_ID));
		label6113.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6113 = (Location)label6113.getLayoutConstraint();
		location6113.setX(0);
		location6113.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExpression_2103(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExpressionEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Expression");
		Node label5186 = createLabel(node, UMLVisualIDRegistry.getType(ExpressionNameEditPart.VISUAL_ID));
		Node label6114 = createLabel(node, UMLVisualIDRegistry.getType(ExpressionFloatingLabelEditPart.VISUAL_ID));
		label6114.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6114 = (Location)label6114.getLayoutConstraint();
		location6114.setX(0);
		location6114.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDuration_2104(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Duration");
		Node label5187 = createLabel(node, UMLVisualIDRegistry.getType(DurationNameEditPart.VISUAL_ID));
		Node label6115 = createLabel(node, UMLVisualIDRegistry.getType(DurationFloatingLabelEditPart.VISUAL_ID));
		label6115.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6115 = (Location)label6115.getLayoutConstraint();
		location6115.setX(0);
		location6115.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeInterval_2105(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeIntervalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeInterval");
		Node label5188 = createLabel(node, UMLVisualIDRegistry.getType(TimeIntervalNameEditPart.VISUAL_ID));
		Node label6116 = createLabel(node, UMLVisualIDRegistry.getType(TimeIntervalFloatingLabelEditPart.VISUAL_ID));
		label6116.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6116 = (Location)label6116.getLayoutConstraint();
		location6116.setX(0);
		location6116.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationInterval_2106(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationIntervalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationInterval");
		Node label5189 = createLabel(node, UMLVisualIDRegistry.getType(DurationIntervalNameEditPart.VISUAL_ID));
		Node label6117 = createLabel(node, UMLVisualIDRegistry.getType(DurationIntervalFloatingLabelEditPart.VISUAL_ID));
		label6117.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6117 = (Location)label6117.getLayoutConstraint();
		location6117.setX(0);
		location6117.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterval_2107(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interval");
		Node label5190 = createLabel(node, UMLVisualIDRegistry.getType(IntervalNameEditPart.VISUAL_ID));
		Node label6118 = createLabel(node, UMLVisualIDRegistry.getType(IntervalFloatingLabelEditPart.VISUAL_ID));
		label6118.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6118 = (Location)label6118.getLayoutConstraint();
		location6118.setX(0);
		location6118.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInstanceValue_2108(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InstanceValueEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InstanceValue");
		Node label5191 = createLabel(node, UMLVisualIDRegistry.getType(InstanceValueNameEditPart.VISUAL_ID));
		Node label6119 = createLabel(node, UMLVisualIDRegistry.getType(InstanceValueFloatingLabelEditPart.VISUAL_ID));
		label6119.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6119 = (Location)label6119.getLayoutConstraint();
		location6119.setX(0);
		location6119.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_2109(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		Node label5192 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_2110(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationConstraint");
		Node label5193 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintNameEditPart.VISUAL_ID));
		Node label6035 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_2111(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeConstraint");
		Node label5194 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintNameEditPart.VISUAL_ID));
		Node label6036 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_2112(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "IntervalConstraint");
		Node label5195 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintNameEditPart.VISUAL_ID));
		Node label6037 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionConstraint_2113(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InteractionConstraint");
		Node label5196 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintNameEditPart.VISUAL_ID));
		Node label6038 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_2114(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		stampShortcut(containerView, node);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		Node label5197 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPart.VISUAL_ID));
		Node label6039 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPart.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_3121(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(BehaviorPortEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		Node label6053 = createLabel(node, UMLVisualIDRegistry.getType(BehaviorPortFloatingLabelEditPart.VISUAL_ID));
		label6053.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6053 = (Location)label6053.getLayoutConstraint();
		location6053.setX(0);
		location6053.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPort_3069(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PortEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Port");
		Node label5125 = createLabel(node, UMLVisualIDRegistry.getType(PortNameEditPart.VISUAL_ID));
		label5125.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location5125 = (Location)label5125.getLayoutConstraint();
		location5125.setX(25);
		location5125.setY(3);
		Node label6029 = createLabel(node, UMLVisualIDRegistry.getType(PortAppliedStereotypeEditPart.VISUAL_ID));
		label6029.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6029 = (Location)label6029.getLayoutConstraint();
		location6029.setX(25);
		location6029.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createParameter_3088(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ParameterEditPart.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Parameter");
		Node label6033 = createLabel(node, UMLVisualIDRegistry.getType(ParameterNameEditPart.VISUAL_ID));
		label6033.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6033 = (Location)label6033.getLayoutConstraint();
		location6033.setX(25);
		location6033.setY(3);
		Node label6034 = createLabel(node, UMLVisualIDRegistry.getType(ParameterAppliedStereotypeEditPart.VISUAL_ID));
		label6034.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6034 = (Location)label6034.getLayoutConstraint();
		location6034.setX(25);
		location6034.setY(-10);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3070(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PropertyPartEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		Node label5126 = createLabel(node, UMLVisualIDRegistry.getType(PropertyPartNameEditPartCN.VISUAL_ID));
		Node label6054 = createLabel(node, UMLVisualIDRegistry.getType(PropertyPartFloatingLabelEditPartCN.VISUAL_ID));
		label6054.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6054 = (Location)label6054.getLayoutConstraint();
		location6054.setX(0);
		location6054.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(PropertyPartCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConnectableElement_3115(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CollaborationRoleEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CollaborationRole");
		Node label5198 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationRoleNameEditPartCN.VISUAL_ID));
		Node label6055 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationRoleFloatingLabelEditPartCN.VISUAL_ID));
		label6055.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6055 = (Location)label6055.getLayoutConstraint();
		location6055.setX(0);
		location6055.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCollaborationUse_3071(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CollaborationUseEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "CollaborationUse");
		Node label5127 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationUseNameEditPart.VISUAL_ID));
		Node label6056 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationUseFloatingLabelEditPartCN.VISUAL_ID));
		label6056.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6056 = (Location)label6056.getLayoutConstraint();
		location6056.setX(0);
		location6056.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActivity_3072(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActivityCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Activity");
		Node label5128 = createLabel(node, UMLVisualIDRegistry.getType(ActivityCompositeNameEditPartCN.VISUAL_ID));
		Node label6057 = createLabel(node, UMLVisualIDRegistry.getType(ActivityCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6057.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6057 = (Location)label6057.getLayoutConstraint();
		location6057.setX(0);
		location6057.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ActivityCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Activity");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteraction_3073(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interaction");
		Node label5129 = createLabel(node, UMLVisualIDRegistry.getType(InteractionCompositeNameEditPartCN.VISUAL_ID));
		Node label6058 = createLabel(node, UMLVisualIDRegistry.getType(InteractionCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6058.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6058 = (Location)label6058.getLayoutConstraint();
		location6058.setX(0);
		location6058.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(InteractionCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Interaction");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProtocolStateMachine_3074(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ProtocolStateMachine");
		Node label5130 = createLabel(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeNameEditPartCN.VISUAL_ID));
		Node label6059 = createLabel(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6059.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6059 = (Location)label6059.getLayoutConstraint();
		location6059.setX(0);
		location6059.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ProtocolStateMachine");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createStateMachine_3075(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(StateMachineCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "StateMachine");
		Node label5131 = createLabel(node, UMLVisualIDRegistry.getType(StateMachineCompositeNameEditPartCN.VISUAL_ID));
		Node label6060 = createLabel(node, UMLVisualIDRegistry.getType(StateMachineCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6060.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6060 = (Location)label6060.getLayoutConstraint();
		location6060.setX(0);
		location6060.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(StateMachineCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "StateMachine");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createFunctionBehavior_3076(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(FunctionBehaviorCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "FunctionBehavior");
		Node label5132 = createLabel(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeNameEditPartCN.VISUAL_ID));
		Node label6061 = createLabel(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6061.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6061 = (Location)label6061.getLayoutConstraint();
		location6061.setX(0);
		location6061.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "FunctionBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOpaqueBehavior_3077(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "OpaqueBehavior");
		Node label5133 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeNameEditPartCN.VISUAL_ID));
		Node label6062 = createLabel(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6062.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6062 = (Location)label6062.getLayoutConstraint();
		location6062.setX(0);
		location6062.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "OpaqueBehavior");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComponent_3081(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ComponentCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Component");
		Node label5137 = createLabel(node, UMLVisualIDRegistry.getType(ComponentCompositeNameEditPartCN.VISUAL_ID));
		Node label6063 = createLabel(node, UMLVisualIDRegistry.getType(ComponentCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6063.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6063 = (Location)label6063.getLayoutConstraint();
		location6063.setX(0);
		location6063.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ComponentCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Component");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDevice_3082(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeviceCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Device");
		Node label5138 = createLabel(node, UMLVisualIDRegistry.getType(DeviceCompositeNameEditPartCN.VISUAL_ID));
		Node label6064 = createLabel(node, UMLVisualIDRegistry.getType(DeviceCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6064.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6064 = (Location)label6064.getLayoutConstraint();
		location6064.setX(0);
		location6064.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(DeviceCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Device");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createExecutionEnvironment_3083(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "ExecutionEnvironment");
		Node label5139 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeNameEditPartCN.VISUAL_ID));
		Node label6065 = createLabel(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6065.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6065 = (Location)label6065.getLayoutConstraint();
		location6065.setX(0);
		location6065.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "ExecutionEnvironment");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createNode_3084(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(NodeCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Node");
		Node label5140 = createLabel(node, UMLVisualIDRegistry.getType(NodeCompositeNameEditPartCN.VISUAL_ID));
		Node label6066 = createLabel(node, UMLVisualIDRegistry.getType(NodeCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6066.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6066 = (Location)label6066.getLayoutConstraint();
		location6066.setX(0);
		location6066.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(NodeCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Node");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createClass_3085(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ClassCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Class");
		Node label5155 = createLabel(node, UMLVisualIDRegistry.getType(ClassCompositeNameEditPartCN.VISUAL_ID));
		Node label6067 = createLabel(node, UMLVisualIDRegistry.getType(ClassCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6067.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6067 = (Location)label6067.getLayoutConstraint();
		location6067.setX(0);
		location6067.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(ClassCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Class");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createCollaboration_3086(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CollaborationCompositeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Collaboration");
		Node label5141 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationCompositeNameEditPartCN.VISUAL_ID));
		Node label6068 = createLabel(node, UMLVisualIDRegistry.getType(CollaborationCompositeFloatingLabelEditPartCN.VISUAL_ID));
		label6068.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6068 = (Location)label6068.getLayoutConstraint();
		location6068.setX(0);
		location6068.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(CollaborationCompositeCompartmentEditPartCN.VISUAL_ID), true, true, false, false);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Collaboration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInterface_3087(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InterfaceEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Interface");
		Node label5154 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceNameEditPartCN.VISUAL_ID));
		Node label6069 = createLabel(node, UMLVisualIDRegistry.getType(InterfaceFloatingLabelEditPartCN.VISUAL_ID));
		label6069.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6069 = (Location)label6069.getLayoutConstraint();
		location6069.setX(0);
		location6069.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createPrimitiveType_3078(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(PrimitiveTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "PrimitiveType");
		Node label5134 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeNameEditPartCN.VISUAL_ID));
		Node label6070 = createLabel(node, UMLVisualIDRegistry.getType(PrimitiveTypeFloatingLabelEditPartCN.VISUAL_ID));
		label6070.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6070 = (Location)label6070.getLayoutConstraint();
		location6070.setX(0);
		location6070.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumeration_3079(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(EnumerationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Enumeration");
		Node label5135 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationNameEditPartCN.VISUAL_ID));
		Node label6071 = createLabel(node, UMLVisualIDRegistry.getType(EnumerationFloatingLabelEditPartCN.VISUAL_ID));
		label6071.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6071 = (Location)label6071.getLayoutConstraint();
		location6071.setX(0);
		location6071.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "Enumeration");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDataType_3080(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DataTypeEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DataType");
		Node label5136 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeNameEditPartCN.VISUAL_ID));
		Node label6072 = createLabel(node, UMLVisualIDRegistry.getType(DataTypeFloatingLabelEditPartCN.VISUAL_ID));
		label6072.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6072 = (Location)label6072.getLayoutConstraint();
		location6072.setX(0);
		location6072.setY(5);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeAttributeCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		createCompartment(node, UMLVisualIDRegistry.getType(DataTypeOperationCompartmentEditPartCN.VISUAL_ID), true, true, true, true);
		PreferenceInitializerForElementHelper.initCompartmentsStatusFromPrefs(node, prefStore, "DataType");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createActor_3091(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ActorEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Actor");
		Node label5144 = createLabel(node, UMLVisualIDRegistry.getType(ActorNameEditPartCN.VISUAL_ID));
		Node label6073 = createLabel(node, UMLVisualIDRegistry.getType(ActorFloatingLabelEditPartCN.VISUAL_ID));
		label6073.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6073 = (Location)label6073.getLayoutConstraint();
		location6073.setX(0);
		location6073.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDeploymentSpecification_3092(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DeploymentSpecificationEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DeploymentSpecification");
		Node label5145 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationNameEditPartCN.VISUAL_ID));
		Node label6074 = createLabel(node, UMLVisualIDRegistry.getType(DeploymentSpecificationFloatingLabelEditPartCN.VISUAL_ID));
		label6074.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6074 = (Location)label6074.getLayoutConstraint();
		location6074.setX(0);
		location6074.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createArtifact_3093(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ArtifactEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Artifact");
		Node label5146 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactNameEditPartCN.VISUAL_ID));
		Node label6075 = createLabel(node, UMLVisualIDRegistry.getType(ArtifactFloatingLabelEditPartCN.VISUAL_ID));
		label6075.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6075 = (Location)label6075.getLayoutConstraint();
		location6075.setX(0);
		location6075.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInformationItem_3094(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InformationItemEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InformationItem");
		Node label5147 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemNameEditPartCN.VISUAL_ID));
		Node label6076 = createLabel(node, UMLVisualIDRegistry.getType(InformationItemFloatingLabelEditPartCN.VISUAL_ID));
		label6076.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6076 = (Location)label6076.getLayoutConstraint();
		location6076.setX(0);
		location6076.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createSignal_3095(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(SignalEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Signal");
		Node label5148 = createLabel(node, UMLVisualIDRegistry.getType(SignalNameEditPartCN.VISUAL_ID));
		Node label6077 = createLabel(node, UMLVisualIDRegistry.getType(SignalFloatingLabelEditPartCN.VISUAL_ID));
		label6077.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6077 = (Location)label6077.getLayoutConstraint();
		location6077.setX(0);
		location6077.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createUseCase_3096(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(UseCaseEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "UseCase");
		Node label5149 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseNameEditPartCN.VISUAL_ID));
		Node label6078 = createLabel(node, UMLVisualIDRegistry.getType(UseCaseFloatingLabelEditPartCN.VISUAL_ID));
		label6078.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6078 = (Location)label6078.getLayoutConstraint();
		location6078.setX(0);
		location6078.setY(5);
		return node;
	}

	/**
	 * @generated
	 */
	public Node createComment_3097(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(CommentEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Comment");
		Node label5150 = createLabel(node, UMLVisualIDRegistry.getType(CommentBodyEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createDurationConstraint_3116(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(DurationConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "DurationConstraint");
		Node label6040 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintNameEditPartCN.VISUAL_ID));
		Node label6041 = createLabel(node, UMLVisualIDRegistry.getType(DurationConstraintSpecificationEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createTimeConstraint_3117(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(TimeConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "TimeConstraint");
		Node label6042 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintNameEditPartCN.VISUAL_ID));
		Node label6043 = createLabel(node, UMLVisualIDRegistry.getType(TimeConstraintSpecificationEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createIntervalConstraint_3118(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(IntervalConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "IntervalConstraint");
		Node label6044 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintNameEditPartCN.VISUAL_ID));
		Node label6045 = createLabel(node, UMLVisualIDRegistry.getType(IntervalConstraintSpecificationEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createInteractionConstraint_3119(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(InteractionConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "InteractionConstraint");
		Node label6046 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintNameEditPartCN.VISUAL_ID));
		Node label6047 = createLabel(node, UMLVisualIDRegistry.getType(InteractionConstraintSpecificationEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createConstraint_3120(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Shape node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		node.setType(UMLVisualIDRegistry.getType(ConstraintEditPartCN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		// initializeFromPreferences 
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Constraint");
		Node label6048 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintNameEditPartCN.VISUAL_ID));
		Node label6049 = createLabel(node, UMLVisualIDRegistry.getType(ConstraintSpecificationEditPartCN.VISUAL_ID));
		return node;
	}

	/**
	 * @generated
	 */
	public Node createProperty_3101(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(PropertyEditPartCLN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Property");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createOperation_3102(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(OperationEditPartCLN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "Operation");
		return node;
	}

	/**
	 * @generated
	 */
	public Node createEnumerationLiteral_3066(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Node node = NotationFactory.eINSTANCE.createShape();
		node.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		node.setType(UMLVisualIDRegistry.getType(EnumerationLiteralEditPartCLN.VISUAL_ID));
		ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(node, prefStore, "EnumerationLiteral");
		return node;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4022(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(BehaviorPortLinkEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createLink_4001(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(LinkDescriptorEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createCommentAnnotatedElement_4002(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(CommentAnnotatedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "CommentAnnotatedElement");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConstraintConstrainedElement_4003(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConstraintConstrainedElementEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ConstraintConstrainedElement");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createComponentRealization_4004(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ComponentRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "ComponentRealization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6001 = createLabel(edge, UMLVisualIDRegistry.getType(ComponentRealizationNameEditPart.VISUAL_ID));
		label6001.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6001 = (Location)label6001.getLayoutConstraint();
		location6001.setX(0);
		location6001.setY(60);
		Node label6015 = createLabel(edge, UMLVisualIDRegistry.getType(ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID));
		label6015.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6015 = (Location)label6015.getLayoutConstraint();
		location6015.setX(0);
		location6015.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInterfaceRealization_4005(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InterfaceRealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InterfaceRealization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6002 = createLabel(edge, UMLVisualIDRegistry.getType(InterfaceRealizationNameEditPart.VISUAL_ID));
		label6002.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6002 = (Location)label6002.getLayoutConstraint();
		location6002.setX(0);
		location6002.setY(60);
		Node label6016 = createLabel(edge, UMLVisualIDRegistry.getType(InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID));
		label6016.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6016 = (Location)label6016.getLayoutConstraint();
		location6016.setX(0);
		location6016.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createSubstitution_4011(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(SubstitutionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Substitution");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6003 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionNameEditPart.VISUAL_ID));
		label6003.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6003 = (Location)label6003.getLayoutConstraint();
		location6003.setX(0);
		location6003.setY(60);
		Node label6017 = createLabel(edge, UMLVisualIDRegistry.getType(SubstitutionAppliedStereotypeEditPart.VISUAL_ID));
		label6017.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6017 = (Location)label6017.getLayoutConstraint();
		location6017.setX(0);
		location6017.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createRealization_4006(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RealizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Realization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6004 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationNameEditPart.VISUAL_ID));
		label6004.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6004 = (Location)label6004.getLayoutConstraint();
		location6004.setX(0);
		location6004.setY(60);
		Node label6018 = createLabel(edge, UMLVisualIDRegistry.getType(RealizationAppliedStereotypeEditPart.VISUAL_ID));
		label6018.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6018 = (Location)label6018.getLayoutConstraint();
		location6018.setX(0);
		location6018.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createManifestation_4012(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ManifestationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Manifestation");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6005 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationNameEditPart.VISUAL_ID));
		label6005.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6005 = (Location)label6005.getLayoutConstraint();
		location6005.setX(0);
		location6005.setY(60);
		Node label6019 = createLabel(edge, UMLVisualIDRegistry.getType(ManifestationAppliedStereotypeEditPart.VISUAL_ID));
		label6019.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6019 = (Location)label6019.getLayoutConstraint();
		location6019.setX(0);
		location6019.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createAbstraction_4007(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(AbstractionEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Abstraction");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6006 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionNameEditPart.VISUAL_ID));
		label6006.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6006 = (Location)label6006.getLayoutConstraint();
		location6006.setX(0);
		location6006.setY(60);
		Node label6020 = createLabel(edge, UMLVisualIDRegistry.getType(AbstractionAppliedStereotypeEditPart.VISUAL_ID));
		label6020.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6020 = (Location)label6020.getLayoutConstraint();
		location6020.setX(0);
		location6020.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createUsage_4008(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(UsageEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Usage");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6007 = createLabel(edge, UMLVisualIDRegistry.getType(UsageNameEditPart.VISUAL_ID));
		label6007.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6007 = (Location)label6007.getLayoutConstraint();
		location6007.setX(0);
		location6007.setY(60);
		Node label6021 = createLabel(edge, UMLVisualIDRegistry.getType(UsageAppliedStereotypeEditPart.VISUAL_ID));
		label6021.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6021 = (Location)label6021.getLayoutConstraint();
		location6021.setX(0);
		location6021.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDeployment_4009(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DeploymentEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Deployment");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6008 = createLabel(edge, UMLVisualIDRegistry.getType(DeploymentNameEditPart.VISUAL_ID));
		label6008.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6008 = (Location)label6008.getLayoutConstraint();
		location6008.setX(0);
		location6008.setY(60);
		Node label6022 = createLabel(edge, UMLVisualIDRegistry.getType(DeploymentAppliedStereotypeEditPart.VISUAL_ID));
		label6022.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6022 = (Location)label6022.getLayoutConstraint();
		location6022.setX(0);
		location6022.setY(30);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4017(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RoleBindingEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "RoleBinding");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6027 = createLabel(edge, UMLVisualIDRegistry.getType(RoleBindingRoleNameEditPart.VISUAL_ID));
		label6027.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6027 = (Location)label6027.getLayoutConstraint();
		location6027.setX(0);
		location6027.setY(20);
		Node label6028 = createLabel(edge, UMLVisualIDRegistry.getType(RoleBindingAppliedStereotypeEditPart.VISUAL_ID));
		label6028.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6028 = (Location)label6028.getLayoutConstraint();
		location6028.setX(0);
		location6028.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDependency_4010(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DependencyEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Dependency");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6009 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyNameEditPart.VISUAL_ID));
		label6009.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6009 = (Location)label6009.getLayoutConstraint();
		location6009.setX(0);
		location6009.setY(60);
		Node label6023 = createLabel(edge, UMLVisualIDRegistry.getType(DependencyAppliedStereotypeEditPart.VISUAL_ID));
		label6023.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6023 = (Location)label6023.getLayoutConstraint();
		location6023.setX(0);
		location6023.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createConnector_4013(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(ConnectorEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Connector");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6025 = createLabel(edge, UMLVisualIDRegistry.getType(ConnectorAppliedStereotypeEditPart.VISUAL_ID));
		label6025.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6025 = (Location)label6025.getLayoutConstraint();
		location6025.setX(0);
		location6025.setY(60);
		Node label6050 = createLabel(edge, UMLVisualIDRegistry.getType(ConnectorNameEditPart.VISUAL_ID));
		label6050.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6050 = (Location)label6050.getLayoutConstraint();
		location6050.setX(0);
		location6050.setY(-20);
		Node label6051 = createLabel(edge, UMLVisualIDRegistry.getType(ConnectorMultiplicitySourceEditPart.VISUAL_ID));
		label6051.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6051 = (Location)label6051.getLayoutConstraint();
		location6051.setX(0);
		location6051.setY(20);
		Node label6052 = createLabel(edge, UMLVisualIDRegistry.getType(ConnectorMultiplicityTargetEditPart.VISUAL_ID));
		label6052.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6052 = (Location)label6052.getLayoutConstraint();
		location6052.setX(0);
		location6052.setY(20);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createGeneralization_4015(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(GeneralizationEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "Generalization");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6024 = createLabel(edge, UMLVisualIDRegistry.getType(GeneralizationAppliedStereotypeEditPart.VISUAL_ID));
		label6024.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6024 = (Location)label6024.getLayoutConstraint();
		location6024.setX(0);
		location6024.setY(60);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createTimeObservationEvent_4018(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(TimeObservationEventEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "TimeObservationEvent");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createDurationObservationEvent_4019(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(DurationObservationEventEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "DurationObservationEvent");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInformationItemRepresented_4020(View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(RepresentationEditPart.VISUAL_ID));
		edge.setElement(null);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		ViewUtil.setStructuralFeatureValue(edge, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.colorToInteger(ColorConstants.black));
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6030 = createLabel(edge, UMLVisualIDRegistry.getType(RepresentationTagLabelEditPart.VISUAL_ID));
		label6030.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6030 = (Location)label6030.getLayoutConstraint();
		location6030.setX(0);
		location6030.setY(15);
		return edge;
	}

	/**
	 * @generated
	 */
	public Edge createInformationFlow_4021(EObject domainElement, View containerView, int index, boolean persisted, PreferencesHint preferencesHint) {
		Connector edge = NotationFactory.eINSTANCE.createConnector();
		edge.getStyles().add(NotationFactory.eINSTANCE.createFontStyle());
		RelativeBendpoints bendpoints = NotationFactory.eINSTANCE.createRelativeBendpoints();
		List<RelativeBendpoint> points = new ArrayList<RelativeBendpoint>(2);
		points.add(new RelativeBendpoint());
		points.add(new RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(UMLVisualIDRegistry.getType(InformationFlowEditPart.VISUAL_ID));
		edge.setElement(domainElement);
		// initializePreferences
		final IPreferenceStore prefStore = (IPreferenceStore)preferencesHint.getPreferenceStore();
		PreferenceInitializerForElementHelper.initFontStyleFromPrefs(edge, prefStore, "InformationFlow");
		//org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		//if (routing != null) {
		//	org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		//}
		Node label6031 = createLabel(edge, UMLVisualIDRegistry.getType(InformationFlowConveyedLabelEditPart.VISUAL_ID));
		label6031.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6031 = (Location)label6031.getLayoutConstraint();
		location6031.setX(0);
		location6031.setY(30);
		Node label6032 = createLabel(edge, UMLVisualIDRegistry.getType(InformationFlowAppliedStereotypeEditPart.VISUAL_ID));
		label6032.setLayoutConstraint(NotationFactory.eINSTANCE.createLocation());
		Location location6032 = (Location)label6032.getLayoutConstraint();
		location6032.setX(0);
		location6032.setY(15);
		return edge;
	}

	/**
	 * @generated
	 */
	protected void stampShortcut(View containerView, Node target) {
		if(!CompositeStructureDiagramEditPart.MODEL_ID.equals(UMLVisualIDRegistry.getModelID(containerView))) {
			EAnnotation shortcutAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			shortcutAnnotation.setSource("Shortcut"); //$NON-NLS-1$
			shortcutAnnotation.getDetails().put("modelID", CompositeStructureDiagramEditPart.MODEL_ID); //$NON-NLS-1$
			target.getEAnnotations().add(shortcutAnnotation);
		}
	}

	/**
	 * @generated
	 */
	protected Node createLabel(View owner, String hint) {
		DecorationNode rv = NotationFactory.eINSTANCE.createDecorationNode();
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	protected Node createCompartment(View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
		//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
		//rv.setShowTitle(showTitle);
		//rv.setCollapsed(isCollapsed);
		Node rv;
		if(canCollapse) {
			rv = NotationFactory.eINSTANCE.createBasicCompartment();
		} else {
			rv = NotationFactory.eINSTANCE.createDecorationNode();
		}
		rv.setLayoutConstraint(NotationFactory.eINSTANCE.createBounds());
		if(hasTitle) {
			TitleStyle ts = NotationFactory.eINSTANCE.createTitleStyle();
			rv.getStyles().add(ts);
		}
		if(canSort) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createSortingStyle());
		}
		if(canFilter) {
			rv.getStyles().add(NotationFactory.eINSTANCE.createFilteringStyle());
		}
		rv.setType(hint);
		ViewUtil.insertChildView(owner, rv, ViewUtil.APPEND, true);
		return rv;
	}

	/**
	 * @generated
	 */
	protected EObject getSemanticElement(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		EObject eObject = (EObject)semanticAdapter.getAdapter(EObject.class);
		if(eObject != null) {
			return EMFCoreUtil.resolve(TransactionUtil.getEditingDomain(eObject), eObject);
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if(semanticAdapter == null) {
			return null;
		}
		return (IElementType)semanticAdapter.getAdapter(IElementType.class);
	}

	/**
	 * @generated
	 */
	private void initFontStyleFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fontConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.FONT);
		String fontColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FONT);
		FontStyle viewFontStyle = (FontStyle)view.getStyle(NotationPackage.Literals.FONT_STYLE);
		if(viewFontStyle != null) {
			FontData fontData = PreferenceConverter.getFontData(store, fontConstant);
			viewFontStyle.setFontName(fontData.getName());
			viewFontStyle.setFontHeight(fontData.getHeight());
			viewFontStyle.setBold((fontData.getStyle() & SWT.BOLD) != 0);
			viewFontStyle.setItalic((fontData.getStyle() & SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = PreferenceConverter.getColor(store, fontColorConstant);
			viewFontStyle.setFontColor(FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	}

	/**
	 * @generated
	 */
	private void initForegroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String lineColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_LINE);
		org.eclipse.swt.graphics.RGB lineRGB = PreferenceConverter.getColor(store, lineColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getLineStyle_LineColor(), FigureUtilities.RGBToInteger(lineRGB));
	}

	/**
	 * @generated
	 */
	private void initBackgroundFromPrefs(View view, final IPreferenceStore store, String elementName) {
		String fillColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_FILL);
		String gradientColorConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.COLOR_GRADIENT);
		String gradientPolicyConstant = PreferencesConstantsHelper.getElementConstant(elementName, PreferencesConstantsHelper.GRADIENT_POLICY);
		org.eclipse.swt.graphics.RGB fillRGB = PreferenceConverter.getColor(store, fillColorConstant);
		ViewUtil.setStructuralFeatureValue(view, NotationPackage.eINSTANCE.getFillStyle_FillColor(), FigureUtilities.RGBToInteger(fillRGB));
		FillStyle fillStyle = (FillStyle)view.getStyle(NotationPackage.Literals.FILL_STYLE);
		fillStyle.setFillColor(FigureUtilities.RGBToInteger(fillRGB).intValue());;
		if(store.getBoolean(gradientPolicyConstant)) {
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(store.getString(gradientColorConstant));
			fillStyle.setGradient(gradientPreferenceConverter.getGradientData());
			fillStyle.setTransparency(gradientPreferenceConverter.getTransparency());
		}
	}
}