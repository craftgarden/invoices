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
package nz.co.iswe.craftgarden.client.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Icons extends ClientBundle {
	
	//main tab icons
	@Source("icons/trip_tab_icon.png")
	ImageResource tripIcon();
	
	@Source("icons/dash-ico.png")
	ImageResource dashboardIcon();

	@Source("icons/car_icon.png")
	ImageResource carIcon();
	
	@Source("icons/report_icon.png")
	ImageResource reportIcon();
	
	@Source("icons/config-ico.png")
	ImageResource settingsIcon();
	
	//cars icons
	@Source("icons/vw_archigraphs_32.png")
	ImageResource vw32();
	
	@Source("icons/beatle_archigraphs_32.png")
	ImageResource beatle32();
	
	@Source("icons/corvette_archigraphs_32.png")
	ImageResource corvette32();
	
	@Source("icons/mini_archigraphs_32.png")
	ImageResource mini32();
	
	//Stats Bar icons
	@Source("icons/Checkered-flag-48.png")
	ImageResource statsDistance();
	
	@Source("icons/Dashboard-black-48.png")
	ImageResource statsFuel();
	
	@Source("icons/Money-48.png")
	ImageResource statsTranspCosts();
	
	//Trips Panel icon
	@Source("icons/trip_map_icon.png")
	ImageResource tripMapIcon();
	
	@Source("icons/graph-up.png")
	ImageResource graphUp();
	
	@Source("icons/graph-down.png")
	ImageResource graphDown();
}
