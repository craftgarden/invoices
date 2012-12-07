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
package nz.co.iswe.craftgarden.server.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class FormConfig {

	@Id
	private Long formConfigId;
	
	private String title;
	
	@Version
	private Integer version;

	public FormConfig(){}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public Long getId() {
		return formConfigId;
	}
	public Long getFormConfigId() {
		return formConfigId;
	}
	public void setFormConfigId(Long formConfigId) {
		this.formConfigId = formConfigId;
	}

	//access methods
	public static  List<FormConfig> findAllForms(){
		List<FormConfig> result = new ArrayList<FormConfig>();
		/*
		result.add(new FormConfig(1l, "Mike"));
		result.add(new FormConfig(2l, "Carlos"));
		result.add(new FormConfig(3l, "Angela"));
		*/ 
		return result;
	}
	
	public static FormConfig findForm(Long formId){
		return new FormConfig();
	}
	
	public void persist() {
		
	}
	
	public void remove() {
		
	}
}
