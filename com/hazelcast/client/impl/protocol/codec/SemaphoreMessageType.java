package com.hazelcast.client.impl.protocol.codec;

public enum SemaphoreMessageType {

    SEMAPHORE_INIT(0x0d01),
    SEMAPHORE_ACQUIRE(0x0d02),
    SEMAPHORE_AVAILABLEPERMITS(0x0d03),
    SEMAPHORE_DRAINPERMITS(0x0d04),
    SEMAPHORE_REDUCEPERMITS(0x0d05),
    SEMAPHORE_RELEASE(0x0d06),
    SEMAPHORE_TRYACQUIRE(0x0d07);

    private final int id;

    SemaphoreMessageType(int messageType) {
        this.id = messageType;
    }

    public int id() {
        return id;
    }


}


