package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class RingbufferAddAllCodec {

    public static final RingbufferMessageType REQUEST_TYPE = RingbufferMessageType.RINGBUFFER_ADDALL;
    public static final int RESPONSE_TYPE = 103;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final RingbufferMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.util.List<com.hazelcast.nio.serialization.Data> valueList;
        public int overflowPolicy;

        public static int calculateDataSize(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> valueList, int
 overflowPolicy) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data valueList_item : valueList ) {
            dataSize += ParameterUtil.calculateDataSize(valueList_item);
            }
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> valueList, int
 overflowPolicy) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, valueList, overflowPolicy);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(valueList.size());
        for (com.hazelcast.nio.serialization.Data valueList_item : valueList) {
        clientMessage.set(valueList_item);
        }
        clientMessage.set(overflowPolicy);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.util.List<com.hazelcast.nio.serialization.Data> valueList = null;
            int valueList_size = clientMessage.getInt();
            valueList = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(valueList_size);
            for (int valueList_index = 0;valueList_index<valueList_size;valueList_index++) {
                com.hazelcast.nio.serialization.Data valueList_item;
        valueList_item = clientMessage.getData();
                valueList.add(valueList_item);
            }
            parameters.valueList = valueList;
        int overflowPolicy ;
        overflowPolicy = clientMessage.getInt();
            parameters.overflowPolicy = overflowPolicy;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public long response;

        public static int calculateDataSize(long
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(long
 response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response);
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        long response ;
        response = clientMessage.getLong();
            parameters.response = response;
        return parameters;
    }

}
