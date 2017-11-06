/*
 * generated by Xtext
 */
package org.eclipse.papyrus.marte.vsl.parser.antlr;

import org.eclipse.papyrus.marte.vsl.services.VSLGrammarAccess;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

import com.google.inject.Inject;

public class VSLParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {

	@Inject
	private VSLGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}

	@Override
	protected org.eclipse.papyrus.marte.vsl.parser.antlr.internal.InternalVSLParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.marte.vsl.parser.antlr.internal.InternalVSLParser(stream, getGrammarAccess());
	}

	@Override
	protected String getDefaultRuleName() {
		return "Expression";
	}

	public VSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(VSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

}
