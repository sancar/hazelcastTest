package test;

import com.hazelcast.core.HazelcastInstance;

import java.io.IOException;

/**
 * User: sancar
 * Date: 02/12/14
 * Time: 00:06
 */
public class Client {

    public static void main(String[] args) throws IOException {
        final HazelcastInstance client = Util.createClient();

    }
}
