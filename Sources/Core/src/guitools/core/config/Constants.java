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


import java.awt.Font;


/**
 * This class contains several constants which are used within the
 * GUI example.
 *
 * @author Kristian Kutin
 */
public final class Constants {

    /**
     * The length of a basic cell.
     */
    public static final int DX;

    /**
     * The height of a basic cell.
     */
    public static final int DY;

    /**
     * The horizontal distance between components.
     */
    public static final int GAPX;

    /**
     * The vertical distance between components.
     */
    public static final int GAPY;

    /**
     * The font which is to be used throughout the example.
     */
    public static final Font DEFAULT_FONT;

    /*
     * The static initializer.
     */
    static {

        DX = 22;
        DY = 22;

        GAPX = Math.max(DX / 4, 4);
        GAPY = Math.max(DY / 4, 3);

        Double fontSize = DY * 0.60d;
        DEFAULT_FONT = new Font(FontNames.SERIF.toString(), Font.PLAIN, fontSize.intValue());
    }

    /**
     * The default constructor.
     */
    private Constants() {

        throw new UnsupportedOperationException();
    }

}
