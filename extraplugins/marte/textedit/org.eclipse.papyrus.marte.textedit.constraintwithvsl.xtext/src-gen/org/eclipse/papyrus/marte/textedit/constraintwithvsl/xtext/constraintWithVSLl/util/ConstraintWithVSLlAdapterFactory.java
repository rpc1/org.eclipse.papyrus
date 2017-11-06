/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintRule;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlPackage
 * @generated
 */
public class ConstraintWithVSLlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected static ConstraintWithVSLlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConstraintWithVSLlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ConstraintWithVSLlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 *
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected ConstraintWithVSLlSwitch<Adapter> modelSwitch =
			new ConstraintWithVSLlSwitch<Adapter>() {
				@Override
				public Adapter caseConstraintRule(ConstraintRule object) {
					return createConstraintRuleAdapter();
				}

				@Override
				public Adapter caseConstraintSpecification(ConstraintSpecification object) {
					return createConstraintSpecificationAdapter();
				}

				@Override
				public Adapter defaultCase(EObject object) {
					return createEObjectAdapter();
				}
			};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @param target
	 *            the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintRule <em>Constraint Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintRule
	 * @generated
	 */
	public Adapter createConstraintRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification <em>Constraint Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification
	 * @generated
	 */
	public Adapter createConstraintSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 *
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // ConstraintWithVSLlAdapterFactory
