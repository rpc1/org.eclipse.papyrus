/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.expansion;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.AbstractRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.RepresentationKind;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
/**
 * 
 * This class is a generic EditpartProvider that is enable to associate controler to new notation element by reading an expansion model
 * See Requirement #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_010
 *
 */
public class ExpandEditPartProvider extends AbstractEditPartProvider {

	/**
	 * 
	 */
	private static final String DEBUG_PREFIX = "[EXPANSION_DIAGRAM]";
	//	private static final boolean DEBUG_EXPANSION = "true".equalsIgnoreCase(Platform.getDebugOption(
	//			"org.eclipse.papyrus.infra.gmfdiag.common/debug/expansion"));
	/** Map containing node view types supported by this provider */
	protected Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();

	/** Map containing edge view types supported by this provider */
	protected Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();

	private DiagramExpansionsRegistry diagramExpansionRegistry=null;

	/** Default constructor */
	public ExpandEditPartProvider() {
		super();
		this.diagramExpansionRegistry = DiagramExpansionSingleton.getInstance().getDiagramExpansionRegistry();

	}

	protected String getDiagramType(View currentView) {
		Diagram diagram=currentView.getDiagram();
		String currentDiagramType=null;
		ViewPrototype viewPrototype=org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils.getPrototype(diagram);
		if(viewPrototype!=null){
			currentDiagramType=viewPrototype.getLabel();
		}
		else{
			currentDiagramType=diagram.getType();
		}
		return currentDiagramType;
	}
	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 *
	 * @param operation
	 * @return
	 */
	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateGraphicEditPartOperation) {
			String currentDiagramType = getDiagramType(((IEditPartOperation) operation).getView());

			if ((currentDiagramType == null) || (diagramExpansionRegistry.getUsage(currentDiagramType)==null)) {
				return false;
			}

			if (operation instanceof CreateGraphicEditPartOperation) {
				View newView = ((IEditPartOperation) operation).getView();
				if (newView == null) {
					return false;
				}

				String graphicalType = newView.getType();
				Activator.log.trace(Activator.EXPANSION_TRACE,""+this.getClass().getName()+" view appears with the type "+graphicalType);

				if(diagramExpansionRegistry.mapChildreen.get(currentDiagramType).IDMap.get(graphicalType)!=null){
					return true;
				}
			}
		}
		return super.provides(operation);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider#createGraphicEditPart(org.eclipse.gmf.runtime.notation.View)
	 *
	 * @param view
	 * @return
	 */
	@Override
	public IGraphicalEditPart createGraphicEditPart(View view) {
		String currentDiagramType = getDiagramType(view);

		if ((currentDiagramType == null) || (diagramExpansionRegistry.getUsage(currentDiagramType)==null)) {
			return null;
		}


		String graphicalType = view.getType();
		Activator.log.trace(Activator.EXPANSION_TRACE,""+ this.getClass().getName()+" view appears with the type "+graphicalType);
		EObject eObject= diagramExpansionRegistry.mapChildreen.get(currentDiagramType).IDMap.get(graphicalType);
		Class editpartClass=null;
		String editpartQualifiedName=null;
		if(eObject instanceof AbstractRepresentation){
			editpartQualifiedName=((AbstractRepresentation)eObject).getEditPartQualifiedName();
			if( editpartQualifiedName!=null&& (!"".equals(editpartQualifiedName.trim()))){
				editpartClass=	ClassLoaderHelper.loadClass( editpartQualifiedName);
			}
			else{
				RepresentationKind  representationKind=((AbstractRepresentation)eObject).getKind();
				if(representationKind!=null){
					editpartQualifiedName=representationKind.getEditPartQualifiedName();
					if( editpartQualifiedName!=null){
						editpartClass=	ClassLoaderHelper.loadClass( editpartQualifiedName);
					}
				}
			}
		}
		IGraphicalEditPart graphicEditPart = createNewGraphicEditPart(editpartClass, new Object[] {view});
		if( graphicEditPart==null){
			String errorMessage= "The model expand does not reference an edit part for the element "+graphicalType;
			if( editpartQualifiedName!=null){
				errorMessage= "The editpart provide does not succed to find "+editpartQualifiedName+" class for the element "+graphicalType;
			}
			org.eclipse.papyrus.infra.gmfdiag.common.Activator.log.error(errorMessage, new NullPointerException(errorMessage));
		}
		return graphicEditPart;

	}


	/** 
	 * Return the appropriate constuctor for the cached editpart class. 
	 * @return a constructor (<tt>null</tt> if none could be found).
	 */
	private Constructor getCreationConstructor(Class editpartClass) {

		if (editpartClass != null) {
			Constructor[] consts = editpartClass.getConstructors();
			if (consts.length != 0)
				return consts[0];
		}
		return null;
	}
	/**
	 * Creates an editpart via reflection.
	 * @param constructorParams the editpart's constructor paramters.
	 */
	private IGraphicalEditPart createNewGraphicEditPart(Class editpartClass, Object[] constructorParams) {
		try {
			Constructor constructor = getCreationConstructor(editpartClass);

			return (constructor == null)? null : (IGraphicalEditPart) constructor.newInstance(constructorParams);
		} 
		catch (Throwable e) {
			String eMsg = NLS.bind(  
					DiagramUIMessages.AbstractEditPartProvider_new_graphicaleditpart_failed_ERROR_,
					editpartClass);
			Log.warning(DiagramUIPlugin.getInstance(), IStatus.WARNING, eMsg, e);
			return null;
		}
	}
}
