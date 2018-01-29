package caching.entities;

import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import caching.AimsPortableFactory;

import java.io.IOException;

public class CachedCard extends CacheBase {
    private static final String FIELD_NUMBER = "number";
    private static final String FIELD_TYPE = "type";
    private static final String FIELD_COUNTRY_CODE = "countryCode";
    private static final String FIELD_DESCRIPTION = "description";
    private static final String FIELD_HELP_NUMBER = "helpNumber";
    private static final String FIELD_CARD_IMAGE_URL = "cardImageUrl";
    private static final String FIELD_ACTIVE = "active";
    private static final String FIELD_INTERNATIONAL_TRAVEL_ENABLED = "internationalTravelEnabled";
    private static final String FIELD_LIMIT_MANAGEMENT_ENABLED = "limitManagementEnabled";
    private static final String FIELD_STOP_CARD_ENABLED = "stopCardEnabled";
    private static final String FIELD_VIEW_PIN_ENABLED = "viewPinEnabled";
    private String number = "";
    private String type = "";
    private String cardImageUrl = "";
    private String countryCode = "";
    private String description = "";
    private String helpNumber = "";
    private boolean active = false;
    private boolean internationalTravelEnabled = false;
    private boolean limitManagementEnabled = false;
    private boolean stopCardEnabled = false;
    private boolean viewPinEnabled = false;

    public CachedCard() {
        //Required by Hazelcast
    }

    public CachedCard(String number, String type, String cardImageUrl, String countryCode, String description, String helpNumber, boolean active, boolean internationalTravelEnabled, boolean limitManagementEnabled, boolean stopCardEnabled, boolean viewPinEnabled) {
        this.number = number;
        this.type = type;
        this.cardImageUrl = cardImageUrl;
        this.countryCode = countryCode;
        this.description = description;
        this.helpNumber = helpNumber;
        this.active = active;
        this.internationalTravelEnabled = internationalTravelEnabled;
        this.limitManagementEnabled = limitManagementEnabled;
        this.stopCardEnabled = stopCardEnabled;
        this.viewPinEnabled = viewPinEnabled;
    }

    @Override
    public int getFactoryId() {
        return AimsPortableFactory.PORTABLE_FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return AimsPortableFactory.CACHED_CARD_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter portableWriter) throws IOException {
        portableWriter.writeUTF(FIELD_NUMBER, number);
        portableWriter.writeUTF(FIELD_TYPE, type);
        portableWriter.writeUTF(FIELD_CARD_IMAGE_URL, cardImageUrl);
        portableWriter.writeUTF(FIELD_COUNTRY_CODE, countryCode);
        portableWriter.writeUTF(FIELD_DESCRIPTION, description);
        portableWriter.writeUTF(FIELD_HELP_NUMBER, helpNumber);
        portableWriter.writeBoolean(FIELD_ACTIVE, active);
        portableWriter.writeBoolean(FIELD_INTERNATIONAL_TRAVEL_ENABLED, internationalTravelEnabled);
        portableWriter.writeBoolean(FIELD_LIMIT_MANAGEMENT_ENABLED, limitManagementEnabled);
        portableWriter.writeBoolean(FIELD_STOP_CARD_ENABLED, stopCardEnabled);
        portableWriter.writeBoolean(FIELD_VIEW_PIN_ENABLED, viewPinEnabled);
    }

    @Override
    public void readPortable(PortableReader portableReader) throws IOException {
        number = portableReader.readUTF(FIELD_NUMBER);
        type = portableReader.readUTF(FIELD_TYPE);
        cardImageUrl = portableReader.readUTF(FIELD_CARD_IMAGE_URL);
        countryCode = portableReader.readUTF(FIELD_COUNTRY_CODE);
        description = portableReader.readUTF(FIELD_DESCRIPTION);
        helpNumber = portableReader.readUTF(FIELD_HELP_NUMBER);
        active = portableReader.readBoolean(FIELD_ACTIVE);
        internationalTravelEnabled = portableReader.readBoolean(FIELD_INTERNATIONAL_TRAVEL_ENABLED);
        limitManagementEnabled = portableReader.readBoolean(FIELD_LIMIT_MANAGEMENT_ENABLED);
        stopCardEnabled = portableReader.readBoolean(FIELD_STOP_CARD_ENABLED);
        viewPinEnabled = portableReader.readBoolean(FIELD_VIEW_PIN_ENABLED);
    }

}
