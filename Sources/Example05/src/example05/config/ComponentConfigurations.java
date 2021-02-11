/*
 * SPDX-License-Identifier: GPL-3.0
 *
 *
 * GUI-Tools
 *
 * GUI-Tools is a collection of utility classes for working with Java
 * Swing based GUIs.
 *
 * Copyright (C) 2021  Kristian Kutin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * e-mail: kristian.kutin@arcor.de
 */

/*
 * This section contains meta informations.
 *
 * $Id$
 */

package example05.config;


import guitools.core.config.ComponentConfiguration;
import static guitools.core.config.Constants.DEFAULT_FONT;
import static guitools.core.config.Constants.DX;
import static guitools.core.config.Constants.DY;
import guitools.core.utils.StringHelper;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 * Contains the configuration for the relevant GUI components.
 *
 * @author Kristian Kutin
 */
public enum ComponentConfigurations implements ComponentConfiguration {


    LABEL1(ComponentNames.LABEL1, "Label#1", new Dimension(DX * 6, DY), JLabel.class, DEFAULT_FONT),
    TEXTFIELD1(ComponentNames.TEXTFIELD1, new Dimension(DX * 12, DY), JTextField.class, DEFAULT_FONT),
    LABEL2(ComponentNames.LABEL2, "Label#2", new Dimension(DX * 6, DY), JLabel.class, DEFAULT_FONT),
    TEXTFIELD2(ComponentNames.TEXTFIELD2, new Dimension(DX * 12, DY), JTextField.class, DEFAULT_FONT),
    LABEL3(ComponentNames.LABEL3, "Label#3", new Dimension(DX * 6, DY), JLabel.class, DEFAULT_FONT),
    TEXTFIELD3(ComponentNames.TEXTFIELD3, new Dimension(DX * 12, DY), JTextField.class, DEFAULT_FONT), ;


    /**
     * The name of a component.
     */
    private final String name;

    /**
     * The text of a component (if applicable or available)
     */
    private final String text;

    /**
     * The preferred size of the component.
     */
    private final Dimension preferredSize;

    /**
     * The type of the component.
     */
    private final Class<? extends JComponent> type;

    /**
     * The font used in the component.
     */
    private final Font font;

    /**
     * Creates a new enumeration element according to the specified parameters.
     *
     * @param aName
     * @param aPreferredSize
     * @param aType
     * @param aFont
     */
    private ComponentConfigurations(CharSequence aName, Dimension aPreferredSize, Class<? extends JComponent> aType,
                                    Font aFont) {

        this(aName, null, aPreferredSize, aType, aFont);
    }

    /**
     * Creates a new enumeration element according to the specified parameters.
     *
     * @param aName
     * @param aText
     * @param aPreferredSize
     * @param aType
     * @param aFont
     */
    private ComponentConfigurations(CharSequence aName, CharSequence aText, Dimension aPreferredSize,
                                    Class<? extends JComponent> aType, Font aFont) {

        name = StringHelper.valueOf(aName);
        text = StringHelper.valueOf(aText);
        preferredSize = aPreferredSize;
        type = aType;
        font = aFont;
    }

    /**
     * Returns the name of a component. Names should be unique within
     * a frame.
     *
     * @return a component name
     */
    @Override
    public String getName() {

        return name;
    }

    /**
     * Returns the text of a component (i.e. which can be applied on
     * components that have a text property, e.g. a label or button).
     *
     * @return a component text
     */
    @Override
    public String getText() {

        return text;
    }

    /**
     * Returns the preferred size of a component.
     *
     * @return the preferred size of a component
     */
    @Override
    public Dimension getPreferredSize() {

        return preferredSize;
    }

    /**
     * Returns the type of the component. This information can be used to
     * instantiate a component.
     *
     * @return a component type
     */
    @Override
    public Class<? extends JComponent> getType() {

        return type;
    }

    /**
     * Returns the font for this component. Ideally all components should
     * share the same font settings.
     *
     * @return the font of a component
     */
    @Override
    public Font getFont() {

        return font;
    }

}
