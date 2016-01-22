package com.hazelcast.client.impl.protocol.codec;

public enum RingbufferMessageType {

    RINGBUFFER_SIZE(0x1901),
    RINGBUFFER_TAILSEQUENCE(0x1902),
    RINGBUFFER_HEADSEQUENCE(0x1903),
    RINGBUFFER_CAPACITY(0x1904),
    RINGBUFFER_REMAININGCAPACITY(0x1905),
    RINGBUFFER_ADD(0x1906),
    RINGBUFFER_READONE(0x1908),
    RINGBUFFER_ADDALL(0x1909),
    RINGBUFFER_READMANY(0x190a);

    private final int id;

    RingbufferMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


