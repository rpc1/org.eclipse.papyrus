/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.expansion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.AbstractRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.GMFT_BasedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.InducedRepresentation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation;
import org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.UseContext;

/**
 * This class is a structure that is adapted for the code of provider not to describe compartments as the model
 *  it satisfy #Req org.eclipse.papyrus.infra.gmfdiag.expansion.Req_060
 *
 */
public class ChildrenListRepresentation {

	/**
	 * 
	 */
	private static final String DEBUG_PREFIX = "[EXPANSION_DIAGRAM]";
	public HashMap<String, AbstractRepresentation> IDMap=new HashMap<String, AbstractRepresentation>();
	public HashMap<String, List<String>> parentChildrenRelation= new HashMap<String, List<String>>();

	protected UseContext useContext;
	/**
	 * Constructor.
	 *
	 */
	public ChildrenListRepresentation(UseContext useContext) {
		this.useContext=useContext;
		initStructure();
	}

	protected void createStructure(AbstractRepresentation representation, ArrayList<String> idListToAdd){

		if( representation instanceof Representation) {
			String hint=null;
			if( representation instanceof GMFT_BasedRepresentation){
				hint=((GMFT_BasedRepresentation)representation).getReusedID();

			}else{
				final IElementType elementType=ElementTypeRegistry.getInstance().getType(((Representation)representation).getGraphicalElementType());
				if( elementType instanceof IHintedType){
					hint=(((IHintedType)elementType).getSemanticHint());
				}
			}
			idListToAdd.add(hint);
			if( IDMap.get(hint)==null){
				IDMap.put(hint, representation);
				ArrayList<String> subRepresentationIDs= new ArrayList<String>();
				//compartments
				for (InducedRepresentation compartments : ((Representation)representation).getInducedRepresentations()) {
					createStructure(compartments, subRepresentationIDs);
				}
				//subRepresentation as port...
				for (Representation subRepresentation : ((Representation)representation).getSubRepresentations()) {
					createStructure(subRepresentation, subRepresentationIDs);
				}
				if( subRepresentationIDs.size()>0){
					parentChildrenRelation.put(hint, subRepresentationIDs);
				}
			}
		}
		else if( representation instanceof InducedRepresentation){
			idListToAdd.add(((InducedRepresentation) representation).getHint());
			if( IDMap.get(((InducedRepresentation) representation).getHint())==null){
				IDMap.put(((InducedRepresentation) representation).getHint(), representation);
				ArrayList<String> compartmentChildreen= new ArrayList<String>();
				for (Representation subRepresentation : ((InducedRepresentation)representation).getChildren()) {
					createStructure(subRepresentation, compartmentChildreen);
				}
				if( compartmentChildreen.size()>0){
					parentChildrenRelation.put(((InducedRepresentation) representation).getHint(), compartmentChildreen);
				}
			} 
		}
	}

	protected void initStructure(){

		//init the structure by go accross the the model.
		ArrayList<String> childreen= new ArrayList<String>();
		for ( org.eclipse.papyrus.infra.gmfdiag.common.expansionmodel.Representation currentR : useContext.getRepresentations()) {
			//Check shapes
			createStructure(currentR, childreen);
		}
		parentChildrenRelation.put(useContext.getDiagramType(), childreen);

	}
	/**
	 * @see java.lang.Object#toString()
	 *
	 * @return
	 */
	@Override
	public String toString() {
		String out=      DEBUG_PREFIX+"+ChildrenListRepresentation for "+useContext.getDiagramType();
		out=out+    "\n"+DEBUG_PREFIX+"+-->ID - Representation";
		for (String currentID : IDMap.keySet()) {
			out=out+"\n"+DEBUG_PREFIX+"    \""+currentID+ "\" "+IDMap.get(currentID);
		}
		out=out+    "\n"+DEBUG_PREFIX+"+--> ParentID- ChildrenIDs";
		for (String currentID : parentChildrenRelation.keySet()) {
			out=out+"\n"+DEBUG_PREFIX+"    \""+currentID+ "\" "+parentChildrenRelation.get(currentID);
		}
		return out;
	}
}
