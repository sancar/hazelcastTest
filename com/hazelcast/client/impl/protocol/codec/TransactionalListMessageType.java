package com.hazelcast.client.impl.protocol.codec;

public enum TransactionalListMessageType {

    TRANSACTIONALLIST_ADD(0x1301),
    TRANSACTIONALLIST_REMOVE(0x1302),
    TRANSACTIONALLIST_SIZE(0x1303);

    private final int id;

    TransactionalListMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


