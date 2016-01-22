package com.hazelcast.client.impl.protocol.codec;

public enum TransactionalQueueMessageType {

    TRANSACTIONALQUEUE_OFFER(0x1401),
    TRANSACTIONALQUEUE_TAKE(0x1402),
    TRANSACTIONALQUEUE_POLL(0x1403),
    TRANSACTIONALQUEUE_PEEK(0x1404),
    TRANSACTIONALQUEUE_SIZE(0x1405);

    private final int id;

    TransactionalQueueMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


