/*******************************************************************************
 * ISWE Ltd.
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of ISWE Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to ISWE Ltd
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from ISWE Ltd.
 *  
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package nz.co.iswe.craftgarden.formdisplay.client.views;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class DisplayFormViewImpl extends Composite implements DisplayFormView{

	private static DisplayFormViewImplUiBinder uiBinder = GWT.create(DisplayFormViewImplUiBinder.class);

	interface DisplayFormViewImplUiBinder extends UiBinder<Widget, DisplayFormViewImpl> {
	}

	private DisplayFormView.Presenter presenter;
	
	//
	//DivElement readMoreEventDetailsModal;
	@UiField
	Button addChildSmall;
	
	@UiField
	HTMLPanel childDetailsContainer;
	
	@UiField
	InputElement firstName, familyName;
	
	private List<ChildSectionView> childList = new ArrayList<ChildSectionView>();
	
	public DisplayFormViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		//setup a tool tip for the addChildSmall button
		addChildSmall.getElement().setAttribute("rel", "tooltip");
		
		
	}
	
	
	private int numChild = 0;
	private void addChildSection() {
		numChild++;
		
		ChildSectionView section = new ChildSectionViewImpl();
		childList.add(section);
		
		section.setPresenter(this.presenter);
		
		//add to the screen
		childDetailsContainer.add(section);
		
		section.focus();
		
		updateChildSectionIndex();
	}
	
	private void updateChildSectionIndex() {
		int idx = 0;
		for(ChildSectionView section : childList){
			section.setIndex(idx++);
		}
	}

	@Override
	public void removeChildSection(int index) {
		ChildSectionView section = childList.remove(index);
		childDetailsContainer.remove(section);
		updateChildSectionIndex();
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		nativeSetup(this.getElement());
		firstName.focus();
	}

	/**
	 * Execute native code to setup the page
	 */
	protected native void nativeSetup(Element e)/*-{
		$wnd.jQuery(e).find("[rel='tooltip']").tooltip({});
	}-*/;	
	
	
	//handlers
	
	@UiHandler({"addChildBig", "addChildSmall"})
	public void onAddChildBig(ClickEvent e){
		addChildSection();
	}
	
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		addChildSection();
	}


}
