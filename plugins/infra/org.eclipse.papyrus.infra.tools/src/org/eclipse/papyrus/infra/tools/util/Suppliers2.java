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

package org.eclipse.papyrus.infra.tools.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.papyrus.infra.tools.Activator;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * Utilities for working with suppliers that are not provided by {@linkplain Suppliers Guava}.
 */
public class Suppliers2 {
	/**
	 * Not instantiable by clients.
	 */
	private Suppliers2() {
		super();
	}

	/**
	 * Obtain a supplier that eventually provides the value of a {@code future} result.
	 * Accessing the supplier returns {@code null} until the {@code future}'s value is
	 * available, after which it returns that value. If the future completes with an
	 * exception, then the supplier will always provide {@code null} and the exception
	 * will not be accessible.
	 * 
	 * @param future
	 *            a future result
	 * @return a supplier of the eventual value of the {@code future}
	 */
	public static <V> Supplier<V> eventualSupplier(Future<V> future) {
		return eventualSupplier(future, null);
	}

	/**
	 * Obtain a supplier that eventually provides the value of a {@code future} result.
	 * Accessing the supplier returns the given {@code defaultValue} until the {@code future}'s value is
	 * available, after which it returns that value. If the future completes with an
	 * exception, then the supplier will always provide the default and the exception
	 * will not be accessible.
	 * 
	 * @param future
	 *            a future result
	 * @param defaultValue
	 *            the default value to provide until the future is done
	 * @return a supplier of the eventual value of the {@code future}
	 */
	public static <V> Supplier<V> eventualSupplier(Future<V> future, V defaultValue) {
		return (future instanceof ListenableFuture<?>)
				? new ListenableFutureSupplier<V>((ListenableFuture<V>) future, defaultValue)
				: new FutureSupplier<V>(future, defaultValue);
	}

	//
	// Nested types
	//

	private static class FutureSupplier<V> implements Supplier<V> {
		private Future<V> future;
		private V value;

		FutureSupplier(Future<V> future, V defaultValue) {
			this.future = future;
			this.value = defaultValue;
		}

		public V get() {
			if ((value == null) && (future != null) && future.isDone()) {
				try {
					if (future.isCancelled()) {
						Activator.log.warn("Future of EventualSupplier was cancelled: " + future); //$NON-NLS-1$
					} else {
						value = future.get();
					}
				} catch (InterruptedException e) {
					// Shouldn't happen on a done future
					Activator.log.error("Interrupted on a done future.", e); //$NON-NLS-1$
				} catch (ExecutionException e) {
					// Normal case. There will never be a value
					Activator.log.error("Future execution failed", e.getCause());
				} finally {
					future = null;
				}
			}

			return value;
		}
	}

	private static class ListenableFutureSupplier<V> implements Supplier<V> {
		private AtomicReference<V> value;

		ListenableFutureSupplier(ListenableFuture<V> future, V defaultValue) {
			value = new AtomicReference<V>(defaultValue);

			Futures.addCallback(future, new FutureCallback<V>() {
				public void onSuccess(V result) {
					value.set(result);
				}

				public void onFailure(Throwable t) {
					// Normal case. There will never be a value
					Activator.log.error("Future execution failed", t);
				}
			});
		}

		public V get() {
			return value.get();
		}
	}

}
