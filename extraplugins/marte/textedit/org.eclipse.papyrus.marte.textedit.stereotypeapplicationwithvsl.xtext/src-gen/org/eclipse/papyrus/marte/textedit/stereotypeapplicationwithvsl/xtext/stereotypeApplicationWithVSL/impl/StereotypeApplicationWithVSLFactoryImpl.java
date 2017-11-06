/**
 */
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.ExpressionValueRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLFactory;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationsRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class StereotypeApplicationWithVSLFactoryImpl extends EFactoryImpl implements StereotypeApplicationWithVSLFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static StereotypeApplicationWithVSLFactory init()
	{
		try
		{
			StereotypeApplicationWithVSLFactory theStereotypeApplicationWithVSLFactory = (StereotypeApplicationWithVSLFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/papyrus/marte/textedit/stereotypeapplicationwithvsl/xtext/StereotypeApplicationWithVSL");
			if (theStereotypeApplicationWithVSLFactory != null)
			{
				return theStereotypeApplicationWithVSLFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StereotypeApplicationWithVSLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public StereotypeApplicationWithVSLFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
		case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATIONS_RULE:
			return createStereotypeApplicationsRule();
		case StereotypeApplicationWithVSLPackage.STEREOTYPE_APPLICATION_RULE:
			return createStereotypeApplicationRule();
		case StereotypeApplicationWithVSLPackage.TAG_SPECIFICATION_RULE:
			return createTagSpecificationRule();
		case StereotypeApplicationWithVSLPackage.EXPRESSION_VALUE_RULE:
			return createExpressionValueRule();
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
	public StereotypeApplicationsRule createStereotypeApplicationsRule()
	{
		StereotypeApplicationsRuleImpl stereotypeApplicationsRule = new StereotypeApplicationsRuleImpl();
		return stereotypeApplicationsRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StereotypeApplicationRule createStereotypeApplicationRule()
	{
		StereotypeApplicationRuleImpl stereotypeApplicationRule = new StereotypeApplicationRuleImpl();
		return stereotypeApplicationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public TagSpecificationRule createTagSpecificationRule()
	{
		TagSpecificationRuleImpl tagSpecificationRule = new TagSpecificationRuleImpl();
		return tagSpecificationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ExpressionValueRule createExpressionValueRule()
	{
		ExpressionValueRuleImpl expressionValueRule = new ExpressionValueRuleImpl();
		return expressionValueRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StereotypeApplicationWithVSLPackage getStereotypeApplicationWithVSLPackage()
	{
		return (StereotypeApplicationWithVSLPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StereotypeApplicationWithVSLPackage getPackage()
	{
		return StereotypeApplicationWithVSLPackage.eINSTANCE;
	}

} // StereotypeApplicationWithVSLFactoryImpl
