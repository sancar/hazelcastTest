package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class TransactionCreateCodec {

    public static final TransactionMessageType REQUEST_TYPE = TransactionMessageType.TRANSACTION_CREATE;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final TransactionMessageType TYPE = REQUEST_TYPE;
        public long timeout;
        public int durability;
        public int transactionType;
        public long threadId;

        public static int calculateDataSize(long
 timeout, int
 durability, int
 transactionType, long
 threadId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(long
 timeout, int
 durability, int
 transactionType, long
 threadId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(timeout, durability, transactionType, threadId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(timeout);
        clientMessage.set(durability);
        clientMessage.set(transactionType);
        clientMessage.set(threadId);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        long timeout ;
        timeout = clientMessage.getLong();
            parameters.timeout = timeout;
        int durability ;
        durability = clientMessage.getInt();
            parameters.durability = durability;
        int transactionType ;
        transactionType = clientMessage.getInt();
            parameters.transactionType = transactionType;
        long threadId ;
        threadId = clientMessage.getLong();
            parameters.threadId = threadId;
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
