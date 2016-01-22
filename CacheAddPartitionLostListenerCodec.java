package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheAddPartitionLostListenerCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_ADDPARTITIONLOSTLISTENER;
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

    public static ClientMessage encodeCachePartitionLostEvent(int
 partitionId, java.lang.String
 uuid){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
                dataSize += ParameterUtil.calculateDataSize(uuid);
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEPARTITIONLOST);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(partitionId);
        clientMessage.set(uuid);
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_CACHEPARTITIONLOST) {
        int partitionId ;
        partitionId = clientMessage.getInt();
        java.lang.String uuid = null;
        uuid = clientMessage.getStringUtf8();
                handle(partitionId, uuid);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(int
 partitionId, java.lang.String
 uuid);

   }

}
