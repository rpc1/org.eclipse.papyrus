/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	private static final String BUNDLE_NAME = "org.eclipse.papyrus.uml.diagram.composite.custom.messages.messages"; //$NON-NLS-1$

	/**
	 * @deprecated. Commands/dialogs have been moved to oep.uml.service.types.command
	 */
	@Deprecated
	public static String CollaborationRoleSelectionDialog_Title;

	@Deprecated
	public static String CollaborationRoleSelectionDialog_Message;

	@Deprecated
	public static String ConnectorCreateCommand_INVALID_ARGS_MSG;

	@Deprecated
	public static String ConnectorCreateCommand_INVALID_SOURCE_MSG;

	@Deprecated
	public static String ConnectorCreateCommand_INVALID_TARGET_MSG;

	@Deprecated
	public static String RoleBindingCreateCommand_INVALID_ARGS_MSG;

	@Deprecated
	public static String RoleBindingRoleSelectionDialog_Title;

	@Deprecated
	public static String RoleBindingRoleSelectionDialog_Message;

	@Deprecated
	public static String InformationFlowSelectionDialog_Title;

	@Deprecated
	public static String InformationFlowSelectionDialog_Message;

	@Deprecated
	public static String InformationItemGetNameDialog_Error_Message;

	public static String SelectionValidated;

	public static String ShowHideRelatedContentsAction_Message;

	public static String ShowHideRelatedContentsAction_Title;

	public static String InformationFlowSelectInformationItem_ERROR;

	public static String NoSelectionFound;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
