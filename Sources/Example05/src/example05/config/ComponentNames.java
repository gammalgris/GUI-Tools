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


import guitools.core.config.ComponentName;


/**
 * This enumeration class contains the unique names for all relevant
 * GUI components.
 *
 * @author Kristian Kutin
 */
public enum ComponentNames implements ComponentName {


    LABEL1,
    TEXTFIELD1,
    LABEL2,
    TEXTFIELD2,
    LABEL3,
    TEXTFIELD3, ;


    /**
     * Returns the length of the component name.
     *
     * @return a length
     */
    @Override
    public int length() {

        return toString().length();
    }

    /**
     * Returns the character at the specified index.
     *
     * @param index
     *        an index (i.e. a number greater than zero and lesser than the
     *        length of the component name.
     *
     * @return a character
     */
    @Override
    public char charAt(int index) {

        return toString().charAt(index);
    }

    /**
     * Returns a substring with the specified bounds.
     *
     * @param start
     *        an index greater than zero and lesser or equal to the end index
     * @param end
     *        an index greater or equal to the start index and lesser than the
     *        string length
     *
     * @return a substring
     */
    @Override
    public CharSequence subSequence(int start, int end) {

        return toString().subSequence(start, end);
    }

    /**
     * Returns a string representation of the component name.
     *
     * @return a string representation
     */
    @Override
    public String toString() {

        return name();
    }

}
