/*****************************************************************************
 * Copyright (c) 2011, 2015 CEA LIST, Christian W. Damus, and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus - bug 465899
 *   Bonnabesse Fanch (ALL4TEC) fanch.bonnabesse@alltec.net - Bug 476872
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.utils;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

import com.google.common.base.Defaults;

/**
 * <pre>
 * IDs of request parameters.
 * </pre>
 */
public interface RequestParameterConstants {

	/**
	 * The ID for the additional parameter SOURCE_PARENT possibly required in link creation request
	 *
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_PARENT = "SOURCE_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_PARENT possibly required in link creation request
	 *
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_PARENT = "TARGET_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter RECONNECT_PARENT possibly required in link reconnect request
	 *
	 * @deprecated
	 */
	@Deprecated
	public static final String CONNECTOR_REORIENT_REQUEST_TARGET_PARENT = "RECONNECT_PARENT"; //$NON-NLS-1$

	/**
	 * Extended request data key to hold the edge view during a reconnect request.
	 */
	public static final String GRAPHICAL_RECONNECTED_EDGE = "graphical_edge"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter SOURCE_GRAPHICAL_VIEW possibly required in link creation request
	 */
	public static final String EDGE_CREATE_REQUEST_SOURCE_VIEW = "SOURCE_GRAPHICAL_VIEW"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_GRAPHICAL_VIEW possibly required in link creation request
	 */
	public static final String EDGE_CREATE_REQUEST_TARGET_VIEW = "TARGET_GRAPHICAL_VIEW"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter RECONNECT_END_VIEW possibly required in link reconnect request
	 */
	public static final String EDGE_REORIENT_REQUEST_END_VIEW = "RECONNECT_END_VIEW"; //$NON-NLS-1$

	/**
	 * The ID to store the list of element under re-factoring.
	 */
	public static final String ASSOCIATION_REFACTORED_ELEMENTS = "ASSOCIATION_REFACTORED_ELEMENTS"; //$NON-NLS-1$

	/**
	 * The ID to store the list of element that should not be destroyed (avoid dependents destroy).
	 */
	public static final String DEPENDENTS_TO_KEEP = "DEPENDENTS_TO_KEEP"; //$NON-NLS-1$

	/**
	 * The ID to store the source figure for an edge creation
	 */
	public static final String EDGE_SOURCE_FIGURE = "EDGE_SOURCE_FIGURE"; //$NON-NLS-1$

	/**
	 * The ID to store the target figure for an edge creation
	 */
	public static final String EDGE_TARGET_FIGURE = "EDGE_TARGET_FIGURE"; //$NON-NLS-1$

	/**
	 * the ID to store the source point for an edge creation
	 */
	public static final String EDGE_SOURCE_POINT = "EDGE_SOURCE_POINT"; //$NON-NLS-1$

	/**
	 * the ID to store the target point for an edge creation
	 */
	public static final String EDGE_TARGET_POINT = "EDGE_TARGET_POINT"; //$NON-NLS-1$

	/**
	 * the ID to enable transactional nesting for the used command in edit helper.
	 */
	public static final String TRANSACTIONAL_NESTING = "TRANSACTIONAL_NESTING"; //$NON-NLS-1$

	/**
	 * the ID to store the name to be set for the new element.
	 */
	public final static String NAME_TO_SET = "nameToSet"; //$NON-NLS-1$

	/**
	 * this constant is used to precise if it is needed to launch UI during the edition of an element
	 */
	public static String USE_GUI = "USE_GUI"; //$NON-NLS-1$

	/**
	 * A boolean-valued parameter for {@link CreateRelationshipRequest} that indicates
	 * whether the creation of the relationship will modify the source element (usually
	 * because it will have an inverse reference to some element of the relationship).
	 * The default value is {@code true} if the parameter is not specified. <b>Note</b>
	 * that this is different from the {@link #AFFECTS_TARGET} parameter.
	 * 
	 * @see #AFFECTS_TARGET
	 */
	public static final String AFFECTS_SOURCE = "papyrus.affectsSource"; //$NON-NLS-1$

	/**
	 * A boolean-valued parameter for {@link CreateRelationshipRequest} that indicates
	 * whether the creation of the relationship will modify the target element (usually
	 * because it will have an inverse reference to some element of the relationship).
	 * The default value is {@code false} if the parameter is not specified. <b>Note</b>
	 * that this is different from the {@link #AFFECTS_SOURCE} parameter.
	 * 
	 * @see #AFFECTS_SOURCE
	 */
	public static final String AFFECTS_TARGET = "papyrus.affectsTarget"; //$NON-NLS-1$

	/**
	 * Constant used to indicate that the action is done in the diagram.
	 */
	public static final String TYPE_MOVING_DIAGRAM = "TYPE_MOVING_DIAGRAM"; //$NON-NLS-1$

	/**
	 * Constant used to indicate where the action is done.
	 */
	public static final String TYPE_MOVING = "TYPE_MOVING"; //$NON-NLS-1$

	/**
	 * this constant is used to precise if it is needed to make the editdialog cancellable or not
	 */
	public static String DIALOG_CANCELLABLE = "DIALOG_CANCELLABLE"; //$NON-NLS-1$

	//
	// Nested types
	//

	/**
	 * Provider of default values for request parameters that support them, defined in the
	 * {@link RequestParameterConstants} type.
	 */
	final class DefaultValues {
		/**
		 * Obtains the value of a parameter of the given {@code type} from a {@code request},
		 * returning the parameter's default value (if any such is defined) in the case that it
		 * is absent from the request.
		 * 
		 * @param request
		 *            an edit request
		 * @param parameterName
		 *            the name of the parameter to retrieve
		 * @param type
		 *            the type of the parameter
		 * 
		 * @return the parameter value, its default (if specified) in case it is absent from the
		 *         {@code request}, or the {@code type}'s default-default otherwise
		 */
		public static <T> T getValue(IEditCommandRequest request, String parameterName, Class<T> type) {
			T result;

			try {
				if (type == Boolean.class) {
					Boolean booleanResult = (Boolean) request.getParameter(parameterName);
					if (booleanResult == null) {
						booleanResult = defaultBoolean(parameterName);
					}
					result = type.cast(booleanResult);
				} else {
					result = type.cast(Defaults.defaultValue(type));
				}
			} catch (IllegalArgumentException e) {
				// The parameter doesn't specify a default
				result = type.cast(Defaults.defaultValue(type));
			}

			return result;
		}

		/**
		 * Queries the default value of a boolean-valued request parameter.
		 * 
		 * @param parameterName
		 *            the boolean-value parameter for which to obtain the default value
		 * 
		 * @return the default value
		 * 
		 * @throws IllegalArgumentException
		 *             if the parameter is not boolean-valued or if it does not have a default value
		 */
		public static boolean defaultBoolean(String parameterName) {
			switch (parameterName) {
			case AFFECTS_SOURCE:
				return true;
			case AFFECTS_TARGET:
				return false;
			default:
				throw new IllegalArgumentException("Not a boolean parameter or not defaulted: " + parameterName); //$NON-NLS-1$
			}
		}
	}
}
