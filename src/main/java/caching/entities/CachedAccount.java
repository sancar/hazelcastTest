package caching.entities;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import caching.AimsPortableFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CachedAccount extends CacheBase {

    private static final Integer DEFAULT_DATE_SAVE = 1;
    private String number = "";
    private String serialNumber = "";
    private String formattedAccountNumber = "";
    private String accountType = "";
    private List<CachedKeyValueMetaData> keyValueMetaData = new ArrayList();
    private List<CachedAccountFeature> accountFeatures = new ArrayList();
    private String name = "";
    private String holderName = "";
    private CachedGoal goal = new CachedGoal();
    private Date lastStatementDate = new Date();
    private Date maturityDate = new Date();
    private Date minimumPaymentDueDate = new Date();
    private Date nextInterestDueDate = new Date();
    private Date noticeDate = new Date();
    private Date openedDate = new Date();

    private String internationalBankAccountNumber = "";
    private String productName = "";
    private String accountStatus = "";
    private String accountUniqueId = "";
    private String handle = "";
    private String customName = "";
    private String disposalAccount = "";
    private String swiftCode = "";
    private BigDecimal interestRate = BigDecimal.ZERO;
    private boolean arrearStatus = false;
    private boolean errorIndicator = false;
    private boolean primary = false;
    private Integer noticeTerm = DEFAULT_DATE_SAVE;
    private Integer remainingTerm = DEFAULT_DATE_SAVE;
    private CachedCurrency availableBalance = new CachedCurrency();
    private CachedCurrency currentBalance = new CachedCurrency();
    private CachedCurrency minimumPaymentDue = new CachedCurrency();
    private CachedCurrency nextInterestDue = new CachedCurrency();
    private CachedCurrency overdraftBalance = new CachedCurrency();
    private CachedCurrency openingBalance = new CachedCurrency();
    private CachedCurrency noticeAmount = new CachedCurrency();
    private CachedCurrency totalInterestEarned = new CachedCurrency();
    private CachedCurrency totalInterestEarnedAtMaturity = new CachedCurrency();
    private CachedCurrency totalInterestOwed = new CachedCurrency();
    private CachedCurrency totalLoanAmount = new CachedCurrency();
    private CachedCurrency unclearedAmount = new CachedCurrency();
    private CachedBranch branch = new CachedBranch();
    private CachedCard card = new CachedCard();
    private CachedCurrency creditLimit = new CachedCurrency();
    private CachedCurrency overdraftAmount = new CachedCurrency();
    private CachedAccountCurrency accountCurrency = new CachedAccountCurrency();

    public CachedAccount() {
        //Required by Hazelcast
    }

    public CachedAccount(String number, String serialNumber, String formattedAccountNumber, String accountType, List<CachedKeyValueMetaData> keyValueMetaData, List<CachedAccountFeature> accountFeatures, String name, String holderName, CachedGoal goal, Date lastStatementDate, Date maturityDate, Date minimumPaymentDueDate, Date nextInterestDueDate, Date noticeDate, Date openedDate, String internationalBankAccountNumber, String productName, String accountStatus, String accountUniqueId, String handle, String customName, String disposalAccount, String swiftCode, BigDecimal interestRate, boolean arrearStatus, boolean errorIndicator, boolean primary, Integer noticeTerm, Integer remainingTerm, CachedCurrency availableBalance, CachedCurrency currentBalance, CachedCurrency minimumPaymentDue, CachedCurrency nextInterestDue, CachedCurrency overdraftBalance, CachedCurrency openingBalance, CachedCurrency noticeAmount, CachedCurrency totalInterestEarned, CachedCurrency totalInterestEarnedAtMaturity, CachedCurrency totalInterestOwed, CachedCurrency totalLoanAmount, CachedCurrency unclearedAmount, CachedBranch branch, CachedCard card, CachedCurrency creditLimit, CachedCurrency overdraftAmount, CachedAccountCurrency accountCurrency) {
        this.number = number;
        this.serialNumber = serialNumber;
        this.formattedAccountNumber = formattedAccountNumber;
        this.accountType = accountType;
        this.keyValueMetaData = keyValueMetaData;
        this.accountFeatures = accountFeatures;
        this.name = name;
        this.holderName = holderName;
        this.goal = goal;
        this.lastStatementDate = lastStatementDate;
        this.maturityDate = maturityDate;
        this.minimumPaymentDueDate = minimumPaymentDueDate;
        this.nextInterestDueDate = nextInterestDueDate;
        this.noticeDate = noticeDate;
        this.openedDate = openedDate;
        this.internationalBankAccountNumber = internationalBankAccountNumber;
        this.productName = productName;
        this.accountStatus = accountStatus;
        this.accountUniqueId = accountUniqueId;
        this.handle = handle;
        this.customName = customName;
        this.disposalAccount = disposalAccount;
        this.swiftCode = swiftCode;
        this.interestRate = interestRate;
        this.arrearStatus = arrearStatus;
        this.errorIndicator = errorIndicator;
        this.primary = primary;
        this.noticeTerm = noticeTerm;
        this.remainingTerm = remainingTerm;
        this.availableBalance = availableBalance;
        this.currentBalance = currentBalance;
        this.minimumPaymentDue = minimumPaymentDue;
        this.nextInterestDue = nextInterestDue;
        this.overdraftBalance = overdraftBalance;
        this.openingBalance = openingBalance;
        this.noticeAmount = noticeAmount;
        this.totalInterestEarned = totalInterestEarned;
        this.totalInterestEarnedAtMaturity = totalInterestEarnedAtMaturity;
        this.totalInterestOwed = totalInterestOwed;
        this.totalLoanAmount = totalLoanAmount;
        this.unclearedAmount = unclearedAmount;
        this.branch = branch;
        this.card = card;
        this.creditLimit = creditLimit;
        this.overdraftAmount = overdraftAmount;
        this.accountCurrency = accountCurrency;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_ACCOUNT_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_NUMBER, number);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_SERIAL_NUMBER, serialNumber);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_FORMATTED_ACCOUNT_NUMBER, formattedAccountNumber);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_NAME, name);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_HOLDER_NAME, holderName);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_ACCOUNT_TYPE, accountType);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_INTERNATIONAL_BANK_ACCOUNT_NUMBER, internationalBankAccountNumber);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_PRODUCT_NAME, productName);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_ACCOUNT_STATUS, accountStatus);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_ACCOUNT_UNIQUE_ID, accountUniqueId);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_CUSTOM_NAME, customName);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_DISPOSAL_ACCOUNT, disposalAccount);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_INTEREST_RATE, interestRate.toString());
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_HANDLE, handle);
        portableWriter.writeUTF(CachedAccountFieldNames.FIELD_SWIFT_CODE, swiftCode);
        portableWriter.writeBoolean(CachedAccountFieldNames.FIELD_ARREAR_STATUS, arrearStatus);
        portableWriter.writeBoolean(CachedAccountFieldNames.FIELD_ERROR_INDICATOR, errorIndicator);
        portableWriter.writeBoolean(CachedAccountFieldNames.FIELD_PRIMARY, primary);

        portableWriter.writeInt(CachedAccountFieldNames.FIELD_KEY_VALUE_META_DATA_SIZE, keyValueMetaData.size());
        portableWriter.writePortableArray(CachedAccountFieldNames.FIELD_KEY_VALUE_META_DATA, CachedKeyValueMetaData.getPortableArray(keyValueMetaData));
        portableWriter.writeInt(CachedAccountFieldNames.FIELD_ACCOUNT_FEATURE_SIZE, accountFeatures.size());
        portableWriter.writePortableArray(CachedAccountFieldNames.FIELD_ACCOUNT_FEATURES, CachedAccountFeature.getPortableArray(accountFeatures));

        portableWriter.writeLong(CachedAccountFieldNames.FIELD_OPENED_DATE, convertToLong(openedDate));
        portableWriter.writeLong(CachedAccountFieldNames.FIELD_NOTICE_DATE, convertToLong(noticeDate));
        portableWriter.writeLong(CachedAccountFieldNames.FIELD_NEXT_INTEREST_DUE_DATE, convertToLong(nextInterestDueDate));
        portableWriter.writeLong(CachedAccountFieldNames.FIELD_MINIMUM_PAYMENT_DUE_DATE, convertToLong(minimumPaymentDueDate));
        portableWriter.writeLong(CachedAccountFieldNames.FIELD_MATURITY_DATE, convertToLong(maturityDate));
        portableWriter.writeLong(CachedAccountFieldNames.FIELD_LAST_STATEMENT_DATE, convertToLong(lastStatementDate));
        portableWriter.writeInt(CachedAccountFieldNames.FIELD_REMAINING_TERM, remainingTerm);
        portableWriter.writeInt(CachedAccountFieldNames.FIELD_NOTICE_TERM, noticeTerm);

        portableWriter.writePortable(CachedAccountFieldNames.FIELD_BRANCH, branch);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_CARD, card);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_CREDIT_LIMIT, creditLimit);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_OVERDRAFT_AMOUNT, overdraftAmount);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_ACCOUNT_CURRENCY, accountCurrency);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_GOAL, goal);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_UNCLEARED_AMOUNT, unclearedAmount);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_TOTAL_LOAN_AMOUNT, totalLoanAmount);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_OWED, totalInterestOwed);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_EARNED_AT_MATURITY, totalInterestEarnedAtMaturity);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_EARNED, totalInterestEarned);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_NOTICE_AMOUNT, noticeAmount);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_OVERDRAFT_BALANCE, overdraftBalance);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_NEXT_INTEREST_DUE, nextInterestDue);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_MINIMUM_PAYMENT_DUE, minimumPaymentDue);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_CURRENT_BALANCE, currentBalance);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_AVAILABLE_BALANCE, availableBalance);
        portableWriter.writePortable(CachedAccountFieldNames.FIELD_OPENING_BALANCE, openingBalance);
    }

    public static long convertToLong(Date openedDate) {
        return openedDate.getTime();
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        number = portableReader.readUTF(CachedAccountFieldNames.FIELD_NUMBER);
        serialNumber = portableReader.readUTF(CachedAccountFieldNames.FIELD_SERIAL_NUMBER);
        formattedAccountNumber = portableReader.readUTF(CachedAccountFieldNames.FIELD_FORMATTED_ACCOUNT_NUMBER);
        name = portableReader.readUTF(CachedAccountFieldNames.FIELD_NAME);
        holderName = portableReader.readUTF(CachedAccountFieldNames.FIELD_HOLDER_NAME);
        accountType = portableReader.readUTF(CachedAccountFieldNames.FIELD_ACCOUNT_TYPE);
        internationalBankAccountNumber = portableReader.readUTF(CachedAccountFieldNames.FIELD_INTERNATIONAL_BANK_ACCOUNT_NUMBER);
        productName = portableReader.readUTF(CachedAccountFieldNames.FIELD_PRODUCT_NAME);
        accountStatus = portableReader.readUTF(CachedAccountFieldNames.FIELD_ACCOUNT_STATUS);
        accountUniqueId = portableReader.readUTF(CachedAccountFieldNames.FIELD_ACCOUNT_UNIQUE_ID);
        handle = portableReader.readUTF(CachedAccountFieldNames.FIELD_HANDLE);
        swiftCode = portableReader.readUTF(CachedAccountFieldNames.FIELD_SWIFT_CODE);
        customName = portableReader.readUTF(CachedAccountFieldNames.FIELD_CUSTOM_NAME);
        disposalAccount = portableReader.readUTF(CachedAccountFieldNames.FIELD_DISPOSAL_ACCOUNT);
        interestRate = new BigDecimal(portableReader.readUTF(CachedAccountFieldNames.FIELD_INTEREST_RATE));
        arrearStatus = portableReader.readBoolean(CachedAccountFieldNames.FIELD_ARREAR_STATUS);
        errorIndicator = portableReader.readBoolean(CachedAccountFieldNames.FIELD_ERROR_INDICATOR);
        primary = portableReader.readBoolean(CachedAccountFieldNames.FIELD_PRIMARY);

        int keyValueMetaDataSize = portableReader.readInt(CachedAccountFieldNames.FIELD_KEY_VALUE_META_DATA_SIZE);
        Portable[] keyValueMetaDataList = portableReader.readPortableArray(CachedAccountFieldNames.FIELD_KEY_VALUE_META_DATA);
        keyValueMetaData = CachedKeyValueMetaData.getList(keyValueMetaDataList, keyValueMetaDataSize);
        int accountFeatureSize = portableReader.readInt(CachedAccountFieldNames.FIELD_ACCOUNT_FEATURE_SIZE);
        Portable[] accountFeaturesList = portableReader.readPortableArray(CachedAccountFieldNames.FIELD_ACCOUNT_FEATURES);
        accountFeatures = CachedAccountFeature.getList(accountFeaturesList, accountFeatureSize);

        openedDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_OPENED_DATE));
        noticeDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_NOTICE_DATE));
        nextInterestDueDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_NEXT_INTEREST_DUE_DATE));
        minimumPaymentDueDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_MINIMUM_PAYMENT_DUE_DATE));
        maturityDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_MATURITY_DATE));
        lastStatementDate = convertToDate(portableReader.readLong(CachedAccountFieldNames.FIELD_LAST_STATEMENT_DATE));

        int tmpRemainingTerm = portableReader.readInt(CachedAccountFieldNames.FIELD_REMAINING_TERM);
        if (tmpRemainingTerm != DEFAULT_DATE_SAVE) {
            remainingTerm = tmpRemainingTerm;
        }

        int tmpNoticeTerm = portableReader.readInt(CachedAccountFieldNames.FIELD_NOTICE_TERM);
        if (tmpNoticeTerm != DEFAULT_DATE_SAVE) {
            noticeTerm = tmpNoticeTerm;
        }

        branch = portableReader.readPortable(CachedAccountFieldNames.FIELD_BRANCH);
        card = portableReader.readPortable(CachedAccountFieldNames.FIELD_CARD);
        creditLimit = portableReader.readPortable(CachedAccountFieldNames.FIELD_CREDIT_LIMIT);
        overdraftAmount = portableReader.readPortable(CachedAccountFieldNames.FIELD_OVERDRAFT_AMOUNT);
        accountCurrency = portableReader.readPortable(CachedAccountFieldNames.FIELD_ACCOUNT_CURRENCY);
        goal = portableReader.readPortable(CachedAccountFieldNames.FIELD_GOAL);
        unclearedAmount = portableReader.readPortable(CachedAccountFieldNames.FIELD_UNCLEARED_AMOUNT);
        totalLoanAmount = portableReader.readPortable(CachedAccountFieldNames.FIELD_TOTAL_LOAN_AMOUNT);
        totalInterestOwed = portableReader.readPortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_OWED);
        totalInterestEarnedAtMaturity = portableReader.readPortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_EARNED_AT_MATURITY);
        totalInterestEarned = portableReader.readPortable(CachedAccountFieldNames.FIELD_TOTAL_INTEREST_EARNED);
        noticeAmount = portableReader.readPortable(CachedAccountFieldNames.FIELD_NOTICE_AMOUNT);
        overdraftBalance = portableReader.readPortable(CachedAccountFieldNames.FIELD_OVERDRAFT_BALANCE);
        nextInterestDue = portableReader.readPortable(CachedAccountFieldNames.FIELD_NEXT_INTEREST_DUE);
        minimumPaymentDue = portableReader.readPortable(CachedAccountFieldNames.FIELD_MINIMUM_PAYMENT_DUE);
        currentBalance = portableReader.readPortable(CachedAccountFieldNames.FIELD_CURRENT_BALANCE);
        availableBalance = portableReader.readPortable(CachedAccountFieldNames.FIELD_AVAILABLE_BALANCE);
        openingBalance = defaultIfNull(portableReader.readPortable(CachedAccountFieldNames.FIELD_OPENING_BALANCE), new CachedCurrency());
    }

    private CachedCurrency defaultIfNull(Portable portable, CachedCurrency cachedCurrency) {
        if (portable == null) {
            return cachedCurrency;
        }
        return (CachedCurrency) portable;
    }

    public static Date convertToDate(long l) {
        return new Date(l);
    }

    public static String updateNonNull(String newHandle, String handle) {
        if (newHandle != null) {
            return newHandle;
        }
        return handle;
    }

}
