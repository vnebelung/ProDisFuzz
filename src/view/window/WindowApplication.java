/*
 * This file is part of ProDisFuzz, modified on 13.03.14 22:09.
 * Copyright (c) 2013-2014 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package view.window;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowApplication extends Application {

    @Override
    public void start(Stage stage) {
        Window window = new Window();

        Scene scene = new Scene(new Window());
        stage.setScene(scene);
        stage.setTitle("ProDisFuzz");
        stage.setOnCloseRequest(windowEvent -> {
            window.onClose();
        });
        stage.show();

        initUpdateCheck(stage);
    }

    /**
     * Starts the check for an update of ProDisFuzz.
     *
     * @param stage the stage
     */
    private void initUpdateCheck(Stage stage) {
        new UpdateTimer(stage).start();
    }

    /**
     * Makes the basic window visible.
     */
    public void show() {
        launch();
    }
}
