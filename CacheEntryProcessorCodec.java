package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheEntryProcessorCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_ENTRYPROCESSOR;
    public static final int RESPONSE_TYPE = 105;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data key;
        public com.hazelcast.nio.serialization.Data entryProcessor;
        public java.util.List<com.hazelcast.nio.serialization.Data> arguments;
        public int completionId;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 entryProcessor, java.util.Collection<com.hazelcast.nio.serialization.Data> arguments, int
 completionId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += ParameterUtil.calculateDataSize(entryProcessor);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data arguments_item : arguments ) {
            dataSize += ParameterUtil.calculateDataSize(arguments_item);
            }
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 entryProcessor, java.util.Collection<com.hazelcast.nio.serialization.Data> arguments, int
 completionId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, key, entryProcessor, arguments, completionId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(key);
        clientMessage.set(entryProcessor);
        clientMessage.set(arguments.size());
        for (com.hazelcast.nio.serialization.Data arguments_item : arguments) {
        clientMessage.set(arguments_item);
        }
        clientMessage.set(completionId);
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
        com.hazelcast.nio.serialization.Data entryProcessor = null;
        entryProcessor = clientMessage.getData();
            parameters.entryProcessor = entryProcessor;
        java.util.List<com.hazelcast.nio.serialization.Data> arguments = null;
            int arguments_size = clientMessage.getInt();
            arguments = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(arguments_size);
            for (int arguments_index = 0;arguments_index<arguments_size;arguments_index++) {
                com.hazelcast.nio.serialization.Data arguments_item;
        arguments_item = clientMessage.getData();
                arguments.add(arguments_item);
            }
            parameters.arguments = arguments;
        int completionId ;
        completionId = clientMessage.getInt();
            parameters.completionId = completionId;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public com.hazelcast.nio.serialization.Data response;

        public static int calculateDataSize(com.hazelcast.nio.serialization.Data
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (response != null) {
            dataSize += ParameterUtil.calculateDataSize(response);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(com.hazelcast.nio.serialization.Data
 response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        boolean response_isNull;
        if (response == null) {
            response_isNull = true;
            clientMessage.set(response_isNull);
        } else {
            response_isNull= false;
            clientMessage.set(response_isNull);
        clientMessage.set(response);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        com.hazelcast.nio.serialization.Data response = null;
        boolean response_isNull = clientMessage.getBoolean();
        if (!response_isNull) {
        response = clientMessage.getData();
            parameters.response = response;
        }
        return parameters;
    }

}
