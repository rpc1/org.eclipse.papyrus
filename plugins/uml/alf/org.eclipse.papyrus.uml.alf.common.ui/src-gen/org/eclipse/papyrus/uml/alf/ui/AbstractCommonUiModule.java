
/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.alf.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.DefaultUiModule;

/**
 * Manual modifications go to {org.eclipse.papyrus.uml.alf.ui.CommonUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractCommonUiModule extends DefaultUiModule {

	public AbstractCommonUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}


	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.JavaBasedContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return org.eclipse.papyrus.uml.alf.ui.contentassist.CommonProposalProvider.class;
	}


}