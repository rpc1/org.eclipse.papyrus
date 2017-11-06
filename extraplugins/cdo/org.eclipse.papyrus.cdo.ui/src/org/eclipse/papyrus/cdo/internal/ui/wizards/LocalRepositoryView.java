/*****************************************************************************
 * Copyright (c) 2013, 2015 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 422257
 *   Eike Stepper (CEA) - bug 466520
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.explorer.CDOExplorerUtil;
import org.eclipse.emf.cdo.explorer.checkouts.CDOCheckout;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.cdo.internal.core.CDOProxyResolvingResourceSet;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


/**
 * This is the LocalRepositoryView type. Enjoy.
 */
public class LocalRepositoryView {

	private final Map<CDOCheckout, CDOView> localViews = Maps.newHashMap();

	private ResourceSet rset = null;

	public LocalRepositoryView() {
		super();
	}

	/**
	 * Disposes of all of the local {@link CDOView}s that I have cached.
	 */
	public void dispose() {
		for (Map.Entry<CDOCheckout, CDOView> next : localViews.entrySet()) {
			CDOView view = next.getValue();
			try {
				CDOUtils.unload(view);
			} catch (Exception e) {
				Activator.error("Exception in unloading CDO repository view.", e); //$NON-NLS-1$
			} finally {
				view.close();
			}
		}

		localViews.clear();

		if (rset != null) {
			try {
				EMFHelper.unload(rset);
			} catch (Exception e) {
				Activator.error("Exception in unloading CDO repository view's resource set.", e); //$NON-NLS-1$
			} finally {
				rset = null;
			}
		}
	}

	/**
	 * Obtain a view of the specified {@code selection} in the context of a local cache of distinct {@link CDOView}s.
	 *
	 * @param selection
	 *            a selection of objects in a CDO view
	 *
	 * @return a new selection consisting of the same objects as presented in my local CDO views
	 */
	public IStructuredSelection translate(IStructuredSelection selection) {
		return new StructuredSelection(translate(selection.toList()));
	}

	/**
	 * Obtain a view of the specified {@code objects} in the context of a local cache of distinct {@link CDOView}s.
	 *
	 * @param objects
	 *            a bunch of objects in a CDO view
	 *
	 * @return a new list consisting of the same objects as presented in my local CDO views
	 */
	public List<Object> translate(Collection<?> objects) {
		List<Object> result = Lists.newArrayListWithCapacity(objects.size());

		for (Object next : objects) {
			if (next instanceof EObject) {
				result.add(translate((EObject) next));
			} else if (next instanceof DIModel) {
				DIModel di = (DIModel) next;

				result.add(DIModel.getInstance(translate(di.getResource()), true));
			}
		}

		return result;
	}

	/**
	 * Obtain a view of the specified {@code object} in the context of a local cache of distinct {@link CDOView}s.
	 *
	 * @param objects
	 *            a modeled object in a CDO view
	 *
	 * @return the same object as presented in my local CDO views
	 */
	public <T extends EObject> T translate(T object) {
		T result;

		if (object instanceof CDOObject) {
			CDOObject cdo = (CDOObject) object;
			CDOView view = cdo.cdoView();
			if (view == null) {
				result = object;
			} else {
				CDOCheckout checkout = CDOExplorerUtil.getCheckout(view);
				CDOView localView = localViews.get(checkout);
				if (localView == null) {
					localView = checkout.openView(true, getResourceSet());
					localViews.put(checkout, localView);
				}

				result = localView.getObject(object);
			}
		} else {
			result = object;
		}

		return result;
	}

	protected ResourceSet getResourceSet() {
		if (rset == null) {
			rset = createResourceSet();
		}

		return rset;
	}

	protected ResourceSet createResourceSet() {
		return new CDOProxyResolvingResourceSet();
	}
}
