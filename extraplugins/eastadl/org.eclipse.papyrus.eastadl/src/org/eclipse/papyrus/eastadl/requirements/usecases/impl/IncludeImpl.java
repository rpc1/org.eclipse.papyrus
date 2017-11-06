/**
 */
package org.eclipse.papyrus.eastadl.requirements.usecases.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RelationshipImpl;
import org.eclipse.papyrus.eastadl.requirements.usecases.Include;
import org.eclipse.papyrus.eastadl.requirements.usecases.UseCase;
import org.eclipse.papyrus.eastadl.requirements.usecases.UsecasesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Include</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.usecases.impl.IncludeImpl#getBase_Include <em>Base Include</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.requirements.usecases.impl.IncludeImpl#getAddition <em>Addition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncludeImpl extends RelationshipImpl implements Include {
	/**
	 * The cached value of the '{@link #getBase_Include() <em>Base Include</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBase_Include()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Include base_Include;

	/**
	 * The cached value of the '{@link #getAddition() <em>Addition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAddition()
	 * @generated
	 * @ordered
	 */
	protected UseCase addition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected IncludeImpl() {
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
		return UsecasesPackage.Literals.INCLUDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public org.eclipse.uml2.uml.Include getBase_Include() {
		if (base_Include != null && base_Include.eIsProxy()) {
			InternalEObject oldBase_Include = (InternalEObject) base_Include;
			base_Include = (org.eclipse.uml2.uml.Include) eResolveProxy(oldBase_Include);
			if (base_Include != oldBase_Include) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasesPackage.INCLUDE__BASE_INCLUDE, oldBase_Include, base_Include));
				}
			}
		}
		return base_Include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public org.eclipse.uml2.uml.Include basicGetBase_Include() {
		return base_Include;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBase_Include(org.eclipse.uml2.uml.Include newBase_Include) {
		org.eclipse.uml2.uml.Include oldBase_Include = base_Include;
		base_Include = newBase_Include;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasesPackage.INCLUDE__BASE_INCLUDE, oldBase_Include, base_Include));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public UseCase getAddition() {
		if (addition != null && addition.eIsProxy()) {
			InternalEObject oldAddition = (InternalEObject) addition;
			addition = (UseCase) eResolveProxy(oldAddition);
			if (addition != oldAddition) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsecasesPackage.INCLUDE__ADDITION, oldAddition, addition));
				}
			}
		}
		return addition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public UseCase basicGetAddition() {
		return addition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setAddition(UseCase newAddition) {
		UseCase oldAddition = addition;
		addition = newAddition;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, UsecasesPackage.INCLUDE__ADDITION, oldAddition, addition));
		}
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
		case UsecasesPackage.INCLUDE__BASE_INCLUDE:
			if (resolve) {
				return getBase_Include();
			}
			return basicGetBase_Include();
		case UsecasesPackage.INCLUDE__ADDITION:
			if (resolve) {
				return getAddition();
			}
			return basicGetAddition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UsecasesPackage.INCLUDE__BASE_INCLUDE:
			setBase_Include((org.eclipse.uml2.uml.Include) newValue);
			return;
		case UsecasesPackage.INCLUDE__ADDITION:
			setAddition((UseCase) newValue);
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
		case UsecasesPackage.INCLUDE__BASE_INCLUDE:
			setBase_Include((org.eclipse.uml2.uml.Include) null);
			return;
		case UsecasesPackage.INCLUDE__ADDITION:
			setAddition((UseCase) null);
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
		case UsecasesPackage.INCLUDE__BASE_INCLUDE:
			return base_Include != null;
		case UsecasesPackage.INCLUDE__ADDITION:
			return addition != null;
		}
		return super.eIsSet(featureID);
	}

} // IncludeImpl