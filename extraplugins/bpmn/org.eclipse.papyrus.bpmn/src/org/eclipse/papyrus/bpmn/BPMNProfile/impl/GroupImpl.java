/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.CategoryValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.Group;

import org.eclipse.uml2.uml.ActivityPartition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GroupImpl#getBase_ActivityPartition <em>Base Activity Partition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.GroupImpl#get_categoryValueRef <em>category Value Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GroupImpl extends BPMNArtifactImpl implements Group {
	/**
	 * The cached value of the '{@link #getBase_ActivityPartition() <em>Base Activity Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ActivityPartition()
	 * @generated
	 * @ordered
	 */
	protected ActivityPartition base_ActivityPartition;

	/**
	 * The cached value of the '{@link #get_categoryValueRef() <em>category Value Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_categoryValueRef()
	 * @generated
	 * @ordered
	 */
	protected CategoryValue _categoryValueRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPartition getBase_ActivityPartition() {
		if (base_ActivityPartition != null && base_ActivityPartition.eIsProxy()) {
			InternalEObject oldBase_ActivityPartition = (InternalEObject)base_ActivityPartition;
			base_ActivityPartition = (ActivityPartition)eResolveProxy(oldBase_ActivityPartition);
			if (base_ActivityPartition != oldBase_ActivityPartition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
			}
		}
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPartition basicGetBase_ActivityPartition() {
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ActivityPartition(ActivityPartition newBase_ActivityPartition) {
		ActivityPartition oldBase_ActivityPartition = base_ActivityPartition;
		base_ActivityPartition = newBase_ActivityPartition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryValue get_categoryValueRef() {
		if (_categoryValueRef != null && _categoryValueRef.eIsProxy()) {
			InternalEObject old_categoryValueRef = (InternalEObject)_categoryValueRef;
			_categoryValueRef = (CategoryValue)eResolveProxy(old_categoryValueRef);
			if (_categoryValueRef != old_categoryValueRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF, old_categoryValueRef, _categoryValueRef));
			}
		}
		return _categoryValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryValue basicGet_categoryValueRef() {
		return _categoryValueRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_categoryValueRef(CategoryValue new_categoryValueRef) {
		CategoryValue old_categoryValueRef = _categoryValueRef;
		_categoryValueRef = new_categoryValueRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF, old_categoryValueRef, _categoryValueRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION:
				if (resolve) return getBase_ActivityPartition();
				return basicGetBase_ActivityPartition();
			case BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF:
				if (resolve) return get_categoryValueRef();
				return basicGet_categoryValueRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)newValue);
				return;
			case BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF:
				set_categoryValueRef((CategoryValue)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)null);
				return;
			case BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF:
				set_categoryValueRef((CategoryValue)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BPMNProfilePackage.GROUP__BASE_ACTIVITY_PARTITION:
				return base_ActivityPartition != null;
			case BPMNProfilePackage.GROUP__CATEGORY_VALUE_REF:
				return _categoryValueRef != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupImpl
