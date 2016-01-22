package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class SetAddListenerCodec {

    public static final SetMessageType REQUEST_TYPE = SetMessageType.SET_ADDLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final SetMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public boolean includeValue;
        public boolean localOnly;

        public static int calculateDataSize(java.lang.String
 name, boolean
 includeValue, boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, boolean
 includeValue, boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, includeValue, localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(includeValue);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        boolean includeValue ;
        includeValue = clientMessage.getBoolean();
            parameters.includeValue = includeValue;
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

    public static ClientMessage encodeItemEvent(com.hazelcast.nio.serialization.Data
 item, java.lang.String
 uuid, int
 eventType){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (item != null) {
            dataSize += ParameterUtil.calculateDataSize(item);
            }
                dataSize += ParameterUtil.calculateDataSize(uuid);
                dataSize += Bits.INT_SIZE_IN_BYTES;
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_ITEM);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        boolean item_isNull;
        if (item == null) {
            item_isNull = true;
            clientMessage.set(item_isNull);
        } else {
            item_isNull= false;
            clientMessage.set(item_isNull);
        clientMessage.set(item);
        }
        clientMessage.set(uuid);
        clientMessage.set(eventType);
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_ITEM) {
        com.hazelcast.nio.serialization.Data item = null;
        boolean item_isNull = clientMessage.getBoolean();
        if (!item_isNull) {
        item = clientMessage.getData();
        }
        java.lang.String uuid = null;
        uuid = clientMessage.getStringUtf8();
        int eventType ;
        eventType = clientMessage.getInt();
                handle(item, uuid, eventType);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(com.hazelcast.nio.serialization.Data
 item, java.lang.String
 uuid, int
 eventType);

   }

}
