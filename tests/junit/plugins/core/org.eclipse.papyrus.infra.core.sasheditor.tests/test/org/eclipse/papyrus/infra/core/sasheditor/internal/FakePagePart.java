/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * A Page part for testing purpose. This page cannot be used in the SashContainer.
 * @author cedric dumoulin
 *
 */
public class FakePagePart extends PagePart {

	public FakePagePart() {
		super(null, null);
	}

	@Override
	boolean visit(IPartVisitor visitor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Control getControl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reparent(TabFolderPart parent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void garbage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disposeThisAndChildren() {
		// TODO Auto-generated method stub
		
	}

}
