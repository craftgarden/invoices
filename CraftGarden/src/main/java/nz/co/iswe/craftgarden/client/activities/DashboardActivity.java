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
package nz.co.iswe.craftgarden.client.activities;

import nz.co.iswe.craftgarden.client.ClientFactory;
import nz.co.iswe.craftgarden.client.places.DashboardPlace;
import nz.co.iswe.craftgarden.client.views.DashboardView;
import nz.co.iswe.craftgarden.client.views.NavBar;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DashboardActivity extends BaseActivity implements DashboardView.Presenter {

	public DashboardActivity(DashboardPlace place, ClientFactory clientFactory){
		super(clientFactory);
	}
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		DashboardView view = clientFactory.getDashboardView();
		
		//set parameters to the view
		//helloView.setName(name);
		
		//set the presenter
		view.setPresenter(this);
		
		//add it to the dom
		panel.setWidget(view.asWidget());
		
		//set the active tab
		NavBar navBar = clientFactory.getNavBar();
		navBar.setActiveTab("Dashboard");
	}

	
}
