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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.elementtypesconfigurations.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage
 * @generated
 */
public class ElementtypesconfigurationsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ElementtypesconfigurationsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementtypesconfigurationsSwitch() {
		if (modelPackage == null) {
			modelPackage = ElementtypesconfigurationsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_SET_CONFIGURATION: {
				ElementTypeSetConfiguration elementTypeSetConfiguration = (ElementTypeSetConfiguration)theEObject;
				T result = caseElementTypeSetConfiguration(elementTypeSetConfiguration);
				if (result == null) result = caseConfigurationElement(elementTypeSetConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.ELEMENT_TYPE_CONFIGURATION: {
				ElementTypeConfiguration elementTypeConfiguration = (ElementTypeConfiguration)theEObject;
				T result = caseElementTypeConfiguration(elementTypeConfiguration);
				if (result == null) result = caseConfigurationElement(elementTypeConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.ICON_ENTRY: {
				IconEntry iconEntry = (IconEntry)theEObject;
				T result = caseIconEntry(iconEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.CONFIGURATION_ELEMENT: {
				ConfigurationElement configurationElement = (ConfigurationElement)theEObject;
				T result = caseConfigurationElement(configurationElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.MATCHER_CONFIGURATION: {
				MatcherConfiguration matcherConfiguration = (MatcherConfiguration)theEObject;
				T result = caseMatcherConfiguration(matcherConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.ADVICE_CONFIGURATION: {
				AdviceConfiguration adviceConfiguration = (AdviceConfiguration)theEObject;
				T result = caseAdviceConfiguration(adviceConfiguration);
				if (result == null) result = caseConfigurationElement(adviceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.ADVICE_BINDING_CONFIGURATION: {
				AdviceBindingConfiguration adviceBindingConfiguration = (AdviceBindingConfiguration)theEObject;
				T result = caseAdviceBindingConfiguration(adviceBindingConfiguration);
				if (result == null) result = caseAdviceConfiguration(adviceBindingConfiguration);
				if (result == null) result = caseConfigurationElement(adviceBindingConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION: {
				SpecializationTypeConfiguration specializationTypeConfiguration = (SpecializationTypeConfiguration)theEObject;
				T result = caseSpecializationTypeConfiguration(specializationTypeConfiguration);
				if (result == null) result = caseElementTypeConfiguration(specializationTypeConfiguration);
				if (result == null) result = caseConfigurationElement(specializationTypeConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.CONTAINER_CONFIGURATION: {
				ContainerConfiguration containerConfiguration = (ContainerConfiguration)theEObject;
				T result = caseContainerConfiguration(containerConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.METAMODEL_TYPE_CONFIGURATION: {
				MetamodelTypeConfiguration metamodelTypeConfiguration = (MetamodelTypeConfiguration)theEObject;
				T result = caseMetamodelTypeConfiguration(metamodelTypeConfiguration);
				if (result == null) result = caseElementTypeConfiguration(metamodelTypeConfiguration);
				if (result == null) result = caseConfigurationElement(metamodelTypeConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ElementtypesconfigurationsPackage.EDIT_HELPER_ADVICE_CONFIGURATION: {
				EditHelperAdviceConfiguration editHelperAdviceConfiguration = (EditHelperAdviceConfiguration)theEObject;
				T result = caseEditHelperAdviceConfiguration(editHelperAdviceConfiguration);
				if (result == null) result = caseAdviceConfiguration(editHelperAdviceConfiguration);
				if (result == null) result = caseConfigurationElement(editHelperAdviceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Set Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Set Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeSetConfiguration(ElementTypeSetConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTypeConfiguration(ElementTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icon Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIconEntry(IconEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfigurationElement(ConfigurationElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Matcher Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Matcher Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatcherConfiguration(MatcherConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdviceConfiguration(AdviceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advice Binding Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advice Binding Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdviceBindingConfiguration(AdviceBindingConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationTypeConfiguration(SpecializationTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerConfiguration(ContainerConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel Type Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel Type Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodelTypeConfiguration(MetamodelTypeConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edit Helper Advice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edit Helper Advice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditHelperAdviceConfiguration(EditHelperAdviceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ElementtypesconfigurationsSwitch
