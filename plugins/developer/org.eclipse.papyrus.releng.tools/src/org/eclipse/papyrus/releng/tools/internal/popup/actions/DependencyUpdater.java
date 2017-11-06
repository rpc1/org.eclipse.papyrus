/*******************************************************************************
 * Copyright (c) 2011, 2015 Mia-Software, CEA LIST, Christian W. Damus, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - Bug 366567 - [Releng] Tool to update rmaps
 *     Camille Letavernier (CEA LIST) - Generalize to support POMs
 *     Christian W. Damus (CEA) - Add support for updating Oomph setup models
 *     Christian W. Damus - Support updating of multiple selected files
 *      
 *******************************************************************************/
package org.eclipse.papyrus.releng.tools.internal.popup.actions;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.eclipse.b3.aggregator.Contribution;
import org.eclipse.b3.aggregator.MappedRepository;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.releng.tools.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


public abstract class DependencyUpdater {

	private final Pattern commentPattern = Pattern.compile("updateFrom\\s*\\(\\s*\"(.*?)\"\\s*,\\s*(\\d+)\\s*\\)"); //$NON-NLS-1$

	private final List<LocationUpdateStrategy> locationUpdateStrategies = ImmutableList.of(
			new MilestoneLocationStrategy(),
			new EMFLocationStrategy());

	public DependencyUpdater() {
		super();
	}

	protected static final String PREFIX = "http://download.eclipse.org/"; //$NON-NLS-1$

	public abstract boolean canUpdate(IFile file);

	public void updateDocument(final Shell parentShell, final IFile mapFile, final EList<Contribution> contributions, final Map<Object, Object> context) throws CoreException {
		try {
			File rmapFile = mapFile.getLocation().toFile();

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(rmapFile);
			doc.normalize();
			Element documentElement = doc.getDocumentElement();

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList uris = (NodeList) xpath.evaluate(getXpath(), documentElement, XPathConstants.NODESET);
			List<UpdateItem> updates = Lists.newArrayList();
			for (int i = 0; i < uris.getLength(); i++) {
				Node uri = uris.item(i);
				Node precedingComment = getPrecedingComment(uri);
				if (precedingComment != null) {
					String comment = getCommentContent(precedingComment);
					Matcher matcher = getCommentPattern().matcher(comment);
					if (matcher.find()) {
						String contributionName = matcher.group(1);
						int repositoryIndex = Integer.parseInt(matcher.group(2));
						Contribution contribution = findContribution(contributions, contributionName);
						if (contribution == null) {
							throw new RuntimeException("'updateFrom' failed: cannot find contribution with label \"" + contributionName + "\""); //$NON-NLS-1$ //$NON-NLS-2$
						}
						updates.add(new UpdateItem(uri, contribution, repositoryIndex));
					} else if (comment.contains("updateFrom")) { //$NON-NLS-1$
						throw new Exception("Wrong syntax for 'updateFrom' : should be " + getCommentSyntax()); //$NON-NLS-1$
					}
				}
			}

			if (confirmUpdates(parentShell, updates, context)) {
				for (UpdateItem next : updates) {
					updateWithContribution(parentShell, next.uriNode, next.contribution, next.repositoryIndex, context);
				}

				save(doc, rmapFile);

				mapFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
			}
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error updating map: " + e.getLocalizedMessage(), e)); //$NON-NLS-1$
		}
	}

	protected void save(Document document, File destination) throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$

