/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.TextAnnotation;

import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TextAnnotationImpl#getBase_Comment <em>Base Comment</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TextAnnotationImpl#getTextFormat <em>Text Format</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.TextAnnotationImpl#getText <em>Text</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TextAnnotationImpl extends BPMNArtifactImpl implements TextAnnotation {
	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * The default value of the '{@link #getTextFormat() <em>Text Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextFormat() <em>Text Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextFormat()
	 * @generated
	 * @ordered
	 */
	protected String textFormat = TEXT_FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getTextAnnotation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment getBase_Comment() {
		if (base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if (base_Comment != oldBase_Comment) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextFormat() {
		return textFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextFormat(String newTextFormat) {
		String oldTextFormat = textFormat;
		textFormat = newTextFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.TEXT_ANNOTATION__TEXT_FORMAT, oldTextFormat, textFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.TEXT_ANNOTATION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT:
				if (resolve) return getBase_Comment();
				return basicGetBase_Comment();
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT_FORMAT:
				return getTextFormat();
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT:
				return getText();
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
			case BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT:
				setBase_Comment((Comment)newValue);
				return;
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT_FORMAT:
				setTextFormat((String)newValue);
				return;
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT:
				setText((String)newValue);
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
			case BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT:
				setBase_Comment((Comment)null);
				return;
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT_FORMAT:
				setTextFormat(TEXT_FORMAT_EDEFAULT);
				return;
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT:
				setText(TEXT_EDEFAULT);
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
			case BPMNProfilePackage.TEXT_ANNOTATION__BASE_COMMENT:
				return base_Comment != null;
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT_FORMAT:
				return TEXT_FORMAT_EDEFAULT == null ? textFormat != null : !TEXT_FORMAT_EDEFAULT.equals(textFormat);
			case BPMNProfilePackage.TEXT_ANNOTATION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (textFormat: ");
		result.append(textFormat);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //TextAnnotationImpl
