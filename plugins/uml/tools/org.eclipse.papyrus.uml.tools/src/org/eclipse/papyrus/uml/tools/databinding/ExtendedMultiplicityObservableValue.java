/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Nicolas FAUVERGUE (ALL4TEC) nicolas.fauvergue@all4tec.net - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.databinding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.tools.databinding.DelegatingObservable;
import org.eclipse.papyrus.infra.tools.databinding.ReferenceCountedObservable;
import org.eclipse.papyrus.uml.tools.helper.UMLDatabindingHelper;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The multiplicity observable values contains a list of 3 observable values : The first the multiplicity lower and upper value for the 'simple' mode and the 2 following are the lower and the upper value observable value.
 */
public class ExtendedMultiplicityObservableValue extends AbstractObservableValue implements AggregatedObservable {

	/**
	 * The number of ObservableValue in the ObservableList.
	 */
	private static final int NUMBER_OBSERVABLE_VALUES = 3;


	/**
	 * The list of observable values for the multiplicity editors (simple mode, lower and upper values)
	 */
	private final List<IObservableValue> observableValues;

	/**
	 * The reference counted observable support.
	 */
	private final ReferenceCountedObservable.Support refCount = new ReferenceCountedObservable.Support(this);

	/**
	 * The editing domain used.
	 */
	private final EditingDomain domain;


	/**
	 * 
	 * Constructor.
	 *
	 * @param domain
	 *            The editing domain.
	 */
	public ExtendedMultiplicityObservableValue(final EditingDomain domain) {
		this(null, domain);
	}

	/**
	 * Constructor.
	 *
	 * @param eObject
	 *            The object to edit.
	 * @param domain
	 *            The editing domain.
	 */
	public ExtendedMultiplicityObservableValue(final EObject eObject, final EditingDomain domain) {
		this.domain = domain;
		this.observableValues = new ArrayList<IObservableValue>(NUMBER_OBSERVABLE_VALUES);
		if (null != eObject) {

			observableValues.add(new MultiplicityObservableValue(eObject, domain));

			// Get the lower and upper values features
			final EStructuralFeature lowerValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue();
			final EStructuralFeature upperValueFeature = UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue();

			// Add the ObservableValues
			observableValues.add(UMLDatabindingHelper.getObservableValue(eObject, lowerValueFeature, domain));
			observableValues.add(UMLDatabindingHelper.getObservableValue(eObject, upperValueFeature, domain));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable#aggregate(org.eclipse.core.databinding.observable.IObservable)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public AggregatedObservable aggregate(final IObservable observable) {
		if (observable instanceof IObservableValue) {
			final Object value = ((IObservableValue) observable).getValue();
			if (value instanceof List<?> && NUMBER_OBSERVABLE_VALUES == ((List<?>) value).size() && isAllIObservableValueType((List<?>) value)) {
				final ExtendedMultiplicityObservableValue result = new ExtendedMultiplicityObservableValue(domain);
				
				int count = 0;
				while(count < NUMBER_OBSERVABLE_VALUES){
					final IObservableValue existingMultiplicityValues = observableValues.get(count);
					final IObservableValue multiplicityValueToAggregate = ((List<IObservableValue>) value).get(count);
					if (existingMultiplicityValues instanceof AggregatedObservable) {
						final IObservableValue aggregatedObservable = (IObservableValue) ((AggregatedObservable) existingMultiplicityValues).aggregate(multiplicityValueToAggregate);
						result.getObservableValues().add((IObservableValue) DelegatingObservable.wrap(aggregatedObservable));
					}
					count++;
				}
				
				return result;
			}
		}
		return new AggregatedPapyrusObservableValue(domain, this, observable);
	}

	/**
	 * Get if all the elements of the list are observable values.
	 * 
	 * @param values The values list.
	 * @return <code>true</code> if all the elements are observable values, <code>false</code> otherwise.
	 */
	private boolean isAllIObservableValueType(final List<?> values) {
		boolean result = true;
		final Iterator<?> value = values.iterator();

		while (result && value.hasNext()) {
			if (!(value.next() instanceof IObservableValue)) {
				result = false;
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.IObservableValue#getValueType()
	 */
	@Override
	public Object getValueType() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.value.AbstractObservableValue#doGetValue()
	 */
	@Override
	protected Object doGetValue() {
		return getObservableValues();
	}

	/**
	 * Get the observable values.
	 * 
	 * @return the observableValues.
	 */
	public List<IObservableValue> getObservableValues() {
		return observableValues;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.databinding.observable.AbstractObservable#dispose()
	 */
	@Override
	public synchronized void dispose() {
		for (IObservableValue observableValue : observableValues) {
			observableValue.dispose();
		}
		observableValues.clear();
		super.dispose();
	}

	/**
	 * This retains the support.
	 */
	public void retain() {
		refCount.retain();
	}

	/**
	 * This releases the support.
	 */
	public void release() {
		refCount.release();
	}

	/**
	 * This auto-relreases the support.
	 */
	public void autorelease() {
		refCount.autorelease();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable#hasDifferentValues()
	 */
	@Override
	public boolean hasDifferentValues() {
		return false;
	}
}
