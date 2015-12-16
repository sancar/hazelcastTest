package test;

import com.hazelcast.cache.ICache;
import com.hazelcast.cache.impl.HazelcastServerCachingProvider;
import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import javax.cache.CacheManager;

public class Node {
    public static void main(String[] args) throws Exception {
        Config config = new XmlConfigBuilder().build();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        HazelcastServerCachingProvider cachingProvider = HazelcastServerCachingProvider.createCachingProvider(instance);
        CacheManager cacheManager = cachingProvider.getCacheManager();

        ICache cache = (ICache) cacheManager.getCache("AOS-sancar");

        Integer numberOfItems = Integer.valueOf(args[0]);
        System.out.println("numberOfItems = " + numberOfItems);

        Integer valueSize = Integer.valueOf(args[1]);
        System.out.println("valueSizeKB = " + valueSize);

        String serverID = args[2];
        System.out.println("serverID = " + serverID);

        for (int i = 0; i < numberOfItems; i++) {
            if (i % 10000 == 0) {
                System.out.println("loading " + i + " of " + numberOfItems);
            }
            cache.put(i, new byte[valueSize * 1000]);
        }

        System.out.println("LOAD FINISHED");

    }

}
