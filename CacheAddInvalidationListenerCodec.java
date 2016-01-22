package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheAddInvalidationListenerCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_ADDINVALIDATIONLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public boolean localOnly;

        public static int calculateDataSize(java.lang.String
 name, boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        boolean localOnly ;
        localOnly = clientMessage.getBoolean();
            parameters.localOnly = localOnly;
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


    //************************ EVENTS *************************//

    public static ClientMessage encodeCacheInvalidationEvent(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, java.lang.String
 sourceUuid){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (key != null) {
            dataSize += ParameterUtil.calculateDataSize(key);
            }
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (sourceUuid != null) {
            dataSize += ParameterUtil.calculateDataSize(sourceUuid);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEINVALIDATION);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(name);
        boolean key_isNull;
        if (key == null) {
            key_isNull = true;
            clientMessage.set(key_isNull);
        } else {
            key_isNull= false;
            clientMessage.set(key_isNull);
        clientMessage.set(key);
        }
        boolean sourceUuid_isNull;
        if (sourceUuid == null) {
            sourceUuid_isNull = true;
            clientMessage.set(sourceUuid_isNull);
        } else {
            sourceUuid_isNull= false;
            clientMessage.set(sourceUuid_isNull);
        clientMessage.set(sourceUuid);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };

    public static ClientMessage encodeCacheBatchInvalidationEvent(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> keys, java.util.Collection<java.lang.String> sourceUuids){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
                dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data keys_item : keys ) {
            dataSize += ParameterUtil.calculateDataSize(keys_item);
            }
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (sourceUuids != null) {
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (java.lang.String sourceUuids_item : sourceUuids ) {
            dataSize += ParameterUtil.calculateDataSize(sourceUuids_item);
            }
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEBATCHINVALIDATION);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(name);
        clientMessage.set(keys.size());
        for (com.hazelcast.nio.serialization.Data keys_item : keys) {
        clientMessage.set(keys_item);
        }
        boolean sourceUuids_isNull;
        if (sourceUuids == null) {
            sourceUuids_isNull = true;
            clientMessage.set(sourceUuids_isNull);
        } else {
            sourceUuids_isNull= false;
            clientMessage.set(sourceUuids_isNull);
        clientMessage.set(sourceUuids.size());
        for (java.lang.String sourceUuids_item : sourceUuids) {
        clientMessage.set(sourceUuids_item);
        }
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEINVALIDATION) {
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
        com.hazelcast.nio.serialization.Data key = null;
        boolean key_isNull = clientMessage.getBoolean();
        if (!key_isNull) {
        key = clientMessage.getData();
        }
        java.lang.String sourceUuid = null;
        boolean sourceUuid_isNull = clientMessage.getBoolean();
        if (!sourceUuid_isNull) {
        sourceUuid = clientMessage.getStringUtf8();
        }
                handle(name, key, sourceUuid);
                return;
            }
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEBATCHINVALIDATION) {
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
        java.util.List<com.hazelcast.nio.serialization.Data> keys = null;
            int keys_size = clientMessage.getInt();
            keys = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(keys_size);
            for (int keys_index = 0;keys_index<keys_size;keys_index++) {
                com.hazelcast.nio.serialization.Data keys_item;
        keys_item = clientMessage.getData();
                keys.add(keys_item);
            }
        java.util.List<java.lang.String> sourceUuids = null;
        boolean sourceUuids_isNull = clientMessage.getBoolean();
        if (!sourceUuids_isNull) {
            int sourceUuids_size = clientMessage.getInt();
            sourceUuids = new java.util.ArrayList<java.lang.String>(sourceUuids_size);
            for (int sourceUuids_index = 0;sourceUuids_index<sourceUuids_size;sourceUuids_index++) {
                java.lang.String sourceUuids_item;
        sourceUuids_item = clientMessage.getStringUtf8();
                sourceUuids.add(sourceUuids_item);
            }
        }
                handle(name, keys, sourceUuids);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, java.lang.String
 sourceUuid);

        public abstract void handle(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> keys, java.util.Collection<java.lang.String> sourceUuids);

   }

}
