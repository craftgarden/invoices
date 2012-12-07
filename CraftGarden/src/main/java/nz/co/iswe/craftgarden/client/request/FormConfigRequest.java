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
package nz.co.iswe.craftgarden.client.request;

import java.util.List;

import nz.co.iswe.craftgarden.client.proxies.FormConfigProxy;
import nz.co.iswe.craftgarden.server.entity.FormConfig;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(FormConfig.class)
public interface FormConfigRequest extends RequestContext{

	Request<List<FormConfigProxy>> findAllForms();
	
	Request<FormConfigProxy> findForm(Long formId);
	
	InstanceRequest<FormConfigProxy, Void> persist();

	InstanceRequest<FormConfigProxy, Void> remove();
	
}