		StreamResult result = new StreamResult(destination);
		DOMSource source = new DOMSource(document);
		transformer.transform(source, result);
	}

	protected void updateWithContribution(final Shell parentShell, final Node uri, final Contribution contribution, final int repositoryIndex, final Map<Object, Object> context) {
		EList<MappedRepository> repositories = contribution.getRepositories();
		if (repositoryIndex >= repositories.size()) {
			throw new RuntimeException("wrong index in updateFrom(\"" + contribution.getLabel() + "\"" + repositoryIndex //$NON-NLS-1$ //$NON-NLS-2$
					+ ") : there are " + repositories.size() + " contributions"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		String location = repositories.get(repositoryIndex).getLocation();

		updateUri(uri, location);
	}

	protected abstract String getCurrentLocation(Node uri);

	protected abstract void updateUri(Node uri, String location);

	protected Contribution findContribution(Iterable<? extends Contribution> contributions, final String contributionName) {
		Contribution matchingContribution = null;
		for (Contribution contribution : contributions) {
			if (contributionName.equalsIgnoreCase(contribution.getLabel())) {
				matchingContribution = contribution;
			}
		}
		return matchingContribution;
	}

	protected Node getPrecedingComment(final Node node) {
		Comment comment = null;
		Node previous = node.getPreviousSibling();
		while (previous != null) {
			if (previous.getNodeType() == Node.COMMENT_NODE) {
				comment = (Comment) previous;
				break;
			} else if (previous.getNodeType() != Node.TEXT_NODE) {
				break;
			}
			previous = previous.getPreviousSibling();
		}
		return comment;
	}

	protected Pattern getCommentPattern() {
		return commentPattern;
	}

	protected String getCommentContent(Node comment) {
		return comment.getTextContent();
	}

	protected String getCommentSyntax() {
		return "updateFrom(\"<contributionName>\",<index>)"; //$NON-NLS-1$
	}

	protected abstract String getXpath();

	private boolean promptToReplaceSingle(Shell parentShell, LocationUpdate locationUpdate, Map<Object, Object> context) {
		String message = NLS.bind("{0}\n\nUpdate anyways?", locationUpdate.strategy.getUpdateConfirmationMessage(locationUpdate.update, locationUpdate.oldLocation, locationUpdate.newLocation)); //$NON-NLS-1$
		boolean result = MessageDialog.openQuestion(parentShell, "Confirm Location Update", message);
		setReplace(locationUpdate.update, result, context);

		return result;
	}

	private Boolean getReplace(UpdateItem update, Map<Object, Object> context) {
		return (Boolean) context.get("$replace$::" + update.contribution.getLabel()); //$NON-NLS-1$
	}

	private void setReplace(UpdateItem update, Boolean replace, Map<Object, Object> context) {
		context.put("$replace$::" + update.contribution.getLabel(), replace); //$NON-NLS-1$
	}

	/**
	 * Prompt to confirm multiple suspicious dependency replacements, returning those updates that the
	 * user confirms to perform.
	 */
	private Collection<LocationUpdate> promptToReplaceMultiple(Shell parentShell, Collection<? extends LocationUpdate> locationUpdates, Map<Object, Object> context) {
		final List<LocationUpdate> result = Lists.newArrayList(locationUpdates);

		ILabelProvider labels = new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((LocationUpdate) element).update.contribution.getLabel();
			}
		};

		ListSelectionDialog dialog = new ListSelectionDialog(parentShell, locationUpdates, ArrayContentProvider.getInstance(), labels, "Select dependencies to confirm updating.") {
			@Override
			protected Control createDialogArea(Composite parent) {
				Composite result = (Composite) super.createDialogArea(parent);

				createDetailsArea(result);

				return result;
			}

			void createDetailsArea(Composite parent) {
				Label label = new Label(parent, SWT.NONE);
				label.setText("Details:");

				final Text details = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP | SWT.READ_ONLY);
				GridData data = new GridData(GridData.FILL_BOTH);
				data.heightHint = details.getLineHeight() * 4;
				details.setLayoutData(data);

				getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection sel = (IStructuredSelection) event.getSelection();
						if (sel.isEmpty()) {
							details.setText(""); //$NON-NLS-1$
						} else {
							LocationUpdate update = (LocationUpdate) sel.getFirstElement();
							details.setText(update.strategy.getUpdateConfirmationMessage(update.update, update.oldLocation, update.newLocation));
						}
					}
				});
			}
		};

		dialog.setInitialElementSelections(result);
		dialog.setTitle("Confirm Location Update");
		if (dialog.open() == Window.OK) {
			Set<?> toUpdate = ImmutableSet.copyOf(dialog.getResult());
			for (Iterator<LocationUpdate> iter = result.iterator(); iter.hasNext();) {
				LocationUpdate next = iter.next();

				boolean update = toUpdate.contains(next);
				setReplace(next.update, update, context);
				if (!update) {
					// User elects not to update, so remove from the result
					iter.remove();
				}
			}
		} else {
			throw new OperationCanceledException();
		}

		return result;
	}

	private boolean confirmUpdates(final Shell parentShell, List<UpdateItem> updates, Map<Object, Object> context) {
		Map<UpdateItem, LocationUpdate> toPrompt = Maps.newHashMap();

		for (Iterator<UpdateItem> iter = updates.iterator(); iter.hasNext();) {
			UpdateItem next = iter.next();

			// Check for previous prompt answer
			Boolean previousAnswer = getReplace(next, context);
			if (previousAnswer != null) {
				if (previousAnswer) {
					// Don't prompt this one
				} else {
					iter.remove(); // Don't update this one
				}
			} else {
				EList<MappedRepository> repositories = next.contribution.getRepositories();
				if (next.repositoryIndex >= repositories.size()) {
					throw new RuntimeException("wrong index in updateFrom(\"" + next.contribution.getLabel() + "\"" + next.repositoryIndex //$NON-NLS-1$ //$NON-NLS-2$
							+ ") : there are " + repositories.size() + " contributions"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				String location = repositories.get(next.repositoryIndex).getLocation();
				String current = getCurrentLocation(next.uriNode);

				if ((current == null) || !current.equals(location)) {
					if ((current != null) && !current.isEmpty()) {
						LocationUpdateStrategy strategy = findLocationUpdateStrategy(next, current, location);
						if (strategy != null) {
							toPrompt.put(next, new LocationUpdate(next, strategy, current, location));
						}
					}
				}
			}
		}

		if (!toPrompt.isEmpty()) {
			if (toPrompt.size() == 1) {
				// Simple dialog
				UpdateItem update = Iterables.getOnlyElement(toPrompt.keySet());
				LocationUpdate location = toPrompt.get(update);
				if (!promptToReplaceSingle(parentShell, location, context)) {
					updates.remove(update);
				}
			} else {
				// List dialog
				toPrompt.values().removeAll(promptToReplaceMultiple(parentShell, toPrompt.values(), context));
				updates.removeAll(toPrompt.keySet()); // What remains are the update exclusions
			}
		}

		return !updates.isEmpty();
	}

	private LocationUpdateStrategy findLocationUpdateStrategy(UpdateItem update, String oldLocation, String newLocation) {
		LocationUpdateStrategy result = null;

		for (LocationUpdateStrategy next : locationUpdateStrategies) {
			if (!next.shouldAutoUpdate(update, oldLocation, newLocation)) {
				result = next;
				break;
			}
		}

		return result;
	}

	//
	// Nested types
	//

	private static class UpdateItem {
		final Node uriNode;
		final Contribution contribution;
		final int repositoryIndex;

		UpdateItem(Node uriNode, Contribution contribution, int repositoryIndex) {
			super();

			this.uriNode = uriNode;
			this.contribution = contribution;
			this.repositoryIndex = repositoryIndex;
		}
	}

	private static class LocationUpdate {
		final UpdateItem update;
		final LocationUpdateStrategy strategy;
		final String oldLocation;
		final String newLocation;

		LocationUpdate(UpdateItem update, LocationUpdateStrategy strategy, String oldLocation, String newLocation) {
			super();

			this.update = update;
			this.strategy = strategy;
			this.oldLocation = oldLocation;
			this.newLocation = newLocation;
		}
	}

	private interface LocationUpdateStrategy {
		boolean shouldAutoUpdate(UpdateItem update, String oldLocation, String newLocation);

		String getUpdateConfirmationMessage(UpdateItem update, String oldLocation, String newLocation);
	}

	static class MilestoneLocationStrategy implements LocationUpdateStrategy {
		private final Pattern typicalBuildTimestampPattern = Pattern.compile("[NISMR](?:-\\d+\\.\\d+(?:\\.\\d+)?(?:M|RC)\\d[abcd]-)?20\\d\\d[-0-9]+"); //$NON-NLS-1$

		@Override
		public boolean shouldAutoUpdate(UpdateItem update, String oldLocation, String newLocation) {
			boolean result = true; // Optimistically assume sameness if we can't find any build timestamps

			Matcher oldMatcher = typicalBuildTimestampPattern.matcher(oldLocation);
			Matcher newMatcher = typicalBuildTimestampPattern.matcher(newLocation);
			boolean foundOld = oldMatcher.find();
			boolean foundNew = newMatcher.find();

			if (foundOld != foundNew) {
				// definitely different
				result = false;
			} else if (foundNew) {
				// Compare prefixes
				String oldPrefix = oldLocation.substring(0, oldMatcher.start());
				String newPrefix = newLocation.substring(0, newMatcher.start());
				result = newPrefix.equals(oldPrefix);
			}

			return result;
		}

		@Override
		public String getUpdateConfirmationMessage(UpdateItem update, String oldLocation, String newLocation) {
			return NLS.bind("The new location \"{0}\" for project \"{1}\" is not like the current location \"{2}\". This could roll back to an older (obsolete) build.", new Object[] { newLocation, update.contribution.getLabel(), oldLocation });
		}
	}

	static class EMFLocationStrategy implements LocationUpdateStrategy {
		private final Pattern typicalMilestonesPattern = Pattern.compile("\\d+\\.\\d+(milestones|interim)$"); //$NON-NLS-1$

		@Override
		public boolean shouldAutoUpdate(UpdateItem update, String oldLocation, String newLocation) {
			boolean result = true; // Optimistically assume sameness if we can't find any milestones/interim segment

			Matcher oldMatcher = typicalMilestonesPattern.matcher(oldLocation);
			Matcher newMatcher = typicalMilestonesPattern.matcher(newLocation);
			boolean foundOld = oldMatcher.find();
			boolean foundNew = newMatcher.find();

			if (foundOld != foundNew) {
				// definitely different
				result = false;
			} else if (foundNew && !(oldMatcher.group(1).equals(newMatcher.group(1)))) {
				result = (oldMatcher.group(1).equals("interim"));
			}

			return result;
		}

		@Override
		public String getUpdateConfirmationMessage(UpdateItem update, String oldLocation, String newLocation) {
			return NLS.bind("The current location \"{2}\" for project \"{1}\" provides interim builds. Updating from \"{0}\" could roll back to a previous milestone build.", new Object[] { newLocation, update.contribution.getLabel(), oldLocation });
		}
	}
}
