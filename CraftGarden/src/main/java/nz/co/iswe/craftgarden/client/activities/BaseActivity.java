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

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;

public abstract class BaseActivity extends AbstractActivity {

	protected ClientFactory clientFactory;
	
	
	public BaseActivity(ClientFactory clientFactory){
		this.clientFactory = clientFactory;
	}
	
	/**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
        //return "Please hold on. This activity is stopping.";
    	return null;
    }
	
    /**
     * Navigate to a new Place in the browser
     */
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

}
