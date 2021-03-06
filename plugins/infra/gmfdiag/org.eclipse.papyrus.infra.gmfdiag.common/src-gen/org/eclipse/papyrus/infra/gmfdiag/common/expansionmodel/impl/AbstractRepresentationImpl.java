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

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.AbstractRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.util.ExpansionmodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Representation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.AbstractRepresentationImpl#getEditPartQualifiedName <em>Edit Part Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.AbstractRepresentationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.AbstractRepresentationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.AbstractRepresentationImpl#getViewFactory <em>View Factory</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractRepresentationImpl extends MinimalEObjectImpl.Container implements AbstractRepresentation {
	/**
	 * The default value of the '{@link #getEditPartQualifiedName() <em>Edit Part Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPartQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String EDIT_PART_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditPartQualifiedName() <em>Edit Part Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditPartQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String editPartQualifiedName = EDIT_PART_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected RepresentationKind kind;

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
	 * The default value of the '{@link #getViewFactory() <em>View Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String VIEW_FACTORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getViewFactory() <em>View Factory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewFactory()
	 * @generated
	 * @ordered
	 */
	protected String viewFactory = VIEW_FACTORY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRepresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpansionmodelPackage.Literals.ABSTRACT_REPRESENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditPartQualifiedName() {
		return editPartQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditPartQualifiedName(String newEditPartQualifiedName) {
		String oldEditPartQualifiedName = editPartQualifiedName;
		editPartQualifiedName = newEditPartQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME, oldEditPartQualifiedName, editPartQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationKind getKind() {
		if (kind != null && kind.eIsProxy()) {
			InternalEObject oldKind = (InternalEObject)kind;
			kind = (RepresentationKind)eResolveProxy(oldKind);
			if (kind != oldKind) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND, oldKind, kind));
			}
		}
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationKind basicGetKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(RepresentationKind newKind) {
		RepresentationKind oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND, oldKind, kind));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.ABSTRACT_REPRESENTATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getViewFactory() {
		return viewFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setViewFactory(String newViewFactory) {
		String oldViewFactory = viewFactory;
		viewFactory = newViewFactory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpansionmodelPackage.ABSTRACT_REPRESENTATION__VIEW_FACTORY, oldViewFactory, viewFactory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validate(DiagnosticChain diagnostic, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostic != null) {
				diagnostic.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 ExpansionmodelValidator.DIAGNOSTIC_SOURCE,
						 ExpansionmodelValidator.ABSTRACT_REPRESENTATION__VALIDATE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "validate", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				return getEditPartQualifiedName();
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND:
				if (resolve) return getKind();
				return basicGetKind();
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__NAME:
				return getName();
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__VIEW_FACTORY:
				return getViewFactory();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName((String)newValue);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND:
				setKind((RepresentationKind)newValue);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__NAME:
				setName((String)newValue);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__VIEW_FACTORY:
				setViewFactory((String)newValue);
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
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				setEditPartQualifiedName(EDIT_PART_QUALIFIED_NAME_EDEFAULT);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND:
				setKind((RepresentationKind)null);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__VIEW_FACTORY:
				setViewFactory(VIEW_FACTORY_EDEFAULT);
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
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__EDIT_PART_QUALIFIED_NAME:
				return EDIT_PART_QUALIFIED_NAME_EDEFAULT == null ? editPartQualifiedName != null : !EDIT_PART_QUALIFIED_NAME_EDEFAULT.equals(editPartQualifiedName);
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__KIND:
				return kind != null;
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION__VIEW_FACTORY:
				return VIEW_FACTORY_EDEFAULT == null ? viewFactory != null : !VIEW_FACTORY_EDEFAULT.equals(viewFactory);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION___VALIDATE__DIAGNOSTICCHAIN_MAP:
				return validate((DiagnosticChain)arguments.get(0), (Map)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (editPartQualifiedName: ");
		result.append(editPartQualifiedName);
		result.append(", name: ");
		result.append(name);
		result.append(", viewFactory: ");
		result.append(viewFactory);
		result.append(')');
		return result.toString();
	}

} //AbstractRepresentationImpl
