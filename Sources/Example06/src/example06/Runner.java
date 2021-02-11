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

package example06;


import example06.config.ComponentConfigurations;

import guitools.core.components.BorderedPanel;
import guitools.core.components.VerticalComponentsPanel;
import guitools.core.utils.ComponentHelper;
import guitools.core.view.test.TestFrame;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class Runner {

    /**
     * The main method.
     *
     * @param args
     *        command line arguments
     */
    public static void main(String[] args) {

        JComponent panelNN =
            ComponentHelper.createTitledHorizontalLabelComponentsPanel("Title#1", ComponentConfigurations.LABEL1,
                                                                       ComponentConfigurations.COMBOBOX1);

        JComponent panelN =
            ComponentHelper.createTitledHorizontalLabelComponentsPanel("Title#2", ComponentConfigurations.LABEL2,
                                                                       ComponentConfigurations.TEXTFIELD1,
                                                                       ComponentConfigurations.LABEL3,
                                                                       ComponentConfigurations.COMBOBOX2,
                                                                       ComponentConfigurations.LABEL4,
                                                                       ComponentConfigurations.COMBOBOX3);

        JComponent panelCenter =
            ComponentHelper.createTitledHorizontalLabelComponentsPanel("Title#3", ComponentConfigurations.LABEL5,
                                                                       ComponentConfigurations.TEXTFIELD2,
                                                                       ComponentConfigurations.LABEL6,
                                                                       ComponentConfigurations.COMBOBOX4,
                                                                       ComponentConfigurations.LABEL7,
                                                                       ComponentConfigurations.TEXTFIELD3);

        JComponent panel = new VerticalComponentsPanel(panelNN, panelN, panelCenter);


        JComponent panelSW = new BorderedPanel("Title#4", ComponentHelper.newInstance(ComponentConfigurations.LIST));
        JComponent panelSE =
            new BorderedPanel("Title#5", ComponentHelper.newInstance(ComponentConfigurations.TEXTAREA));
        JSplitPane splitPane =
            new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ComponentHelper.embedInScrollPane(panelSW),
                           ComponentHelper.embedInScrollPane(panelSE));

        JComponent panelS = new JPanel();
        panelS.add(splitPane);
        panelS.setPreferredSize(new Dimension(panel.getPreferredSize().width, panel.getPreferredSize().height));


        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(panel);
        p.add(panelS);


        TestFrame frame = new TestFrame(p);
        frame.setTitle("Example06");
        frame.setPreferredSize(new Dimension(400, 600));
        frame.pack();
        frame.setVisible(true);
    }

}
