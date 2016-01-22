package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class XATransactionCreateCodec {

    public static final XATransactionMessageType REQUEST_TYPE = XATransactionMessageType.XATRANSACTION_CREATE;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final XATransactionMessageType TYPE = REQUEST_TYPE;
        public javax.transaction.xa.Xid xid;
        public long timeout;

        public static int calculateDataSize(javax.transaction.xa.Xid
 xid, long
 timeout) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += com.hazelcast.client.impl.protocol.codec.XIDCodec.calculateDataSize(xid);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(javax.transaction.xa.Xid
 xid, long
 timeout) {
        final int requiredDataSize = RequestParameters.calculateDataSize(xid, timeout);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        com.hazelcast.client.impl.protocol.codec.XIDCodec.encode(xid, clientMessage);
        clientMessage.set(timeout);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        javax.transaction.xa.Xid xid = null;
            xid = com.hazelcast.client.impl.protocol.codec.XIDCodec.decode(clientMessage);
            parameters.xid = xid;
        long timeout ;
        timeout = clientMessage.getLong();
            parameters.timeout = timeout;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.lang.String response;

        public static int calculateDataSize(java.lang.String
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(response);
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.lang.String
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
        java.lang.String response = null;
        response = clientMessage.getStringUtf8();
            parameters.response = response;
        return parameters;
    }

}
