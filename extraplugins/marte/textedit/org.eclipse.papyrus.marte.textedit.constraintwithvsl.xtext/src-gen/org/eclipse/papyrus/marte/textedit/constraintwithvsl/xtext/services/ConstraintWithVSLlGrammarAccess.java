/*
 * generated by Xtext
 */

package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.services;

import org.eclipse.papyrus.marte.vsl.services.VSLGrammarAccess;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder.AbstractGrammarElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ConstraintWithVSLlGrammarAccess extends AbstractGrammarElementFinder {


	public class ConstraintRuleElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConstraintRule");
		private final Assignment cSpecificationAssignment = (Assignment) rule.eContents().get(1);
		private final RuleCall cSpecificationConstraintSpecificationParserRuleCall_0 = (RuleCall) cSpecificationAssignment.eContents().get(0);

		// ConstraintRule:
		// specification=ConstraintSpecification?;
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// specification=ConstraintSpecification?
		public Assignment getSpecificationAssignment() {
			return cSpecificationAssignment;
		}

		// ConstraintSpecification
		public RuleCall getSpecificationConstraintSpecificationParserRuleCall_0() {
			return cSpecificationConstraintSpecificationParserRuleCall_0;
		}
	}

	public class ConstraintSpecificationElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ConstraintSpecification");
		private final Assignment cExpressionAssignment = (Assignment) rule.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_0 = (RuleCall) cExpressionAssignment.eContents().get(0);

		// ConstraintSpecification:
		// expression=Expression;
		@Override
		public ParserRule getRule() {
			return rule;
		}

		// expression=Expression
		public Assignment getExpressionAssignment() {
			return cExpressionAssignment;
		}

		// Expression
		public RuleCall getExpressionExpressionParserRuleCall_0() {
			return cExpressionExpressionParserRuleCall_0;
		}
	}


	private ConstraintRuleElements pConstraintRule;
	private ConstraintSpecificationElements pConstraintSpecification;

	private final GrammarProvider grammarProvider;

	private VSLGrammarAccess gaVSL;

	@Inject
	public ConstraintWithVSLlGrammarAccess(GrammarProvider grammarProvider,
			VSLGrammarAccess gaVSL) {
		this.grammarProvider = grammarProvider;
		this.gaVSL = gaVSL;
	}

	@Override
	public Grammar getGrammar() {
		return grammarProvider.getGrammar(this);
	}


	public VSLGrammarAccess getVSLGrammarAccess() {
		return gaVSL;
	}


	// ConstraintRule:
	// specification=ConstraintSpecification?;
	public ConstraintRuleElements getConstraintRuleAccess() {
		return (pConstraintRule != null) ? pConstraintRule : (pConstraintRule = new ConstraintRuleElements());
	}

	public ParserRule getConstraintRuleRule() {
		return getConstraintRuleAccess().getRule();
	}

	// ConstraintSpecification:
	// expression=Expression;
	public ConstraintSpecificationElements getConstraintSpecificationAccess() {
		return (pConstraintSpecification != null) ? pConstraintSpecification : (pConstraintSpecification = new ConstraintSpecificationElements());
	}

	public ParserRule getConstraintSpecificationRule() {
		return getConstraintSpecificationAccess().getRule();
	}

	// Expression:
	// exp=AndOrXorExpression;
	public VSLGrammarAccess.ExpressionElements getExpressionAccess() {
		return gaVSL.getExpressionAccess();
	}

	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	// AndOrXorExpression:
	// exp+=EqualityExpression (op+=("and" | "or" | "xor") exp+=EqualityExpression)*;
	public VSLGrammarAccess.AndOrXorExpressionElements getAndOrXorExpressionAccess() {
		return gaVSL.getAndOrXorExpressionAccess();
	}

	public ParserRule getAndOrXorExpressionRule() {
		return getAndOrXorExpressionAccess().getRule();
	}

	// EqualityExpression:
	// exp+=RelationalExpression (op+=("==" | "<>") exp+=RelationalExpression)*;
	public VSLGrammarAccess.EqualityExpressionElements getEqualityExpressionAccess() {
		return gaVSL.getEqualityExpressionAccess();
	}

	public ParserRule getEqualityExpressionRule() {
		return getEqualityExpressionAccess().getRule();
	}

	// RelationalExpression:
	// exp+=ConditionalExpression (op+=("<" | ">" | "<=" | ">=") exp+=ConditionalExpression)*;
	public VSLGrammarAccess.RelationalExpressionElements getRelationalExpressionAccess() {
		return gaVSL.getRelationalExpressionAccess();
	}

	public ParserRule getRelationalExpressionRule() {
		return getRelationalExpressionAccess().getRule();
	}

	// ConditionalExpression:
	// exp+=AdditiveExpression (op+="?" exp+=AdditiveExpression ":" exp+=AdditiveExpression)?;
	public VSLGrammarAccess.ConditionalExpressionElements getConditionalExpressionAccess() {
		return gaVSL.getConditionalExpressionAccess();
	}

	public ParserRule getConditionalExpressionRule() {
		return getConditionalExpressionAccess().getRule();
	}

	// AdditiveExpression:
	// exp+=MultiplicativeExpression (op+=("+" | "-") exp+=MultiplicativeExpression)*;
	public VSLGrammarAccess.AdditiveExpressionElements getAdditiveExpressionAccess() {
		return gaVSL.getAdditiveExpressionAccess();
	}

	public ParserRule getAdditiveExpressionRule() {
		return getAdditiveExpressionAccess().getRule();
	}

	// MultiplicativeExpression:
	// exp+=UnaryExpression (op+=("*" | "/" | "mod") exp+=UnaryExpression)*;
	public VSLGrammarAccess.MultiplicativeExpressionElements getMultiplicativeExpressionAccess() {
		return gaVSL.getMultiplicativeExpressionAccess();
	}

	public ParserRule getMultiplicativeExpressionRule() {
		return getMultiplicativeExpressionAccess().getRule();
	}

	// UnaryExpression:
	// op=("not" | "-" | "+") unary=UnaryExpression | exp=PrimaryExpression;
	public VSLGrammarAccess.UnaryExpressionElements getUnaryExpressionAccess() {
		return gaVSL.getUnaryExpressionAccess();
	}

	public ParserRule getUnaryExpressionRule() {
		return getUnaryExpressionAccess().getRule();
	}

	// PrimaryExpression:
	// prefix=ValueSpecification ("." suffix=SuffixExpression)?;
	public VSLGrammarAccess.PrimaryExpressionElements getPrimaryExpressionAccess() {
		return gaVSL.getPrimaryExpressionAccess();
	}

	public ParserRule getPrimaryExpressionRule() {
		return getPrimaryExpressionAccess().getRule();
	}

	// ValueSpecification:
	// Literal | NameOrChoiceOrBehaviorCall | Interval | CollectionOrTuple | Tuple | TimeExpression | VariableDeclaration |
	// "(" Expression ")";
	public VSLGrammarAccess.ValueSpecificationElements getValueSpecificationAccess() {
		return gaVSL.getValueSpecificationAccess();
	}

	public ParserRule getValueSpecificationRule() {
		return getValueSpecificationAccess().getRule();
	}

	// SuffixExpression:
	// PropertyCallExpression | OperationCallExpression;
	public VSLGrammarAccess.SuffixExpressionElements getSuffixExpressionAccess() {
		return gaVSL.getSuffixExpressionAccess();
	}

	public ParserRule getSuffixExpressionRule() {
		return getSuffixExpressionAccess().getRule();
	}

	// PropertyCallExpression:
	// property=[uml::Property] ("." suffix=SuffixExpression)?;
	public VSLGrammarAccess.PropertyCallExpressionElements getPropertyCallExpressionAccess() {
		return gaVSL.getPropertyCallExpressionAccess();
	}

	public ParserRule getPropertyCallExpressionRule() {
		return getPropertyCallExpressionAccess().getRule();
	}

	// OperationCallExpression:
	// operation=[uml::Operation] "(" arguments=ListOfValues? ")" ("." suffix=SuffixExpression)?;
	public VSLGrammarAccess.OperationCallExpressionElements getOperationCallExpressionAccess() {
		return gaVSL.getOperationCallExpressionAccess();
	}

	public ParserRule getOperationCallExpressionRule() {
		return getOperationCallExpressionAccess().getRule();
	}

	// Literal:
	// NumberLiteralRule | DateTimeLiteralRule | BooleanLiteralRule | NullLiteralRule | DefaultLiteralRule |
	// StringLiteralRule;
	public VSLGrammarAccess.LiteralElements getLiteralAccess() {
		return gaVSL.getLiteralAccess();
	}

	public ParserRule getLiteralRule() {
		return getLiteralAccess().getRule();
	}

	// NameOrChoiceOrBehaviorCall:
	// path=QualifiedName? // can resolve to :
	// // - EnumSpecification,
	// // - VariableCallExpression
	// // - PropertyCallExpression
	// // - ChoiceExpression
	// id=[uml::NamedElement] ("(" arguments=ListOfValues? ")")?;
	public VSLGrammarAccess.NameOrChoiceOrBehaviorCallElements getNameOrChoiceOrBehaviorCallAccess() {
		return gaVSL.getNameOrChoiceOrBehaviorCallAccess();
	}

	public ParserRule getNameOrChoiceOrBehaviorCallRule() {
		return getNameOrChoiceOrBehaviorCallAccess().getRule();
	}

	// QualifiedName:
	// path=[uml::Namespace] "::" remaining=QualifiedName?;
	public VSLGrammarAccess.QualifiedNameElements getQualifiedNameAccess() {
		return gaVSL.getQualifiedNameAccess();
	}

	public ParserRule getQualifiedNameRule() {
		return getQualifiedNameAccess().getRule();
	}

	// Interval:
	// ("]" | isLowerIncluded="[") lower=Expression ".." upper=Expression (isUpperIncluded="]" | "[");
	public VSLGrammarAccess.IntervalElements getIntervalAccess() {
		return gaVSL.getIntervalAccess();
	}

	public ParserRule getIntervalRule() {
		return getIntervalAccess().getRule();
	}

	// CollectionOrTuple:
	// "{" listOfValues=ListOfValues "}";
	public VSLGrammarAccess.CollectionOrTupleElements getCollectionOrTupleAccess() {
		return gaVSL.getCollectionOrTupleAccess();
	}

	public ParserRule getCollectionOrTupleRule() {
		return getCollectionOrTupleAccess().getRule();
	}

	// Tuple:
	// "{" listOfValueNamePairs=ListOfValueNamePairs "}";
	public VSLGrammarAccess.TupleElements getTupleAccess() {
		return gaVSL.getTupleAccess();
	}

	public ParserRule getTupleRule() {
		return getTupleAccess().getRule();
	}

	// ListOfValues:
	// values+=Expression ("," values+=Expression)*;
	public VSLGrammarAccess.ListOfValuesElements getListOfValuesAccess() {
		return gaVSL.getListOfValuesAccess();
	}

	public ParserRule getListOfValuesRule() {
		return getListOfValuesAccess().getRule();
	}

	// ListOfValueNamePairs:
	// valueNamePairs+=ValueNamePair ("," valueNamePairs+=ValueNamePair)*;
	public VSLGrammarAccess.ListOfValueNamePairsElements getListOfValueNamePairsAccess() {
		return gaVSL.getListOfValueNamePairsAccess();
	}

	public ParserRule getListOfValueNamePairsRule() {
		return getListOfValueNamePairsAccess().getRule();
	}

	// ValueNamePair:
	// property=[uml::Property] "=" value=Expression;
	public VSLGrammarAccess.ValueNamePairElements getValueNamePairAccess() {
		return gaVSL.getValueNamePairAccess();
	}

	public ParserRule getValueNamePairRule() {
		return getValueNamePairAccess().getRule();
	}

	// TimeExpression:
	// InstantObsExpression | DurationObsExpression | JitterExp;
	public VSLGrammarAccess.TimeExpressionElements getTimeExpressionAccess() {
		return gaVSL.getTimeExpressionAccess();
	}

	public ParserRule getTimeExpressionRule() {
		return getTimeExpressionAccess().getRule();
	}

	// InstantObsExpression:
	// "@" id=InstantObsName ("(" index=Expression ")")? ("when" "(" condition=Expression ")")?;
	public VSLGrammarAccess.InstantObsExpressionElements getInstantObsExpressionAccess() {
		return gaVSL.getInstantObsExpressionAccess();
	}

	public ParserRule getInstantObsExpressionRule() {
		return getInstantObsExpressionAccess().getRule();
	}

	// InstantObsName:
	// path=QualifiedName? instantId=[uml::TimeObservation];
	public VSLGrammarAccess.InstantObsNameElements getInstantObsNameAccess() {
		return gaVSL.getInstantObsNameAccess();
	}

	public ParserRule getInstantObsNameRule() {
		return getInstantObsNameAccess().getRule();
	}

	// DurationObsExpression:
	// "&" id=DurationObsName ("(" index=Expression ")")? ("when" "(" condition=Expression ")")?;
	public VSLGrammarAccess.DurationObsExpressionElements getDurationObsExpressionAccess() {
		return gaVSL.getDurationObsExpressionAccess();
	}

	public ParserRule getDurationObsExpressionRule() {
		return getDurationObsExpressionAccess().getRule();
	}

	// DurationObsName:
	// path=QualifiedName? durationId=[uml::DurationObservation];
	public VSLGrammarAccess.DurationObsNameElements getDurationObsNameAccess() {
		return gaVSL.getDurationObsNameAccess();
	}

	public ParserRule getDurationObsNameRule() {
		return getDurationObsNameAccess().getRule();
	}

	// JitterExp:
	// "jitter(" firstInstant=InstantObsExpression ("-" secondInstant=InstantObsExpression)? ")";
	public VSLGrammarAccess.JitterExpElements getJitterExpAccess() {
		return gaVSL.getJitterExpAccess();
	}

	public ParserRule getJitterExpRule() {
		return getJitterExpAccess().getRule();
	}

	// VariableDeclaration:
	// variableDeclaration=VariableDirectionKind? "$" name=ID (":" type=DataTypeName ("=" "(" initValue=Expression ")")? |
	// "=" "(" initValue=Expression ")");
	public VSLGrammarAccess.VariableDeclarationElements getVariableDeclarationAccess() {
		return gaVSL.getVariableDeclarationAccess();
	}

	public ParserRule getVariableDeclarationRule() {
		return getVariableDeclarationAccess().getRule();
	}

	// VariableDirectionKind:
	// "in" | "out" | "inout";
	public VSLGrammarAccess.VariableDirectionKindElements getVariableDirectionKindAccess() {
		return gaVSL.getVariableDirectionKindAccess();
	}

	public ParserRule getVariableDirectionKindRule() {
		return getVariableDirectionKindAccess().getRule();
	}

	// DataTypeName:
	// path=QualifiedName? type=[uml::DataType];
	public VSLGrammarAccess.DataTypeNameElements getDataTypeNameAccess() {
		return gaVSL.getDataTypeNameAccess();
	}

	public ParserRule getDataTypeNameRule() {
		return getDataTypeNameAccess().getRule();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////
	// //LITERAL
	// //////////////////////////////////////////////////////////////////////////////////////////////////////
	// NumberLiteralRule:
	// IntegerLiteralRule | UnlimitedLiteralRule | RealLiteralRule;
	public VSLGrammarAccess.NumberLiteralRuleElements getNumberLiteralRuleAccess() {
		return gaVSL.getNumberLiteralRuleAccess();
	}

	public ParserRule getNumberLiteralRuleRule() {
		return getNumberLiteralRuleAccess().getRule();
	}

	// IntegerLiteralRule:
	// value=IntegerLiteral;
	public VSLGrammarAccess.IntegerLiteralRuleElements getIntegerLiteralRuleAccess() {
		return gaVSL.getIntegerLiteralRuleAccess();
	}

	public ParserRule getIntegerLiteralRuleRule() {
		return getIntegerLiteralRuleAccess().getRule();
	}

	// terminal IntegerLiteral:
	// ("+" | "-")? ("0".."9"+ | "0x" ("0".."9" | "A".."F" | "a".."f")+ | "0b" "0".."1"+);
	public TerminalRule getIntegerLiteralRule() {
		return gaVSL.getIntegerLiteralRule();
	}

	// //UnlimitedLiteralRule :
	// // value = UnlimitedLiteral ;
	// //terminal UnlimitedLiteral :
	// // '*' ;
	// UnlimitedLiteralRule:
	// value="*";
	public VSLGrammarAccess.UnlimitedLiteralRuleElements getUnlimitedLiteralRuleAccess() {
		return gaVSL.getUnlimitedLiteralRuleAccess();
	}

	public ParserRule getUnlimitedLiteralRuleRule() {
		return getUnlimitedLiteralRuleAccess().getRule();
	}

	// RealLiteralRule:
	// value=RealLiteral;
	public VSLGrammarAccess.RealLiteralRuleElements getRealLiteralRuleAccess() {
		return gaVSL.getRealLiteralRuleAccess();
	}

	public ParserRule getRealLiteralRuleRule() {
		return getRealLiteralRuleAccess().getRule();
	}

	// terminal RealLiteral:
	// ("+" | "-")? "0".."9"+ "." "0".."9"+ ("E" ("+" | "-")? "0".."9"+)?;
	public TerminalRule getRealLiteralRule() {
		return gaVSL.getRealLiteralRule();
	}

	// //DateTimeLiteral:
	// // TimeString (DateString)? (DayString)? |
	// // DateString (DayString)? |
	// // DayString ;
	// //terminal DateString :
	// // ('0'..'9')('0'..'9')('0'..'9')('0'..'9')'/'('0'('0'..'9')|'1'('0'..'2'))'/'(('0'..'2')('0'..'9')|'3' ('0'|'1')) ;
	// //terminal TimeString :
	// // (('0'..'1')('0'..'9')|'2'('0'..'3'))':'('0'..'5')('0'..'9')(':'('0'..'5')('0'..'9')(':'('0'..'9')('0'..'9'))?)? ;
	// //terminal DayString :
	// // "Mon" | "Tue" | "Wed" | "Thr" | "Fri" | "Sat" | "Sun" ;
	// DateTimeLiteralRule:
	// value=DateTimeLiteral;
	public VSLGrammarAccess.DateTimeLiteralRuleElements getDateTimeLiteralRuleAccess() {
		return gaVSL.getDateTimeLiteralRuleAccess();
	}

	public ParserRule getDateTimeLiteralRuleRule() {
		return getDateTimeLiteralRuleAccess().getRule();
	}

	// terminal DateTimeLiteral:
	// (("0".."1" "0".."9" | "2" "0".."3") ":" "0".."5" "0".."9" (":" "0".."5" "0".."9" (":" "0".."9" "0".."9")?)?) (" "
	// "0".."9" "0".."9" "0".."9" "0".."9" "/" ("0" "0".."9" | "1" "0".."2") "/" ("0".."2" "0".."9" | "3" ("0" | "1")))? (" "
	// ("Mon" | "Tue" | "Wed" | "Thr" | "Fri" | "Sat" | "Sun"))? | ("0".."9" "0".."9" "0".."9" "0".."9" "/" ("0" "0".."9" |
	// "1" "0".."2") "/" ("0".."2" "0".."9" | "3" ("0" | "1"))) (" " ("Mon" | "Tue" | "Wed" | "Thr" | "Fri" | "Sat" |
	// "Sun"))? | ("Mon" | "Tue" | "Wed" | "Thr" | "Fri" | "Sat" | "Sun");
	public TerminalRule getDateTimeLiteralRule() {
		return gaVSL.getDateTimeLiteralRule();
	}

	// BooleanLiteralRule:
	// value=BooleanLiteral;
	public VSLGrammarAccess.BooleanLiteralRuleElements getBooleanLiteralRuleAccess() {
		return gaVSL.getBooleanLiteralRuleAccess();
	}

	public ParserRule getBooleanLiteralRuleRule() {
		return getBooleanLiteralRuleAccess().getRule();
	}

	// terminal BooleanLiteral:
	// "true" | "false";
	public TerminalRule getBooleanLiteralRule() {
		return gaVSL.getBooleanLiteralRule();
	}

	// NullLiteralRule:
	// value=NullLiteral;
	public VSLGrammarAccess.NullLiteralRuleElements getNullLiteralRuleAccess() {
		return gaVSL.getNullLiteralRuleAccess();
	}

	public ParserRule getNullLiteralRuleRule() {
		return getNullLiteralRuleAccess().getRule();
	}

	// terminal NullLiteral:
	// "null";
	public TerminalRule getNullLiteralRule() {
		return gaVSL.getNullLiteralRule();
	}

	// //DefaultLiteralRule :
	// // value = DefaultLiteral ;
	// //terminal DefaultLiteral :
	// // '/' ;
	// DefaultLiteralRule:
	// value="/";
	public VSLGrammarAccess.DefaultLiteralRuleElements getDefaultLiteralRuleAccess() {
		return gaVSL.getDefaultLiteralRuleAccess();
	}

	public ParserRule getDefaultLiteralRuleRule() {
		return getDefaultLiteralRuleAccess().getRule();
	}

	// StringLiteralRule:
	// value=STRING;
	public VSLGrammarAccess.StringLiteralRuleElements getStringLiteralRuleAccess() {
		return gaVSL.getStringLiteralRuleAccess();
	}

	public ParserRule getStringLiteralRuleRule() {
		return getStringLiteralRuleAccess().getRule();
	}

	// terminal ID:
	// "^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaVSL.getIDRule();
	}

	// terminal INT returns ecore::EInt:
	// "0".."9"+;
	public TerminalRule getINTRule() {
		return gaVSL.getINTRule();
	}

	// terminal STRING:
	// "\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	// "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaVSL.getSTRINGRule();
	}

	// terminal ML_COMMENT:
	// "/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaVSL.getML_COMMENTRule();
	}

	// terminal SL_COMMENT:
	// "//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaVSL.getSL_COMMENTRule();
	}

	// terminal WS:
	// (" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaVSL.getWSRule();
	}

	// terminal ANY_OTHER:
	// .;
	public TerminalRule getANY_OTHERRule() {
		return gaVSL.getANY_OTHERRule();
	}
}
