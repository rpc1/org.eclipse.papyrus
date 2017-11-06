/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintWithVSLlPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ConstraintWithVSLlXMLProcessor extends XMLProcessor {

	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ConstraintWithVSLlXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		ConstraintWithVSLlPackage.eINSTANCE.eClass();
	}

	/**
	 * Register for "*" and "xml" file extensions the ConstraintWithVSLlResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new ConstraintWithVSLlResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new ConstraintWithVSLlResourceFactoryImpl());
		}
		return registrations;
	}

} // ConstraintWithVSLlXMLProcessor
