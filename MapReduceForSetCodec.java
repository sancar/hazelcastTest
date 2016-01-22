package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapReduceForSetCodec {

    public static final MapReduceMessageType REQUEST_TYPE = MapReduceMessageType.MAPREDUCE_FORSET;
    public static final int RESPONSE_TYPE = 117;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapReduceMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.lang.String jobId;
        public com.hazelcast.nio.serialization.Data predicate;
        public com.hazelcast.nio.serialization.Data mapper;
        public com.hazelcast.nio.serialization.Data combinerFactory;
        public com.hazelcast.nio.serialization.Data reducerFactory;
        public java.lang.String setName;
        public int chunkSize;
        public java.util.List<com.hazelcast.nio.serialization.Data> keys;
        public java.lang.String topologyChangedStrategy;

        public static int calculateDataSize(java.lang.String
 name, java.lang.String
 jobId, com.hazelcast.nio.serialization.Data
 predicate, com.hazelcast.nio.serialization.Data
 mapper, com.hazelcast.nio.serialization.Data
 combinerFactory, com.hazelcast.nio.serialization.Data
 reducerFactory, java.lang.String
 setName, int
 chunkSize, java.util.Collection<com.hazelcast.nio.serialization.Data> keys, java.lang.String
 topologyChangedStrategy) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(jobId);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (predicate != null) {
            dataSize += ParameterUtil.calculateDataSize(predicate);
            }
            dataSize += ParameterUtil.calculateDataSize(mapper);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (combinerFactory != null) {
            dataSize += ParameterUtil.calculateDataSize(combinerFactory);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (reducerFactory != null) {
            dataSize += ParameterUtil.calculateDataSize(reducerFactory);
            }
            dataSize += ParameterUtil.calculateDataSize(setName);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (keys != null) {
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data keys_item : keys ) {
            dataSize += ParameterUtil.calculateDataSize(keys_item);
            }
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (topologyChangedStrategy != null) {
            dataSize += ParameterUtil.calculateDataSize(topologyChangedStrategy);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.lang.String
 jobId, com.hazelcast.nio.serialization.Data
 predicate, com.hazelcast.nio.serialization.Data
 mapper, com.hazelcast.nio.serialization.Data
 combinerFactory, com.hazelcast.nio.serialization.Data
 reducerFactory, java.lang.String
 setName, int
 chunkSize, java.util.Collection<com.hazelcast.nio.serialization.Data> keys, java.lang.String
 topologyChangedStrategy) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, jobId, predicate, mapper, combinerFactory, reducerFactory, setName, chunkSize, keys, topologyChangedStrategy);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(jobId);
        boolean predicate_isNull;
        if (predicate == null) {
            predicate_isNull = true;
            clientMessage.set(predicate_isNull);
        } else {
            predicate_isNull= false;
            clientMessage.set(predicate_isNull);
        clientMessage.set(predicate);
        }
        clientMessage.set(mapper);
        boolean combinerFactory_isNull;
        if (combinerFactory == null) {
            combinerFactory_isNull = true;
            clientMessage.set(combinerFactory_isNull);
        } else {
            combinerFactory_isNull= false;
            clientMessage.set(combinerFactory_isNull);
        clientMessage.set(combinerFactory);
        }
        boolean reducerFactory_isNull;
        if (reducerFactory == null) {
            reducerFactory_isNull = true;
            clientMessage.set(reducerFactory_isNull);
        } else {
            reducerFactory_isNull= false;
            clientMessage.set(reducerFactory_isNull);
        clientMessage.set(reducerFactory);
        }
        clientMessage.set(setName);
        clientMessage.set(chunkSize);
        boolean keys_isNull;
        if (keys == null) {
            keys_isNull = true;
            clientMessage.set(keys_isNull);
        } else {
            keys_isNull= false;
            clientMessage.set(keys_isNull);
        clientMessage.set(keys.size());
        for (com.hazelcast.nio.serialization.Data keys_item : keys) {
        clientMessage.set(keys_item);
        }
        }
        boolean topologyChangedStrategy_isNull;
        if (topologyChangedStrategy == null) {
            topologyChangedStrategy_isNull = true;
            clientMessage.set(topologyChangedStrategy_isNull);
        } else {
            topologyChangedStrategy_isNull= false;
            clientMessage.set(topologyChangedStrategy_isNull);
        clientMessage.set(topologyChangedStrategy);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.lang.String jobId = null;
        jobId = clientMessage.getStringUtf8();
            parameters.jobId = jobId;
        com.hazelcast.nio.serialization.Data predicate = null;
        boolean predicate_isNull = clientMessage.getBoolean();
        if (!predicate_isNull) {
        predicate = clientMessage.getData();
            parameters.predicate = predicate;
        }
        com.hazelcast.nio.serialization.Data mapper = null;
        mapper = clientMessage.getData();
            parameters.mapper = mapper;
        com.hazelcast.nio.serialization.Data combinerFactory = null;
        boolean combinerFactory_isNull = clientMessage.getBoolean();
        if (!combinerFactory_isNull) {
        combinerFactory = clientMessage.getData();
            parameters.combinerFactory = combinerFactory;
        }
        com.hazelcast.nio.serialization.Data reducerFactory = null;
        boolean reducerFactory_isNull = clientMessage.getBoolean();
        if (!reducerFactory_isNull) {
        reducerFactory = clientMessage.getData();
            parameters.reducerFactory = reducerFactory;
        }
        java.lang.String setName = null;
        setName = clientMessage.getStringUtf8();
            parameters.setName = setName;
        int chunkSize ;
        chunkSize = clientMessage.getInt();
            parameters.chunkSize = chunkSize;
        java.util.List<com.hazelcast.nio.serialization.Data> keys = null;
        boolean keys_isNull = clientMessage.getBoolean();
        if (!keys_isNull) {
            int keys_size = clientMessage.getInt();
            keys = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(keys_size);
            for (int keys_index = 0;keys_index<keys_size;keys_index++) {
                com.hazelcast.nio.serialization.Data keys_item;
        keys_item = clientMessage.getData();
                keys.add(keys_item);
            }
            parameters.keys = keys;
        }
        java.lang.String topologyChangedStrategy = null;
        boolean topologyChangedStrategy_isNull = clientMessage.getBoolean();
        if (!topologyChangedStrategy_isNull) {
        topologyChangedStrategy = clientMessage.getStringUtf8();
            parameters.topologyChangedStrategy = topologyChangedStrategy;
        }
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
