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

import nz.co.iswe.craftgarden.client.places.DashboardPlace;
import nz.co.iswe.craftgarden.client.resources.ResourceInjector;
import nz.co.iswe.craftgarden.client.views.BottomNav;
import nz.co.iswe.craftgarden.client.views.NavBar;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CraftGardenApp implements EntryPoint, NavBar.Presenter, BottomNav.Presenter {
 
	private Place defaultPlace = new DashboardPlace();
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ResourceInjector.configure();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
        // Navigation bar at the top of the screen
 		NavBar navBar = clientFactory.getNavBar();
 		navBar.setPresenter(this);
 		RootPanel.get("top").add(navBar);
 		
 		// Bottom Nav
 		BottomNav bottomNav = clientFactory.getBottomNav();
 		bottomNav.setPresenter(this);
 		RootPanel.get("bottom").add(bottomNav);
 		
 		//Center Panel
        SimplePanel centerContainer = new SimplePanel();
        RootPanel.get("center").add(centerContainer);
        
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(centerContainer);
        
        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();
	}
	
	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}
