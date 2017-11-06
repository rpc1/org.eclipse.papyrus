/*
* generated by Xtext
*/
package org.eclipse.papyrus.alf.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.papyrus.alf.services.AlfGrammarAccess;

public class AlfParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private AlfGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.papyrus.alf.parser.antlr.internal.InternalAlfParser createParser(XtextTokenStream stream) {
		return new org.eclipse.papyrus.alf.parser.antlr.internal.InternalAlfParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "UnitDefinition";
	}
	
	public AlfGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(AlfGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
