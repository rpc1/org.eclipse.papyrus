/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.emf.newchild.MenuRoot;
import org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;
import org.eclipse.papyrus.infra.emf.newchild.ncpolicy.NewChildPolicySet;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.NewchildConfigurationImpl#getRoots <em>Roots</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.NewchildConfigurationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.emf.newchild.impl.NewchildConfigurationImpl#getNewChildPolicies <em>New Child Policies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NewchildConfigurationImpl extends EObjectImpl implements NewchildConfiguration {
	/**
	 * The cached value of the '{@link #getRoots() <em>Roots</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<MenuRoot> roots;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNewChildPolicies() <em>New Child Policies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getNewChildPolicies()
	 * @generated
	 * @ordered
	 */
	protected EList<NewChildPolicySet> newChildPolicies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected NewchildConfigurationImpl() {
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
		return NewchildPackage.Literals.NEWCHILD_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<MenuRoot> getRoots() {
		if (roots == null) {
			roots = new EObjectContainmentEList<MenuRoot>(MenuRoot.class, this, NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS);
		}
		return roots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, NewchildPackage.NEWCHILD_CONFIGURATION__NAME, oldName, name));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<NewChildPolicySet> getNewChildPolicies() {
		if (newChildPolicies == null) {
			newChildPolicies = new EObjectContainmentEList<NewChildPolicySet>(NewChildPolicySet.class, this, NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES);
		}
		return newChildPolicies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
			return ((InternalEList<?>) getRoots()).basicRemove(otherEnd, msgs);
		case NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES:
			return ((InternalEList<?>) getNewChildPolicies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
			return getRoots();
		case NewchildPackage.NEWCHILD_CONFIGURATION__NAME:
			return getName();
		case NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES:
			return getNewChildPolicies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
			getRoots().clear();
			getRoots().addAll((Collection<? extends MenuRoot>) newValue);
			return;
		case NewchildPackage.NEWCHILD_CONFIGURATION__NAME:
			setName((String) newValue);
			return;
		case NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES:
			getNewChildPolicies().clear();
			getNewChildPolicies().addAll((Collection<? extends NewChildPolicySet>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
			getRoots().clear();
			return;
		case NewchildPackage.NEWCHILD_CONFIGURATION__NAME:
			setName(NAME_EDEFAULT);
			return;
		case NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES:
			getNewChildPolicies().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case NewchildPackage.NEWCHILD_CONFIGURATION__ROOTS:
			return roots != null && !roots.isEmpty();
		case NewchildPackage.NEWCHILD_CONFIGURATION__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case NewchildPackage.NEWCHILD_CONFIGURATION__NEW_CHILD_POLICIES:
			return newChildPolicies != null && !newChildPolicies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // NewchildConfigurationImpl
