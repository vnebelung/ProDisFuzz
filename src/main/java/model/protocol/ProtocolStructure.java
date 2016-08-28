/*
 * This file is part of ProDisFuzz, modified on 28.08.16 19:39.
 * Copyright (c) 2013-2016 Volker Nebelung <vnebelung@prodisfuzz.net>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */

package model.protocol;

import model.protocol.ProtocolBlock.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the protocol structure representing the whole protocol used for fuzzing.
 */
public class ProtocolStructure {

    private final List<ProtocolBlock> protocolBlocks;

    /**
     * Constructs a new protocol structure.
     */
    public ProtocolStructure() {
        protocolBlocks = new ArrayList<>();
    }

    /**
     * Adds a protocol block to the protocol structure. The given bytes must only contain null values or not null
     * values. If mixed null - not null combinations are found, the data block will be silently dropped.
     *
     * @param bytes the bytes
     */
    public void addBlock(List<Byte> bytes) {
        boolean fixed = true;
        boolean variable = true;
        for (Byte each : bytes) {
            if (each == null) {
                fixed = false;
            } else {
                variable = false;
            }
        }
        if (!fixed && !variable) {
            return;
        }
        // noinspection UnqualifiedInnerClassAccess
        Type type = fixed ? Type.FIX : Type.VAR;
        protocolBlocks.add(new ProtocolBlock(type, bytes.toArray(new Byte[bytes.size()])));
    }

    /**
     * Clears the structure from any defined protocol blocks.
     */
    public void clear() {
        protocolBlocks.clear();
    }

    /**
     * Returns the number of protocol blocks.
     *
     * @return the number of protocol blocks
     */
    public int getSize() {
        return protocolBlocks.size();
    }

    /**
     * Returns the protocol block with the given index
     *
     * @param index the block index
     * @return the protocol block
     */
    public ProtocolBlock getBlock(int index) {
        return protocolBlocks.get(index);
    }

    /**
     * Returns the bytes of all protocol blocks as a single byte sequence.
     *
     * @return the byte values
     */
    public Byte[] getBytes() {
        int size = 0;
        for (ProtocolBlock each : protocolBlocks) {
            size += each.getBytes().length;
        }
        Byte[] result = new Byte[size];
        int index = 0;
        for (ProtocolBlock eachProtocolBlock : protocolBlocks) {
            for (Byte eachByte : eachProtocolBlock.getBytes()) {
                result[index] = eachByte;
                index++;
            }
        }
        return result;
    }
}
