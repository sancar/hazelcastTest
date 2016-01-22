package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class ClientAuthenticationCustomCodec {

    public static final ClientMessageType REQUEST_TYPE = ClientMessageType.CLIENT_AUTHENTICATIONCUSTOM;
    public static final int RESPONSE_TYPE = 107;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final ClientMessageType TYPE = REQUEST_TYPE;
        public com.hazelcast.nio.serialization.Data credentials;
        public java.lang.String uuid;
        public java.lang.String ownerUuid;
        public boolean isOwnerConnection;
        public java.lang.String clientType;
        public byte serializationVersion;

        public static int calculateDataSize(com.hazelcast.nio.serialization.Data
 credentials, java.lang.String
 uuid, java.lang.String
 ownerUuid, boolean
 isOwnerConnection, java.lang.String
 clientType, byte
 serializationVersion) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(credentials);
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (uuid != null) {
            dataSize += ParameterUtil.calculateDataSize(uuid);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (ownerUuid != null) {
            dataSize += ParameterUtil.calculateDataSize(ownerUuid);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            dataSize += ParameterUtil.calculateDataSize(clientType);
            dataSize += Bits.BYTE_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(com.hazelcast.nio.serialization.Data
 credentials, java.lang.String
 uuid, java.lang.String
 ownerUuid, boolean
 isOwnerConnection, java.lang.String
 clientType, byte
 serializationVersion) {
        final int requiredDataSize = RequestParameters.calculateDataSize(credentials, uuid, ownerUuid, isOwnerConnection, clientType, serializationVersion);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(credentials);
        boolean uuid_isNull;
        if (uuid == null) {
            uuid_isNull = true;
            clientMessage.set(uuid_isNull);
        } else {
            uuid_isNull= false;
            clientMessage.set(uuid_isNull);
        clientMessage.set(uuid);
        }
        boolean ownerUuid_isNull;
        if (ownerUuid == null) {
            ownerUuid_isNull = true;
            clientMessage.set(ownerUuid_isNull);
        } else {
            ownerUuid_isNull= false;
            clientMessage.set(ownerUuid_isNull);
        clientMessage.set(ownerUuid);
        }
        clientMessage.set(isOwnerConnection);
        clientMessage.set(clientType);
        clientMessage.set(serializationVersion);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        com.hazelcast.nio.serialization.Data credentials = null;
        credentials = clientMessage.getData();
            parameters.credentials = credentials;
        java.lang.String uuid = null;
        boolean uuid_isNull = clientMessage.getBoolean();
        if (!uuid_isNull) {
        uuid = clientMessage.getStringUtf8();
            parameters.uuid = uuid;
        }
        java.lang.String ownerUuid = null;
        boolean ownerUuid_isNull = clientMessage.getBoolean();
        if (!ownerUuid_isNull) {
        ownerUuid = clientMessage.getStringUtf8();
            parameters.ownerUuid = ownerUuid;
        }
        boolean isOwnerConnection ;
        isOwnerConnection = clientMessage.getBoolean();
            parameters.isOwnerConnection = isOwnerConnection;
        java.lang.String clientType = null;
        clientType = clientMessage.getStringUtf8();
            parameters.clientType = clientType;
        byte serializationVersion ;
        serializationVersion = clientMessage.getByte();
            parameters.serializationVersion = serializationVersion;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public byte status;
        public com.hazelcast.nio.Address address;
        public java.lang.String uuid;
        public java.lang.String ownerUuid;
        public byte serializationVersion;

        public static int calculateDataSize(byte
 status, com.hazelcast.nio.Address
 address, java.lang.String
 uuid, java.lang.String
 ownerUuid, byte
 serializationVersion) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.BYTE_SIZE_IN_BYTES;
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (address != null) {
            dataSize += com.hazelcast.client.impl.protocol.codec.AddressCodec.calculateDataSize(address);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (uuid != null) {
            dataSize += ParameterUtil.calculateDataSize(uuid);
            }
            dataSize += Bits.BOOLEAN_SIZE_IN_BYTES;
            if (ownerUuid != null) {
            dataSize += ParameterUtil.calculateDataSize(ownerUuid);
            }
            dataSize += Bits.BYTE_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(byte
 status, com.hazelcast.nio.Address
 address, java.lang.String
 uuid, java.lang.String
 ownerUuid, byte
 serializationVersion) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(status, address, uuid, ownerUuid, serializationVersion);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(status);
        boolean address_isNull;
        if (address == null) {
            address_isNull = true;
            clientMessage.set(address_isNull);
        } else {
            address_isNull= false;
            clientMessage.set(address_isNull);
        com.hazelcast.client.impl.protocol.codec.AddressCodec.encode(address, clientMessage);
        }
        boolean uuid_isNull;
        if (uuid == null) {
            uuid_isNull = true;
            clientMessage.set(uuid_isNull);
        } else {
            uuid_isNull= false;
            clientMessage.set(uuid_isNull);
        clientMessage.set(uuid);
        }
        boolean ownerUuid_isNull;
        if (ownerUuid == null) {
            ownerUuid_isNull = true;
            clientMessage.set(ownerUuid_isNull);
        } else {
            ownerUuid_isNull= false;
            clientMessage.set(ownerUuid_isNull);
        clientMessage.set(ownerUuid);
        }
        clientMessage.set(serializationVersion);
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        byte status ;
        status = clientMessage.getByte();
            parameters.status = status;
        com.hazelcast.nio.Address address = null;
        boolean address_isNull = clientMessage.getBoolean();
        if (!address_isNull) {
            address = com.hazelcast.client.impl.protocol.codec.AddressCodec.decode(clientMessage);
            parameters.address = address;
        }
        java.lang.String uuid = null;
        boolean uuid_isNull = clientMessage.getBoolean();
        if (!uuid_isNull) {
        uuid = clientMessage.getStringUtf8();
            parameters.uuid = uuid;
        }
        java.lang.String ownerUuid = null;
        boolean ownerUuid_isNull = clientMessage.getBoolean();
        if (!ownerUuid_isNull) {
        ownerUuid = clientMessage.getStringUtf8();
            parameters.ownerUuid = ownerUuid;
        }
        byte serializationVersion ;
        serializationVersion = clientMessage.getByte();
            parameters.serializationVersion = serializationVersion;
        return parameters;
    }

}
