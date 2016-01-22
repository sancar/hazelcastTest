package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class AtomicLongAddAndGetCodec {

    public static final AtomicLongMessageType REQUEST_TYPE = AtomicLongMessageType.ATOMICLONG_ADDANDGET;
    public static final int RESPONSE_TYPE = 103;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final AtomicLongMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public long delta;

        public static int calculateDataSize(java.lang.String
 name, long
 delta) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, long
 delta) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, delta);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(delta);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        long delta ;
        delta = clientMessage.getLong();
            parameters.delta = delta;
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
