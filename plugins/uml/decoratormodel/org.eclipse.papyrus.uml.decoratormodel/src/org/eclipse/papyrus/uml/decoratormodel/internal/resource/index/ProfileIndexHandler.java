/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
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
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.xml.sax.Attributes;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * SAX parsing handler for indexing a profile-application resource. It produces two outputs:
 * <ul>
 * <li>{@link #getReferencedModelURIs()}: the set of model resource URIs for which the resource profiles profile applications (without fragments)</li>
 * <li>{@link #getAppliedProfileURIs()}: a mapping of applying package to applied profile, as object URIs (with fragments)</li>
 * </ul>
 */
public class ProfileIndexHandler extends AbstractUMLIndexHandler {
	private final Set<URI> referencedModelURIs = Sets.newHashSet();
	private final Map<URI, Map<URI, URI>> packageToProfileApplications = Maps.newHashMap();
	private String externalizationName;

	private String dependencyType;
	private String client;
	private String profileApplication;
	private String appliedProfile;

	private Map<String, URI> packageClients = Maps.newHashMap();
	private URIPair currentProfileApplication;
	private Multimap<String, URIPair> packageProfileApplications = ArrayListMultimap.create();

	/**
	 * Initializes me.
	 *
	 * @param fileURI
	 *            the URI of the profile-application file that I am parsing
	 */
	public ProfileIndexHandler(final URI fileURI) {
		super(fileURI);
	}

	public Set<URI> getReferencedModelURIs() {
		return referencedModelURIs;
	}

	public Map<URI, Map<URI, URI>> getPackageToProfileApplications() {
		return packageToProfileApplications;
	}

	public String getExternalizationName() {
		return externalizationName == null ? "<unnamed>" : externalizationName;
	}

	@Override
	protected void initializeUMLElementNames() {
		super.initializeUMLElementNames();

		dependencyType = umlElement("Dependency"); //$NON-NLS-1$
		client = "client"; //$NON-NLS-1$

		profileApplication = "profileApplication"; //$NON-NLS-1$
		appliedProfile = "appliedProfile"; //$NON-NLS-1$
	}

	@Override
	protected void enterPackage(UMLElement package_, Attributes attributes) {
		if (package_.parent == null) {
			externalizationName = attributes.getValue("name"); //$NON-NLS-1$
		}
	}

	@Override
	protected boolean doHandleUMLElement(UMLElement element, Attributes attributes) {
		boolean result = false;

		if (element.isA(dependencyType)) {
			// It's a dependency. We want its client
			await(client);
			result = true;
		} else if (element.isRole(profileApplication)) {
			currentProfileApplication = new URIPair();
			packageProfileApplications.put(currentPackage.id, currentProfileApplication);
			await(appliedProfile);
			result = true;
		}

		return result;
	}

	@Override
	protected void handleAwaitedElement(UMLElement element) {
		if (element.isRole(client) && element.isPackage()) {
			// Got a package dependency client
			handleDependencyClient(element);
		} else if (element.isRole(appliedProfile)) {
			handleAppliedProfile(element);
		}
	}

	protected void handleDependencyClient(UMLElement client) {
		URI href = client.getHREF();
		if (href != null) {
			referencedModelURIs.add(href.trimFragment());
			packageClients.put(currentPackage.id, href);
		}
	}

	@Override
	protected void handleAnnotationReferences(UMLElement references) {
		URI href = references.getHREF();
		if (href != null) {
			currentProfileApplication.second = href;
		}
	}

	protected void handleAppliedProfile(UMLElement appliedProfile) {
		URI href = appliedProfile.getHREF();
		if (href != null) {
			currentProfileApplication.first = href;
		}
	}

	@Override
	protected void summarize() {
		for (String packageID : packageProfileApplications.keySet()) {
			URI applyingPackageURI = packageClients.get(packageID);
			if (applyingPackageURI != null) {
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
}
