package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapReplaceIfSameCodec {

    public static final MapMessageType REQUEST_TYPE = MapMessageType.MAP_REPLACEIFSAME;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data key;
        public com.hazelcast.nio.serialization.Data testValue;
        public com.hazelcast.nio.serialization.Data value;
        public long threadId;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 testValue, com.hazelcast.nio.serialization.Data
 value, long
 threadId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += ParameterUtil.calculateDataSize(testValue);
            dataSize += ParameterUtil.calculateDataSize(value);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 testValue, com.hazelcast.nio.serialization.Data
 value, long
 threadId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, key, testValue, value, threadId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(key);
        clientMessage.set(testValue);
        clientMessage.set(value);
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
        com.hazelcast.nio.serialization.Data testValue = null;
        testValue = clientMessage.getData();
            parameters.testValue = testValue;
        com.hazelcast.nio.serialization.Data value = null;
        value = clientMessage.getData();
            parameters.value = value;
        long threadId ;
        threadId = clientMessage.getLong();
            parameters.threadId = threadId;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public boolean response;

        public static int calculateDataSize(boolean
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(boolean
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
        boolean response ;
        response = clientMessage.getBoolean();
            parameters.response = response;
        return parameters;
    }

}
