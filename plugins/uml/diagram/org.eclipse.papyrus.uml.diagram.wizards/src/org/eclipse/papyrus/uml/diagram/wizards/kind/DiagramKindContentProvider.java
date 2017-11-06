/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.wizards.kind;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.viewpoints.configuration.Category;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;

/**
 * The ContentProvider for DiagramCategory table.
 * Returns available diagram kinds for the given diagram category(ies).
 */
public class DiagramKindContentProvider implements IStructuredContentProvider {

	private final Map<String, Collection<ViewPrototype>> prototypes;

	/**
	 * Instantiates a new diagram kind content provider.
	 *
	 */
	public DiagramKindContentProvider() {
		Collection<ViewPrototype> vps = PolicyChecker.getCurrent().getAllPrototypes();
		this.prototypes = new HashMap<String, Collection<ViewPrototype>>();
		for (ViewPrototype vp : vps) {
			for (Category category : vp.getCategories()) {
				cache(category.getName(), vp);
			}
		}
	}

	/**
	 * Stores the given diagram prototype in the cache
	 *
	 * @param prototype
	 *            The prototype to cache
	 */
	private void cache(String category, ViewPrototype prototype) {
		if (!prototypes.containsKey(category)) {
			prototypes.put(category, new ArrayList<ViewPrototype>());
		}
		prototypes.get(category).add(prototype);
	}

	/**
	 * Dispose.
	 *
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		prototypes.clear();
	}

	/**
	 * Input changed.
	 *
	 * @param viewer
	 *            the viewer
	 * @param oldInput
	 *            the old input
	 * @param newInput
	 *            the new input
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	/**
	 * Gets the elements.
	 *
	 * @param inputElement
	 *            the input element
	 * @return the elements
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Object[]) {
			List<ViewPrototype> result = new ArrayList<ViewPrototype>();
			for (Object next : (Object[]) inputElement) {
				if (next instanceof String) {
					String diagramCategory = (String) next;
					result.addAll(getPrototypes(diagramCategory));
				}
			}
			Collections.sort(result, new ViewPrototype.Comp());
			return result.toArray(new Object[result.size()]);
		}
		if (inputElement instanceof String) {
			String diagramCategory = (String) inputElement;
			List<ViewPrototype> result = getPrototypes(diagramCategory);
			return result.toArray(new Object[result.size()]);
		}
		return null;
	}

	/**
	 * Gets the creation commands.
	 *
	 * @param diagramCategory
	 *            the diagram category
	 * @return the creation commands
	 */
	protected List<ViewPrototype> getPrototypes(String diagramCategory) {
		HashMap<String, ViewPrototype> result = new HashMap<String, ViewPrototype>();
		if (prototypes.containsKey(diagramCategory)) {
			// Look for all diagram kind of the category
			for (ViewPrototype prototype : prototypes.get(diagramCategory)) {
				String label = prototype.getLabel();
				// If the diagram is not contains in the result add it
				if (!result.containsKey(label)) {
					result.put(label, prototype);
				}
			}
		}
		return new ArrayList<ViewPrototype>(result.values());
	}
}