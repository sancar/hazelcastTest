package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CacheManagementConfigCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_MANAGEMENTCONFIG;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public boolean isStat;
        public boolean enabled;
        public com.hazelcast.nio.Address address;

        public static int calculateDataSize(java.lang.String
 name, boolean
 isStat, boolean
 enabled, com.hazelcast.nio.Address
 address) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(address);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, boolean
 isStat, boolean
 enabled, com.hazelcast.nio.Address
 address) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, isStat, enabled, address);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(isStat);
        clientMessage.set(enabled);
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(address, clientMessage);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        boolean isStat ;
        isStat = clientMessage.getBoolean();
            parameters.isStat = isStat;
        boolean enabled ;
        enabled = clientMessage.getBoolean();
            parameters.enabled = enabled;
        com.hazelcast.nio.Address address = null;
            address = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
            parameters.address = address;
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
