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

package guitools.core.utils;


import guitools.core.components.BorderedPanel;
import guitools.core.components.HorizontalComponentsPanel;
import guitools.core.components.HorizontalComponentsPanelWithButtons;
import guitools.core.components.LabelComponentPanel;
import guitools.core.config.ComponentConfiguration;
import guitools.core.utils.creators.ComponentCreator;
import guitools.core.utils.creators.DefaultComponentCreator;

import java.awt.Component;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


/**
 * This utilíty class provides operations around components.
 *
 * @author Kristian Kutin
 */
public final class ComponentHelper {

    /**
     * A creator singleton.
     */
    private static final ComponentCreator CREATOR_SINGLETON;

    /*
     * The static initializer.
     */
    static {

        CREATOR_SINGLETON = new DefaultComponentCreator();
    }

    /**
     * The default constructor.
     */
    private ComponentHelper() {

        throw new UnsupportedOperationException();
    }

    /**
     * Returns a new instance of a GUI component according to the
     * specified configuration.
     *
     * @param aConfiguration
     *
     * @return a new instance
     */
    public static JComponent newInstance(ComponentConfiguration aConfiguration) {

        return CREATOR_SINGLETON.newInstance(aConfiguration);
    }

    /**
     * Looks for the first component that has the specified component name. Ideally component
     * names should be unique within the object tree.
     *
     * @param aFrame
     * @param aComponentName
     *
     * @return a component or <code>null</code> if no such component could be found
     */
    public static JComponent findChildComponentByName(JFrame aFrame, CharSequence aComponentName) {

        for (Component child : aFrame.getContentPane().getComponents()) {

            if (child instanceof JComponent) {

                JComponent childComponent = (JComponent) child;
                return findChildComponentByName(childComponent, aComponentName);
            }
        }

        return null;
    }

    /**
     * Looks for the first component that has the specified component name. Ideally component
     * names should be unique within the object tree.
     *
     * @param aComponent
     * @param aComponentName
     *
     * @return a component or <code>null</code> if no such component could be found
     */
    public static JComponent findChildComponentByName(JComponent aComponent, CharSequence aComponentName) {

        CharSequence actualName = aComponent.getName();
        if ((actualName != null) && actualName.equals(aComponentName)) {

            return aComponent;
        }

        for (Component child : aComponent.getComponents()) {

            if (child instanceof JComponent) {

                JComponent childComponent = (JComponent) child;
                return findChildComponentByName(childComponent, aComponentName);
            }
        }

        return null;
    }

    /**
     *
     * @param aTitle
     * @param allConfigurations
     *
     * @return
     */
    public static JComponent createTitledHorizontalLabelComponentsPanel(String aTitle,
                                                                        ComponentConfiguration... allConfigurations) {

        if (allConfigurations == null) {

            String message = "No component configurations (null) have been specified!";
            throw new IllegalArgumentException(message);
        }

        if (allConfigurations.length == 0) {

            String message = "No component configurations (empty array) have been specified!";
            throw new IllegalArgumentException(message);
        }

        if (allConfigurations.length % 2 != 0) {

            String message =
                String.format("An uneven number of component configurations (%d) has been specified!",
                              allConfigurations.length);
            throw new IllegalArgumentException(message);
        }

        List<JLabel> labels = new ArrayList<>();
        List<JComponent> components = new ArrayList<>();
        int index = 0;
        while (index < allConfigurations.length) {

            JLabel label = (JLabel) newInstance(allConfigurations[index]);
            labels.add(label);

            JComponent component = newInstance(allConfigurations[index + 1]);
            components.add(component);

            index += 2;
        }

        List<JComponent> componentList = new ArrayList<>();
        for (int a = 0; a < labels.size(); a++) {

            JComponent component = new LabelComponentPanel<JComponent>(labels.get(a), components.get(a));
            componentList.add(component);
        }

        JComponent component = new HorizontalComponentsPanel(componentList.toArray(new JComponent[] { }));

        return new BorderedPanel(aTitle, component);
    }

    /**
     *
     * @param aTitle
     * @param allConfigurations
     *
     * @return
     */
    public static JComponent createTitledHorizontalLabelComponentsPanelWithButtons(String aTitle,
                                                                                   ComponentConfiguration... allConfigurations) {

        if (allConfigurations == null) {

            String message = "No component configurations (null) have been specified!";
            throw new IllegalArgumentException(message);
        }

        if (allConfigurations.length == 0) {

            String message = "No component configurations (empty array) have been specified!";
            throw new IllegalArgumentException(message);
        }


        List<JComponent> components = new ArrayList<>();

        for (ComponentConfiguration configuration : allConfigurations) {

            JComponent component = newInstance(configuration);
            components.add(component);
        }

        List<JComponent> buttons = extract(JButton.class, components);
        components.removeAll(buttons);


        if (components.size() % 2 != 0) {

            String message =
                String.format("An uneven number of component configurations (%d) has been specified!",
                              components.size());
            throw new IllegalArgumentException(message);
        }


        List<JLabel> labels = new ArrayList<>();
        List<JComponent> inputs = new ArrayList<>();
        int index = 0;
        while (index < components.size()) {

            JLabel label = (JLabel) components.get(index);
            labels.add(label);

            JComponent component = components.get(index + 1);
            inputs.add(component);

            index += 2;
        }


        List<JComponent> componentList = new ArrayList<>();
        for (int a = 0; a < labels.size(); a++) {

            JComponent component = new LabelComponentPanel<JComponent>(labels.get(a), inputs.get(a));
            componentList.add(component);
        }
        for (int a = 0; a < buttons.size(); a++) {

            componentList.add(buttons.get(a));
        }


        JComponent component = new HorizontalComponentsPanelWithButtons(componentList.toArray(new JComponent[] { }));

        return new BorderedPanel(aTitle, component);
    }

    public static JComponent embedInScrollPane(JComponent aComponent) {

        return new JScrollPane(aComponent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                               JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * Extracts all components with the specified type.
     *
     * @param aComponentType
     * @param allComponents
     *
     * @return a component list
     */
    public static List<JComponent> extract(Class aComponentType, JComponent... allComponents) {

        List<JComponent> result = new ArrayList<>();

        for (JComponent component : allComponents) {

            Class actualClass = component.getClass();

            if (aComponentType.isAssignableFrom(actualClass)) {

                result.add(component);
            }
        }

        return result;
    }

    /**
     * Extracts all components with the specified type.
     *
     * @param aComponentType
     * @param allComponents
     *
     * @return a component list
     */
    public static List<JComponent> extract(Class aComponentType, List<JComponent> allComponents) {

        List<JComponent> result = new ArrayList<>();

        for (JComponent component : allComponents) {

            Class actualClass = component.getClass();

            if (aComponentType.isAssignableFrom(actualClass)) {

                result.add(component);
            }
        }

        return result;
    }

}
