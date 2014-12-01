package test;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

/**
 * User: sancar
 * Date: 02/12/14
 * Time: 00:06
 */
public class Client {

    public static void main(String[] args) {
        final HazelcastInstance client = HazelcastClient.newHazelcastClient();

    }
}
