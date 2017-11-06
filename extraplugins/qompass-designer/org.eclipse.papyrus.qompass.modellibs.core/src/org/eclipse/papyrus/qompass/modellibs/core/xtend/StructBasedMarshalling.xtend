package org.eclipse.papyrus.qompass.modellibs.core.xtend

import org.eclipse.uml2.uml.Operation
import static extension org.eclipse.papyrus.qompass.designer.core.UMLTool.*
import static extension org.eclipse.papyrus.qompass.modellibs.core.xtend.CppUtils.cppType

// TODO: original model code does effectively do more than marshalling
class StructBasedMarshalling {
	def static marshall(Operation operation) '''
		struct ParamData {
			«FOR parameter : operation.parametersInInout»
				«parameter.type.cppType» «parameter.name»;
			«ENDFOR»
		};
		Event event;
		event.ID = [operation.name/];
		event.kind = CallEvent;
		ParamData * data = &event.params;
		«FOR parameter : operation.parametersInInout»
		data->[parameter.name/] = [parameter.name/];
		«ENDFOR»
		out->dispatch(event);
	'''
	
}