package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.nio.Bits;
import javax.annotation.Generated;

@Generated("Hazelcast.code.generator")
@edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public final class MapReduceJobProcessInformationCodec {

    public static final MapReduceMessageType REQUEST_TYPE = MapReduceMessageType.MAPREDUCE_JOBPROCESSINFORMATION;
    public static final int RESPONSE_TYPE = 112;
    public static final boolean RETRYABLE = true;

    //************************ REQUEST *************************//

    public static class RequestParameters {
    public static final MapReduceMessageType TYPE = REQUEST_TYPE;
        public java.lang.String name;
        public java.lang.String jobId;

        public static int calculateDataSize(java.lang.String
 name, java.lang.String
 jobId) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += ParameterUtil.calculateDataSize(name);
            dataSize += ParameterUtil.calculateDataSize(jobId);
            return dataSize;
        }
    }

    public static ClientMessage encodeRequest(java.lang.String
 name, java.lang.String
 jobId) {
        final int requiredDataSize = RequestParameters.calculateDataSize(name, jobId);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(REQUEST_TYPE.id());
        clientMessage.setRetryable(RETRYABLE);
        clientMessage.set(name);
        clientMessage.set(jobId);
        clientMessage.updateFrameLength();
        return clientMessage;
    }

    public static RequestParameters decodeRequest(ClientMessage clientMessage) {
        final RequestParameters parameters = new RequestParameters();
        java.lang.String name = null;
        name = clientMessage.getStringUtf8();
            parameters.name = name;
        java.lang.String jobId = null;
        jobId = clientMessage.getStringUtf8();
            parameters.jobId = jobId;
        return parameters;
    }

    //************************ RESPONSE *************************//

    public static class ResponseParameters {
        public java.util.List<com.hazelcast.mapreduce.JobPartitionState> jobPartitionStates;
        public int processRecords;

        public static int calculateDataSize(java.util.Collection<com.hazelcast.mapreduce.JobPartitionState> jobPartitionStates, int
 processRecords) {
            int dataSize = ClientMessage.HEADER_SIZE;
            dataSize += Bits.INT_SIZE_IN_BYTES;
            for (com.hazelcast.mapreduce.JobPartitionState jobPartitionStates_item : jobPartitionStates ) {
            dataSize += com.hazelcast.client.impl.protocol.codec.JobPartitionStateCodec.calculateDataSize(jobPartitionStates_item);
            }
            dataSize += Bits.INT_SIZE_IN_BYTES;
            return dataSize;
        }
    }

    public static ClientMessage encodeResponse(java.util.Collection<com.hazelcast.mapreduce.JobPartitionState> jobPartitionStates, int
 processRecords) {
        final int requiredDataSize = ResponseParameters.calculateDataSize(jobPartitionStates, processRecords);
        ClientMessage clientMessage = ClientMessage.createForEncode(requiredDataSize);
        clientMessage.setMessageType(RESPONSE_TYPE);
        clientMessage.set(jobPartitionStates.size());
        for (com.hazelcast.mapreduce.JobPartitionState jobPartitionStates_item : jobPartitionStates) {
        com.hazelcast.client.impl.protocol.codec.JobPartitionStateCodec.encode(jobPartitionStates_item, clientMessage);
        }
        clientMessage.set(processRecords);
        clientMessage.updateFrameLength();
        return clientMessage;

    }

    public static ResponseParameters decodeResponse(ClientMessage clientMessage) {
        ResponseParameters parameters = new ResponseParameters();
        java.util.List<com.hazelcast.mapreduce.JobPartitionState> jobPartitionStates = null;
            int jobPartitionStates_size = clientMessage.getInt();
            jobPartitionStates = new java.util.ArrayList<com.hazelcast.mapreduce.JobPartitionState>(jobPartitionStates_size);
            for (int jobPartitionStates_index = 0;jobPartitionStates_index<jobPartitionStates_size;jobPartitionStates_index++) {
                com.hazelcast.mapreduce.JobPartitionState jobPartitionStates_item;
            jobPartitionStates_item = com.hazelcast.client.impl.protocol.codec.JobPartitionStateCodec.decode(clientMessage);
                jobPartitionStates.add(jobPartitionStates_item);
            }
            parameters.jobPartitionStates = jobPartitionStates;
        int processRecords ;
        processRecords = clientMessage.getInt();
            parameters.processRecords = processRecords;
        return parameters;
    }

}
