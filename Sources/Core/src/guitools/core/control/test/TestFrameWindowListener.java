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

package guitools.core.control.test;


import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class TestFrameWindowListener implements WindowListener {

    public TestFrameWindowListener() {

        super();
    }

    @Override
    public void windowOpened(WindowEvent e) {

        logEvent(e);
    }

    @Override
    public void windowClosing(WindowEvent e) {

        logEvent(e);

        Window window = e.getWindow();
        if (window != null) {

            window.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

        logEvent(e);
    }

    @Override
    public void windowIconified(WindowEvent e) {

        logEvent(e);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {

        logEvent(e);
    }

    @Override
    public void windowActivated(WindowEvent e) {

        logEvent(e);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

        logEvent(e);
    }

    private void logEvent(WindowEvent e) {

        synchronized (this) {

            System.out.println("DEBUG::" + e);
        }
    }

}
