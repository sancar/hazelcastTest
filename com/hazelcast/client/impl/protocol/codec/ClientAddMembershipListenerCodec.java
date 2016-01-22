package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientAddMembershipListenerCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_ADDMEMBERSHIPLISTENER;
    public static final int RESPONSE_TYPE = 104;
    public static final boolean RETRYABLE = false;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ClientMessageType TYPE = REQUEST_TYPE;
        public boolean localOnly;

        public static int calculateDataSize(boolean
 localOnly) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(boolean
 localOnly) {
        final int requiredDataSize = RequestParameters.calculateDataSize(localOnly);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(localOnly);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
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

    public static ClientMessage encodeMemberEvent(com.hazelcast.core.Member
 member, int
 eventType){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += com.hazelcast.client.impl.protocol.codec.MemberCodec.calculateDataSize(member);
                dataSize += Bits.INT_SIZE_IN_BYTES;
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBER);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        com.hazelcast.client.impl.protocol.codec.MemberCodec.encode(member, clientMessage);
        clientMessage.set(eventType);
        clientMessage.updateFrameLength();
        return clientMessage;
    };

    public static ClientMessage encodeMemberListEvent(java.util.Collection<com.hazelcast.core.Member> members){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.core.Member members_item : members ) {
            dataSize += com.hazelcast.client.impl.protocol.codec.MemberCodec.calculateDataSize(members_item);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBERLIST);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(members.size());
        for (com.hazelcast.core.Member members_item : members) {
        com.hazelcast.client.impl.protocol.codec.MemberCodec.encode(members_item, clientMessage);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };

    public static ClientMessage encodeMemberAttributeChangeEvent(java.lang.String
 uuid, java.lang.String
 key, int
 operationType, java.lang.String
 value){
        int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(uuid);
                dataSize += ParameterUtil.calculateDataSize(key);
                dataSize += Bits.INT_SIZE_IN_BYTES;
                dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (value != null) {
            dataSize += ParameterUtil.calculateDataSize(value);
            }
    ;

        ClientMessage clientMessage = ClientMessage.createForEncode(dataSize);
        clientMessage.setMessageType(com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBERATTRIBUTECHANGE);
        clientMessage.addFlag(ClientMessage.LISTENER_EVENT_FLAG);

        clientMessage.set(uuid);
        clientMessage.set(key);
        clientMessage.set(operationType);
        boolean value_isNull;
        if (value == null) {
            value_isNull = true;
            clientMessage.set(value_isNull);
        } else {
            value_isNull= false;
            clientMessage.set(value_isNull);
        clientMessage.set(value);
        }
        clientMessage.updateFrameLength();
        return clientMessage;
    };



  public static abstract class AbstractEventHandler{

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBER) {
        com.hazelcast.core.Member member = null;
            member = com.hazelcast.client.impl.protocol.codec.MemberCodec.decode(clientMessage);
        int eventType ;
        eventType = clientMessage.getInt();
                handle(member, eventType);
                return;
            }
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBERLIST) {
        java.util.List<com.hazelcast.core.Member> members = null;
            int members_size = clientMessage.getInt();
            members = new java.util.ArrayList<com.hazelcast.core.Member>(members_size);
            for (int members_index = 0;members_index<members_size;members_index++) {
                com.hazelcast.core.Member members_item;
            members_item = com.hazelcast.client.impl.protocol.codec.MemberCodec.decode(clientMessage);
                members.add(members_item);
            }
                handle(members);
                return;
            }
            if (messageType == com.hazelcast.client.impl.protocol.EventMessageConst.EVENT_MEMBERATTRIBUTECHANGE) {
        java.lang.String uuid = null;
        uuid = clientMessage.getStringUtf8();
        java.lang.String key = null;
        key = clientMessage.getStringUtf8();
        int operationType ;
        operationType = clientMessage.getInt();
        java.lang.String value = null;
        boolean value_isNull = clientMessage.getBoolean();
        if (!value_isNull) {
        value = clientMessage.getStringUtf8();
        }
                handle(uuid, key, operationType, value);
                return;
            }
            com.hazelcast.logging.Logger.getLogger(super.getClass()).warning("Unknown message type received on event handler :" + clientMessage.getMessageType());
        }

        public abstract void handle(com.hazelcast.core.Member
 member, int
 eventType);

        public abstract void handle(java.util.Collection<com.hazelcast.core.Member> members);

        public abstract void handle(java.lang.String
 uuid, java.lang.String
 key, int
 operationType, java.lang.String
 value);

   }

}
