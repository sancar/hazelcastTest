package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class TransactionalMapKeySetWithPredicateCodec {

    public static final TransactionalMapMessageType REQUEST_TYPE = TransactionalMapMessageType.TRANSACTIONALMAP_KEYSETWITHPREDICATE;
    public static final int RESPONSE_TYPE = 106;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final TransactionalMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.lang.String txnId;
        public long threadId;
        public com.hazelcast.nio.serialization.Data predicate;

        public static int calculateDataSize(java.lang.String
 name, java.lang.String
 txnId, long
 threadId, com.hazelcast.nio.serialization.Data
 predicate) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(txnId);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += ParameterUtil.calculateDataSize(predicate);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.lang.String
 txnId, long
 threadId, com.hazelcast.nio.serialization.Data
 predicate) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, txnId, threadId, predicate);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(txnId);
        clientMessage.set(threadId);
        clientMessage.set(predicate);
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
        com.hazelcast.nio.serialization.Data predicate = null;
        predicate = clientMessage.getData();
            parameters.predicate = predicate;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<com.hazelcast.nio.serialization.Data> response;

        public static int calculateDataSize(java.util.Collection<com.hazelcast.nio.serialization.Data> response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data response_item : response ) {
            dataSize += ParameterUtil.calculateDataSize(response_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<com.hazelcast.nio.serialization.Data> response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response.size());
        for (com.hazelcast.nio.serialization.Data response_item : response) {
        clientMessage.set(response_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<com.hazelcast.nio.serialization.Data> response = null;
            int response_size = clientMessage.getInt();
            response = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(response_size);
            for (int response_index = 0;response_index<response_size;response_index++) {
                com.hazelcast.nio.serialization.Data response_item;
        response_item = clientMessage.getData();
                response.add(response_item);
            }
            parameters.response = response;
        return parameters;
    }

}
