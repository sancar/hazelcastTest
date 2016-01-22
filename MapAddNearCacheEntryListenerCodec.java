package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapAddNearCacheEntryListenerCodec {

    public static final MapMessageType REQUEST_TYPE = MapMessageType.MAP_ADDNEARCACHEENTRYLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public int listenerFlags;
        public boolean localOnly;

        public static int calculateDataSize(java.lang.String
 name, int
 listenerFlags, boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, int
 listenerFlags, boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, listenerFlags, localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(listenerFlags);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        int listenerFlags ;
        listenerFlags = clientMessage.getInt();
            parameters.listenerFlags = listenerFlags;
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

    public static ClientMessage encodeIMapInvalidationEvent(com.hazelcast.nio.serialization.Data
 key){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (key != null) {
            dataSize += ParameterUtil.calculateDataSize(key);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_IMAPINVALIDATION);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        boolean key_isNull;
        if (key == null) {
            key_isNull = true;
            clientMessage.set(key_isNull);
        } else {
            key_isNull= false;
            clientMessage.set(key_isNull);
        clientMessage.set(key);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };

    public static ClientMessage encodeIMapBatchInvalidationEvent(java.util.Collection<com.hazelcast.nio.serialization.Data> keys){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data keys_item : keys ) {
            dataSize += ParameterUtil.calculateDataSize(keys_item);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_IMAPBATCHINVALIDATION);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(keys.size());
        for (com.hazelcast.nio.serialization.Data keys_item : keys) {
        clientMessage.set(keys_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_IMAPINVALIDATION) {
        com.hazelcast.nio.serialization.Data key = null;
        boolean key_isNull = clientMessage.getBoolean();
        if (!key_isNull) {
        key = clientMessage.getData();
        }
                handle(key);
                return;
            }
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_IMAPBATCHINVALIDATION) {
        java.util.List<com.hazelcast.nio.serialization.Data> keys = null;
            int keys_size = clientMessage.getInt();
            keys = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(keys_size);
            for (int keys_index = 0;keys_index<keys_size;keys_index++) {
                com.hazelcast.nio.serialization.Data keys_item;
        keys_item = clientMessage.getData();
                keys.add(keys_item);
            }
                handle(keys);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(com.hazelcast.nio.serialization.Data
 key);

        public abstract void handle(java.util.Collection<com.hazelcast.nio.serialization.Data> keys);

   }

}
