package com.hazelcast.client.impl.protocol.codec;

public enum TopicMessageType {

    TOPIC_PUBLISH(0x0401),
    TOPIC_ADDMESSAGELISTENER(0x0402),
    TOPIC_REMOVEMESSAGELISTENER(0x0403);

    private final int id;

    TopicMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


