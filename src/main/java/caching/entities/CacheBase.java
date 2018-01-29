package caching.entities;

import com.hazelcast.nio.serialization.Portable;

public abstract class CacheBase  implements Portable {
    protected static final String DUMMY_RECORD_KEY = "INVALID";
}
