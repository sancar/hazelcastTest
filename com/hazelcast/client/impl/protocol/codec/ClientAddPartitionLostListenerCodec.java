package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientAddPartitionLostListenerCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_ADDPARTITIONLOSTLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ClientMessageType TYPE = REQUEST_TYPE;
        public boolean localOnly;

        public static int calculateDataSize(boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
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

    public static ClientMessage encodePartitionLostEvent(int
 partitionId, int
 lostBackupCount, com.hazelcast.nio.Address
 source){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
                dataSize += Bits.INT_SIZE_IN_BYTES;
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (source != null) {
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(source);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_PARTITIONLOST);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(partitionId);
        clientMessage.set(lostBackupCount);
        boolean source_isNull;
        if (source == null) {
            source_isNull = true;
            clientMessage.set(source_isNull);
        } else {
            source_isNull= false;
            clientMessage.set(source_isNull);
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(source, clientMessage);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_PARTITIONLOST) {
        int partitionId ;
        partitionId = clientMessage.getInt();
        int lostBackupCount ;
        lostBackupCount = clientMessage.getInt();
        com.hazelcast.nio.Address source = null;
        boolean source_isNull = clientMessage.getBoolean();
        if (!source_isNull) {
            source = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
        }
                handle(partitionId, lostBackupCount, source);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(int
 partitionId, int
 lostBackupCount, com.hazelcast.nio.Address
 source);

   }

}
