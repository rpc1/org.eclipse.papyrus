/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage;
import org.eclipse.papyrus.design.profile.architecture.LayerDependency;
import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl#isDeprecated <em>Is Deprecated</em>}</li>
 * <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl#getDeprecatedComment <em>Deprecated Comment</em>}</li>
 * <li>{@link org.eclipse.papyrus.design.profile.architecture.impl.LayerDependencyImpl#getBase_Dependency <em>Base Dependency</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerDependencyImpl extends ElementImpl implements LayerDependency {
	/**
	 * The default value of the '{@link #isDeprecated() <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEPRECATED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDeprecated() <em>Is Deprecated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isDeprecated()
	 * @generated
	 * @ordered
	 */
	protected boolean isDeprecated = IS_DEPRECATED_EDEFAULT;
	/**
	 * The default value of the '{@link #getDeprecatedComment() <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDeprecatedComment()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPRECATED_COMMENT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDeprecatedComment() <em>Deprecated Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getDeprecatedComment()
	 * @generated
	 * @ordered
	 */
	protected String deprecatedComment = DEPRECATED_COMMENT_EDEFAULT;
	/**
	 * The cached value of the '{@link #getBase_Dependency() <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getBase_Dependency()
	 * @generated
	 * @ordered
	 */
	protected Dependency base_Dependency;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected LayerDependencyImpl() {
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
		return ArchitecturePackage.Literals.LAYER_DEPENDENCY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isDeprecated() {
		return isDeprecated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIsDeprecated(boolean newIsDeprecated) {
		boolean oldIsDeprecated = isDeprecated;
		isDeprecated = newIsDeprecated;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER_DEPENDENCY__IS_DEPRECATED, oldIsDeprecated, isDeprecated));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getDeprecatedComment() {
		return deprecatedComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setDeprecatedComment(String newDeprecatedComment) {
		String oldDeprecatedComment = deprecatedComment;
		deprecatedComment = newDeprecatedComment;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER_DEPENDENCY__DEPRECATED_COMMENT, oldDeprecatedComment, deprecatedComment));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Dependency getBase_Dependency() {
		if (base_Dependency != null && base_Dependency.eIsProxy()) {
			InternalEObject oldBase_Dependency = (InternalEObject) base_Dependency;
			base_Dependency = (Dependency) eResolveProxy(oldBase_Dependency);
			if (base_Dependency != oldBase_Dependency) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
				}
			}
		}
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Dependency basicGetBase_Dependency() {
		return base_Dependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setBase_Dependency(Dependency newBase_Dependency) {
		Dependency oldBase_Dependency = base_Dependency;
		base_Dependency = newBase_Dependency;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY, oldBase_Dependency, base_Dependency));
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
		case ArchitecturePackage.LAYER_DEPENDENCY__IS_DEPRECATED:
			return isDeprecated();
		case ArchitecturePackage.LAYER_DEPENDENCY__DEPRECATED_COMMENT:
			return getDeprecatedComment();
		case ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY:
			if (resolve) {
				return getBase_Dependency();
			}
			return basicGetBase_Dependency();
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
		case ArchitecturePackage.LAYER_DEPENDENCY__IS_DEPRECATED:
			setIsDeprecated((Boolean) newValue);
			return;
		case ArchitecturePackage.LAYER_DEPENDENCY__DEPRECATED_COMMENT:
			setDeprecatedComment((String) newValue);
			return;
		case ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY:
			setBase_Dependency((Dependency) newValue);
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
		case ArchitecturePackage.LAYER_DEPENDENCY__IS_DEPRECATED:
			setIsDeprecated(IS_DEPRECATED_EDEFAULT);
			return;
		case ArchitecturePackage.LAYER_DEPENDENCY__DEPRECATED_COMMENT:
			setDeprecatedComment(DEPRECATED_COMMENT_EDEFAULT);
			return;
		case ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY:
			setBase_Dependency((Dependency) null);
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
		case ArchitecturePackage.LAYER_DEPENDENCY__IS_DEPRECATED:
			return isDeprecated != IS_DEPRECATED_EDEFAULT;
		case ArchitecturePackage.LAYER_DEPENDENCY__DEPRECATED_COMMENT:
			return DEPRECATED_COMMENT_EDEFAULT == null ? deprecatedComment != null : !DEPRECATED_COMMENT_EDEFAULT.equals(deprecatedComment);
		case ArchitecturePackage.LAYER_DEPENDENCY__BASE_DEPENDENCY:
			return base_Dependency != null;
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
		result.append(" (isDeprecated: ");
		result.append(isDeprecated);
		result.append(", deprecatedComment: ");
		result.append(deprecatedComment);
		result.append(')');
		return result.toString();
	}

} // LayerDependencyImpl
