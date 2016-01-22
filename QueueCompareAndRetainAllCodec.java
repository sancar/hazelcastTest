package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class QueueCompareAndRetainAllCodec {

    public static final QueueMessageType REQUEST_TYPE = QueueMessageType.QUEUE_COMPAREANDRETAINALL;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final QueueMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.util.List<com.hazelcast.nio.serialization.Data> dataList;

        public static int calculateDataSize(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> dataList) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data dataList_item : dataList ) {
            dataSize += ParameterUtil.calculateDataSize(dataList_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> dataList) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, dataList);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(dataList.size());
        for (com.hazelcast.nio.serialization.Data dataList_item : dataList) {
        clientMessage.set(dataList_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.util.List<com.hazelcast.nio.serialization.Data> dataList = null;
            int dataList_size = clientMessage.getInt();
            dataList = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(dataList_size);
            for (int dataList_index = 0;dataList_index<dataList_size;dataList_index++) {
                com.hazelcast.nio.serialization.Data dataList_item;
        dataList_item = clientMessage.getData();
                dataList.add(dataList_item);
            }
            parameters.dataList = dataList;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public boolean response;

        public static int calculateDataSize(boolean
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(boolean
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
        boolean response ;
        response = clientMessage.getBoolean();
            parameters.response = response;
        return parameters;
    }

}
