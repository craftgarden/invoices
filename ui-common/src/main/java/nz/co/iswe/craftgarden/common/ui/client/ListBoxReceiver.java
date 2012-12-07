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

import java.util.ArrayList;
import java.util.List;

import com.google.web.bindery.requestfactory.shared.Receiver;

public abstract class ListBoxReceiver<V extends List<E>, E> extends Receiver<V>  {

	private TagBox tagBox;
	private int minSize;
	
	//0 not loaded
	//1 loading
	//2 loaded
	private int state = 0;
	
	private List<E> selectedItems = new ArrayList<E>();
	
	public ListBoxReceiver(TagBox tagBox, int minSize) {
		this.tagBox = tagBox;
		this.minSize = minSize;
	}

	@Override
	public void onSuccess(V response) {
		populateListBox(response);
	}

	public void populateListBox(V list){
		tagBox.hideLoading();
		
		//remove items
		while(tagBox.getItemCount() > minSize){//keep the first item
			tagBox.removeItem(minSize);
		}
		
		//load from the database
		for(E item: list){
			OptionItem optionItem = getOptionItem(item);
			tagBox.addItem(optionItem.getLabel(), optionItem.getValue());
		}
		tagBox.update();
		
		state = 2;//loaded
		
		if(selectedItems.size() > 0){
			setValue(selectedItems);
			selectedItems.clear();
			tagBox.update();
		}
	}

	public abstract OptionItem getOptionItem(E item);

	public ListBoxReceiver<V, E> startLoad(boolean displayLoadingMessage) {
		try{
			if(displayLoadingMessage){
				tagBox.displayLoading();
			}
		}
		finally{
			state = 1;//loading
		}
		return this;
	}

	public void setValue(List<E> list) {
		//null value
		if(list == null || list.size() == 0){
			selectedItems.clear();
			tagBox.setSelectedIndex(-1);
			return;
		}
		@SuppressWarnings("unchecked")
		E[] array = (E[])list.toArray();
		for(E item: array){
			setValue(item);
		}
	}
	
	public void setValue(E item) {
		//null value
		if(item == null){
			selectedItems.clear();
			tagBox.setSelectedIndex(-1);
			return;
		}
		
		OptionItem optionItem = getOptionItem(item);
		if(state == 2){//loaded
			//find the item to select
			for (int i = 0; i < tagBox.getItemCount(); i++) {
				String currentValue = tagBox.getValue(i);
				if(currentValue.equals(optionItem.getValue())){
					//found the item
					tagBox.setItemSelected(i, true);
					break;
				}
			}
			//value not found
		}
		else{
			selectedItems.add(item);
		}
	}
	
	public static class OptionItem{

		private String label;
		private String value;
		
		public OptionItem(String label, String value){
			this.label = label;
			this.value = value;
		}
		
		public String getLabel() {
			return label;
		}

		public String getValue() {
			return value;
		}
	}
}
