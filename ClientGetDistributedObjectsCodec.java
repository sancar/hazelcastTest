package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientGetDistributedObjectsCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_GETDISTRIBUTEDOBJECTS;
    public static final int RESPONSE_TYPE = 110;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ClientMessageType TYPE = REQUEST_TYPE;

        public static int calculateDataSize() {
            int dataSize = ClientMessage.HEADER_SIZE;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest() {
        final int requiredDataSize = RequestParameters.calculateDataSize();
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<com.hazelcast.client.impl.client.DistributedObjectInfo> response;

        public static int calculateDataSize(java.util.Collection<com.hazelcast.client.impl.client.DistributedObjectInfo> response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.client.impl.client.DistributedObjectInfo response_item : response ) {
            dataSize += com.hazelcast.client.impl.protocol.codec.DistributedObjectInfoCodec.calculateDataSize(response_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<com.hazelcast.client.impl.client.DistributedObjectInfo> response) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(response);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(response.size());
        for (com.hazelcast.client.impl.client.DistributedObjectInfo response_item : response) {
        com.hazelcast.client.impl.protocol.codec.DistributedObjectInfoCodec.encode(response_item, clientMessage);
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<com.hazelcast.client.impl.client.DistributedObjectInfo> response = null;
            int response_size = clientMessage.getInt();
            response = new java.util.ArrayList<com.hazelcast.client.impl.client.DistributedObjectInfo>(response_size);
            for (int response_index = 0;response_index<response_size;response_index++) {
                com.hazelcast.client.impl.client.DistributedObjectInfo response_item;
            response_item = com.hazelcast.client.impl.protocol.codec.DistributedObjectInfoCodec.decode(clientMessage);
                response.add(response_item);
            }
            parameters.response = response;
        return parameters;
    }

}
