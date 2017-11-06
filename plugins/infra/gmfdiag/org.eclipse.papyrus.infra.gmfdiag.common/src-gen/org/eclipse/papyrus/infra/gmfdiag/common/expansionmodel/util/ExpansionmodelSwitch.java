/**
 * Copyright (c) 2015 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 	CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.ExpansionmodelPackage
 * @generated
 */
public class ExpansionmodelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpansionmodelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpansionmodelSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpansionmodelPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpansionmodelPackage.REPRESENTATION: {
				Representation representation = (Representation)theEObject;
				T result = caseRepresentation(representation);
				if (result == null) result = caseAbstractRepresentation(representation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.ABSTRACT_REPRESENTATION: {
				AbstractRepresentation abstractRepresentation = (AbstractRepresentation)theEObject;
				T result = caseAbstractRepresentation(abstractRepresentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.REPRESENTATION_KIND: {
				RepresentationKind representationKind = (RepresentationKind)theEObject;
				T result = caseRepresentationKind(representationKind);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.INDUCED_REPRESENTATION: {
				InducedRepresentation inducedRepresentation = (InducedRepresentation)theEObject;
				T result = caseInducedRepresentation(inducedRepresentation);
				if (result == null) result = caseAbstractRepresentation(inducedRepresentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.GRAPHICAL_ELEMENT_LIBRARY: {
				GraphicalElementLibrary graphicalElementLibrary = (GraphicalElementLibrary)theEObject;
				T result = caseGraphicalElementLibrary(graphicalElementLibrary);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.USE_CONTEXT: {
				UseContext useContext = (UseContext)theEObject;
				T result = caseUseContext(useContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.GMFT_BASED_REPRESENTATION: {
				GMFT_BasedRepresentation gmfT_BasedRepresentation = (GMFT_BasedRepresentation)theEObject;
				T result = caseGMFT_BasedRepresentation(gmfT_BasedRepresentation);
				if (result == null) result = caseRepresentation(gmfT_BasedRepresentation);
				if (result == null) result = caseAbstractRepresentation(gmfT_BasedRepresentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpansionmodelPackage.DIAGRAM_EXPANSION: {
				DiagramExpansion diagramExpansion = (DiagramExpansion)theEObject;
				T result = caseDiagramExpansion(diagramExpansion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepresentation(Representation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRepresentation(AbstractRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Representation Kind</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Representation Kind</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepresentationKind(RepresentationKind object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Induced Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Induced Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInducedRepresentation(InducedRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphical Element Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphical Element Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicalElementLibrary(GraphicalElementLibrary object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseContext(UseContext object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>GMFT Based Representation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>GMFT Based Representation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGMFT_BasedRepresentation(GMFT_BasedRepresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram Expansion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram Expansion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagramExpansion(DiagramExpansion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpansionmodelSwitch
