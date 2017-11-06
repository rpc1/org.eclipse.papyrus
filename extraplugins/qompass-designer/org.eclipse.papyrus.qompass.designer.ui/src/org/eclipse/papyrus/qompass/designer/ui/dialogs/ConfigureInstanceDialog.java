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

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.util.FCMUtil;
import org.eclipse.papyrus.infra.widgets.toolbox.utils.DialogUtils;
import org.eclipse.papyrus.qompass.designer.core.ConfigUtils;
import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.ElementFilter;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepCreation;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepPlanUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.sync.DepPlanSync;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Select container rules, either from a list of globally defined rules or from
 * local rules which may be created "on the fly" by this dialog.
 *
 * TODO: extend rule application to instances (problematic, since rules
 * transformation is done on type level)
 */
public class ConfigureInstanceDialog extends SelectionStatusDialog {

	protected Class m_component;

	protected Label fDescriptionLabel;

	protected Text fDescription;

	protected TreeViewer fInstanceList;

	protected TableViewer fPropertyList;

	protected Property m_currentAttribute;

	protected final String valueLabelPrefix = "Value:"; //$NON-NLS-1$

	protected Label fValueLabel;

	protected Text fValue;

	protected Combo fComboValue;

	protected Package m_model;

	protected Feature m_feature;

	protected EList<Package> visitedPackages;

	protected boolean m_rulePropertiesOnly;

	protected InstanceSpecification m_instance;

	EList<InstanceSpecification> m_instanceList;

	public ConfigureInstanceDialog(Shell parent) {
		super(parent);
	}

	public boolean init(Class component, ExecutionEvent from) {
		// visitedPackages = new BasicEList<Package> ();
		DepPlanSync.syncAllDepPlans(component);
		m_component = component;
		m_instance = null;
		m_feature = null;
		m_model = PackageUtil.getUserModel(from);
		if (m_model == null) {
			return false;
		}
		return checkAndGetInstances();
	}

	public boolean init(InstanceSpecification instance, ExecutionEvent from) {
		// visitedPackages = new BasicEList<Package> ();
		DepPlanSync.syncDepPlan(instance.getNearestPackage());
		m_component = DepUtils.getImplementation(instance);
		m_instance = instance;
		m_feature = null;
		m_model = PackageUtil.getUserModel(from);
		return checkAndGetInstances();
	}

	public boolean init(Feature feature, ExecutionEvent from) {
		// visitedPackages = new BasicEList<Package> ();
		m_feature = feature;
		m_model = PackageUtil.getUserModel(from);
		if (m_model == null) {
			m_model = PackageUtil.getRootPackage(feature);
		}
		m_instance = null;
		if (feature instanceof Connector) {
			org.eclipse.papyrus.FCM.Connector fcmConn = UMLUtil.getStereotypeApplication(feature,
					org.eclipse.papyrus.FCM.Connector.class);
			if ((fcmConn != null) && (fcmConn.getIc() != null)) {
				m_component = fcmConn.getIc().getBase_Class();
				return checkAndGetInstances();
			}
		} else if (feature instanceof Property) {
			Type type = ((Property) feature).getType();
			if (type instanceof Class) {
				m_component = (Class) type;
				return checkAndGetInstances();
			}
		}
		return false;
	}

	/**
	 * A filter class that selects instances associated with the selected feature or component
	 */
	class InstanceFilter implements ElementFilter {

		private String featureCandidateName;

		@Override
		public boolean acceptElement(Element element) {
			if (element instanceof InstanceSpecification) {
				InstanceSpecification instance = (InstanceSpecification) element;
				if (m_feature instanceof Property) {
					EList<Slot> slots = DepUtils.getReferencingSlots(instance);
					for (Slot slot : slots) {
						if (slot.getDefiningFeature() == m_feature) {
							return true;
						}
					}
				}
				else if (m_feature instanceof Connector) {
					// Connector instances cannot be found via a slot. Since a connector is not a structural feature,
					// it cannot be referenced via the "definingFeature" property of a slot. Therefore, the deployment
					// plan creation (@see DepCreation.createDepPlan) simply omits slots, but still creates instances
					// for the interaction components referenced by an FCM connector.
					// TODO: the following code relies on specific order of instances and might not always work.
					Element owner = m_feature.getOwner();
					if (DepUtils.getImplementation(instance) == owner) {
						// instance is for owner of feature: examine name
						featureCandidateName = instance.getName() + "." + m_feature.getName(); //$NON-NLS-1$
					}
					else if (featureCandidateName != null) {
						if (featureCandidateName.equals(instance.getName())) {
							return true;
						}
					}
				} else if (DepUtils.getImplementation(instance) == m_component) {
					return true;
				}
			}
			return false;
		}
	}


	/**
	 * retrieve the instance list. Returns false, if no deployment plan could be found.
	 *
	 * @return
	 */
	public boolean checkAndGetInstances() {
		visitedPackages = new BasicEList<Package>();
		m_instanceList = new BasicEList<InstanceSpecification>();

		ElementFilter filter = new InstanceFilter();
		DepUtils.getAllInstances(m_model, m_instanceList, filter);

		if (m_instanceList.size() == 0) {
			Shell shell = Display.getDefault().getActiveShell();
			if (DepPlanUtils.getAllDepPlans(m_model).size() == 0) {
				MessageDialog.openInformation(shell, "Instance configuration",
						"No deployment plans are defined. Create a deployment plan before configuring instances");
				return false;
			}
			else if (MessageDialog.openConfirm(shell, "Instance configuration",
					"The list of available instances is empty. Synchronize deployment plans?")) {
				DepPlanSync.syncAllDepPlans(m_model);
				visitedPackages = new BasicEList<Package>();
				DepUtils.getAllInstances(m_model, m_instanceList, filter);

				if (m_instanceList.size() == 0) {
					MessageDialog
							.openInformation(
									shell,
									"Instance configuration",
									"There are still no instances available\n. Check whether you created already a deployment plan for your system. Check as well, if the parts in your a composite use \"composite\" as aggregation kind. (Results of deployment plan synchronizations will be unrolled)");
					return false;
				}
			}
		}
		return true;
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

		createInstanceSelectionGroup(contents);
		createInstanceConfigurationGroup(contents);
		return contents;
	}

