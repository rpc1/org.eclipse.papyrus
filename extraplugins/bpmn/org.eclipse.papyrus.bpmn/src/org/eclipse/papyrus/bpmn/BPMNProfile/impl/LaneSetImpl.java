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
import org.eclipse.papyrus.bpmn.BPMNProfile.FlowElementsContainer;
import org.eclipse.papyrus.bpmn.BPMNProfile.Lane;
import org.eclipse.papyrus.bpmn.BPMNProfile.LaneSet;

import org.eclipse.papyrus.bpmn.BPMNProfile.util.BPMNProfileValidator;

import org.eclipse.uml2.uml.ActivityPartition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl#getBase_ActivityPartition <em>Base Activity Partition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl#getLanes <em>Lanes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl#getParentLane <em>Parent Lane</em>}</li>
 *   <li>{@link org.eclipse.papyrus.bpmn.BPMNProfile.impl.LaneSetImpl#getFlowElementsContainer <em>Flow Elements Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LaneSetImpl extends BaseElementImpl implements LaneSet {
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
	 * The cached value of the '{@link #getLanes() <em>Lanes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanes()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> lanes;
	/**
	 * The cached value of the '{@link #getParentLane() <em>Parent Lane</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentLane()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> parentLane;
	/**
	 * The cached value of the '{@link #getFlowElementsContainer() <em>Flow Elements Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowElementsContainer()
	 * @generated
	 * @ordered
	 */
	protected FlowElementsContainer flowElementsContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPMNProfilePackage.eINSTANCE.getLaneSet();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lane> getLanes() {
		if (lanes == null) {
			lanes = new EObjectWithInverseResolvingEList<Lane>(Lane.class, this, BPMNProfilePackage.LANE_SET__LANES, BPMNProfilePackage.LANE__LANE_SET);
		}
		return lanes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lane> getParentLane() {
		if (parentLane == null) {
			parentLane = new EObjectResolvingEList<Lane>(Lane.class, this, BPMNProfilePackage.LANE_SET__PARENT_LANE);
		}
		return parentLane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowElementsContainer getFlowElementsContainer() {
		if (flowElementsContainer != null && flowElementsContainer.eIsProxy()) {
			InternalEObject oldFlowElementsContainer = (InternalEObject)flowElementsContainer;
			flowElementsContainer = (FlowElementsContainer)eResolveProxy(oldFlowElementsContainer);
			if (flowElementsContainer != oldFlowElementsContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER, oldFlowElementsContainer, flowElementsContainer));
			}
		}
		return flowElementsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowElementsContainer basicGetFlowElementsContainer() {
		return flowElementsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlowElementsContainer(FlowElementsContainer newFlowElementsContainer, NotificationChain msgs) {
		FlowElementsContainer oldFlowElementsContainer = flowElementsContainer;
		flowElementsContainer = newFlowElementsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER, oldFlowElementsContainer, newFlowElementsContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowElementsContainer(FlowElementsContainer newFlowElementsContainer) {
		if (newFlowElementsContainer != flowElementsContainer) {
			NotificationChain msgs = null;
			if (flowElementsContainer != null)
				msgs = ((InternalEObject)flowElementsContainer).eInverseRemove(this, BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS, FlowElementsContainer.class, msgs);
			if (newFlowElementsContainer != null)
				msgs = ((InternalEObject)newFlowElementsContainer).eInverseAdd(this, BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS, FlowElementsContainer.class, msgs);
			msgs = basicSetFlowElementsContainer(newFlowElementsContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER, newFlowElementsContainer, newFlowElementsContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean LaneSetlanes(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE_SET__LANE_SETLANES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LaneSetlanes", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LaneSetparentLane(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE_SET__LANE_SETPARENT_LANE,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LaneSetparentLane", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LaneSetflowElementsContainer(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE_SET__LANE_SETFLOW_ELEMENTS_CONTAINER,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LaneSetflowElementsContainer", EObjectValidator.getObjectLabel(this, context) }),
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
	public boolean LaneSet(DiagnosticChain diagnostics, Map<Object, Object> context) {
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
						 BPMNProfileValidator.LANE_SET__LANE_SET,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "LaneSet", EObjectValidator.getObjectLabel(this, context) }),
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
			case BPMNProfilePackage.LANE_SET__LANES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLanes()).basicAdd(otherEnd, msgs);
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				if (flowElementsContainer != null)
					msgs = ((InternalEObject)flowElementsContainer).eInverseRemove(this, BPMNProfilePackage.FLOW_ELEMENTS_CONTAINER__LANE_SETS, FlowElementsContainer.class, msgs);
				return basicSetFlowElementsContainer((FlowElementsContainer)otherEnd, msgs);
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
			case BPMNProfilePackage.LANE_SET__LANES:
				return ((InternalEList<?>)getLanes()).basicRemove(otherEnd, msgs);
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				return basicSetFlowElementsContainer(null, msgs);
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
			case BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION:
				if (resolve) return getBase_ActivityPartition();
				return basicGetBase_ActivityPartition();
			case BPMNProfilePackage.LANE_SET__LANES:
				return getLanes();
			case BPMNProfilePackage.LANE_SET__PARENT_LANE:
				return getParentLane();
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				if (resolve) return getFlowElementsContainer();
				return basicGetFlowElementsContainer();
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
			case BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)newValue);
				return;
			case BPMNProfilePackage.LANE_SET__LANES:
				getLanes().clear();
				getLanes().addAll((Collection<? extends Lane>)newValue);
				return;
			case BPMNProfilePackage.LANE_SET__PARENT_LANE:
				getParentLane().clear();
				getParentLane().addAll((Collection<? extends Lane>)newValue);
				return;
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				setFlowElementsContainer((FlowElementsContainer)newValue);
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
			case BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION:
				setBase_ActivityPartition((ActivityPartition)null);
				return;
			case BPMNProfilePackage.LANE_SET__LANES:
				getLanes().clear();
				return;
			case BPMNProfilePackage.LANE_SET__PARENT_LANE:
				getParentLane().clear();
				return;
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				setFlowElementsContainer((FlowElementsContainer)null);
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
			case BPMNProfilePackage.LANE_SET__BASE_ACTIVITY_PARTITION:
				return base_ActivityPartition != null;
			case BPMNProfilePackage.LANE_SET__LANES:
				return lanes != null && !lanes.isEmpty();
			case BPMNProfilePackage.LANE_SET__PARENT_LANE:
				return parentLane != null && !parentLane.isEmpty();
			case BPMNProfilePackage.LANE_SET__FLOW_ELEMENTS_CONTAINER:
				return flowElementsContainer != null;
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
			case BPMNProfilePackage.LANE_SET___LANE_SETLANES__DIAGNOSTICCHAIN_MAP:
				return LaneSetlanes((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE_SET___LANE_SETPARENT_LANE__DIAGNOSTICCHAIN_MAP:
				return LaneSetparentLane((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE_SET___LANE_SETFLOW_ELEMENTS_CONTAINER__DIAGNOSTICCHAIN_MAP:
				return LaneSetflowElementsContainer((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case BPMNProfilePackage.LANE_SET___LANE_SET__DIAGNOSTICCHAIN_MAP:
				return LaneSet((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

} //LaneSetImpl
