package org.eclipse.papyrus.sysml.diagram.common.utils;

import java.util.Collection;

import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.uml2.uml.MultiplicityElement;


public class SysMLMultiplicityElementUtil extends org.eclipse.papyrus.uml.tools.utils.MultiplicityElementUtil {

	private static final String DEFAULT_MULTIPLICITY = "[1]";

	/**
	 * If multiplicity is [1] (SysML default), only show when explicitly asked.
	 */
	public static String formatMultiplicity(MultiplicityElement element, Collection<String> maskValues) {
		return formatMultiplicity(element, !maskValues.contains(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY));
	}

	public static String formatMultiplicity(MultiplicityElement element, boolean blockDefault) {
		String result = formatMultiplicity(element);
		if (result == null || result.isEmpty()) {
			result = DEFAULT_MULTIPLICITY;
		}
		if (blockDefault && DEFAULT_MULTIPLICITY.equals(result)) {
			result = "";
		}
		return result;
	}
}
