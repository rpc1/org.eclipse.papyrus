/*******************************************************************************
 * Copyright (c) 2006 - 2007 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.views.panels;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.papyrus.C_Cpp.Const;
import org.eclipse.papyrus.C_Cpp.ConstInit;
import org.eclipse.papyrus.C_Cpp.Friend;
import org.eclipse.papyrus.C_Cpp.Inline;
import org.eclipse.papyrus.C_Cpp.Virtual;
import org.eclipse.papyrus.cpp.profile.StdStereo;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.views.cpp.CommandSupport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * Panel displayed when an Operation is selected
 *
 * TODO: instead of keeping isAbstract and pureVirtual Stereotype synchronized, pure virtual
 * could be removed from the panel
 * @deprecated This view will be replaced by a XWT view for the C++ profile
 */
@Deprecated
public class CppOperationPanel extends CppAbstractPanel {

	@SuppressWarnings("unused")
	private ISourceViewer viewerBody;

	@SuppressWarnings("unused")
	private ISourceViewer viewerConstInit;

	private Group groupBody;

	private Group groupCInit;

	// document used by the viewer
	private IDocument docBody;

	private IDocument docConstInit;

	private Button isStatic;

	private Button isInline;

	private Button isConst;

	private Button isFriend;

	private Button isCreate;

	private Button isDestroy;

	private Combo vPropCombo;

	private Operation selectedOperation;

	Element selectedEOwner;

	protected String origBody;
	
