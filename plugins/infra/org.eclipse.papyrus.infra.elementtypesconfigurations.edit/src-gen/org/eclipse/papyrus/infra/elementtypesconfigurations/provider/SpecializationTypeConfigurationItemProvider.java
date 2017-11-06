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
package org.eclipse.papyrus.infra.elementtypesconfigurations.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsFactory;
import org.eclipse.papyrus.infra.elementtypesconfigurations.ElementtypesconfigurationsPackage;
import org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration;

/**
 * This is the item provider adapter for a {@link org.eclipse.papyrus.infra.elementtypesconfigurations.SpecializationTypeConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecializationTypeConfigurationItemProvider extends ElementTypeConfigurationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationTypeConfigurationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addSpecializedTypesIDPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Specialized Types ID feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSpecializedTypesIDPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_SpecializationTypeConfiguration_specializedTypesID_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_SpecializationTypeConfiguration_specializedTypesID_feature", "_UI_SpecializationTypeConfiguration_type"),
				 ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION);
			childrenFeatures.add(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION);
			childrenFeatures.add(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns SpecializationTypeConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/SpecializationTypeConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((SpecializationTypeConfiguration)object).getIdentifier();
		return label == null || label.length() == 0 ?
			getString("_UI_SpecializationTypeConfiguration_type") :
			getString("_UI_SpecializationTypeConfiguration_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(SpecializationTypeConfiguration.class)) {
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__SPECIALIZED_TYPES_ID:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION:
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION:
			case ElementtypesconfigurationsPackage.SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION:
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
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__EDIT_HELPER_ADVICE_CONFIGURATION,
				 ElementtypesconfigurationsFactory.eINSTANCE.createEditHelperAdviceConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__CONTAINER_CONFIGURATION,
				 ElementtypesconfigurationsFactory.eINSTANCE.createContainerConfiguration()));

		newChildDescriptors.add
			(createChildParameter
				(ElementtypesconfigurationsPackage.Literals.SPECIALIZATION_TYPE_CONFIGURATION__MATCHER_CONFIGURATION,
				 ElementtypesconfigurationsFactory.eINSTANCE.createMatcherConfiguration()));
	}

}
