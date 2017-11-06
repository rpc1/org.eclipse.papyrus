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

import org.eclipse.emf.common.util.EList;

import org.eclipse.papyrus.dd.dc.Point;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Polyline</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Polyline is a marked element that defines a shape consisting of a sequence of connected straight line segments.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.dd.dg.Polyline#getPoints <em>Point</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.dd.dg.DGPackage#getPolyline()
 * @model
 * @generated
 */
public interface Polyline extends MarkedElement {

	/**
	 * Returns the value of the '<em><b>Point</b></em>' containment reference
	 * list. The list contents are of type {@link org.eclipse.papyrus.dd.dc.Point}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> a list of 2 or more points
	 * making up the polyline. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Point</em>' containment reference list.
	 * @see org.eclipse.papyrus.dd.dg.DGPackage#getPolyline_Point()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoints();
} // Polyline
