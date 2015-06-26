/*
 * This file is part of ProDisFuzz, modified on 6/26/15 9:26 PM.
 * Copyright (c) 2013-2015 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package model.process;

import java.util.Observable;

public abstract class AbstractProcess extends Observable {

    /**
     * Resets all variables to the default value and notifies all observers.
     */
    public abstract void reset();

    /**
     * Notifies all observers about an update.
     */
    protected void spreadUpdate() {
        setChanged();
        notifyObservers();
    }

}
