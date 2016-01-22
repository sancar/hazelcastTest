package com.hazelcast.client.impl.protocol.codec;

public enum XATransactionMessageType {

    XATRANSACTION_CLEARREMOTE(0x1601),
    XATRANSACTION_COLLECTTRANSACTIONS(0x1602),
    XATRANSACTION_FINALIZE(0x1603),
    XATRANSACTION_COMMIT(0x1604),
    XATRANSACTION_CREATE(0x1605),
    XATRANSACTION_PREPARE(0x1606),
    XATRANSACTION_ROLLBACK(0x1607);

    private final int id;

    XATransactionMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


