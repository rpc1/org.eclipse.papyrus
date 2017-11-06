/*
 * generated by Xtext
 */
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLProposalProvider;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * Represents a generated, default implementation of interface {@link IProposalProvider}.
 * Methods are dynamically dispatched on the first parameter, i.e., you can override them
 * with a more concrete subtype.
 */
@SuppressWarnings("all")
public class AbstractConstraintWithVSLlProposalProvider extends VSLProposalProvider {

	public void completeConstraintRule_Specification(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeRuleCall(((RuleCall) assignment.getTerminal()), context, acceptor);
	}

	public void completeConstraintSpecification_Expression(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		completeRuleCall(((RuleCall) assignment.getTerminal()), context, acceptor);
	}

	public void complete_ConstraintRule(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// subclasses may override
	}

	public void complete_ConstraintSpecification(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// subclasses may override
	}
}
