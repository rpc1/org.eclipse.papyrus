/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GMFT_BasedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Use Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl#getDiagramType <em>Diagram Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl#getRepresentations <em>Representations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.UseContextImpl#getGmftRepresentations <em>Gmft Representations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseContextImpl extends MinimalEObjectImpl.Container implements UseContext {
	/**
	 * The default value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagramType() <em>Diagram Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramType()
	 * @generated
	 * @ordered
	 */
	protected String diagramType = DIAGRAM_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRepresentations() <em>Representations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentations()
	 * @generated
	 * @ordered
	 */
	protected EList<Representation> representations;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGmftRepresentations() <em>Gmft Representations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGmftRepresentations()
	 * @generated
	 * @ordered
	 */
	protected EList<GMFT_BasedRepresentation> gmftRepresentations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionmodelPackage.Literals.USE_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiagramType() {
		return diagramType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramType(String newDiagramType) {
		String oldDiagramType = diagramType;
		diagramType = newDiagramType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.USE_CONTEXT__DIAGRAM_TYPE, oldDiagramType, diagramType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Representation> getRepresentations() {
		if (representations == null) {
			representations = new EObjectResolvingEList<Representation>(Representation.class, this, ExpansionmodelPackage.USE_CONTEXT__REPRESENTATIONS);
		}
		return representations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.USE_CONTEXT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GMFT_BasedRepresentation> getGmftRepresentations() {
		if (gmftRepresentations == null) {
			gmftRepresentations = new EObjectContainmentEList<GMFT_BasedRepresentation>(GMFT_BasedRepresentation.class, this, ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS);
		}
		return gmftRepresentations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS:
				return ((InternalEList<?>)getGmftRepresentations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionmodelPackage.USE_CONTEXT__DIAGRAM_TYPE:
				return getDiagramType();
			case ExpansionmodelPackage.USE_CONTEXT__REPRESENTATIONS:
				return getRepresentations();
			case ExpansionmodelPackage.USE_CONTEXT__NAME:
				return getName();
			case ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS:
				return getGmftRepresentations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpansionmodelPackage.USE_CONTEXT__DIAGRAM_TYPE:
				setDiagramType((String)newValue);
				return;
			case ExpansionmodelPackage.USE_CONTEXT__REPRESENTATIONS:
				getRepresentations().clear();
				getRepresentations().addAll((Collection<? extends Representation>)newValue);
				return;
			case ExpansionmodelPackage.USE_CONTEXT__NAME:
				setName((String)newValue);
				return;
			case ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS:
				getGmftRepresentations().clear();
				getGmftRepresentations().addAll((Collection<? extends GMFT_BasedRepresentation>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpansionmodelPackage.USE_CONTEXT__DIAGRAM_TYPE:
				setDiagramType(DIAGRAM_TYPE_EDEFAULT);
				return;
			case ExpansionmodelPackage.USE_CONTEXT__REPRESENTATIONS:
				getRepresentations().clear();
				return;
			case ExpansionmodelPackage.USE_CONTEXT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS:
				getGmftRepresentations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpansionmodelPackage.USE_CONTEXT__DIAGRAM_TYPE:
				return DIAGRAM_TYPE_EDEFAULT == null ? diagramType != null : !DIAGRAM_TYPE_EDEFAULT.equals(diagramType);
			case ExpansionmodelPackage.USE_CONTEXT__REPRESENTATIONS:
				return representations != null && !representations.isEmpty();
			case ExpansionmodelPackage.USE_CONTEXT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpansionmodelPackage.USE_CONTEXT__GMFT_REPRESENTATIONS:
				return gmftRepresentations != null && !gmftRepresentations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (diagramType: ");
		result.append(diagramType);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //UseContextImpl
