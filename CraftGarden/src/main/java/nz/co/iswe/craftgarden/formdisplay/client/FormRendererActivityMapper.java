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
import nz.co.iswe.craftgarden.formdisplay.client.activities.DisplayFormActivity;
import nz.co.iswe.craftgarden.formdisplay.client.places.DisplayFormPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class FormRendererActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public FormRendererActivityMapper(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}
	
	/**
	 * Creates a new activity accordinly to the place
	 */
	@Override
	public Activity getActivity(Place place) {
		if (place instanceof DisplayFormPlace){
            return new DisplayFormActivity((DisplayFormPlace) place, clientFactory);
		}
		
		return null;
	}

}
