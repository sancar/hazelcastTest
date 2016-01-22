package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class RingbufferReadManyCodec {

    public static final RingbufferMessageType REQUEST_TYPE = RingbufferMessageType.RINGBUFFER_READMANY;
    public static final int RESPONSE_TYPE = 115;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final RingbufferMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public long startSequence;
        public int minCount;
        public int maxCount;
        public com.hazelcast.nio.serialization.Data filter;

        public static int calculateDataSize(java.lang.String
 name, long
 startSequence, int
 minCount, int
 maxCount, com.hazelcast.nio.serialization.Data
 filter) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (filter != null) {
            dataSize += ParameterUtil.calculateDataSize(filter);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, long
 startSequence, int
 minCount, int
 maxCount, com.hazelcast.nio.serialization.Data
 filter) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, startSequence, minCount, maxCount, filter);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(startSequence);
        clientMessage.set(minCount);
        clientMessage.set(maxCount);
        boolean filter_isNull;
        if (filter == null) {
            filter_isNull = true;
            clientMessage.set(filter_isNull);
        } else {
            filter_isNull= false;
            clientMessage.set(filter_isNull);
        clientMessage.set(filter);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        long startSequence ;
        startSequence = clientMessage.getLong();
            parameters.startSequence = startSequence;
        int minCount ;
        minCount = clientMessage.getInt();
            parameters.minCount = minCount;
        int maxCount ;
        maxCount = clientMessage.getInt();
            parameters.maxCount = maxCount;
        com.hazelcast.nio.serialization.Data filter = null;
        boolean filter_isNull = clientMessage.getBoolean();
        if (!filter_isNull) {
        filter = clientMessage.getData();
            parameters.filter = filter;
        }
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public int readCount;
        public java.util.List<com.hazelcast.nio.serialization.Data> items;

        public static int calculateDataSize(int
 readCount, java.util.Collection<com.hazelcast.nio.serialization.Data> items) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data items_item : items ) {
            dataSize += ParameterUtil.calculateDataSize(items_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(int
 readCount, java.util.Collection<com.hazelcast.nio.serialization.Data> items) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(readCount, items);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(readCount);
        clientMessage.set(items.size());
        for (com.hazelcast.nio.serialization.Data items_item : items) {
        clientMessage.set(items_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        int readCount ;
        readCount = clientMessage.getInt();
            parameters.readCount = readCount;
        java.util.List<com.hazelcast.nio.serialization.Data> items = null;
            int items_size = clientMessage.getInt();
            items = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(items_size);
            for (int items_index = 0;items_index<items_size;items_index++) {
                com.hazelcast.nio.serialization.Data items_item;
        items_item = clientMessage.getData();
                items.add(items_item);
            }
            parameters.items = items;
        return parameters;
    }

}
