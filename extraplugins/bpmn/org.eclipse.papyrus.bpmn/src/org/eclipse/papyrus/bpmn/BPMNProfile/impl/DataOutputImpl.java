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

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.bpmn.BPMNProfile.BPMNProfilePackage;
import org.eclipse.papyrus.bpmn.BPMNProfile.DataOutput;
import org.eclipse.papyrus.bpmn.BPMNProfile.OutputSet;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getBase_OutputPin <em>Base Output Pin</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#isCollection <em>Is Collection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getBase_Parameter <em>Base Parameter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getBase_ActivityParameterNode <em>Base Activity Parameter Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getOutputSetRefs <em>Output Set Refs</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getOutputSetWithOptional <em>Output Set With Optional</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.DataOutputImpl#getOutputSetWithWhileExecuting <em>Output Set With While Executing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataOutputImpl extends ItemAwareElementImpl implements DataOutput {
	/**
	 * The cached value of the '{@link #getBase_OutputPin() <em>Base Output Pin</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_OutputPin()
	 * @generated
	 * @ordered
	 */
	protected OutputPin base_OutputPin;

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
	 * The cached value of the '{@link #getOutputSetRefs() <em>Output Set Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSetRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSet> outputSetRefs;

	/**
	 * The cached value of the '{@link #getOutputSetWithOptional() <em>Output Set With Optional</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSetWithOptional()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSet> outputSetWithOptional;

	/**
	 * The cached value of the '{@link #getOutputSetWithWhileExecuting() <em>Output Set With While Executing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSetWithWhileExecuting()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSet> outputSetWithWhileExecuting;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataOutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getDataOutput();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPin getBase_OutputPin() {
		if (base_OutputPin != null && base_OutputPin.eIsProxy()) {
			InternalEObject oldBase_OutputPin = (InternalEObject)base_OutputPin;
			base_OutputPin = (OutputPin)eResolveProxy(oldBase_OutputPin);
			if (base_OutputPin != oldBase_OutputPin) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN, oldBase_OutputPin, base_OutputPin));
			}
		}
		return base_OutputPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPin basicGetBase_OutputPin() {
		return base_OutputPin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_OutputPin(OutputPin newBase_OutputPin) {
		OutputPin oldBase_OutputPin = base_OutputPin;
		base_OutputPin = newBase_OutputPin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN, oldBase_OutputPin, base_OutputPin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OUTPUT__IS_COLLECTION, oldIsCollection, isCollection));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE, oldBase_ActivityParameterNode, base_ActivityParameterNode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE, oldBase_ActivityParameterNode, base_ActivityParameterNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSet> getOutputSetRefs() {
		if (outputSetRefs == null) {
			outputSetRefs = new EObjectWithInverseResolvingEList.ManyInverse<OutputSet>(OutputSet.class, this, BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS, BPMNProfilePackage.OUTPUT_SET__DATA_OUTPUT_REFS);
		}
		return outputSetRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSet> getOutputSetWithOptional() {
		if (outputSetWithOptional == null) {
			outputSetWithOptional = new EObjectResolvingEList<OutputSet>(OutputSet.class, this, BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL);
		}
		return outputSetWithOptional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSet> getOutputSetWithWhileExecuting() {
		if (outputSetWithWhileExecuting == null) {
			outputSetWithWhileExecuting = new EObjectResolvingEList<OutputSet>(OutputSet.class, this, BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING);
		}
		return outputSetWithWhileExecuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean DataOutputnotation(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.DATA_OUTPUT__DATA_OUTPUTNOTATION,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataOutputnotation", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean DataOutputitemSubjectRef(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.DATA_OUTPUT__DATA_OUTPUTITEM_SUBJECT_REF,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "DataOutputitemSubjectRef", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputSetRefs()).basicAdd(otherEnd, msgs);
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
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				return ((InternalEList<?>)getOutputSetRefs()).basicRemove(otherEnd, msgs);
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
			case BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN:
				if (resolve) return getBase_OutputPin();
				return basicGetBase_OutputPin();
			case BPMNProfilePackage.DATA_OUTPUT__IS_COLLECTION:
				return isCollection();
			case BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER:
				if (resolve) return getBase_Parameter();
				return basicGetBase_Parameter();
			case BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE:
				if (resolve) return getBase_ActivityParameterNode();
				return basicGetBase_ActivityParameterNode();
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				return getOutputSetRefs();
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL:
				return getOutputSetWithOptional();
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING:
				return getOutputSetWithWhileExecuting();
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
			case BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN:
				setBase_OutputPin((OutputPin)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__IS_COLLECTION:
				setIsCollection((Boolean)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER:
				setBase_Parameter((Parameter)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE:
				setBase_ActivityParameterNode((ActivityParameterNode)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				getOutputSetRefs().clear();
				getOutputSetRefs().addAll((Collection<? extends OutputSet>)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL:
				getOutputSetWithOptional().clear();
				getOutputSetWithOptional().addAll((Collection<? extends OutputSet>)newValue);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING:
				getOutputSetWithWhileExecuting().clear();
				getOutputSetWithWhileExecuting().addAll((Collection<? extends OutputSet>)newValue);
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
			case BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN:
				setBase_OutputPin((OutputPin)null);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__IS_COLLECTION:
				setIsCollection(IS_COLLECTION_EDEFAULT);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER:
				setBase_Parameter((Parameter)null);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE:
				setBase_ActivityParameterNode((ActivityParameterNode)null);
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				getOutputSetRefs().clear();
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL:
				getOutputSetWithOptional().clear();
				return;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING:
				getOutputSetWithWhileExecuting().clear();
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
			case BPMNProfilePackage.DATA_OUTPUT__BASE_OUTPUT_PIN:
				return base_OutputPin != null;
			case BPMNProfilePackage.DATA_OUTPUT__IS_COLLECTION:
				return isCollection != IS_COLLECTION_EDEFAULT;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_PARAMETER:
				return base_Parameter != null;
			case BPMNProfilePackage.DATA_OUTPUT__BASE_ACTIVITY_PARAMETER_NODE:
				return base_ActivityParameterNode != null;
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_REFS:
				return outputSetRefs != null && !outputSetRefs.isEmpty();
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_OPTIONAL:
				return outputSetWithOptional != null && !outputSetWithOptional.isEmpty();
			case BPMNProfilePackage.DATA_OUTPUT__OUTPUT_SET_WITH_WHILE_EXECUTING:
				return outputSetWithWhileExecuting != null && !outputSetWithWhileExecuting.isEmpty();
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
			case BPMNProfilePackage.DATA_OUTPUT___DATA_OUTPUTNOTATION__DIAGNOSTICCHAIN_MAP:
				return DataOutputnotation((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.DATA_OUTPUT___DATA_OUTPUTITEM_SUBJECT_REF__DIAGNOSTICCHAIN_MAP:
				return DataOutputitemSubjectRef((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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

} //DataOutputImpl
