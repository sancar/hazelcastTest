package com.hazelcast.client.impl.protocol.codec;

public enum ConditionMessageType {

    CONDITION_AWAIT(0x0801),
    CONDITION_BEFOREAWAIT(0x0802),
    CONDITION_SIGNAL(0x0803),
    CONDITION_SIGNALALL(0x0804);

    private final int id;

    ConditionMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


