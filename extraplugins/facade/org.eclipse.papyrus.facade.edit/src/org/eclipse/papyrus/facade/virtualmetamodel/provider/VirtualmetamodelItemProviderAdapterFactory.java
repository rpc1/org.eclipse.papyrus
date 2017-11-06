/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.virtualmetamodel.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.papyrus.facade.virtualmetamodel.util.VirtualmetamodelAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class VirtualmetamodelItemProviderAdapterFactory extends VirtualmetamodelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public VirtualmetamodelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualMetamodelItemProvider virtualMetamodelItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualMetamodelAdapter() {
		if (virtualMetamodelItemProvider == null) {
			virtualMetamodelItemProvider = new VirtualMetamodelItemProvider(this);
		}

		return virtualMetamodelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualMetaclassItemProvider virtualMetaclassItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetaclass}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualMetaclassAdapter() {
		if (virtualMetaclassItemProvider == null) {
			virtualMetaclassItemProvider = new VirtualMetaclassItemProvider(this);
		}

		return virtualMetaclassItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualPropertyItemProvider virtualPropertyItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualPropertyAdapter() {
		if (virtualPropertyItemProvider == null) {
			virtualPropertyItemProvider = new VirtualPropertyItemProvider(this);
		}

		return virtualPropertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualOperationItemProvider virtualOperationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualOperation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualOperationAdapter() {
		if (virtualOperationItemProvider == null) {
			virtualOperationItemProvider = new VirtualOperationItemProvider(this);
		}

		return virtualOperationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualParameterItemProvider virtualParameterItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualParameterAdapter() {
		if (virtualParameterItemProvider == null) {
			virtualParameterItemProvider = new VirtualParameterItemProvider(this);
		}

		return virtualParameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualDatatypeItemProvider virtualDatatypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualDatatype}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualDatatypeAdapter() {
		if (virtualDatatypeItemProvider == null) {
			virtualDatatypeItemProvider = new VirtualDatatypeItemProvider(this);
		}

		return virtualDatatypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualEnumItemProvider virtualEnumItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualEnumAdapter() {
		if (virtualEnumItemProvider == null) {
			virtualEnumItemProvider = new VirtualEnumItemProvider(this);
		}

		return virtualEnumItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VirtualLiteralItemProvider virtualLiteralItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.facade.virtualmetamodel.VirtualLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createVirtualLiteralAdapter() {
		if (virtualLiteralItemProvider == null) {
			virtualLiteralItemProvider = new VirtualLiteralItemProvider(this);
		}

		return virtualLiteralItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void dispose() {
		if (virtualMetamodelItemProvider != null) {
			virtualMetamodelItemProvider.dispose();
		}
		if (virtualMetaclassItemProvider != null) {
			virtualMetaclassItemProvider.dispose();
		}
		if (virtualPropertyItemProvider != null) {
			virtualPropertyItemProvider.dispose();
		}
		if (virtualOperationItemProvider != null) {
			virtualOperationItemProvider.dispose();
		}
		if (virtualParameterItemProvider != null) {
			virtualParameterItemProvider.dispose();
		}
		if (virtualDatatypeItemProvider != null) {
			virtualDatatypeItemProvider.dispose();
		}
		if (virtualEnumItemProvider != null) {
			virtualEnumItemProvider.dispose();
		}
		if (virtualLiteralItemProvider != null) {
			virtualLiteralItemProvider.dispose();
		}
	}

}