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
package nz.co.iswe.craftgarden.formdisplay.client.views;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;

public class ChildSectionViewImpl extends Composite implements ChildSectionView{

	private static ChildSectionViewImplUiBinder uiBinder = GWT.create(ChildSectionViewImplUiBinder.class);

	interface ChildSectionViewImplUiBinder extends UiBinder<Widget, ChildSectionViewImpl> {
	}

	private ChildSectionView.Presenter presenter;
	
	@UiField
	SpanElement childNumber;
	
	@UiField
	Button removeChild;

	@UiField
	Anchor genderBoy, genderGirl;
	
	@UiField
	SpanElement ageLabel;
	
	@UiField
	DivElement dateOfBirth;
	
	@UiField
	InputElement firstName, familyName;
	
	@Override
	public void focus() {
		firstName.focus();
	} 
	
	int index = 0;
	public ChildSectionViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		removeChild.getElement().setAttribute("rel", "tooltip");
		removeChild.getElement().setAttribute("title", "Remove child");
		
		setupDateOfBirth(dateOfBirth);
	}
	
	//http://www.eyecon.ro/bootstrap-datepicker/
	private native void setupDateOfBirth(Element element) /*-{
		var delegate = this;
		
		function changedEvent (date){
			//console.log("new changedEvent func");
			delegate.@nz.co.iswe.craftgarden.formdisplay.client.views.ChildSectionViewImpl::dateOfBirthChanged(Ljava/lang/String;)(date);
		}
		
		(function ($){
			//jQuery closure
			$(element).datepicker().on('changeDate', function(ev){
				var dateValue = ev.date.getDate() + "/" + (ev.date.getMonth() + 1)+ "/" + ev.date.getFullYear();
				//hide calendar
				$(element).datepicker('hide');
				//call the changed event
				changedEvent(dateValue);
			});
			
		    $(element).find("input[type='text']").change(function() {
		    	//console.log("input[type='text'] change() " + $(element).find("input[type='text']").val());
		    	$(element).datepicker('setValue', $(element).find("input[type='text']").val());
		    	changedEvent($(element).find("input[type='text']").val());
		    });
		    
		 
		}($wnd.jQuery));
	}-*/;

	DateTimeFormat fmt = DateTimeFormat.getFormat("dd/MM/yyyy");
	public void dateOfBirthChanged(String dateString){
		Date date = fmt.parse(dateString);
		calcAge(date);
	}
	
	@Override
	public void setIndex(int index) {
		this.index = index;
		childNumber.setInnerText("Child: " + (index + 1));
	}
	
	private void calcAge(Date date) {
		Date today = new Date();
		int days = CalendarUtil.getDaysBetween(date, today);
		int age = days / 366;
		ageLabel.setInnerText(age + " years old.");
	}

	@UiHandler("genderBoy")
	public void genderBoyClick(ClickEvent e){
		genderBoy.getElement().addClassName("active");
		genderGirl.getElement().removeClassName("active");	
	}
	
	@UiHandler("genderGirl")
	public void genderGirlClick(ClickEvent e){
		genderGirl.getElement().addClassName("active");
		genderBoy.getElement().removeClassName("active");
	}
	
	@UiHandler("removeChild")
	public void removeChildClick(ClickEvent e){
		presenter.remove(index);
		//hide tool tip
		toolTip(removeChild.getElement(), "hide");
	}
	
	protected native void toolTip(Element e, String parameter)/*-{
		(function ($){
			//jQuery closure
			$(e).tooltip(parameter);
		}($wnd.jQuery));
	}-*/;	

	@Override
	protected void onLoad() {
		super.onLoad();
		nativeSetup(this.getElement());
	}

	/**
	 * Execute native code to setup the page
	 */
	protected native void nativeSetup(Element e)/*-{
		(function ($){
			//jQuery closure
			$(e).find("[rel='tooltip']").tooltip({});
		}($wnd.jQuery));
	}-*/;	
	
	//handlers
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
