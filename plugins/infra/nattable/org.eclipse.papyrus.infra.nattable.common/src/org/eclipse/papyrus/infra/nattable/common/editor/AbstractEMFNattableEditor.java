/*****************************************************************************
 * Copyright (c) 2009, 2014 CEA LIST, LIFL, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *  Christian W. Damus (CEA) - bug 430880
 *  Christian W. Damus (CEA) - bug 437217
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.common.editor;


import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.core.editor.reload.IReloadContextProvider;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.nattable.selection.EObjectSelectionExtractor;
import org.eclipse.papyrus.infra.nattable.common.Activator;
import org.eclipse.papyrus.infra.nattable.common.utils.TableEditorInput;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.utils.NattableModelManagerFactory;
import org.eclipse.papyrus.infra.nattable.utils.TableEditingDomainUtils;
import org.eclipse.papyrus.infra.widgets.util.NavigationTarget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;


/**
 * Abstract class for TableEditor
 *
 *
 *
 */
public abstract class AbstractEMFNattableEditor extends EditorPart implements NavigationTarget {

	/** the service registry */
	protected ServicesRegistry servicesRegistry;

	/**
	 * the table manager
	 */
	protected INattableModelManager tableManager;

	/**
	 * the part name synchronizer
	 */
	private PartNameSynchronizer synchronizer;

	/**
	 * the workspace preference store for this table editor
	 */
	@SuppressWarnings("unused")
	// not yet used in the table
	private PreferenceStore workspacePreferenceStore;

	/**
	 * @param servicesRegistry
	 * @param rawModel
	 *
	 */
	public AbstractEMFNattableEditor(final ServicesRegistry servicesRegistry, final Table rawModel) {
		this.servicesRegistry = servicesRegistry;
		this.tableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(rawModel, new EObjectSelectionExtractor());
		this.synchronizer = new PartNameSynchronizer(rawModel);
		this.workspacePreferenceStore = getWorkspaceViewerPreferenceStore();
	}

	/**
	 * Returns the workspace viewer <code>PreferenceStore</code>
	 *
	 * @return the workspace viewer <code>PreferenceStore</code>
	 */
	public PreferenceStore getWorkspaceViewerPreferenceStore() {
		// not yet used by tables
		return null;

		// if(this.workspacePreferenceStore != null) {
		// return this.workspacePreferenceStore;
		// } else {
		// // Try to load it
		// IPath path = Activator.getDefault().getStateLocation();
		// String id = getIdStr(this.tableManager.getTable());
		//
		//			String fileName = path.toString() + "/" + id;//$NON-NLS-1$
		// java.io.File file = new File(fileName);
		// this.workspacePreferenceStore = new PreferenceStore(fileName);
		// if(file.exists()) {
		// // Load it
		// try {
		// this.workspacePreferenceStore.load();
		// } catch (Exception e) {
		// // Create the default
		// addDefaultPreferences();
		// }
		// } else {
		// // Create it
		// addDefaultPreferences();
		// }
		// return this.workspacePreferenceStore;
		// }
	}

	// /**
	// * returns the unique GUID of the view
	// *
	// * @param view
	// * the view
	// * @return String the GUID of a view (constant)
	// */
	// private static String getIdStr(Table table) {
	// Resource resource = table.eResource();
	// if(resource instanceof XMLResource) {
	// String id = ((XMLResource)resource).getID(table);
	// if(id != null) {
	// return id;
	// }
	// }
	//
	// // Remain compatible with previous behavior.
	// return StringStatics.BLANK;
	// }

	// not used : add a workspace preference to the table
	// private void addDefaultPreferences() {
	// final IPreferenceStore globalPreferenceStore = Activator.getDefault().getPreferenceStore();
	// String tableKind = this.tableManager.getTable().getTableConfiguration().getType();
	// }

	/**
	 *
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 *
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		final TableEditorInput tableEditorInput = new TableEditorInput(this.tableManager.getTable(), getEditingDomain());
		setSite(site);
		setInput(tableEditorInput);
		setPartName(this.tableManager.getTable().getName());
	}

	/**
	 *
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#getEditingDomain()
	 *
	 * @return
	 */
	public TransactionalEditingDomain getEditingDomain() {
		try {
			return ServiceUtils.getInstance().getTransactionalEditingDomain(this.servicesRegistry);
		} catch (final ServiceException e) {
			Activator.log.error(e);
		}
		return null;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		// nothing to do
	}

	@Override
	public void doSaveAs() {
		// nothing to do

	}

	@Override
	public boolean isDirty() {
		// nothing to do
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// nothing to do
		return false;
	}

