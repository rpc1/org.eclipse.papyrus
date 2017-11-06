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
package org.eclipse.papyrus.umldi.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.umldi.DiagramCompartment;
import org.eclipse.papyrus.umldi.UMLDIFactory;
import org.eclipse.papyrus.umldi.UMLDIPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.umldi.DiagramCompartment} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramCompartmentItemProvider extends UmlCompartmentItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramCompartmentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.
		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_DiagramCompartment_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch(notification.getFeatureID(DiagramCompartment.class)) {
		case UMLDIPackage.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createConstraintShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createEnumerationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPropertyEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGeneralizationSetEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActivityNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createObjectNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createObjectFlowEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createLifelineShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInteractionFragmentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPinShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createConnectorEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInstanceSpecificationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDependencyEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInstanceSpecificationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createClassShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPortShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInterfaceShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDataTypeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPrimitiveTypeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createSignalShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createModelShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createContainmentEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGeneralizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAbstractionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createRealizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInterfaceRealizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createUsageEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createElementImportEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageImportEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPackageMergeEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createSubstitutionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInformationFlowEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationClassEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCommentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAttachmentEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationClassShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createComponentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInformationItemShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createRepresentationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createAssociationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDependencyShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTimeObservationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTimeObservationShape_TimeObservationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDurationObservationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createProfileShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createProfileApplicationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExtensionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createArtifactShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createComponentRealizationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createManifestationEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPropertyShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCollaborationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCollaborationUseShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTemplateBindingEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createStereotypeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDeviceShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExecutionEnvironmentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActivityShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActivityParameterNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInteractionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGateShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createOpaqueBehaviorShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createFunctionBehaviorShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createStateMachineShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPseudostateShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createProtocolStateMachineShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDeploymentSpecificationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCommunicationPathEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDeploymentEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActorShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createUseCaseShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createIncludeEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExtendEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createStateShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createConnectionPointReferenceShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createRegionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTransitionEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createControlFlowEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActivityGroupShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExceptionHandlerEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInteractionUseShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createActivityPartitionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createStructuredActivityNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExpansionRegionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExpansionNodeShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createMessageEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createGeneralOrderingEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createCombinedFragmentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createInteractionOperandShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createExecutionSpecificationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDurationConstraintShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTimeConstraintShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createTimeExpressionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createDurationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createPathEdge()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.DIAGRAM_COMPARTMENT__TOP_UML_DIAGRAM_ELEMENT, UMLDIFactory.eINSTANCE.createStateInvariantShape()));
	}
}
