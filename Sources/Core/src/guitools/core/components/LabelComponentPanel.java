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

package guitools.core.components;


import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static guitools.core.config.Constants.GAPX;
import static guitools.core.config.Constants.GAPY;


public class LabelComponentPanel<T extends JComponent> extends JPanel {

    private JLabel label;

    private T component;

    public LabelComponentPanel(JLabel aLabel, T aComponent) {

        super();

        label = aLabel;
        component = aComponent;

        initSelf();
        initComponents();
        initLayout();
    }

    private void initSelf() {

        setLayout(null);
    }

    private void initComponents() {

        add(label);
        add(component);
    }

    private void initLayout() {

        Dimension d1 = label.getPreferredSize();
        Dimension d2 = component.getPreferredSize();

        label.setSize(d1);
        label.setLocation(GAPX, GAPY);

        component.setSize(d2);
        component.setLocation(GAPX, GAPY * 2 + d1.height);

        Dimension d3 = new Dimension(GAPX * 2 + Math.max(d1.width, d2.width), GAPY * 3 + d1.height + d2.height);
        setPreferredSize(d3);
        setSize(d3);
        setLocation(0, 0);
    }

}
