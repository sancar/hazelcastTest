package test;

import com.hazelcast.core.EntryAdapter;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 * User: sancar
 * Date: 01/12/14
 * Time: 18:17
 */
public class Node {

    static {
        System.setProperty("java.util.logging.config.file", "~/logging.properties");
    }

    public static void main(String[] args) throws Exception {
        final HazelcastInstance server = Util.createServer();
        final IMap<Object, Boolean> map = server.getMap("default");

        map.addEntryListener(new EntryAdapter<Object, Boolean>() {
            @Override
            public void onEntryEvent(EntryEvent<Object, Boolean> event) {
                System.err.println("map event = " + event.getKey());
            }
        }, true);


    }

}
