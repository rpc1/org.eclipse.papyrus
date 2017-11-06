/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Command Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.CommandDeclaration#getCommands <em>Commands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getCommandDeclaration()
 * @model
 * @generated
 */
public interface CommandDeclaration extends EObject {

	/**
	 * Returns the value of the '<em><b>Commands</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.domaincontextcodegen.Command}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commands</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Commands</em>' containment reference list.
	 * @see org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage#getCommandDeclaration_Commands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Command> getCommands();

} // CommandDeclaration
