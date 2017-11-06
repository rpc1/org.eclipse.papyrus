/**
 */
package org.eclipse.papyrus.marte.vsl.vSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.marte.vsl.vSL.EqualityExpression;
import org.eclipse.papyrus.marte.vsl.vSL.RelationalExpression;
import org.eclipse.papyrus.marte.vsl.vSL.VSLPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Equality Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl#getExp <em>Exp</em>}</li>
 * <li>{@link org.eclipse.papyrus.marte.vsl.vSL.impl.EqualityExpressionImpl#getOp <em>Op</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EqualityExpressionImpl extends MinimalEObjectImpl.Container implements EqualityExpression
{
	/**
	 * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getExp()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationalExpression> exp;

	/**
	 * The cached value of the '{@link #getOp() <em>Op</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getOp()
	 * @generated
	 * @ordered
	 */
	protected EList<String> op;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EqualityExpressionImpl()
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
		return VSLPackage.Literals.EQUALITY_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<RelationalExpression> getExp()
	{
		if (exp == null)
		{
			exp = new EObjectContainmentEList<RelationalExpression>(RelationalExpression.class, this, VSLPackage.EQUALITY_EXPRESSION__EXP);
		}
		return exp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<String> getOp()
	{
		if (op == null)
		{
			op = new EDataTypeEList<String>(String.class, this, VSLPackage.EQUALITY_EXPRESSION__OP);
		}
		return op;
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
		case VSLPackage.EQUALITY_EXPRESSION__EXP:
			return ((InternalEList<?>) getExp()).basicRemove(otherEnd, msgs);
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
		case VSLPackage.EQUALITY_EXPRESSION__EXP:
			return getExp();
		case VSLPackage.EQUALITY_EXPRESSION__OP:
			return getOp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case VSLPackage.EQUALITY_EXPRESSION__EXP:
			getExp().clear();
			getExp().addAll((Collection<? extends RelationalExpression>) newValue);
			return;
		case VSLPackage.EQUALITY_EXPRESSION__OP:
			getOp().clear();
			getOp().addAll((Collection<? extends String>) newValue);
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
		case VSLPackage.EQUALITY_EXPRESSION__EXP:
			getExp().clear();
			return;
		case VSLPackage.EQUALITY_EXPRESSION__OP:
			getOp().clear();
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
		case VSLPackage.EQUALITY_EXPRESSION__EXP:
			return exp != null && !exp.isEmpty();
		case VSLPackage.EQUALITY_EXPRESSION__OP:
			return op != null && !op.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (op: ");
		result.append(op);
		result.append(')');
		return result.toString();
	}

} // EqualityExpressionImpl
