package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ListSizeCodec {

    public static final ListMessageType REQUEST_TYPE = ListMessageType.LIST_SIZE;
    public static final int RESPONSE_TYPE = 102;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ListMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;

        public static int calculateDataSize(java.lang.String
 name) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public int response;

        public static int calculateDataSize(int
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(int
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
        int response ;
        response = clientMessage.getInt();
            parameters.response = response;
        return parameters;
    }

}
