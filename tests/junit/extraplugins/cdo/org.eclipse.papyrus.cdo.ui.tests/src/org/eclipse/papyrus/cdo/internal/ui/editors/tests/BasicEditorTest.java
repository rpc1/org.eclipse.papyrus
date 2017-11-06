/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 422257
 *
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.editors.tests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.cdo.util.ConcurrentAccessException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.expressions.CDOObjectPropertyTester;
import org.eclipse.papyrus.cdo.ui.tests.AbstractPapyrusCDOUITest;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IComponentPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IEditorPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageVisitor;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.utils.AdapterUtils;
import org.eclipse.papyrus.junit.framework.classification.rules.MemoryLeakRule;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Class;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.google.common.base.Optional;

/**
 * This is the BasicEditorTest type. Enjoy.
 */
public class BasicEditorTest extends AbstractPapyrusCDOUITest {

	private static final Object[] NO_OBJECTS = {};

	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();


	@BeforeClass
	public static void beforeClass() {
		System.setProperty("cdo.interactive.conflict.resolution", "false");
	}

	@AfterClass
	public static void afterClass() {
		System.clearProperty("cdo.interactive.conflict.resolution");
	}

	public BasicEditorTest() {
		super();
	}

	@Test
	public void editorOpens() {
		openEditor();

		Class foo = expectElement("Foo", Class.class);
		EditPart editPart = expectEditPart(foo);

		assertThat(editPart.isActive(), is(true));
	}

	@Test
	public void canLock() {
		openEditor();

		Class foo = expectElement("Foo", Class.class);
		EditPart editPart = expectEditPart(foo);

		CDOObject cdoObject = (CDOObject) editPart.getAdapter(CDOObject.class);
		boolean canLock = new CDOObjectPropertyTester().test(cdoObject, CDOObjectPropertyTester.CAN_LOCK, NO_OBJECTS, true);
		assertThat(canLock, is(true));
	}

	@Test
	public void isLockedLocally() {
		openEditor();

		Class foo = expectElement("Foo", Class.class);
		EditPart editPart = expectEditPart(foo);

		getDawnEditorSupport().lockObject(editPart);

		CDOObject cdoObject = (CDOObject) editPart.getAdapter(CDOObject.class);
		boolean isLocked = new CDOObjectPropertyTester().test(cdoObject, CDOObjectPropertyTester.IS_LOCKED_LOCALLY, NO_OBJECTS, true);
		assertThat(isLocked, is(true));
	}

	@Test
	public void isLockedRemotely() {
		openEditor();

		Class foo = expectElement("Foo", Class.class);
		EditPart editPart = expectEditPart(foo);

		URI uri = EcoreUtil.getURI(foo);

		// open another transaction in which to lock the element
		CDOTransaction transaction = createTransaction();
		EObject remote = transaction.getResourceSet().getEObject(uri, true);
		assertThat(remote, notNullValue());
		CDOUtils.lock(CDOUtil.getCDOObject(remote));

		// give the lock a chance to propagate
		sleep(3);

		CDOObject cdoObject = (CDOObject) editPart.getAdapter(CDOObject.class);
		boolean isLocked = new CDOObjectPropertyTester().test(cdoObject, CDOObjectPropertyTester.IS_LOCKED_REMOTELY, NO_OBJECTS, true);
		assertThat(isLocked, is(true));
	}

	@Test
	public void isConflicting() throws Exception {
		openEditor();

		final Class foo = expectElement("Foo", Class.class);
		EditPart editPart = expectEditPart(foo);
		executeEdit(new Runnable() {

			@Override
			public void run() {
				foo.setName("Foo1");
			}
		});

		URI uri = EcoreUtil.getURI(foo);

		// open another transaction in which to modify the element
		CDOTransaction transaction = createTransaction();
		Class remote = (Class) transaction.getResourceSet().getEObject(uri, true);
		assertThat(remote, notNullValue());
		remote.setName("Foo2");
		transaction.commit();

		// give the lock a chance to propagate
		sleep(3);

		CDOObject cdoObject = (CDOObject) editPart.getAdapter(CDOObject.class);
		boolean isConflicting = new CDOObjectPropertyTester().test(cdoObject, CDOObjectPropertyTester.IS_CONFLICTED, NO_OBJECTS, true);
		assertThat(isConflicting, is(true));
	}

	// TODO Re-enable when interactive conflict resolution is in place and modal dialog can be tested.
	// @Test
	public void handlesConflict() throws Exception {
		IEditorPart editor = openEditor();
		CDOTransaction transaction = null;

		try {
			final Class foo = expectElement("Foo", Class.class);
			EditPart editPart = expectEditPart(foo);
			executeEdit(new Runnable() {

				@Override
				public void run() {
					foo.setName("Foo1");
				}
			});

			URI uri = EcoreUtil.getURI(foo);

			// open another transaction in which to modify the element
			transaction = createTransaction();
			Class remote = (Class) transaction.getResourceSet().getEObject(uri, true);
			assertThat(remote, notNullValue());
			remote.setName("Foo2");
			transaction.commit();
			transaction.close();

			// give the lock a chance to propagate
			sleep(3);

			CDOObject cdoObject = (CDOObject) editPart.getAdapter(CDOObject.class);
			boolean isConflicting = new CDOObjectPropertyTester().test(cdoObject, CDOObjectPropertyTester.IS_CONFLICTED, NO_OBJECTS, true);
			assertThat(isConflicting, is(true));

			editor.doSave(null);
		} finally {
			LifecycleUtil.deactivate(transaction);
			closeEditor();
		}
	}

	@Test
	public void editorDoesNotLeakWhenClosed() throws Exception {
		Optional<ISashWindowsContainer> sashContainer = AdapterUtils.adapt(openEditor(), ISashWindowsContainer.class);
		sashContainer.get().visit(new IPageVisitor() {

			@Override
			public void accept(IEditorPage page) {
				memory.add(page.getIEditorPart());
			}

			@Override
			public void accept(IComponentPage page) {
				// Pass
			}
		});

		// Close the editor and open a new one so that the Outline View page
		// may be replaced and reclaimed by GC
		closeEditor();
		openEditor();
	}
}
