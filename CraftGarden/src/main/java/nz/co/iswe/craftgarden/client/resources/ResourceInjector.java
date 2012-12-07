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
/*
 *  Copyright 2012 GWT-Bootstrap
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package nz.co.iswe.craftgarden.client.resources;

import nz.co.iswe.craftgarden.common.ui.client.resources.Chosen;
import nz.co.iswe.craftgarden.common.ui.client.resources.JavaScriptInjector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * Utility class to inject our resources into modules page. Use it to inject
 * JavaScript and CSS files.
 * 
 * 
 * @author Rafael Almeida
 */
public class ResourceInjector {

    private static final Chosen CHOSEN = GWT.create(Chosen.class);
    private static final Resources RESOURCES = GWT.create(Resources.class);
    
    /**
     * Injects the required CSS styles and JavaScript files into the document
     * header.
     */
    public static void configure() {
    	//app CSS
        injectCss(RESOURCES.appCss());
        
        //datepicker
        injectCss(RESOURCES.datePickerCss());
        injectJs(RESOURCES.datePickerJs());
        
        //Chosen resources
        injectJs(CHOSEN.chosenJs());
        injectCss(CHOSEN.chosenCss());
    }

    private static void injectCss(TextResource r) {
        StyleInjector.inject(r.getText());
    }

    private static void injectJs(TextResource r) {
        JavaScriptInjector.inject(r.getText());
    }

}
