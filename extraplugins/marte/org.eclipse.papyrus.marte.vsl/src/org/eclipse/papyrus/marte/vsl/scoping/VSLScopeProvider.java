/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil;
import org.eclipse.papyrus.marte.vsl.scoping.visitors.ScopingVisitors;
import org.eclipse.papyrus.marte.vsl.scoping.visitors.Visitor;
import org.eclipse.papyrus.marte.vsl.vSL.CollectionOrTuple;
import org.eclipse.papyrus.marte.vsl.vSL.DataTypeName;
import org.eclipse.papyrus.marte.vsl.vSL.DurationObsName;
import org.eclipse.papyrus.marte.vsl.vSL.Expression;
import org.eclipse.papyrus.marte.vsl.vSL.InstantObsName;
import org.eclipse.papyrus.marte.vsl.vSL.Interval;
import org.eclipse.papyrus.marte.vsl.vSL.ListOfValues;
import org.eclipse.papyrus.marte.vsl.vSL.NameOrChoiceOrBehaviorCall;
import org.eclipse.papyrus.marte.vsl.vSL.OperationCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.PropertyCallExpression;
import org.eclipse.papyrus.marte.vsl.vSL.QualifiedName;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueNamePair;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class VSLScopeProvider extends AbstractDeclarativeScopeProvider {

	public static VSLScopeProvider eInstance = new VSLScopeProvider();

	/**
	 * A private helper class for scope computing
	 *
	 */
	public class ScopingHelper {
		private List<EObject> eObjectHierarchy;
		private List<EObject> bindingKeys;
		private HashMap<EObject, Classifier> ruleToClassifierBinding;
		private HashMap<EObject, Element> ruleToContextInformation;
		private HashMap<EObject, MultiplicityElement> ruleToMultiplicityInformation;

		private EObject analyzedRule;

		public boolean isExpectedTypeAUMLMetaclass() {
			Classifier expectedType = (Classifier) VSLContextUtil.getExpectedType(analyzedRule);
			if (expectedType instanceof org.eclipse.uml2.uml.Class) {
				String name = "" + ((org.eclipse.uml2.uml.Class) expectedType).getName();
				if (UMLPackage.eINSTANCE.getEClassifier(name) != null) {
					return true;
				}
			}
			return false;
		}

		public boolean isExpectedTypeAStereotype() {
			Classifier expectedType = (Classifier) VSLContextUtil.getExpectedType(analyzedRule);
			if (expectedType instanceof Stereotype) {
				return true;
			}
			return false;
		}

		public ScopingHelper(EObject rule) {
			this.analyzedRule = rule;
			Classifier expectedType = (Classifier) VSLContextUtil.getExpectedType(analyzedRule);
			// if expected type is not a metaclass or a stereotype
			this.buildEObjectHierarchy();
			this.buildRuleToClassifierBinding(); // default case
		}

		public Classifier getClassifierForScoping() {
			EObject previousKey = this.getPreviousRuleKey(analyzedRule);
			return ruleToClassifierBinding.get(previousKey);
		}

		public MultiplicityElement getExpectedMultiplicity() {
			EObject previousKey = this.getPreviousRuleKey(analyzedRule);
			return ruleToMultiplicityInformation.get(previousKey);
		}

		private void buildEObjectHierarchy() {
			eObjectHierarchy = new ArrayList<EObject>();
			EObject currentRule = this.analyzedRule;
			while (currentRule != null && VSLPackage.eINSTANCE.getEClassifier(currentRule.eClass().getName()) != null) {
				eObjectHierarchy.add(0, currentRule);
				currentRule = currentRule.eContainer();
			}
		}

		private void buildRuleToClassifierBinding() {
			ruleToClassifierBinding = new HashMap<EObject, Classifier>();
			ruleToContextInformation = new HashMap<EObject, Element>();
			ruleToMultiplicityInformation = new HashMap<EObject, MultiplicityElement>();
			if (eObjectHierarchy.isEmpty()) {
				return;
			}
			Classifier expectedType = (Classifier) VSLContextUtil.getExpectedType(analyzedRule);
			ruleToClassifierBinding.put(eObjectHierarchy.get(0), expectedType);
			if (analyzedRule instanceof MultiplicityElement) {
				MultiplicityElement expectedMultiplicity = (MultiplicityElement) VSLContextUtil.getContextElement(analyzedRule);
				ruleToMultiplicityInformation.put(eObjectHierarchy.get(0), expectedMultiplicity);
			}
			bindingKeys = new ArrayList<EObject>();
			bindingKeys.add(eObjectHierarchy.get(0));
			if (!isExpectedTypeAStereotype() && !isExpectedTypeAUMLMetaclass()) {
				for (int i = 1; i < eObjectHierarchy.size(); i++) {
					EObject currentRule = eObjectHierarchy.get(i);
					this.bindExpectedType(currentRule);
				}
			}
			else {
				for (int i = 1; i < eObjectHierarchy.size(); i++) {
					EObject currentRule = eObjectHierarchy.get(i);
					this.bindExpectedMetaclassOrStereotype(currentRule);
				}
			}
		}

		private void bindExpectedMetaclassOrStereotype(EObject rule) {
			if (eObjectHierarchy.isEmpty()) {
				return;
			}
			EObject previousKey = this.getPreviousRuleKey(rule);
			if (previousKey != null) {
				ruleToClassifierBinding.put(rule, ruleToClassifierBinding.get(previousKey));
				ruleToMultiplicityInformation.put(rule, ruleToMultiplicityInformation.get(previousKey));
				if (ruleToContextInformation.containsKey(previousKey)) {
					ruleToContextInformation.put(rule, ruleToContextInformation.get(previousKey));
				}
			} else {
				ruleToClassifierBinding.put(rule, null);
			}
		}

		private void bindExpectedType(EObject rule) {
			if (eObjectHierarchy.isEmpty()) {
				return;
			}

			if (rule instanceof PropertyCallExpression) {
				if (((PropertyCallExpression) rule).getProperty() != null) {
					ruleToClassifierBinding.put(rule, (Classifier) ((((PropertyCallExpression) rule).getProperty()).getType()));
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			else if (rule instanceof OperationCallExpression) {
				if (((OperationCallExpression) rule).getOperation() != null) {
					ruleToClassifierBinding.put(rule, (Classifier) ((OperationCallExpression) rule).getOperation().getType());
					ruleToContextInformation.put(rule, ((OperationCallExpression) rule).getOperation());
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			else if (rule instanceof NameOrChoiceOrBehaviorCall) {
				if (((NameOrChoiceOrBehaviorCall) rule).getId() != null) {
					if (((NameOrChoiceOrBehaviorCall) rule).getId() instanceof Property) {
						ruleToClassifierBinding.put(rule, (Classifier) ((Property) ((NameOrChoiceOrBehaviorCall) rule).getId()).getType());
						if (VSLContextUtil.isAChoiceType((Classifier) ((Property) ((NameOrChoiceOrBehaviorCall) rule).getId()).getOwner())) {
							ruleToContextInformation.put(rule, ((NameOrChoiceOrBehaviorCall) rule).getId());
						}
					}
					else if (((NameOrChoiceOrBehaviorCall) rule).getId() instanceof EnumerationLiteral) {
						ruleToClassifierBinding.put(rule, ((EnumerationLiteral) ((NameOrChoiceOrBehaviorCall) rule).getId()).getEnumeration());
					}
					else if (((NameOrChoiceOrBehaviorCall) rule).getId() instanceof Behavior) {
						Behavior calledBehavior = (Behavior) ((NameOrChoiceOrBehaviorCall) rule).getId();
						boolean done = false;
						for (Parameter p : calledBehavior.getOwnedParameters()) {
							if (p.getDirection() == ParameterDirectionKind.RETURN_LITERAL) {
								ruleToClassifierBinding.put(rule, (Classifier) p.getType());
								done = true;
							}
						}
						ruleToContextInformation.put(rule, calledBehavior);
						if (!done) {
							ruleToClassifierBinding.put(rule, null);
						}
					}
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			// else if (rule instanceof QualifiedName) {
			// // tODO ??
			// }
			else if (rule instanceof ValueNamePair) {
				if (((ValueNamePair) rule).getProperty() != null) {
					ruleToClassifierBinding.put(rule, (Classifier) ((ValueNamePair) rule).getProperty().getType());
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			// else if (rule instanceof InstantObsName) {
			// // tODO ??
			// }
			// else if (rule instanceof DurationObsName) {
			// // tODO ?
			// }
			// else if (rule instanceof DataTypeName) {
			// // tODO ?
			// }
			else if (rule instanceof CollectionOrTuple) {
				EObject previousKey = this.getPreviousRuleKey(rule);
				if (previousKey != null) {
					ruleToClassifierBinding.put(rule, ruleToClassifierBinding.get(previousKey));
					ruleToMultiplicityInformation.put(rule, ruleToMultiplicityInformation.get(previousKey));
					if (ruleToContextInformation.containsKey(previousKey)) {
						ruleToContextInformation.put(rule, ruleToContextInformation.get(previousKey));
					}
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			else if (rule instanceof ListOfValues) {
				EObject previousKey = this.getPreviousRuleKey(rule);
				if (previousKey != null) {
					ruleToClassifierBinding.put(rule, ruleToClassifierBinding.get(previousKey));
					ruleToMultiplicityInformation.put(rule, ruleToMultiplicityInformation.get(previousKey));
					if (ruleToContextInformation.containsKey(previousKey)) {
						ruleToContextInformation.put(rule, ruleToContextInformation.get(previousKey));
					}
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			else if (rule instanceof Interval) {
				EObject previousKey = this.getPreviousRuleKey(rule);
				if (previousKey != null) {
					ruleToClassifierBinding.put(rule, ruleToClassifierBinding.get(previousKey));
					if (ruleToContextInformation.containsKey(previousKey)) {
						ruleToContextInformation.put(rule, ruleToContextInformation.get(previousKey));
					}
				} else {
					ruleToClassifierBinding.put(rule, null);
				}
			}
			else if (rule instanceof Expression) {
				EObject previousKey = this.getPreviousRuleKey(rule);
				if (previousKey instanceof ListOfValues) {
					Classifier expectedType =
							this.retrieveExpectedClassifierForExpressionFromListOfValues
									((Expression) rule,
											(ListOfValues) previousKey);
					ruleToClassifierBinding.put(rule, expectedType);
				}
				else if (previousKey instanceof Interval) {
					Classifier expectedType = ruleToClassifierBinding.get(previousKey);
					if (VSLContextUtil.isAnIntervalType(expectedType)) {
						Property intervalAttribProperty = (Property) VSLContextUtil.getIntervalAttrib(expectedType);
						if (intervalAttribProperty != null) {
							ruleToClassifierBinding.put(rule, (Classifier) intervalAttribProperty.getType());
						} else {
							ruleToClassifierBinding.put(rule, expectedType);
						}
					} else {
						ruleToClassifierBinding.put(rule, expectedType);
					}
				}
				else {
					ruleToClassifierBinding.put(rule, ruleToClassifierBinding.get(previousKey));
				}
			}
			else {
				// Do nothing
				// System.out.println() ;
			}
		}

		private EObject getPreviousRuleKey(EObject rule) {
			int index = eObjectHierarchy.indexOf(rule);
			while (index >= 0) {
				EObject currentRule = eObjectHierarchy.get(index);
				if (ruleToClassifierBinding.get(currentRule) != null) {
					return currentRule;
				}
				index--;
			}
			return null;
		}

		private Classifier retrieveExpectedClassifierForExpressionFromListOfValues(Expression exp, ListOfValues listOfValues) {
			Classifier expectedType = ruleToClassifierBinding.get(listOfValues);
			MultiplicityElement multiplicity = ruleToMultiplicityInformation.get(listOfValues);
			if (listOfValues.getValues().contains(exp)) {
				if (multiplicity != null && (multiplicity.getUpper() > 1 || multiplicity.getUpper() == -1)) {
					return expectedType;
				}
				int indexOfExp = listOfValues.getValues().indexOf(exp);
				Element optionalContextElement = ruleToContextInformation.get(listOfValues);
				if (optionalContextElement != null) {
					if (optionalContextElement instanceof Behavior) {
						Behavior calledBehavior = (Behavior) optionalContextElement;
						List<Parameter> inoutParameters = new ArrayList<Parameter>();
						for (Parameter p : calledBehavior.getOwnedParameters()) {
							if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
								inoutParameters.add(p);
							}
						}
						if (inoutParameters.size() > indexOfExp) {
							return (Classifier) inoutParameters.get(indexOfExp).getType();
						}
					}
					else if (optionalContextElement instanceof Operation) {
						Operation calledOperation = (Operation) optionalContextElement;
						List<Parameter> inoutParameters = new ArrayList<Parameter>();
						for (Parameter p : calledOperation.getOwnedParameters()) {
							if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
								inoutParameters.add(p);
							}
						}
						if (inoutParameters.size() > indexOfExp) {
							return (Classifier) inoutParameters.get(indexOfExp).getType();
						}
					}
					else if (optionalContextElement instanceof Property) {// This is a chosen alternative
						System.out.println(((Property) optionalContextElement).getType().getName());
						return (Classifier) ((Property) optionalContextElement).getType();
					}
					else {
						System.out.println("should not be reached");
					}
				}
				else {
					if (VSLContextUtil.isATupleType(expectedType)) {
						List<NamedElement> tupleProperties =
								new ArrayList<NamedElement>(VSLContextUtil.getTupleAttribs(expectedType));
						if (tupleProperties.size() > indexOfExp) {
							System.out.println(((Property) tupleProperties.get(indexOfExp)).getType().getName());
							System.out.println(((Property) tupleProperties.get(indexOfExp)).getName() + "");
							return (Classifier) ((Property) tupleProperties.get(indexOfExp)).getType();
						}
					}
					else if (VSLContextUtil.isACollectionType(expectedType)) {
						if (VSLContextUtil.getCollectionAttrib(expectedType) != null) {
							return (Classifier) ((Property) VSLContextUtil.getCollectionAttrib(expectedType)).getType();
						}
					}
					else if (VSLContextUtil.isAnIntervalType(expectedType)) {
						if (VSLContextUtil.getIntervalAttrib(expectedType) != null) {
							return (Classifier) ((Property) VSLContextUtil.getIntervalAttrib(expectedType)).getType();
						}
					}
				}
			}
			return expectedType;
		}
	}

	/* ****************************************************
	 *
	 * Scope for qualified names
	 *
	 * ***************************************************
	 */

	public IScope scope_QualifiedName_path(QualifiedName ctx, EReference ref) {
		List<Namespace> visibleNamespaces = new ArrayList<Namespace>();
		if (ctx != null && ctx.eContainer() != null && ctx.eContainer() instanceof QualifiedName) {
			Namespace parentNameSpace = ((QualifiedName) ctx.eContainer()).getPath();
			visibleNamespaces.addAll(ScopingVisitors.ownedAndImportedNamespaces.visit(parentNameSpace));
		}
		else {
			visibleNamespaces.add(VSLJavaValidator.getModel());
			visibleNamespaces.addAll(ScopingVisitors.ownedAndImportedNamespaces.visit(VSLJavaValidator.getModel()));
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(visibleNamespaces);
		return new SimpleScope(iterableIEobjectDescription);
	}

	public IScope scope_QualifiedName_remaining(QualifiedName ctx, EReference ref) {
		List<Namespace> visibleNamespaces = new ArrayList<Namespace>();
		if (ctx != null) {
			Namespace parentNameSpace = ctx.getPath();
			if (parentNameSpace != null) {
				visibleNamespaces.addAll(ScopingVisitors.ownedAndImportedNamespaces.visit(parentNameSpace));
			}
		}
		Iterable<IEObjectDescription> iterableIEobjectDescription = Scopes.scopedElementsFor(visibleNamespaces);
		return new SimpleScope(iterableIEobjectDescription);
	}

	/* ****************************************************
	 *
	 * Scope for names
	 *
	 * ***************************************************
	 */
	private IScope scope_Name_ifExpectingAStereotype(NameOrChoiceOrBehaviorCall ctx, EReference ref) {
		List<Element> visibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				Stereotype expectedStereotype =
						(Stereotype) new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
				visibleElementsFromPath.addAll(ScopingVisitors.Visitor_GetOwnedAndImportedStereotypeInstances.visit(nearestNamespace, expectedStereotype));
			}
		}
		else {
			// TODO: handle the case where no qualified name is specified
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		iterableIEobjectDescriptions = Scopes.scopedElementsFor(visibleElementsFromPath);
		resultScope = new SimpleScope(iterableIEobjectDescriptions);

		return resultScope;
	}

	private IScope scope_Name_ifExpectingAMetaclassInstance(NameOrChoiceOrBehaviorCall ctx, EReference ref) {
		List<Element> visibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				org.eclipse.uml2.uml.Class expectedMetaclass =
						(org.eclipse.uml2.uml.Class) new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
				visibleElementsFromPath.addAll(ScopingVisitors.Visitor_GetOwnedAndImportedMetaclassInstances.visit(nearestNamespace, expectedMetaclass));
			}
		}
		else {
			// TODO: handle the case where no qualified name is specified
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		iterableIEobjectDescriptions = Scopes.scopedElementsFor(visibleElementsFromPath);
		resultScope = new SimpleScope(iterableIEobjectDescriptions);

		return resultScope;
	}

	public IScope scope_NameOrChoiceOrBehaviorCall_id(NameOrChoiceOrBehaviorCall ctx, EReference ref) {
		// List<List<Element>> visibleElements = new ArrayList<List<Element>>() ;


		ScopingHelper tmpHelper = new ScopingHelper(ctx.eContainer());
		if (tmpHelper.isExpectedTypeAStereotype()) {
			return scope_Name_ifExpectingAStereotype(ctx, ref);
		} else if (tmpHelper.isExpectedTypeAUMLMetaclass()) {
			return scope_Name_ifExpectingAMetaclassInstance(ctx, ref);
		}

		List<List<Element>> tmpOwnedOrInheritedVisibleProperties = new ArrayList<List<Element>>();
		List<Element> tmpFlatListOfVisibleElements = new ArrayList<Element>();
		List<List<Element>> tmpHierarchichallyVisibleBehaviors = new ArrayList<List<Element>>();
		List<List<Element>> tmpHierarchichallyVisibleProperties = new ArrayList<List<Element>>();

		// In the case where a path (qualified name prefix) has been specified,
		// retrieves visible elements from this name space
		List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				List<Element> tmpVisibleBehaviorsFromPath = new ArrayList<Element>();
				List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
				List<Element> tmpVisibleEnumerationLiteralFromPath = new ArrayList<Element>();
				tmpVisibleBehaviorsFromPath.addAll(ScopingVisitors.ownedAndImportedBehaviors.visit(nearestNamespace));
				tmpVisiblePropertiesFromPath.addAll(ScopingVisitors.ownedAndImportedProperties.visit(nearestNamespace));
				tmpVisibleEnumerationLiteralFromPath.addAll(ScopingVisitors.ownedAndImportedEnumerationLiterals.visit(nearestNamespace));
				for (Element e : tmpVisibleBehaviorsFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
				for (Element e : tmpVisiblePropertiesFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
				for (Element e : tmpVisibleEnumerationLiteralFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}
		}
		else {
			// if the global context element is nested inside a classifier:
			// - retrieves the classifier, and gets all its owned and inherited attributes
			Element context = VSLJavaValidator.getContextElement();
			while (context != null && !(context instanceof Classifier)) {
				context = context.getOwner();
			}
			if (context != null) {
				tmpOwnedOrInheritedVisibleProperties.addAll(ScopingVisitors.ownedOrInheritedAttributes.visit(((Classifier) context)));
			}

			// retrieves any hierarchically visible behavior from context (not based on inheritance)
			context = VSLJavaValidator.getContextElement();
			tmpHierarchichallyVisibleBehaviors = new ArrayList<List<Element>>();
			tmpHierarchichallyVisibleBehaviors.addAll(ScopingVisitors.hierarchichallyAccessibleBehaviors.visit(context));
			for (List<Element> l : tmpHierarchichallyVisibleBehaviors) {
				tmpFlatListOfVisibleElements.addAll(l);
			}

			// retrieves any hierarchically visible properties from context (not based on inheritance)
			context = VSLJavaValidator.getContextElement();
			tmpHierarchichallyVisibleProperties = new ArrayList<List<Element>>();
			tmpHierarchichallyVisibleProperties.addAll(ScopingVisitors.hierarchichallyAccessibleProperties.visit(context));
			for (List<Element> l : tmpHierarchichallyVisibleProperties) {
				List<Element> elementsToBeRemovedFromTheScope = new ArrayList<Element>();
				for (Element e : l) {
					if (tmpFlatListOfVisibleElements.contains(e)) {
						// The element has already been considered by inheritance scoping,
						// and must not be considered by hierarchy scoping
						elementsToBeRemovedFromTheScope.add(e);
					}
					tmpFlatListOfVisibleElements.addAll(l);
				}
				l.removeAll(elementsToBeRemovedFromTheScope);
			}
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		for (List<Element> l : tmpHierarchichallyVisibleBehaviors) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}
		if (!tmpVisibleElementsFromPath.isEmpty()) {
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}
		for (List<Element> l : tmpHierarchichallyVisibleProperties) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}
		for (List<Element> l : tmpOwnedOrInheritedVisibleProperties) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}

		// Finally handle specific cases due to the expected type of the expression
		// - enumeration literals of an Enumeration
		// - choice alternatives of a ChoiceType
		Classifier expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
		if (VSLContextUtil.isAChoiceType(expectedTypeForScoping)) {
			List<Element> visibleLiterals = new ArrayList<Element>();
			visibleLiterals.addAll(VSLContextUtil.getChoiceAttribs(expectedTypeForScoping));
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(visibleLiterals);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}
		// else if (VSLContextUtil.isATupleType(expectedTypeForScoping)) {
		// visibleElements.addAll(VSLContextUtil.getTupleAttribs(expectedTypeForScoping)) ;
		// }
		else if (expectedTypeForScoping instanceof Enumeration) {
			List<Element> visibleLiterals = new ArrayList<Element>();
			visibleLiterals.addAll(((Enumeration) expectedTypeForScoping).getOwnedLiterals());
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(visibleLiterals);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}

		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
	}

	/* ****************************************************
	 *
	 * Scope for names of time observation
	 *
	 * ***************************************************
	 */

	public IScope scope_InstantObsName_instantId(InstantObsName ctx, EReference ref) {
		List<Element> tmpFlatListOfVisibleElements = new ArrayList<Element>();

		// retrieves any hierarchically visible properties from context (not based on inheritance)
		Element context = VSLJavaValidator.getContextElement();
		List<List<Element>> tmpHierarchichallyVisibleElements = new ArrayList<List<Element>>();

		// In the case where a path (qualified name prefix) has been specified,
		// retrieves visible elements from this name space
		List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
				tmpVisiblePropertiesFromPath.addAll(ScopingVisitors.ownedAndImportedInstantObservations.visit(nearestNamespace));
				for (Element e : tmpVisiblePropertiesFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}
		}
		else {
			tmpHierarchichallyVisibleElements.addAll(ScopingVisitors.hierarchichallyAccessibleInstantObservations.visit(context));
			for (List<Element> l : tmpHierarchichallyVisibleElements) {
				List<Element> elementsToBeRemovedFromTheScope = new ArrayList<Element>();
				for (Element e : l) {
					if (tmpFlatListOfVisibleElements.contains(e)) {
						// The element has already been considered by inheritance scoping,
						// and must not be considered by hierarchy scoping
						elementsToBeRemovedFromTheScope.add(e);
					}
					tmpFlatListOfVisibleElements.addAll(l);
				}
				l.removeAll(elementsToBeRemovedFromTheScope);
			}
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		if (!tmpVisibleElementsFromPath.isEmpty()) {
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}
		for (List<Element> l : tmpHierarchichallyVisibleElements) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}

		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));

	}

	/* ****************************************************
	 *
	 * Scope for names of duration observation
	 *
	 * ***************************************************
	 */


	public IScope scope_DurationObsName_durationId(DurationObsName ctx, EReference ref) {
		List<Element> tmpFlatListOfVisibleElements = new ArrayList<Element>();

		// retrieves any hierarchically visible properties from context (not based on inheritance)
		Element context = VSLJavaValidator.getContextElement();
		List<List<Element>> tmpHierarchichallyVisibleElements = new ArrayList<List<Element>>();
		tmpHierarchichallyVisibleElements.addAll(ScopingVisitors.hierarchichallyAccessibleDurationObservations.visit(context));
		for (List<Element> l : tmpHierarchichallyVisibleElements) {
			List<Element> elementsToBeRemovedFromTheScope = new ArrayList<Element>();
			for (Element e : l) {
				if (tmpFlatListOfVisibleElements.contains(e)) {
					// The element has already been considered by inheritance scoping,
					// and must not be considered by hierarchy scoping
					elementsToBeRemovedFromTheScope.add(e);
				}
				tmpFlatListOfVisibleElements.addAll(l);
			}
			l.removeAll(elementsToBeRemovedFromTheScope);
		}

		// In the case where a path (qualified name prefix) has been specified,
		// retrieves visible elements from this name space
		List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
				tmpVisiblePropertiesFromPath.addAll(ScopingVisitors.ownedAndImportedDurationObservations.visit(nearestNamespace));
				for (Element e : tmpVisiblePropertiesFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		if (!tmpVisibleElementsFromPath.isEmpty()) {
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}
		for (List<Element> l : tmpHierarchichallyVisibleElements) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}

		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
	}

	/* ****************************************************
	 *
	 * Scope for data types (used to type local variables)
	 *
	 * ***************************************************
	 */

	public IScope scope_DataTypeName_type(DataTypeName ctx, EReference ref) {
		List<Element> tmpFlatListOfVisibleElements = new ArrayList<Element>();

		// retrieves any hierarchically visible properties from context (not based on inheritance)
		Element context = VSLJavaValidator.getContextElement();
		List<List<Element>> tmpHierarchichallyVisibleElements = new ArrayList<List<Element>>();
		tmpHierarchichallyVisibleElements.addAll(ScopingVisitors.hierarchichallyAccessibleDataTypes.visit(context));
		for (List<Element> l : tmpHierarchichallyVisibleElements) {
			List<Element> elementsToBeRemovedFromTheScope = new ArrayList<Element>();
			for (Element e : l) {
				if (tmpFlatListOfVisibleElements.contains(e)) {
					// The element has already been considered by inheritance scoping,
					// and must not be considered by hierarchy scoping
					elementsToBeRemovedFromTheScope.add(e);
				}
				tmpFlatListOfVisibleElements.addAll(l);
			}
			l.removeAll(elementsToBeRemovedFromTheScope);
		}

		// In the case where a path (qualified name prefix) has been specified,
		// retrieves visible elements from this name space
		List<Element> tmpVisibleElementsFromPath = new ArrayList<Element>();
		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				List<Element> tmpVisiblePropertiesFromPath = new ArrayList<Element>();
				tmpVisiblePropertiesFromPath.addAll(ScopingVisitors.ownedAndImportedDataTypes.visit(nearestNamespace));
				for (Element e : tmpVisiblePropertiesFromPath) {
					if (!tmpFlatListOfVisibleElements.contains(e)) {
						tmpVisibleElementsFromPath.add(e);
					}
				}
			}
		}

		// builds the nested scope base on hierarchy and then inheritance
		SimpleScope resultScope = null;

		Iterable<IEObjectDescription> iterableIEobjectDescriptions;
		if (!tmpVisibleElementsFromPath.isEmpty()) {
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(tmpVisibleElementsFromPath);
			resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
		}
		for (List<Element> l : tmpHierarchichallyVisibleElements) {
			if (!l.isEmpty()) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}

		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
	}

	/* ****************************************************
	 *
	 * Scope for PropertyCallExpression
	 *
	 * ***************************************************
	 */

	public IScope scope_PropertyCallExpression_property(PropertyCallExpression ctx, EReference ref) {
		SimpleScope resultScope = null;
		List<List<Element>> visibleProperties = new ArrayList<List<Element>>();
		Classifier expectedTypeForScoping = null;
		if (ctx.eContainer() instanceof PrimaryExpression) {
			PrimaryExpression primary = (PrimaryExpression) ctx.eContainer();
			if (primary.getPrefix() instanceof NameOrChoiceOrBehaviorCall) {
				NameOrChoiceOrBehaviorCall n = (NameOrChoiceOrBehaviorCall) primary.getPrefix();
				if (n.getId() instanceof Property) {
					expectedTypeForScoping = (Classifier) ((Property) n.getId()).getType();
				} else {
					expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
				}
			} else {
				expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
			}
		} else {
			expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
		}
		if (expectedTypeForScoping != null) {
			visibleProperties.addAll(ScopingVisitors.ownedOrInheritedAttributes.visit(expectedTypeForScoping));
			Iterable<IEObjectDescription> iterableIEobjectDescriptions;
			for (List<Element> l : visibleProperties) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}
		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<EObject>()));
	}


	/* ****************************************************
	 *
	 * Scope for OperationCallExpression
	 *
	 * ***************************************************
	 */

	public IScope scope_OperationCallExpression_operation(OperationCallExpression ctx, EReference ref) {
		SimpleScope resultScope = null;
		List<List<Element>> visibleOperations = new ArrayList<List<Element>>();
		Classifier expectedTypeForScoping = null;
		if (ctx.eContainer() instanceof PrimaryExpression) {
			PrimaryExpression primary = (PrimaryExpression) ctx.eContainer();
			if (primary.getPrefix() instanceof NameOrChoiceOrBehaviorCall) {
				NameOrChoiceOrBehaviorCall n = (NameOrChoiceOrBehaviorCall) primary.getPrefix();
				if (n.getId() instanceof Property) {
					expectedTypeForScoping = (Classifier) ((Property) n.getId()).getType();
				} else {
					expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
				}
			} else {
				expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
			}
		} else {
			expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
		}
		if (expectedTypeForScoping != null) {
			visibleOperations.addAll(ScopingVisitors.ownedOrInheritedOperations.visit(expectedTypeForScoping));
			Iterable<IEObjectDescription> iterableIEobjectDescriptions;
			for (List<Element> l : visibleOperations) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}
		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<EObject>()));
	}

	/* ****************************************************
	 *
	 * Scope for ValueNamePair
	 *
	 * ***************************************************
	 */

	public IScope scope_ValueNamePair_property(ValueNamePair ctx, EReference ref) {
		SimpleScope resultScope = null;
		Iterable<IEObjectDescription> iterableIEobjectDescriptions;

		Classifier expectedTypeForScoping = new ScopingHelper(ctx.eContainer()).getClassifierForScoping();
		if (VSLContextUtil.isAChoiceType(expectedTypeForScoping)) {
			List<NamedElement> visibleProperties = new ArrayList<NamedElement>();
			visibleProperties.addAll(VSLContextUtil.getChoiceAttribs(expectedTypeForScoping));
			iterableIEobjectDescriptions = Scopes.scopedElementsFor(visibleProperties);
			resultScope = new SimpleScope(iterableIEobjectDescriptions);
		}
		else if (VSLContextUtil.isATupleType(expectedTypeForScoping)) {
			List<List<Element>> visibleProperties = new ArrayList<List<Element>>();
			visibleProperties.addAll(ScopingVisitors.ownedOrInheritedTupleAttributes.visit(expectedTypeForScoping));
			for (List<Element> l : visibleProperties) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}
		else { // A tuple has been specified, and the expected type is not a tuple or choice type
				// We put in the scope all the properties of NFP_Duration, since it is the only tuple type involved in operators in this implementation of VSL
				// TODO This solution is temporary and MUST be generalized to any operator.
			List<List<Element>> visibleProperties = new ArrayList<List<Element>>();
			visibleProperties.addAll(ScopingVisitors.ownedOrInheritedTupleAttributes.visit((Classifier) VSLJavaValidator._nfp_duration));
			for (List<Element> l : visibleProperties) {
				iterableIEobjectDescriptions = Scopes.scopedElementsFor(l);
				resultScope = resultScope != null ? new SimpleScope(resultScope, iterableIEobjectDescriptions) : new SimpleScope(iterableIEobjectDescriptions);
			}
		}

		return resultScope != null ? resultScope : new SimpleScope(Scopes.scopedElementsFor(new ArrayList<Element>()));
	}



	// ///////////////
	// UTILS
	// ///////////////

	public static List<EObject> getVisibleNamesAsAList(NameOrChoiceOrBehaviorCall ctx) {
		List<EObject> allVisibleNames = new ArrayList<EObject>();

		if (ctx.getPath() != null) {
			QualifiedName qualifiedName = ctx.getPath();
			while (qualifiedName.getRemaining() != null) {
				qualifiedName = qualifiedName.getRemaining();
			}
			Namespace nearestNamespace = qualifiedName.getPath();
			if (nearestNamespace != null) {
				allVisibleNames.addAll(nearestNamespace.getOwnedMembers());
			}
		}

		return allVisibleNames;
	}

	public static IScope getVisibleNamesAsAScope(IScope outer, Element context) {
		IScope result = null;
		if (outer != null) {
			for (Element currentContext : context.getOwnedElements()) {
				List<Element> ownedElements = currentContext.getOwnedElements();
				List<NamedElement> ownedNamedElements = new ArrayList<NamedElement>();
				for (Element ownedElement : ownedElements) {
					if (ownedElement instanceof NamedElement) {
						ownedNamedElements.add((NamedElement) ownedElement);
					}
				}
				Iterable<IEObjectDescription> localIterableIEobjectDescriptions = Scopes.scopedElementsFor(ownedNamedElements);
				result = new SimpleScope(outer, localIterableIEobjectDescriptions);
			}
		}
		else {
			List<Element> contextHierarchy = new ArrayList<Element>();
			contextHierarchy.add(context);
			Element tmpContext = context.getOwner();
			while (tmpContext != null) {
				contextHierarchy.add(0, tmpContext);
				tmpContext = tmpContext.getOwner();
			}
			for (Element currentContext : contextHierarchy) {
				List<Element> ownedElements = currentContext.getOwnedElements();
				List<NamedElement> ownedNamedElements = new ArrayList<NamedElement>();
				for (Element ownedElement : ownedElements) {
					if (ownedElement instanceof NamedElement) {
						ownedNamedElements.add((NamedElement) ownedElement);
					}
				}
				Iterable<IEObjectDescription> locallyVisibleElements = Scopes.scopedElementsFor(ownedNamedElements);
				if (result == null) {
					result = new SimpleScope(locallyVisibleElements);
				}
				else {
					result = new SimpleScope(result, locallyVisibleElements);
				}
			}
		}
		if (context instanceof NamedElement) {
			List<NamedElement> self = new ArrayList<NamedElement>();
			self.add((NamedElement) context);
			Iterable<IEObjectDescription> locallyVisibleElements = Scopes.scopedElementsFor(self);
			result = new SimpleScope(result, locallyVisibleElements);
		}
		return result;
	}

	private static IScope getVisibleNamesAsAScopeWithAccountForInheritance(IScope outer, Classifier type, List<Visitor<NamedElement, Classifier>> visitors) {
		IScope result = null;

		// build the classifier inheritance hierarchy

		List<List<Classifier>> inheritanceStructure = new ArrayList<List<Classifier>>();
		List<Classifier> tmpList = new ArrayList<Classifier>();
		tmpList.add(type);

		do {
			inheritanceStructure.add(tmpList);
			List<Classifier> localClassifierList = new ArrayList<Classifier>();
			for (Classifier currentClassifier : tmpList) {
				for (Classifier general : currentClassifier.getGenerals()) {
					localClassifierList.add(general);
				}
			}
			tmpList = new ArrayList<Classifier>();
			tmpList.addAll(localClassifierList);
		} while (!tmpList.isEmpty());

		// builds the nested scope

		if (!inheritanceStructure.isEmpty()) {
			List<NamedElement> visibleProperties = new ArrayList<NamedElement>();
			List<Classifier> currentList = inheritanceStructure.get(inheritanceStructure.size() - 1);
			for (Classifier currentClassifier : currentList) {
				for (Visitor<NamedElement, Classifier> v : visitors) {
					visibleProperties.addAll(v.visit(currentClassifier));
				}
			}
			Iterable<IEObjectDescription> visiblePropertiesIterable =
					Scopes.scopedElementsFor(visibleProperties);
			result = new SimpleScope(visiblePropertiesIterable);
			for (int i = inheritanceStructure.size() - 2; i >= 0; i--) {
				visibleProperties = new ArrayList<NamedElement>();
				currentList = inheritanceStructure.get(i);
				for (Classifier currentClassifier : currentList) {
					for (Visitor<NamedElement, Classifier> v : visitors) {
						visibleProperties.addAll(v.visit(currentClassifier));
					}
				}
				visiblePropertiesIterable =
						Scopes.scopedElementsFor(visibleProperties);
				result = new SimpleScope(result, visiblePropertiesIterable);
			}
		}

		return result;
	}

}
