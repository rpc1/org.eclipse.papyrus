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

package org.eclipse.papyrus.umlrt.ui.internal.sync.statemachine;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.sync.NodePositionSyncFeature;
import org.eclipse.papyrus.infra.gmfdiag.common.sync.NodeSizeSyncFeature;
import org.eclipse.papyrus.umlrt.ui.internal.sync.UMLRTMasterSlaveSyncBucket;
import org.eclipse.uml2.uml.Region;

/**
 * Synchronization bucket for regions in a UML-RT Capsule state machine diagram.
 */
public class RegionSyncBucket extends UMLRTMasterSlaveSyncBucket<Region> {

	public RegionSyncBucket(Region model, EditPart master) {
		super(model, master);

		add(new NodeSizeSyncFeature<>(this));
		add(new NodePositionSyncFeature<>(this));
		add(new RegionVerticesSyncFeature(this));
	}

}
