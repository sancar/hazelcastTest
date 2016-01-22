package com.hazelcast.client.impl.protocol.codec;

public enum ExecutorServiceMessageType {

    EXECUTORSERVICE_SHUTDOWN(0x0901),
    EXECUTORSERVICE_ISSHUTDOWN(0x0902),
    EXECUTORSERVICE_CANCELONPARTITION(0x0903),
    EXECUTORSERVICE_CANCELONADDRESS(0x0904),
    EXECUTORSERVICE_SUBMITTOPARTITION(0x0905),
    EXECUTORSERVICE_SUBMITTOADDRESS(0x0906);

    private final int id;

    ExecutorServiceMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


