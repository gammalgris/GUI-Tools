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
 * An implementation of the interface for font names.
 *
 * @author Kristian Kutin
 */
public enum FontNames implements FontName {


    SERIF(Font.SERIF),
    SANS_SERIF(Font.SANS_SERIF),
    MONOSPACED(Font.MONOSPACED), ;


    private final String fontName;

    /**
     *
     *
     * @param aFontName
     */
    private FontNames(String aFontName) {

        fontName = aFontName;
    }

    /**
     * Returns the name of a font.
     *
     * @return a font name
     */
    @Override
    public String getFontName() {

        return fontName;
    }

    /**
     * Returns the length of the string.
     *
     * @return a length
     */
    @Override
    public int length() {

        return getFontName().length();

    }

    /**
     * Returns the character at the specified location.
     *
     * @param index
     *        an index position, i.e. a value greater or equals to zero
     *        and lesser than the string length
     *
     * @return a character
     */
    @Override
    public char charAt(int index) {

        return getFontName().charAt(index);
    }

    /**
     * Returns a substring according to the specified bounds.
     *
     * @param start
     *        a start index, i.e. a value greater or equals to zero and
     *        lesser or equals to the end index
     * @param end
     *        an end index, i.e. greater or equals to the start index and
     *        lesser than the string length
     *
     * @return a substring
     */
    @Override
    public CharSequence subSequence(int start, int end) {

        return getFontName().subSequence(start, end);
    }

    /**
     * Returns a string representation of this enumeration element.
     *
     * @return a string representation
     */
    @Override
    public String toString() {

        return getFontName();
    }

}
