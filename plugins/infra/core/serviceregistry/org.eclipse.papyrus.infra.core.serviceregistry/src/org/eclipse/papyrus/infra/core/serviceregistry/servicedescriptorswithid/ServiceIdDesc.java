/**
 */
package org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Desc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getStartKind <em>Start Kind</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getClassname <em>Classname</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getInjections <em>Injections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getServiceIdDesc()
 * @model
 * @generated
 */
public interface ServiceIdDesc extends AbstractServiceIdDesc {
	/**
	 * Returns the value of the '<em><b>Start Kind</b></em>' attribute.
	 * The default value is <code>"lazy"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Kind</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Start Kind</em>' attribute.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind
	 * @see #setStartKind(StartupKind)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getServiceIdDesc_StartKind()
	 * @model default="lazy" required="true" ordered="false"
	 * @generated
	 */
	StartupKind getStartKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getStartKind <em>Start Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Start Kind</em>' attribute.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.StartupKind
	 * @see #getStartKind()
	 * @generated
	 */
	void setStartKind(StartupKind value);

	/**
	 * Returns the value of the '<em><b>Classname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classname</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Classname</em>' attribute.
	 * @see #setClassname(String)
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getServiceIdDesc_Classname()
	 * @model dataType="org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.String" required="true" ordered="false"
	 * @generated
	 */
	String getClassname();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServiceIdDesc#getClassname <em>Classname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Classname</em>' attribute.
	 * @see #getClassname()
	 * @generated
	 */
	void setClassname(String value);

	/**
	 * Returns the value of the '<em><b>Injections</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.FeatureInjection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Injections</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Injections</em>' containment reference list.
	 * @see org.eclipse.papyrus.infra.core.serviceregistry.servicedescriptorswithid.ServicedescriptorswithidPackage#getServiceIdDesc_Injections()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FeatureInjection> getInjections();

} // ServiceIdDesc
