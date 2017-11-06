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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  (with the help of examining table support from Vincent Lorenzo)
 *
 *****************************************************************************/

package org.eclipse.papyrus.texteditor.modelexplorer.queries;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.papyrus.views.modelexplorer.queries.AbstractEditorContainerQuery;

/** Get the collection of all contained text editors */
public class GetContainedTextEditors extends AbstractEditorContainerQuery implements IJavaQuery2<EObject, Collection<TextEditorModel>> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<TextEditorModel> evaluate(EObject source, IParameterValueList2 parameterValues, IFacetManager manager) throws DerivedTypedElementException  {

		List<TextEditorModel> result = new ArrayList<TextEditorModel>();
		Iterator<EObject> roots = NavigatorUtils.getNotationRoots(source);
		if (roots == null) {
			return result;
		}

		while (roots.hasNext()) {
			EObject root = roots.next();
			if (root instanceof TextEditorModel) {
				TextEditorModel textEditorModel = (TextEditorModel) root; 
				if (textEditorModel.getEditedObject() == source) {
					result.add(textEditorModel);
				}
			}
		}
		return result;
	}
}
