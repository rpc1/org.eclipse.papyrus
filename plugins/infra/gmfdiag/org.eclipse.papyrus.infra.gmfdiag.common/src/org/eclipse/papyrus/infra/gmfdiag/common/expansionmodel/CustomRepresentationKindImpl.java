/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * @author PT202707
 *
 */
public class CustomRepresentationKindImpl extends org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.impl.RepresentationKindImpl {

	public boolean validate(DiagnosticChain diagnostic, Map context) {
		return ExpansionModelValidationUtil.validate_loadclasses(this, diagnostic, context);
	}
}
