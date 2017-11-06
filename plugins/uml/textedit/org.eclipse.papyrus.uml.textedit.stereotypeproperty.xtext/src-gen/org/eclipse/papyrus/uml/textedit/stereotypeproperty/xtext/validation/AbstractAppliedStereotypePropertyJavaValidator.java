/*
 * generated by Xtext
 */
package org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.alf.validation.AlfValidator;

public class AbstractAppliedStereotypePropertyJavaValidator extends AlfValidator {

	@Override
	public List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.papyrus.uml.textedit.stereotypeproperty.xtext.appliedStereotypeProperty.AppliedStereotypePropertyPackage.eINSTANCE);
	    result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.omg.org/spec/ALF/20120827"));
		return result;
	}

}