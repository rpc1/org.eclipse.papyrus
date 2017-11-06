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
package org.eclipse.papyrus.infra.elementtypesconfigurations;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Matcher Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration#getMatcherClassName <em>Matcher Class Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getMatcherConfiguration()
 * @model
 * @generated
 */
public interface MatcherConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Matcher Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matcher Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Matcher Class Name</em>' attribute.
	 * @see #setMatcherClassName(String)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage#getMatcherConfiguration_MatcherClassName()
	 * @model required="true"
	 * @generated
	 */
	String getMatcherClassName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.MatcherConfiguration#getMatcherClassName <em>Matcher Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Matcher Class Name</em>' attribute.
	 * @see #getMatcherClassName()
	 * @generated
	 */
	void setMatcherClassName(String value);

} // MatcherConfiguration
