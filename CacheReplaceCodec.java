package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheReplaceCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_REPLACE;
    public static final int RESPONSE_TYPE = 105;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data key;
        public com.hazelcast.nio.serialization.Data oldValue;
        public com.hazelcast.nio.serialization.Data newValue;
        public com.hazelcast.nio.serialization.Data expiryPolicy;
        public int completionId;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 oldValue, com.hazelcast.nio.serialization.Data
 newValue, com.hazelcast.nio.serialization.Data
 expiryPolicy, int
 completionId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (oldValue != null) {
            dataSize += ParameterUtil.calculateDataSize(oldValue);
            }
            dataSize += ParameterUtil.calculateDataSize(newValue);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (expiryPolicy != null) {
            dataSize += ParameterUtil.calculateDataSize(expiryPolicy);
            }
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 oldValue, com.hazelcast.nio.serialization.Data
 newValue, com.hazelcast.nio.serialization.Data
 expiryPolicy, int
 completionId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, key, oldValue, newValue, expiryPolicy, completionId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(key);
        boolean oldValue_isNull;
        if (oldValue == null) {
            oldValue_isNull = true;
            clientMessage.set(oldValue_isNull);
        } else {
            oldValue_isNull= false;
            clientMessage.set(oldValue_isNull);
        clientMessage.set(oldValue);
        }
        clientMessage.set(newValue);
        boolean expiryPolicy_isNull;
        if (expiryPolicy == null) {
            expiryPolicy_isNull = true;
            clientMessage.set(expiryPolicy_isNull);
        } else {
            expiryPolicy_isNull= false;
            clientMessage.set(expiryPolicy_isNull);
        clientMessage.set(expiryPolicy);
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
        com.hazelcast.nio.serialization.Data oldValue = null;
        boolean oldValue_isNull = clientMessage.getBoolean();
        if (!oldValue_isNull) {
        oldValue = clientMessage.getData();
            parameters.oldValue = oldValue;
        }
        com.hazelcast.nio.serialization.Data newValue = null;
        newValue = clientMessage.getData();
            parameters.newValue = newValue;
        com.hazelcast.nio.serialization.Data expiryPolicy = null;
        boolean expiryPolicy_isNull = clientMessage.getBoolean();
        if (!expiryPolicy_isNull) {
        expiryPolicy = clientMessage.getData();
            parameters.expiryPolicy = expiryPolicy;
        }
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
