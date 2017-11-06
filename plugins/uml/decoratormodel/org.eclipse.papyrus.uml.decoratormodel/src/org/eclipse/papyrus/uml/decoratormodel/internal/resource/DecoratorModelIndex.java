/*****************************************************************************
 * Copyright (c) 2014, 2015 Christian W. Damus and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.uml.decoratormodel.internal.resource;

import static org.eclipse.papyrus.uml.decoratormodel.Activator.TRACE_INDEX;

import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndex.IndexHandler;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndexAdapter;
import org.eclipse.papyrus.infra.emf.resource.index.WorkspaceModelIndexEvent;
import org.eclipse.papyrus.uml.decoratormodel.Activator;
import org.eclipse.papyrus.uml.decoratormodel.helper.DecoratorModelUtils;
import org.eclipse.papyrus.uml.decoratormodel.internal.messages.Messages;
import org.eclipse.papyrus.uml.decoratormodel.internal.resource.index.ModelIndexHandler;
import org.eclipse.papyrus.uml.decoratormodel.internal.resource.index.ProfileIndexHandler;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.xml.sax.helpers.DefaultHandler;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * A workspace-wide index mapping UML model resources to decorator models that apply profiles to them.
 */
public class DecoratorModelIndex {

	private static final int MAX_INDEX_JOBS = 5;

	private static final DecoratorModelIndex INSTANCE = new DecoratorModelIndex();

	private final Object sync = new Object();
	private final SetMultimap<URI, URI> modelToDecorators = HashMultimap.create();
	private final SetMultimap<URI, URI> decoratorToModels = HashMultimap.create();
	private final SetMultimap<URI, URI> packageToDecoratorModels = HashMultimap.create();

	private final Map<URI, Map<URI, Map<URI, URI>>> decoratorModelToPackageToProfileApplications = Maps.newHashMap();
	private final Map<URI, String> decoratorModelNames = Maps.newHashMap();

	private final Map<URI, SetMultimap<URI, URI>> userModelToResourceToAppliedProfiles = Maps.newHashMap();

	private final WorkspaceModelIndex<DecoratorModelIndex> index;

	private final CopyOnWriteArrayList<IDecoratorModelIndexListener> listeners = Lists.newCopyOnWriteArrayList();

	/**
	 * Not instantiable by clients.
	 */
	private DecoratorModelIndex() {
		super();

		index = new WorkspaceModelIndex<DecoratorModelIndex>("papyrusUMLProfiles", UMLPackage.eCONTENT_TYPE, indexer(), MAX_INDEX_JOBS); //$NON-NLS-1$
		index.addListener(new WorkspaceModelIndexAdapter() {
			@Override
			protected void indexAboutToCalculateOrRecalculate(WorkspaceModelIndexEvent event) {
				// Clear the CacheAdapter to purge any caches of information derived from this index
				CacheAdapter.getInstance().clear();
			}

			@Override
			protected void indexCalculatedOrRecalculated(WorkspaceModelIndexEvent event) {
				notifyChanged();
			}
		});
	}

	public void dispose() {
		index.dispose();
		modelToDecorators.clear();
	}

	public static DecoratorModelIndex getInstance() {
		return INSTANCE;
	}

	/**
	 * Asynchronously queries the mapping of URIs of user models to URIs of decorator models that apply profiles to them.
	 * 
	 * @return a future result of the mapping of user model URIs to decorator model URIs
	 */
	public ListenableFuture<SetMultimap<URI, URI>> getDecoratorModelsAsync() {
		return afterIndex(getDecoratorModelsCallable());
	}

	/**
	 * Queries the mapping of URIs of user models to URIs of decorator models that apply profiles to them.
	 * 
	 * @return the mapping of user model URIs to decorator model URIs
	 */
	public SetMultimap<URI, URI> getDecoratorModels() throws CoreException {
		return sync(afterIndex(getDecoratorModelsCallable()));
	}

