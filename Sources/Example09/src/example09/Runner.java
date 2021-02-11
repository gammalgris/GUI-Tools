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

package example09;

import guitools.core.components.BorderedPanel;
import guitools.core.utils.ComponentHelper;
import guitools.core.view.test.TestFrame;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import example09.config.ComponentConfigurations;


public class Runner {

    /**
     * The main method.
     *
     * @param args
     *        command line arguments
     */
    public static void main(String[] args) {

        /* JComponent panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));*/

        JComponent panelSW = new BorderedPanel("Title#4", ComponentHelper.newInstance(ComponentConfigurations.LIST));
        JComponent panelSE =
            new BorderedPanel("Title#5", ComponentHelper.newInstance(ComponentConfigurations.TEXTAREA));
        JSplitPane splitPane =
            new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ComponentHelper.embedInScrollPane(panelSW),
                           ComponentHelper.embedInScrollPane(panelSE));

        JComponent panelS = new JPanel();
        panelS.add(splitPane);
        //panelS.setPreferredSize(new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height));


        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(panelS);


        TestFrame frame = new TestFrame(p);
        frame.setTitle("Example08");
        frame.setPreferredSize(new Dimension(930, 500));
        frame.pack();
        frame.setVisible(true);
    }

}
