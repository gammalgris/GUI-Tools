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

package example01;


import guitools.core.view.test.TestFrame;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;


/**
 * An example which shows an empty frame.
 *
 * @author Kristian Kutin
 */
public class Runner {

    /**
     * The main method.
     *
     * @param args
     *        command line arguments
     */
    public static void main(String[] args) {

        JComponent component = new JPanel();

        TestFrame frame = new TestFrame(component);
        frame.setTitle("Example01");
        frame.setPreferredSize(new Dimension(300, 200));
        frame.pack();
        frame.setVisible(true);
    }

}
