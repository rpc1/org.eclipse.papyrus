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
package org.eclipse.papyrus.moka.communication.reply;

import org.eclipse.papyrus.moka.MokaConstants;

/**
 * A reply message used to synchronize the debug target and the execution engine,
 * in case where no specific additional information needs to be conveyed.
 *
 */
public class Ack extends ReplyMessage {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.papyrus.moka.communication.reply.ReplyMessage#marshal()
	 */
	@Override
	public String marshal() {
		return MokaConstants.ack;
	}

}
