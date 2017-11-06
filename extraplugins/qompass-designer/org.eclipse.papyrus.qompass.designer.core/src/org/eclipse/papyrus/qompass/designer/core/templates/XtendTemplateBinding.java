package org.eclipse.papyrus.qompass.designer.core.templates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.papyrus.qompass.designer.core.Messages;
import org.eclipse.papyrus.qompass.designer.core.extensions.IXtend;
import org.eclipse.papyrus.qompass.designer.core.extensions.XtendGenerator;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.uml2.uml.Element;

public class XtendTemplateBinding {

	public static final String XTEND_MAGIC = "!xtend"; //$NON-NLS-1$

	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 *
	 * @param template
	 *            The template in string form
	 * @param element
	 *            The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element) throws TransformationException {
		return bind(templateStr, element, null);
	}
	
	/**
	 * Execute a script passed as parameter. It will be executed in the context
	 * of a base script that declares the meta-model (UML2) and has additional
	 * imports (currently none).
	 *
	 * @param template
	 *            The template in string form
	 * @param element
	 *            The UML element to which the template is applied
	 * @return the evaluated template
	 */
	public static String bind(String templateStr, Element element, Object args[]) throws TransformationException {
		String[] templateRef = templateStr.substring(XTEND_MAGIC.length() + 1).split("\\."); //$NON-NLS-1$
		String templateId = templateRef[0].trim();
		String methodName = templateRef[1].trim();
		IXtend generator = XtendGenerator.getXtendGenerator(templateId);
		if (generator == null) {
			throw new TransformationException(String.format(Messages.XtendTemplateBinding_TemplateNotFound, templateId, methodName));
		}
		
		try {
			Object result;
			if (args != null) {
				Method method = getMethod(generator, methodName, 1+args.length);
				result = method.invoke(generator, element, args);
			}
			else {
				Method method = getMethod(generator, methodName, 1);
				result = method.invoke(generator, element);
			}
			if (result instanceof String) {
				return (String) result;
			}
			else if (result instanceof CharSequence) {
				return result.toString();
			}
			else {
				throw new TransformationException(Messages.XtendTemplateBinding_TemplateResultIsNotAString);
			}
		} catch (SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NullPointerException e) {
			throw new TransformationException(e.getMessage());
		}
	}
	
	public static Method getMethod(IXtend generator, String methodName, int numberOfArguments) {
		for (Method method : generator.getClass().getMethods()) {
			if (method.getName().equals(methodName) && method.getParameterTypes().length == numberOfArguments) {
				return method;
			}
		}
		return null;
	}
}