	protected void createInstanceSelectionGroup(Composite parent) {
		Composite instanceSelection = new Composite(parent, SWT.NONE);
		GridLayout grid = new GridLayout(1, true);
		GridData groupGridData = new GridData();

		groupGridData.grabExcessVerticalSpace = true;
		groupGridData.grabExcessHorizontalSpace = true;
		groupGridData.horizontalAlignment = GridData.FILL;
		groupGridData.verticalAlignment = GridData.FILL;
		instanceSelection.setLayout(grid);
		instanceSelection.setLayoutData(groupGridData);

		/*
		 * fRules = DialogUtils.createFilteredList (ruleSelGroup, new
		 * RuleLabelProvider(), 200, 200, SWT.BORDER | SWT.V_SCROLL |
		 * SWT.H_SCROLL);
		 */

		//
		// --------------- instance selection -------------------
		//
		Group instanceSelGroup = new Group(instanceSelection, SWT.BORDER);
		instanceSelGroup.setText(addSpaces("associated instance specifications"));
		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		instanceSelGroup.setLayout(new GridLayout(1, false));
		instanceSelGroup.setLayoutData(groupGridData);

		fInstanceList = new TreeViewer(instanceSelGroup, SWT.BORDER);

		GridData data = new GridData(GridData.FILL_BOTH);
		data.heightHint = 100;
		data.widthHint = 350;

		fInstanceList.getTree().setLayoutData(data);
		fInstanceList.setLabelProvider(new InstanceLabelProvider());
		fInstanceList.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public boolean hasChildren(Object element) {
				return getChildren(element).length > 0;
			}

			@Override
			public Object getParent(Object element) {
				return null;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return (Object[]) inputElement;
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if (parentElement instanceof InstanceSpecification) {
					return DepUtils.getContainedInstances((InstanceSpecification) parentElement).toArray();
				}
				return new Object[0];
			}
		});

		fInstanceList.setInput(m_instanceList.toArray());
		fInstanceList.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = fInstanceList.getSelection();
				if (selection instanceof StructuredSelection) {
					Object[] selected = ((StructuredSelection) selection)
							.toArray();
					if ((selected.length == 1)
							&& (selected[0] instanceof InstanceSpecification)) {
						m_instance = (InstanceSpecification) selected[0];
						Classifier cl = DepUtils.getClassifier(m_instance);
						fPropertyList.setInput(getConfigAttributes(cl).toArray());
						selectProperty(m_currentAttribute);
					}
				}
			}
		});
		if (m_instance != null) {
			int index = m_instanceList.indexOf(m_instance);
			if (index != -1) {
				TreeItem treeItem = fInstanceList.getTree().getItem(index);
				fInstanceList.getTree().setSelection(treeItem);
			}
		}
	}

	// create instance configuration group
	protected void createInstanceConfigurationGroup(Composite parent) {
		GridData groupGridData = DialogUtils.createFillGridData();

		Group instanceConfigurationGroup = new Group(parent, SWT.BORDER);
		instanceConfigurationGroup.setText(addSpaces("Configuration"));
		instanceConfigurationGroup.setLayout(new RowLayout(SWT.VERTICAL));
		instanceConfigurationGroup.setLayout(new GridLayout(1, false));
		instanceConfigurationGroup.setLayoutData(groupGridData);

		// fRuleName = new Text (ruleInfoGroup, SWT.NONE);
		Label configL = new Label(instanceConfigurationGroup, SWT.NONE);
		configL.setText("Available properties:");

		fPropertyList = new TableViewer(instanceConfigurationGroup, SWT.BORDER);
		fPropertyList.setLabelProvider(new AttributeLabelProvider());
		fPropertyList.setContentProvider(new ArrayContentProvider());
		fPropertyList.setInput(getConfigAttributes(m_component).toArray());
		fPropertyList
				.addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection selection = fPropertyList.getSelection();
						if (selection instanceof StructuredSelection) {
							Object[] selected = ((StructuredSelection) selection)
									.toArray();
							if ((selected.length == 1)
									&& (selected[0] instanceof Property)) {
								selectProperty((Property) selected[0]);
							}
						}
					}
				});

		fValueLabel = new Label(instanceConfigurationGroup, SWT.NONE);

		GridData span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.heightHint = 70;
		fPropertyList.getTable().setLayoutData(span2);

		fValue = new Text(instanceConfigurationGroup, SWT.WRAP);
		span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		fValue.setLayoutData(span2);
		
		fValue.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// store value, once focus is lost (different element is
				// selected)
				String valueStr = fValue.getText();
				Slot valueSlot = null;
				if (m_instance == null) {
					// no instance has been selected
					// (field should be inactive, if not selected)
					return;
				}
				for (Slot slot : m_instance.getSlots()) {
					if (slot.getDefiningFeature() == m_currentAttribute) {
						valueSlot = slot;
					}
				}
				if (valueSlot == null) {
					// slot does not exist yet, create
					valueSlot = DepCreation.createSlotForConfigProp(m_instance,
							m_currentAttribute);
				}
				for (ValueSpecification value : valueSlot.getValues()) {
					if (value instanceof LiteralString) {
						((LiteralString) value).setValue(valueStr);
					} else if (value instanceof LiteralInteger) {
						((LiteralInteger) value).setValue(Integer
								.parseInt(valueStr));
					} else if (value instanceof LiteralBoolean) {
						((LiteralBoolean) value).setValue(Boolean
								.parseBoolean(valueStr));
					}
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		fComboValue = new Combo(instanceConfigurationGroup, SWT.NONE);
		span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		fComboValue.setLayoutData(span2);
		
		fComboValue.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				// store value, once focus is lost (different element is
				// selected)
				int index = fComboValue.getSelectionIndex();
				if (m_instance == null) {
					// no instance has been selected
					// (field should be inactive, if not selected)
					return;
				}
				Slot valueSlot = null;
				for (Slot slot : m_instance.getSlots()) {
					if (slot.getDefiningFeature() == m_currentAttribute) {
						// slot for enumerations can only be configured with instanceValues.
						// Destroy slots with do not contain at least one instanceValue
						boolean destroySlot = true;
						for (ValueSpecification value : slot.getValues()) {
							if (value instanceof InstanceValue) {
								destroySlot = false;
							}
						}
						if (destroySlot) {
							slot.destroy();
						}
						else {
							valueSlot = slot;
						}
						break;
					}
				}
				if (valueSlot == null) {
					// slot does not exist yet, create
					valueSlot = DepCreation.createSlotForConfigProp(m_instance,
							m_currentAttribute);
				}
				Enumeration enumeration = (Enumeration) m_currentAttribute.getType();
				for (ValueSpecification value : valueSlot.getValues()) {
					if (value instanceof InstanceValue) {
						((InstanceValue) value).setInstance(enumeration.getOwnedLiterals().get(index));
					}
				}
			}
		});
		
		fDescriptionLabel = new Label(instanceConfigurationGroup, SWT.NONE);
		fDescriptionLabel.setText("Description:");
		fDescriptionLabel.setLayoutData(span2);

		span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.grabExcessVerticalSpace = true;
		span2.verticalAlignment = GridData.FILL;
		span2.heightHint = 80;

		fDescription = new Text(instanceConfigurationGroup, SWT.NONE | SWT.WRAP
				| SWT.V_SCROLL | SWT.READ_ONLY);
		fDescription.setLayoutData(span2);
		// createMessageArea (ruleInfoGroup);
		instanceConfigurationGroup.pack();
		setEnabled(false);
	}

	/**
	 * Select a rule, i.e. update the visual representation from the rule
	 *
	 * @param rule
	 */
	protected void selectProperty(Property attribute) {
		m_currentAttribute = attribute;
		if ((attribute == null) || (fValue == null)) {
			setEnabled(false);
			return;
		}
		setEnabled(true);
		fDescription.setText(Description.getDescription(attribute, "not available"));
		fValueLabel.setText(getValueLabel(attribute));
		boolean isEnum = m_currentAttribute.getType() instanceof Enumeration;
		fValue.setVisible(!isEnum);
		fComboValue.setVisible(isEnum);
		if (isEnum) {
			Enumeration enumeration = (Enumeration) m_currentAttribute.getType();
			EList<EnumerationLiteral> literals = enumeration.getOwnedLiterals();
			String items[] = new String[literals.size()];
			for (int i = 0; i < literals.size(); i++) {
				items[i] = literals.get(i).getName();
			}
			fComboValue.setItems(items);
		}
		
		for (Slot slot : m_instance.getSlots()) {
			if (slot.getDefiningFeature() == m_currentAttribute) {
				for (ValueSpecification value : slot.getValues()) {
					if (value instanceof LiteralInteger) {
						Integer intVal = ((LiteralInteger) value).getValue();
						fValue.setText(intVal.toString());
						return;
					}
					if (value instanceof InstanceValue) {
						InstanceSpecification enumIS = ((InstanceValue) value).getInstance();
						if (enumIS instanceof EnumerationLiteral) {
							EnumerationLiteral literal = (EnumerationLiteral) enumIS;
							int index = literal.getEnumeration().getOwnedLiterals().indexOf(literal);
							if (index != -1) {
								fComboValue.select(index);
							}
						}
						return;
					}
					else if (value instanceof LiteralBoolean) {
						Boolean boolVal = ((LiteralBoolean) value).booleanValue();
						fValue.setText(boolVal.toString());
						return;
					}
					else if (value instanceof LiteralString) {
						fValue.setText(((LiteralString) value).getValue());
						return;
					}
				}
			}
		}
		fValue.setText(""); //$NON-NLS-1$
	}

	private void setEnabled(boolean enabled) {
		fDescriptionLabel.setEnabled(enabled);
		fDescription.setEnabled(enabled);
		fValueLabel.setEnabled(enabled);
		fValue.setEnabled(enabled);
		if (!enabled) {
			fValue.setText(""); //$NON-NLS-1$
			fDescription.setText(""); //$NON-NLS-1$
			fValueLabel.setText(valueLabelPrefix);
		}
	}

	private String getValueLabel(Property attribute) {
		String label = valueLabelPrefix;
		if (attribute.getDefault() != null) {
			return label + " " + String.format("(default = %s)", attribute.getDefault()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return label;
	}

	private EList<Property> getConfigAttributes(Classifier component) {
		EList<Property> list = new BasicEList<Property>();
		// add properties of component
		list.addAll(ConfigUtils.getConfigAttributes(component));
		// now add properties of container rules
		// TODO: is it possible that multiple container extensions of the same
		// type exist, and if yes, how do we configure these?
		if (component instanceof Class) {
			EList<ContainerRule> rules = FCMUtil.getAllContainerRules((Class) component);
			if (rules != null) {
				for (ContainerRule aRule : rules) {
					// (many, in case of a composite rule)
					try {
						list.addAll(ConfigUtils.getConfigAttributes(aRule));
					} catch (TransformationException e) {
					}
				}
			}
		}
		return list;
	}

	/**
	 * Add a space before and after
	 *
	 * @param text
	 * @return
	 */
	public static String addSpaces(String text) {
		return " " + text + " "; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
