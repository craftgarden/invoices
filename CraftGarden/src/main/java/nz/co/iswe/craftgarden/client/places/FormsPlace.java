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
package nz.co.iswe.craftgarden.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * 
 * @author rafaelalmeida
 *
 */
public class FormsPlace extends Place {
	
	
	public FormsPlace( ) { 
	}

	 
	public static class Tokenizer implements PlaceTokenizer<FormsPlace> {
		@Override
		public FormsPlace getPlace(String token) {
			return new FormsPlace();
		}

		@Override
		public String getToken(FormsPlace place) {
			return "";
		}        
    }
}
