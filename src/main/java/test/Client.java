package test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.IOException;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws IOException {
        ClientConfig clientConfig = new XmlClientConfigBuilder().build();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        final IMap<Object, Boolean> map = client.getMap("default");

        final Random random = new Random();

        final Thread clientThread = new Thread() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.print(".");
                        map.get(random.nextInt());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        clientThread.start();

    }
}
