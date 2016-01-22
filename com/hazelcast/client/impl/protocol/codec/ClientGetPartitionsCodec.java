package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientGetPartitionsCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_GETPARTITIONS;
    public static final int RESPONSE_TYPE = 108;
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
        public java.util.Map<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>> partitions;

        public static int calculateDataSize(java.util.Map<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>>
 partitions) {
            int dataSize = ClientMessage.HEADER_SIZE;
        for (java.util.Map.Entry<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>> entry : partitions.entrySet() ) {
            com.hazelcast.nio.Address key = entry.getKey();
            java.util.List<java.lang.Integer> val = entry.getValue();
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(key);
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (java.lang.Integer val_item : val ) {
            dataSize += ParameterUtil.calculateDataSize(val_item);
            }
        }
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Map<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>>
 partitions) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(partitions);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(partitions.size());
        for (java.util.Map.Entry<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>> entry : partitions.entrySet() ) {
            com.hazelcast.nio.Address key = entry.getKey();
            java.util.List<java.lang.Integer> val = entry.getValue();
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(key, clientMessage);
        clientMessage.set(val.size());
        for (java.lang.Integer val_item : val) {
        clientMessage.set(val_item);
        }
        }
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.Map<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>> partitions = null;
        int partitions_size = clientMessage.getInt();
        partitions = new java.util.HashMap<com.hazelcast.nio.Address,java.util.List<java.lang.Integer>>(partitions_size);
        for (int partitions_index = 0;partitions_index<partitions_size;partitions_index++) {
            com.hazelcast.nio.Address partitions_key;
            java.util.List<java.lang.Integer> partitions_val;
            partitions_key = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
            int partitions_val_size = clientMessage.getInt();
            partitions_val = new java.util.ArrayList<java.lang.Integer>(partitions_val_size);
            for (int partitions_val_index = 0;partitions_val_index<partitions_val_size;partitions_val_index++) {
                java.lang.Integer partitions_val_item;
        partitions_val_item = clientMessage.getInt();
                partitions_val.add(partitions_val_item);
            }
            partitions.put(partitions_key, partitions_val);
        }
            parameters.partitions = partitions;
        return parameters;
    }

}
