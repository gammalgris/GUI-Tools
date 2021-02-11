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

package guitools.core.config;


import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;


/**
 * This interface describes a configuration for a component. Implement
 * this interface in an enumeration for managing components.
 */
public interface ComponentConfiguration {

    /**
     * Returns the name of a component. Names should be unique within
     * a frame.
     *
     * @return a component name
     */
    String getName();

    /**
     * Returns the text of a component (i.e. which can be applied on
     * components that have a text property, e.g. a label or button).
     *
     * @return a component text
     */
    String getText();

    /**
     * Returns the preferred size of a component.
     *
     * @return the preferred size of a component
     */
    Dimension getPreferredSize();

    /**
     * Returns the type of the component. This information can be used to
     * instantiate a component.
     *
     * @return a component type
     */
    Class<? extends JComponent> getType();

    /**
     * Returns the font for this component. Ideally all components should
     * share the same font settings.
     *
     * @return the font of a component
     */
    Font getFont();

}
