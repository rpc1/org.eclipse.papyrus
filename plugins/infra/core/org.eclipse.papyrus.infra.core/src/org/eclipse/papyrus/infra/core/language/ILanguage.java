/*****************************************************************************
 * Copyright (c) 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.language;

import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * <p>
 * Protocol for the definition of a <em>Modeling Language</em> as it is instantiated
 * in a Papyrus model. Although one may distinguish between primary or core languages
 * such as UML, Ecore, MOF, etc. as implemented by OMG metamodels and derivative
 * languages such as UML profiles, specializations, or package merges, this API does
 * not make any such distinction.
 * </p>
 * <p>
 * Any number of languages may be instantiated in a Papyrus model, but as long as the
 * {@linkplain ILanguageService Language Service} is present, there is always at least
 * one language.
 * </p>
 */
public interface ILanguage {

	/**
	 * Obtains an unique identifier of the language, irrespective of version.
	 * 
	 * @return
	 */
	String getID();

	/**
	 * Obtains the version of the language. All versions of a language have the same {@linkplain #getID() identifier}.
	 * 
	 * @return the version. Never {@code null}
	 */
	Version getVersion();

	/**
	 * Obtains the user-presentable (translated for the current locale) name of the language, not including any {@linkplain #getVersion() version number}.
	 * 
	 * @return my name. Never {@code null} or empty
	 */
	String getName();

	/**
	 * Installs me on a model-set. This performs whatever registrations, listener attachments, etc. that may be necessary
	 * for the proper functioning of my language in the Papyrus context.
	 * 
	 * @param modelSet
	 *            a model-set to configure
	 */
	void install(ModelSet modelSet);

	/**
	 * Uninstalls me from a model-set. This undoes whatever the {@linkplain #install(ModelSet) installation} did.
	 * 
	 * @param modelSet
	 *            a model-set to unconfigure
	 */
	void uninstall(ModelSet modelSet);

	/**
	 * Two languages are equal if they have the same {@linkplain #getID() identifier} and {@linkplain #getVersion() version}.
	 */
	@Override
	boolean equals(Object obj);

	/**
	 * Languages are hashed by {@linkplain #getID() identifier} and {@linkplain #getVersion() version}.
	 */
	@Override
	int hashCode();
}
