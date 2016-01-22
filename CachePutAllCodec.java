package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class CachePutAllCodec {

    public static final CacheMessageType REQUEST_TYPE = CacheMessageType.CACHE_PUTALL;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final CacheMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> entries;
        public com.hazelcast.nio.serialization.Data expiryPolicy;
        public int completionId;

        public static int calculateDataSize(java.lang.String
 name, java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> entries, com.hazelcast.nio.serialization.Data
 expiryPolicy, int
 completionId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entries_item : entries ) {
            dataSize += ParameterUtil.calculateDataSize(entries_item);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (expiryPolicy != null) {
            dataSize += ParameterUtil.calculateDataSize(expiryPolicy);
            }
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.util.Collection<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> entries, com.hazelcast.nio.serialization.Data
 expiryPolicy, int
 completionId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, entries, expiryPolicy, completionId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(entries.size());
        for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entries_item : entries) {
        clientMessage.set(entries_item);
        }
        boolean expiryPolicy_isNull;
        if (expiryPolicy == null) {
            expiryPolicy_isNull = true;
            clientMessage.set(expiryPolicy_isNull);
        } else {
            expiryPolicy_isNull= false;
            clientMessage.set(expiryPolicy_isNull);
        clientMessage.set(expiryPolicy);
        }
        clientMessage.set(completionId);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.util.List<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>> entries = null;
            int entries_size = clientMessage.getInt();
            entries = new java.util.ArrayList<java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>>(entries_size);
            for (int entries_index = 0;entries_index<entries_size;entries_index++) {
                java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entries_item;
        entries_item = clientMessage.getMapEntry();
                entries.add(entries_item);
            }
            parameters.entries = entries;
        com.hazelcast.nio.serialization.Data expiryPolicy = null;
        boolean expiryPolicy_isNull = clientMessage.getBoolean();
        if (!expiryPolicy_isNull) {
        expiryPolicy = clientMessage.getData();
            parameters.expiryPolicy = expiryPolicy;
        }
        int completionId ;
        completionId = clientMessage.getInt();
            parameters.completionId = completionId;
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
