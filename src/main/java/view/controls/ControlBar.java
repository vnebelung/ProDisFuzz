/*
 * This file is part of ProDisFuzz, modified on 28.08.16 19:39.
 * Copyright (c) 2013-2016 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package view.controls;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import view.window.FxmlConnection;
import view.window.NavigationControl;

/**
 * This class is a JavaFX based control bar, responsible for displaying various navigation controls and information
 * elements.
 */
public class ControlBar extends HBox {

    private final MemoryTimer memoryTimer;
    @FXML
    private Button cancelButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button finishButton;
    @FXML
    private Label memoryUsage;
    private NavigationControl navigationControl;

    /**
     * Constructs a new control bar.
     */
    public ControlBar() {
        super();
        //noinspection HardCodedStringLiteral
        FxmlConnection.connect(getClass().getResource("/fxml/controlBar.fxml"), this);
        memoryTimer = new MemoryTimer(memoryUsage);
        memoryTimer.start();
    }

    /**
     * Sets the visibility status of the navigation buttons. All navigation buttons can be hidden if they are not
     * needed.
     *
     * @param visible true, if the buttons shall be visible. Default is true.
     */
    public void setNavigationVisible(boolean visible) {
        cancelButton.setVisible(visible);
        nextButton.setVisible(visible);
        finishButton.setVisible(visible);
    }

    /**
     * Stops the memory timer.
     */
    public void onClose() {
        memoryTimer.stop();
    }

    /**
     * Handles the action of the cancel button.
     */
    @FXML
    private void cancel() {
        navigationControl.resetPage();
    }

    /**
     * Handles the action of the finish button.
     */
    @FXML
    private void finish() {
        navigationControl.resetPage();
    }

    /**
     * Handles the action of the next button.
     */
    @FXML
    private void next() {
        navigationControl.nextPage();
    }

    /**
     * Sets the enabled status of the next button.
     *
     * @param enabled true, if the button should be enabled
     */
    public void setNextEnabled(boolean enabled) {
        nextButton.setDisable(!enabled);
    }

    /**
     * Sets the enabled status of the cancel button.
     *
     * @param enabled true, if the button should be enabled
     */
    public void setCancelEnabled(boolean enabled) {
        cancelButton.setDisable(!enabled);
    }

    /**
     * Sets the enabled status of the finish button.
     *
     * @param enabled true, if the button should be enabled
     */
    public void setFinishEnabled(boolean enabled) {
        finishButton.setDisable(!enabled);
    }

    /**
     * Sets the navigation control that handles the actions to navigate through pages.
     *
     * @param navigationControl the navigation control
     */
    public void setNavigationControl(NavigationControl navigationControl) {
        this.navigationControl = navigationControl;
    }
}
