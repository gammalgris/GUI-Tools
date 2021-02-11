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

package example08;


import example08.config.ComponentConfigurations;

import guitools.core.components.BorderedPanel;
import static guitools.core.config.Constants.DX;
import static guitools.core.config.Constants.DY;
import guitools.core.utils.ComponentHelper;
import guitools.core.view.test.TestFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;

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

        JComponent panelNW =
            ComponentHelper.createTitledHorizontalLabelComponentsPanel("Title#1", ComponentConfigurations.LABEL1,
                                                                       ComponentConfigurations.COMBOBOX1);

        JComponent panelNE =
            ComponentHelper.createTitledHorizontalLabelComponentsPanel("Title#2", ComponentConfigurations.LABEL2,
                                                                       ComponentConfigurations.TEXTFIELD1,
                                                                       ComponentConfigurations.LABEL3,
                                                                       ComponentConfigurations.COMBOBOX2,
                                                                       ComponentConfigurations.LABEL4,
                                                                       ComponentConfigurations.COMBOBOX3);

        JComponent panelCenter =
            ComponentHelper.createTitledHorizontalLabelComponentsPanelWithButtons("Title#3",
                                                                                  ComponentConfigurations.LABEL5,
                                                                                  ComponentConfigurations.TEXTFIELD2,
                                                                                  ComponentConfigurations.LABEL6,
                                                                                  ComponentConfigurations.COMBOBOX4,
                                                                                  ComponentConfigurations.LABEL7,
                                                                                  ComponentConfigurations.TEXTFIELD3,
                                                                                  ComponentConfigurations.BUTTON);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(3 * DX + panelNW.getPreferredSize().width +
                                             panelNE.getPreferredSize().width,
                                             3 * DY + panelNW.getPreferredSize().height +
                                             panelCenter.getPreferredSize().height));

        panel.add(panelNW);
        panelNW.setLocation(DX, DY);

        panel.add(panelNE);
        panelNE.setLocation(2 * DX + panelNW.getPreferredSize().width, DY);

        panel.add(panelCenter);
        panelCenter.setLocation(DX, 2 * DY + panelNW.getPreferredSize().height);


        /* int width = 3 * DX + panelNW.getPreferredSize().width + panelNE.getPreferredSize().width;
        int height = 3 * DY + panelNW.getPreferredSize().height + panelCenter.getPreferredSize().height;

        JComponent panelSW = new BorderedPanel("Title#4", ComponentHelper.newInstance(ComponentConfigurations.LIST));
        panelSW.setLocation(DX, DY);
        panelSW.setPreferredSize(new Dimension((width - 2 * DX) / 3, height - 2 * DY));

        JComponent panelSE =
            new BorderedPanel("Title#5", ComponentHelper.newInstance(ComponentConfigurations.TEXTAREA));
        panelSW.setLocation(width / 3 + DX, DY);
        panelSW.setPreferredSize(new Dimension((height - 2 * DX) * 2 / 3, height - 2 * DY));

        JSplitPane splitPane =
            new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ComponentHelper.embedInScrollPane(panelSW),
                           ComponentHelper.embedInScrollPane(panelSE));

        JComponent panelS = new JPanel();
        panelS.add(splitPane);
        panelS.setLocation(DX, 3 * DY + panelNW.getPreferredSize().height + panelCenter.getPreferredSize().height);
        panelS.setPreferredSize(new Dimension(width, height));

        panel.add(panelS);
        /*panel.add(splitPane);
        splitPane.setLocation(DX, 3 * DY + panelNW.getPreferredSize().height + panelCenter.getPreferredSize().height);
        splitPane.setPreferredSize(new Dimension(width, height));*/

        int width = 3 * DX + panelNW.getPreferredSize().width + panelNE.getPreferredSize().width;
        int height = 3 * DY + panelNW.getPreferredSize().height + panelCenter.getPreferredSize().height;

        JComponent panelSW = new BorderedPanel("Title#4", ComponentHelper.newInstance(ComponentConfigurations.LIST));
        JComponent panelSE =
            new BorderedPanel("Title#5", ComponentHelper.newInstance(ComponentConfigurations.TEXTAREA));
        JSplitPane splitPane =
            new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ComponentHelper.embedInScrollPane(panelSW),
                           ComponentHelper.embedInScrollPane(panelSE));

        JComponent panelS = new JPanel();
        panelS.setLayout(new FlowLayout());
        panelS.add(splitPane);
        panelS.setPreferredSize(new Dimension(width, height));


        TestFrame frame = new TestFrame(panel);
        frame.setTitle("Example08");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.pack();
        frame.setVisible(true);

    }

}
