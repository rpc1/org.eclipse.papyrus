/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.migration.rsa.umlnotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.papyrus.migration.rsa.umlnotation.PapyrusUMLNotationPackage;
import org.eclipse.papyrus.migration.rsa.umlnotation.UMLDiagram;
import org.eclipse.papyrus.migration.rsa.umlnotation.UMLView;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#getShowStereotype <em>Show Stereotype</em>}</li>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#getShowListVisibility <em>Show List Visibility</em>}</li>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#isShowListSignature <em>Show List Signature</em>}</li>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#getAlignment <em>Alignment</em>}</li>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#getShowStereotypeAttributeCompartment <em>Show Stereotype Attribute Compartment</em>}</li>
 * <li>{@link org.eclipse.papyrus.migration.rsa.umlnotation.impl.UMLDiagramImpl#getShowListStereotype <em>Show List Stereotype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UMLDiagramImpl extends DiagramImpl implements UMLDiagram {

	/**
	 * The default value of the '{@link #getShowStereotype() <em>Show Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowStereotype() <em>Show Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowStereotype()
	 * @generated
	 * @ordered
	 */
	protected String showStereotype = SHOW_STEREOTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowListVisibility() <em>Show List Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowListVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_LIST_VISIBILITY_EDEFAULT = "None";

	/**
	 * The cached value of the '{@link #getShowListVisibility() <em>Show List Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowListVisibility()
	 * @generated
	 * @ordered
	 */
	protected String showListVisibility = SHOW_LIST_VISIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isShowListSignature() <em>Show List Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isShowListSignature()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SHOW_LIST_SIGNATURE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isShowListSignature() <em>Show List Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #isShowListSignature()
	 * @generated
	 * @ordered
	 */
	protected boolean showListSignature = SHOW_LIST_SIGNATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIGNMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlignment() <em>Alignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAlignment()
	 * @generated
	 * @ordered
	 */
	protected String alignment = ALIGNMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowStereotypeAttributeCompartment() <em>Show Stereotype Attribute Compartment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowStereotypeAttributeCompartment()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowStereotypeAttributeCompartment() <em>Show Stereotype Attribute Compartment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowStereotypeAttributeCompartment()
	 * @generated
	 * @ordered
	 */
	protected String showStereotypeAttributeCompartment = SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getShowListStereotype() <em>Show List Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowListStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final String SHOW_LIST_STEREOTYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getShowListStereotype() <em>Show List Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getShowListStereotype()
	 * @generated
	 * @ordered
	 */
	protected String showListStereotype = SHOW_LIST_STEREOTYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected UMLDiagramImpl() {
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
		return PapyrusUMLNotationPackage.Literals.UML_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getShowStereotype() {
		return showStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setShowStereotype(String newShowStereotype) {
		String oldShowStereotype = showStereotype;
		showStereotype = newShowStereotype;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE, oldShowStereotype, showStereotype));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getShowListVisibility() {
		return showListVisibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setShowListVisibility(String newShowListVisibility) {
		String oldShowListVisibility = showListVisibility;
		showListVisibility = newShowListVisibility;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY, oldShowListVisibility, showListVisibility));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean isShowListSignature() {
		return showListSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setShowListSignature(boolean newShowListSignature) {
		boolean oldShowListSignature = showListSignature;
		showListSignature = newShowListSignature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE, oldShowListSignature, showListSignature));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getAlignment() {
		return alignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setAlignment(String newAlignment) {
		String oldAlignment = alignment;
		alignment = newAlignment;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT, oldAlignment, alignment));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getShowStereotypeAttributeCompartment() {
		return showStereotypeAttributeCompartment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setShowStereotypeAttributeCompartment(String newShowStereotypeAttributeCompartment) {
		String oldShowStereotypeAttributeCompartment = showStereotypeAttributeCompartment;
		showStereotypeAttributeCompartment = newShowStereotypeAttributeCompartment;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT, oldShowStereotypeAttributeCompartment, showStereotypeAttributeCompartment));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getShowListStereotype() {
		return showListStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setShowListStereotype(String newShowListStereotype) {
		String oldShowListStereotype = showListStereotype;
		showListStereotype = newShowListStereotype;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE, oldShowListStereotype, showListStereotype));
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
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE:
			return getShowStereotype();
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY:
			return getShowListVisibility();
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE:
			return isShowListSignature();
		case PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT:
			return getAlignment();
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
			return getShowStereotypeAttributeCompartment();
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE:
			return getShowListStereotype();
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
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE:
			setShowStereotype((String) newValue);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY:
			setShowListVisibility((String) newValue);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE:
			setShowListSignature((Boolean) newValue);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT:
			setAlignment((String) newValue);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
			setShowStereotypeAttributeCompartment((String) newValue);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE:
			setShowListStereotype((String) newValue);
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
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE:
			setShowStereotype(SHOW_STEREOTYPE_EDEFAULT);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY:
			setShowListVisibility(SHOW_LIST_VISIBILITY_EDEFAULT);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE:
			setShowListSignature(SHOW_LIST_SIGNATURE_EDEFAULT);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT:
			setAlignment(ALIGNMENT_EDEFAULT);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
			setShowStereotypeAttributeCompartment(SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT_EDEFAULT);
			return;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE:
			setShowListStereotype(SHOW_LIST_STEREOTYPE_EDEFAULT);
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
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE:
			return SHOW_STEREOTYPE_EDEFAULT == null ? showStereotype != null : !SHOW_STEREOTYPE_EDEFAULT.equals(showStereotype);
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY:
			return SHOW_LIST_VISIBILITY_EDEFAULT == null ? showListVisibility != null : !SHOW_LIST_VISIBILITY_EDEFAULT.equals(showListVisibility);
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE:
			return showListSignature != SHOW_LIST_SIGNATURE_EDEFAULT;
		case PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT:
			return ALIGNMENT_EDEFAULT == null ? alignment != null : !ALIGNMENT_EDEFAULT.equals(alignment);
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
			return SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT_EDEFAULT == null ? showStereotypeAttributeCompartment != null : !SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT_EDEFAULT.equals(showStereotypeAttributeCompartment);
		case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE:
			return SHOW_LIST_STEREOTYPE_EDEFAULT == null ? showListStereotype != null : !SHOW_LIST_STEREOTYPE_EDEFAULT.equals(showListStereotype);
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == UMLView.class) {
			switch (derivedFeatureID) {
			case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE:
				return PapyrusUMLNotationPackage.UML_VIEW__SHOW_STEREOTYPE;
			case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY:
				return PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_VISIBILITY;
			case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE:
				return PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_SIGNATURE;
			case PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT:
				return PapyrusUMLNotationPackage.UML_VIEW__ALIGNMENT;
			case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
				return PapyrusUMLNotationPackage.UML_VIEW__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT;
			case PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE:
				return PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_STEREOTYPE;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == UMLView.class) {
			switch (baseFeatureID) {
			case PapyrusUMLNotationPackage.UML_VIEW__SHOW_STEREOTYPE:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE;
			case PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_VISIBILITY:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_VISIBILITY;
			case PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_SIGNATURE:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_SIGNATURE;
			case PapyrusUMLNotationPackage.UML_VIEW__ALIGNMENT:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__ALIGNMENT;
			case PapyrusUMLNotationPackage.UML_VIEW__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_STEREOTYPE_ATTRIBUTE_COMPARTMENT;
			case PapyrusUMLNotationPackage.UML_VIEW__SHOW_LIST_STEREOTYPE:
				return PapyrusUMLNotationPackage.UML_DIAGRAM__SHOW_LIST_STEREOTYPE;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (showStereotype: ");
		result.append(showStereotype);
		result.append(", showListVisibility: ");
		result.append(showListVisibility);
		result.append(", showListSignature: ");
		result.append(showListSignature);
		result.append(", alignment: ");
		result.append(alignment);
		result.append(", showStereotypeAttributeCompartment: ");
		result.append(showStereotypeAttributeCompartment);
		result.append(", showListStereotype: ");
		result.append(showListStereotype);
		result.append(')');
		return result.toString();
	}

} // UMLDiagramImpl
