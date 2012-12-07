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

import nz.co.iswe.craftgarden.client.activities.DashboardActivity;
import nz.co.iswe.craftgarden.client.activities.FormsActivity;
import nz.co.iswe.craftgarden.client.places.DashboardPlace;
import nz.co.iswe.craftgarden.client.places.FormsPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public AppActivityMapper(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}
	
	/**
	 * Creates a new activity accordinly to the place
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof DashboardPlace){
            return new DashboardActivity((DashboardPlace) place, clientFactory);
		}
		else if (place instanceof FormsPlace){
            return new FormsActivity((FormsPlace) place, clientFactory);
		}
		return null;
	}

}
