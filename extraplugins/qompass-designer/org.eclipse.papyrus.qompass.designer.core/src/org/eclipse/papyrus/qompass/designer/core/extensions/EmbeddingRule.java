/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.qompass.designer.core.Activator;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Port;


/**
 * Support for embedding rules.
 * CAVEAT: Currently not used, unclear if kept
 */
@Deprecated
public class EmbeddingRule {

	public static final String IEMBEDDING_RULE_ID = Activator.PLUGIN_ID + ".embeddingRule"; //$NON-NLS-1$

	/**
	 *
	 * @param iConfiguratorName
	 * @param component
	 *            containing composite (container)
	 * @param instance
	 */
	public static void embeddExtension(String embeddingRuleID, InstanceSpecification executorIS, InstanceSpecification instance, Port port) {
		IEmbeddingRule iEmbeddingRule = getEmbeddingRule(embeddingRuleID);
		if (iEmbeddingRule != null) {
			iEmbeddingRule.embeddExtension(executorIS, instance, port);
		}
	}

	private static IEmbeddingRule getEmbeddingRule(String embeddingRuleID) {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] configElements = reg.getConfigurationElementsFor(IEMBEDDING_RULE_ID);
		for (IConfigurationElement configElement : configElements) {
			try {
				final String iConfiguratorIDext = configElement.getAttribute("configuratorID"); //$NON-NLS-1$
				if (iConfiguratorIDext.equals(embeddingRuleID)) {
					// TODO: cache returned instance (avoid creating a new instance each time => more efficient, no need for static attributes)
					final Object obj = configElement.createExecutableExtension("class"); //$NON-NLS-1$
					if (obj instanceof IEmbeddingRule) {
						return (IEmbeddingRule) obj;
					}
				}
			} catch (CoreException exception) {
				exception.printStackTrace();
			}
		}
		return null;
	}
}
