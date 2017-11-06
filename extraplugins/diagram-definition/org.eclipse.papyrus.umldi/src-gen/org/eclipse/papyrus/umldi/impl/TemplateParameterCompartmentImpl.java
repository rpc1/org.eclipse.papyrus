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
package org.eclipse.papyrus.umldi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.papyrus.umldi.TemplateParameterCompartment;
import org.eclipse.papyrus.umldi.TemplateableElementShape;
import org.eclipse.papyrus.umldi.UMLDIPackage;
import org.eclipse.papyrus.umldi.UmlDiagramElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Parameter Compartment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TemplateParameterCompartmentImpl#getOwningUmlDiagramElement <em>Owning Uml Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.umldi.impl.TemplateParameterCompartmentImpl#getTemplateableElementShape <em>Templateable Element Shape</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateParameterCompartmentImpl extends ListCompartmentImpl implements TemplateParameterCompartment {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TemplateParameterCompartmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDIPackage.Literals.TEMPLATE_PARAMETER_COMPARTMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement getOwningUmlDiagramElement() {
		UmlDiagramElement owningUmlDiagramElement = basicGetOwningUmlDiagramElement();
		return owningUmlDiagramElement != null && owningUmlDiagramElement.eIsProxy() ? (UmlDiagramElement)eResolveProxy((InternalEObject)owningUmlDiagramElement) : owningUmlDiagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public UmlDiagramElement basicGetOwningUmlDiagramElement() {
		TemplateableElementShape templateableElementShape = getTemplateableElementShape();
		if(templateableElementShape != null) {
			return templateableElementShape;
		}
		return super.basicGetOwningUmlDiagramElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TemplateableElementShape getTemplateableElementShape() {
		if(eContainerFeatureID() != UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE)
			return null;
		return (TemplateableElementShape)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTemplateableElementShape(TemplateableElementShape newTemplateableElementShape, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTemplateableElementShape, UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTemplateableElementShape(TemplateableElementShape newTemplateableElementShape) {
		if(newTemplateableElementShape != eInternalContainer() || (eContainerFeatureID() != UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE && newTemplateableElementShape != null)) {
			if(EcoreUtil.isAncestor(this, newTemplateableElementShape))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newTemplateableElementShape != null)
				msgs = ((InternalEObject)newTemplateableElementShape).eInverseAdd(this, UMLDIPackage.TEMPLATEABLE_ELEMENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, TemplateableElementShape.class, msgs);
			msgs = basicSetTemplateableElementShape(newTemplateableElementShape, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE, newTemplateableElementShape, newTemplateableElementShape));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetTemplateableElementShape((TemplateableElementShape)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			return basicSetTemplateableElementShape(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			return eInternalContainer().eInverseRemove(this, UMLDIPackage.TEMPLATEABLE_ELEMENT_SHAPE__TEMPLATE_PARAMETER_COMPARTMENT, TemplateableElementShape.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			return getTemplateableElementShape();
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
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			setTemplateableElementShape((TemplateableElementShape)newValue);
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
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			setTemplateableElementShape((TemplateableElementShape)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__OWNING_UML_DIAGRAM_ELEMENT:
			return isSetOwningUmlDiagramElement();
		case UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE:
			return getTemplateableElementShape() != null;
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
	public boolean isSetOwningUmlDiagramElement() {
		return super.isSetOwningUmlDiagramElement() || eIsSet(UMLDIPackage.TEMPLATE_PARAMETER_COMPARTMENT__TEMPLATEABLE_ELEMENT_SHAPE);
	}
} //TemplateParameterCompartmentImpl
