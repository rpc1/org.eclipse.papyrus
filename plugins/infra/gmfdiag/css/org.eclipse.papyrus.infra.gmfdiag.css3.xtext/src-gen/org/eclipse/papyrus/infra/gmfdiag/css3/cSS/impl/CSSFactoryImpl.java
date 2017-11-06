/**
 */
package org.eclipse.papyrus.infra.gmfdiag.css3.cSS.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.gmfdiag.css3.cSS.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CSSFactoryImpl extends EFactoryImpl implements CSSFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static CSSFactory init()
	{
		try
		{
			CSSFactory theCSSFactory = (CSSFactory) EPackage.Registry.INSTANCE.getEFactory(CSSPackage.eNS_URI);
			if (theCSSFactory != null)
			{
				return theCSSFactory;
			}
		} catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CSSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CSSFactoryImpl()
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
		case CSSPackage.STYLESHEET:
			return createstylesheet();
		case CSSPackage.CHARSET:
			return createcharset();
		case CSSPackage.IMPORT_EXPRESSION:
			return createimportExpression();
		case CSSPackage.PAGE:
			return createpage();
		case CSSPackage.MEDIA:
			return createmedia();
		case CSSPackage.FONT_FACE:
			return createfont_face();
		case CSSPackage.KEYFRAMES:
			return createkeyframes();
		case CSSPackage.KEYFRAME_SELECTOR:
			return createkeyframe_selector();
		case CSSPackage.RULESET:
			return createruleset();
		case CSSPackage.SELECTOR:
			return createselector();
		case CSSPackage.SIMPLE_SELECTOR_FOR_NEGATION:
			return createSimpleSelectorForNegation();
		case CSSPackage.CSS_SELECTOR:
			return createCssSelector();
		case CSSPackage.SIMPLE_SELECTOR:
			return createsimple_selector();
		case CSSPackage.CLASS_SELECTOR:
			return createClassSelector();
		case CSSPackage.ELEMENT_SELECTOR:
			return createElementSelector();
		case CSSPackage.UNIVERSAL_SELECTOR:
			return createUniversalSelector();
		case CSSPackage.ID_SELECTOR:
			return createIdSelector();
		case CSSPackage.CSS_DECLARATION:
			return createcss_declaration();
		case CSSPackage.CSS_PROPERTY:
			return createcss_property();
		case CSSPackage.PSEUDO_CLASS_OR_FUNC:
			return createPseudoClassOrFunc();
		case CSSPackage.PSEUDO_CLASS:
			return createPseudoClass();
		case CSSPackage.PSEUDO_CLASS_NAME:
			return createPseudoClassName();
		case CSSPackage.PSEUDO_CLASS_FUNCTION:
			return createPseudoClassFunction();
		case CSSPackage.CSS_TOK:
			return createCssTok();
		case CSSPackage.URL_TYPE:
			return createURLType();
		case CSSPackage.ATTRIBUTE_SELECTOR:
			return createAttributeSelector();
		case CSSPackage.SYMBOL_TOK:
			return createSymbolTok();
		case CSSPackage.WS_TOK:
			return createWSTok();
		case CSSPackage.STRING_TOK:
			return createStringTok();
		case CSSPackage.NUMBER_TOK:
			return createNumberTok();
		case CSSPackage.URL_TOK:
			return createUrlTok();
		case CSSPackage.COLOR_TOK:
			return createColorTok();
		case CSSPackage.IDENTIFIER_TOK:
			return createIdentifierTok();
		case CSSPackage.FUNC_TOK:
			return createFuncTok();
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
	public stylesheet createstylesheet()
	{
		stylesheetImpl stylesheet = new stylesheetImpl();
		return stylesheet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public charset createcharset()
	{
		charsetImpl charset = new charsetImpl();
		return charset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public importExpression createimportExpression()
	{
		importExpressionImpl importExpression = new importExpressionImpl();
		return importExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public page createpage()
	{
		pageImpl page = new pageImpl();
		return page;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public media createmedia()
	{
		mediaImpl media = new mediaImpl();
		return media;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public font_face createfont_face()
	{
		font_faceImpl font_face = new font_faceImpl();
		return font_face;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public keyframes createkeyframes()
	{
		keyframesImpl keyframes = new keyframesImpl();
		return keyframes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public keyframe_selector createkeyframe_selector()
	{
		keyframe_selectorImpl keyframe_selector = new keyframe_selectorImpl();
		return keyframe_selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ruleset createruleset()
	{
		rulesetImpl ruleset = new rulesetImpl();
		return ruleset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public selector createselector()
	{
		selectorImpl selector = new selectorImpl();
		return selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SimpleSelectorForNegation createSimpleSelectorForNegation()
	{
		SimpleSelectorForNegationImpl simpleSelectorForNegation = new SimpleSelectorForNegationImpl();
		return simpleSelectorForNegation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CssSelector createCssSelector()
	{
		CssSelectorImpl cssSelector = new CssSelectorImpl();
		return cssSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public simple_selector createsimple_selector()
	{
		simple_selectorImpl simple_selector = new simple_selectorImpl();
		return simple_selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ClassSelector createClassSelector()
	{
		ClassSelectorImpl classSelector = new ClassSelectorImpl();
		return classSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ElementSelector createElementSelector()
	{
		ElementSelectorImpl elementSelector = new ElementSelectorImpl();
		return elementSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public UniversalSelector createUniversalSelector()
	{
		UniversalSelectorImpl universalSelector = new UniversalSelectorImpl();
		return universalSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public IdSelector createIdSelector()
	{
		IdSelectorImpl idSelector = new IdSelectorImpl();
		return idSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public css_declaration createcss_declaration()
	{
		css_declarationImpl css_declaration = new css_declarationImpl();
		return css_declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public css_property createcss_property()
	{
		css_propertyImpl css_property = new css_propertyImpl();
		return css_property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PseudoClassOrFunc createPseudoClassOrFunc()
	{
		PseudoClassOrFuncImpl pseudoClassOrFunc = new PseudoClassOrFuncImpl();
		return pseudoClassOrFunc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PseudoClass createPseudoClass()
	{
		PseudoClassImpl pseudoClass = new PseudoClassImpl();
		return pseudoClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PseudoClassName createPseudoClassName()
	{
		PseudoClassNameImpl pseudoClassName = new PseudoClassNameImpl();
		return pseudoClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public PseudoClassFunction createPseudoClassFunction()
	{
		PseudoClassFunctionImpl pseudoClassFunction = new PseudoClassFunctionImpl();
		return pseudoClassFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CssTok createCssTok()
	{
		CssTokImpl cssTok = new CssTokImpl();
		return cssTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public URLType createURLType()
	{
		URLTypeImpl urlType = new URLTypeImpl();
		return urlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public AttributeSelector createAttributeSelector()
	{
		AttributeSelectorImpl attributeSelector = new AttributeSelectorImpl();
		return attributeSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SymbolTok createSymbolTok()
	{
		SymbolTokImpl symbolTok = new SymbolTokImpl();
		return symbolTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public WSTok createWSTok()
	{
		WSTokImpl wsTok = new WSTokImpl();
		return wsTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public StringTok createStringTok()
	{
		StringTokImpl stringTok = new StringTokImpl();
		return stringTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NumberTok createNumberTok()
	{
		NumberTokImpl numberTok = new NumberTokImpl();
		return numberTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public UrlTok createUrlTok()
	{
		UrlTokImpl urlTok = new UrlTokImpl();
		return urlTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ColorTok createColorTok()
	{
		ColorTokImpl colorTok = new ColorTokImpl();
		return colorTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public IdentifierTok createIdentifierTok()
	{
		IdentifierTokImpl identifierTok = new IdentifierTokImpl();
		return identifierTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public FuncTok createFuncTok()
	{
		FuncTokImpl funcTok = new FuncTokImpl();
		return funcTok;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public CSSPackage getCSSPackage()
	{
		return (CSSPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CSSPackage getPackage()
	{
		return CSSPackage.eINSTANCE;
	}

} // CSSFactoryImpl
