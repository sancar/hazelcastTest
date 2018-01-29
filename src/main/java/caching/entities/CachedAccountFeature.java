package caching.entities;

import caching.AimsPortableFactory;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CachedAccountFeature extends CacheBase {

    public static final String FIELD_FEATURE = "feature";
    public static final String FIELD_VALUE = "value";
    private String feature = "";
    private boolean value = true;

    public CachedAccountFeature() {
        //Required by Hazelcast
    }

    public CachedAccountFeature(String feature, boolean value) {
        this.feature = feature;
        this.value = value;
    }

    protected static Portable[] getPortableArray(List<CachedAccountFeature> input) {
        if (!input.isEmpty()) {
            return input.toArray(new Portable[input.size()]);
        }
        List<CachedAccountFeature> dummyList = new ArrayList(1);
        dummyList.add(new CachedAccountFeature(DUMMY_RECORD_KEY, false));
        return dummyList.toArray(new Portable[1]);
    }

    protected static List<CachedAccountFeature> getList(Portable[] input, int size) {
        if (size == 0) {
            return new ArrayList();
        }
        List<CachedAccountFeature> accountFeatureList = new ArrayList();
        for (Portable portable : input) {
            CachedAccountFeature accountFeature = (CachedAccountFeature) portable;
            if (!DUMMY_RECORD_KEY.equals(accountFeature.getFeature())) {
                accountFeatureList.add(accountFeature);
            }
        }
        return accountFeatureList;
    }


    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_ACCOUNT_FEATURE_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_FEATURE, feature);
        portableWriter.writeBoolean(FIELD_VALUE, value);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        feature = portableReader.readUTF(FIELD_FEATURE);
        value = portableReader.readBoolean(FIELD_VALUE);
    }


    public String getFeature() {
        return feature;
    }

}
