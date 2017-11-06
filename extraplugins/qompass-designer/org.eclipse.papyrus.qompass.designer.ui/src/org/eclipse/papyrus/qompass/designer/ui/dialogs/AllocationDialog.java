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

package org.eclipse.papyrus.qompass.designer.ui.dialogs;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource;
import org.eclipse.papyrus.infra.widgets.toolbox.utils.DialogUtils;
import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.ElementFilter;
import org.eclipse.papyrus.qompass.designer.core.commands.AddMarteAndFcmProfile;
import org.eclipse.papyrus.qompass.designer.core.deployment.AllocUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.BootLoaderGen;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Allocate elements in a deployment plan to a node or thread
 *
 */
public class AllocationDialog extends SelectionStatusDialog {

	private DeploymentPlan m_cdp;

	private Tree fTree;

	private Label fLabel;

	private Combo fAlloc;

	private InstanceSpecification currentIS;

	private EList<InstanceSpecification> nodeOrThreadList;

	public AllocationDialog(Shell parent, Package cdp) {
		super(parent);
		m_cdp = UMLUtil.getStereotypeApplication(cdp, DeploymentPlan.class);
		nodeOrThreadList = new BasicEList<InstanceSpecification>();
		nodeOrThreadList.add(null); // dummy entry for no allocation
		DepUtils.getAllInstances(cdp.getModel(), nodeOrThreadList, new ElementFilter() {

			@Override
			public boolean acceptElement(Element element) {
				if (element instanceof InstanceSpecification) {
					InstanceSpecification instance = (InstanceSpecification) element;
					if (instance.getName() == null) {
						// donn't allocate to root element (detectable via the empty name)
						return false;
					}
					Classifier cl = DepUtils.getClassifier(instance);
					if (cl instanceof Class) {
						if (StereotypeUtil.isApplied(cl, SwSchedulableResource.class)) {
							// threads are valid allocation targets. Therefore, threads are always added to
							// list, even if within a deployment plan.
							return true;
						}
						if (StereotypeUtil.isApplied(instance.getNearestPackage(), DeploymentPlan.class)) {
							// instance is part of a deployment plan => don't add to list.
							return false;
						}
						return true;
					}
				}
				return false;
			}
		});
	}

	/**
	 * @see SelectionStatusDialog#computeResult()
	 */
	@Override
	protected void computeResult() {
		// nothing to do
	}

	@Override
	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		// (parent, "Container rules", "Avail. extensions/interceptors");

		fTree = new Tree(contents, SWT.H_SCROLL | SWT.BORDER);
		fTree.setHeaderVisible(true);
		GridData data = new GridData(GridData.FILL_BOTH);
		fTree.setLayoutData(data);
		data.heightHint = 150;
		// data.widthHint = 200;

		// Turn off drawing to avoid flicker
		fTree.setRedraw(false);

		TreeColumn instances = new TreeColumn(fTree, SWT.LEFT);
		instances.setText("Instance");
		instances.setWidth(200);
		TreeColumn explicitAlloc = new TreeColumn(fTree, SWT.LEFT);
		explicitAlloc.setText("explicit allocation");
		explicitAlloc.setWidth(150);
		TreeColumn implicitAlloc = new TreeColumn(fTree, SWT.LEFT);
		implicitAlloc.setText("implicit allocation");
		implicitAlloc.setWidth(150);

		fillTree(fTree, null, m_cdp.getMainInstance());

		// Turn drawing back on!
		fTree.setRedraw(true);

