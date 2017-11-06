package org.eclipse.papyrus.cpp.cdtproject;

import org.eclipse.cdt.ui.wizards.CProjectWizard;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Variant of CProjectWizard that allows for setting an initial
 * project name. It creates the pages and sets the initial name.
 * It does not use the standard CDTMainWizardPage but a variant
 * called CDTMainWizardPageV that skips the first validation which
 * would other trigger an error.
 *
 * @see org.eclipse.papyrus.cpp.cdtproject.CDTMainWizardPageV
 */
public class CNamedProjectWizard extends CProjectWizard {

	public CNamedProjectWizard(String projectName) {
		this.projectName = projectName;
		dontAdd = false;
	}

	@Override
	public void addPages() {
		dontAdd = true;
		// avoid that page is actually added, since we want to add our page below
		super.addPages();
		dontAdd = false;
		String title = fMainPage.getTitle();
		String desc = fMainPage.getDescription();
		fMainPage = new CDTMainWizardPageV(fMainPage.getName());
		fMainPage.setTitle(title);
		fMainPage.setDescription(desc);
		fMainPage.setInitialProjectName(projectName);
		addPage(fMainPage);
	}

	@Override
	public void addPage(IWizardPage page) {
		if (!dontAdd) {
			super.addPage(page);
		}
	}

	private String projectName;

	private boolean dontAdd;
}
