package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientCreateProxyCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_CREATEPROXY;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ClientMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.lang.String serviceName;
        public com.hazelcast.nio.Address target;

        public static int calculateDataSize(java.lang.String
 name, java.lang.String
 serviceName, com.hazelcast.nio.Address
 target) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(serviceName);
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(target);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.lang.String
 serviceName, com.hazelcast.nio.Address
 target) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, serviceName, target);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(serviceName);
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(target, clientMessage);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.lang.String serviceName = null;
        serviceName = clientMessage.getStringUtf8();
            parameters.serviceName = serviceName;
        com.hazelcast.nio.Address target = null;
            target = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
            parameters.target = target;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {

        public static int calculateDataSize() {
            int dataSize = ClientMessage.HEADER_SIZE;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse() {
        final int requiredDataSize = ResponseParameters.calculateDataSize();
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        return parameters;
    }

}