	public CppOperationPanel(Composite parent, int style) {
		super(parent, style);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#getSelectedElement()
	 */
	@Override
	public Operation getSelectedElement() {
		return selectedOperation;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#setSelectedElement(java.lang.Element)
	 */
	@Override
	public void setSelectedElement(Element newElement) {
		super.setSelectedElement(newElement);
		if (newElement instanceof Operation) {
			this.selectedOperation = (Operation) newElement;
			// Retrieve the owner
			this.selectedEOwner = selectedOperation.getOwner();
		}
		else {
			throw new RuntimeException("bad selection: " + newElement + " should be an uml2 Operation");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#createContent()
	 */
	@Override
	public Control createContent()
	{
		// /////////////////////////////////////////////////////////////////////
		// Create checkboxes
		// /////////////////////////////////////////////////////////////////////
		isStatic = createButton("isStatic", this, null);
		isInline = createButton("isInline", this, isStatic);
		isConst = createButton("isConst", this, isInline);
		isFriend = createButton("isFriend", this, isConst);
		isCreate = createButton("isCreate", this, isFriend);
		isDestroy = createButton("isDestroy", this, isCreate);

		// /////////////////////////////////////////////////////////////////////
		// Add checkboxes listeners
		// /////////////////////////////////////////////////////////////////////
		isStatic.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CommandSupport.exec("C++ operation save", new Runnable() {

					@Override
					public void run() {
						updateModel();
					}
				});
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		addStereotypeSelectionListener(isInline, "Inline");
		addStereotypeSelectionListener(isConst, "Const");
		addStereotypeSelectionListener(isFriend, "Friend");
		addStereotypeSelectionListener(isCreate, "Create");
		addStereotypeSelectionListener(isDestroy, "Destroy");

		// /////////////////////////////////////////////////////////////////////
		// Virtual properties combo box
		// /////////////////////////////////////////////////////////////////////
		vPropCombo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		String items[] = { "not virtual", "virtual", "pure virtual" };
		vPropCombo.setItems(items);
		vPropCombo.setText("Virtual operation qualifiers");
		vPropCombo.addSelectionListener(
				new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent event) {
						checkVirtual();
						reset();
					}
				});

		FormData data = new FormData();
		data.left = new FormAttachment(isDestroy, H_SPACE);
		data.top = new FormAttachment(0, H_SPACE);
		vPropCombo.setLayoutData(data);

		// /////////////////////////////////////////////////////////////////////
		// Create save reset buttons with superclass method
		// /////////////////////////////////////////////////////////////////////
		createSaveResetButtons();

		// /////////////////////////////////////////////////////////////////////
		// Constructor init list
		// /////////////////////////////////////////////////////////////////////
		docConstInit = createDocument();
		groupCInit = createGroup(
				this
				, "Constructor initialisation list"
				, isStatic
				, null
				, true
				, 0
				, 0
				, false);

		// Use CDT CEditor coloration
		viewerConstInit = createViewer(docConstInit, groupCInit);

		// /////////////////////////////////////////////////////////////////////
		// Body
		// /////////////////////////////////////////////////////////////////////

		docBody = createDocumentC();
		groupBody = createGroup(
				this
				, "Method body"
				, groupCInit
				, null
				, true
				, 0
				, 0
				, true);
		// Use CDT CEditor coloration
		viewerBody = createViewerC(docBody, groupBody);

		// /////////////////////////////////////////////////////////////////////

		return this;
	}



	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accordcpp.core.ui.panels.AccordCppAbstractPanel#save()
	 */
	@Override
	public void save()
	{
		if (selectedOperation == null) {
			/* Log.debug("saveBody : selectedOperation is null"); */
		} else {
			CommandSupport.exec("C++ operation save", new Runnable() {

				@Override
				public void run() {
					String newConstInit = docConstInit.get();
					if (newConstInit.equals("")) { //$NON-NLS-1$
						StereotypeUtil.unapply(selectedOperation, ConstInit.class);
					} else {
						ConstInit cppConstInit =
								StereotypeUtil.applyApp(selectedOperation, ConstInit.class);
						cppConstInit.setInitialisation(newConstInit);
					}

					// Body
					setCppBody(selectedOperation, docBody.get());
					origBody = docBody.get();
				}
			});
		}

	}

	public static String getCppBody(Operation operation)
	{
		// get the body of the operation
		for (Behavior behavior : operation.getMethods()) {
			if (behavior instanceof OpaqueBehavior) {
				OpaqueBehavior ob = (OpaqueBehavior) behavior;
				int i = 0;
				for (String language : ob.getLanguages()) {
					if (language.equals(C_CPP_ID)) {
						return ob.getBodies().get(i);
					}
					else if (language.equals(CPP_ID)) {
						return ob.getBodies().get(i);
					}
					else if (language.equals(C_ID)) {
						return ob.getBodies().get(i);
					}
					i++;
				}
			}
		}
		return ""; //$NON-NLS-1$
	}

	public static void setCppBody(Operation operation, String body)
	{
		boolean done = false;
		for (Behavior behavior : operation.getMethods()) {
			if (behavior instanceof OpaqueBehavior) {
				OpaqueBehavior ob = (OpaqueBehavior) behavior;
				int i = 0;
				for (String language : ob.getLanguages()) {
					if (language.equals(C_CPP_ID) || language.equals(CPP_ID) || language.equals(C_ID)) {
						done = true;
						ob.getBodies().set(i, body);
						break;
					}
					i++;
				}
			}
			if (done) {
				break;
			}
		}
		if (!done) {
			OpaqueBehavior ob = (OpaqueBehavior)
					operation.getClass_().createOwnedBehavior(operation.getName(), UMLPackage.eINSTANCE.getOpaqueBehavior());
			ob.getLanguages().add(C_CPP_ID);
			ob.getBodies().add(body);
			ob.setSpecification(operation);
		}

	}

	/**
	 * Called when the static checkbox is modified
	 */
	protected void checkStatic()
	{
		boolean boxState = isStatic.getSelection();

		selectedOperation.setIsStatic(boxState);
	}

	/**
	 * Called when the inline checkbox is modified
	 */
	protected void checkInline() {
		// get the text in the activity
		boolean boxState = isInline.getSelection();

		if (boxState != StereotypeUtil.isApplied(selectedOperation, Inline.class)) {
			if (boxState) {
				StereotypeUtil.apply(selectedOperation, Inline.class);
			}
			else {
				StereotypeUtil.unapply(selectedOperation, Inline.class);
			}
		}
	}

	/**
	 * Called when the const checkbox is modified
	 */
	protected void checkConst() {

		boolean boxState = isConst.getSelection();

		if (boxState != StereotypeUtil.isApplied(selectedOperation, Const.class)) {
			if (boxState) {
				StereotypeUtil.apply(selectedOperation, Const.class);
			}
			else {
				StereotypeUtil.unapply(selectedOperation, Const.class);
			}
		}
	}

	/**
	 * Called when the friend checkbox is modified
	 */
	protected void checkFriend() {

		boolean boxState = isFriend.getSelection();

		if (boxState != StereotypeUtil.isApplied(selectedOperation, Friend.class)) {
			if (boxState) {
				StereotypeUtil.apply(selectedOperation, Friend.class);
			}
			else {
				StereotypeUtil.unapply(selectedOperation, Friend.class);
			}
		}
	}

	/**
	 * Called when the create checkbox is modified
	 */
	protected void checkCreate() {
		// get the text in the activity
		boolean boxState = isCreate.getSelection();

		if (boxState) {
			StereotypeUtil.apply(selectedOperation, StdStereo.create);
		}
		else {
			StereotypeUtil.unapply(selectedOperation, ConstInit.class);
			StereotypeUtil.unapply(selectedOperation, StdStereo.create);
		}

		groupCInit.setEnabled(boxState);
	}

	/**
	 * Called when the destroy checkbox is modified
	 */
	protected void checkDestroy() {
		// get the text in the activity
		boolean boxState = isDestroy.getSelection();

		if (boxState) {
			StereotypeUtil.apply(selectedOperation, StdStereo.destroy);
		}
		else {
			StereotypeUtil.unapply(selectedOperation, StdStereo.destroy);
		}
	}

	/**
	 * Called when the virtual qualifier is modified
	 */
	protected void checkVirtual() {

		// Treat the operation
		int comboSelected = 2;

		// If owner is a class
		if (selectedEOwner instanceof org.eclipse.uml2.uml.Class) {
			comboSelected = vPropCombo.getSelectionIndex();
		} else {
			// Assume this is an interface
			comboSelected = 2;
		}

		if (comboSelected == 0 /* not virtual */) {

			selectedOperation.setIsAbstract(false);
			StereotypeUtil.unapply(selectedOperation, Virtual.class);
		}
		else if (comboSelected == 1 /* virtual */) {

			selectedOperation.setIsAbstract(false);
			StereotypeUtil.apply(selectedOperation, Virtual.class);
		}
		else if (comboSelected == 2 /* pure virtual */) {

			selectedOperation.setIsAbstract(true);
			StereotypeUtil.apply(selectedOperation, Virtual.class);
		}

		// Treat the owner class
		if (selectedEOwner instanceof Class) {
			Class ownerCl = (Class) selectedEOwner;

			ownerCl.setIsAbstract(ownerCl.isAbstract());
		} // else nothing
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#entryAction()
	 */
	@Override
	public void entryAction() {
		super.entryAction();
		reset();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cea.accorduml.ui.views.panels.AccordUMLAbstractPanel#exitAction()
	 */
	@Override
	public void exitAction() {
		// do exit action, only if the owner is a class
		if (selectedEOwner instanceof Class) {
			super.exitAction();
		}
	}

	@Override
	public boolean checkModifications() {
		// check if ConstInit has changed
		String valueConstInit = ""; //$NON-NLS-1$
		ConstInit constInit = UMLUtil.getStereotypeApplication(selectedOperation, ConstInit.class);
		if (constInit != null) {
			valueConstInit = constInit.getInitialisation();
		}
		if (!docConstInit.get().equals(valueConstInit)) {
			return true;
		}

		// String methodBody = getCppBody(selectedOperation);
		if (!(docBody.get().equals(origBody))) {
			return true;
		}

		return false;
	}

	@Override
	protected void refreshPanel() {
		if (selectedOperation == null) {
			/* Log.debug("resetBody : selectedOperation is null"); */
		} else {

			// get the text in the activity if parent is a class
			if (selectedEOwner instanceof Class) {

				// This part is done for a class only
				ConstInit constInit = UMLUtil.getStereotypeApplication(selectedOperation, ConstInit.class);
				if (constInit != null) {
					docConstInit.set(constInit.getInitialisation());
				}

				// Don't show this unless the operation is a constructor
				if (isCreate.getSelection()) {
					groupCInit.setEnabled(true);
				} else {
					docConstInit.set(""); //$NON-NLS-1$
					groupCInit.setEnabled(false);
				}

				String body = getCppBody(selectedOperation);
				origBody = body;
				docBody.set(body);

				// Combo Box
				if (selectedOperation.isAbstract()) {
					vPropCombo.select(2);
					// Nothing in body and body unavailable
					docBody.set(""); //$NON-NLS-1$
					groupBody.setEnabled(false);
				}
				else {
					if (StereotypeUtil.isApplied(selectedOperation, Virtual.class)) {
						vPropCombo.select(1);
						groupBody.setEnabled(true);
					}
					else {
						vPropCombo.select(0);
						groupBody.setEnabled(true);
					}
				}

				// Inline
				if (StereotypeUtil.isApplied(selectedOperation, Inline.class)) {
					isInline.setSelection(true);
				}

			}
			else {
				// Don't show text areas nor buttons
				groupBody.setVisible(false);
				buttonSave.setVisible(false);
				buttonCancel.setVisible(false);

				// Methods are virtual pure
				vPropCombo.select(2);
				vPropCombo.setEnabled(false);

				// Inline not visible
				isInline.setVisible(false);
			}

			isStatic.setSelection(selectedOperation.isStatic());
			isConst.setSelection(StereotypeUtil.isApplied(selectedOperation, Const.class));
			isFriend.setSelection(StereotypeUtil.isApplied(selectedOperation, Friend.class));
			isCreate.setSelection(StereotypeUtil.isApplied(selectedOperation, StdStereo.create));
			isDestroy.setSelection(StereotypeUtil.isApplied(selectedOperation, StdStereo.destroy));
		}
	}

	@Override
	protected boolean isModelValid() {
		if (selectedOperation == null) {
			return true;
		}
		if (selectedEOwner instanceof Class) {

			if (selectedOperation.isAbstract()) {
				if (!StereotypeUtil.isApplied(selectedOperation, Virtual.class)) {
					return false;
				}
			}
		} else {
			// owner is interface
			if (!selectedOperation.isAbstract()) {
				return false;
			}
			if (StereotypeUtil.isApplied(selectedOperation, Virtual.class)) {
				return false;
			}
		}
		return true;

	}

	@Override
	protected void updateModel()
	{
		CommandSupport.exec("C++ operation save", new Runnable() {

			@Override
			public void run()
			{
				// Check button changes
				checkStatic();
				checkConst();
				checkCreate();
				checkDestroy();
				checkInline();
				checkFriend();

				if (selectedOperation == null) {
					return;
				}
				if (selectedEOwner instanceof Class) {
					// toggle Stereotypes pure virtual if element is abstract
					if (selectedOperation.isAbstract()) {
						if (!StereotypeUtil.isApplied(selectedOperation, Virtual.class)) {
							// selectedOperation.toggleStereotype("VirtualPure", true);
							// selectedOperation.toggleStereotype("Virtual", false);
						} else {
							// selectedOperation.toggleStereotype("Virtual", false);
						}
					}

					// if element is abstract and has VirtualPure, set to Virtual only
					if (!selectedOperation.isAbstract()) {
						if (StereotypeUtil.isApplied(selectedOperation, Virtual.class)) {
							// selectedOperation.toggleStereotype("VirtualPure", false);
							// selectedOperation.toggleStereotype("Virtual", true);
						} else {
							// selectedOperation.toggleStereotype("VirtualPure", false);
							// selectedOperation.toggleStereotype("Virtual", false);
						}
					}
				}
				else {
					selectedOperation.setIsAbstract(true);
					// selectedOperation.toggleStereotype("Virtual", false);
					// selectedOperation.toggleStereotype("VirtualPure", true);
				}
			}
		});
	}
}
