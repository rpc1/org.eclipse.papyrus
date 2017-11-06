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
package org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceBindingConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.AdviceConfiguration;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ConfigurationElement;

import org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfigurationPackage
 * @generated
 */
public class ApplyStereotypeAdviceConfigurationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ApplyStereotypeAdviceConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeAdviceConfigurationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ApplyStereotypeAdviceConfigurationPackage.eINSTANCE;
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
	protected ApplyStereotypeAdviceConfigurationSwitch<Adapter> modelSwitch =
		new ApplyStereotypeAdviceConfigurationSwitch<Adapter>() {
			@Override
			public Adapter caseApplyStereotypeAdviceConfiguration(ApplyStereotypeAdviceConfiguration object) {
				return createApplyStereotypeAdviceConfigurationAdapter();
			}
			@Override
			public Adapter caseStereotypeToApply(StereotypeToApply object) {
				return createStereotypeToApplyAdapter();
			}
			@Override
			public Adapter caseFeatureToSet(FeatureToSet object) {
				return createFeatureToSetAdapter();
			}
			@Override
			public Adapter caseFeatureValue(FeatureValue object) {
				return createFeatureValueAdapter();
			}
			@Override
			public Adapter caseListValue(ListValue object) {
				return createListValueAdapter();
			}
			@Override
			public Adapter caseConstantValue(ConstantValue object) {
				return createConstantValueAdapter();
			}
			@Override
			public Adapter caseDynamicValue(DynamicValue object) {
				return createDynamicValueAdapter();
			}
			@Override
			public Adapter caseQueryExecutionValue(QueryExecutionValue object) {
				return createQueryExecutionValueAdapter();
			}
			@Override
			public Adapter caseConfigurationElement(ConfigurationElement object) {
				return createConfigurationElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration <em>Apply Stereotype Advice Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ApplyStereotypeAdviceConfiguration
	 * @generated
	 */
	public Adapter createApplyStereotypeAdviceConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.StereotypeToApply <em>Stereotype To Apply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.StereotypeToApply
	 * @generated
	 */
	public Adapter createStereotypeToApplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.FeatureToSet <em>Feature To Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.FeatureToSet
	 * @generated
	 */
	public Adapter createFeatureToSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.FeatureValue <em>Feature Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.FeatureValue
	 * @generated
	 */
	public Adapter createFeatureValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ListValue <em>List Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ListValue
	 * @generated
	 */
	public Adapter createListValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ConstantValue <em>Constant Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.ConstantValue
	 * @generated
	 */
	public Adapter createConstantValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.DynamicValue <em>Dynamic Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.DynamicValue
	 * @generated
	 */
	public Adapter createDynamicValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.QueryExecutionValue <em>Query Execution Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.uml.tools.elementtypesconfigurations.applystereotypeadviceconfiguration.QueryExecutionValue
	 * @generated
	 */
	public Adapter createQueryExecutionValueAdapter() {
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

} //ApplyStereotypeAdviceConfigurationAdapterFactory
