package caching;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import caching.entities.*;

public class AimsPortableFactory implements PortableFactory {
    public static final int PORTABLE_FACTORY_ID = 1;
    public static final int CACHED_SYSTEM_PRINCIPAL_CLASS_ID = 1;
    public static final int CACHED_ACCOUNT_CLASS_ID = 2;
    public static final int CACHED_BRANCH_CLASS_ID = 3;
    public static final int CACHED_CARD_CLASS_ID = 4;
    public static final int CACHED_CURRENCY_CLASS_ID = 5;
    public static final int CACHED_KEY_VALUE_METADATA_CLASS_ID = 6;
    public static final int CACHED_ACCOUNT_CURRENCY_CLASS_ID = 7;
    public static final int CACHED_ACCOUNT_FEATURE_CLASS_ID = 8;
    public static final int CACHED_GOAL_CLASS_ID = 9;

    @Override
    public Portable create(int classId) {
        switch (classId) {
            case CACHED_ACCOUNT_CLASS_ID:
                return new CachedAccount();
            case CACHED_SYSTEM_PRINCIPAL_CLASS_ID:
                return new CachedSystemPrincipal();
            case CACHED_BRANCH_CLASS_ID:
                return new CachedBranch();
            case CACHED_CARD_CLASS_ID:
                return new CachedCard();
            case CACHED_CURRENCY_CLASS_ID:
                return new CachedCurrency();
            case CACHED_KEY_VALUE_METADATA_CLASS_ID:
                return new CachedKeyValueMetaData();
            case CACHED_ACCOUNT_CURRENCY_CLASS_ID:
                return new CachedAccountCurrency();
            case CACHED_ACCOUNT_FEATURE_CLASS_ID:
                return new CachedAccountFeature();
            case CACHED_GOAL_CLASS_ID:
                return new CachedGoal();
            default:
                throw new IllegalArgumentException(classId + " unsupported classId");
        }
    }
}
