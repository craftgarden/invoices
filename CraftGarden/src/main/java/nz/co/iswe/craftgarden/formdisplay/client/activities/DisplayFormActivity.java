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
package nz.co.iswe.craftgarden.formdisplay.client.activities;

import nz.co.iswe.craftgarden.client.ClientFactory;
import nz.co.iswe.craftgarden.client.activities.BaseActivity;
import nz.co.iswe.craftgarden.formdisplay.client.places.DisplayFormPlace;
import nz.co.iswe.craftgarden.formdisplay.client.views.DisplayFormView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class DisplayFormActivity extends BaseActivity implements DisplayFormView.Presenter {

	public DisplayFormActivity(DisplayFormPlace place, ClientFactory clientFactory){
		super(clientFactory);
	}
	
	private DisplayFormView view;
	
	/**
     * Invoked by the ActivityManager to start a new Activity
     */
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view = clientFactory.getDisplayFormView();
		
		//set the presenter
		view.setPresenter(this);
		
		//add it to the dom
		panel.setWidget(view.asWidget());
	}

	@Override
	public void remove(int index) {
		view.removeChildSection(index);
	}

	
}
