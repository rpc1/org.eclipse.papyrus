package org.eclipse.papyrus.migration.rsa.utils;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.migration.rsa.Activator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class CreateProject {

	protected String projectName;

	protected IProject createdProject;

	protected Collection<Object> inputFiles;

	public CreateProject(Collection<Object> inputFiles) {
		this.projectName = getProjectName();
		this.inputFiles = inputFiles;

		if (projectName != null) {
			try {
				this.createdProject = createProject();
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}
	}


	protected IProject createProject() throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject project = workspace.getRoot().getProject(projectName);

		if (! project.exists()){
			project.create(new NullProgressMonitor());
		}

		if (! project.isOpen()){
			project.open(new NullProgressMonitor());
		}

		if (inputFiles != null && !inputFiles.isEmpty()) {
			// create resource folder
			createFolder("resources", project, inputFiles);
		}

		return project;
	}

	protected void createFolder(String folderName, IProject project, Collection<Object> inputFiles) throws Exception {
		IFolder folder = project.getFolder(folderName);
		folder.create(false, true, null);

		List<Object> inputList = new ArrayList<Object>(inputFiles);
		for (Object object : inputList) {
			File file = ((File) object);
			IFile linkedFile = folder.getFile(file.getName());
			URI fileURI = file.toURI();
			linkedFile.createLink(fileURI, IResource.NONE, null);
		}

	}

	protected void createBuildProps(IProject project, List<String> srcFolders) throws Exception {
		StringBuilder bpContent = new StringBuilder("source.. = ");

		if (srcFolders != null && !srcFolders.isEmpty()) {
			for (Iterator<String> iterator = srcFolders.iterator(); iterator.hasNext();)
			{
				bpContent.append(iterator.next()).append(File.separatorChar);
				if (iterator.hasNext()) {
					bpContent.append(",");
				}
			}
		}

		bpContent.append("\n");
		bpContent.append("bin.includes = META-INF/,.\n");
		CreateFile.createFile("build.properties", project, bpContent.toString());
	}


	public IProject getCreatedProject() {
		return this.createdProject;
	}

	protected String getProjectName() {
		String init_value = "project_" + System.currentTimeMillis();

		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		InputDialog dialog = new InputDialog(activeShell, "Create Project", "Provide project name...", init_value, new IInputValidator() {
			@Override
			public String isValid(String newText)
			{
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IProject[] projs = root.getProjects();
				for (int i = 0; i < projs.length; i++) {
					if (projs[i].getName().equalsIgnoreCase(newText)) {
						return "This project already exists";
					}
				}

				return null;
			}
		});

		if (dialog.open() == Window.CANCEL) {
			return null;
		}

		return dialog.getValue();
	}

}
