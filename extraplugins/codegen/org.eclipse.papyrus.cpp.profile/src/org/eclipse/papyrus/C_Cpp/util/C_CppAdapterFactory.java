/**
 * Copyright (c) 2013 CEA LIST
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    CEA LIST - Initial API and implementation
 *
 */
package org.eclipse.papyrus.C_Cpp.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.C_Cpp.Array;
import org.eclipse.papyrus.C_Cpp.C_CppPackage;
import org.eclipse.papyrus.C_Cpp.Const;
import org.eclipse.papyrus.C_Cpp.ConstInit;
import org.eclipse.papyrus.C_Cpp.CppInit;
import org.eclipse.papyrus.C_Cpp.CppRoot;
import org.eclipse.papyrus.C_Cpp.ExternLibrary;
import org.eclipse.papyrus.C_Cpp.External;
import org.eclipse.papyrus.C_Cpp.Friend;
import org.eclipse.papyrus.C_Cpp.Include;
import org.eclipse.papyrus.C_Cpp.Inline;
import org.eclipse.papyrus.C_Cpp.ManualGeneration;
import org.eclipse.papyrus.C_Cpp.NoCodeGen;
import org.eclipse.papyrus.C_Cpp.Ptr;
import org.eclipse.papyrus.C_Cpp.Ref;
import org.eclipse.papyrus.C_Cpp.StorageClass;
import org.eclipse.papyrus.C_Cpp.Template;
import org.eclipse.papyrus.C_Cpp.TemplateBinding;
import org.eclipse.papyrus.C_Cpp.TemplateParameter;
import org.eclipse.papyrus.C_Cpp.Typedef;
import org.eclipse.papyrus.C_Cpp.Union;
import org.eclipse.papyrus.C_Cpp.Virtual;
import org.eclipse.papyrus.C_Cpp.Visibility;
import org.eclipse.papyrus.C_Cpp.Volatile;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage
 * @generated
 */
public class C_CppAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static C_CppPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public C_CppAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = C_CppPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected C_CppSwitch<Adapter> modelSwitch =
			new C_CppSwitch<Adapter>() {
			@Override
			public Adapter casePtr(Ptr object) {
				return createPtrAdapter();
			}
			@Override
			public Adapter caseInclude(Include object) {
				return createIncludeAdapter();
			}
			@Override
			public Adapter caseManualGeneration(ManualGeneration object) {
				return createManualGenerationAdapter();
			}
			@Override
			public Adapter caseExternLibrary(ExternLibrary object) {
				return createExternLibraryAdapter();
			}
			@Override
			public Adapter caseNoCodeGen(NoCodeGen object) {
				return createNoCodeGenAdapter();
			}
			@Override
			public Adapter caseCppRoot(CppRoot object) {
				return createCppRootAdapter();
			}
			@Override
			public Adapter caseArray(Array object) {
				return createArrayAdapter();
			}
			@Override
			public Adapter caseConst(Const object) {
				return createConstAdapter();
			}
			@Override
			public Adapter caseRef(Ref object) {
				return createRefAdapter();
			}
			@Override
			public Adapter caseExternal(External object) {
				return createExternalAdapter();
			}
			@Override
			public Adapter caseConstInit(ConstInit object) {
				return createConstInitAdapter();
			}
			@Override
			public Adapter caseFriend(Friend object) {
				return createFriendAdapter();
			}
			@Override
			public Adapter caseInline(Inline object) {
				return createInlineAdapter();
			}
			@Override
			public Adapter caseVirtual(Virtual object) {
				return createVirtualAdapter();
			}
			@Override
			public Adapter caseTypedef(Typedef object) {
				return createTypedefAdapter();
			}
			@Override
			public Adapter caseVisibility(Visibility object) {
				return createVisibilityAdapter();
			}
			@Override
			public Adapter caseCppInit(CppInit object) {
				return createCppInitAdapter();
			}
			@Override
			public Adapter caseTemplate(Template object) {
				return createTemplateAdapter();
			}
			@Override
			public Adapter caseTemplateBinding(TemplateBinding object) {
				return createTemplateBindingAdapter();
			}
			@Override
			public Adapter caseTemplateParameter(TemplateParameter object) {
				return createTemplateParameterAdapter();
			}
			@Override
			public Adapter caseUnion(Union object) {
				return createUnionAdapter();
			}
			@Override
			public Adapter caseStorageClass(StorageClass object) {
				return createStorageClassAdapter();
			}
			@Override
			public Adapter caseVolatile(Volatile object) {
				return createVolatileAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Ptr <em>Ptr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Ptr
	 * @generated
	 */
	public Adapter createPtrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Include <em>Include</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Include
	 * @generated
	 */
	public Adapter createIncludeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.ManualGeneration <em>Manual Generation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.ManualGeneration
	 * @generated
	 */
	public Adapter createManualGenerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.ExternLibrary <em>Extern Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.ExternLibrary
	 * @generated
	 */
	public Adapter createExternLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.NoCodeGen <em>No Code Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.NoCodeGen
	 * @generated
	 */
	public Adapter createNoCodeGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.CppRoot <em>Cpp Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.CppRoot
	 * @generated
	 */
	public Adapter createCppRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Array <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Array
	 * @generated
	 */
	public Adapter createArrayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Const <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Const
	 * @generated
	 */
	public Adapter createConstAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Ref <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Ref
	 * @generated
	 */
	public Adapter createRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.External <em>External</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.External
	 * @generated
	 */
	public Adapter createExternalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.ConstInit <em>Const Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.ConstInit
	 * @generated
	 */
	public Adapter createConstInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Friend <em>Friend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Friend
	 * @generated
	 */
	public Adapter createFriendAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Inline <em>Inline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Inline
	 * @generated
	 */
	public Adapter createInlineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Virtual <em>Virtual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Virtual
	 * @generated
	 */
	public Adapter createVirtualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Typedef <em>Typedef</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Typedef
	 * @generated
	 */
	public Adapter createTypedefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Visibility
	 * @generated
	 */
	public Adapter createVisibilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.CppInit <em>Cpp Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.CppInit
	 * @generated
	 */
	public Adapter createCppInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Template
	 * @generated
	 */
	public Adapter createTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.TemplateBinding <em>Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateBinding
	 * @generated
	 */
	public Adapter createTemplateBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.TemplateParameter <em>Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.TemplateParameter
	 * @generated
	 */
	public Adapter createTemplateParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Union <em>Union</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Union
	 * @generated
	 */
	public Adapter createUnionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.StorageClass <em>Storage Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.StorageClass
	 * @generated
	 */
	public Adapter createStorageClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.papyrus.C_Cpp.Volatile <em>Volatile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.papyrus.C_Cpp.Volatile
	 * @generated
	 */
	public Adapter createVolatileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // C_CppAdapterFactory
