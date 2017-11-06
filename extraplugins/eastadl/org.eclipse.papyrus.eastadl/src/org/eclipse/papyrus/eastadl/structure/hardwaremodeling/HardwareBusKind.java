/**
 */
package org.eclipse.papyrus.eastadl.structure.hardwaremodeling;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Hardware Bus Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * LogicalBusKind is an enumeration type representing different kinds of busses.
 *
 * Extension:
 * Enumeration, no extension.
 * <!-- end-model-doc -->
 *
 * @see org.eclipse.papyrus.eastadl.structure.hardwaremodeling.HardwaremodelingPackage#getHardwareBusKind()
 * @model
 * @generated
 */
public enum HardwareBusKind implements Enumerator {
	/**
	 * The '<em><b>Time Triggered</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #TIME_TRIGGERED_VALUE
	 * @generated
	 * @ordered
	 */
	TIME_TRIGGERED(0, "TimeTriggered", "TimeTriggered"),

	/**
	 * The '<em><b>Event Triggered</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #EVENT_TRIGGERED_VALUE
	 * @generated
	 * @ordered
	 */
	EVENT_TRIGGERED(1, "EventTriggered", "EventTriggered"),

	/**
	 * The '<em><b>Timeand Event Triggered</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #TIMEAND_EVENT_TRIGGERED_VALUE
	 * @generated
	 * @ordered
	 */
	TIMEAND_EVENT_TRIGGERED(2, "TimeandEventTriggered", "TimeandEventTriggered"),

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #OTHER_VALUE
	 * @generated
	 * @ordered
	 */
	OTHER(3, "other", "other");

	/**
	 * The '<em><b>Time Triggered</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bus is time-triggered
	 * <!-- end-model-doc -->
	 *
	 * @see #TIME_TRIGGERED
	 * @model name="TimeTriggered"
	 * @generated
	 * @ordered
	 */
	public static final int TIME_TRIGGERED_VALUE = 0;

	/**
	 * The '<em><b>Event Triggered</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bus is event-triggered
	 * <!-- end-model-doc -->
	 *
	 * @see #EVENT_TRIGGERED
	 * @model name="EventTriggered"
	 * @generated
	 * @ordered
	 */
	public static final int EVENT_TRIGGERED_VALUE = 1;

	/**
	 * The '<em><b>Timeand Event Triggered</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Bus is both time and event-triggered
	 * <!-- end-model-doc -->
	 *
	 * @see #TIMEAND_EVENT_TRIGGERED
	 * @model name="TimeandEventTriggered"
	 * @generated
	 * @ordered
	 */
	public static final int TIMEAND_EVENT_TRIGGERED_VALUE = 2;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Another type of bus communication
	 * <!-- end-model-doc -->
	 *
	 * @see #OTHER
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER_VALUE = 3;

	/**
	 * An array of all the '<em><b>Hardware Bus Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private static final HardwareBusKind[] VALUES_ARRAY =
			new HardwareBusKind[] {
					TIME_TRIGGERED,
					EVENT_TRIGGERED,
					TIMEAND_EVENT_TRIGGERED,
					OTHER,
			};

	/**
	 * A public read-only list of all the '<em><b>Hardware Bus Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static final List<HardwareBusKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Hardware Bus Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static HardwareBusKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HardwareBusKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hardware Bus Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static HardwareBusKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HardwareBusKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hardware Bus Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public static HardwareBusKind get(int value) {
		switch (value) {
		case TIME_TRIGGERED_VALUE:
			return TIME_TRIGGERED;
		case EVENT_TRIGGERED_VALUE:
			return EVENT_TRIGGERED;
		case TIMEAND_EVENT_TRIGGERED_VALUE:
			return TIMEAND_EVENT_TRIGGERED;
		case OTHER_VALUE:
			return OTHER;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	private HardwareBusKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // HardwareBusKind