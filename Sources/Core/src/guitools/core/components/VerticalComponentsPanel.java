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


import static guitools.core.config.Constants.GAPX;
import static guitools.core.config.Constants.GAPY;

import java.awt.Dimension;

import java.util.Arrays;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class VerticalComponentsPanel extends JPanel {

    private List<JComponent> components;

    public VerticalComponentsPanel(JComponent... allComponents) {

        super();

        components = Arrays.asList(allComponents);

        initSelf();
        initComponents();
        initLayout();
    }

    private void initSelf() {

        setLayout(null);
    }

    private void initComponents() {

        for (JComponent component : components) {

            add(component);
        }
    }

    private void initLayout() {

        int length = components.size();
        Dimension[] d = new Dimension[length];

        for (int a = 0; a < length; a++) {

            d[a] = components.get(a).getPreferredSize();
        }

        int x = 0;
        int y = 0;
        for (int a = 0; a < length; a++) {

            JComponent component = components.get(a);
            component.setSize(d[a]);

            y += GAPY;
            component.setLocation(GAPX, y);
            x = Math.max(x, d[a].width);
            y += d[a].height;
        }
        x += 2 * GAPX;
        y += GAPY;

        Dimension dn = new Dimension(x, y);
        setPreferredSize(dn);
        setSize(dn);
        setLocation(0, 0);
    }

}
