/**
 * Copyright (c) 2013 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Action Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ViewActionConfigurationImpl extends ActionConfigurationImpl implements ViewActionConfiguration {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ViewActionConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtendedtypesPackage.eINSTANCE.getViewActionConfiguration();
	}
} // ViewActionConfigurationImpl
