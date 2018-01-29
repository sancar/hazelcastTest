package test;

import caching.entities.CachedAccount;
import caching.entities.CachedAccountCurrency;
import caching.entities.CachedAccountFeature;
import caching.entities.CachedBranch;
import caching.entities.CachedCard;
import caching.entities.CachedCurrency;
import caching.entities.CachedGoal;
import caching.entities.CachedKeyValueMetaData;
import caching.entities.CachedSystemPrincipal;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: sancar
 * Date: 01/12/14
 * Time: 18:17
 */
public class Node {

    public static void main(String[] args) throws Exception {
//        Config config = new XmlConfigBuilder().build();
//        ClassDefinitionBuilder classDefinitionBuilder = new ClassDefinitionBuilder(AimsPortableFactory.PORTABLE_FACTORY_ID, AimsPortableFactory.CACHED_ACCOUNT_CLASS_ID);
//        ClassDefinitionBuilder classDefinitionBuilder = new ClassDefinitionBuilder(AimsPortableFactory.PORTABLE_FACTORY_ID, AimsPortableFactory.CACHED_ACCOUNT_CLASS_ID, 6);
//        classDefinitionBuilder.addUTFField(CachedAccountFeature.FIELD_FEATURE);
//        classDefinitionBuilder.addBooleanField(CachedAccountFeature.FIELD_VALUE);
//        config.getSerializationConfig().addClassDefinition(classDefinitionBuilder.build());


        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        final IMap<Integer, CachedSystemPrincipal> map = hazelcastInstance.getMap("default");


        {
            ArrayList<CachedAccount> cachedAccounts = new ArrayList<CachedAccount>();
            ArrayList<CachedAccountFeature> cachedAccountFeatures = new ArrayList<CachedAccountFeature>();
            cachedAccountFeatures.add(new CachedAccountFeature("faafa", true));
            cachedAccountFeatures.add(new CachedAccountFeature("faafa", true));

            List<CachedKeyValueMetaData> keyValueMetaData = new ArrayList<CachedKeyValueMetaData>();
            keyValueMetaData.add(new CachedKeyValueMetaData("s", "s"));
            cachedAccounts.add(new CachedAccount("13", "s", " s", "s",
                    keyValueMetaData, cachedAccountFeatures, "n", "h", new CachedGoal(),
                    new Date(), new Date(), new Date(), new Date(), new Date(), new Date(),
                    "13", "s", " s", "s",
                    "13", "s", " s", "s", new BigDecimal(1),
                    true, true, true, 1, 1,
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedBranch(), new CachedCard(), new CachedCurrency(), new CachedCurrency(), new CachedAccountCurrency()));

            map.put(1, new CachedSystemPrincipal("s", "s", "s", cachedAccounts));
            System.out.println(map.get(1));
        }

        {
            ArrayList<CachedAccount> cachedAccounts = new ArrayList<CachedAccount>();
            ArrayList<CachedAccountFeature> cachedAccountFeatures = new ArrayList<CachedAccountFeature>();


            List<CachedKeyValueMetaData> keyValueMetaData = new ArrayList<CachedKeyValueMetaData>();
            keyValueMetaData.add(new CachedKeyValueMetaData("s", "s"));
            cachedAccounts.add(new CachedAccount("13", "s", " s", "s",
                    keyValueMetaData, cachedAccountFeatures, "n", "h", new CachedGoal(),
                    new Date(), new Date(), new Date(), new Date(), new Date(), new Date(),
                    "13", "s", " s", "s",
                    "13", "s", " s", "s", new BigDecimal(1),
                    true, true, true, 1, 1,
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedCurrency(), new CachedCurrency(), new CachedCurrency(), new CachedCurrency(),
                    new CachedBranch(), new CachedCard(), new CachedCurrency(), new CachedCurrency(), new CachedAccountCurrency()));

            map.put(1, new CachedSystemPrincipal("s", "s", "s", cachedAccounts));
            System.out.println(map.get(1));
        }

        {
            ArrayList<CachedAccount> cachedAccounts = new ArrayList<CachedAccount>();
            map.put(1, new CachedSystemPrincipal("s", "s", "s", cachedAccounts));
            System.out.println(map.get(1));

        }


    }

}
