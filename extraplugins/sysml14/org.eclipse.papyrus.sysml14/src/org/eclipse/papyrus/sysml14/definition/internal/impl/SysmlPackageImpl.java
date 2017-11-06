/**
 * Copyright (c) 2015 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.sysml14.definition.internal.impl;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.sysml14.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml14.activities.internal.impl.ActivitiesPackageImpl;
import org.eclipse.papyrus.sysml14.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml14.allocations.internal.impl.AllocationsPackageImpl;
import org.eclipse.papyrus.sysml14.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml14.blocks.internal.impl.BlocksPackageImpl;
import org.eclipse.papyrus.sysml14.constraintblocks.ConstraintblocksPackage;
import org.eclipse.papyrus.sysml14.constraintblocks.internal.impl.ConstraintblocksPackageImpl;
import org.eclipse.papyrus.sysml14.definition.SysmlFactory;
import org.eclipse.papyrus.sysml14.definition.SysmlPackage;
import org.eclipse.papyrus.sysml14.deprecatedelements.DeprecatedelementsPackage;
import org.eclipse.papyrus.sysml14.deprecatedelements.internal.impl.DeprecatedelementsPackageImpl;
import org.eclipse.papyrus.sysml14.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml14.modelelements.internal.impl.ModelelementsPackageImpl;
import org.eclipse.papyrus.sysml14.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml14.portandflows.internal.impl.PortandflowsPackageImpl;
import org.eclipse.papyrus.sysml14.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml14.requirements.internal.impl.RequirementsPackageImpl;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;

/**
 * An implementation of the model <b>Package</b>.
 */
public class SysmlPackageImpl extends EPackageImpl implements SysmlPackage {

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.sysml14.definition.SysmlPackage#eNS_URI
	 * @see #init()
	 * 
	 */
	private SysmlPackageImpl() {
		super(eNS_URI, SysmlFactory.eINSTANCE);
	}

	/**
	 * 
	 * 
	 * 
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SysmlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * 
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * 
	 */
	public static SysmlPackage init() {
		if (isInited) return (SysmlPackage)EPackage.Registry.INSTANCE.getEPackage(SysmlPackage.eNS_URI);

		// Obtain or create and register package
		SysmlPackageImpl thesysmlPackage = (SysmlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SysmlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SysmlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		BlocksPackageImpl theBlocksPackage = (BlocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI) instanceof BlocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI) : BlocksPackage.eINSTANCE);
		PortandflowsPackageImpl thePortandflowsPackage = (PortandflowsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI) instanceof PortandflowsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI) : PortandflowsPackage.eINSTANCE);
		ActivitiesPackageImpl theActivitiesPackage = (ActivitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivitiesPackage.eNS_URI) instanceof ActivitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivitiesPackage.eNS_URI) : ActivitiesPackage.eINSTANCE);
		ModelelementsPackageImpl theModelelementsPackage = (ModelelementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelelementsPackage.eNS_URI) instanceof ModelelementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelelementsPackage.eNS_URI) : ModelelementsPackage.eINSTANCE);
		ConstraintblocksPackageImpl theConstraintblocksPackage = (ConstraintblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintblocksPackage.eNS_URI) instanceof ConstraintblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintblocksPackage.eNS_URI) : ConstraintblocksPackage.eINSTANCE);
		AllocationsPackageImpl theAllocationsPackage = (AllocationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationsPackage.eNS_URI) instanceof AllocationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationsPackage.eNS_URI) : AllocationsPackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) : RequirementsPackage.eINSTANCE);
		DeprecatedelementsPackageImpl theDeprecatedelementsPackage = (DeprecatedelementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeprecatedelementsPackage.eNS_URI) instanceof DeprecatedelementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeprecatedelementsPackage.eNS_URI) : DeprecatedelementsPackage.eINSTANCE);

		// Create package meta-data objects
		thesysmlPackage.createPackageContents();
		theBlocksPackage.createPackageContents();
		thePortandflowsPackage.createPackageContents();
		theActivitiesPackage.createPackageContents();
		theModelelementsPackage.createPackageContents();
		theConstraintblocksPackage.createPackageContents();
		theAllocationsPackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theDeprecatedelementsPackage.createPackageContents();

		// Initialize created meta-data
		thesysmlPackage.initializePackageContents();
		theBlocksPackage.initializePackageContents();
		thePortandflowsPackage.initializePackageContents();
		theActivitiesPackage.initializePackageContents();
		theModelelementsPackage.initializePackageContents();
		theConstraintblocksPackage.initializePackageContents();
		theAllocationsPackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theDeprecatedelementsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thesysmlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SysmlPackage.eNS_URI, thesysmlPackage);
		return thesysmlPackage;
	}

	public SysmlFactory getSysmlFactory() {
		return (SysmlFactory)getEFactoryInstance();
	}

	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;	
	}

	/**
	 * 
	 * 
	 * 
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BlocksPackage theBlocksPackage = (BlocksPackage)EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI);
		PortandflowsPackage thePortandflowsPackage = (PortandflowsPackage)EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI);
		ActivitiesPackage theActivitiesPackage = (ActivitiesPackage)EPackage.Registry.INSTANCE.getEPackage(ActivitiesPackage.eNS_URI);
		ModelelementsPackage theModelelementsPackage = (ModelelementsPackage)EPackage.Registry.INSTANCE.getEPackage(ModelelementsPackage.eNS_URI);
		ConstraintblocksPackage theConstraintblocksPackage = (ConstraintblocksPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintblocksPackage.eNS_URI);
		AllocationsPackage theAllocationsPackage = (AllocationsPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationsPackage.eNS_URI);
		RequirementsPackage theRequirementsPackage = (RequirementsPackage)EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI);
		DeprecatedelementsPackage theDeprecatedelementsPackage = (DeprecatedelementsPackage)EPackage.Registry.INSTANCE.getEPackage(DeprecatedelementsPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theBlocksPackage);
		getESubpackages().add(thePortandflowsPackage);
		getESubpackages().add(theActivitiesPackage);
		getESubpackages().add(theModelelementsPackage);
		getESubpackages().add(theConstraintblocksPackage);
		getESubpackages().add(theAllocationsPackage);
		getESubpackages().add(theRequirementsPackage);
		getESubpackages().add(theDeprecatedelementsPackage);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML"; //$NON-NLS-1$	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "originalName", "SysML" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} 
