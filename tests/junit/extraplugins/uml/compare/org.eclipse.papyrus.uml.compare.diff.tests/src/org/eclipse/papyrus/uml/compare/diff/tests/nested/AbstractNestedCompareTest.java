/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests.nested;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.compare.diff.services.UMLDiffService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMatchService;
import org.eclipse.papyrus.uml.compare.diff.services.nested.NestedMergeUtils;
import org.eclipse.papyrus.uml.compare.diff.tests.AbstractCompareTest;
import org.eclipse.papyrus.uml.compare.diff.tests.Activator;
import org.eclipse.uml2.uml.Package;

;

/**
 * 
 * This abstract provides methods to compare 2 Papyrus uml files named "left.uml" and "right.uml"
 * 
 */
public abstract class AbstractNestedCompareTest extends AbstractCompareTest {


	/** the root of the model used for the test */
	protected static Package root;

	private static final String FOLDER_PATH = "/resources/nested/";

	/** the name of the model used to do the test */
	private static final String MODEL = "model";



	public static final void init(final String modelPath, boolean leftToRight) throws CoreException, IOException, ServiceException, ModelMultiException {
		AbstractNestedCompareTest.init(FOLDER_PATH, modelPath, leftToRight);
	}
	
	public static final void init(final String folderPath, final String modelPath, boolean leftToRight) throws CoreException, IOException, ServiceException, ModelMultiException {
		GenericUtils.closeIntroPart();
		GenericUtils.cleanWorkspace();
		AbstractCompareTest.leftToRight = leftToRight;
		project = ProjectUtils.createProject("MyProject"); //$NON-NLS-1$
		PapyrusProjectUtils.copyPapyrusModel(project, Activator.getDefault().getBundle(), folderPath + modelPath, MODEL);
		final List<IFile> comparedFiles = new ArrayList<IFile>();
		comparedFiles.add(project.getFile(MODEL + "." + "uml"));
		AbstractCompareTest.loadModels(comparedFiles);
		root = (Package)roots.get(0);
	}

	/**
	 * 
	 * @param leftRoot
	 * @param rightRoot
	 * @return
	 *         The diffModel for these parameters
	 * @throws InterruptedException
	 */
	protected DiffModel getDiffModel(EObject leftRoot, EObject rightRoot) throws InterruptedException {
		final ComparisonResourceSnapshot snapshot = DiffFactory.eINSTANCE.createComparisonResourceSnapshot(); //TODO it should be interesting to factorize this process between the JUnit tests and the "graphical use"
		Map<String, Object> options = NestedMergeUtils.getMergeOptions(null, leftRoot, rightRoot);;
		// Matching model elements
		final MatchModel match = NestedMatchService.doContentMatch(leftRoot, rightRoot, options);
		// Computing differences
		final DiffModel diff = UMLDiffService.doDiff(match, false, options);
		snapshot.setMatch(match);
		snapshot.setDiff(diff);
		return diff;
	}
}
