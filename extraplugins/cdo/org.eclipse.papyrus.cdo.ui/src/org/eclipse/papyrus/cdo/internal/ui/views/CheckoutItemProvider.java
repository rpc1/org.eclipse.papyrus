/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.views;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.explorer.CDOExplorerUtil;
import org.eclipse.emf.cdo.explorer.checkouts.CDOCheckout;
import org.eclipse.emf.cdo.ui.CDOItemProvider;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.net4j.util.ui.views.IElementFilter;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.SharedImages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * This is the ModelRepositoryItemProvider type. Enjoy.
 */
public class CheckoutItemProvider extends CDOItemProvider {

	private final Predicate<Object> isDIResource = new Predicate<Object>() {

		@Override
		public boolean apply(Object input) {
			return (input instanceof CDOResource) && DIResourceQuery.getDIResources(((CDOResource) input).cdoView()).contains(input);
		}
	};

	private final Predicate<Object> isUnaffiliatedResource = new Predicate<Object>() {

		@Override
		public boolean apply(Object input) {
			return !(input instanceof CDOResource) || DIResourceQuery.isUnaffiliatedResource((CDOResource) input);
		}
	};

	@SuppressWarnings("unchecked")
	private final Predicate<Object> resourceFilter = Predicates.or(Predicates.instanceOf(CDOResourceFolder.class), isDIResource, isUnaffiliatedResource);

	private final Function<Object, Object> resourceNodeTransformer = new Function<Object, Object>() {

		@Override
		public Object apply(Object input) {
			if (isDIResource.apply(input)) {
				return DIModel.getInstance((CDOResource) input, true);
			} else {
				return input;
			}
		}
	};

	private final Predicate<Object> extensibleFilter;

	public CheckoutItemProvider(IWorkbenchPage page, IElementFilter rootElementFilter) {

		super(page, rootElementFilter);

		extensibleFilter = ItemProviderFilterRegistry.INSTANCE.createFilter(this);
	}

	public CheckoutItemProvider(IWorkbenchPage page, Object rootElementToShow) {
		this(page, Collections.singleton(rootElementToShow));
	}

	public CheckoutItemProvider(IWorkbenchPage page, final Collection<?> rootElementsToShow) {
		this(page, new IElementFilter() {

			@Override
			public boolean filter(Object element) {
				return rootElementsToShow.contains(element);
			}
		});
	}

	public CheckoutItemProvider(IWorkbenchPage page) {
		this(page, (IElementFilter) null);
	}

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof CDOCheckout) {
			// initialize query for DI resources
			CDOCheckout checkout = (CDOCheckout) element;
			if (checkout.isOpen()) {
				DIResourceQuery.initialize(getViewer(), checkout.getView());
			}
		}

		Iterable<?> result;

		if (element instanceof DIModel) {
			result = Arrays.asList(((DIModel) element).getChildren());
		} else {
			result = Arrays.asList(super.getChildren(element));

			if ((element instanceof CDOResourceFolder) || (element instanceof CDOCheckout)) {
				result = filterDIResources(result);
			}
		}

		return Iterables.toArray(Iterables.filter(result, extensibleFilter), Object.class);
	}

	@Override
	public Object getParent(Object element) {
		Object result;

		if (element instanceof CDOResource) {
			CDOResource di = DIResourceQuery.getAffiliateResource((CDOResource) element);

			if (di != null) {
				result = DIModel.getInstance(di, true);
			} else {
				result = super.getParent(element);
			}
		} else if (element instanceof DIModel) {
			CDOResource resource = ((DIModel) element).getResource();
			CDOView view = resource.cdoView();

			// can't query the parent of an object in a closed view
			result = ((view != null) && view.isClosed()) ? null : super.getParent(resource);
		} else {
			CDOView view = null;
			if (element instanceof CDOObject) {
				view = ((CDOObject) element).cdoView();
			}

			// can't query the parent of an object in a closed view
			result = ((view != null) && view.isClosed()) ? null : super.getParent(element);

			// we don't show the view
			if (result instanceof CDOView) {
				result = CDOExplorerUtil.getCheckout((CDOView) result);
			}
		}

		return result;
	}

	protected Iterable<?> filter(Iterable<?> elements, Predicate<Object> predicate) {
		return Iterables.transform(Iterables.filter(elements, predicate), resourceNodeTransformer);
	}

	protected Iterable<?> filterDIResources(Iterable<?> elements) {
		return filter(elements, resourceFilter);
	}

	@Override
	public Image getImage(Object obj) {
		Image result;

		if (obj instanceof CDOCheckout) {
			boolean open = ((CDOCheckout) obj).isOffline();
			result = SharedImages.getImage(open ? Activator.ICON_OPEN_REPOSITORY : Activator.ICON_CLOSED_REPOSITORY);
		} else if (obj instanceof DIModel) {
			result = ((DIModel) obj).getImage();
		} else {
			result = super.getImage(obj);
		}

		return result;
	}

	@Override
	public String getText(Object obj) {
		String result;

		if (obj instanceof CDOCheckout) {
			result = ((CDOCheckout) obj).getLabel();
		} else if (obj instanceof DIModel) {
			result = ((DIModel) obj).getName();
		} else {
			result = super.getText(obj);
		}

		return result;
	}

}
