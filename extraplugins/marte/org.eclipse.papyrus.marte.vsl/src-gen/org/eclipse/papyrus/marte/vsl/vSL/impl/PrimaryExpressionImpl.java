/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.marte.vsl.vSL.PrimaryExpression;
import org.eclipse.papyrus.marte.vsl.vSL.SuffixExpression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.papyrus.marte.vsl.vSL.ValueSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primary Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl#getPrefix <em>Prefix</em>}</li>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.PrimaryExpressionImpl#getSuffix <em>Suffix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimaryExpressionImpl extends MinimalEObjectImpl.Container implements PrimaryExpression
{
	/**
	 * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getPrefix()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification prefix;

	/**
	 * The cached value of the '{@link #getSuffix() <em>Suffix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getSuffix()
	 * @generated
	 * @ordered
	 */
	protected SuffixExpression suffix;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected PrimaryExpressionImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return VSLPackage.Literals.PRIMARY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public ValueSpecification getPrefix()
	{
		return prefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetPrefix(ValueSpecification newPrefix, NotificationChain msgs)
	{
		ValueSpecification oldPrefix = prefix;
		prefix = newPrefix;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.PRIMARY_EXPRESSION__PREFIX, oldPrefix, newPrefix);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setPrefix(ValueSpecification newPrefix)
	{
		if (newPrefix != prefix)
		{
			NotificationChain msgs = null;
			if (prefix != null) {
				msgs = ((InternalEObject) prefix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.PRIMARY_EXPRESSION__PREFIX, null, msgs);
			}
			if (newPrefix != null) {
				msgs = ((InternalEObject) newPrefix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.PRIMARY_EXPRESSION__PREFIX, null, msgs);
			}
			msgs = basicSetPrefix(newPrefix, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.PRIMARY_EXPRESSION__PREFIX, newPrefix, newPrefix));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public SuffixExpression getSuffix()
	{
		return suffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetSuffix(SuffixExpression newSuffix, NotificationChain msgs)
	{
		SuffixExpression oldSuffix = suffix;
		suffix = newSuffix;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VSLPackage.PRIMARY_EXPRESSION__SUFFIX, oldSuffix, newSuffix);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void setSuffix(SuffixExpression newSuffix)
	{
		if (newSuffix != suffix)
		{
			NotificationChain msgs = null;
			if (suffix != null) {
				msgs = ((InternalEObject) suffix).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VSLPackage.PRIMARY_EXPRESSION__SUFFIX, null, msgs);
			}
			if (newSuffix != null) {
				msgs = ((InternalEObject) newSuffix).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VSLPackage.PRIMARY_EXPRESSION__SUFFIX, null, msgs);
			}
			msgs = basicSetSuffix(newSuffix, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		}
		else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, VSLPackage.PRIMARY_EXPRESSION__SUFFIX, newSuffix, newSuffix));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EObject getFilteredParentRule(final EClass filter)
	{
		return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Type getExpectedType()
	{
		return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Element getContextElement()
	{
		return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
		case VSLPackage.PRIMARY_EXPRESSION__PREFIX:
			return basicSetPrefix(null, msgs);
		case VSLPackage.PRIMARY_EXPRESSION__SUFFIX:
			return basicSetSuffix(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case VSLPackage.PRIMARY_EXPRESSION__PREFIX:
			return getPrefix();
		case VSLPackage.PRIMARY_EXPRESSION__SUFFIX:
			return getSuffix();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case VSLPackage.PRIMARY_EXPRESSION__PREFIX:
			setPrefix((ValueSpecification) newValue);
			return;
		case VSLPackage.PRIMARY_EXPRESSION__SUFFIX:
			setSuffix((SuffixExpression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case VSLPackage.PRIMARY_EXPRESSION__PREFIX:
			setPrefix((ValueSpecification) null);
			return;
		case VSLPackage.PRIMARY_EXPRESSION__SUFFIX:
			setSuffix((SuffixExpression) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case VSLPackage.PRIMARY_EXPRESSION__PREFIX:
			return prefix != null;
		case VSLPackage.PRIMARY_EXPRESSION__SUFFIX:
			return suffix != null;
		}
		return super.eIsSet(featureID);
	}

} // PrimaryExpressionImpl
