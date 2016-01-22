package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MultiMapGetCodec {

    public static final MultiMapMessageType REQUEST_TYPE = MultiMapMessageType.MULTIMAP_GET;
    public static final int RESPONSE_TYPE = 106;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MultiMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data key;
        public long threadId;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, long
 threadId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, long
 threadId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, key, threadId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(key);
        clientMessage.set(threadId);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        com.hazelcast.nio.serialization.Data key = null;
        key = clientMessage.getData();
            parameters.key = key;
        long threadId ;
        threadId = clientMessage.getLong();
            parameters.threadId = threadId;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<com.hazelcast.nio.serialization.Data> response;

        public static int calculateDataSize(java.util.Collection<com.hazelcast.nio.serialization.Data> response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data response_item : response ) {
            dataSize += ParameterUtil.calculateDataSize(response_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<com.hazelcast.nio.serialization.Data> response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response.size());
        for (com.hazelcast.nio.serialization.Data response_item : response) {
        clientMessage.set(response_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<com.hazelcast.nio.serialization.Data> response = null;
            int response_size = clientMessage.getInt();
            response = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(response_size);
            for (int response_index = 0;response_index<response_size;response_index++) {
                com.hazelcast.nio.serialization.Data response_item;
        response_item = clientMessage.getData();
                response.add(response_item);
            }
            parameters.response = response;
        return parameters;
    }

}