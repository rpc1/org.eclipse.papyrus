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
package org.eclipse.papyrus.dd.dg;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.papyrus.dd.dc.Bounds;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Canvas</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Canvas is a kind of group that has bounds.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.dd.dg.Canvas#getBounds <em>Bounds</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.dd.dg.DGPackage#getCanvas()
 * @model
 * @generated
 */
public interface Canvas extends Group {

	/**
	 * Returns the value of the '<em><b>Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * the bounds of the canvas in the x-y coordinate system. <!-- end-model-doc
	 * -->
	 * 
	 * @return the value of the '<em>Bounds</em>' containment reference.
	 * @see #setBounds(Bounds)
	 * @see org.eclipse.papyrus.dd.dg.DGPackage#getCanvas_Bounds()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	Bounds getBounds();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dd.dg.Canvas#getBounds <em>Bounds</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Bounds</em>' containment reference.
	 * @see #getBounds()
	 * @generated
	 */
	void setBounds(Bounds value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * @param diagnostics
	 *        The chain of diagnostics to which problems are to be appended.
	 * @param context
	 *        The cache of context-specific information. <!-- end-model-doc
	 *        -->
	 * @model annotation=
	 *        "http://www.eclipse.org/emf/2002/Ecore/OCL body='transform->isEmpty()'"
	 * @generated
	 */
	boolean canvasCannotHaveTransforms(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Canvas
