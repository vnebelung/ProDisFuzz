/*
 * This file is part of ProDisFuzz, modified on 28.08.16 19:39.
 * Copyright (c) 2013-2016 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package view.controls;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is a JAVAFX based timer, for displaying the current memory consumption in periodic intervals.
 */
public class MemoryTimer {

    private final Label label;
    private final Timer timer;

    /**
     * Constructs a new memory timer.
     *
     * @param label the label the memory consumption will be displayed in
     */
    public MemoryTimer(Label label) {
        super();
        this.label = label;
        timer = new Timer();
    }

    /**
     * Starts the timer.
     */
    public void start() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                DecimalFormat numberFormat = new DecimalFormat("#0");
                String totalMemory = numberFormat.format(Runtime.getRuntime().totalMemory() / 1024 / 1024);
                String usedMemory = numberFormat.format((Runtime.getRuntime().totalMemory() - Runtime.getRuntime()
                        .freeMemory()) / 1024 / 1024);
                //noinspection HardCodedStringLiteral
                Platform.runLater(() -> label.setText(usedMemory + '/' + totalMemory + " MB"));
            }
        }, 2000, 2000);
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        timer.cancel();
    }

}
