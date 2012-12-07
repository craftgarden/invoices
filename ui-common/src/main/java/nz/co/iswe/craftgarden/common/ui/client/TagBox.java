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
package nz.co.iswe.craftgarden.common.ui.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ListBox;

public class TagBox extends ListBox {

	public TagBox(){
		super();
	}

	public TagBox(boolean multiple){
		super(multiple);
	}

	private String noResultsText = null;
	private boolean allowSingleDeselect = false;
	
	@Override
	protected void onLoad() {
		super.onLoad();
		setupChosen(this.getElement(), noResultsText, allowSingleDeselect);
	}
	
	/*
	@Override
	public void setItemSelected(int index, boolean selected) {
		super.setItemSelected(index, selected);
		fixEvents(this.getElement().getId());
		super.setItemSelected(index, selected);
		update();
	}
	*/
	
	@Override
	public void setSelectedIndex(int index) {
		super.setSelectedIndex(index);
		fixEvents(this.getElement().getId());
		super.setSelectedIndex(index);
		update();
	}
	
	private native void fixEvents(String id) /*-{
		$wnd.jQuery('#' + id + '_chzn').remove();
		$wnd.jQuery('#' + id).val('').change().removeClass('chzn-done').chosen();
	}-*/;

	public void update(){
		updateImpl(this.getElement());
	}
	
	protected native void updateImpl(Element element)/*-{
		$wnd.jQuery(element).trigger("liszt:updated");
	}-*/;
	
	public void setNoResultsText(String noResultsText) {
		this.noResultsText = noResultsText;
	}
	
	public void setPlaceholder(String value){
		getElement().setAttribute("data-placeholder", value);
	}
	
	private native void setupChosen(Element element, 
			String noResultsText, 
			boolean allowSingleDeselect) /*-{
				
		var params = {allow_single_deselect:allowSingleDeselect};
		
		if(noResultsText){
			params.no_results_text = noResultsText;
		}
		
		$wnd.jQuery(element).chosen(params);
	}-*/;

	public void displayLoading() {
		//TODO: IMplement the display loading method
		
	}
	
	public void hideLoading() {
		//TODO: IMplement the hide loading method
		
	}

	public String getValue() {
		if(getSelectedIndex() == -1){
			return null;
		}
		return getValue(getSelectedIndex());
	}
	
	public String getLabel(){
		if(getSelectedIndex() == -1){
			return null;
		}
		return getItemText(getSelectedIndex());
	}
}
