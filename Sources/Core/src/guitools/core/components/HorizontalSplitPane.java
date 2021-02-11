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


import javax.swing.JComponent;
import javax.swing.JSplitPane;

import guitools.core.utils.ComponentHelper;


public class HorizontalSplitPane extends JSplitPane {

    public HorizontalSplitPane(JComponent aLeftComponent, JComponent aRightComponent) {

        super(JSplitPane.HORIZONTAL_SPLIT, ComponentHelper.embedInScrollPane(aLeftComponent),
              ComponentHelper.embedInScrollPane(aRightComponent));

        initSelf();
        initComponents();
        initLayout();
    }

    private void initSelf() {

    }

    private void initComponents() {

    }

    private void initLayout() {

    }

}
