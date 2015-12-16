package test;

import com.hazelcast.cache.ICache;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.cache.impl.HazelcastClientCachingProvider;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastOverloadException;
import com.hazelcast.core.ICompletableFuture;
import org.HdrHistogram.ConcurrentHistogram;

import javax.cache.CacheManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Client {

    public static void main(String[] args) throws IOException {
        final ConcurrentHistogram successHistogram = new ConcurrentHistogram(TimeUnit.MINUTES.toNanos(1), 3);
        final ConcurrentHistogram failHistogram = new ConcurrentHistogram(TimeUnit.MINUTES.toNanos(1), 3);

        ClientConfig clientConfig = new XmlClientConfigBuilder().build();
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        HazelcastClientCachingProvider cachingProvider = HazelcastClientCachingProvider.createCachingProvider(client);
        CacheManager cacheManager = cachingProvider.getCacheManager();
        final ICache cache = (ICache) cacheManager.getCache("AOS-sancar");

        final int keyRange = Integer.valueOf(args[0]);
        System.out.println("keyRange = " + keyRange);
        int threadCount = Integer.valueOf(args[1]);
        System.out.println("threadCount = " + threadCount);
        String clientId = args[2];
        System.out.println("clientId = " + clientId);
        String serverId = args[3];
        System.out.println("serverId = " + serverId);
        Integer testDuration = Integer.valueOf(args[4]);
        System.out.println("testDurationSeconds = " + testDuration);
        Integer warmupDuration = Integer.valueOf(args[5]);
        System.out.println("warmupDurationSeconds = " + warmupDuration);


        long testBegin = System.currentTimeMillis();
        final long warmupEnd = testBegin + TimeUnit.SECONDS.toMillis(warmupDuration);
        final long testEnd = testBegin + TimeUnit.SECONDS.toMillis(testDuration);
        System.out.println("TEST BEGIN  - END :  " + testBegin + "  -  " + testEnd);

        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    while (System.currentTimeMillis() < warmupEnd) {
                        try {
                            ICompletableFuture future = cache.getAsync(random.nextInt() % keyRange);
                            future.get(35, TimeUnit.MILLISECONDS);
                        } catch (HazelcastOverloadException e) {
                        } catch (InterruptedException e) {
                        } catch (ExecutionException e) {
                        } catch (TimeoutException e) {
                        }
                    }
                    System.out.println("Thread " + threadId + " finished warmup");

                    while (System.currentTimeMillis() < testEnd) {
                        long beg = System.nanoTime();
                        try {
                            ICompletableFuture future = cache.getAsync(random.nextInt() % keyRange);
                            future.get(35, TimeUnit.MILLISECONDS);
                            successHistogram.recordValue(System.nanoTime() - beg);
                        } catch (HazelcastOverloadException e) {
                            failHistogram.recordValue(System.nanoTime() - beg);
                            getFromDatabase();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            failHistogram.recordValue(System.nanoTime() - beg);
                        } catch (ExecutionException e) {
                            getFromDatabase();
                            failHistogram.recordValue(System.nanoTime() - beg);
                        } catch (TimeoutException e) {
                            getFromDatabase();
                            failHistogram.recordValue(System.nanoTime() - beg);
                        }
                    }

                    System.out.println("Thread " + threadId + " finished test");
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < threadCount; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        PrintStream printStream = new PrintStream(new FileOutputStream(serverId + " " + clientId + " " + UUID.randomUUID() + "success.hdr"));
        successHistogram.outputPercentileDistribution(printStream, 1000.0);

        PrintStream printStream2 = new PrintStream(new FileOutputStream(serverId + " " + clientId + " " + UUID.randomUUID() + "fail.hdr"));
        failHistogram.outputPercentileDistribution(printStream2, 1000.0);
    }

    private static void getFromDatabase() {
        try {
            //simulating database access
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
