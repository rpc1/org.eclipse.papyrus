/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.papyrus.customization.Activator;
import org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement;
import org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement;
import org.eclipse.papyrus.customization.plugin.PluginEditor;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;
import org.w3c.dom.Element;


public abstract class FileBasedExtensionFactory implements ExtensionFactory {

	protected final String extensionPoint;

	protected final String fileAttributeName;

	protected final String fileElementName;

	protected final boolean allowMultiple;

	protected final String name;

	public FileBasedExtensionFactory(String name, String extensionPoint, String fileAttributeName, String fileElementName, boolean allowMultiple) {
		this.extensionPoint = extensionPoint;
		this.fileAttributeName = fileAttributeName;
		this.fileElementName = fileElementName;
		this.allowMultiple = allowMultiple;
		this.name = name;
	}

	public void addElement(CustomizableElement element, PluginEditor editor) {
		createExtension((FileBasedCustomizableElement) element, editor);
		try {
			copyFile((FileBasedCustomizableElement) element, editor);
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
	}

	protected Element createExtension(FileBasedCustomizableElement element, PluginEditor editor) {
		Element extensionElement = null;
		if (element instanceof FileBasedCustomizableElement) {
			Element extension = editor.getPluginEditor().addExtension(extensionPoint);
			extensionElement = editor.getPluginEditor().addChild(extension, fileElementName);
			editor.getPluginEditor().setAttribute(extensionElement, fileAttributeName, getTargetPath(element));
		}
		return extensionElement;
	}

	protected void copyFile(FileBasedCustomizableElement element, PluginEditor editor) throws FileNotFoundException, IOException {
		copyFile(element.getFile(), getTargetPath(element), editor);
	}

	protected void copyFile(String sourcePath, String targetPath, PluginEditor editor) throws FileNotFoundException, IOException {
		File sourceFile = FileUtil.getFile(sourcePath);
		File targetFile = FileUtil.getWorkspaceFile("/" + editor.getProject().getName() + "/" + targetPath); //$NON-NLS-1$ //$NON-NLS-2$

		if (sourceFile == null) {
			throw new IllegalArgumentException("The source path " + sourcePath + " is not valid");
		}

		if (targetFile == null) {
			throw new IllegalArgumentException("The target path " + targetPath + " is not valid");
		}

		if (!targetFile.getParentFile().exists()) {
			targetFile.getParentFile().mkdirs();
		}

		copy(new FileInputStream(sourceFile), targetFile);

		editor.getBuildEditor().addToBuild(targetPath);
	}

	protected String getTargetPath(FileBasedCustomizableElement element) {
		return "/" + getFileName(element); //$NON-NLS-1$
	}

	protected String getFileName(FileBasedCustomizableElement element) {
		return getFileName(element.getFile());
	}

	protected String getFileName(String path) {
		if (path == null) {
			throw new IllegalArgumentException("File path should not be null");
		}
		String fileName;
		path = path.replace("\\", "/");
		if (path.indexOf("/") < 0) { //$NON-NLS-1$
			fileName = path;
		} else {
			fileName = path.substring(path.lastIndexOf("/") + 1, path.length()); //$NON-NLS-1$
		}
		return fileName;
	}

	protected void copy(InputStream source, File target) throws IOException {
		if (!target.getParentFile().exists()) {
			target.getParentFile().mkdirs();
		}

		OutputStream out = new FileOutputStream(target);
		try {
			int c;

			while ((c = source.read()) != -1) {
				out.write(c);
			}

		} catch (IOException ex) {
			throw ex;
		} finally {
			source.close();
			out.close();
		}
	}

	public boolean isValidElement(CustomizableElement element) {
		return element instanceof FileBasedCustomizableElement;
	}

	public String getName() {
		return name;
	}

}
