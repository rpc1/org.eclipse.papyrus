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

package org.eclipse.papyrus.uml.decoratormodel.internal.resource.index;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.xml.sax.Attributes;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * SAX parsing handler for indexing a UML resource. It produces one output:
 * <ul>
 * <li>{@link #getProfileApplicationsByPackage()}: profile applications by {@link Package}, as mappings of {@link Profile}&nbsp;==>&nbsp;{@link EPackage} object URIs (with fragments)</li>
 * </ul>
 */
public class ModelIndexHandler extends AbstractUMLIndexHandler {
	private final Map<URI, Map<URI, URI>> packageToProfileApplications = Maps.newHashMap();
	private final Multimap<String, URIPair> packageProfileApplications = ArrayListMultimap.create();

	private String profileApplication;
	private String appliedProfile;

	private URIPair currentProfileApplication;

	/**
	 * Initializes me.
	 *
	 * @param fileURI
	 *            the URI of the UML file that I am parsing
	 */
	public ModelIndexHandler(final URI fileURI) {
		super(fileURI);
	}

	@Override
	public URI getFileURI() {
		return fileURI;
	}

	@Override
	public Map<URI, Map<URI, URI>> getProfileApplicationsByPackage() {
		return packageToProfileApplications;
	}

	@Override
	protected void initializeUMLElementNames() {
		super.initializeUMLElementNames();

		profileApplication = "profileApplication"; //$NON-NLS-1$
		appliedProfile = "appliedProfile"; //$NON-NLS-1$
	}

	@Override
	protected boolean doHandleUMLElement(UMLElement element, Attributes attributes) {
		boolean result = false;

		if (element.isRole(profileApplication)) {
			currentProfileApplication = new URIPair();
			packageProfileApplications.put(currentPackage.id, currentProfileApplication);
			await(appliedProfile);
			result = true;
		}

		return result;
	}

	@Override
	protected void handleAwaitedElement(UMLElement element) {
		if (element.isRole(appliedProfile)) {
			URI href = element.getHREF();
			if (href != null) {
				currentProfileApplication.first = href;
			}
		}
	}

	@Override
	protected void handleAnnotationReferences(UMLElement references) {
		URI href = references.getHREF();
		if (href != null) {
			currentProfileApplication.second = href;
		}
	}

	@Override
	protected void summarize() {
		for (String packageID : packageProfileApplications.keySet()) {
			URI applyingPackageURI = fileURI.appendFragment(packageID);
			Collection<URIPair> profileApplications = packageProfileApplications.get(packageID);
			if (!profileApplications.isEmpty()) {
				Map<URI, URI> map = packageToProfileApplications.get(applyingPackageURI);
				if (map == null) {
					map = Maps.newHashMap();
					packageToProfileApplications.put(applyingPackageURI, map);
				}
				for (URIPair profileApplication : profileApplications) {
					// If we can't determine the Ecore definition, the profile is not properly applied
					if (profileApplication.second != null) {
						map.put(profileApplication.first, profileApplication.second);
					}
				}
			}
		}
	}
}
