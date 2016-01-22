package com.hazelcast.client.impl.protocol.codec;

public enum ClientMessageType {

    CLIENT_AUTHENTICATION(0x0002),
    CLIENT_AUTHENTICATIONCUSTOM(0x0003),
    CLIENT_ADDMEMBERSHIPLISTENER(0x0004),
    CLIENT_CREATEPROXY(0x0005),
    CLIENT_DESTROYPROXY(0x0006),
    CLIENT_GETPARTITIONS(0x0008),
    CLIENT_REMOVEALLLISTENERS(0x0009),
    CLIENT_ADDPARTITIONLOSTLISTENER(0x000a),
    CLIENT_REMOVEPARTITIONLOSTLISTENER(0x000b),
    CLIENT_GETDISTRIBUTEDOBJECTS(0x000c),
    CLIENT_ADDDISTRIBUTEDOBJECTLISTENER(0x000d),
    CLIENT_REMOVEDISTRIBUTEDOBJECTLISTENER(0x000e),
    CLIENT_PING(0x000f);

    private final int id;

    ClientMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


