/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.provider;

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
import org.eclipse.papyrus.domaincontextcodegen.util.DomaincontextcodegenAdapterFactory;

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
public class DomaincontextcodegenItemProviderAdapterFactory extends DomaincontextcodegenAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {

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
	public DomaincontextcodegenItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.DomainContext} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected DomainContextItemProvider domainContextItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.DomainContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createDomainContextAdapter() {
		if (domainContextItemProvider == null) {
			domainContextItemProvider = new DomainContextItemProvider(this);
		}

		return domainContextItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementTypesItemProvider elementTypesItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypes}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createElementTypesAdapter() {
		if (elementTypesItemProvider == null) {
			elementTypesItemProvider = new ElementTypesItemProvider(this);
		}

		return elementTypesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MetaClassTypeItemProvider metaClassTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.MetaClassType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createMetaClassTypeAdapter() {
		if (metaClassTypeItemProvider == null) {
			metaClassTypeItemProvider = new MetaClassTypeItemProvider(this);
		}

		return metaClassTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected SpecializationTypeItemProvider specializationTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.SpecializationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createSpecializationTypeAdapter() {
		if (specializationTypeItemProvider == null) {
			specializationTypeItemProvider = new SpecializationTypeItemProvider(this);
		}

		return specializationTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.Advice} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AdviceItemProvider adviceItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.Advice}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createAdviceAdapter() {
		if (adviceItemProvider == null) {
			adviceItemProvider = new AdviceItemProvider(this);
		}

		return adviceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementTypeBindingsItemProvider elementTypeBindingsItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createElementTypeBindingsAdapter() {
		if (elementTypeBindingsItemProvider == null) {
			elementTypeBindingsItemProvider = new ElementTypeBindingsItemProvider(this);
		}

		return elementTypeBindingsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ElementTypeBindingItemProvider elementTypeBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.ElementTypeBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createElementTypeBindingAdapter() {
		if (elementTypeBindingItemProvider == null) {
			elementTypeBindingItemProvider = new ElementTypeBindingItemProvider(this);
		}

		return elementTypeBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected AdviceBindingItemProvider adviceBindingItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.AdviceBinding}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createAdviceBindingAdapter() {
		if (adviceBindingItemProvider == null) {
			adviceBindingItemProvider = new AdviceBindingItemProvider(this);
		}

		return adviceBindingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected GenHandlersItemProvider genHandlersItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.GenHandlers}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createGenHandlersAdapter() {
		if (genHandlersItemProvider == null) {
			genHandlersItemProvider = new GenHandlersItemProvider(this);
		}

		return genHandlersItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected StereotypedElementMatcherItemProvider stereotypedElementMatcherItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createStereotypedElementMatcherAdapter() {
		if (stereotypedElementMatcherItemProvider == null) {
			stereotypedElementMatcherItemProvider = new StereotypedElementMatcherItemProvider(this);
		}

		return stereotypedElementMatcherItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected StereotypedElementHelperItemProvider stereotypedElementHelperItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.StereotypedElementHelper}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createStereotypedElementHelperAdapter() {
		if (stereotypedElementHelperItemProvider == null) {
			stereotypedElementHelperItemProvider = new StereotypedElementHelperItemProvider(this);
		}

		return stereotypedElementHelperItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected MenuDeclarationItemProvider menuDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.MenuDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createMenuDeclarationAdapter() {
		if (menuDeclarationItemProvider == null) {
			menuDeclarationItemProvider = new MenuDeclarationItemProvider(this);
		}

		return menuDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CommandDeclarationItemProvider commandDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createCommandDeclarationAdapter() {
		if (commandDeclarationItemProvider == null) {
			commandDeclarationItemProvider = new CommandDeclarationItemProvider(this);
		}

		return commandDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.papyrus.domaincontextcodegen.Command} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected CommandItemProvider commandItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.papyrus.domaincontextcodegen.Command}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Adapter createCommandAdapter() {
		if (commandItemProvider == null) {
			commandItemProvider = new CommandItemProvider(this);
		}

		return commandItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
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
	public void dispose() {
		if (domainContextItemProvider != null) {
			domainContextItemProvider.dispose();
		}
		if (elementTypesItemProvider != null) {
			elementTypesItemProvider.dispose();
		}
		if (metaClassTypeItemProvider != null) {
			metaClassTypeItemProvider.dispose();
		}
		if (specializationTypeItemProvider != null) {
			specializationTypeItemProvider.dispose();
		}
		if (adviceItemProvider != null) {
			adviceItemProvider.dispose();
		}
		if (elementTypeBindingsItemProvider != null) {
			elementTypeBindingsItemProvider.dispose();
		}
		if (elementTypeBindingItemProvider != null) {
			elementTypeBindingItemProvider.dispose();
		}
		if (adviceBindingItemProvider != null) {
			adviceBindingItemProvider.dispose();
		}
		if (genHandlersItemProvider != null) {
			genHandlersItemProvider.dispose();
		}
		if (stereotypedElementMatcherItemProvider != null) {
			stereotypedElementMatcherItemProvider.dispose();
		}
		if (stereotypedElementHelperItemProvider != null) {
			stereotypedElementHelperItemProvider.dispose();
		}
		if (menuDeclarationItemProvider != null) {
			menuDeclarationItemProvider.dispose();
		}
		if (commandDeclarationItemProvider != null) {
			commandDeclarationItemProvider.dispose();
		}
		if (commandItemProvider != null) {
			commandItemProvider.dispose();
		}
	}

}
