package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class TransactionalMapReplaceCodec {

    public static final TransactionalMapMessageType REQUEST_TYPE = TransactionalMapMessageType.TRANSACTIONALMAP_REPLACE;
    public static final int RESPONSE_TYPE = 105;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final TransactionalMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.lang.String txnId;
        public long threadId;
        public com.hazelcast.nio.serialization.Data key;
        public com.hazelcast.nio.serialization.Data value;

        public static int calculateDataSize(java.lang.String
 name, java.lang.String
 txnId, long
 threadId, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 value) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(txnId);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += ParameterUtil.calculateDataSize(value);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.lang.String
 txnId, long
 threadId, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 value) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, txnId, threadId, key, value);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(txnId);
        clientMessage.set(threadId);
        clientMessage.set(key);
        clientMessage.set(value);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.lang.String txnId = null;
        txnId = clientMessage.getStringUtf8();
            parameters.txnId = txnId;
        long threadId ;
        threadId = clientMessage.getLong();
            parameters.threadId = threadId;
        com.hazelcast.nio.serialization.Data key = null;
        key = clientMessage.getData();
            parameters.key = key;
        com.hazelcast.nio.serialization.Data value = null;
        value = clientMessage.getData();
            parameters.value = value;
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
