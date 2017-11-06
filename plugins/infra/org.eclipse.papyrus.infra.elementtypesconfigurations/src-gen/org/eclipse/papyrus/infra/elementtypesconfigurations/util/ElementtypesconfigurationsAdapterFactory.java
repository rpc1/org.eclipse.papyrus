/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.elementtypesconfigurations.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.elementtypesconfigurations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage
 * @generated
 */
public class ElementtypesconfigurationsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ElementtypesconfigurationsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementtypesconfigurationsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ElementtypesconfigurationsPackage.eINSTANCE;
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
	protected ElementtypesconfigurationsSwitch<Adapter> modelSwitch =
		new ElementtypesconfigurationsSwitch<Adapter>() {
			@Override
			public Adapter caseElementTypeSetConfiguration(ElementTypeSetConfiguration object) {
				return createElementTypeSetConfigurationAdapter();
			}
			@Override
			public Adapter caseElementTypeConfiguration(ElementTypeConfiguration object) {
				return createElementTypeConfigurationAdapter();
			}
			@Override
			public Adapter caseIconEntry(IconEntry object) {
				return createIconEntryAdapter();
			}
			@Override
			public Adapter caseConfigurationElement(ConfigurationElement object) {
				return createConfigurationElementAdapter();
			}
			@Override
			public Adapter caseMatcherConfiguration(MatcherConfiguration object) {
				return createMatcherConfigurationAdapter();
			}
			@Override
			public Adapter caseAdviceConfiguration(AdviceConfiguration object) {
				return createAdviceConfigurationAdapter();
			}
			@Override
			public Adapter caseAdviceBindingConfiguration(AdviceBindingConfiguration object) {
				return createAdviceBindingConfigurationAdapter();
			}
			@Override
			public Adapter caseSpecializationTypeConfiguration(SpecializationTypeConfiguration object) {
				return createSpecializationTypeConfigurationAdapter();
			}
			@Override
			public Adapter caseContainerConfiguration(ContainerConfiguration object) {
				return createContainerConfigurationAdapter();
			}
			@Override
			public Adapter caseMetamodelTypeConfiguration(MetamodelTypeConfiguration object) {
				return createMetamodelTypeConfigurationAdapter();
			}
			@Override
			public Adapter caseEditHelperAdviceConfiguration(EditHelperAdviceConfiguration object) {
				return createEditHelperAdviceConfigurationAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration <em>Element Type Set Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeSetConfiguration
	 * @generated
	 */
	public Adapter createElementTypeSetConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration <em>Element Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementTypeConfiguration
	 * @generated
	 */
	public Adapter createElementTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry <em>Icon Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.IconEntry
	 * @generated
	 */
	public Adapter createIconEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement <em>Configuration Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement
	 * @generated
	 */
	public Adapter createConfigurationElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration <em>Matcher Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration
	 * @generated
	 */
	public Adapter createMatcherConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration <em>Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration
	 * @generated
	 */
	public Adapter createAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration <em>Advice Binding Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration
	 * @generated
	 */
	public Adapter createAdviceBindingConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration <em>Specialization Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration
	 * @generated
	 */
	public Adapter createSpecializationTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration <em>Container Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ContainerConfiguration
	 * @generated
	 */
	public Adapter createContainerConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration <em>Metamodel Type Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.MetamodelTypeConfiguration
	 * @generated
	 */
	public Adapter createMetamodelTypeConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration <em>Edit Helper Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.EditHelperAdviceConfiguration
	 * @generated
	 */
	public Adapter createEditHelperAdviceConfigurationAdapter() {
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

} //ElementtypesconfigurationsAdapterFactory
