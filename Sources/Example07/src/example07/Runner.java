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

package example07;


import example07.config.ComponentConfigurations;

import static guitools.core.config.Constants.DX;
import static guitools.core.config.Constants.DY;
import guitools.core.utils.ComponentHelper;
import guitools.core.view.test.TestFrame;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;


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

        TestFrame frame = new TestFrame(panel);
        frame.setTitle("Example07");
        frame.setPreferredSize(new Dimension(400, 600));
        frame.pack();
        frame.setVisible(true);

    }

}
