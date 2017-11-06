/*****************************************************************************
 * Copyright (c) 2010, 2015 LIFL & CEA LIST, Christian W. Damus, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin (LIFL) cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Christian W. Damus - bug 468030
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.ui.IEditorPart;

/**
 * Set of utility methods for accessing core Services. This class provide
 * methods to access the Papyrus well known services.
 *
 * <br>
 * This is the base class for concrete classes providing these utility methods.
 * Concrete class need to provide method {@link #getServiceRegistry(Object)} implementing how the ServiceRegistry is retrieved from the provided
 * object.
 * Subclasses can also provide a Singleton pattern (getInstance()) in order to
 * allow access to the utility methods in a static way. <br>
 *
 * @author cedri dumoulin
 *
 */
public abstract class AbstractServiceUtils<T> {

	/**
	 * Get the service registry from the specified parameter.
	 *
	 * @param from
	 * @return
	 */
	abstract public ServicesRegistry getServiceRegistry(T from) throws ServiceException;

	/**
	 * Gets the {@link TransactionalEditingDomain} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain(T from) throws ServiceException {
		return getServiceRegistry(from).getService(TransactionalEditingDomain.class);
	}

	/**
	 * Gets the {@link IPageMngr} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 *
	 * @deprecated Use {@link #getIPageManager(Object)} instead
	 */
	@Deprecated
	public IPageMngr getIPageMngr(T from) throws ServiceException {
		return getServiceRegistry(from).getService(IPageMngr.class);
	}

	/**
	 * Gets the {@link IPageManager} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public IPageManager getIPageManager(T from) throws ServiceException {
		return getServiceRegistry(from).getService(IPageManager.class);
	}

	/**
	 * Gets the {@link IPageMngr} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public ModelSet getModelSet(T from) throws ServiceException {
		return getServiceRegistry(from).getService(ModelSet.class);
	}

	/**
	 * Gets the {@link ILifeCycleEventsProvider} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public ILifeCycleEventsProvider getILifeCycleEventsProvider(T from) throws ServiceException {
		return getServiceRegistry(from).getService(ILifeCycleEventsProvider.class);
	}

	/**
	 * Gets the {@link ISashWindowsContainer} registered in the {@link ServicesRegistry}.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public ISashWindowsContainer getISashWindowsContainer(T from) throws ServiceException {
		return getServiceRegistry(from).getService(ISashWindowsContainer.class);
	}

	/**
	 * Gets the {@link IEditorPart} of the currently nested active editor.
	 *
	 * @param from
	 * @return
	 * @throws ServiceException
	 *             If an error occurs while getting the requested service.
	 */
	public IEditorPart getNestedActiveIEditorPart(T from) throws ServiceException {
		return getISashWindowsContainer(from).getActiveEditor();
	}

	/**
	 * Returns an implementation of the requested service, from the specified context
	 *
	 * @param service
	 *            The service for which an implementation is requested
	 * @param from
	 *            The context from which the service should be retrieved
	 * @return
	 * 		The implementation of the requested service
	 * @throws ServiceException
	 *             If an error occurs (e.g. cannot find the ServicesRegistry or the Service)
	 *
	 */
	public <S> S getService(Class<S> service, T from) throws ServiceException {
		return getServiceRegistry(from).getService(service);
	}

	/**
	 * Returns an implementation of the requested service, from the specified context
	 *
	 * @param service
	 *            The service for which an implementation is requested
	 * @param from
	 *            The context from which the service should be retrieved
	 * @return
	 * 		The implementation of the requested service
	 * @throws ServiceException
	 *             If an error occurs (e.g. cannot find the ServicesRegistry or the Service)
	 *
	 */
	public Object getService(Object service, T from) throws ServiceException {
		return getServiceRegistry(from).getService(service);
	}

	/**
	 * Returns an implementation of the requested <em>optional</em> service, from the specified context, if it is available.
	 *
	 * @param service
	 *            The service for which an implementation is requested
	 * @param from
	 *            The context from which the service should be retrieved
	 * @param defaultImpl
	 *            A default implementation of the requested service API to return if none is available in the registry
	 *            or if the registered implementation could not be properly initialized. May be {@code null} if the
	 *            service is <em>optional</em>
	 * 
	 * @return
	 * 		The implementation of the requested service, or the {@code defaultImpl}
	 */
	public <S> S getService(Class<S> service, T from, S defaultImpl) {
		try {
			// Don't even attempt to get a registry from a null context
			return (from == null) ? defaultImpl : getServiceRegistry(from).getService(service);
		} catch (ServiceException e) {
			// That's OK. It's optional and we have a default
			return defaultImpl;
		}
	}
}
