/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.uml.search.internal.ui.query;

import static java.util.regex.Pattern.quote;

import java.util.regex.Matcher;


/**
 * Utilities for working with regex patterns in CDO OCL queries.
 */
public class PatternUtil {

	private static final String WILDCARD = ".*"; //$NON-NLS-1$

	// not instantiable by clients
	private PatternUtil() {
		super();
	}

	/**
	 * OCL queries always use reqular expressions to implement either regex search (obviously) or case-insensitive search because there
	 * is no better way using OCL's String operations.
	 *
	 * @param searchText
	 *            the user's search text
	 * @param caseSensitive
	 *            whether the search is case-sensitive
	 * @param regularExpression
	 *            whether the search text is to be interpreted as a regular expression
	 * @param allStringAttributes
	 *            whether the search text is sought in all string attributes of an object
	 *
	 * @return the appropriately modified string specifying the regular expression search term, or {@code null} if the search text
	 *         is actually a literal exact sub-string match
	 */
	public static String wrap(String searchText, boolean caseSensitive, boolean regularExpression, boolean allStringAttributes) {
		String result;

		if (caseSensitive) {
			if (!regularExpression) {
				if (allStringAttributes) {
					// the cdoMatches() operation needs a regex
					result = String.format("%s%s%s", WILDCARD, quote(searchText), WILDCARD);
				} else {
					// we use "indexOf(searchPattern) > 0" to do a simple sub-string search
					result = null;
				}
			} else {
				result = ensureRegexSubstring(searchText);
			}
		} else {
			if (!regularExpression) {
				// make a case-insensitive regex matching the literal text
				result = String.format("(?i)%s%s%s", WILDCARD, quote(searchText), WILDCARD);
			} else {
				result = String.format("(?i)%s", ensureRegexSubstring(searchText));
			}
		}

		return result;
	}

	// ensure that the regex matches any substring by starting and finishing with wildcards
	private static String ensureRegexSubstring(String regex) {
		String result = regex;
		if (!result.startsWith(WILDCARD)) {
			result = WILDCARD + result;
		}
		if (!result.endsWith(WILDCARD)) {
			result = result + WILDCARD;
		}
		return result;
	}

	/**
	 * Local post-processing of element matches uses {@link Matcher#find()} to gather up all applicable attribute matches. This method converts
	 * the user's search criteria into an appropriate regular expression.
	 *
	 * @param searchText
	 *            the user's search text
	 * @param caseSensitive
	 *            whether the search is case-sensitive
	 * @param regularExpression
	 *            whether the search tex is to be interpreted as a regular expression
	 *
	 * @return the appropriately modified string specifying the regular expression search term, never {@code null}
	 */
	public static String wrapForFind(String searchText, boolean caseSensitive, boolean regularExpression) {
		String result;

		if (caseSensitive) {
			if (!regularExpression) {
				result = quote(searchText); // simple sub-string search
			} else {
				result = searchText; // already a regex
			}
		} else {
			if (!regularExpression) {
				// make a case-insensitive regex matching the literal text
				result = String.format("(?i)%s", quote(searchText));
			} else {
				result = String.format("(?i)%s", searchText);
			}
		}

		return result;
	}
}
