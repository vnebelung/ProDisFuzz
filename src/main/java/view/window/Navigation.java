/*
 * This file is part of ProDisFuzz, modified on 28.08.16 19:39.
 * Copyright (c) 2013-2016 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package view.window;

import javafx.scene.Node;

/**
 * This interface represents a navigation component, responsible for displaying navigation elements.
 */
public interface Navigation {

    /**
     * Sets whether the control panel should enable the option to cancel the current page.
     *
     * @param enabled true, if the cancel option should be enabled
     * @param node the Node that sends the signal
     */
    void setFinishable(boolean enabled, Node node);

    /**
     * Sets whether the control panel should enable the option to finish the current page.
     *
     * @param enabled true, if the finish option should be enabled
     * @param node the Node that sends the signal
     */
    void setCancelable(boolean enabled, Node node);
}
