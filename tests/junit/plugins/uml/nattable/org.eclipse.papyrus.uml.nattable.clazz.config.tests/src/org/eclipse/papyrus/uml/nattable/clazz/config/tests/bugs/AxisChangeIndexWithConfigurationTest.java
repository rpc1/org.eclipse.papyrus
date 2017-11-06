/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.nattable.clazz.config.tests.bugs;

import org.eclipse.papyrus.junit.utils.rules.PluginResource;

/**
 * This allow to test the change index style for the table with configuration.
 */
@PluginResource("resources/bugs/bug473155/AxisChangeIndexWithConfigurationTest.di")
public class AxisChangeIndexWithConfigurationTest extends AbstractAxisChangeIndexTest {

	/**
	 * Constructor.
	 */
	public AxisChangeIndexWithConfigurationTest() {
		super();
	}

}
