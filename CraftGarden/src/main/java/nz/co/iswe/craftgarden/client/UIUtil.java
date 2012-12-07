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

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;

/**
 * 
 * @author Rafael Almeida
 *
 */
public class UIUtil {

	private static DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");//TODO: Use the user's preferred data format
	private static NumberFormat numberFormat = NumberFormat.getFormat("#,###,###.00");//TODO: Use the user's preferred decimal format
	/**
	 * @param mileage
	 * @return
	 */
	public static String formatMileage(Double value) {
		return numberFormat.format(value);
	}
	/**
	 * @param avgFuelEfficiency
	 * @return
	 */
	public static String formatFuelEfficiency(Double value) {
		return numberFormat.format(value);
	}
	/**
	 * @param lastTripCost
	 * @return
	 */
	public static String formatMoney(Double value) {
		return numberFormat.format(value);
	}
	/**
	 * @param lastTripDate
	 * @return
	 */
	public static String formatShortDate(Date value) {
		return dateFormat.format(value);
	}
	
	
}
