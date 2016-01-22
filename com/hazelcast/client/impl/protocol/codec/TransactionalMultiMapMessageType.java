package com.hazelcast.client.impl.protocol.codec;

public enum TransactionalMultiMapMessageType {

    TRANSACTIONALMULTIMAP_PUT(0x1101),
    TRANSACTIONALMULTIMAP_GET(0x1102),
    TRANSACTIONALMULTIMAP_REMOVE(0x1103),
    TRANSACTIONALMULTIMAP_REMOVEENTRY(0x1104),
    TRANSACTIONALMULTIMAP_VALUECOUNT(0x1105),
    TRANSACTIONALMULTIMAP_SIZE(0x1106);

    private final int id;

    TransactionalMultiMapMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


