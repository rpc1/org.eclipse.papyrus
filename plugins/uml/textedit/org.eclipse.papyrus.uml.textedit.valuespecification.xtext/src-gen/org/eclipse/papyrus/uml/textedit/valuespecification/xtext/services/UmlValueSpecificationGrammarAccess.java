/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.valuespecification.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class UmlValueSpecificationGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class AbstractRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AbstractRule");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cVisibilityAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cVisibilityVisibilityKindParserRuleCall_0_0 = (RuleCall)cVisibilityAssignment_0.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Alternatives cAlternatives_2 = (Alternatives)cGroup.eContents().get(2);
		private final Assignment cInstanceSpecificationAssignment_2_0 = (Assignment)cAlternatives_2.eContents().get(0);
		private final CrossReference cInstanceSpecificationInstanceSpecificationCrossReference_2_0_0 = (CrossReference)cInstanceSpecificationAssignment_2_0.eContents().get(0);
		private final RuleCall cInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_2_0_0_1 = (RuleCall)cInstanceSpecificationInstanceSpecificationCrossReference_2_0_0.eContents().get(1);
		private final Assignment cValueAssignment_2_1 = (Assignment)cAlternatives_2.eContents().get(1);
		private final Alternatives cValueAlternatives_2_1_0 = (Alternatives)cValueAssignment_2_1.eContents().get(0);
		private final RuleCall cValueLiteralBooleanRuleParserRuleCall_2_1_0_0 = (RuleCall)cValueAlternatives_2_1_0.eContents().get(0);
		private final RuleCall cValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1 = (RuleCall)cValueAlternatives_2_1_0.eContents().get(1);
		private final RuleCall cValueLiteralRealRuleParserRuleCall_2_1_0_2 = (RuleCall)cValueAlternatives_2_1_0.eContents().get(2);
		private final RuleCall cValueLiteralNullRuleParserRuleCall_2_1_0_3 = (RuleCall)cValueAlternatives_2_1_0.eContents().get(3);
		private final RuleCall cValueLiteralStringRuleParserRuleCall_2_1_0_4 = (RuleCall)cValueAlternatives_2_1_0.eContents().get(4);
		private final Assignment cUndefinedAssignment_2_2 = (Assignment)cAlternatives_2.eContents().get(2);
		private final RuleCall cUndefinedUndefinedRuleParserRuleCall_2_2_0 = (RuleCall)cUndefinedAssignment_2_2.eContents().get(0);
		
		//AbstractRule:
		//	visibility=VisibilityKind? name=VALUE_SPECIFICATION_ID? (instanceSpecification=[uml::InstanceSpecification] |
		//	value=(LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule | LiteralRealRule | LiteralNullRule |
		//	LiteralStringRule) | undefined=UndefinedRule);
		@Override public ParserRule getRule() { return rule; }

		//visibility=VisibilityKind? name=VALUE_SPECIFICATION_ID? (instanceSpecification=[uml::InstanceSpecification] |
		//value=(LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule | LiteralRealRule | LiteralNullRule |
		//LiteralStringRule) | undefined=UndefinedRule)
		public Group getGroup() { return cGroup; }

		//visibility=VisibilityKind?
		public Assignment getVisibilityAssignment_0() { return cVisibilityAssignment_0; }

		//VisibilityKind
		public RuleCall getVisibilityVisibilityKindParserRuleCall_0_0() { return cVisibilityVisibilityKindParserRuleCall_0_0; }

		//name=VALUE_SPECIFICATION_ID?
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//VALUE_SPECIFICATION_ID
		public RuleCall getNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0() { return cNameVALUE_SPECIFICATION_IDTerminalRuleCall_1_0; }

		//instanceSpecification=[uml::InstanceSpecification] | value=(LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule |
		//LiteralRealRule | LiteralNullRule | LiteralStringRule) | undefined=UndefinedRule
		public Alternatives getAlternatives_2() { return cAlternatives_2; }

		//instanceSpecification=[uml::InstanceSpecification]
		public Assignment getInstanceSpecificationAssignment_2_0() { return cInstanceSpecificationAssignment_2_0; }

		//[uml::InstanceSpecification]
		public CrossReference getInstanceSpecificationInstanceSpecificationCrossReference_2_0_0() { return cInstanceSpecificationInstanceSpecificationCrossReference_2_0_0; }

		//ID
		public RuleCall getInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_2_0_0_1() { return cInstanceSpecificationInstanceSpecificationIDTerminalRuleCall_2_0_0_1; }

		//value=(LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule | LiteralRealRule | LiteralNullRule |
		//LiteralStringRule)
		public Assignment getValueAssignment_2_1() { return cValueAssignment_2_1; }

		//LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule | LiteralRealRule | LiteralNullRule | LiteralStringRule
		public Alternatives getValueAlternatives_2_1_0() { return cValueAlternatives_2_1_0; }

		//LiteralBooleanRule
		public RuleCall getValueLiteralBooleanRuleParserRuleCall_2_1_0_0() { return cValueLiteralBooleanRuleParserRuleCall_2_1_0_0; }

		//LiteralIntegerOrUnlimitedNaturalRule
		public RuleCall getValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1() { return cValueLiteralIntegerOrUnlimitedNaturalRuleParserRuleCall_2_1_0_1; }

		//LiteralRealRule
		public RuleCall getValueLiteralRealRuleParserRuleCall_2_1_0_2() { return cValueLiteralRealRuleParserRuleCall_2_1_0_2; }

		//LiteralNullRule
		public RuleCall getValueLiteralNullRuleParserRuleCall_2_1_0_3() { return cValueLiteralNullRuleParserRuleCall_2_1_0_3; }

		//LiteralStringRule
		public RuleCall getValueLiteralStringRuleParserRuleCall_2_1_0_4() { return cValueLiteralStringRuleParserRuleCall_2_1_0_4; }

		//undefined=UndefinedRule
		public Assignment getUndefinedAssignment_2_2() { return cUndefinedAssignment_2_2; }

		//UndefinedRule
		public RuleCall getUndefinedUndefinedRuleParserRuleCall_2_2_0() { return cUndefinedUndefinedRuleParserRuleCall_2_2_0; }
	}

	public class LiteralBooleanRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralBooleanRule");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cValueAlternatives_0 = (Alternatives)cValueAssignment.eContents().get(0);
		private final Keyword cValueTrueKeyword_0_0 = (Keyword)cValueAlternatives_0.eContents().get(0);
		private final Keyword cValueFalseKeyword_0_1 = (Keyword)cValueAlternatives_0.eContents().get(1);
		
		//LiteralBooleanRule:
		//	value=("true" | "false");
		@Override public ParserRule getRule() { return rule; }

		//value=("true" | "false")
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"true" | "false"
		public Alternatives getValueAlternatives_0() { return cValueAlternatives_0; }

		//"true"
		public Keyword getValueTrueKeyword_0_0() { return cValueTrueKeyword_0_0; }

		//"false"
		public Keyword getValueFalseKeyword_0_1() { return cValueFalseKeyword_0_1; }
	}

	public class LiteralIntegerOrUnlimitedNaturalRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralIntegerOrUnlimitedNaturalRule");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cValueAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Alternatives cValueAlternatives_0_0 = (Alternatives)cValueAssignment_0.eContents().get(0);
		private final RuleCall cValueINTTerminalRuleCall_0_0_0 = (RuleCall)cValueAlternatives_0_0.eContents().get(0);
		private final RuleCall cValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1 = (RuleCall)cValueAlternatives_0_0.eContents().get(1);
		private final Assignment cUnlimitedAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cUnlimitedAsteriskKeyword_1_0 = (Keyword)cUnlimitedAssignment_1.eContents().get(0);
		
		//LiteralIntegerOrUnlimitedNaturalRule:
		//	value=(INT | VALUE_SPECIFICATION_NEGATIVE_INT) | unlimited="*";
		@Override public ParserRule getRule() { return rule; }

		//value=(INT | VALUE_SPECIFICATION_NEGATIVE_INT) | unlimited="*"
		public Alternatives getAlternatives() { return cAlternatives; }

		//value=(INT | VALUE_SPECIFICATION_NEGATIVE_INT)
		public Assignment getValueAssignment_0() { return cValueAssignment_0; }

		//INT | VALUE_SPECIFICATION_NEGATIVE_INT
		public Alternatives getValueAlternatives_0_0() { return cValueAlternatives_0_0; }

		//INT
		public RuleCall getValueINTTerminalRuleCall_0_0_0() { return cValueINTTerminalRuleCall_0_0_0; }

		//VALUE_SPECIFICATION_NEGATIVE_INT
		public RuleCall getValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1() { return cValueVALUE_SPECIFICATION_NEGATIVE_INTTerminalRuleCall_0_0_1; }

		//unlimited="*"
		public Assignment getUnlimitedAssignment_1() { return cUnlimitedAssignment_1; }

		//"*"
		public Keyword getUnlimitedAsteriskKeyword_1_0() { return cUnlimitedAsteriskKeyword_1_0; }
	}

	public class LiteralRealRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralRealRule");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralRealRule:
		//	value=VALUE_SPECIFICATION_DOUBLE;
		@Override public ParserRule getRule() { return rule; }

		//value=VALUE_SPECIFICATION_DOUBLE
		public Assignment getValueAssignment() { return cValueAssignment; }

		//VALUE_SPECIFICATION_DOUBLE
		public RuleCall getValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0() { return cValueVALUE_SPECIFICATION_DOUBLETerminalRuleCall_0; }
	}

	public class LiteralNullRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralNullRule");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueNullKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//LiteralNullRule:
		//	value="null";
		@Override public ParserRule getRule() { return rule; }

		//value="null"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"null"
		public Keyword getValueNullKeyword_0() { return cValueNullKeyword_0; }
	}

	public class LiteralStringRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LiteralStringRule");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//LiteralStringRule:
		//	value=STRING;
		@Override public ParserRule getRule() { return rule; }

		//value=STRING
		public Assignment getValueAssignment() { return cValueAssignment; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_0() { return cValueSTRINGTerminalRuleCall_0; }
	}

	public class UndefinedRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "UndefinedRule");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Keyword cValueUndefinedKeyword_0 = (Keyword)cValueAssignment.eContents().get(0);
		
		//UndefinedRule:
		//	value="<Undefined>";
		@Override public ParserRule getRule() { return rule; }

		//value="<Undefined>"
		public Assignment getValueAssignment() { return cValueAssignment; }

		//"<Undefined>"
		public Keyword getValueUndefinedKeyword_0() { return cValueUndefinedKeyword_0; }
	}

	public class VisibilityKindElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VisibilityKind");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Assignment cPublicAssignment_0 = (Assignment)cAlternatives.eContents().get(0);
		private final Keyword cPublicPlusSignKeyword_0_0 = (Keyword)cPublicAssignment_0.eContents().get(0);
		private final Assignment cPrivateAssignment_1 = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword cPrivateHyphenMinusKeyword_1_0 = (Keyword)cPrivateAssignment_1.eContents().get(0);
		private final Assignment cProtectedAssignment_2 = (Assignment)cAlternatives.eContents().get(2);
		private final Keyword cProtectedNumberSignKeyword_2_0 = (Keyword)cProtectedAssignment_2.eContents().get(0);
		private final Assignment cPackageAssignment_3 = (Assignment)cAlternatives.eContents().get(3);
		private final Keyword cPackageTildeKeyword_3_0 = (Keyword)cPackageAssignment_3.eContents().get(0);
		
		//VisibilityKind:
		//	public="+" | private="-" | protected="#" | package="~";
		@Override public ParserRule getRule() { return rule; }

		//public="+" | private="-" | protected="#" | package="~"
		public Alternatives getAlternatives() { return cAlternatives; }

		//public="+"
		public Assignment getPublicAssignment_0() { return cPublicAssignment_0; }

		//"+"
		public Keyword getPublicPlusSignKeyword_0_0() { return cPublicPlusSignKeyword_0_0; }

		//private="-"
		public Assignment getPrivateAssignment_1() { return cPrivateAssignment_1; }

		//"-"
		public Keyword getPrivateHyphenMinusKeyword_1_0() { return cPrivateHyphenMinusKeyword_1_0; }

		//protected="#"
		public Assignment getProtectedAssignment_2() { return cProtectedAssignment_2; }

		//"#"
		public Keyword getProtectedNumberSignKeyword_2_0() { return cProtectedNumberSignKeyword_2_0; }

		//package="~"
		public Assignment getPackageAssignment_3() { return cPackageAssignment_3; }

		//"~"
		public Keyword getPackageTildeKeyword_3_0() { return cPackageTildeKeyword_3_0; }
	}
	
	
	private final AbstractRuleElements pAbstractRule;
	private final LiteralBooleanRuleElements pLiteralBooleanRule;
	private final LiteralIntegerOrUnlimitedNaturalRuleElements pLiteralIntegerOrUnlimitedNaturalRule;
	private final LiteralRealRuleElements pLiteralRealRule;
	private final LiteralNullRuleElements pLiteralNullRule;
	private final LiteralStringRuleElements pLiteralStringRule;
	private final UndefinedRuleElements pUndefinedRule;
	private final VisibilityKindElements pVisibilityKind;
	private final TerminalRule tVALUE_SPECIFICATION_ID;
	private final TerminalRule tVALUE_SPECIFICATION_NEGATIVE_INT;
	private final TerminalRule tVALUE_SPECIFICATION_DOUBLE;
	
	private final Grammar grammar;

	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public UmlValueSpecificationGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pAbstractRule = new AbstractRuleElements();
		this.pLiteralBooleanRule = new LiteralBooleanRuleElements();
		this.pLiteralIntegerOrUnlimitedNaturalRule = new LiteralIntegerOrUnlimitedNaturalRuleElements();
		this.pLiteralRealRule = new LiteralRealRuleElements();
		this.pLiteralNullRule = new LiteralNullRuleElements();
		this.pLiteralStringRule = new LiteralStringRuleElements();
		this.pUndefinedRule = new UndefinedRuleElements();
		this.pVisibilityKind = new VisibilityKindElements();
		this.tVALUE_SPECIFICATION_ID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "VALUE_SPECIFICATION_ID");
		this.tVALUE_SPECIFICATION_NEGATIVE_INT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "VALUE_SPECIFICATION_NEGATIVE_INT");
		this.tVALUE_SPECIFICATION_DOUBLE = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "VALUE_SPECIFICATION_DOUBLE");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.papyrus.uml.textedit.valuespecification.xtext.UmlValueSpecification".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//AbstractRule:
	//	visibility=VisibilityKind? name=VALUE_SPECIFICATION_ID? (instanceSpecification=[uml::InstanceSpecification] |
	//	value=(LiteralBooleanRule | LiteralIntegerOrUnlimitedNaturalRule | LiteralRealRule | LiteralNullRule |
	//	LiteralStringRule) | undefined=UndefinedRule);
	public AbstractRuleElements getAbstractRuleAccess() {
		return pAbstractRule;
	}
	
	public ParserRule getAbstractRuleRule() {
		return getAbstractRuleAccess().getRule();
	}

	//LiteralBooleanRule:
	//	value=("true" | "false");
	public LiteralBooleanRuleElements getLiteralBooleanRuleAccess() {
		return pLiteralBooleanRule;
	}
	
	public ParserRule getLiteralBooleanRuleRule() {
		return getLiteralBooleanRuleAccess().getRule();
	}

	//LiteralIntegerOrUnlimitedNaturalRule:
	//	value=(INT | VALUE_SPECIFICATION_NEGATIVE_INT) | unlimited="*";
	public LiteralIntegerOrUnlimitedNaturalRuleElements getLiteralIntegerOrUnlimitedNaturalRuleAccess() {
		return pLiteralIntegerOrUnlimitedNaturalRule;
	}
	
	public ParserRule getLiteralIntegerOrUnlimitedNaturalRuleRule() {
		return getLiteralIntegerOrUnlimitedNaturalRuleAccess().getRule();
	}

	//LiteralRealRule:
	//	value=VALUE_SPECIFICATION_DOUBLE;
	public LiteralRealRuleElements getLiteralRealRuleAccess() {
		return pLiteralRealRule;
	}
	
	public ParserRule getLiteralRealRuleRule() {
		return getLiteralRealRuleAccess().getRule();
	}

	//LiteralNullRule:
	//	value="null";
	public LiteralNullRuleElements getLiteralNullRuleAccess() {
		return pLiteralNullRule;
	}
	
	public ParserRule getLiteralNullRuleRule() {
		return getLiteralNullRuleAccess().getRule();
	}

	//LiteralStringRule:
	//	value=STRING;
	public LiteralStringRuleElements getLiteralStringRuleAccess() {
		return pLiteralStringRule;
	}
	
	public ParserRule getLiteralStringRuleRule() {
		return getLiteralStringRuleAccess().getRule();
	}

	//UndefinedRule:
	//	value="<Undefined>";
	public UndefinedRuleElements getUndefinedRuleAccess() {
		return pUndefinedRule;
	}
	
	public ParserRule getUndefinedRuleRule() {
		return getUndefinedRuleAccess().getRule();
	}

	//VisibilityKind:
	//	public="+" | private="-" | protected="#" | package="~";
	public VisibilityKindElements getVisibilityKindAccess() {
		return pVisibilityKind;
	}
	
	public ParserRule getVisibilityKindRule() {
		return getVisibilityKindAccess().getRule();
	}

	//// Manage the basic terminals
	//terminal VALUE_SPECIFICATION_ID:
	//	("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "-" | "0".."9")* "=";
	public TerminalRule getVALUE_SPECIFICATION_IDRule() {
		return tVALUE_SPECIFICATION_ID;
	} 

	//terminal VALUE_SPECIFICATION_NEGATIVE_INT returns ecore::EInt:
	//	"-" INT;
	public TerminalRule getVALUE_SPECIFICATION_NEGATIVE_INTRule() {
		return tVALUE_SPECIFICATION_NEGATIVE_INT;
	} 

	//terminal VALUE_SPECIFICATION_DOUBLE returns ecore::EDouble:
	//	"-"? (INT ("." | ",") INT | INT ("." | ",") | ("." | ",") INT);
	public TerminalRule getVALUE_SPECIFICATION_DOUBLERule() {
		return tVALUE_SPECIFICATION_DOUBLE;
	} 

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" . / * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\""))* "\"" | "\'" ("\\" .
	//	/ * 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' * / | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
