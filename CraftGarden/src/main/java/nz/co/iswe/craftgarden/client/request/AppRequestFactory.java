/*******************************************************************************
 * ISWE Ltd.
 * All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of * Ltd and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to * Ltd
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from * Ltd.
 *  
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package nz.co.iswe.craftgarden.client.request;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface AppRequestFactory extends RequestFactory {
	FormConfigRequest formConfigRequest();
}
