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

/**
 * 
 * @author Rafael Almeida
 *
 */
public interface DetailPresenter {
	
	//navigation actions
	void gotoSearchView();
	
	//record related actions
	
	//Edit the current displayed record
	void edit();
	
	//prepare the view to create a new record
	void createNew();
	
	//delete the current displayed record
	void delete();
}
