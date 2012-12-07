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
import nz.co.iswe.craftgarden.client.views.DashboardView;
import nz.co.iswe.craftgarden.client.views.FormsView;
import nz.co.iswe.craftgarden.client.views.NavBar;
import nz.co.iswe.craftgarden.formdisplay.client.views.DisplayFormView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
    EventBus getEventBus();
    
    AppRequestFactory getRequestFactory();
    
    PlaceController getPlaceController();
    
    //Views
    DashboardView getDashboardView();
    FormsView getFormsView();
    
    //Nav bars
    NavBar getNavBar();
    BottomNav getBottomNav();

	DisplayFormView getDisplayFormView();
	
}
