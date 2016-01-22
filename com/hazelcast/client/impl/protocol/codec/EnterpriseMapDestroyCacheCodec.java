package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class EnterpriseMapDestroyCacheCodec {

    public static final EnterpriseMapMessageType REQUEST_TYPE = EnterpriseMapMessageType.ENTERPRISEMAP_DESTROYCACHE;
    public static final int RESPONSE_TYPE = 101;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final EnterpriseMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String mapName;
        public java.lang.String cacheName;

        public static int calculateDataSize(java.lang.String
 mapName, java.lang.String
 cacheName) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(mapName);
            dataSize += ParameterUtil.calculateDataSize(cacheName);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 mapName, java.lang.String
 cacheName) {
        final int requiredDataSize = RequestParameters.calculateDataSize(mapName, cacheName);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(mapName);
        clientMessage.set(cacheName);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String mapName = null;
        mapName = clientMessage.getStringUtf8();
            parameters.mapName = mapName;
        java.lang.String cacheName = null;
        cacheName = clientMessage.getStringUtf8();
            parameters.cacheName = cacheName;
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
