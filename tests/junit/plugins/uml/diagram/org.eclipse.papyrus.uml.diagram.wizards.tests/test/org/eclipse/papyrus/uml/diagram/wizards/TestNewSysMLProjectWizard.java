package org.eclipse.papyrus.uml.diagram.wizards;

import static org.junit.Assert.assertEquals;

import org.eclipse.papyrus.sysml.diagram.common.commands.CreateSysMLModelCommand;
import org.eclipse.papyrus.sysml.diagram.ui.NewSysMLProjectWizard;
import org.eclipse.papyrus.uml.diagram.wizards.pages.PapyrusProjectCreationPage;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramKindPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.junit.Test;



public class TestNewSysMLProjectWizard extends TestNewModelWizardBase {


	@Override
	protected IWorkbenchWizard createWizard() {
		return new NewSysMLProjectWizard();
	}

	@Test
	public void testOrderOfPages() {

		// actual pages: [PapyrusNewProjectPage -> PapyrusProjectCreationPage, SelectDiagramKind -> SelectDiagramKindPage]
		Class<?>[] expectedPages = new Class[] { PapyrusProjectCreationPage.class, SelectDiagramKindPage.class };

		IWorkbenchWizard wizard = initWizardDialog();
		testOrderOfPages(wizard, expectedPages);
	}


	@Test
	public void testDiagramCategory() {
		class NewSysMLProjectWizardWithPublicAccess extends NewSysMLProjectWizard {

			// open access to protected method
			@Override
			public String[] getDiagramCategoryIds() {
				return new String[] { CreateSysMLModelCommand.COMMAND_ID };
			}
		}

		NewSysMLProjectWizardWithPublicAccess wizard = new NewSysMLProjectWizardWithPublicAccess();
		initWizardDialog(wizard);
		String actualCategory = wizard.getDiagramCategoryIds()[0];
		assertEquals(CreateSysMLModelCommand.COMMAND_ID, actualCategory);
	}

}
