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

package org.eclipse.papyrus.qompass.designer.core.transformations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;

/**
 * A collection of transformations related to component-types (or abstract implementations)
 *
 * 1. Add access operations for ports, i.e. operations that return a reference of a port
 * (if port provides interface) and/or allow to connect a port with a given reference
 * (if port requires an interface)
 * 2. Remove ports (after ports have been replaced with standard properties)
 *
 * TODO: transformation is specific to C++
 * TODO: currently unused
 *
 * @author ansgar
 *
 */
@Deprecated
public class CompTypeTrafos {

	public static final String INDEX_TYPE_FOR_MULTI_RECEPTACLE = "corba::Long"; //$NON-NLS-1$

	/**
	 * Complete access operations recursively, i.e. traverse all packageable
	 * elements and apply the completeAccessOps operation on classes
	 *
	 * @param pkg
	 *            the package for which the completion should start
	 * @see completeAccessOps(Class)
	 */
	public static void completeAccessOps(Package pkg) {
		for (PackageableElement element : new BasicEList<PackageableElement>(pkg.getPackagedElements())) {
			if (element instanceof Package) {
				completeAccessOps((Package) element);
			} else if (element instanceof Class) {
				completeAccessOps((Class) element);
			}
		}
	}

	/**
	 * Complete access operations that return the reference. This function is a completion,
	 * since the access operations have already been added for component implementations
	 * (partly, if implementation was abstract).
	 *
	 * @param component
	 *            the component for which access operation should be completed.
	 * @return
	 */
	private static void completeAccessOps(Class component) {
		// only owned ports => since the operation is also applied on inherited types.
		for (Port port : component.getOwnedPorts()) {
			Interface providedIntf = PortUtils.getProvided(port);
			if (providedIntf != null) {
				// add operation CCM_<%type%> get_<portname>
				String getName = PrefixConstants.getP_Prefix + port.getName();

				// create unless already existing
				if (component.getOwnedOperation(getName, null, null) == null) {
					Operation op = component.createOwnedOperation(getName, null, null);
					op.setIsAbstract(true);
					Parameter retParam = op.createOwnedParameter("ret", providedIntf); //$NON-NLS-1$
					retParam.setDirection(ParameterDirectionKind.RETURN_LITERAL);
					StereotypeUtil.apply(retParam, Ptr.class);
					// StereotypeUtil.apply(op, CppVirtual.class);
				}
			}
			Interface requiredIntf = PortUtils.getRequired(port);
			if (requiredIntf != null) {
				// add operation CCM_<%type%> connect_q <portname>
				String connName = PrefixConstants.connectQ_Prefix + port.getName();

				// create unless already existing
				if (component.getOwnedOperation(connName, null, null) == null) {
					Operation op = component.createOwnedOperation(connName, null, null);
					op.setIsAbstract(true);
					boolean multiPort = (port.getUpper() > 1) || (port.getUpper() == -1); // -1 indicates "*"
					if (multiPort) {
						// add index parameter
						Element eLong = Utils.getQualifiedElement(PackageUtil.getRootPackage(component), INDEX_TYPE_FOR_MULTI_RECEPTACLE);
						if (eLong instanceof Type) {
							op.createOwnedParameter("index", (Type) eLong); //$NON-NLS-1$
						}
						else {
							throw new RuntimeException(String.format(Messages.CompTypeTrafos_CannotFindType, INDEX_TYPE_FOR_MULTI_RECEPTACLE));
						}
					}
					Parameter refParam = op.createOwnedParameter("ref", requiredIntf); //$NON-NLS-1$
					refParam.setDirection(ParameterDirectionKind.IN_LITERAL);
					StereotypeUtil.apply(refParam, Ptr.class);
					// StereotypeUtil.apply(op, CppVirtual.class);
				}
			}
		}
	}
}
