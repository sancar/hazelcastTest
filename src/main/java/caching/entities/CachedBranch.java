package caching.entities;

import caching.AimsPortableFactory;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;

public class CachedBranch extends CacheBase {
    private static final String FIELD_CODE = "code";
    private static final String FIELD_NAME = "name";
    private String code = "";
    private String name = "";

    public CachedBranch() {
        //Required by Hazelcast
    }

    public CachedBranch(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_BRANCH_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_CODE, code);
        portableWriter.writeUTF(FIELD_NAME, name);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        code = portableReader.readUTF(FIELD_CODE);
        name = portableReader.readUTF(FIELD_NAME);
    }

}
