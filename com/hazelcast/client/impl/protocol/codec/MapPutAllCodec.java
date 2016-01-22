package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapPutAllCodec {

    public static final MapMessageType REQUEST_TYPE = MapMessageType.MAP_PUTALL;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.util.Map<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entries;

        public static int calculateDataSize(java.lang.String
 name, java.util.Map<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>
 entries) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
        for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entry : entries.entrySet() ) {
            com.hazelcast.nio.serialization.Data key = entry.getKey();
            com.hazelcast.nio.serialization.Data val = entry.getValue();
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += ParameterUtil.calculateDataSize(val);
        }
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.util.Map<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>
 entries) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, entries);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(entries.size());
        for (java.util.Map.Entry<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entry : entries.entrySet() ) {
            com.hazelcast.nio.serialization.Data key = entry.getKey();
            com.hazelcast.nio.serialization.Data val = entry.getValue();
        clientMessage.set(key);
        clientMessage.set(val);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.util.Map<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data> entries = null;
        int entries_size = clientMessage.getInt();
        entries = new java.util.HashMap<com.hazelcast.nio.serialization.Data,com.hazelcast.nio.serialization.Data>(entries_size);
        for (int entries_index = 0;entries_index<entries_size;entries_index++) {
            com.hazelcast.nio.serialization.Data entries_key;
            com.hazelcast.nio.serialization.Data entries_val;
        entries_key = clientMessage.getData();
        entries_val = clientMessage.getData();
            entries.put(entries_key, entries_val);
        }
            parameters.entries = entries;
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
