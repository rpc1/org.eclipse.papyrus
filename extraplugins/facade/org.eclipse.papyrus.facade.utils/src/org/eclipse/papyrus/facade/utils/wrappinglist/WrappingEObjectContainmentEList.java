/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.facade.utils.wrappinglist;

import java.util.Collection;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.papyrus.facade.utils.RepresentingElement;
import org.eclipse.uml2.uml.Element;


public class WrappingEObjectContainmentEList<E extends RepresentingElement> extends EObjectContainmentEList<E> implements WrappingList<E> {

	protected Collection<Element> representedElementList;

	public WrappingEObjectContainmentEList(Class<?> dataClass, InternalEObject owner, int featureID, Collection<Element> representedElementList) {
		super(dataClass, owner, featureID);
		this.representedElementList = representedElementList;
	}

	@Override
	public boolean add(E object) {

		if (!representedElementList.contains(object.get__Represented())) {
			representedElementList.add((Element) object.get__Represented());
		}

		if (isUnique() && contains(object)) {
			return false;
		} else {
			super.doAddUnique(object);
			if (hasInverse()) {
				inverseAdd(object, null);
			}

			return true;
		}

		// return super.add(object);
	}

	@Override
	public void add(int index, E e) {
		if (!representedElementList.contains((e).get__Represented())) {
			representedElementList.add((Element) (e).get__Represented());
		}

		super.doAddUnique(index, e);
		if (hasInverse()) {
			inverseAdd(e, null);
		}

		// super.add(index, e);
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		for (E e : collection) {
			if (!representedElementList.contains(e.get__Represented())) {
				representedElementList.add((Element) e.get__Represented());
			}
		}

		if (collection.isEmpty()) {
			return false;
		} else {
			for (E e : collection) {
				super.doAddUnique(e);
				if (hasInverse()) {
					inverseAdd(e, null);
				}
			}
			return true;
		}

		// return super.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		for (E e : collection) {
			if (!representedElementList.contains(e.get__Represented())) {
				representedElementList.add((Element) e.get__Represented());
			}
		}

		if (collection.isEmpty()) {
			return false;
		} else {
			int collectionSize = collection.size();

			super.doAddAllUnique(index, collection);

			if (hasInverse()) {
				int lastIndex = index + collectionSize;
				for (int i = index; i < lastIndex; ++i) {
					@SuppressWarnings("unchecked")
					E object = (E) data[i];
					inverseAdd(object, null);
				}
			}
			return true;
		}
	}


	@Override
	public boolean remove(Object object) {
		Object representedElement = ((RepresentingElement) object).get__Represented();
		representedElementList.remove(representedElement);

		if (this.contains(object)) {
			E oldObject = doRemove(indexOf(object));
			if (hasInverse() && oldObject != null) {
				inverseRemove(oldObject, null);
			}
			return true;
		} else {
			return false;
		}
		// return oldObject;

		// return super.remove(object);
	}

	@Override
	public E remove(int index) {
		Object representedElement = ((RepresentingElement) this.get(index)).get__Represented();
		representedElementList.remove(representedElement);


		E oldObject = doRemove(index);
		if (hasInverse() && oldObject != null) {
			inverseRemove(oldObject, null);
		}
		return oldObject;

		// return super.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		for (Object object : collection) {
			Object representedElement = ((RepresentingElement) object).get__Represented();
			representedElementList.remove(representedElement);
		}

		boolean result = false;

		for (Object object : collection) {
			if (this.contains(object)) {
				E oldObject = doRemove(indexOf(object));
				if (hasInverse() && oldObject != null) {
					inverseRemove(oldObject, null);
				}
				result = true;
			}
		}
		return result;

		// return super.removeAll(collection);
	}

	@Override
	public void clear() {

		representedElementList.clear();

		for (Object object : this) {
			if (this.contains(object)) {
				E oldObject = doRemove(indexOf(object));
				if (hasInverse() && oldObject != null) {
					inverseRemove(oldObject, null);
				}

			}
		}


		// super.clear();
	}

	@Override
	public void notWrappingAdd(E object) {
		doAddUnique(object);



	}

	@Override
	public E notWrappingRemove(E object) {

		return doRemove(indexOf(object));
	}




	@Override
	public void silentAdd(int index, E object) {

		super.doAddUnique(index, object);
		if (hasInverse()) {
			inverseAdd(object, null);
		}

	}


	@Override
	public E silentRemove(int index) {
		E oldObject = super.doRemove(index);
		if (hasInverse() && oldObject != null) {
			inverseRemove(oldObject, null);

		}
		return oldObject;
	}





}
