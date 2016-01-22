package com.hazelcast.client.impl.protocol.codec;

public enum CountDownLatchMessageType {

    COUNTDOWNLATCH_AWAIT(0x0c01),
    COUNTDOWNLATCH_COUNTDOWN(0x0c02),
    COUNTDOWNLATCH_GETCOUNT(0x0c03),
    COUNTDOWNLATCH_TRYSETCOUNT(0x0c04);

    private final int id;

    CountDownLatchMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


