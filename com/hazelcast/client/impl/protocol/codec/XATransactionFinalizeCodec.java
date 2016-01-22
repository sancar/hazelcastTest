package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class XATransactionFinalizeCodec {

    public static final XATransactionMessageType REQUEST_TYPE = XATransactionMessageType.XATRANSACTION_FINALIZE;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final XATransactionMessageType TYPE = REQUEST_TYPE;
        public javax.transaction.xa.Xid xid;
        public boolean isCommit;

        public static int calculateDataSize(javax.transaction.xa.Xid
 xid, boolean
 isCommit) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += com.hazelcast.client.impl.protocol.codec.XIDCodec.calculateDataSize(xid);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(javax.transaction.xa.Xid
 xid, boolean
 isCommit) {
        final int requiredDataSize = RequestParameters.calculateDataSize(xid, isCommit);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        com.hazelcast.client.impl.protocol.codec.XIDCodec.encode(xid, clientMessage);
        clientMessage.set(isCommit);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        javax.transaction.xa.Xid xid = null;
            xid = com.hazelcast.client.impl.protocol.codec.XIDCodec.decode(clientMessage);
            parameters.xid = xid;
        boolean isCommit ;
        isCommit = clientMessage.getBoolean();
            parameters.isCommit = isCommit;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {

        public static int calculateDataSize() {
            int dataSize = ClientMessage.HEADER_SIZE;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse() {
        final int requiredDataSize = ResponseParameters.calculateDataSize();
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        return parameters;
    }

}
