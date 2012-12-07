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
package nz.co.iswe.craftgarden.formdisplay.client;

import nz.co.iswe.craftgarden.client.ClientFactory;
import nz.co.iswe.craftgarden.client.resources.ResourceInjector;
import nz.co.iswe.craftgarden.client.views.BottomNav;
import nz.co.iswe.craftgarden.client.views.NavBar;
import nz.co.iswe.craftgarden.formdisplay.client.places.DisplayFormPlace;

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
public class FormRendererApp implements EntryPoint, NavBar.Presenter, BottomNav.Presenter {
 
	private Place defaultPlace = new DisplayFormPlace();
	private ClientFactory clientFactory = GWT.create(ClientFactory.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ResourceInjector.configure();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
 		//Center Panel
        SimplePanel content = new SimplePanel();
        RootPanel.get("content").add(content);
        
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new FormRendererActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(content);
        
        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        FormRendererPlaceHistoryMapper historyMapper = GWT.create(FormRendererPlaceHistoryMapper.class);
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
