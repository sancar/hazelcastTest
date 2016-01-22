package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class EnterpriseMapAddListenerCodec {

    public static final EnterpriseMapMessageType REQUEST_TYPE = EnterpriseMapMessageType.ENTERPRISEMAP_ADDLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final EnterpriseMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String listenerName;
        public boolean localOnly;

        public static int calculateDataSize(java.lang.String
 listenerName, boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(listenerName);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 listenerName, boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(listenerName, localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(listenerName);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String listenerName = null;
        listenerName = clientMessage.getStringUtf8();
            parameters.listenerName = listenerName;
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

    public static ClientMessage encodeQueryCacheSingleEvent(com.hazelcast.map.impl.querycache.event.QueryCacheEventData
 data){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.calculateDataSize(data);
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_QUERYCACHESINGLE);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.encode(data, clientMessage);
        clientMessage.updateFrameLength();
        return clientMessage;
    };

    public static ClientMessage encodeQueryCacheBatchEvent(java.util.Collection<com.hazelcast.map.impl.querycache.event.QueryCacheEventData> events, java.lang.String
 source, int
 partitionId){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.map.impl.querycache.event.QueryCacheEventData events_item : events ) {
            dataSize += com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.calculateDataSize(events_item);
            }
                dataSize += ParameterUtil.calculateDataSize(source);
                dataSize += Bits.INT_SIZE_IN_BYTES;
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_QUERYCACHEBATCH);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(events.size());
        for (com.hazelcast.map.impl.querycache.event.QueryCacheEventData events_item : events) {
        com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.encode(events_item, clientMessage);
        }
        clientMessage.set(source);
        clientMessage.set(partitionId);
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_QUERYCACHESINGLE) {
        com.hazelcast.map.impl.querycache.event.QueryCacheEventData data = null;
            data = com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.decode(clientMessage);
                handle(data);
                return;
            }
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_QUERYCACHEBATCH) {
        java.util.List<com.hazelcast.map.impl.querycache.event.QueryCacheEventData> events = null;
            int events_size = clientMessage.getInt();
            events = new java.util.ArrayList<com.hazelcast.map.impl.querycache.event.QueryCacheEventData>(events_size);
            for (int events_index = 0;events_index<events_size;events_index++) {
                com.hazelcast.map.impl.querycache.event.QueryCacheEventData events_item;
            events_item = com.hazelcast.client.impl.protocol.codec.QueryCacheEventDataCodec.decode(clientMessage);
                events.add(events_item);
            }
        java.lang.String source = null;
        source = clientMessage.getStringUtf8();
        int partitionId ;
        partitionId = clientMessage.getInt();
                handle(events, source, partitionId);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(com.hazelcast.map.impl.querycache.event.QueryCacheEventData
 data);

        public abstract void handle(java.util.Collection<com.hazelcast.map.impl.querycache.event.QueryCacheEventData> events, java.lang.String
 source, int
 partitionId);

   }

}
