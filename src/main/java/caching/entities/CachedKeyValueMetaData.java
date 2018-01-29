package caching.entities;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import caching.AimsPortableFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static caching.entities.CachedAccount.updateNonNull;

public class CachedKeyValueMetaData extends CacheBase {
    private static final String FIELD_KEY = "key";
    private static final String FIELD_VALUE = "value";

    private String key = "";
    private String value = "";

    public CachedKeyValueMetaData() {
        //Required by Hazelcast
    }

    public CachedKeyValueMetaData(String key, String value) {
        this.key = updateNonNull(key, this.key);
        this.value = updateNonNull(value, this.value);
    }


    protected static Portable[] getPortableArray(List<CachedKeyValueMetaData> input) {
        if (!input.isEmpty()) {
            return input.toArray(new Portable[input.size()]);
        }
        List<CachedKeyValueMetaData> dummyList = new ArrayList(1);
        dummyList.add(new CachedKeyValueMetaData(DUMMY_RECORD_KEY, DUMMY_RECORD_KEY));

        return dummyList.toArray(new Portable[1]);
    }

    protected static List<CachedKeyValueMetaData> getList(Portable[] input, int size) {
        if (size == 0) {
            return new ArrayList();
        }
        List<CachedKeyValueMetaData> keyMetaDataList = new ArrayList();
        for (Portable portable : input) {
            CachedKeyValueMetaData keyMetaData = (CachedKeyValueMetaData) portable;
            if (!DUMMY_RECORD_KEY.equals(keyMetaData.getKey())) {
                keyMetaDataList.add(keyMetaData);
            }
        }
        return keyMetaDataList;
    }


    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_KEY_VALUE_METADATA_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_KEY, key);
        portableWriter.writeUTF(FIELD_VALUE, value);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        key = portableReader.readUTF(FIELD_KEY);
        value = portableReader.readUTF(FIELD_VALUE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CachedKeyValueMetaData that = (CachedKeyValueMetaData) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
