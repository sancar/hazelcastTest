package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ReplicatedMapAddEntryListenerToKeyWithPredicateCodec {

    public static final ReplicatedMapMessageType REQUEST_TYPE = ReplicatedMapMessageType.REPLICATEDMAP_ADDENTRYLISTENERTOKEYWITHPREDICATE;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ReplicatedMapMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public com.hazelcast.nio.serialization.Data key;
        public com.hazelcast.nio.serialization.Data predicate;
        public boolean localOnly;

        public static int calculateDataSize(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 predicate, boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(key);
            dataSize += ParameterUtil.calculateDataSize(predicate);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 predicate, boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, key, predicate, localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(key);
        clientMessage.set(predicate);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        com.hazelcast.nio.serialization.Data key = null;
        key = clientMessage.getData();
            parameters.key = key;
        com.hazelcast.nio.serialization.Data predicate = null;
        predicate = clientMessage.getData();
            parameters.predicate = predicate;
        boolean localOnly ;
        localOnly = clientMessage.getBoolean();
            parameters.localOnly = localOnly;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.lang.String response;

        public static int calculateDataSize(java.lang.String
 response) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(response);
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.lang.String
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
        java.lang.String response = null;
        response = clientMessage.getStringUtf8();
            parameters.response = response;
        return parameters;
    }


    //************************ EVENTS *************************//

    public static ClientMessage encodeEntryEvent(com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 value, com.hazelcast.nio.serialization.Data
 oldValue, com.hazelcast.nio.serialization.Data
 mergingValue, int
 eventType, java.lang.String
 uuid, int
 numberOfAffectedEntries){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (key != null) {
            dataSize += ParameterUtil.calculateDataSize(key);
            }
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (value != null) {
            dataSize += ParameterUtil.calculateDataSize(value);
            }
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (oldValue != null) {
            dataSize += ParameterUtil.calculateDataSize(oldValue);
            }
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (mergingValue != null) {
            dataSize += ParameterUtil.calculateDataSize(mergingValue);
            }
                dataSize += Bits.INT_SIZE_IN_BYTES;
                dataSize += ParameterUtil.calculateDataSize(uuid);
                dataSize += Bits.INT_SIZE_IN_BYTES;
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_ENTRY);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        boolean key_isNull;
        if (key == null) {
            key_isNull = true;
            clientMessage.set(key_isNull);
        } else {
            key_isNull= false;
            clientMessage.set(key_isNull);
        clientMessage.set(key);
        }
        boolean value_isNull;
        if (value == null) {
            value_isNull = true;
            clientMessage.set(value_isNull);
        } else {
            value_isNull= false;
            clientMessage.set(value_isNull);
        clientMessage.set(value);
        }
        boolean oldValue_isNull;
        if (oldValue == null) {
            oldValue_isNull = true;
            clientMessage.set(oldValue_isNull);
        } else {
            oldValue_isNull= false;
            clientMessage.set(oldValue_isNull);
        clientMessage.set(oldValue);
        }
        boolean mergingValue_isNull;
        if (mergingValue == null) {
            mergingValue_isNull = true;
            clientMessage.set(mergingValue_isNull);
        } else {
            mergingValue_isNull= false;
            clientMessage.set(mergingValue_isNull);
        clientMessage.set(mergingValue);
        }
        clientMessage.set(eventType);
        clientMessage.set(uuid);
        clientMessage.set(numberOfAffectedEntries);
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_ENTRY) {
        com.hazelcast.nio.serialization.Data key = null;
        boolean key_isNull = clientMessage.getBoolean();
        if (!key_isNull) {
        key = clientMessage.getData();
        }
        com.hazelcast.nio.serialization.Data value = null;
        boolean value_isNull = clientMessage.getBoolean();
        if (!value_isNull) {
        value = clientMessage.getData();
        }
        com.hazelcast.nio.serialization.Data oldValue = null;
        boolean oldValue_isNull = clientMessage.getBoolean();
        if (!oldValue_isNull) {
        oldValue = clientMessage.getData();
        }
        com.hazelcast.nio.serialization.Data mergingValue = null;
        boolean mergingValue_isNull = clientMessage.getBoolean();
        if (!mergingValue_isNull) {
        mergingValue = clientMessage.getData();
        }
        int eventType ;
        eventType = clientMessage.getInt();
        java.lang.String uuid = null;
        uuid = clientMessage.getStringUtf8();
        int numberOfAffectedEntries ;
        numberOfAffectedEntries = clientMessage.getInt();
                handle(key, value, oldValue, mergingValue, eventType, uuid, numberOfAffectedEntries);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(com.hazelcast.nio.serialization.Data
 key, com.hazelcast.nio.serialization.Data
 value, com.hazelcast.nio.serialization.Data
 oldValue, com.hazelcast.nio.serialization.Data
 mergingValue, int
 eventType, java.lang.String
 uuid, int
 numberOfAffectedEntries);

   }

}
