package com.hazelcast.client.impl.protocol.codec;

public enum EnterpriseMapMessageType {

    ENTERPRISEMAP_PUBLISHERCREATEWITHVALUE(0x1801),
    ENTERPRISEMAP_PUBLISHERCREATE(0x1802),
    ENTERPRISEMAP_MADEPUBLISHABLE(0x1803),
    ENTERPRISEMAP_ADDLISTENER(0x1804),
    ENTERPRISEMAP_SETREADCURSOR(0x1805),
    ENTERPRISEMAP_DESTROYCACHE(0x1806);

    private final int id;

    EnterpriseMapMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