	Callable<SetMultimap<URI, URI>> getDecoratorModelsCallable() {
		return new SyncCallable<SetMultimap<URI, URI>>() {
			@Override
			protected SetMultimap<URI, URI> doCall() {
				return ImmutableSetMultimap.copyOf(modelToDecorators);
			}
		};
	}

	/**
	 * Asynchronously queries the URIs of decorator models that apply profiles to the specified user model resource.
	 * 
	 * @param modelResourceURI
	 *            the URI of a user model resource
	 * @return a future result of the URIs of decorator models for the user model resource
	 */
	public ListenableFuture<Set<URI>> getDecoratorModelsAsync(URI modelResourceURI) {
		return afterIndex(getDecoratorModelsCallable(modelResourceURI));
	}

	/**
	 * Queries the URIs of decorator models that apply profiles to the specified user model resource.
	 * 
	 * @param modelResourceURI
	 *            the URI of a user model resource
	 * @return the URIs of decorator models for the user model resource
	 */
	public Set<URI> getDecoratorModels(URI modelResourceURI) throws CoreException {
		return sync(afterIndex(getDecoratorModelsCallable(modelResourceURI)));
	}

	final <V> V sync(Future<V> future) throws CoreException {
		try {
			return future.get();
		} catch (InterruptedException e) {
			throw new CoreException(Status.CANCEL_STATUS);
		} catch (ExecutionException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.DecoratorModelIndex_0, e));
		}
	}

	Callable<Set<URI>> getDecoratorModelsCallable(final URI modelResourceURI) {
		return new SyncCallable<Set<URI>>() {
			@Override
			protected Set<URI> doCall() {
				return ImmutableSet.copyOf(modelToDecorators.get(modelResourceURI));
			}
		};
	}

	/**
	 * Asynchronously queries the URIs of profiles applied to the specified user model package by the specified decorator model.
	 * 
	 * @param packageURI
	 *            the URI of a package in a user model
	 * @param decoratorModel
	 *            the URI of a decorator model
	 * @return the future result of the URIs of profiles applied to the package by the resource
	 */
	public ListenableFuture<Set<URI>> getAppliedProfilesAsync(final URI packageURI, URI decoratorModel) {
		return Futures.transform(getAppliedProfilesByPackageAsync(decoratorModel), new Function<SetMultimap<URI, URI>, Set<URI>>() {
			@Override
			public Set<URI> apply(SetMultimap<URI, URI> input) {
				return input.get(packageURI);
			}
		});
	}

	/**
	 * Queries the URIs of profiles applied to the specified user model package by the specified decorator model.
	 * 
	 * @param packageURI
	 *            the URI of a package in a user model
	 * @param decoratorModel
	 *            the URI of a decorator model
	 * @return the URIs of profiles applied to the package by the resource
	 */
	public Set<URI> getAppliedProfiles(URI packageURI, URI decoratorModel) throws CoreException {
		return sync(getAppliedProfilesAsync(packageURI, decoratorModel));
	}

	/**
	 * Asynchronously queries a mapping of user-model package URIs to URIs of profiles applied to them by the specified decorator model.
	 * 
	 * @param decoratorModel
	 *            the URI of a decorator model
	 * @return the future result of the URIs of user model packages to profiles applied to them by the resource
	 */
	public ListenableFuture<SetMultimap<URI, URI>> getAppliedProfilesByPackageAsync(URI decoratorModel) {
		return afterIndex(getAppliedProfilesByPackageCallable(decoratorModel));
	}

	/**
	 * Queries a mapping of user-model package URIs to URIs of profiles applied to them by the specified decorator model.
	 * 
	 * @param decoratorModel
	 *            the URI of a decorator model
	 * @return the URIs of user model packages to profiles applied to them by the resource
	 */
	public SetMultimap<URI, URI> getAppliedProfilesByPackage(URI decoratorModel) throws CoreException {
		return sync(afterIndex(getAppliedProfilesByPackageCallable(decoratorModel)));
	}

	Callable<SetMultimap<URI, URI>> getAppliedProfilesByPackageCallable(final URI decoratorModel) {
		return new SyncCallable<SetMultimap<URI, URI>>() {
			@Override
			protected SetMultimap<URI, URI> doCall() {
				SetMultimap<URI, URI> result;

				Map<URI, Map<URI, URI>> packageToProfileApplications = decoratorModelToPackageToProfileApplications.get(decoratorModel);
				if (packageToProfileApplications == null) {
					result = ImmutableSetMultimap.of();
				} else {
					ImmutableSetMultimap.Builder<URI, URI> builder = ImmutableSetMultimap.builder();
					for (Map.Entry<URI, Map<URI, URI>> next : packageToProfileApplications.entrySet()) {
						builder.putAll(next.getKey(), next.getValue().keySet());
					}
					result = builder.build();
				}

				return result;
			}
		};
	}

	/**
	 * Asynchronously queries a mapping of all profiles applied externally on a package to the resources that apply those profiles.
	 * The mapping is one-to-many because any number of decorator models can apply the same profile to a package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return the future result of a mapping of the URIs of profiles externally applied on the package to the resources that apply them
	 */
	public ListenableFuture<SetMultimap<URI, URI>> getAllAppliedProfilesAsync(URI package_) {
		return afterIndex(getAllAppliedProfilesCallable(package_));
	}

	/**
	 * Queries a mapping of all profiles applied externally on a package to the resources that apply those profiles.
	 * The mapping is one-to-many because any number of decorator models can apply the same profile to a package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return a mapping of the URIs of profiles externally applied on the package to the resources that apply them
	 */
	public SetMultimap<URI, URI> getAllAppliedProfiles(URI package_) throws CoreException {
		return sync(afterIndex(getAllAppliedProfilesCallable(package_)));
	}

	Callable<SetMultimap<URI, URI>> getAllAppliedProfilesCallable(final URI packageURI) {
		return new SyncCallable<SetMultimap<URI, URI>>() {
			@Override
			protected SetMultimap<URI, URI> doCall() {
				ImmutableSetMultimap.Builder<URI, URI> result = ImmutableSetMultimap.builder();

				for (URI paResource : modelToDecorators.get(packageURI.trimFragment())) {
					Map<URI, Map<URI, URI>> packageToProfileApplications = decoratorModelToPackageToProfileApplications.get(paResource);
					if (packageToProfileApplications != null) {
						Map<URI, URI> profileApplications = packageToProfileApplications.get(packageURI);
						if (profileApplications != null) {
							for (URI profile : profileApplications.keySet()) {
								result.put(profile, paResource);
							}
						}
					}
				}

				return result.build();
			}
		};
	}

	/**
	 * Asynchronously queries a mapping of all profiles applied externally on a package to mappings of decorator model resources that apply those profiles
	 * to the Ecore definitions applied by those decorators. That is, (profile&nbsp;==>&nbsp;decorator-model&nbsp;==>&nbsp;ecore-definition).
	 * The mapping is one-to-many because any number of decorator models can apply the same profile to a package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return the future result of a mapping of the URIs of profiles externally applied on the package to the resources that apply them to
	 *         the Ecore definitions applied by those resources
	 */
	public ListenableFuture<Map<URI, Map<URI, URI>>> getAllAppliedProfileDefinitionsAsync(URI package_) {
		return afterIndex(getAllAppliedProfileDefinitionsCallable(package_));
	}

	/**
	 * Queries a mapping of all profiles applied externally on a package to mappings of decorator model resources that apply those profiles
	 * to the Ecore definitions applied by those decorators. That is, (profile&nbsp;==>&nbsp;decorator-model&nbsp;==>&nbsp;ecore-definition).
	 * The mapping is one-to-many because any number of decorator models can apply the same profile to a package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return a mapping of the URIs of profiles externally applied on the package to the resources that apply them to
	 *         the Ecore definitions applied by those resources
	 */
	public Map<URI, Map<URI, URI>> getAllAppliedProfileDefinitions(URI package_) throws CoreException {
		return sync(afterIndex(getAllAppliedProfileDefinitionsCallable(package_)));
	}

	Callable<Map<URI, Map<URI, URI>>> getAllAppliedProfileDefinitionsCallable(final URI packageURI) {
		return new SyncCallable<Map<URI, Map<URI, URI>>>() {
			@Override
			protected Map<URI, Map<URI, URI>> doCall() {
				Map<URI, ImmutableMap.Builder<URI, URI>> gather = Maps.newHashMap();

				for (URI paResource : modelToDecorators.get(packageURI.trimFragment())) {
					Map<URI, Map<URI, URI>> packageToProfileApplications = decoratorModelToPackageToProfileApplications.get(paResource);
					if (packageToProfileApplications != null) {
						Map<URI, URI> profileApplications = packageToProfileApplications.get(packageURI);
						if (profileApplications != null) {
							for (Map.Entry<URI, URI> next : profileApplications.entrySet()) {
								URI profile = next.getKey();
								ImmutableMap.Builder<URI, URI> builder = gather.get(profile);
								if (builder == null) {
									builder = ImmutableMap.builder();
									gather.put(profile, builder);
								}

								builder.put(paResource, next.getValue());
							}
						}
					}
				}

				ImmutableMap.Builder<URI, Map<URI, URI>> result = ImmutableMap.builder();
				for (Map.Entry<URI, ImmutableMap.Builder<URI, URI>> next : gather.entrySet()) {
					result.put(next.getKey(), next.getValue().build());
				}
				return result.build();
			}
		};
	}

	/**
	 * Asynchronously queries the set of URIs of decorator models that apply profiles to the specified package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return the future result of the URIs of all decorator models that apply profiels to it
	 */
	public ListenableFuture<Set<URI>> getDecoratorModelsForPackageAsync(URI package_) {
		return afterIndex(getDecoratorModelsForPackageCallable(package_));
	}

	/**
	 * Queries the set of URIs of decorator models that apply profiles to the specified package.
	 * 
	 * @param package_
	 *            the URI of a user-model package
	 * @return the URIs of all decorator models that apply profiels to it
	 */
	public Set<URI> getDecoratorModelsForPackage(URI package_) throws CoreException {
		return sync(afterIndex(getDecoratorModelsForPackageCallable(package_)));
	}

	Callable<Set<URI>> getDecoratorModelsForPackageCallable(final URI packageURI) {
		return new SyncCallable<Set<URI>>() {
			@Override
			protected Set<URI> doCall() {
				return ImmutableSet.copyOf(packageToDecoratorModels.get(packageURI));
			}
		};
	}

	/**
	 * Asynchronously queries a mapping of the user-defined names/identifiers of the profile application externalization models in the workspace.
	 * 
	 * @return the future result of the known decorator models' names
	 */
	public ListenableFuture<Map<URI, String>> getDecoratorModelNamesAsync() {
		return afterIndex(getDecoratorModelNamesCallable());
	}

	/**
	 * Queries a mapping of the user-defined names/identifiers of the profile application externalization models in the workspace.
	 * 
	 * @return the known decorator models' names
	 */
	public Map<URI, String> getDecoratorModelNames() throws CoreException {
		return sync(afterIndex(getDecoratorModelNamesCallable()));
	}

	Callable<Map<URI, String>> getDecoratorModelNamesCallable() {
		return new SyncCallable<Map<URI, String>>() {
			@Override
			protected Map<URI, String> doCall() {
				return ImmutableMap.copyOf(decoratorModelNames);
			}
		};
	}

	/**
	 * Asynchronously queries the user-defined names/identifier of a decorator model.
	 * 
	 * @param resourceURI
	 *            the URI of the decorator model
	 * @return the future result of the decorator model name
	 */
	public ListenableFuture<String> getDecoratorModelNameAsync(final URI resourceURI) {
		return Futures.transform(getDecoratorModelNamesAsync(), new Function<Map<URI, String>, String>() {
			@Override
			public String apply(Map<URI, String> input) {
				return input.get(resourceURI);
			}
		});
	}

	/**
	 * Queries the user-defined names/identifier of a decorator model.
	 * 
	 * @param resourceURI
	 *            the URI of the decorator model
	 * @return the decorator model name
	 */
	public String getDecoratorModelName(URI resourceURI) throws CoreException {
		return sync(getDecoratorModelNameAsync(resourceURI));
	}

	/**
	 * Asynchronously queries the mapping of URIs of decorator models to URIs of user models to which they apply profiles.
	 * 
	 * @return a future result of the mapping of decorator model URIs to user model URIs
	 */
	public ListenableFuture<SetMultimap<URI, URI>> getUserModelsByDecoratorAsync() {
		return afterIndex(getUserModelsByDecoratorCallable());
	}

	/**
	 * Queries the mapping of URIs of decorator models to URIs of user models to which they apply profiles.
	 * 
	 * @return the mapping of decorator model URIs to user model URIs
	 */
	public SetMultimap<URI, URI> getUserModelsByDecorator() throws CoreException {
		return sync(afterIndex(getUserModelsByDecoratorCallable()));
	}

	Callable<SetMultimap<URI, URI>> getUserModelsByDecoratorCallable() {
		return new SyncCallable<SetMultimap<URI, URI>>() {
			@Override
			protected SetMultimap<URI, URI> doCall() {
				return ImmutableSetMultimap.copyOf(decoratorToModels);
			}
		};
	}

	/**
	 * Asynchronously queries the set of URIs of {@link Profile}s applied internally and by decorators to {@link Package}s
	 * within the specified user model.
	 * 
	 * @param userModelURI
	 *            the URI of a user model
	 * @return a future result of the set of URIs of the profile elements applied to it
	 */
	public ListenableFuture<Set<URI>> getAllProfilesAppliedToPackagesAsync(URI userModelURI) {
		return afterIndex(getAllProfilesAppliedToPackagesCallable(userModelURI));
	}

	/**
	 * Queries the set of URIs of {@link Profile}s applied internally and by decorators to {@link Package}s
	 * within the specified user model.
	 * 
	 * @param userModelURI
	 *            the URI of a user model
	 * @return the set of URIs of the profile elements applied to it
	 */
	public Set<URI> getAllProfilesAppliedToPackages(URI userModelURI) throws CoreException {
		return sync(afterIndex(getAllProfilesAppliedToPackagesCallable(userModelURI)));
	}

	Callable<Set<URI>> getAllProfilesAppliedToPackagesCallable(final URI userModelURI) {
		return new SyncCallable<Set<URI>>() {
			@Override
			protected Set<URI> doCall() {
				SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(userModelURI);
				return (resourceToAppliedProfiles == null) ? Collections.<URI> emptySet() : ImmutableSet.copyOf(resourceToAppliedProfiles.values());
			}
		};
	}

	public Set<URI> getIntrinsicAppliedProfiles(URI umlResource) {
		Set<URI> result = Collections.emptySet();

		synchronized (sync) {
			// Do we happen to have a last-known idea of this resource's internally applied profiles?
			SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(umlResource);
			if ((resourceToAppliedProfiles != null) && (resourceToAppliedProfiles.containsKey(umlResource))) {
				result = ImmutableSet.copyOf(resourceToAppliedProfiles.get(umlResource));
			}
		}

		if (!result.isEmpty() && Activator.log.isTraceEnabled(TRACE_INDEX)) {
			Activator.log.trace(TRACE_INDEX, "Using last known intrinsically applied profiles for " + umlResource);
		}

		if (result.isEmpty() && umlResource.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(umlResource.toPlatformString(true)));
			if (file.isAccessible()) {
				indexUserModel(file);

				synchronized (sync) {
					// Did we find any profiles applied to this resource within this resource, itself?
					SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(umlResource);
					if ((resourceToAppliedProfiles != null) && (resourceToAppliedProfiles.containsKey(umlResource))) {
						result = ImmutableSet.copyOf(resourceToAppliedProfiles.get(umlResource));
					}
				}

				if (Activator.log.isTraceEnabled(TRACE_INDEX)) {
					Activator.log.trace(TRACE_INDEX, "Forced index of intrinsically applied profiles for " + umlResource);
				}
			}
		}

		return result;
	}

	<V> ListenableFuture<V> afterIndex(Callable<V> callable) {
		return index.afterIndex(callable);
	}

	private void runIndexHandler(IFile file, URI resourceURI, DefaultHandler handler) {
		try (InputStream input = file.getContents()) {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			factory.setNamespaceAware(true);
			SAXParser parser = factory.newSAXParser();

			parser.parse(input, handler, resourceURI.toString());
		} catch (Exception e) {
			// We intentionally bomb out early with an exception
		}
	}

	private void indexDecoratorModel(IFile file) {
		final URI decoratorURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		ProfileIndexHandler handler = new ProfileIndexHandler(decoratorURI);

		runIndexHandler(file, decoratorURI, handler);

		synchronized (sync) {
			// first, remove all links to the decorator model
			for (URI next : decoratorToModels.get(decoratorURI)) {
				modelToDecorators.remove(next, decoratorURI);

				SetMultimap<URI, URI> decoratorMap = userModelToResourceToAppliedProfiles.get(next);
				if (decoratorMap != null) {
					decoratorMap.removeAll(decoratorURI);
				}
			}

			// update the forward mapping
			decoratorToModels.replaceValues(decoratorURI, handler.getReferencedModelURIs());

			// update the reverse mapping
			for (URI next : handler.getReferencedModelURIs()) {
				modelToDecorators.put(next, decoratorURI);
			}

			// remove all package links to the decorator model
			Map<URI, Map<URI, URI>> packageToProfileApplications = decoratorModelToPackageToProfileApplications.get(decoratorURI);
			if (packageToProfileApplications != null) {
				for (URI next : packageToProfileApplications.keySet()) {
					packageToDecoratorModels.remove(next, decoratorURI);
				}
			}

			// update the package links
			for (URI next : handler.getPackageToProfileApplications().keySet()) {
				packageToDecoratorModels.put(next, decoratorURI);
			}

			// and update the package-to-profiles-to-definitions index
			decoratorModelToPackageToProfileApplications.put(decoratorURI, handler.getPackageToProfileApplications());

			// and the externalization name index
			decoratorModelNames.put(decoratorURI, handler.getExternalizationName());

			// and the applied profiles by resource (external and internal)
			Set<URI> userModelsProcessed = Sets.newHashSet();
			for (Map.Entry<URI, Map<URI, URI>> next : handler.getPackageToProfileApplications().entrySet()) {
				URI userModelURI = next.getKey().trimFragment();
				if (userModelsProcessed.add(userModelURI)) {
					SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(userModelURI);
					if (resourceToAppliedProfiles == null) {
						resourceToAppliedProfiles = HashMultimap.create();
						userModelToResourceToAppliedProfiles.put(userModelURI, resourceToAppliedProfiles);
					}
					for (URI profileURI : next.getValue().keySet()) {
						resourceToAppliedProfiles.put(decoratorURI, profileURI);
					}
				}
			}
		}
	}

	private void unindexDecoratorModel(IFile file) {
		final URI decoratorURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		synchronized (sync) {
			// first, remove all links to the decorator model
			for (URI next : decoratorToModels.get(decoratorURI)) {
				modelToDecorators.remove(next, decoratorURI);

				SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(next);
				if (resourceToAppliedProfiles != null) {
					resourceToAppliedProfiles.removeAll(decoratorURI);
				}
			}

			// remove the forward mapping
			decoratorToModels.removeAll(decoratorURI);

			// remove from mapping of packages to decorator models
			Map<URI, Map<URI, URI>> packageToProfileApplications = decoratorModelToPackageToProfileApplications.get(decoratorURI);
			if (packageToProfileApplications != null) {
				for (URI next : packageToProfileApplications.keySet()) {
					packageToDecoratorModels.get(next).remove(decoratorURI);
				}
			}

			// remove the package-to-profiles index
			decoratorModelToPackageToProfileApplications.remove(decoratorURI);

			// and the name index
			decoratorModelNames.remove(decoratorURI);
		}
	}

	private void indexUserModel(IFile file) {
		final URI userModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		ModelIndexHandler handler = new ModelIndexHandler(userModelURI);

		runIndexHandler(file, userModelURI, handler);

		synchronized (sync) {
			// remove all internal profile applications of this resource
			SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(userModelURI);
			if (resourceToAppliedProfiles != null) {
				resourceToAppliedProfiles.removeAll(userModelURI);
			}

			// then add the applied profiles by resource (external and internal)
			for (Map<URI, URI> next : handler.getProfileApplicationsByPackage().values()) {
				if (resourceToAppliedProfiles == null) {
					resourceToAppliedProfiles = HashMultimap.create();
					userModelToResourceToAppliedProfiles.put(userModelURI, resourceToAppliedProfiles);
				}
				resourceToAppliedProfiles.putAll(userModelURI, next.keySet()); // This resource applies the profiles, itself
			}
		}
	}

	private void unindexUserModel(IFile file) {
		final URI userModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

		synchronized (sync) {
			// remove all internal profile applications of this resource
			SetMultimap<URI, URI> resourceToAppliedProfiles = userModelToResourceToAppliedProfiles.get(userModelURI);
			if (resourceToAppliedProfiles != null) {
				resourceToAppliedProfiles.removeAll(userModelURI);
			}
		}
	}

	private IndexHandler<DecoratorModelIndex> indexer() {
		return new IndexHandler<DecoratorModelIndex>() {
			@Override
			public DecoratorModelIndex index(IFile file) {
				if (DecoratorModelUtils.isDecoratorModel(file)) {
					DecoratorModelIndex.this.indexDecoratorModel(file);
				} else {
					DecoratorModelIndex.this.indexUserModel(file);
				}
				return DecoratorModelIndex.this;
			}

			@Override
			public void unindex(IFile file) {
				DecoratorModelIndex.this.unindexDecoratorModel(file);
				DecoratorModelIndex.this.unindexUserModel(file);
			}
		};
	}

	public void addIndexListener(IDecoratorModelIndexListener listener) {
		listeners.addIfAbsent(listener);
	}

	public void removeIndexListener(IDecoratorModelIndexListener listener) {
		listeners.remove(listener);
	}

	protected final void notifyChanged() {
		if (!listeners.isEmpty()) {
			DecoratorModelIndexEvent event = new DecoratorModelIndexEvent(this, DecoratorModelIndexEvent.INDEX_CHANGED);
			for (IDecoratorModelIndexListener next : listeners) {
				try {
					next.indexChanged(event);
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in decorator model index listener.", e); //$NON-NLS-1$
				}
			}
		}
	}

	//
	// Nested types
	//

	abstract class SyncCallable<V> implements Callable<V> {
		@Override
		public final V call() throws Exception {
			synchronized (sync) {
				return doCall();
			}
		}

		protected abstract V doCall();
	}
}
