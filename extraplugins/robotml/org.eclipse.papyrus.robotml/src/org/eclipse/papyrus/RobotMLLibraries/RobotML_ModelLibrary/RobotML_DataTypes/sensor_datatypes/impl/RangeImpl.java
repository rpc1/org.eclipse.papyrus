/**
 */
package org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Range;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.Sensor_datatypesPackage;
import org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.std_datatypes.Header;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getULTRASOUND <em>ULTRASOUND</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getINFRARED <em>INFRARED</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getHeader <em>Header</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getRadiation_type <em>Radiation type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getField_of_view <em>Field of view</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getMin_range <em>Min range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getMax_range <em>Max range</em>}</li>
 *   <li>{@link org.eclipse.papyrus.RobotMLLibraries.RobotML_ModelLibrary.RobotML_DataTypes.sensor_datatypes.impl.RangeImpl#getRange <em>Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeImpl extends MinimalEObjectImpl.Container implements Range {
	/**
	 * The default value of the '{@link #getULTRASOUND() <em>ULTRASOUND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getULTRASOUND()
	 * @generated
	 * @ordered
	 */
	protected static final Object ULTRASOUND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getULTRASOUND() <em>ULTRASOUND</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getULTRASOUND()
	 * @generated
	 * @ordered
	 */
	protected Object ultrasound = ULTRASOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getINFRARED() <em>INFRARED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getINFRARED()
	 * @generated
	 * @ordered
	 */
	protected static final Object INFRARED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getINFRARED() <em>INFRARED</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getINFRARED()
	 * @generated
	 * @ordered
	 */
	protected Object infrared = INFRARED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHeader() <em>Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeader()
	 * @generated
	 * @ordered
	 */
	protected Header header;

	/**
	 * The default value of the '{@link #getRadiation_type() <em>Radiation type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadiation_type()
	 * @generated
	 * @ordered
	 */
	protected static final Object RADIATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRadiation_type() <em>Radiation type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRadiation_type()
	 * @generated
	 * @ordered
	 */
	protected Object radiation_type = RADIATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getField_of_view() <em>Field of view</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField_of_view()
	 * @generated
	 * @ordered
	 */
	protected static final Object FIELD_OF_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getField_of_view() <em>Field of view</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getField_of_view()
	 * @generated
	 * @ordered
	 */
	protected Object field_of_view = FIELD_OF_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin_range() <em>Min range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin_range()
	 * @generated
	 * @ordered
	 */
	protected static final Object MIN_RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMin_range() <em>Min range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin_range()
	 * @generated
	 * @ordered
	 */
	protected Object min_range = MIN_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax_range() <em>Max range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_range()
	 * @generated
	 * @ordered
	 */
	protected static final Object MAX_RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMax_range() <em>Max range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax_range()
	 * @generated
	 * @ordered
	 */
	protected Object max_range = MAX_RANGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected static final Object RANGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRange()
	 * @generated
	 * @ordered
	 */
	protected Object range = RANGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sensor_datatypesPackage.Literals.RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getULTRASOUND() {
		return ultrasound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setULTRASOUND(Object newULTRASOUND) {
		Object oldULTRASOUND = ultrasound;
		ultrasound = newULTRASOUND;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__ULTRASOUND, oldULTRASOUND, ultrasound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getINFRARED() {
		return infrared;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setINFRARED(Object newINFRARED) {
		Object oldINFRARED = infrared;
		infrared = newINFRARED;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__INFRARED, oldINFRARED, infrared));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHeader(Header newHeader, NotificationChain msgs) {
		Header oldHeader = header;
		header = newHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__HEADER, oldHeader, newHeader);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeader(Header newHeader) {
		if (newHeader != header) {
			NotificationChain msgs = null;
			if (header != null)
				msgs = ((InternalEObject)header).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.RANGE__HEADER, null, msgs);
			if (newHeader != null)
				msgs = ((InternalEObject)newHeader).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Sensor_datatypesPackage.RANGE__HEADER, null, msgs);
			msgs = basicSetHeader(newHeader, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__HEADER, newHeader, newHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRadiation_type() {
		return radiation_type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiation_type(Object newRadiation_type) {
		Object oldRadiation_type = radiation_type;
		radiation_type = newRadiation_type;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__RADIATION_TYPE, oldRadiation_type, radiation_type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getField_of_view() {
		return field_of_view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setField_of_view(Object newField_of_view) {
		Object oldField_of_view = field_of_view;
		field_of_view = newField_of_view;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW, oldField_of_view, field_of_view));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMin_range() {
		return min_range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin_range(Object newMin_range) {
		Object oldMin_range = min_range;
		min_range = newMin_range;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__MIN_RANGE, oldMin_range, min_range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getMax_range() {
		return max_range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax_range(Object newMax_range) {
		Object oldMax_range = max_range;
		max_range = newMax_range;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__MAX_RANGE, oldMax_range, max_range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRange() {
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRange(Object newRange) {
		Object oldRange = range;
		range = newRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sensor_datatypesPackage.RANGE__RANGE, oldRange, range));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Sensor_datatypesPackage.RANGE__HEADER:
				return basicSetHeader(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sensor_datatypesPackage.RANGE__ULTRASOUND:
				return getULTRASOUND();
			case Sensor_datatypesPackage.RANGE__INFRARED:
				return getINFRARED();
			case Sensor_datatypesPackage.RANGE__HEADER:
				return getHeader();
			case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
				return getRadiation_type();
			case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
				return getField_of_view();
			case Sensor_datatypesPackage.RANGE__MIN_RANGE:
				return getMin_range();
			case Sensor_datatypesPackage.RANGE__MAX_RANGE:
				return getMax_range();
			case Sensor_datatypesPackage.RANGE__RANGE:
				return getRange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Sensor_datatypesPackage.RANGE__ULTRASOUND:
				setULTRASOUND((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__INFRARED:
				setINFRARED((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__HEADER:
				setHeader((Header)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
				setRadiation_type((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
				setField_of_view((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__MIN_RANGE:
				setMin_range((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__MAX_RANGE:
				setMax_range((Object)newValue);
				return;
			case Sensor_datatypesPackage.RANGE__RANGE:
				setRange((Object)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Sensor_datatypesPackage.RANGE__ULTRASOUND:
				setULTRASOUND(ULTRASOUND_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__INFRARED:
				setINFRARED(INFRARED_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__HEADER:
				setHeader((Header)null);
				return;
			case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
				setRadiation_type(RADIATION_TYPE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
				setField_of_view(FIELD_OF_VIEW_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__MIN_RANGE:
				setMin_range(MIN_RANGE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__MAX_RANGE:
				setMax_range(MAX_RANGE_EDEFAULT);
				return;
			case Sensor_datatypesPackage.RANGE__RANGE:
				setRange(RANGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Sensor_datatypesPackage.RANGE__ULTRASOUND:
				return ULTRASOUND_EDEFAULT == null ? ultrasound != null : !ULTRASOUND_EDEFAULT.equals(ultrasound);
			case Sensor_datatypesPackage.RANGE__INFRARED:
				return INFRARED_EDEFAULT == null ? infrared != null : !INFRARED_EDEFAULT.equals(infrared);
			case Sensor_datatypesPackage.RANGE__HEADER:
				return header != null;
			case Sensor_datatypesPackage.RANGE__RADIATION_TYPE:
				return RADIATION_TYPE_EDEFAULT == null ? radiation_type != null : !RADIATION_TYPE_EDEFAULT.equals(radiation_type);
			case Sensor_datatypesPackage.RANGE__FIELD_OF_VIEW:
				return FIELD_OF_VIEW_EDEFAULT == null ? field_of_view != null : !FIELD_OF_VIEW_EDEFAULT.equals(field_of_view);
			case Sensor_datatypesPackage.RANGE__MIN_RANGE:
				return MIN_RANGE_EDEFAULT == null ? min_range != null : !MIN_RANGE_EDEFAULT.equals(min_range);
			case Sensor_datatypesPackage.RANGE__MAX_RANGE:
				return MAX_RANGE_EDEFAULT == null ? max_range != null : !MAX_RANGE_EDEFAULT.equals(max_range);
			case Sensor_datatypesPackage.RANGE__RANGE:
				return RANGE_EDEFAULT == null ? range != null : !RANGE_EDEFAULT.equals(range);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ULTRASOUND: ");
		result.append(ultrasound);
		result.append(", INFRARED: ");
		result.append(infrared);
		result.append(", radiation_type: ");
		result.append(radiation_type);
		result.append(", field_of_view: ");
		result.append(field_of_view);
		result.append(", min_range: ");
		result.append(min_range);
		result.append(", max_range: ");
		result.append(max_range);
		result.append(", range: ");
		result.append(range);
		result.append(')');
		return result.toString();
	}

} // RangeImpl
