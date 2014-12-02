package test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientAwsConfig;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.AwsConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: sancar
 * Date: 02/12/14
 * Time: 10:04
 */
public class Util {

    private Util() {

    }


    public static HazelcastInstance createServer() throws IOException {
        final Config config = new Config();
//        config.setProperty("hazelcast.merge.first.run.delay.seconds", "10");
//        config.setProperty("hazelcast.merge.next.run.delay.seconds", "10");
//        config.setProperty("hazelcast.heartbeat.interval.seconds", "5");
//        config.setProperty("hazelcast.max.no.heartbeat.seconds", "20");
//        config.setProperty("hazelcast.operation.call.timeout.millis", "1000");
//        config.setProperty("hazelcast.client.max.no.heartbeat.seconds", "20");
//        config.setProperty("hazelcast.client.heartbeat.interval.seconds", "5");

        final JoinConfig join = config.getNetworkConfig().getJoin();
        join.getMulticastConfig().setEnabled(false);
        final AwsConfig awsConfig = join.getAwsConfig();
        awsConfig.setAccessKey(Util.readFile("/home/ec2-user/ec2.identity"))
                .setSecretKey(Util.readFile("/home/ec2-user/ec2.credential"))
                .setRegion("us-east-1b")
                .setHostHeader("ec2.amazonaws.com")
                .setTagKey("Name")
                .setTagValue("sancar").setEnabled(true);
        Hazelcast.newHazelcastInstance(config);
        return Hazelcast.newHazelcastInstance(config);
    }

    public static HazelcastInstance createClient() throws IOException {
        ClientConfig clientConfig = new ClientConfig();
        ClientAwsConfig clientAwsConfig = new ClientAwsConfig();
        clientAwsConfig.setInsideAws(false)
                .setAccessKey(Util.readFile("/home/ec2-user/ec2.identity"))
                .setSecretKey(Util.readFile("/home/ec2-user/ec2.credential"))
                .setRegion("us-east-1b")
                .setHostHeader("ec2.amazonaws.com")
                .setTagKey("Name")
                .setTagValue("sancar").setEnabled(true);
        clientConfig.getNetworkConfig().setAwsConfig(clientAwsConfig);
        return HazelcastClient.newHazelcastClient(clientConfig);
    }


    private static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }


}
