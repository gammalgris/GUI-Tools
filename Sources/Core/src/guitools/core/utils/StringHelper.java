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

package guitools.core.utils;


/**
 * This helper class contains helper functions for string processing.
 *
 * @author Kristian Kutin
 */
public final class StringHelper {

    /**
     * The default constructor.
     */
    private StringHelper() {

        throw new UnsupportedOperationException();
    }

    /**
     * Returns the string representation of the specified char sequence. If the specified
     * parameter is <code>null</code> the actual value is returned instead.
     *
     * @param aCharSequence
     *
     * @return a string representation
     */
    public static String valueOf(CharSequence aCharSequence) {

        if (aCharSequence == null) {

            return null;

        } else {

            return String.valueOf(aCharSequence);
        }
    }

}
