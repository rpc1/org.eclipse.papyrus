/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.environment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.eastadl.EastadlPackage;
import org.eclipse.papyrus.eastadl.annex.AnnexPackage;
import org.eclipse.papyrus.eastadl.annex.attributequantificationconstraint.AttributequantificationconstraintPackage;
import org.eclipse.papyrus.eastadl.annex.attributequantificationconstraint.impl.AttributequantificationconstraintPackageImpl;
import org.eclipse.papyrus.eastadl.annex.behaviordescription.BehaviordescriptionPackage;
import org.eclipse.papyrus.eastadl.annex.behaviordescription.impl.BehaviordescriptionPackageImpl;
import org.eclipse.papyrus.eastadl.annex.computationconstraint.ComputationconstraintPackage;
import org.eclipse.papyrus.eastadl.annex.computationconstraint.impl.ComputationconstraintPackageImpl;
import org.eclipse.papyrus.eastadl.annex.impl.AnnexPackageImpl;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;
import org.eclipse.papyrus.eastadl.annex.needs.impl.NeedsPackageImpl;
import org.eclipse.papyrus.eastadl.annex.temporalconstraint.TemporalconstraintPackage;
import org.eclipse.papyrus.eastadl.annex.temporalconstraint.impl.TemporalconstraintPackageImpl;
import org.eclipse.papyrus.eastadl.behavior.BehaviorPackage;
import org.eclipse.papyrus.eastadl.behavior.impl.BehaviorPackageImpl;
import org.eclipse.papyrus.eastadl.dependability.DependabilityPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.ErrormodelPackage;
import org.eclipse.papyrus.eastadl.dependability.errormodel.impl.ErrormodelPackageImpl;
import org.eclipse.papyrus.eastadl.dependability.impl.DependabilityPackageImpl;
import org.eclipse.papyrus.eastadl.dependability.safetycase.SafetycasePackage;
import org.eclipse.papyrus.eastadl.dependability.safetycase.impl.SafetycasePackageImpl;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.SafetyconstraintsPackage;
import org.eclipse.papyrus.eastadl.dependability.safetyconstraints.impl.SafetyconstraintsPackageImpl;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.SafetyrequirementPackage;
import org.eclipse.papyrus.eastadl.dependability.safetyrequirement.impl.SafetyrequirementPackageImpl;
import org.eclipse.papyrus.eastadl.environment.ClampConnector;
import org.eclipse.papyrus.eastadl.environment.Environment;
import org.eclipse.papyrus.eastadl.environment.EnvironmentFactory;
import org.eclipse.papyrus.eastadl.environment.EnvironmentPackage;
import org.eclipse.papyrus.eastadl.genericconstraints.GenericconstraintsPackage;
import org.eclipse.papyrus.eastadl.genericconstraints.impl.GenericconstraintsPackageImpl;
import org.eclipse.papyrus.eastadl.impl.EastadlPackageImpl;
import org.eclipse.papyrus.eastadl.infrastructure.InfrastructurePackage;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.DatatypesPackageImpl;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.impl.ElementsPackageImpl;
import org.eclipse.papyrus.eastadl.infrastructure.impl.InfrastructurePackageImpl;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.userattributes.impl.UserattributesPackageImpl;
import org.eclipse.papyrus.eastadl.infrastructure.values.ValuesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.values.impl.ValuesPackageImpl;
import org.eclipse.papyrus.eastadl.requirements.RequirementsPackage;
import org.eclipse.papyrus.eastadl.requirements.impl.RequirementsPackageImpl;
import org.eclipse.papyrus.eastadl.requirements.usecases.UsecasesPackage;
import org.eclipse.papyrus.eastadl.requirements.usecases.impl.UsecasesPackageImpl;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.VerificationvalidationPackage;
import org.eclipse.papyrus.eastadl.requirements.verificationvalidation.impl.VerificationvalidationPackageImpl;
import org.eclipse.papyrus.eastadl.structure.StructurePackage;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.FeaturemodelingPackage;
import org.eclipse.papyrus.eastadl.structure.featuremodeling.impl.FeaturemodelingPackageImpl;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.FunctionmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.functionmodeling.impl.FunctionmodelingPackageImpl;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage;
import org.eclipse.papyrus.eastadl.structure.hardwaremodeling.impl.HardwaremodelingPackageImpl;
import org.eclipse.papyrus.eastadl.structure.impl.StructurePackageImpl;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.SystemmodelingPackage;
import org.eclipse.papyrus.eastadl.structure.systemmodeling.impl.SystemmodelingPackageImpl;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.VehiclefeaturemodelingPackage;
import org.eclipse.papyrus.eastadl.structure.vehiclefeaturemodeling.impl.VehiclefeaturemodelingPackageImpl;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;
import org.eclipse.papyrus.eastadl.timing.events.EventsPackage;
import org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl;
import org.eclipse.papyrus.eastadl.timing.impl.TimingPackageImpl;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl;
import org.eclipse.papyrus.eastadl.variability.VariabilityPackage;
import org.eclipse.papyrus.eastadl.variability.impl.VariabilityPackageImpl;
import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class EnvironmentPackageImpl extends EPackageImpl implements EnvironmentPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass environmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private EClass clampConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link EnvironmentPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EnvironmentPackage init() {
		if (isInited) {
			return (EnvironmentPackage) EPackage.Registry.INSTANCE.getEPackage(EnvironmentPackage.eNS_URI);
		}

		// Obtain or create and register package
		EnvironmentPackageImpl theEnvironmentPackage = (EnvironmentPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EnvironmentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EnvironmentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SysmlPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EastadlPackageImpl theEastadlPackage = (EastadlPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(EastadlPackage.eNS_URI) instanceof EastadlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EastadlPackage.eNS_URI) : EastadlPackage.eINSTANCE);
		VariabilityPackageImpl theVariabilityPackage = (VariabilityPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(VariabilityPackage.eNS_URI) instanceof VariabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VariabilityPackage.eNS_URI)
				: VariabilityPackage.eINSTANCE);
		InfrastructurePackageImpl theInfrastructurePackage = (InfrastructurePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI) instanceof InfrastructurePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(InfrastructurePackage.eNS_URI) : InfrastructurePackage.eINSTANCE);
		DatatypesPackageImpl theDatatypesPackage = (DatatypesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI) instanceof DatatypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DatatypesPackage.eNS_URI)
				: DatatypesPackage.eINSTANCE);
		UserattributesPackageImpl theUserattributesPackage = (UserattributesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UserattributesPackage.eNS_URI) instanceof UserattributesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UserattributesPackage.eNS_URI) : UserattributesPackage.eINSTANCE);
		ValuesPackageImpl theValuesPackage = (ValuesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(ValuesPackage.eNS_URI) instanceof ValuesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ValuesPackage.eNS_URI) : ValuesPackage.eINSTANCE);
		ElementsPackageImpl theElementsPackage = (ElementsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(ElementsPackage.eNS_URI) instanceof ElementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ElementsPackage.eNS_URI)
				: ElementsPackage.eINSTANCE);
		StructurePackageImpl theStructurePackage = (StructurePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI) instanceof StructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StructurePackage.eNS_URI)
				: StructurePackage.eINSTANCE);
		FunctionmodelingPackageImpl theFunctionmodelingPackage = (FunctionmodelingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(FunctionmodelingPackage.eNS_URI) instanceof FunctionmodelingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(FunctionmodelingPackage.eNS_URI) : FunctionmodelingPackage.eINSTANCE);
		FeaturemodelingPackageImpl theFeaturemodelingPackage = (FeaturemodelingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(FeaturemodelingPackage.eNS_URI) instanceof FeaturemodelingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(FeaturemodelingPackage.eNS_URI) : FeaturemodelingPackage.eINSTANCE);
		SystemmodelingPackageImpl theSystemmodelingPackage = (SystemmodelingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SystemmodelingPackage.eNS_URI) instanceof SystemmodelingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SystemmodelingPackage.eNS_URI) : SystemmodelingPackage.eINSTANCE);
		VehiclefeaturemodelingPackageImpl theVehiclefeaturemodelingPackage = (VehiclefeaturemodelingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(VehiclefeaturemodelingPackage.eNS_URI) instanceof VehiclefeaturemodelingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(VehiclefeaturemodelingPackage.eNS_URI)
				: VehiclefeaturemodelingPackage.eINSTANCE);
		HardwaremodelingPackageImpl theHardwaremodelingPackage = (HardwaremodelingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(HardwaremodelingPackage.eNS_URI) instanceof HardwaremodelingPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(HardwaremodelingPackage.eNS_URI) : HardwaremodelingPackage.eINSTANCE);
		DependabilityPackageImpl theDependabilityPackage = (DependabilityPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(DependabilityPackage.eNS_URI) instanceof DependabilityPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(DependabilityPackage.eNS_URI) : DependabilityPackage.eINSTANCE);
		SafetyrequirementPackageImpl theSafetyrequirementPackage = (SafetyrequirementPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SafetyrequirementPackage.eNS_URI) instanceof SafetyrequirementPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SafetyrequirementPackage.eNS_URI) : SafetyrequirementPackage.eINSTANCE);
		SafetyconstraintsPackageImpl theSafetyconstraintsPackage = (SafetyconstraintsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SafetyconstraintsPackage.eNS_URI) instanceof SafetyconstraintsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SafetyconstraintsPackage.eNS_URI) : SafetyconstraintsPackage.eINSTANCE);
		SafetycasePackageImpl theSafetycasePackage = (SafetycasePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SafetycasePackage.eNS_URI) instanceof SafetycasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafetycasePackage.eNS_URI)
				: SafetycasePackage.eINSTANCE);
		ErrormodelPackageImpl theErrormodelPackage = (ErrormodelPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(ErrormodelPackage.eNS_URI) instanceof ErrormodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ErrormodelPackage.eNS_URI)
				: ErrormodelPackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI)
				: RequirementsPackage.eINSTANCE);
		UsecasesPackageImpl theUsecasesPackage = (UsecasesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UsecasesPackage.eNS_URI) instanceof UsecasesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsecasesPackage.eNS_URI)
				: UsecasesPackage.eINSTANCE);
		VerificationvalidationPackageImpl theVerificationvalidationPackage = (VerificationvalidationPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(VerificationvalidationPackage.eNS_URI) instanceof VerificationvalidationPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(VerificationvalidationPackage.eNS_URI)
				: VerificationvalidationPackage.eINSTANCE);
		org.eclipse.papyrus.eastadl.requirements.requirements.impl.RequirementsPackageImpl theRequirementsPackage_1 = (org.eclipse.papyrus.eastadl.requirements.requirements.impl.RequirementsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(org.eclipse.papyrus.eastadl.requirements.requirements.RequirementsPackage.eNS_URI) instanceof org.eclipse.papyrus.eastadl.requirements.requirements.impl.RequirementsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(org.eclipse.papyrus.eastadl.requirements.requirements.RequirementsPackage.eNS_URI) : org.eclipse.papyrus.eastadl.requirements.requirements.RequirementsPackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI)
				: BehaviorPackage.eINSTANCE);
		TimingPackageImpl theTimingPackage = (TimingPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TimingPackage.eNS_URI) instanceof TimingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimingPackage.eNS_URI) : TimingPackage.eINSTANCE);
		TimingconstraintsPackageImpl theTimingconstraintsPackage = (TimingconstraintsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TimingconstraintsPackage.eNS_URI) instanceof TimingconstraintsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(TimingconstraintsPackage.eNS_URI) : TimingconstraintsPackage.eINSTANCE);
		EventsPackageImpl theEventsPackage = (EventsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
		AnnexPackageImpl theAnnexPackage = (AnnexPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(AnnexPackage.eNS_URI) instanceof AnnexPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnexPackage.eNS_URI) : AnnexPackage.eINSTANCE);
		NeedsPackageImpl theNeedsPackage = (NeedsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(NeedsPackage.eNS_URI) instanceof NeedsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NeedsPackage.eNS_URI) : NeedsPackage.eINSTANCE);
		BehaviordescriptionPackageImpl theBehaviordescriptionPackage = (BehaviordescriptionPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(BehaviordescriptionPackage.eNS_URI) instanceof BehaviordescriptionPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(BehaviordescriptionPackage.eNS_URI) : BehaviordescriptionPackage.eINSTANCE);
		AttributequantificationconstraintPackageImpl theAttributequantificationconstraintPackage = (AttributequantificationconstraintPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(AttributequantificationconstraintPackage.eNS_URI) instanceof AttributequantificationconstraintPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AttributequantificationconstraintPackage.eNS_URI)
				: AttributequantificationconstraintPackage.eINSTANCE);
		TemporalconstraintPackageImpl theTemporalconstraintPackage = (TemporalconstraintPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(TemporalconstraintPackage.eNS_URI) instanceof TemporalconstraintPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(TemporalconstraintPackage.eNS_URI) : TemporalconstraintPackage.eINSTANCE);
		ComputationconstraintPackageImpl theComputationconstraintPackage = (ComputationconstraintPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(ComputationconstraintPackage.eNS_URI) instanceof ComputationconstraintPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ComputationconstraintPackage.eNS_URI)
				: ComputationconstraintPackage.eINSTANCE);
		GenericconstraintsPackageImpl theGenericconstraintsPackage = (GenericconstraintsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(GenericconstraintsPackage.eNS_URI) instanceof GenericconstraintsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(GenericconstraintsPackage.eNS_URI) : GenericconstraintsPackage.eINSTANCE);

		// Create package meta-data objects
		theEnvironmentPackage.createPackageContents();
		theEastadlPackage.createPackageContents();
		theVariabilityPackage.createPackageContents();
		theInfrastructurePackage.createPackageContents();
		theDatatypesPackage.createPackageContents();
		theUserattributesPackage.createPackageContents();
		theValuesPackage.createPackageContents();
		theElementsPackage.createPackageContents();
		theStructurePackage.createPackageContents();
		theFunctionmodelingPackage.createPackageContents();
		theFeaturemodelingPackage.createPackageContents();
		theSystemmodelingPackage.createPackageContents();
		theVehiclefeaturemodelingPackage.createPackageContents();
		theHardwaremodelingPackage.createPackageContents();
		theDependabilityPackage.createPackageContents();
		theSafetyrequirementPackage.createPackageContents();
		theSafetyconstraintsPackage.createPackageContents();
		theSafetycasePackage.createPackageContents();
		theErrormodelPackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theUsecasesPackage.createPackageContents();
		theVerificationvalidationPackage.createPackageContents();
		theRequirementsPackage_1.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theTimingPackage.createPackageContents();
		theTimingconstraintsPackage.createPackageContents();
		theEventsPackage.createPackageContents();
		theAnnexPackage.createPackageContents();
		theNeedsPackage.createPackageContents();
		theBehaviordescriptionPackage.createPackageContents();
		theAttributequantificationconstraintPackage.createPackageContents();
		theTemporalconstraintPackage.createPackageContents();
		theComputationconstraintPackage.createPackageContents();
		theGenericconstraintsPackage.createPackageContents();

		// Initialize created meta-data
		theEnvironmentPackage.initializePackageContents();
		theEastadlPackage.initializePackageContents();
		theVariabilityPackage.initializePackageContents();
		theInfrastructurePackage.initializePackageContents();
		theDatatypesPackage.initializePackageContents();
		theUserattributesPackage.initializePackageContents();
		theValuesPackage.initializePackageContents();
		theElementsPackage.initializePackageContents();
		theStructurePackage.initializePackageContents();
		theFunctionmodelingPackage.initializePackageContents();
		theFeaturemodelingPackage.initializePackageContents();
		theSystemmodelingPackage.initializePackageContents();
		theVehiclefeaturemodelingPackage.initializePackageContents();
		theHardwaremodelingPackage.initializePackageContents();
		theDependabilityPackage.initializePackageContents();
		theSafetyrequirementPackage.initializePackageContents();
		theSafetyconstraintsPackage.initializePackageContents();
		theSafetycasePackage.initializePackageContents();
		theErrormodelPackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theUsecasesPackage.initializePackageContents();
		theVerificationvalidationPackage.initializePackageContents();
		theRequirementsPackage_1.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theTimingPackage.initializePackageContents();
		theTimingconstraintsPackage.initializePackageContents();
		theEventsPackage.initializePackageContents();
		theAnnexPackage.initializePackageContents();
		theNeedsPackage.initializePackageContents();
		theBehaviordescriptionPackage.initializePackageContents();
		theAttributequantificationconstraintPackage.initializePackageContents();
		theTemporalconstraintPackage.initializePackageContents();
		theComputationconstraintPackage.initializePackageContents();
		theGenericconstraintsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEnvironmentPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EnvironmentPackage.eNS_URI, theEnvironmentPackage);
		return theEnvironmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.eastadl.environment.EnvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EnvironmentPackageImpl() {
		super(eNS_URI, EnvironmentFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		environmentEClass = createEClass(ENVIRONMENT);
		createEReference(environmentEClass, ENVIRONMENT__ENVIRONMENT_MODEL);
		createEReference(environmentEClass, ENVIRONMENT__CLAMP_CONNECTOR);
		createEReference(environmentEClass, ENVIRONMENT__BASE_CLASS);
		createEReference(environmentEClass, ENVIRONMENT__BASE_PACKAGE);

		clampConnectorEClass = createEClass(CLAMP_CONNECTOR);
		createEReference(clampConnectorEClass, CLAMP_CONNECTOR__BASE_CONNECTOR);
		createEReference(clampConnectorEClass, CLAMP_CONNECTOR__PORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getClampConnector() {
		return clampConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getClampConnector_Port() {
		return (EReference) clampConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getClampConnector_Base_Connector() {
		return (EReference) clampConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EClass getEnvironment() {
		return environmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEnvironment_ClampConnector() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEnvironment_Base_Class() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEnvironment_Base_Package() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EReference getEnvironment_EnvironmentModel() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EnvironmentFactory getEnvironmentFactory() {
		return (EnvironmentFactory) getEFactoryInstance();
	}

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ElementsPackage theElementsPackage = (ElementsPackage) EPackage.Registry.INSTANCE.getEPackage(ElementsPackage.eNS_URI);
		FunctionmodelingPackage theFunctionmodelingPackage = (FunctionmodelingPackage) EPackage.Registry.INSTANCE.getEPackage(FunctionmodelingPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage) EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		InfrastructurePackage theInfrastructurePackage = (InfrastructurePackage) EPackage.Registry.INSTANCE.getEPackage(InfrastructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		environmentEClass.getESuperTypes().add(theElementsPackage.getContext());
		clampConnectorEClass.getESuperTypes().add(theElementsPackage.getEAElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnvironment_EnvironmentModel(), theFunctionmodelingPackage.getFunctionPrototype(), null, "environmentModel", null, 0, 1, Environment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getEnvironment_ClampConnector(), this.getClampConnector(), null, "clampConnector", null, 0, -1, Environment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED,
				!IS_ORDERED);
		initEReference(getEnvironment_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getEnvironment_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 0, 1, Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);

		initEClass(clampConnectorEClass, ClampConnector.class, "ClampConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClampConnector_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, ClampConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
		initEReference(getClampConnector_Port(), theInfrastructurePackage.getClampConnectorInstanceRef(), null, "port", null, 2, 2, ClampConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);
	}

} // EnvironmentPackageImpl