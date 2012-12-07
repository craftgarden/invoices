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
import nz.co.iswe.craftgarden.client.places.FormsPlace;
import nz.co.iswe.craftgarden.client.views.FormsView;
import nz.co.iswe.craftgarden.client.views.NavBar;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FormsActivity extends BaseActivity implements FormsView.Presenter {

	public FormsActivity(FormsPlace place, ClientFactory clientFactory){
		super(clientFactory);
	}
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		FormsView view = clientFactory.getFormsView();
		
		//set parameters to the view
		
		//set the presenter
		view.setPresenter(this);
		
		//add it to the dom
		panel.setWidget(view.asWidget());
		
		//set the active tab
		NavBar navBar = clientFactory.getNavBar();
		navBar.setActiveTab("Forms");
	}

	
}
