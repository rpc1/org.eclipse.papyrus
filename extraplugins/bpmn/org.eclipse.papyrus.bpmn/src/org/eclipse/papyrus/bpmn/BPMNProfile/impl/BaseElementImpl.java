/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNAssociation;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.BaseElement;
import org.eclipse.papyrus.bpmn.BPMNProfile.Documentation;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionAttributeValue;
import org.eclipse.papyrus.bpmn.BPMNProfile.ExtensionDefinition;

import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getExtensionValues <em>Extension Values</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getBase_Element <em>Base Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getExtensionDefinitions <em>Extension Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.BaseElementImpl#getIncoming <em>Incoming</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BaseElementImpl extends MinimalEObjectImpl.Container implements BaseElement {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtensionValues() <em>Extension Values</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionAttributeValue> extensionValues;

	/**
	 * The cached value of the '{@link #getBase_Element() <em>Base Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Element()
	 * @generated
	 * @ordered
	 */
	protected Element base_Element;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected EList<Documentation> documentation;

	/**
	 * The cached value of the '{@link #getExtensionDefinitions() <em>Extension Definitions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtensionDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtensionDefinition> extensionDefinitions;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNAssociation> outgoing;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<BPMNAssociation> incoming;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getBaseElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BASE_ELEMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionAttributeValue> getExtensionValues() {
		if (extensionValues == null) {
			extensionValues = new EObjectResolvingEList<ExtensionAttributeValue>(ExtensionAttributeValue.class, this, BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES);
		}
		return extensionValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getBase_Element() {
		if (base_Element != null && base_Element.eIsProxy()) {
			InternalEObject oldBase_Element = (InternalEObject)base_Element;
			base_Element = (Element)eResolveProxy(oldBase_Element);
			if (base_Element != oldBase_Element) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT, oldBase_Element, base_Element));
			}
		}
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetBase_Element() {
		return base_Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Element(Element newBase_Element) {
		Element oldBase_Element = base_Element;
		base_Element = newBase_Element;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT, oldBase_Element, base_Element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Documentation> getDocumentation() {
		if (documentation == null) {
			documentation = new EObjectResolvingEList<Documentation>(Documentation.class, this, BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION);
		}
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtensionDefinition> getExtensionDefinitions() {
		if (extensionDefinitions == null) {
			extensionDefinitions = new EObjectResolvingEList<ExtensionDefinition>(ExtensionDefinition.class, this, BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS);
		}
		return extensionDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNAssociation> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<BPMNAssociation>(BPMNAssociation.class, this, BPMNProfilePackage.BASE_ELEMENT__OUTGOING, BPMNProfilePackage.BPMN_ASSOCIATION__SOURCE_REF);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BPMNAssociation> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<BPMNAssociation>(BPMNAssociation.class, this, BPMNProfilePackage.BASE_ELEMENT__INCOMING, BPMNProfilePackage.BPMN_ASSOCIATION__TARGET_REF);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				return getId();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				return getExtensionValues();
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				if (resolve) return getBase_Element();
				return basicGetBase_Element();
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				return getDocumentation();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				return getExtensionDefinitions();
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				return getOutgoing();
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				return getIncoming();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				setId((String)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				getExtensionValues().clear();
				getExtensionValues().addAll((Collection<? extends ExtensionAttributeValue>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				setBase_Element((Element)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				getDocumentation().clear();
				getDocumentation().addAll((Collection<? extends Documentation>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				getExtensionDefinitions().addAll((Collection<? extends ExtensionDefinition>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends BPMNAssociation>)newValue);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends BPMNAssociation>)newValue);
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
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				setId(ID_EDEFAULT);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				getExtensionValues().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				setBase_Element((Element)null);
				return;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				getDocumentation().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				getExtensionDefinitions().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				getOutgoing().clear();
				return;
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				getIncoming().clear();
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
			case BPMNProfilePackage.BASE_ELEMENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_VALUES:
				return extensionValues != null && !extensionValues.isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__BASE_ELEMENT:
				return base_Element != null;
			case BPMNProfilePackage.BASE_ELEMENT__DOCUMENTATION:
				return documentation != null && !documentation.isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__EXTENSION_DEFINITIONS:
				return extensionDefinitions != null && !extensionDefinitions.isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case BPMNProfilePackage.BASE_ELEMENT__INCOMING:
				return incoming != null && !incoming.isEmpty();
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //BaseElementImpl
