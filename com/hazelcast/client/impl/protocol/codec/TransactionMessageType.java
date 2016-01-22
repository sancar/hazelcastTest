package com.hazelcast.client.impl.protocol.codec;

public enum TransactionMessageType {

    TRANSACTION_COMMIT(0x1701),
    TRANSACTION_CREATE(0x1702),
    TRANSACTION_ROLLBACK(0x1703);

    private final int id;

    TransactionMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


