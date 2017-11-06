/*****************************************************************************
 * Copyright (c) 2012 Cedric Dumoulin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.serviceregistry.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.papyrus.infra.core.serviceregistry.annotations.Service.StartupKind;



/**
 * @author cedric dumoulin
 *
 */
// Annotation accessible at runtime
@Retention(RetentionPolicy.RUNTIME)
// Annotation associated to (Class, interface)
@Target(ElementType.TYPE)
public @interface ServiceFactory {

	/*
	 * Service Id
	 */
	String id() default Service.ID_NOT_SET;

	/**
	 * Kind of startup requested for the service.
	 *
	 * @return
	 */
	StartupKind startupKind() default StartupKind.lazy;

	/**
	 * Service priority level. Default is 0.
	 *
	 * @return
	 */
	int priority() default 0;

}
