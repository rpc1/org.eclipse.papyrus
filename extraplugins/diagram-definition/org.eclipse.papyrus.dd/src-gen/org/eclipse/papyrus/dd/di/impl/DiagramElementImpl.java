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
package org.eclipse.papyrus.dd.di.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.dd.di.DIPackage;
import org.eclipse.papyrus.dd.di.Diagram;
import org.eclipse.papyrus.dd.di.DiagramElement;
import org.eclipse.papyrus.dd.di.Edge;
import org.eclipse.papyrus.dd.di.Style;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Diagram Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getModelElement <em>Model Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getOwningDiagramElement <em>Owning Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getOwnedDiagramElement <em>Owned Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getLocalStyle <em>Local Style</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getSharedStyle <em>Shared Style</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getTargetEdge <em>Target Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getSourceEdge <em>Source Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.dd.di.impl.DiagramElementImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DiagramElementImpl extends MinimalEObjectImpl.Container implements DiagramElement {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DiagramElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DIPackage.Literals.DIAGRAM_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<EObject> getModelElement() {
		return new DerivedUnionEObjectEList<EObject>(EObject.class, this, DIPackage.DIAGRAM_ELEMENT__MODEL_ELEMENT, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement getOwningDiagramElement() {
		DiagramElement owningDiagramElement = basicGetOwningDiagramElement();
		return owningDiagramElement != null && owningDiagramElement.eIsProxy() ? (DiagramElement)eResolveProxy((InternalEObject)owningDiagramElement) : owningDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement basicGetOwningDiagramElement() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<DiagramElement> getOwnedDiagramElement() {
		return new DerivedUnionEObjectEList<DiagramElement>(DiagramElement.class, this, DIPackage.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Edge> getTargetEdge() {
		return new DerivedUnionEObjectEList<Edge>(Edge.class, this, DIPackage.DIAGRAM_ELEMENT__TARGET_EDGE, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Edge> getSourceEdge() {
		return new DerivedUnionEObjectEList<Edge>(Edge.class, this, DIPackage.DIAGRAM_ELEMENT__SOURCE_EDGE, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram getDiagram() {
		Diagram diagram = basicGetDiagram();
		return diagram != null && diagram.eIsProxy() ? (Diagram)eResolveProxy((InternalEObject)diagram) : diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Diagram basicGetDiagram() {
		return diagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		// TODO: implement this method to set the 'Diagram' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * The cached invocation delegate for the '{@link #diagram() <em>Diagram</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #diagram()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate DIAGRAM__EINVOCATION_DELEGATE = ((EOperation.Internal)DIPackage.Literals.DIAGRAM_ELEMENT___DIAGRAM).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram diagram() {
		try {
			return (Diagram)DIAGRAM__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		} catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Style getLocalStyle() {
		Style localStyle = basicGetLocalStyle();
		return localStyle != null && localStyle.eIsProxy() ? (Style)eResolveProxy((InternalEObject)localStyle) : localStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Style basicGetLocalStyle() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Style getSharedStyle() {
		Style sharedStyle = basicGetSharedStyle();
		return sharedStyle != null && sharedStyle.eIsProxy() ? (Style)eResolveProxy((InternalEObject)sharedStyle) : sharedStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Style basicGetSharedStyle() {
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DIPackage.DIAGRAM_ELEMENT__MODEL_ELEMENT:
			return getModelElement();
		case DIPackage.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT:
			if(resolve)
				return getOwningDiagramElement();
			return basicGetOwningDiagramElement();
		case DIPackage.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT:
			return getOwnedDiagramElement();
		case DIPackage.DIAGRAM_ELEMENT__LOCAL_STYLE:
			if(resolve)
				return getLocalStyle();
			return basicGetLocalStyle();
		case DIPackage.DIAGRAM_ELEMENT__SHARED_STYLE:
			if(resolve)
				return getSharedStyle();
			return basicGetSharedStyle();
		case DIPackage.DIAGRAM_ELEMENT__TARGET_EDGE:
			return getTargetEdge();
		case DIPackage.DIAGRAM_ELEMENT__SOURCE_EDGE:
			return getSourceEdge();
		case DIPackage.DIAGRAM_ELEMENT__DIAGRAM:
			if(resolve)
				return getDiagram();
			return basicGetDiagram();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DIPackage.DIAGRAM_ELEMENT__DIAGRAM:
			setDiagram((Diagram)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DIPackage.DIAGRAM_ELEMENT__DIAGRAM:
			setDiagram((Diagram)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DIPackage.DIAGRAM_ELEMENT__MODEL_ELEMENT:
			return isSetModelElement();
		case DIPackage.DIAGRAM_ELEMENT__OWNING_DIAGRAM_ELEMENT:
			return isSetOwningDiagramElement();
		case DIPackage.DIAGRAM_ELEMENT__OWNED_DIAGRAM_ELEMENT:
			return isSetOwnedDiagramElement();
		case DIPackage.DIAGRAM_ELEMENT__LOCAL_STYLE:
			return isSetLocalStyle();
		case DIPackage.DIAGRAM_ELEMENT__SHARED_STYLE:
			return isSetSharedStyle();
		case DIPackage.DIAGRAM_ELEMENT__TARGET_EDGE:
			return isSetTargetEdge();
		case DIPackage.DIAGRAM_ELEMENT__SOURCE_EDGE:
			return isSetSourceEdge();
		case DIPackage.DIAGRAM_ELEMENT__DIAGRAM:
			return basicGetDiagram() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch(operationID) {
		case DIPackage.DIAGRAM_ELEMENT___DIAGRAM:
			return diagram();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetModelElement() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetOwningDiagramElement() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetOwnedDiagramElement() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetLocalStyle() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetSharedStyle() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetTargetEdge() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetSourceEdge() {
		return false;
	}
} // DiagramElementImpl
