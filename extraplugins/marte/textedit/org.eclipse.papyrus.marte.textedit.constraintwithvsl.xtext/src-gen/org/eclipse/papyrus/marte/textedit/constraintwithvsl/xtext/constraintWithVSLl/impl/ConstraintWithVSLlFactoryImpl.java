/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintRule;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlFactory;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ConstraintWithVSLlFactoryImpl extends EFactoryImpl implements ConstraintWithVSLlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static ConstraintWithVSLlFactory init() {
		try {
			ConstraintWithVSLlFactory theConstraintWithVSLlFactory = (ConstraintWithVSLlFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/marte/textedit/constraintwithvsl/xtext/ConstraintWithVSLl");
			if (theConstraintWithVSLlFactory != null) {
				return theConstraintWithVSLlFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ConstraintWithVSLlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConstraintWithVSLlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ConstraintWithVSLlPackage.CONSTRAINT_RULE:
			return createConstraintRule();
		case ConstraintWithVSLlPackage.CONSTRAINT_SPECIFICATION:
			return createConstraintSpecification();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConstraintRule createConstraintRule() {
		ConstraintRuleImpl constraintRule = new ConstraintRuleImpl();
		return constraintRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConstraintSpecification createConstraintSpecification() {
		ConstraintSpecificationImpl constraintSpecification = new ConstraintSpecificationImpl();
		return constraintSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ConstraintWithVSLlPackage getConstraintWithVSLlPackage() {
		return (ConstraintWithVSLlPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ConstraintWithVSLlPackage getPackage() {
		return ConstraintWithVSLlPackage.eINSTANCE;
	}

} // ConstraintWithVSLlFactoryImpl
