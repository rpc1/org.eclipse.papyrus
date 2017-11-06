/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Volatile</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_parameter <em>Base parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_property <em>Base property</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_operation <em>Base operation</em>}</li>
 * </ul>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVolatile()
 * @model
 * @generated
 */
public interface Volatile extends EObject {
	/**
	 * Returns the value of the '<em><b>Base parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base parameter</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base parameter</em>' reference.
	 * @see #setBase_parameter(Parameter)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVolatile_Base_parameter()
	 * @model ordered="false"
	 * @generated
	 */
	Parameter getBase_parameter();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_parameter <em>Base parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base parameter</em>' reference.
	 * @see #getBase_parameter()
	 * @generated
	 */
	void setBase_parameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Base property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base property</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base property</em>' reference.
	 * @see #setBase_property(Property)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVolatile_Base_property()
	 * @model ordered="false"
	 * @generated
	 */
	Property getBase_property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_property <em>Base property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base property</em>' reference.
	 * @see #getBase_property()
	 * @generated
	 */
	void setBase_property(Property value);

	/**
	 * Returns the value of the '<em><b>Base operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base operation</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base operation</em>' reference.
	 * @see #setBase_operation(Operation)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVolatile_Base_operation()
	 * @model ordered="false"
	 * @generated
	 */
	Operation getBase_operation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Volatile#getBase_operation <em>Base operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base operation</em>' reference.
	 * @see #getBase_operation()
	 * @generated
	 */
	void setBase_operation(Operation value);

} // Volatile
