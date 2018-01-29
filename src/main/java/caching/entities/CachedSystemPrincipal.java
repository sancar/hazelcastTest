package caching.entities;

import caching.AimsPortableFactory;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CachedSystemPrincipal extends CacheBase {

    private static final String FIELD_ID = "id";
    private static final String FIELD_BANKING_TERRITORY_KEY = "bankingTerritoryKey";
    private static final String FIELD_SYSTEM_TYPE = "systemType";
    private static final String ACCOUNT_SIZE = "accountSize";
    private static final String FIELD_ACCOUNTS = "accounts";
    private String id = "";
    private String bankingTerritoryKey = "";
    private String systemType = "";
    private List<CachedAccount> accounts = new ArrayList();

    public CachedSystemPrincipal() {
        //Required by Hazelcast
    }

    public CachedSystemPrincipal(String id, String bankingTerritoryKey, String systemType, List<CachedAccount> accounts) {
        this.id = id;
        this.bankingTerritoryKey = bankingTerritoryKey;
        this.systemType = systemType;
        this.accounts = accounts;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_SYSTEM_PRINCIPAL_CLASS_ID;
    }


    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_ID, id);
        portableWriter.writeUTF(FIELD_BANKING_TERRITORY_KEY, bankingTerritoryKey);
        portableWriter.writeUTF(FIELD_SYSTEM_TYPE, systemType);
        portableWriter.writeInt(ACCOUNT_SIZE, accounts.size());
        if (!accounts.isEmpty()) {
            portableWriter.writePortableArray(FIELD_ACCOUNTS, accounts.toArray(new Portable[accounts.size()]));
        } else {
//            ArrayList<CachedAccount> dummmy = new ArrayList<CachedAccount>();
//            dummmy.add(new CachedAccount());
//            portableWriter.writePortableArray(FIELD_ACCOUNTS,  dummmy.toArray(new Portable[dummmy.size()]));
        }
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        id = portableReader.readUTF(FIELD_ID);
        bankingTerritoryKey = portableReader.readUTF(FIELD_BANKING_TERRITORY_KEY);
        systemType = portableReader.readUTF(FIELD_SYSTEM_TYPE);
        int accountsSize = portableReader.readInt(ACCOUNT_SIZE);
        if (accountsSize > 0) {
            Portable[] accountsArray = portableReader.readPortableArray(FIELD_ACCOUNTS);
            for (Portable account : accountsArray) {
                accounts.add((CachedAccount) account);
            }
        }
    }

}
