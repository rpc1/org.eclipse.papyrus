/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.alf.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AlfSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlfGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_SequenceExpressionList_CommaKeyword_2_q;
	protected AbstractElementAlias match_SequenceInitializationExpression_NewKeyword_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlfGrammarAccess) access;
		match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getColonColonKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getAsteriskKeyword_1_0_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getFullStopKeyword_1_1_1()), new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getAsteriskKeyword_1_1_2())));
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_SequenceExpressionList_CommaKeyword_2_q = new TokenAlias(false, true, grammarAccess.getSequenceExpressionListAccess().getCommaKeyword_2());
		match_SequenceInitializationExpression_NewKeyword_0_q = new TokenAlias(false, true, grammarAccess.getSequenceInitializationExpressionAccess().getNewKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getMultiplicityIndicatorRule())
			return getMultiplicityIndicatorToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getReclassifyAllClauseRule())
			return getReclassifyAllClauseToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * MultiplicityIndicator : 
	 * 	'[' ']'
	 * ;
	 */
	protected String getMultiplicityIndicatorToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * ReclassifyAllClause : 
	 * 	'from' '*'
	 * ;
	 */
	protected String getReclassifyAllClauseToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "from*";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__.equals(syntax))
				emit_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SequenceExpressionList_CommaKeyword_2_q.equals(syntax))
				emit_SequenceExpressionList_CommaKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SequenceInitializationExpression_NewKeyword_0_q.equals(syntax))
				emit_SequenceInitializationExpression_NewKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ('::' '*') | ('.' '*')
	 *
	 * This ambiguous syntax occurs at:
	 *     nameBinding+=NameBinding (ambiguity) (rule end)
	 */
	protected void emit_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '=' (ambiguity) '(' isAny?='any'
	 *     (rule start) '=' (ambiguity) '(' typeName=QualifiedName
	 *     (rule start) '=' (ambiguity) '*' (rule start)
	 *     (rule start) '=' (ambiguity) 'new' constructor=QualifiedName
	 *     (rule start) '=' (ambiguity) 'new' typeName=QualifiedName
	 *     (rule start) '=' (ambiguity) 'super' '.' target=QualifiedName
	 *     (rule start) '=' (ambiguity) 'super' tuple=Tuple
	 *     (rule start) '=' (ambiguity) 'this' (rule start)
	 *     (rule start) '=' (ambiguity) 'this' tuple=Tuple
	 *     (rule start) '=' (ambiguity) associationName=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '=' (ambiguity) className=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '=' (ambiguity) hasMultiplicity?='null'
	 *     (rule start) '=' (ambiguity) image=BOOLEAN_VALUE
	 *     (rule start) '=' (ambiguity) image=NATURAL_VALUE
	 *     (rule start) '=' (ambiguity) image=STRING
	 *     (rule start) '=' (ambiguity) isAny?='any'
	 *     (rule start) '=' (ambiguity) leftHandSide=LeftHandSide
	 *     (rule start) '=' (ambiguity) name=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '=' (ambiguity) operand=LeftHandSide
	 *     (rule start) '=' (ambiguity) operator='!'
	 *     (rule start) '=' (ambiguity) operator='$'
	 *     (rule start) '=' (ambiguity) operator='~'
	 *     (rule start) '=' (ambiguity) operator=AffixOperator
	 *     (rule start) '=' (ambiguity) operator=NumericUnaryOperator
	 *     (rule start) '=' (ambiguity) target=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '=' (ambiguity) typeName=QualifiedName
	 *     (rule start) '=' (ambiguity) {ArithmeticExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {ClassificationExpression.operand=}
	 *     (rule start) '=' (ambiguity) {ConditionalLogicalExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {ConditionalTestExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {EqualityExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {FeatureInvocationExpression.target=}
	 *     (rule start) '=' (ambiguity) {LogicalExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {PropertyAccessExpression.featureReference=}
	 *     (rule start) '=' (ambiguity) {RelationalExpression.operand1=}
	 *     (rule start) '=' (ambiguity) {SequenceAccessExpression.primary=}
	 *     (rule start) '=' (ambiguity) {SequenceExpansionExpression.primary=}
	 *     (rule start) '=' (ambiguity) {SequenceOperationExpression.primary=}
	 *     (rule start) '=' (ambiguity) {SequenceReductionExpression.primary=}
	 *     (rule start) '=' (ambiguity) {ShiftExpression.operand1=}
	 *     (rule start) '[' (ambiguity) '(' isAny?='any'
	 *     (rule start) '[' (ambiguity) '(' typeName=QualifiedName
	 *     (rule start) '[' (ambiguity) '*' ']' (rule start)
	 *     (rule start) '[' (ambiguity) 'new' constructor=QualifiedName
	 *     (rule start) '[' (ambiguity) 'new' typeName=QualifiedName
	 *     (rule start) '[' (ambiguity) 'super' '.' target=QualifiedName
	 *     (rule start) '[' (ambiguity) 'super' tuple=Tuple
	 *     (rule start) '[' (ambiguity) 'this' ']' (rule start)
	 *     (rule start) '[' (ambiguity) 'this' tuple=Tuple
	 *     (rule start) '[' (ambiguity) associationName=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '[' (ambiguity) className=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '[' (ambiguity) hasMultiplicity?='null'
	 *     (rule start) '[' (ambiguity) image=BOOLEAN_VALUE
	 *     (rule start) '[' (ambiguity) image=NATURAL_VALUE
	 *     (rule start) '[' (ambiguity) image=STRING
	 *     (rule start) '[' (ambiguity) isAny?='any'
	 *     (rule start) '[' (ambiguity) leftHandSide=LeftHandSide
	 *     (rule start) '[' (ambiguity) name=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '[' (ambiguity) operand=LeftHandSide
	 *     (rule start) '[' (ambiguity) operator='!'
	 *     (rule start) '[' (ambiguity) operator='$'
	 *     (rule start) '[' (ambiguity) operator='~'
	 *     (rule start) '[' (ambiguity) operator=AffixOperator
	 *     (rule start) '[' (ambiguity) operator=NumericUnaryOperator
	 *     (rule start) '[' (ambiguity) target=PotentiallyAmbiguousQualifiedName
	 *     (rule start) '[' (ambiguity) typeName=QualifiedName
	 *     (rule start) '[' (ambiguity) {ArithmeticExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {ClassificationExpression.operand=}
	 *     (rule start) '[' (ambiguity) {ConditionalLogicalExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {ConditionalTestExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {EqualityExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {FeatureInvocationExpression.target=}
	 *     (rule start) '[' (ambiguity) {LogicalExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {PropertyAccessExpression.featureReference=}
	 *     (rule start) '[' (ambiguity) {RelationalExpression.operand1=}
	 *     (rule start) '[' (ambiguity) {SequenceAccessExpression.primary=}
	 *     (rule start) '[' (ambiguity) {SequenceExpansionExpression.primary=}
	 *     (rule start) '[' (ambiguity) {SequenceOperationExpression.primary=}
	 *     (rule start) '[' (ambiguity) {SequenceReductionExpression.primary=}
	 *     (rule start) '[' (ambiguity) {ShiftExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) '(' isAny?='any'
	 *     (rule start) 'case' (ambiguity) '(' typeName=QualifiedName
	 *     (rule start) 'case' (ambiguity) '*' ':' (rule start)
	 *     (rule start) 'case' (ambiguity) 'new' constructor=QualifiedName
	 *     (rule start) 'case' (ambiguity) 'new' typeName=QualifiedName
	 *     (rule start) 'case' (ambiguity) 'super' '.' target=QualifiedName
	 *     (rule start) 'case' (ambiguity) 'super' tuple=Tuple
	 *     (rule start) 'case' (ambiguity) 'this' ':' (rule start)
	 *     (rule start) 'case' (ambiguity) 'this' tuple=Tuple
	 *     (rule start) 'case' (ambiguity) associationName=PotentiallyAmbiguousQualifiedName
	 *     (rule start) 'case' (ambiguity) className=PotentiallyAmbiguousQualifiedName
	 *     (rule start) 'case' (ambiguity) hasMultiplicity?='null'
	 *     (rule start) 'case' (ambiguity) image=BOOLEAN_VALUE
	 *     (rule start) 'case' (ambiguity) image=NATURAL_VALUE
	 *     (rule start) 'case' (ambiguity) image=STRING
	 *     (rule start) 'case' (ambiguity) isAny?='any'
	 *     (rule start) 'case' (ambiguity) leftHandSide=LeftHandSide
	 *     (rule start) 'case' (ambiguity) name=PotentiallyAmbiguousQualifiedName
	 *     (rule start) 'case' (ambiguity) operand=LeftHandSide
	 *     (rule start) 'case' (ambiguity) operator='!'
	 *     (rule start) 'case' (ambiguity) operator='$'
	 *     (rule start) 'case' (ambiguity) operator='~'
	 *     (rule start) 'case' (ambiguity) operator=AffixOperator
	 *     (rule start) 'case' (ambiguity) operator=NumericUnaryOperator
	 *     (rule start) 'case' (ambiguity) target=PotentiallyAmbiguousQualifiedName
	 *     (rule start) 'case' (ambiguity) typeName=QualifiedName
	 *     (rule start) 'case' (ambiguity) {ArithmeticExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {ClassificationExpression.operand=}
	 *     (rule start) 'case' (ambiguity) {ConditionalLogicalExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {ConditionalTestExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {EqualityExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {FeatureInvocationExpression.target=}
	 *     (rule start) 'case' (ambiguity) {LogicalExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {PropertyAccessExpression.featureReference=}
	 *     (rule start) 'case' (ambiguity) {RelationalExpression.operand1=}
	 *     (rule start) 'case' (ambiguity) {SequenceAccessExpression.primary=}
	 *     (rule start) 'case' (ambiguity) {SequenceExpansionExpression.primary=}
	 *     (rule start) 'case' (ambiguity) {SequenceOperationExpression.primary=}
	 *     (rule start) 'case' (ambiguity) {SequenceReductionExpression.primary=}
	 *     (rule start) 'case' (ambiguity) {ShiftExpression.operand1=}
	 *     (rule start) (ambiguity) '(' isAny?='any'
	 *     (rule start) (ambiguity) '(' typeName=QualifiedName
	 *     (rule start) (ambiguity) '*' (rule start)
	 *     (rule start) (ambiguity) 'new' constructor=QualifiedName
	 *     (rule start) (ambiguity) 'new' typeName=QualifiedName
	 *     (rule start) (ambiguity) 'super' '.' target=QualifiedName
	 *     (rule start) (ambiguity) 'super' tuple=Tuple
	 *     (rule start) (ambiguity) 'this' (rule start)
	 *     (rule start) (ambiguity) 'this' tuple=Tuple
	 *     (rule start) (ambiguity) associationName=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) className=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) hasMultiplicity?='null'
	 *     (rule start) (ambiguity) image=BOOLEAN_VALUE
	 *     (rule start) (ambiguity) image=NATURAL_VALUE
	 *     (rule start) (ambiguity) image=STRING
	 *     (rule start) (ambiguity) isAny?='any'
	 *     (rule start) (ambiguity) leftHandSide=LeftHandSide
	 *     (rule start) (ambiguity) name=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) operand=LeftHandSide
	 *     (rule start) (ambiguity) operator='!'
	 *     (rule start) (ambiguity) operator='$'
	 *     (rule start) (ambiguity) operator='~'
	 *     (rule start) (ambiguity) operator=AffixOperator
	 *     (rule start) (ambiguity) operator=NumericUnaryOperator
	 *     (rule start) (ambiguity) target=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) typeName=QualifiedName
	 *     (rule start) (ambiguity) {ArithmeticExpression.operand1=}
	 *     (rule start) (ambiguity) {ClassificationExpression.operand=}
	 *     (rule start) (ambiguity) {ConditionalLogicalExpression.operand1=}
	 *     (rule start) (ambiguity) {ConditionalTestExpression.operand1=}
	 *     (rule start) (ambiguity) {EqualityExpression.operand1=}
	 *     (rule start) (ambiguity) {FeatureInvocationExpression.target=}
	 *     (rule start) (ambiguity) {LogicalExpression.operand1=}
	 *     (rule start) (ambiguity) {PropertyAccessExpression.featureReference=}
	 *     (rule start) (ambiguity) {RelationalExpression.operand1=}
	 *     (rule start) (ambiguity) {SequenceAccessExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceExpansionExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceOperationExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceReductionExpression.primary=}
	 *     (rule start) (ambiguity) {ShiftExpression.operand1=}
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '(' isAny?='any'
	 *     (rule start) (ambiguity) '(' typeName=QualifiedName
	 *     (rule start) (ambiguity) '*' ')' (rule start)
	 *     (rule start) (ambiguity) 'new' constructor=QualifiedName
	 *     (rule start) (ambiguity) 'new' typeName=QualifiedName
	 *     (rule start) (ambiguity) 'super' '.' target=QualifiedName
	 *     (rule start) (ambiguity) 'super' tuple=Tuple
	 *     (rule start) (ambiguity) 'this' ')' (rule start)
	 *     (rule start) (ambiguity) 'this' tuple=Tuple
	 *     (rule start) (ambiguity) associationName=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) className=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) hasMultiplicity?='null'
	 *     (rule start) (ambiguity) image=BOOLEAN_VALUE
	 *     (rule start) (ambiguity) image=NATURAL_VALUE
	 *     (rule start) (ambiguity) image=STRING
	 *     (rule start) (ambiguity) isAny?='any'
	 *     (rule start) (ambiguity) leftHandSide=LeftHandSide
	 *     (rule start) (ambiguity) name=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) operand=LeftHandSide
	 *     (rule start) (ambiguity) operator='!'
	 *     (rule start) (ambiguity) operator='$'
	 *     (rule start) (ambiguity) operator='~'
	 *     (rule start) (ambiguity) operator=AffixOperator
	 *     (rule start) (ambiguity) operator=NumericUnaryOperator
	 *     (rule start) (ambiguity) target=PotentiallyAmbiguousQualifiedName
	 *     (rule start) (ambiguity) typeName=QualifiedName
	 *     (rule start) (ambiguity) {ArithmeticExpression.operand1=}
	 *     (rule start) (ambiguity) {ClassificationExpression.operand=}
	 *     (rule start) (ambiguity) {ConditionalLogicalExpression.operand1=}
	 *     (rule start) (ambiguity) {ConditionalTestExpression.operand1=}
	 *     (rule start) (ambiguity) {EqualityExpression.operand1=}
	 *     (rule start) (ambiguity) {FeatureInvocationExpression.target=}
	 *     (rule start) (ambiguity) {LogicalExpression.operand1=}
	 *     (rule start) (ambiguity) {PropertyAccessExpression.featureReference=}
	 *     (rule start) (ambiguity) {RelationalExpression.operand1=}
	 *     (rule start) (ambiguity) {SequenceAccessExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceExpansionExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceOperationExpression.primary=}
	 *     (rule start) (ambiguity) {SequenceReductionExpression.primary=}
	 *     (rule start) (ambiguity) {ShiftExpression.operand1=}
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     element+=SequenceElement (ambiguity) (rule end)
	 */
	protected void emit_SequenceExpressionList_CommaKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     'new'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) '=' (ambiguity) '{' elements=SequenceElements
	 *     (rule start) (ambiguity) '{' elements=SequenceElements
	 */
	protected void emit_SequenceInitializationExpression_NewKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
