/**
 * Copyright (c) 2014 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.dd.dg;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Path</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Path is a marked element that defines a custom shape whose geometry is specified with a sequence of path commands.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.dd.dg.Path#getCommands <em>Command</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.dd.dg.DGPackage#getPath()
 * @model
 * @generated
 */
public interface Path extends MarkedElement {

	/**
	 * Returns the value of the '<em><b>Command</b></em>' containment reference
	 * list. The list contents are of type {@link org.eclipse.papyrus.dd.dg.PathCommand}. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> a list of path commands
	 * that define the geometry of the custom shape. <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Command</em>' containment reference list.
	 * @see org.eclipse.papyrus.dd.dg.DGPackage#getPath_Command()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<PathCommand> getCommands();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * @param diagnostics
	 *        The chain of diagnostics to which problems are to be appended.
	 * @param context
	 *        The cache of context-specific information. <!-- end-model-doc
	 *        -->
	 * @model annotation=
	 *        "http://www.eclipse.org/emf/2002/Ecore/OCL body='command->first().oclIsKindOf(MoveTo)'"
	 * @generated
	 */
	boolean firstCommandMustBeMove(DiagnosticChain diagnostics, Map<Object, Object> context);
} // Path
