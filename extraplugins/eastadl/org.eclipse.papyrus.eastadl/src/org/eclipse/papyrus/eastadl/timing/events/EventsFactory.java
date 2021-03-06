/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.timing.events;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.eastadl.timing.events.EventsPackage
 * @generated
 */
public interface EventsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	EventsFactory eINSTANCE = org.eclipse.papyrus.eastadl.timing.events.impl.EventsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Event Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Event Function</em>'.
	 * @generated
	 */
	EventFunction createEventFunction();

	/**
	 * Returns a new object of class '<em>AUTOSAR Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>AUTOSAR Event</em>'.
	 * @generated
	 */
	AUTOSAREvent createAUTOSAREvent();

	/**
	 * Returns a new object of class '<em>Event Fault Failure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Event Fault Failure</em>'.
	 * @generated
	 */
	EventFaultFailure createEventFaultFailure();

	/**
	 * Returns a new object of class '<em>Event Feature Flaw</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Event Feature Flaw</em>'.
	 * @generated
	 */
	EventFeatureFlaw createEventFeatureFlaw();

	/**
	 * Returns a new object of class '<em>External Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>External Event</em>'.
	 * @generated
	 */
	ExternalEvent createExternalEvent();

	/**
	 * Returns a new object of class '<em>Mode Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Mode Event</em>'.
	 * @generated
	 */
	ModeEvent createModeEvent();

	/**
	 * Returns a new object of class '<em>Event Function Client Server Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Event Function Client Server Port</em>'.
	 * @generated
	 */
	EventFunctionClientServerPort createEventFunctionClientServerPort();

	/**
	 * Returns a new object of class '<em>Event Function Flow Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Event Function Flow Port</em>'.
	 * @generated
	 */
	EventFunctionFlowPort createEventFunctionFlowPort();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @return the package supported by this factory.
	 * @generated
	 */
	EventsPackage getEventsPackage();

} // EventsFactory
