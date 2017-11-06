/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Label Visibility Preference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl#getRole <em>Role</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl#getIconPathRole <em>Icon Path Role</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl#getLinkLabels <em>Link Labels</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl#getExternalNodeLabels <em>External Node Labels</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.LabelVisibilityPreferenceImpl#isVisibleByDefault <em>Visible By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LabelVisibilityPreferenceImpl extends CommentedElementImpl implements LabelVisibilityPreference {
	/**
	 * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected String role = ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIconPathRole() <em>Icon Path Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getIconPathRole()
	 * @generated
	 * @ordered
	 */
	protected static final String ICON_PATH_ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIconPathRole() <em>Icon Path Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getIconPathRole()
	 * @generated
	 * @ordered
	 */
	protected String iconPathRole = ICON_PATH_ROLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLinkLabels() <em>Link Labels</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getLinkLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<GenLinkLabel> linkLabels;

	/**
	 * The cached value of the '{@link #getExternalNodeLabels() <em>External Node Labels</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getExternalNodeLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<GenExternalNodeLabel> externalNodeLabels;

	/**
	 * The default value of the '{@link #isVisibleByDefault() <em>Visible By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isVisibleByDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_BY_DEFAULT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisibleByDefault() <em>Visible By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isVisibleByDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean visibleByDefault = VISIBLE_BY_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected LabelVisibilityPreferenceImpl() {
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
		return PapyrusgmfgenextensionPackage.Literals.LABEL_VISIBILITY_PREFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setRole(String newRole) {
		String oldRole = role;
		role = newRole;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ROLE, oldRole, role));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getIconPathRole() {
		return iconPathRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setIconPathRole(String newIconPathRole) {
		String oldIconPathRole = iconPathRole;
		iconPathRole = newIconPathRole;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE, oldIconPathRole, iconPathRole));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<GenLinkLabel> getLinkLabels() {
		if (linkLabels == null) {
			linkLabels = new EObjectResolvingEList<GenLinkLabel>(GenLinkLabel.class, this, PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__LINK_LABELS);
		}
		return linkLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<GenExternalNodeLabel> getExternalNodeLabels() {
		if (externalNodeLabels == null) {
			externalNodeLabels = new EObjectResolvingEList<GenExternalNodeLabel>(GenExternalNodeLabel.class, this, PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS);
		}
		return externalNodeLabels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isVisibleByDefault() {
		return visibleByDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setVisibleByDefault(boolean newVisibleByDefault) {
		boolean oldVisibleByDefault = visibleByDefault;
		visibleByDefault = newVisibleByDefault;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT, oldVisibleByDefault, visibleByDefault));
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
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ROLE:
			return getRole();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE:
			return getIconPathRole();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__LINK_LABELS:
			return getLinkLabels();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS:
			return getExternalNodeLabels();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT:
			return isVisibleByDefault();
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
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ROLE:
			setRole((String) newValue);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE:
			setIconPathRole((String) newValue);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__LINK_LABELS:
			getLinkLabels().clear();
			getLinkLabels().addAll((Collection<? extends GenLinkLabel>) newValue);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS:
			getExternalNodeLabels().clear();
			getExternalNodeLabels().addAll((Collection<? extends GenExternalNodeLabel>) newValue);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT:
			setVisibleByDefault((Boolean) newValue);
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
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ROLE:
			setRole(ROLE_EDEFAULT);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE:
			setIconPathRole(ICON_PATH_ROLE_EDEFAULT);
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__LINK_LABELS:
			getLinkLabels().clear();
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS:
			getExternalNodeLabels().clear();
			return;
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT:
			setVisibleByDefault(VISIBLE_BY_DEFAULT_EDEFAULT);
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
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ROLE:
			return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__ICON_PATH_ROLE:
			return ICON_PATH_ROLE_EDEFAULT == null ? iconPathRole != null : !ICON_PATH_ROLE_EDEFAULT.equals(iconPathRole);
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__LINK_LABELS:
			return linkLabels != null && !linkLabels.isEmpty();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__EXTERNAL_NODE_LABELS:
			return externalNodeLabels != null && !externalNodeLabels.isEmpty();
		case PapyrusgmfgenextensionPackage.LABEL_VISIBILITY_PREFERENCE__VISIBLE_BY_DEFAULT:
			return visibleByDefault != VISIBLE_BY_DEFAULT_EDEFAULT;
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
		result.append(" (role: ");
		result.append(role);
		result.append(", iconPathRole: ");
		result.append(iconPathRole);
		result.append(", visibleByDefault: ");
		result.append(visibleByDefault);
		result.append(')');
		return result.toString();
	}

} // LabelVisibilityPreferenceImpl
