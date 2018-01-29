package caching.entities;

import caching.AimsPortableFactory;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;

public class CachedAccountCurrency extends CacheBase {
    private static final String FIELD_CURRENCY = "currency";
    private static final String FIELD_CURRENCY_CODE = "currencyCode";
    private static final String FIELD_CURRENCY_NAME = "currencyName";
    private String currencyCode = "";
    private String currencyName = "";
    private String currency = "";

    public CachedAccountCurrency() {
        //Required by Hazelcast
    }

    public CachedAccountCurrency(String currencyCode, String currencyName, String currency) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.currency = currency;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_ACCOUNT_CURRENCY_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_CURRENCY, currency);
        portableWriter.writeUTF(FIELD_CURRENCY_CODE, currencyCode);
        portableWriter.writeUTF(FIELD_CURRENCY_NAME, currencyName);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        currency = portableReader.readUTF(FIELD_CURRENCY);
        currencyCode = portableReader.readUTF(FIELD_CURRENCY_CODE);
        currencyName = portableReader.readUTF(FIELD_CURRENCY_NAME);
    }

}
