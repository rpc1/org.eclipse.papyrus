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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer.bundle;

import java.util.ArrayList;

import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.internal.core.ifeature.IFeatureModel;
import org.eclipse.uml2.uml.Component;
import org.osgi.framework.Bundle;


/**
 * this registry redirect the job to a good implementation.
 *
 */
@SuppressWarnings("restriction")
public class BundleDesignerRegistry implements IBundleDescriptionDesigner {
	protected WorkspaceBundleDescriptionDesigner workspaceBundleDescriptionDesigner;
	protected LoadedBundleDescriptionDesigner loadedBundleDescriptionDesigner;
	protected FeatureDescriptionDesigner featureDescriptionDesigner;


	/**
	 * create the registry
	 * Constructor.
	 *
	 */
	public BundleDesignerRegistry() {
		workspaceBundleDescriptionDesigner = new WorkspaceBundleDescriptionDesigner();
		loadedBundleDescriptionDesigner = new LoadedBundleDescriptionDesigner();
		featureDescriptionDesigner = new FeatureDescriptionDesigner();
	}

	/**
	 *
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getBundleValue(java.lang.Object, java.lang.String)
	 *
	 * @param bundleProject
	 * @param key
	 * @return the value that correspond to the key
	 */
	public String getBundleValue(Object bundleProject, String key) {
		if (bundleProject instanceof IBundleProjectDescription) {
			return workspaceBundleDescriptionDesigner.getBundleValue(bundleProject, key);

		}
		else if (bundleProject instanceof Bundle) {
			return loadedBundleDescriptionDesigner.getBundleValue(bundleProject, key);
		}
		else if (bundleProject instanceof IFeatureModel) {
			return featureDescriptionDesigner.getBundleValue(bundleProject, key);
		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#fillPluginProperties(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 */
	public void fillPluginProperties(Component bundleComponent, Object bundleProject) {
		if (bundleProject instanceof IBundleProjectDescription) {
			workspaceBundleDescriptionDesigner.fillPluginProperties(bundleComponent, bundleProject);

		}
		else if (bundleProject instanceof Bundle) {
			loadedBundleDescriptionDesigner.fillPluginProperties(bundleComponent, bundleProject);
		}
		else if (bundleProject instanceof IFeatureModel) {
			featureDescriptionDesigner.fillPluginProperties(bundleComponent, bundleProject);
		}
	}

	/**
	 *
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getSymbolicName(java.lang.Object)
	 *
	 * @param bundleProject
	 * @return a string that correspond to the symbolic name
	 */
	public String getSymbolicName(Object bundleProject) {
		if (bundleProject instanceof IBundleProjectDescription) {
			return workspaceBundleDescriptionDesigner.getSymbolicName(bundleProject);

		}
		else if (bundleProject instanceof Bundle) {
			return loadedBundleDescriptionDesigner.getSymbolicName(bundleProject);
		}
		else if (bundleProject instanceof IFeatureModel) {
			return featureDescriptionDesigner.getSymbolicName(bundleProject);
		}
		return null;
	}

	/**
	 *
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#fillExportedPackages(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 */
	public void fillExportedPackages(Component bundleComponent, Object bundleProject) {
		if (bundleProject instanceof IBundleProjectDescription) {
			workspaceBundleDescriptionDesigner.fillExportedPackages(bundleComponent, bundleProject);

		}
		else if (bundleProject instanceof Bundle) {
			loadedBundleDescriptionDesigner.fillExportedPackages(bundleComponent, bundleProject);
		}
		else if (bundleProject instanceof IFeatureModel) {
			featureDescriptionDesigner.fillExportedPackages(bundleComponent, bundleProject);
		}

	}

	/**
	 *
	 * @see org.eclipse.papyrus.adltool.designer.bundle.IBundleDescriptionDesigner#getRequiredBundle(org.eclipse.uml2.uml.Component, java.lang.Object)
	 *
	 * @param bundleComponent
	 * @param bundleProject
	 * @return the list of required Bundle
	 */
	public ArrayList<ReferencedOSGIElement> getRequiredBundle(Component bundleComponent, Object bundleProject) {
		if (bundleProject instanceof IBundleProjectDescription) {
			return workspaceBundleDescriptionDesigner.getRequiredBundle(bundleComponent, bundleProject);

		}
		else if (bundleProject instanceof Bundle) {
			return loadedBundleDescriptionDesigner.getRequiredBundle(bundleComponent, bundleProject);
		}
		else if (bundleProject instanceof IFeatureModel) {
			return featureDescriptionDesigner.getRequiredBundle(bundleComponent, bundleProject);
		}

		return new ArrayList<ReferencedOSGIElement>();
	}

	public String getName(Object bundleProject) {
		if (bundleProject instanceof IBundleProjectDescription) {
			return workspaceBundleDescriptionDesigner.getName(bundleProject);

		}
		else if (bundleProject instanceof Bundle) {
			return loadedBundleDescriptionDesigner.getName(bundleProject);
		}
		else if (bundleProject instanceof IFeatureModel) {
			return featureDescriptionDesigner.getName(bundleProject);
		}
		return null;
	}
}
