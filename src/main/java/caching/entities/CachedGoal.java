package caching.entities;

import caching.AimsPortableFactory;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;
import java.util.Date;

import static caching.entities.CachedAccount.convertToDate;
import static caching.entities.CachedAccount.convertToLong;

public class CachedGoal extends CacheBase {
    private static final String FIELD_NAME = "name";
    private static final String FIELD_AMOUNT = "amount";
    private static final String FIELD_TARGET_DATE = "targetDate";

    private CachedCurrency amount = new CachedCurrency();
    private String name = "";
    private Date targetDate = new Date();

    public CachedGoal() {
        //Required by Hazelcast
    }

    public CachedGoal(CachedCurrency amount, String name, Date targetDate) {
        this.amount = amount;
        this.name = name;
        this.targetDate = targetDate;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_GOAL_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_NAME, name);
        portableWriter.writeLong(FIELD_TARGET_DATE, convertToLong(targetDate));
        portableWriter.writePortable(FIELD_AMOUNT, amount);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        name = portableReader.readUTF(FIELD_NAME);
        targetDate = convertToDate(portableReader.readLong(FIELD_TARGET_DATE));
        amount = portableReader.readPortable(FIELD_AMOUNT);
    }

}
