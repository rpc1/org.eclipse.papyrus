/**
 */
package org.eclipse.papyrus.bpmn.BPMNProfile.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataInput;
import org.eclipse.papyrus.bpmn.BPMNProfile.InputSet;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#isCollection <em>Is Collection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getBase_InputPin <em>Base Input Pin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getBase_Parameter <em>Base Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getInputSetRefs <em>Input Set Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getInputSetWithOptional <em>Input Set With Optional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataInputImpl#getInputSetWithWhileExecuting <em>Input Set With While Executing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataInputImpl extends ItemAwareElementImpl implements DataInput {
	/**
	 * The default value of the '{@link #isCollection() <em>Is Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COLLECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCollection() <em>Is Collection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCollection()
	 * @generated
	 * @ordered
	 */
	protected boolean isCollection = IS_COLLECTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_InputPin() <em>Base Input Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_InputPin()
	 * @generated
	 * @ordered
	 */
	protected InputPin base_InputPin;

	/**
	 * The cached value of the '{@link #getBase_Parameter() <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Parameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter base_Parameter;

	/**
	 * The cached value of the '{@link #getBase_ActivityParameterNode() <em>Base Activity Parameter Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_ActivityParameterNode()
	 * @generated
	 * @ordered
	 */
	protected ActivityParameterNode base_ActivityParameterNode;

	/**
	 * The cached value of the '{@link #getInputSetRefs() <em>Input Set Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSetRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSet> inputSetRefs;

	/**
	 * The cached value of the '{@link #getInputSetWithOptional() <em>Input Set With Optional</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSetWithOptional()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSet> inputSetWithOptional;

	/**
	 * The cached value of the '{@link #getInputSetWithWhileExecuting() <em>Input Set With While Executing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSetWithWhileExecuting()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSet> inputSetWithWhileExecuting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getDataInput();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollection() {
		return isCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCollection(boolean newIsCollection) {
		boolean oldIsCollection = isCollection;
		isCollection = newIsCollection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_INPUT__IS_COLLECTION, oldIsCollection, isCollection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin getBase_InputPin() {
		if (base_InputPin != null && base_InputPin.eIsProxy()) {
			InternalEObject oldBase_InputPin = (InternalEObject)base_InputPin;
			base_InputPin = (InputPin)eResolveProxy(oldBase_InputPin);
			if (base_InputPin != oldBase_InputPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN, oldBase_InputPin, base_InputPin));
			}
		}
		return base_InputPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPin basicGetBase_InputPin() {
		return base_InputPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_InputPin(InputPin newBase_InputPin) {
		InputPin oldBase_InputPin = base_InputPin;
		base_InputPin = newBase_InputPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN, oldBase_InputPin, base_InputPin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getBase_Parameter() {
		if (base_Parameter != null && base_Parameter.eIsProxy()) {
			InternalEObject oldBase_Parameter = (InternalEObject)base_Parameter;
			base_Parameter = (Parameter)eResolveProxy(oldBase_Parameter);
			if (base_Parameter != oldBase_Parameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
			}
		}
		return base_Parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter basicGetBase_Parameter() {
		return base_Parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Parameter(Parameter newBase_Parameter) {
		Parameter oldBase_Parameter = base_Parameter;
		base_Parameter = newBase_Parameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityParameterNode getBase_ActivityParameterNode() {
		if (base_ActivityParameterNode != null && base_ActivityParameterNode.eIsProxy()) {
			InternalEObject oldBase_ActivityParameterNode = (InternalEObject)base_ActivityParameterNode;
			base_ActivityParameterNode = (ActivityParameterNode)eResolveProxy(oldBase_ActivityParameterNode);
			if (base_ActivityParameterNode != oldBase_ActivityParameterNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE, oldBase_ActivityParameterNode, base_ActivityParameterNode));
			}
		}
		return base_ActivityParameterNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityParameterNode basicGetBase_ActivityParameterNode() {
		return base_ActivityParameterNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_ActivityParameterNode(ActivityParameterNode newBase_ActivityParameterNode) {
		ActivityParameterNode oldBase_ActivityParameterNode = base_ActivityParameterNode;
		base_ActivityParameterNode = newBase_ActivityParameterNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE, oldBase_ActivityParameterNode, base_ActivityParameterNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputSet> getInputSetRefs() {
		if (inputSetRefs == null) {
			inputSetRefs = new EObjectWithInverseResolvingEList.ManyInverse<InputSet>(InputSet.class, this, BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS, BPMNProfilePackage.INPUT_SET__DATA_INPUT_REFS);
		}
		return inputSetRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputSet> getInputSetWithOptional() {
		if (inputSetWithOptional == null) {
			inputSetWithOptional = new EObjectWithInverseResolvingEList.ManyInverse<InputSet>(InputSet.class, this, BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL, BPMNProfilePackage.INPUT_SET__OPTIONAL_INPUT_REFS);
		}
		return inputSetWithOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputSet> getInputSetWithWhileExecuting() {
		if (inputSetWithWhileExecuting == null) {
			inputSetWithWhileExecuting = new EObjectWithInverseResolvingEList.ManyInverse<InputSet>(InputSet.class, this, BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING, BPMNProfilePackage.INPUT_SET__WHILE_EXECUTING_INPUT_REFS);
		}
		return inputSetWithWhileExecuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataInputAssociation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.DATA_INPUT__DATA_INPUT_ASSOCIATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataInputAssociation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataInputnotation(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.DATA_INPUT__DATA_INPUTNOTATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataInputnotation", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataInputitemSubjectRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 BPMNProfileValidator.DIAGNOSTIC_SOURCE,
						 BPMNProfileValidator.DATA_INPUT__DATA_INPUTITEM_SUBJECT_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataInputitemSubjectRef", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
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
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputSetRefs()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputSetWithOptional()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputSetWithWhileExecuting()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				return ((InternalEList<?>)getInputSetRefs()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				return ((InternalEList<?>)getInputSetWithOptional()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				return ((InternalEList<?>)getInputSetWithWhileExecuting()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.DATA_INPUT__IS_COLLECTION:
				return isCollection();
			case BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN:
				if (resolve) return getBase_InputPin();
				return basicGetBase_InputPin();
			case BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER:
				if (resolve) return getBase_Parameter();
				return basicGetBase_Parameter();
			case BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE:
				if (resolve) return getBase_ActivityParameterNode();
				return basicGetBase_ActivityParameterNode();
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				return getInputSetRefs();
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				return getInputSetWithOptional();
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				return getInputSetWithWhileExecuting();
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
			case BPMNProfilePackage.DATA_INPUT__IS_COLLECTION:
				setIsCollection((Boolean)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN:
				setBase_InputPin((InputPin)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER:
				setBase_Parameter((Parameter)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE:
				setBase_ActivityParameterNode((ActivityParameterNode)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				getInputSetRefs().clear();
				getInputSetRefs().addAll((Collection<? extends InputSet>)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				getInputSetWithOptional().clear();
				getInputSetWithOptional().addAll((Collection<? extends InputSet>)newValue);
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				getInputSetWithWhileExecuting().clear();
				getInputSetWithWhileExecuting().addAll((Collection<? extends InputSet>)newValue);
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
			case BPMNProfilePackage.DATA_INPUT__IS_COLLECTION:
				setIsCollection(IS_COLLECTION_EDEFAULT);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN:
				setBase_InputPin((InputPin)null);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER:
				setBase_Parameter((Parameter)null);
				return;
			case BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE:
				setBase_ActivityParameterNode((ActivityParameterNode)null);
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				getInputSetRefs().clear();
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				getInputSetWithOptional().clear();
				return;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				getInputSetWithWhileExecuting().clear();
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
			case BPMNProfilePackage.DATA_INPUT__IS_COLLECTION:
				return isCollection != IS_COLLECTION_EDEFAULT;
			case BPMNProfilePackage.DATA_INPUT__BASE_INPUT_PIN:
				return base_InputPin != null;
			case BPMNProfilePackage.DATA_INPUT__BASE_PARAMETER:
				return base_Parameter != null;
			case BPMNProfilePackage.DATA_INPUT__BASE_ACTIVITY_PARAMETER_NODE:
				return base_ActivityParameterNode != null;
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_REFS:
				return inputSetRefs != null && !inputSetRefs.isEmpty();
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_OPTIONAL:
				return inputSetWithOptional != null && !inputSetWithOptional.isEmpty();
			case BPMNProfilePackage.DATA_INPUT__INPUT_SET_WITH_WHILE_EXECUTING:
				return inputSetWithWhileExecuting != null && !inputSetWithWhileExecuting.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case BPMNProfilePackage.DATA_INPUT___DATA_INPUT_ASSOCIATION__DIAGNOSTICCHAIN_MAP:
				return DataInputAssociation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_INPUT___DATA_INPUTNOTATION__DIAGNOSTICCHAIN_MAP:
				return DataInputnotation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_INPUT___DATA_INPUTITEM_SUBJECT_REF__DIAGNOSTICCHAIN_MAP:
				return DataInputitemSubjectRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (isCollection: ");
		result.append(isCollection);
		result.append(')');
		return result.toString();
	}

} //DataInputImpl
