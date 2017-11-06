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

package org.eclipse.papyrus.uml.nattable.clazz.config.tests.creation.outside;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.junit.utils.rules.ActiveTable;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author VL222926
 *
 */
public class AbstractCreateElementDepth2_Test extends AbstractCreateElementTableTest {

	private static final String CLASS1 = "Class1"; //$NON-NLS-1$

	private static final String OPERATION1 = "Operation1"; //$NON-NLS-1$

	private static final int NB_ROWS_BEFORE_CREATION = 4;

	private static final int NB_ROWS_AFTER_CREATION = 6;

	/**
	 * this test check the content and the display of the table after a creation of an element outside of the table
	 */
	@Test
	@ActiveTable("ClassTreeTable")
	public void createParameterElement() {
		startTest();
		Table table = this.manager.getTable();
		EObject context = table.getContext();
		Assert.assertTrue(context instanceof Model);
		Model model = (Model) context;
		Class clazz = (Class) model.getMember(CLASS1);
		Assert.assertNotNull(clazz);
		Operation op = (Operation) clazz.getMember(OPERATION1);
		Assert.assertNotNull(op);
		createElement(op, UMLElementTypes.PARAMETER, NB_ROWS_BEFORE_CREATION, NB_ROWS_AFTER_CREATION);
	}
}
