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
package nz.co.iswe.craftgarden.client;

import nz.co.iswe.craftgarden.client.request.AppRequestFactory;
import nz.co.iswe.craftgarden.client.views.BottomNav;
import nz.co.iswe.craftgarden.client.views.BottomNavImpl;
import nz.co.iswe.craftgarden.client.views.DashboardView;
import nz.co.iswe.craftgarden.client.views.DashboardViewImpl;
import nz.co.iswe.craftgarden.client.views.FormsView;
import nz.co.iswe.craftgarden.client.views.FormsViewImpl;
import nz.co.iswe.craftgarden.client.views.NavBar;
import nz.co.iswe.craftgarden.client.views.NavBarImpl;
import nz.co.iswe.craftgarden.formdisplay.client.views.DisplayFormView;
import nz.co.iswe.craftgarden.formdisplay.client.views.DisplayFormViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class ClientFactoryImpl implements ClientFactory {

	private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);

    private DashboardView dashboardView;
    private FormsView formsView;
    private DisplayFormView displayFormView;
	private NavBar navBar;
	private BottomNav bottomNav;
    private AppRequestFactory requestFactory;
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public DashboardView getDashboardView() {
		if(dashboardView == null){
			dashboardView = new DashboardViewImpl();
		}
		return dashboardView;
	}

	@Override
	public FormsView getFormsView() {
		if(formsView == null){
			formsView = new FormsViewImpl();
		}
		return formsView;
	}
	
	@Override
	public DisplayFormView getDisplayFormView() {
		if(displayFormView == null){
			displayFormView = new DisplayFormViewImpl();
		}
		return displayFormView;
	}

	@Override
	public NavBar getNavBar() {
		if(navBar == null){
			navBar = new NavBarImpl();
		}
		return navBar;
	}

	@Override
	public BottomNav getBottomNav() {
		if(bottomNav == null){
			bottomNav = new BottomNavImpl();
		}
		return bottomNav;
	}
	
	@Override
	public AppRequestFactory getRequestFactory() {
		if(requestFactory == null){
			requestFactory = GWT.create(AppRequestFactory.class);
			requestFactory.initialize(getEventBus());
		}
		return requestFactory;
	}
}