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
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.stereotypecollector;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.URI;

/**
 *
 * Implements a visitor that goes through a hierarchy of Iresource from a root and collect only those that can be processed for search
 *
 */
public class PapyrusUMLResourceVisitor extends UMLResourceVisitor {
	
	public PapyrusUMLResourceVisitor() {
		super();
		this.participantURIs = new HashSet<URI>();
	}

	@Override
	public boolean visit(IResourceProxy proxy) throws CoreException {
		switch (proxy.getType()) {
		case IResource.FILE:
			IResource resource = proxy.requestResource();
			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);

			if ("uml".equals(uri.fileExtension())) { //$NON-NLS-1$
				if (resource.getWorkspace().getRoot().exists(resource.getFullPath().removeFileExtension().addFileExtension("di"))) {
					participantURIs.add(uri);
				}
			}

			break;
		default:
			break;
		}
		return true;
	}

	public Collection<URI> getParticipantURIs() {
		return participantURIs;
	}

}