	@Override
	public void setFocus() {
		// nothing to do
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.tableManager.createNattable(parent, SWT.NONE, getSite());
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") final Class adapter) {
		if (adapter == INattableModelManager.class) {
			return this.tableManager;
		}

		// Give direct access to the Table model element
		// Most actions should be done through the TableManager.
		// Be careful when using directly the Table element.
		if (adapter == Table.class) {
			if (tableManager != null) {
				return this.tableManager.getTable();
			}
		}

		if (adapter == IReloadContextProvider.class) {
			return new NattableReloadContextProvider(this);
		}

		return super.getAdapter(adapter);
	}

	/**
	 * this method is used dispose the existing nattable widget and recreate a new one.
	 * It has been created to be able to reload a table when a bug broke the table after a user action.
	 * 
	 * see bug 466447: [TreeTable] Missing method to reload a (hierarchic) table
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=466447
	 */
	public void reloadNattableModelManager() {
		Table rawModel = this.tableManager.getTable();
		// we dispose the previous nattable widget
		NatTable nattable = this.tableManager.getAdapter(NatTable.class);
		Composite parent = nattable.getParent();
		this.tableManager.dispose();
		this.tableManager = NattableModelManagerFactory.INSTANCE.createNatTableModelManager(rawModel, new EObjectSelectionExtractor());
		nattable = this.tableManager.createNattable(parent, SWT.NONE, getSite());
		nattable.getParent().layout();
	}

	@Override
	public void dispose() {
		saveLocalPreferenceStoreValues();
		this.tableManager.dispose();
		this.synchronizer.dispose();
		this.tableManager= null;
		this.servicesRegistry = null;
		this.synchronizer = null;
		super.dispose();
	}

	protected void saveLocalPreferenceStoreValues() {
		// Write the settings, if necessary
		try {
			if (getWorkspaceViewerPreferenceStore() != null && getWorkspaceViewerPreferenceStore().needsSaving()) {
				getWorkspaceViewerPreferenceStore().save();
			}
		} catch (IOException ioe) {
			Activator.log.warn("Preferences can' be saved"); //$NON-NLS-1$
		}
	}

	/**
	 * A class taking in charge the synchronization of the partName and the table name.
	 * When table name change, the other is automatically updated.
	 *
	 *
	 */
	public class PartNameSynchronizer {

		/** the papyrus table */
		private Table papyrusTable;

		/**
		 * Listener on diagram name change.
		 */
		private final Adapter tableNameListener = new AdapterImpl() {

			/**
			 *
			 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 *
			 * @param notification
			 */
			@Override
			public void notifyChanged(final Notification notification) {
				if (notification.getFeature() == NattableconfigurationPackage.eINSTANCE.getTableNamedElement_Name()) {
					setPartName(PartNameSynchronizer.this.papyrusTable.getName());
				}
			}
		};

		/**
		 *
		 * Constructor.
		 *
		 * @param diagram
		 */
		public PartNameSynchronizer(final Table papyrusTable) {
			setTable(papyrusTable);
		}

		public void dispose() {
			this.papyrusTable.eAdapters().remove(this.tableNameListener);
			this.papyrusTable = null;
		}

		/**
		 * Change the associated diagram.
		 *
		 * @param papyrusTable
		 */
		public void setTable(final Table papyrusTable) {
			// Remove from old table, if any
			if (this.papyrusTable != null) {
				papyrusTable.eAdapters().remove(this.tableNameListener);
			}
			// Set new table
			this.papyrusTable = papyrusTable;
			// Set editor name
			setPartName(papyrusTable.getName());
			// Listen to name change
			papyrusTable.eAdapters().add(this.tableNameListener);
		}
	}


	/**
	 *
	 * used to link the selection between the model explorer and the table
	 *
	 * @param element
	 */
	@Override
	public boolean revealElement(Object element) {
		return revealElement(Collections.singleton(element));
	}

	/**
	 *
	 * used to link the selection between the model explorer and the table
	 *
	 * @param elements
	 */
	@Override
	public boolean revealElement(Collection<?> elements) {
		if (tableManager instanceof NavigationTarget) {
			return ((NavigationTarget) tableManager).revealElement(elements);
		}
		return false;
	}

	/**
	 * 
	 * @return
	 * 		the table model displayed by the editor
	 */
	public Table getTable() {
		return tableManager.getTable();
	}

	/**
	 * 
	 * @return
	 * 		the table editing domain
	 */
	public TransactionalEditingDomain getTableEditingDomain() {
		return TableEditingDomainUtils.getTableEditingDomain(getTable());
	}

	/**
	 * 
	 * @return
	 * 		the table context editing domain
	 */
	public TransactionalEditingDomain getTableContextEditingDomain() {
		return TableEditingDomainUtils.getTableContextEditingDomain(getTable());
	}
}
