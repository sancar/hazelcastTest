package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class EnterpriseMapPublisherCreateWithValueCodec {

    public static final EnterpriseMapMessageType REQUEST_TYPE = EnterpriseMapMessageType.ENTERPRISEMAP_PUBLISHERCREATEWITHVALUE;
    public static final int RESPONSE_TYPE = 117;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final EnterpriseMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String mapName;
        public java.lang.String cacheName;
        public com.hazelcast.nio.serialization.Data predicate;
        public int batchSize;
        public int bufferSize;
        public long delaySeconds;
        public boolean populate;
        public boolean coalesce;

        public static int calculateDataSize(java.lang.String
 mapName, java.lang.String
 cacheName, com.hazelcast.nio.serialization.Data
 predicate, int
 batchSize, int
 bufferSize, long
 delaySeconds, boolean
 populate, boolean
 coalesce) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(mapName);
            dataSize += ParameterUtil.calculateDataSize(cacheName);
            dataSize += ParameterUtil.calculateDataSize(predicate);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 mapName, java.lang.String
 cacheName, com.hazelcast.nio.serialization.Data
 predicate, int
 batchSize, int
 bufferSize, long
 delaySeconds, boolean
 populate, boolean
 coalesce) {
        final int requiredDataSize = RequestParameters.calculateDataSize(mapName, cacheName, predicate, batchSize, bufferSize, delaySeconds, populate, coalesce);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(mapName);
        clientMessage.set(cacheName);
        clientMessage.set(predicate);
        clientMessage.set(batchSize);
        clientMessage.set(bufferSize);
        clientMessage.set(delaySeconds);
        clientMessage.set(populate);
        clientMessage.set(coalesce);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String mapName = null;
        mapName = clientMessage.getStringUtf8();
            parameters.mapName = mapName;
        java.lang.String cacheName = null;
        cacheName = clientMessage.getStringUtf8();
            parameters.cacheName = cacheName;
        com.hazelcast.nio.serialization.Data predicate = null;
        predicate = clientMessage.getData();
            parameters.predicate = predicate;
        int batchSize ;
        batchSize = clientMessage.getInt();
            parameters.batchSize = batchSize;
        int bufferSize ;
        bufferSize = clientMessage.getInt();
            parameters.bufferSize = bufferSize;
        long delaySeconds ;
        delaySeconds = clientMessage.getLong();
            parameters.delaySeconds = delaySeconds;
        boolean populate ;
        populate = clientMessage.getBoolean();
            parameters.populate = populate;
        boolean coalesce ;
        coalesce = clientMessage.getBoolean();
            parameters.coalesce = coalesce;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response;

        public static int calculateDataSize(java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item : response ) {
            dataSize += ParameterUtil.calculateDataSize(response_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response.size());
        for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item : response) {
        clientMessage.set(response_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> response = null;
            int response_size = clientMessage.getInt();
            response = new java.util.ArrayList<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>>(response_size);
            for (int response_index = 0;response_index<response_size;response_index++) {
                java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> response_item;
        response_item = clientMessage.getMapEntry();
                response.add(response_item);
            }
            parameters.response = response;
        return parameters;
    }

}