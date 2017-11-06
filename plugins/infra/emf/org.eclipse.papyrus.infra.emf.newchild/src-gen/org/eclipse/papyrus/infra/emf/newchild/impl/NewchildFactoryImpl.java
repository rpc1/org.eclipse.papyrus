/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.emf.newchild.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.emf.newchild.CustomFiller;
import org.eclipse.papyrus.infra.emf.newchild.Menu;
import org.eclipse.papyrus.infra.emf.newchild.MenuAction;
import org.eclipse.papyrus.infra.emf.newchild.MenuGroup;
import org.eclipse.papyrus.infra.emf.newchild.MenuPosition;
import org.eclipse.papyrus.infra.emf.newchild.MenuRoot;
import org.eclipse.papyrus.infra.emf.newchild.NewchildConfiguration;
import org.eclipse.papyrus.infra.emf.newchild.NewchildFactory;
import org.eclipse.papyrus.infra.emf.newchild.NewchildPackage;
import org.eclipse.papyrus.infra.emf.newchild.Separator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NewchildFactoryImpl extends EFactoryImpl implements NewchildFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static NewchildFactory init() {
		try {
			NewchildFactory theNewchildFactory = (NewchildFactory) EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/newchild");
			if (theNewchildFactory != null) {
				return theNewchildFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NewchildFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NewchildFactoryImpl() {
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
		case NewchildPackage.NEWCHILD_CONFIGURATION:
			return createNewchildConfiguration();
		case NewchildPackage.MENU_ROOT:
			return createMenuRoot();
		case NewchildPackage.MENU:
			return createMenu();
		case NewchildPackage.MENU_ACTION:
			return createMenuAction();
		case NewchildPackage.SEPARATOR:
			return createSeparator();
		case NewchildPackage.MENU_GROUP:
			return createMenuGroup();
		case NewchildPackage.CUSTOM_FILLER:
			return createCustomFiller();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case NewchildPackage.MENU_POSITION:
			return createMenuPositionFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case NewchildPackage.MENU_POSITION:
			return convertMenuPositionToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NewchildConfiguration createNewchildConfiguration() {
		NewchildConfigurationImpl newchildConfiguration = new NewchildConfigurationImpl();
		return newchildConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MenuRoot createMenuRoot() {
		MenuRootImpl menuRoot = new MenuRootImpl();
		return menuRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Menu createMenu() {
		MenuImpl menu = new MenuImpl();
		return menu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MenuAction createMenuAction() {
		MenuActionImpl menuAction = new MenuActionImpl();
		return menuAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Separator createSeparator() {
		SeparatorImpl separator = new SeparatorImpl();
		return separator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MenuGroup createMenuGroup() {
		MenuGroupImpl menuGroup = new MenuGroupImpl();
		return menuGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public CustomFiller createCustomFiller() {
		CustomFillerImpl customFiller = new CustomFillerImpl();
		return customFiller;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public MenuPosition createMenuPositionFromString(EDataType eDataType, String initialValue) {
		MenuPosition result = MenuPosition.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public String convertMenuPositionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NewchildPackage getNewchildPackage() {
		return (NewchildPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NewchildPackage getPackage() {
		return NewchildPackage.eINSTANCE;
	}

} // NewchildFactoryImpl
