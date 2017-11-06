/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.sysml14.allocations;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.ActivityPartition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocate Activity Partition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AllocateActivityPartition is used to depict an Ğallocateğ relationship on an Activity diagram. The AllocateActivityPartition is a standard UML2::ActivityPartition, with modified constraints as stated in the paragraph below.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.sysml14.allocations.AllocateActivityPartition#getBase_ActivityPartition <em>Base Activity Partition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.sysml14.allocations.AllocationsPackage#getAllocateActivityPartition()
 * @model
 * @generated
 */
public interface AllocateActivityPartition extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Partition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Activity Partition</em>' reference.
	 * @see #setBase_ActivityPartition(ActivityPartition)
	 * @see org.eclipse.papyrus.sysml14.allocations.AllocationsPackage#getAllocateActivityPartition_Base_ActivityPartition()
	 * @model ordered="false"
	 * @generated
	 */
	ActivityPartition getBase_ActivityPartition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml14.allocations.AllocateActivityPartition#getBase_ActivityPartition <em>Base Activity Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Activity Partition</em>' reference.
	 * @see #getBase_ActivityPartition()
	 * @generated
	 */
	void setBase_ActivityPartition(ActivityPartition value);

} // AllocateActivityPartition
