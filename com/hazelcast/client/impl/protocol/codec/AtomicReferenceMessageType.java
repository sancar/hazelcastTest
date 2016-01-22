package com.hazelcast.client.impl.protocol.codec;

public enum AtomicReferenceMessageType {

    ATOMICREFERENCE_APPLY(0x0b01),
    ATOMICREFERENCE_ALTER(0x0b02),
    ATOMICREFERENCE_ALTERANDGET(0x0b03),
    ATOMICREFERENCE_GETANDALTER(0x0b04),
    ATOMICREFERENCE_CONTAINS(0x0b05),
    ATOMICREFERENCE_COMPAREANDSET(0x0b06),
    ATOMICREFERENCE_GET(0x0b08),
    ATOMICREFERENCE_SET(0x0b09),
    ATOMICREFERENCE_CLEAR(0x0b0a),
    ATOMICREFERENCE_GETANDSET(0x0b0b),
    ATOMICREFERENCE_SETANDGET(0x0b0c),
    ATOMICREFERENCE_ISNULL(0x0b0d);

    private final int id;

    AtomicReferenceMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


