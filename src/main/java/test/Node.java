package test;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;

public class Node {


    public static void main(String[] args) throws Exception {
        Config config = new XmlConfigBuilder().build();
        Hazelcast.newHazelcastInstance(config);

    }

}
