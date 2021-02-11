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


import static guitools.core.config.Constants.DX;
import static guitools.core.config.Constants.DY;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class BorderedPanel extends JPanel {

    private String title;

    private JComponent component;

    public BorderedPanel(String aTitle, JComponent aComponent) {

        super();

        title = aTitle;
        component = aComponent;

        initSelf();
        initComponents();
        initLayout();
    }

    private void initSelf() {

        setLayout(null);
    }

    private void initComponents() {

        add(component);
    }

    private void initLayout() {

        Dimension d1 = component.getPreferredSize();

        component.setSize(d1);
        component.setLocation(DX, DY);

        Dimension d2 = new Dimension(DX * 2 + d1.width, DY * 2 + d1.height);
        setPreferredSize(d2);
        setSize(d2);
        setLocation(0, 0);

        Border border = BorderFactory.createTitledBorder(title);
        setBorder(border);
    }

}
