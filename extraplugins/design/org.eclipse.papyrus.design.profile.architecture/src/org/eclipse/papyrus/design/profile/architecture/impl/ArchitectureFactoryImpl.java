/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.design.profile.architecture.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.design.profile.architecture.ArchitectureFactory;
import org.eclipse.papyrus.design.profile.architecture.ArchitecturePackage;
import org.eclipse.papyrus.design.profile.architecture.Layer;
import org.eclipse.papyrus.design.profile.architecture.LayerDependency;
import org.eclipse.papyrus.design.profile.architecture.Plugin;
import org.eclipse.papyrus.design.profile.architecture.Project;
import org.eclipse.papyrus.design.profile.architecture.ProjectDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ArchitectureFactoryImpl extends EFactoryImpl implements ArchitectureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static ArchitectureFactory init() {
		try {
			ArchitectureFactory theArchitectureFactory = (ArchitectureFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/design/architecture/1");
			if (theArchitectureFactory != null) {
				return theArchitectureFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ArchitectureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public ArchitectureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ArchitecturePackage.LAYER:
			return createLayer();
		case ArchitecturePackage.LAYER_DEPENDENCY:
			return createLayerDependency();
		case ArchitecturePackage.PLUGIN:
			return createPlugin();
		case ArchitecturePackage.PROJECT:
			return createProject();
		case ArchitecturePackage.PROJECT_DEPENDENCY:
			return createProjectDependency();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Layer createLayer() {
		LayerImpl layer = new LayerImpl();
		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public LayerDependency createLayerDependency() {
		LayerDependencyImpl layerDependency = new LayerDependencyImpl();
		return layerDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Plugin createPlugin() {
		PluginImpl plugin = new PluginImpl();
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ProjectDependency createProjectDependency() {
		ProjectDependencyImpl projectDependency = new ProjectDependencyImpl();
		return projectDependency;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ArchitecturePackage getArchitecturePackage() {
		return (ArchitecturePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ArchitecturePackage getPackage() {
		return ArchitecturePackage.eINSTANCE;
	}

} // ArchitectureFactoryImpl