		fTree.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fTree.getSelection().length > 0) {
					selectInstance(fTree.getSelection()[0]);
				}
			}
		});

		Label label = new Label();
		label.setText("seletected instance:");
		fLabel = new Label();

		createAllocInfo(contents);
		return contents;
	}

	/**
	 * Helper method to fill a tree with data
	 *
	 * @param tree
	 *            the tree to fill
	 */
	private void fillTree(Tree tree, TreeItem treeItem, InstanceSpecification is) {
		TreeItem item;
		if (treeItem != null) {
			item = new TreeItem(treeItem, SWT.NONE);
		} else {
			item = new TreeItem(tree, SWT.NONE);
		}
		item.setData(is);
		setTextFromData(item);

		// create children
		for (InstanceSpecification subIS : DepUtils.getContainedNonSharedInstances(is)) {
			fillTree(tree, item, subIS);
		}
	}

	// obtain name and explicit/implicit node Allocation
	protected void setTextFromData(TreeItem ti) {
		Object data = ti.getData();
		if (data instanceof InstanceSpecification) {
			InstanceSpecification is = (InstanceSpecification) data;

			String name = is.getName();
			int index = name.lastIndexOf("."); //$NON-NLS-1$
			if (index != -1) {
				name = name.substring(index + 1);
			}
			InstanceSpecification explicitNodeOrThread = AllocUtils.getNodeOrThread(is);
			Classifier cl = DepUtils.getClassifier(is);
			String nodeName;
			if (explicitNodeOrThread == null) {
				nodeName = "-"; //$NON-NLS-1$
			} else {
				nodeName = getAllocName(explicitNodeOrThread);
			}
			if (cl instanceof Class) {
				if (BootLoaderGen.hasUnconnectedStartRoutine(null, (Class) cl, null)) {
					nodeName += " (main)"; //$NON-NLS-1$
				}
			}
			EList<InstanceSpecification> implicitNodes = AllocUtils.getAllNodesOrThreadsParent(is);
			implicitNodes.addAll(AllocUtils.getAllNodesOrThreadsParent(is));
			String list = ""; //$NON-NLS-1$
			for (InstanceSpecification node : implicitNodes) {
				if (list.equals("")) { //$NON-NLS-1$
					list = getAllocName(node);
				} else {
					list += ", " + getAllocName(node); //$NON-NLS-1$
				}
			}
			ti.setText(new String[] { name, nodeName, "[" + list + "]" }); //$NON-NLS-1$//$NON-NLS-2$
		}
	}

	protected void refreshTree(TreeItem ti) {
		setTextFromData(ti);
		for (TreeItem subItem : ti.getItems()) {
			refreshTree(subItem);
		}
	}

	private String getAllocName(InstanceSpecification nodeOrThread) {
		if (nodeOrThread == null) {
			return "no explicit allocation";
		} else {
			String name = nodeOrThread.getName();
			InstanceSpecification threadNode = AllocUtils.getNode(nodeOrThread);
			return name + (threadNode != null ? " on " + threadNode.getName() : "");
		}
	}

	protected void createAllocInfo(Composite parent) {
		// create extension kind combo
		fAlloc = DialogUtils.createComboWithText(parent, "Alloc to node:",
				SWT.DROP_DOWN | SWT.READ_ONLY, SWT.NONE);

		String items[] = new String[nodeOrThreadList.size()];
		int i = 0;
		for (InstanceSpecification nodeOrThread : nodeOrThreadList) {
			items[i++] = getAllocName(nodeOrThread);
		}
		fAlloc.setItems(items);
		fAlloc.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				if (currentIS != null) {
					updateAllocation(currentIS, fAlloc.getSelectionIndex());
					// selectionCount should always be 1
					for (TreeItem ti : fTree.getSelection()) {
						refreshTree(ti);
					}
				}
			}
		});

		fAlloc.setEnabled(false);
	}

	/**
	 * Select a rule, i.e. update the visual representation from the rule
	 *
	 * @param rule
	 */
	protected void selectInstance(TreeItem item) {
		// for (Port port : rule.getPortSet ()) {
		// fPorts.setSelection()
		// }
		currentIS = (InstanceSpecification) item.getData();
		fLabel.setText(currentIS.getName());

		fAlloc.setEnabled(true);
		InstanceSpecification nodeOrThread = AllocUtils.getNodeOrThread(currentIS);

		for (int i = 0; i < nodeOrThreadList.size(); i++) {
			if (nodeOrThreadList.get(i) == nodeOrThread) {
				fAlloc.select(i);
			}
		}
	}

	private void updateAllocation(InstanceSpecification is, int index) {
		InstanceSpecification oldNode = AllocUtils.getNodeOrThread(is);
		InstanceSpecification newNode = nodeOrThreadList.get(index);

		if (oldNode == newNode) {
			return;
		}

		// add or update
		if (oldNode == null) {
			if (!AllocUtils.allocate(is, newNode)) {
				if (MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Error",
						"Stereotype application failed. The profile MARTE::Allocation is probably not applied. Try to apply it?")) {
					AbstractEMFOperation applyProfile = new AddMarteAndFcmProfile(PackageUtil.getRootPackage(is), AddMarteAndFcmProfile.APPLY_ALLOC, TransactionUtil.getEditingDomain(is));
					CommandSupport.exec(applyProfile);
					AllocUtils.allocate(is, newNode);
				}
			}
		} else {
			AllocUtils.updateAllocation(is, oldNode, newNode);
		}
	}
}
