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
package org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.views.properties.contexts.View;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View To Display</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.ViewToDisplay#getView <em>View</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage#getViewToDisplay()
 * @model
 * @generated
 */
public interface ViewToDisplay extends EObject {
	/**
	 * Returns the value of the '<em><b>View</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>View</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>View</em>' reference.
	 * @see #setView(View)
	 * @see org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.RuntimevalueseditionadviceconfigurationPackage#getViewToDisplay_View()
	 * @model required="true"
	 * @generated
	 */
	View getView();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.elementtypesconfigurations.emf.runtimevalueseditionadviceconfiguration.ViewToDisplay#getView <em>View</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>View</em>' reference.
	 * @see #getView()
	 * @generated
	 */
	void setView(View value);

} // ViewToDisplay
