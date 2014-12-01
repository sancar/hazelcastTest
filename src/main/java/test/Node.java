package test;

import java.io.FileNotFoundException;

/**
 * User: sancar
 * Date: 01/12/14
 * Time: 18:17
 */
public class Node {

    private static HazelcastInstance createServer() throws FileNotFoundException {
        final Config config = new XmlConfigBuilder("/Users/sancar/workspace/IdeaProjects/testEnv/src/main/resources/hazelcast.xml").build();
        config.setProperty("hazelcast.merge.first.run.delay.seconds", "10");
        config.setProperty("hazelcast.merge.next.run.delay.seconds", "10");

        config.setProperty("hazelcast.heartbeat.interval.seconds", "5");
        config.setProperty("hazelcast.max.no.heartbeat.seconds", "20");
//        config.setProperty("hazelcast.operation.call.timeout.millis", "1000");
//        config.setProperty("hazelcast.client.max.no.heartbeat.seconds", "20");
//        config.setProperty("hazelcast.client.heartbeat.interval.seconds", "5");

//        config.setLiteMember(true);


        return Hazelcast.newHazelcastInstance(config);
    }

    public static void main(String[] args) throws Exception {
        final Config config = new XmlConfigBuilder("/Users/sancar/workspace/IdeaProjects/testEnv/src/main/resources/hazelcast.xml").build();
        final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);

//        System.out.println(readFile("/Users/sancar/ec2.identity") + ":");
//        System.out.println(readFile("/Users/sancar/ec2.credential")  + ":");

    }

}
