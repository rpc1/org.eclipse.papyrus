/*
 * Copyright (c) 2014, 2015 CEA, Christian W. Damus, CEA LIST, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *   Christian W. Damus - bug 399859
 *   Christian W. Damus - bug 465416
 *   Eike Stepper (CEA) - bug 466520
 *
 */
package org.eclipse.papyrus.infra.core.resource;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.google.common.collect.ImmutableList;


/**
 * A convenient superclass for adapters on {@link ResourceSet}s that need to handle changes in {@link Resource}s.
 * The adapter automatically propagates itself to newly added resources and provides hooks for common resource events.
 */
public abstract class ResourceAdapter extends AdapterImpl {

	public ResourceAdapter() {
		super();
	}

	@Override
	public void setTarget(Notifier newTarget) {
		// Don't need to track resources as targets (there are multiple)
		if (newTarget instanceof ResourceSet) {
			super.setTarget(newTarget);

			// Discover existing resources. Iterate the current set; any new additions
			// will be discovered automatically
			for (Resource next : ImmutableList.copyOf(((ResourceSet) newTarget).getResources())) {
				handleResourceAdded(next);
				if (next.isLoaded()) {
					handleResourceLoaded(next);
				}
			}
		}
	}

	protected ResourceSet getResourceSet() {
		return (ResourceSet) getTarget();
	}

	@Override
	public void notifyChanged(Notification msg) {
		Object notifier = msg.getNotifier();

		if (!msg.isTouch()) {
			if (notifier instanceof ResourceSet) {
				if (msg.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES) {
					handleResourceSetResources(msg);
				}
			} else if (notifier instanceof Resource) {
				switch (msg.getFeatureID(Resource.class)) {
				case Resource.RESOURCE__IS_LOADED:
					switch (msg.getEventType()) {
					case Notification.SET:
					case Notification.UNSET:
						if (msg.getNewBooleanValue()) {
							handleResourceLoaded((Resource) notifier);
						} else {
							handleResourceUnloaded((Resource) notifier);
						}
						break;
					}
					break;
				case Resource.RESOURCE__URI:
					switch (msg.getEventType()) {
					case Notification.SET:
					case Notification.UNSET:
						handleResourceURI((Resource) notifier, (URI) msg.getOldValue(), (URI) msg.getNewValue());
						break;
					}
					break;
				case Resource.RESOURCE__CONTENTS:
					handleResourceContents(msg);
					break;
				}
			}
		}
	}

	protected void addAdapter(Notifier notifier) {
		EList<Adapter> adapters = notifier.eAdapters();
		if (!adapters.contains(this)) {
			adapters.add(this);
		}
	}

	protected void removeAdapter(Notifier notifier) {
		notifier.eAdapters().remove(this);
	}

	protected void handleResourceSetResources(Notification msg) {
		switch (msg.getEventType()) {
		case Notification.ADD: {
			Resource resource = (Resource) msg.getNewValue();
			addAdapter(resource);
			handleResourceAdded(resource);
		}
			break;
		case Notification.ADD_MANY:
			for (Object next : (Iterable<?>) msg.getNewValue()) {
				Resource resource = (Resource) next;
				addAdapter(resource);
				handleResourceAdded(resource);
			}
			break;
		case Notification.REMOVE: {
			Resource resource = (Resource) msg.getOldValue();
			try {
				handleResourceRemoved(resource);
			} finally {
				removeAdapter(resource);
			}
			break;
		}
		case Notification.REMOVE_MANY:
			for (Object next : (Iterable<?>) msg.getOldValue()) {
				Resource resource = (Resource) next;
				try {
					handleResourceRemoved(resource);
				} finally {
					removeAdapter(resource);
				}
			}
			break;
		case Notification.SET: {
			Resource oldResource = (Resource) msg.getOldValue();
			try {
				handleResourceRemoved(oldResource);
			} finally {
				removeAdapter(oldResource);
			}

			Resource newResource = (Resource) msg.getOldValue();
			addAdapter(newResource);
			handleResourceAdded(newResource);
			break;
		}
		}
	}

	protected void handleResourceContents(Notification msg) {
		Resource.Internal resource = (Resource.Internal) msg.getNotifier();

		// Don't report addition of roots when loading nor removal of roots when unloading
		// because loading and unloading are semantically more significant events
		if (resource.isLoaded() && !resource.isLoading()) {
			switch (msg.getEventType()) {
			case Notification.ADD: {
				Object newValue = msg.getNewValue();
				if (newValue instanceof EObject) {
					handleRootAdded(resource, (EObject) newValue);
				}
				break;
			}
			case Notification.ADD_MANY: {
				Object newValue = msg.getNewValue();
				if (newValue instanceof Iterable<?>) {
					for (Object next : (Iterable<?>) newValue) {
					handleRootAdded(resource, (EObject) next);
				}
				}
				break;
			}
			case Notification.REMOVE: {
				Object oldValue = msg.getOldValue();
				if (oldValue instanceof EObject) {
					handleRootRemoved(resource, (EObject) oldValue);
				}
				break;
			}
			case Notification.REMOVE_MANY: {
				Object oldValue = msg.getOldValue();
				if (oldValue instanceof Iterable<?>) {
					for (Object next : (Iterable<?>) oldValue) {
					handleRootRemoved(resource, (EObject) next);
				}
				}
				break;
			}
			case Notification.SET: {
				Object oldValue = msg.getOldValue();
				Object newValue = msg.getNewValue();
				if (oldValue instanceof EObject && newValue instanceof EObject) {
					handleRootRemoved(resource, (EObject) oldValue);
					handleRootAdded(resource, (EObject) newValue);
				}
				break;
			}
		}
	}
	}

