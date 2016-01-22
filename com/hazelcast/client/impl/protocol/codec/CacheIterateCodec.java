package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheIterateCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_ITERATE;
    public static final int RESPONSE_TYPE = 116;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public int partitionId;
        public int tableIndex;
        public int batch;

        public static int calculateDataSize(java.lang.String
 name, int
 partitionId, int
 tableIndex, int
 batch) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, int
 partitionId, int
 tableIndex, int
 batch) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, partitionId, tableIndex, batch);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(partitionId);
        clientMessage.set(tableIndex);
        clientMessage.set(batch);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        int partitionId ;
        partitionId = clientMessage.getInt();
            parameters.partitionId = partitionId;
        int tableIndex ;
        tableIndex = clientMessage.getInt();
            parameters.tableIndex = tableIndex;
        int batch ;
        batch = clientMessage.getInt();
            parameters.batch = batch;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public int tableIndex;
        public java.util.List<com.hazelcast.nio.serialization.Data> keys;

        public static int calculateDataSize(int
 tableIndex, java.util.Collection<com.hazelcast.nio.serialization.Data> keys) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data keys_item : keys ) {
            dataSize += ParameterUtil.calculateDataSize(keys_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(int
 tableIndex, java.util.Collection<com.hazelcast.nio.serialization.Data> keys) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(tableIndex, keys);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(tableIndex);
        clientMessage.set(keys.size());
        for (com.hazelcast.nio.serialization.Data keys_item : keys) {
        clientMessage.set(keys_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        int tableIndex ;
        tableIndex = clientMessage.getInt();
            parameters.tableIndex = tableIndex;
        java.util.List<com.hazelcast.nio.serialization.Data> keys = null;
            int keys_size = clientMessage.getInt();
            keys = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(keys_size);
            for (int keys_index = 0;keys_index<keys_size;keys_index++) {
                com.hazelcast.nio.serialization.Data keys_item;
        keys_item = clientMessage.getData();
                keys.add(keys_item);
            }
            parameters.keys = keys;
        return parameters;
    }

}
