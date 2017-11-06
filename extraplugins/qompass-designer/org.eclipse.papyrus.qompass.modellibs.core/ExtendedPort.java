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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.modellibs.core.mappingrules;

import org.eclipse.papyrus.FCM.util.IMappingRule;
import org.eclipse.papyrus.FCM.util.MapUtil;
import org.eclipse.papyrus.qompass.designer.core.OperationUtils;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;


/**
 * An extended Port in the sense of the DDS4CCM standard: a port typed with a component
 * type. Since the component typing the port can have multiple provided and required
 * ports, the ports are implicitly owned by the port. Conjugation on the level of an extended
 * port level will conjugate all ports of the component typing the port.
 * 
 * The derived interface that is provided will concatenate provided port names within the
 * extended port with the port name and provided a "big" interface.
 * The derived interface that is required is identical, except for a conjugation on the
 * extended port level.
 * 
 * Creates a fixed template binding that binds T (of the extended Port) to the used data type
 * 
 * Here, the idea is that the port type is a classifier, e.g. the data type that is
 * transported by a DDS port. The port kind is the extended port, e.g. DDSWrite.
 * 
 * The derived property isExtended of FCM port-kind is true, if the class representing the port-kind owns at least one
 * port
 * 
 * @author ansgar
 * 
 */
public class ExtendedPort implements IMappingRule {

	public Interface getProvided(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config, boolean update)
	{
		return getDerived(p, false, config, update);
	}

	public Interface getRequired(org.eclipse.papyrus.FCM.Port p, InstanceSpecification config, boolean update)
	{
		return getDerived(p, true, config, update);
	}

	public Interface getDerived(org.eclipse.papyrus.FCM.Port extPort, boolean isRequired, InstanceSpecification config, boolean update)
	{
		Type type = extPort.getBase_Port().getType();
		if(!(type instanceof Classifier)) {
			return null;
		}
		Class extendedPort = extPort.getKind().getBase_Class();

		String prefix = extendedPort.getName() + "_" + (isRequired ? "R_" : "P_");
		Interface derivedInterface = MapUtil.getOrCreateDerivedInterfaceFP(extPort, prefix, type, update);
		if (!update) {
			return derivedInterface;
		}
		if(derivedInterface == null) {
			return null;
		}
		/*
		TemplateSignature signature = TemplateUtils.getSignature(type.getNearestPackage());
		if(signature != null) {
			Package model = Utils.getTop(derivedInterface);
			try {
				TemplateBinding binding =
					TemplateUtils.fixedBinding(model, extendedPort, (Classifier)type);
				Copy copy = new Copy(model, model, false);
				TemplateInstantiation ti = new TemplateInstantiation(copy, binding);
				// create a bound element of the extended port. Add bound class to derived interface class
				Class boundClass = ti.bindNamedElement(extendedPort);
				derivedInterface.getNearestPackage().getPackagedElements().add(boundClass);
			} catch (TransformationException e) {
				return null;
			}
		}
		*/
		// obtain first template parameter = port type
		// kind.getBase_Class().getNearestPackage().getTemplateParameter();

		for(Port port : extendedPort.getOwnedPorts()) {
			Interface derivedIntf = (isRequired) ?
				PortUtils.getRequired(port) :
				PortUtils.getProvided(port);

			if(derivedIntf != null) {
				for(Operation op : derivedIntf.getAllOperations()) {
					String name = port.getName() + "_" + op.getName(); //$NON-NLS-1$

					// check whether operation already exists. Create, if not
					Operation derivedOperation = derivedInterface.getOperation(name, null, null);
					if(derivedOperation == null) {
						derivedOperation = derivedInterface.createOwnedOperation(name, null, null);
						OperationUtils.syncOperation(op, derivedOperation);
						derivedOperation.setName(name);
					}
					else {
						if (!OperationUtils.isSameOperation(derivedOperation, op, false)) {
							OperationUtils.syncOperation(op, derivedOperation);
							derivedOperation.setName(name);
						}
					}
				}
			}
		}
		return derivedInterface;
	}
}
