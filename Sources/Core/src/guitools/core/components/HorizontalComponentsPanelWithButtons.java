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
import guitools.core.utils.ComponentHelper;

import java.awt.Dimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class HorizontalComponentsPanelWithButtons extends JPanel {

    private static final int UNINITIALIZED;

    private List<JComponent> components;

    private List<JComponent> buttons;

    static {

        UNINITIALIZED = -1;
    }

    public HorizontalComponentsPanelWithButtons(JComponent... allComponents) {

        super();

        buttons = ComponentHelper.extract(JButton.class, allComponents);

        components = new ArrayList<>(Arrays.asList(allComponents));
        components.removeAll(buttons);

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

        for (JComponent component : buttons) {

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
        int minY = GAPY;
        for (int a = 0; a < length; a++) {

            JComponent component = components.get(a);
            component.setSize(d[a]);

            x += GAPX;
            component.setLocation(x, minY);
            x += d[a].width;
            y = Math.max(y, d[a].height);
        }
        x += GAPX;
        y += 4 * GAPY;


        int maxX = x;


        length = buttons.size();
        d = new Dimension[length];

        for (int a = 0; a < length; a++) {

            d[a] = buttons.get(a).getPreferredSize();
        }

        x = GAPX;
        minY = y;
        for (int a = 0; a < length; a++) {

            JComponent component = buttons.get(a);
            component.setSize(d[a]);

            x += GAPX;
            component.setLocation(x, minY);
            x += d[a].width;
            y = Math.max(y, minY + d[a].height);
        }
        x += GAPX;
        y += 2 * GAPY;


        maxX = Math.max(x, maxX);

        Dimension dn = new Dimension(maxX, y);
        setPreferredSize(dn);
        setSize(dn);
        setLocation(0, 0);
    }

}
