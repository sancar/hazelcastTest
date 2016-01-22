package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ExecutorServiceCancelOnAddressCodec {

    public static final ExecutorServiceMessageType REQUEST_TYPE = ExecutorServiceMessageType.EXECUTORSERVICE_CANCELONADDRESS;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ExecutorServiceMessageType TYPE = REQUEST_TYPE;
        public java.lang.String uuid;
        public com.hazelcast.nio.Address address;
        public boolean interrupt;

        public static int calculateDataSize(java.lang.String
 uuid, com.hazelcast.nio.Address
 address, boolean
 interrupt) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(uuid);
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(address);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 uuid, com.hazelcast.nio.Address
 address, boolean
 interrupt) {
        final int requiredDataSize = RequestParameters.calculateDataSize(uuid, address, interrupt);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(uuid);
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(address, clientMessage);
        clientMessage.set(interrupt);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String uuid = null;
        uuid = clientMessage.getStringUtf8();
            parameters.uuid = uuid;
        com.hazelcast.nio.Address address = null;
            address = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
            parameters.address = address;
        boolean interrupt ;
        interrupt = clientMessage.getBoolean();
            parameters.interrupt = interrupt;
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