	protected void handleResourceAdded(Resource resource) {
		// Pass
	}

	protected void handleResourceRemoved(Resource resource) {
		// Pass
	}

	protected void handleResourceLoaded(Resource resource) {
		// Pass
	}

	protected void handleResourceUnloaded(Resource resource) {
		// Pass
	}

	protected void handleResourceURI(Resource resource, URI oldURI, URI newURI) {
		// Pass
	}

	protected void handleRootAdded(Resource resource, EObject root) {
		// Pass
	}

	protected void handleRootRemoved(Resource resource, EObject root) {
		// Pass
	}

	//
	// Nested types
	//

	/**
	 * A variant of the {@link ResourceAdapter} that is attached to a {@link TransactionalEditingDomain} to process batched notifications.
	 */
	public static class Transactional extends ResourceAdapter implements ResourceSetListener {
		private final boolean isPrecommit;

		private final NotificationFilter filter = NotificationFilter.NOT_TOUCH.and(createFilter());

		/**
		 * Initializes me as a post-commit resource notification handler.
		 */
		public Transactional() {
			this(false);
		}

		/**
		 * Initializes me as a pre- or post-commit resource notification handler.
		 * 
		 * @param isPrecommit
		 *            {@code true} to react to pre-commit notifications; {@code false} to react to post-commit notifications
		 */
		public Transactional(boolean isPrecommit) {
			this.isPrecommit = isPrecommit;
		}

		@Override
		public boolean isAggregatePrecommitListener() {
			return false;
		}

		@Override
		public boolean isPrecommitOnly() {
			return isPrecommit;
		}

		@Override
		public boolean isPostcommitOnly() {
			return !isPrecommit;
		}

		/**
		 * Subclasses may override/extend this method to create custom filters, perhaps based on the default filter create by the superclass.
		 * <b>Note</b> that this method is invoked by the superclass constructor, so subclasses must not attempt to access their own state.
		 * 
		 * @return my notification filter
		 */
		protected NotificationFilter createFilter() {
			return NotificationFilter.createNotifierTypeFilter(ResourceSet.class).or(
					NotificationFilter.createNotifierTypeFilter(Resource.class));
		}

		@Override
		public NotificationFilter getFilter() {
			return filter;
		}

		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			handleResourceSetChangeEvent(event);
		}

		@Override
		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			handleResourceSetChangeEvent(event);
			return null;
		}

		/**
		 * Installs me on the specified editing domain and processes existing loaded resources through the
		 * {@link #handleResourceAdded(Resource)} and (for resources that are already loaded)
		 * {@link #handleResourceLoaded(Resource)} call-backs. Clients that do not want this initial
		 * discovery step should just add me directly to the editing domain as a listener.
		 * 
		 * @param editingDomain
		 *            an editing domain in which to install me
		 */
		public void install(TransactionalEditingDomain editingDomain) {
			editingDomain.addResourceSetListener(this);

			// Safe iteration in case of additional resources being loaded (which will be picked up by the listener separately)
			for (Resource next : ImmutableList.copyOf(editingDomain.getResourceSet().getResources())) {
				handleResourceAdded(next);

				if (next.isLoaded()) {
					handleResourceLoaded(next);
				}
			}
		}

		/**
		 * Uninstalls me from the specified editing domain and processes existing loaded resources through the
		 * {@link #handleResourceRemoved(Resource)} call-back. Loaded resources are still loaded, so they are
		 * not run through {@link #handleResourceUnloaded(Resource)}: this is not symmetric with {@link #install(TransactionalEditingDomain)}.
		 * Clients that do not want this un-discovery step should just remove me directly fromthe editing domain.
		 * 
		 * @param editingDomain
		 *            an editing domain from which to uninstall me
		 */
		public void uninstall(TransactionalEditingDomain editingDomain) {
			try {
				ResourceSet resourceSet = editingDomain.getResourceSet();
				if (resourceSet != null) {
					// Safe iteration
					for (Resource next : ImmutableList.copyOf(resourceSet.getResources())) {
						handleResourceRemoved(next);
					}
				}
			} finally {
				editingDomain.addResourceSetListener(this);
			}
		}

		protected void handleResourceSetChangeEvent(ResourceSetChangeEvent event) {
			for (Notification next : event.getNotifications()) {
				notifyChanged(next);
			}
		}

		@Override
		public final void setTarget(Notifier newTarget) {
			// Don't attach me to anything. I am fed directly by the editing domain
		}

		@Override
		public final void unsetTarget(Notifier oldTarget) {
			// Pass
		}

		@Override
		protected final void addAdapter(Notifier notifier) {
			// Don't attach me to anything. I am fed directly by the editing domain
		}

		@Override
		protected final void removeAdapter(Notifier notifier) {
			// Pass
		}
	}
}
