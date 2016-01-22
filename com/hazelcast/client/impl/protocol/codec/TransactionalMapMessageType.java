package com.hazelcast.client.impl.protocol.codec;

public enum TransactionalMapMessageType {

    TRANSACTIONALMAP_CONTAINSKEY(0x1001),
    TRANSACTIONALMAP_GET(0x1002),
    TRANSACTIONALMAP_GETFORUPDATE(0x1003),
    TRANSACTIONALMAP_SIZE(0x1004),
    TRANSACTIONALMAP_ISEMPTY(0x1005),
    TRANSACTIONALMAP_PUT(0x1006),
    TRANSACTIONALMAP_SET(0x1007),
    TRANSACTIONALMAP_PUTIFABSENT(0x1008),
    TRANSACTIONALMAP_REPLACE(0x1009),
    TRANSACTIONALMAP_REPLACEIFSAME(0x100a),
    TRANSACTIONALMAP_REMOVE(0x100b),
    TRANSACTIONALMAP_DELETE(0x100c),
    TRANSACTIONALMAP_REMOVEIFSAME(0x100d),
    TRANSACTIONALMAP_KEYSET(0x100e),
    TRANSACTIONALMAP_KEYSETWITHPREDICATE(0x100f),
    TRANSACTIONALMAP_VALUES(0x1010),
    TRANSACTIONALMAP_VALUESWITHPREDICATE(0x1011);

    private final int id;

    TransactionalMapMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


