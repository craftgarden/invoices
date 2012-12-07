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
package nz.co.iswe.craftgarden.client.views;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Abstract class for Search Views.
 * 
 * 
 * @author Rafael Almeida
 *
 */
public abstract class AbstractViewWithDisplayMessage extends Composite implements HasDisplayMessage {

	@UiField
	public HTMLPanel alertPanel;
	
	public void displayErrorMessage(String message) {
		displayMessage(message, "ERROR");
	}
	
	public void displayInfoMessage(String message) {
		displayMessage(message, "INFO");
	}
	
	public void displaySuccessMessage(String message) {
		displayMessage(message, "SUCCESS");
	}
	
	public void displayWarningMessage(String message) {
		displayMessage(message, "WARNING");
	}
	
	protected void displayMessage(String message, String alertType) {
		/*
		Alert alert = new Alert();
		alert.setType(alertType);
		alert.setClose(true);
		alert.setAnimation(true);
		alert.setText(message);
		
		// add to the view
		alertPanel.add(alert);
		*/
	}
}
