package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class AtomicReferenceContainsCodec {

    public static final AtomicReferenceMessageType REQUEST_TYPE = AtomicReferenceMessageType.ATOMICREFERENCE_CONTAINS;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final AtomicReferenceMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data expected;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 expected) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (expected != null) {
            dataSize += ParameterUtil.calculateDataSize(expected);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 expected) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, expected);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        boolean expected_isNull;
        if (expected == null) {
            expected_isNull = true;
            clientMessage.set(expected_isNull);
        } else {
            expected_isNull= false;
            clientMessage.set(expected_isNull);
        clientMessage.set(expected);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        com.hazelcast.nio.serialization.Data expected = null;
        boolean expected_isNull = clientMessage.getBoolean();
        if (!expected_isNull) {
        expected = clientMessage.getData();
            parameters.expected = expected;
        }
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
