package com.hazelcast.client.impl.protocol.codec;

public enum MapReduceMessageType {

    MAPREDUCE_CANCEL(0x0f01),
    MAPREDUCE_JOBPROCESSINFORMATION(0x0f02),
    MAPREDUCE_FORMAP(0x0f03),
    MAPREDUCE_FORLIST(0x0f04),
    MAPREDUCE_FORSET(0x0f05),
    MAPREDUCE_FORMULTIMAP(0x0f06),
    MAPREDUCE_FORCUSTOM(0x0f07);

    private final int id;

    MapReduceMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


