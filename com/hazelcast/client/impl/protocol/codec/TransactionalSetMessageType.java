package com.hazelcast.client.impl.protocol.codec;

public enum TransactionalSetMessageType {

    TRANSACTIONALSET_ADD(0x1201),
    TRANSACTIONALSET_REMOVE(0x1202),
    TRANSACTIONALSET_SIZE(0x1203);

    private final int id;

    TransactionalSetMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


