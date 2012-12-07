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
package com.github.gwtbootstrap.client.ui;

import com.github.gwtbootstrap.client.ui.base.StyleHelper;
import com.github.gwtbootstrap.client.ui.constants.IconSize;
import com.github.gwtbootstrap.client.ui.constants.IconType;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

//@formatter:off

/**
 * Widget with a black or white icon.
 * <p>
 * The icons are provided by <a href="http://glyphicons.com/">Glyphicons</a>
 * and <a href="http://fortawesome.github.com/Font-Awesome/">Font Awesome</a>.
 *
 * <p/>
 * <p>
 * <h3>UiBinder Usage:</h3>
 * <p/>
 * <pre>
 * {@code
 * <b:Icon type="PLANE" />
 * }
 * </pre>
 * </p>
 *
 * @author Carlos Alexandro Becker
 * @author Dominik Mayer
 * @see <a href="http://twitter.github.com/bootstrap/base-css.html#icons">Bootstrap documentation</a>
 * @see <a href="http://fortawesome.github.com/Font-Awesome/">Font Awesome page</a>
 * @since 2.0.4.0
 */
//@formatter:on
public class Icon extends Widget {

    private IconType type;

    /**
     * Creates a widget but doesn't set an icon yet.
     * <p/>
     * (This is probably not what you want to do most of the time.)
     */
    public Icon() {
        setElement(DOM.createElement("i"));
    }

    /**
     * Creates a black icon of given type.
     *
     * @param type the icon type
     */
    @UiConstructor
    public Icon(IconType type) {
        this();
        setType(type);
    }

    /**
     * Sets the icon type.
     *
     * @param type the icon type
     */
    public void setType(IconType type) {
        this.type = type;
        StyleHelper.changeStyle(this, type, IconType.class);
    }

    /**
     * Sets the icon size.
     *
     * @param size the icon size
     */
    public void setIconSize(IconSize size) {
        StyleHelper.changeStyle(this, size, IconSize.class);
    }
    
    /**
     * Get the icon type
     * 
     * @return icon type.
     */
    public IconType getIconType() {
    	return type;
    }

}
