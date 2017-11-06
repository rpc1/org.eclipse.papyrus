/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Fadwa TMAR (CEA LIST) fadwa.tmar@cea.fr - Initial API and implementation
 *****************************************************************************/
package SoaML.util;

import SoaML.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see SoaML.SoaMLPackage
 * @generated
 */
public class SoaMLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SoaMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoaMLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SoaMLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoaMLSwitch<Adapter> modelSwitch =
		new SoaMLSwitch<Adapter>() {
			@Override
			public Adapter caseAgent(Agent object) {
				return createAgentAdapter();
			}
			@Override
			public Adapter caseParticipant(Participant object) {
				return createParticipantAdapter();
			}
			@Override
			public Adapter caseCollaboration(Collaboration object) {
				return createCollaborationAdapter();
			}
			@Override
			public Adapter caseMotivationElement(MotivationElement object) {
				return createMotivationElementAdapter();
			}
			@Override
			public Adapter caseProvider(Provider object) {
				return createProviderAdapter();
			}
			@Override
			public Adapter caseFreeFormValue(FreeFormValue object) {
				return createFreeFormValueAdapter();
			}
			@Override
			public Adapter caseMessageType(MessageType object) {
				return createMessageTypeAdapter();
			}
			@Override
			public Adapter caseCategory(Category object) {
				return createCategoryAdapter();
			}
			@Override
			public Adapter caseNodeDescriptor(NodeDescriptor object) {
				return createNodeDescriptorAdapter();
			}
			@Override
			public Adapter caseMilestone(Milestone object) {
				return createMilestoneAdapter();
			}
			@Override
			public Adapter caseFreeFormDescriptor(FreeFormDescriptor object) {
				return createFreeFormDescriptorAdapter();
			}
			@Override
			public Adapter caseCategoryValue(CategoryValue object) {
				return createCategoryValueAdapter();
			}
			@Override
			public Adapter caseServiceContract(ServiceContract object) {
				return createServiceContractAdapter();
			}
			@Override
			public Adapter caseRequest(Request object) {
				return createRequestAdapter();
			}
			@Override
			public Adapter caseConsumer(Consumer object) {
				return createConsumerAdapter();
			}
			@Override
			public Adapter caseCatalog(Catalog object) {
				return createCatalogAdapter();
			}
			@Override
			public Adapter caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			@Override
			public Adapter caseCategorization(Categorization object) {
				return createCategorizationAdapter();
			}
			@Override
			public Adapter caseMotivationRealization(MotivationRealization object) {
				return createMotivationRealizationAdapter();
			}
			@Override
			public Adapter caseServiceInterface(ServiceInterface object) {
				return createServiceInterfaceAdapter();
			}
			@Override
			public Adapter caseServicesArchitecture(ServicesArchitecture object) {
				return createServicesArchitectureAdapter();
			}
			@Override
			public Adapter caseAttachment(Attachment object) {
				return createAttachmentAdapter();
			}
			@Override
			public Adapter caseCollaborationUse(CollaborationUse object) {
				return createCollaborationUseAdapter();
			}
			@Override
			public Adapter caseServiceChannel(ServiceChannel object) {
				return createServiceChannelAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseExpose(Expose object) {
				return createExposeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Agent
	 * @generated
	 */
	public Adapter createAgentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Participant
	 * @generated
	 */
	public Adapter createParticipantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Collaboration <em>Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Collaboration
	 * @generated
	 */
	public Adapter createCollaborationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.MotivationElement <em>Motivation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.MotivationElement
	 * @generated
	 */
	public Adapter createMotivationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Provider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Provider
	 * @generated
	 */
	public Adapter createProviderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.FreeFormValue <em>Free Form Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.FreeFormValue
	 * @generated
	 */
	public Adapter createFreeFormValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.MessageType
	 * @generated
	 */
	public Adapter createMessageTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.NodeDescriptor <em>Node Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.NodeDescriptor
	 * @generated
	 */
	public Adapter createNodeDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Milestone <em>Milestone</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Milestone
	 * @generated
	 */
	public Adapter createMilestoneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.FreeFormDescriptor <em>Free Form Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.FreeFormDescriptor
	 * @generated
	 */
	public Adapter createFreeFormDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.CategoryValue <em>Category Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.CategoryValue
	 * @generated
	 */
	public Adapter createCategoryValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.ServiceContract <em>Service Contract</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.ServiceContract
	 * @generated
	 */
	public Adapter createServiceContractAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Request <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Request
	 * @generated
	 */
	public Adapter createRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Consumer <em>Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Consumer
	 * @generated
	 */
	public Adapter createConsumerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Catalog <em>Catalog</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Catalog
	 * @generated
	 */
	public Adapter createCatalogAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Categorization <em>Categorization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Categorization
	 * @generated
	 */
	public Adapter createCategorizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.MotivationRealization <em>Motivation Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.MotivationRealization
	 * @generated
	 */
	public Adapter createMotivationRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.ServiceInterface <em>Service Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.ServiceInterface
	 * @generated
	 */
	public Adapter createServiceInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.ServicesArchitecture <em>Services Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.ServicesArchitecture
	 * @generated
	 */
	public Adapter createServicesArchitectureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Attachment
	 * @generated
	 */
	public Adapter createAttachmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.CollaborationUse <em>Collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.CollaborationUse
	 * @generated
	 */
	public Adapter createCollaborationUseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.ServiceChannel <em>Service Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.ServiceChannel
	 * @generated
	 */
	public Adapter createServiceChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link SoaML.Expose <em>Expose</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see SoaML.Expose
	 * @generated
	 */
	public Adapter createExposeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SoaMLAdapterFactory
