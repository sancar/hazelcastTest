package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ListCompareAndRetainAllCodec {

    public static final ListMessageType REQUEST_TYPE = ListMessageType.LIST_COMPAREANDRETAINALL;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ListMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.util.List<com.hazelcast.nio.serialization.Data> values;

        public static int calculateDataSize(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> values) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.nio.serialization.Data values_item : values ) {
            dataSize += ParameterUtil.calculateDataSize(values_item);
            }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.util.Collection<com.hazelcast.nio.serialization.Data> values) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, values);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(values.size());
        for (com.hazelcast.nio.serialization.Data values_item : values) {
        clientMessage.set(values_item);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.util.List<com.hazelcast.nio.serialization.Data> values = null;
            int values_size = clientMessage.getInt();
            values = new java.util.ArrayList<com.hazelcast.nio.serialization.Data>(values_size);
            for (int values_index = 0;values_index<values_size;values_index++) {
                com.hazelcast.nio.serialization.Data values_item;
        values_item = clientMessage.getData();
                values.add(values_item);
            }
            parameters.values = values;
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
