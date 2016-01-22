package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapExecuteOnKeysCodec {

    public static final MapMessageType REQUEST_TYPE = MapMessageType.MAP_EXECUTEONKEYS;
    public static final int RESPONSE_TYPE = 117;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data entryProcessor;
        public java.util.List<com.hazelcast.nio.serialization.Data> keys;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 entryProcessor, java.util.Collection<com.hazelcast.nio.serialization.Data> keys) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(entryProcessor);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data keys_item : keys ) {
            dataSize += ParameterUtil.calculateDataSize(keys_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 entryProcessor, java.util.Collection<com.hazelcast.nio.serialization.Data> keys) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, entryProcessor, keys);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(entryProcessor);
        clientMessage.set(keys.size());
        for (com.hazelcast.nio.serialization.Data keys_item : keys) {
        clientMessage.set(keys_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        com.hazelcast.nio.serialization.Data entryProcessor = null;
        entryProcessor = clientMessage.getData();
            parameters.entryProcessor = entryProcessor;
        java.util.List<com.hazelcast.nio.serialization.Data> keys = null;
            int keys_size = clientMessage.getInt();
            keys = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(keys_size);
            for (int keys_index = 0;keys_index<keys_size;keys_index++) {
                com.hazelcast.nio.serialization.Data keys_item;
        keys_item = clientMessage.getData();
                keys.add(keys_item);
            }
            parameters.keys = keys;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response;

        public static int calculateDataSize(java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item : response ) {
            dataSize += ParameterUtil.calculateDataSize(response_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response.size());
        for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item : response) {
        clientMessage.set(response_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response = null;
            int response_size = clientMessage.getInt();
            response = new java.util.ArrayList<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>>(response_size);
            for (int response_index = 0;response_index<response_size;response_index++) {
                java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item;
        response_item = clientMessage.getMapEntry();
                response.add(response_item);
            }
            parameters.response = response;
        return parameters;
    }

}
