package org.fredrikJ.model;

/**
 * Represents storeInformation such as storename, adress...
 */
public class StoreInfo {
    private String storeName = "KöttMarknaden";
    private String adress = "Golvmopsgatan 18";
    private String telephone = "073 818 5733";
    private String organisationNumber = "982774612541";

    /**
     * Creates a new instance, representing storeInfo
     */
    public StoreInfo() {
    }

    /**
     * Returns store name
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * Returns store adress.
     */
    public String getAdressName() {
        return this.adress;
    }

    /**
     * Returns telephone number.
     */
    public String getTelephoneNumber() {
        return this.telephone;
    }

    /**
     * Returns Organisation number.
     */
    public String getOrganisationNumber() {
        return this.organisationNumber;
    }
}
