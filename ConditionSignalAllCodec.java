package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ConditionSignalAllCodec {

    public static final ConditionMessageType REQUEST_TYPE = ConditionMessageType.CONDITION_SIGNALALL;
    public static final int RESPONSE_TYPE = 100;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ConditionMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public long threadId;
        public java.lang.String lockName;

        public static int calculateDataSize(java.lang.String
 name, long
 threadId, java.lang.String
 lockName) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += Bits.LONG_SIZE_IN_BYTES;
            dataSize += ParameterUtil.calculateDataSize(lockName);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, long
 threadId, java.lang.String
 lockName) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, threadId, lockName);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(threadId);
        clientMessage.set(lockName);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        long threadId ;
        threadId = clientMessage.getLong();
            parameters.threadId = threadId;
        java.lang.String lockName = null;
        lockName = clientMessage.getStringUtf8();
            parameters.lockName = lockName;
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
