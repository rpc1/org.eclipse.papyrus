/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.java.template.resolvers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.corext.template.java.CompilationUnitContext;
import org.eclipse.jdt.internal.corext.template.java.JavaContext;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateVariable;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

/**
 * This class creates a new variable which resolve the activator class of the compilation unit.
 *
 * @author tlandre
 *
 */
public class BundleActivatorResolver extends TemplateVariableResolver {

	public BundleActivatorResolver() {
		super("activatorLog", "Static field log in the activator containing the current compilation unit"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see TemplateVariableResolver#resolve(org.eclipse.jface.text.templates.TemplateContext)
	 *
	 */
	@SuppressWarnings("restriction")
	@Override
	public void resolve(TemplateVariable variable, TemplateContext pContext) {
		variable.setUnambiguous(true);
		variable.setValue(""); //$NON-NLS-1$
		if (pContext instanceof JavaContext) {
			final JavaContext context = (JavaContext) pContext;
			final IPluginModelBase pluginModelBase = PluginRegistry.findModel(getProject(context));
			Bundle bundle = getBundle(pluginModelBase);
			if (bundle != null) {
				Object obj = bundle.getHeaders().get(Constants.BUNDLE_ACTIVATOR);
				if (obj instanceof String) {
					StringBuffer qualifiedName = new StringBuffer((String) obj);
					qualifiedName.append(".log");
					context.addStaticImport(qualifiedName.toString());
				}
			}
		}

	}

	/**
	 * Get the bundle associated with the IPluginModelBase
	 *
	 * @param pluginModelBase
	 *            a pluginModelBase. May be null.
	 * @return the bundle found or null.
	 */
	private Bundle getBundle(IPluginModelBase pluginModelBase) {
		Bundle bundle = null;
		if (pluginModelBase != null && pluginModelBase.getBundleDescription() != null) {
			bundle = Platform.getBundle(pluginModelBase.getBundleDescription().getSymbolicName());
		}
		return bundle;
	}

	/**
	 * Get the project of the compilation unit (if any) associated with the given JavaContext
	 *
	 * @param context
	 *            the JavaContext. Must be not null.
	 * @return the project found or null
	 */
	@SuppressWarnings("restriction")
	private IProject getProject(CompilationUnitContext context) {
		IProject project = null;
		ICompilationUnit compilationUnit = context.getCompilationUnit();
		if (compilationUnit != null) {
			IJavaProject javaProject = compilationUnit.getJavaProject();
			if (javaProject != null) {
				project = javaProject.getProject();
			}
		}
		return project;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.jface.text.templates.TemplateVariableResolver#resolveAll(org.eclipse.jface.text.templates.TemplateContext)
	 */
	@Override
	protected String[] resolveAll(TemplateContext context) {
		return new String[0];
	}
}
