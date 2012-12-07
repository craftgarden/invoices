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
package nz.co.iswe.craftgarden.client.views;

import nz.co.iswe.craftgarden.client.places.DashboardPlace;
import nz.co.iswe.craftgarden.client.places.FormsPlace;

import com.github.gwtbootstrap.client.ui.Nav;
import com.github.gwtbootstrap.client.ui.NavWidget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NavBarImpl extends Composite implements NavBar {

	private static NavBarImplUiBinder uiBinder = GWT.create(NavBarImplUiBinder.class);

	interface NavBarImplUiBinder extends UiBinder<Widget, NavBarImpl> {
	}
	
	@UiField
	NavWidget dashboardTab;
	
	@UiField
	NavWidget formsTab;
	
	@UiField
	NavWidget invoicesTab;
	
	@UiField
	NavWidget clientsTab;
	
	@UiField
	NavWidget settingsTab;
	
	@UiField
	Nav tabs;
	
	private Presenter presenter;
	
	public NavBarImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		formsTab.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//load/show the Vehicles screen
				presenter.goTo(new FormsPlace());
			}
		});
		
		dashboardTab.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//load/show dashboard view
				presenter.goTo(new DashboardPlace());
			}
		});
		
		
	}
	
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setActiveTab(String tabName) {
		if(tabName == null){
			return;
		}
		
		NavWidget activeTab = null;
		//disable the previous component that is active
		for (int i = 0; i < tabs.getWidgetCount(); i++) {
			if(tabs.getWidget(i) instanceof NavWidget){
				NavWidget navW = (NavWidget)tabs.getWidget(i);
				navW.setActive(false);
				
				String name = navW.getTitle();
				if(tabName.equals(name)){
					activeTab = navW;
				}
			}
		}
		if(activeTab != null){
			//set tghe current nav widget as active
			activeTab.setActive(true);
		}
	}
}
