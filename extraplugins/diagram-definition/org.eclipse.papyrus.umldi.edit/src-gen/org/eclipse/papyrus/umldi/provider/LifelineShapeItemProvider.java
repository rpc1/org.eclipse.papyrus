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
package org.eclipse.papyrus.umldi.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.papyrus.umldi.LifelineShape;
import org.eclipse.papyrus.umldi.UMLDIFactory;
import org.eclipse.papyrus.umldi.UMLDIPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.umldi.LifelineShape} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class LifelineShapeItemProvider extends ElementShapeItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LifelineShapeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE);
			childrenFeatures.add(UMLDIPackage.Literals.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE);
			childrenFeatures.add(UMLDIPackage.Literals.LIFELINE_SHAPE__CONSTRAINT_LABEL);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.
		return super.getChildFeature(object, child);
	}

	/**
	 * This returns LifelineShape.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/LifelineShape"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		LifelineShape lifelineShape = (LifelineShape)object;
		return getString("_UI_LifelineShape_type") + " " + lifelineShape.isShowStereotypeAttributes();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		switch(notification.getFeatureID(LifelineShape.class)) {
		case UMLDIPackage.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE:
		case UMLDIPackage.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE:
		case UMLDIPackage.LIFELINE_SHAPE__CONSTRAINT_LABEL:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createInteractionFragmentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createInteractionShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createInteractionUseShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createCombinedFragmentShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createInteractionOperandShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createExecutionSpecificationShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__SUBFRAGMENT_SHAPE, UMLDIFactory.eINSTANCE.createStateInvariantShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__NESTED_LIFELINE_SHAPE, UMLDIFactory.eINSTANCE.createLifelineShape()));
		newChildDescriptors.add(createChildParameter(UMLDIPackage.Literals.LIFELINE_SHAPE__CONSTRAINT_LABEL, UMLDIFactory.eINSTANCE.createConstraintLabel()));
	}
}
