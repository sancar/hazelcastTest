package com.hazelcast.client.impl.protocol.codec;

public enum AtomicLongMessageType {

    ATOMICLONG_APPLY(0x0a01),
    ATOMICLONG_ALTER(0x0a02),
    ATOMICLONG_ALTERANDGET(0x0a03),
    ATOMICLONG_GETANDALTER(0x0a04),
    ATOMICLONG_ADDANDGET(0x0a05),
    ATOMICLONG_COMPAREANDSET(0x0a06),
    ATOMICLONG_DECREMENTANDGET(0x0a07),
    ATOMICLONG_GET(0x0a08),
    ATOMICLONG_GETANDADD(0x0a09),
    ATOMICLONG_GETANDSET(0x0a0a),
    ATOMICLONG_INCREMENTANDGET(0x0a0b),
    ATOMICLONG_GETANDINCREMENT(0x0a0c),
    ATOMICLONG_SET(0x0a0d);

    private final int id;

    AtomicLongMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


