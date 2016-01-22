package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ListAddAllWithIndexCodec {

    public static final ListMessageType REQUEST_TYPE = ListMessageType.LIST_ADDALLWITHINDEX;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ListMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public int index;
        public java.util.List<com.hazelcast.nio.serialization.Data> valueList;

        public static int calculateDataSize(java.lang.String
 name, int
 index, java.util.Collection<com.hazelcast.nio.serialization.Data> valueList) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data valueList_item : valueList ) {
            dataSize += ParameterUtil.calculateDataSize(valueList_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, int
 index, java.util.Collection<com.hazelcast.nio.serialization.Data> valueList) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, index, valueList);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(index);
        clientMessage.set(valueList.size());
        for (com.hazelcast.nio.serialization.Data valueList_item : valueList) {
        clientMessage.set(valueList_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        int index ;
        index = clientMessage.getInt();
            parameters.index = index;
        java.util.List<com.hazelcast.nio.serialization.Data> valueList = null;
            int valueList_size = clientMessage.getInt();
            valueList = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(valueList_size);
            for (int valueList_index = 0;valueList_index<valueList_size;valueList_index++) {
                com.hazelcast.nio.serialization.Data valueList_item;
        valueList_item = clientMessage.getData();
                valueList.add(valueList_item);
            }
            parameters.valueList = valueList;
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
