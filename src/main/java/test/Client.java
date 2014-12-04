package test;

import com.hazelcast.core.EntryAdapter;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.io.IOException;
import java.util.Random;

/**
 * User: sancar
 * Date: 02/12/14
 * Time: 00:06
 */
public class Client {

    static {
        System.setProperty("java.util.logging.config.file", "/home/msk/hazelcastTest/logging.propertis");
    }


    public static void main(String[] args) throws IOException {
        final HazelcastInstance client = Util.createClient();
        final IMap<Object, Boolean> mapC = client.getMap("default");

        mapC.addEntryListener(new EntryAdapter<Object, Boolean>() {
            @Override
            public void onEntryEvent(EntryEvent<Object, Boolean> event) {
                System.err.println("mapC event = " + event.getKey());
            }
        }, true);


        final Random random = new Random();

        final Thread clientThread = new Thread() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(5000);
                        mapC.put(random.nextInt(), true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        clientThread.start();


    }
}
