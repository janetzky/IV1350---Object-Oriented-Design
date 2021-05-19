package org.fredrikJ.model;

/**
 * Represents a price including Vat and discount
 */
public class Price {

    private double price = 0;
    private double vat = 0;
    private double netto = 0;

    private double vatPercentage;

    //Discount
    private double pricePreDiscount = 0;
    private double vatPreDiscount = 0;
    private double nettoPreDiscount = 0;

    private double discountPercentage = 0;

    /**
     * Constructor of Price
     */
    public Price() {
    }

    /**
     * Copies an existing price object
     *
     * @param priceToCopy an object of Price
     */
    public Price(Price priceToCopy) {
        setNettoAndVatPercentage(priceToCopy.getNetto(), priceToCopy.getVatPercentage());
    }

    /**
     * Constructs a new price object. Using (sek) netto and (%) vat.
     *
     * @param netto         netto shown in sek.
     * @param vatPercentage Vat percentage shown in % not in sek.
     */
    public Price(double netto, double vatPercentage) {
        setNettoAndVatPercentage(netto, vatPercentage);
    }

    /**
     * Edit price of the object. Using (sek) netto and (%) vat.
     *
     * @param netto         netto shown in sek.
     * @param vatPercentage Vat percentage shown in % not in sek.
     */
    public void setNettoAndVatPercentage(double netto, double vatPercentage) {
        this.vatPercentage = vatPercentage;
        this.nettoPreDiscount = netto;
        this.vatPreDiscount = netto * (vatPercentage / 100);
        this.pricePreDiscount = vatPreDiscount + nettoPreDiscount;
        calculateDiscount();
    }

    /**
     * Edits price of the object. Using (sek) Price and (sek) Vat
     *
     * @param price price in sek.
     * @param vat   Vat shown in sek.
     */
    public void setPriceAndVat(double price, double vat) {
        this.vatPercentage = (vat / price) * 100;
        this.nettoPreDiscount = price - vat;
        this.vatPreDiscount = vat;
        this.pricePreDiscount = price;
        calculateDiscount();
    }

    /**
     * Sets the discount by percentage.
     */
    public void setDiscountByPercentage(double discount) {
        this.discountPercentage = discount;
        calculateDiscount();
    }

    /**
     * Get methods
     */
    public double getDiscountPercentage() {
        return this.discountPercentage;
    }

    public double getPrice() {
        return this.price;
    }

    public double getPricePreDiscount() {
        return this.pricePreDiscount;
    }

    public double getDiscountAmount() {
        return this.pricePreDiscount - this.price;
    }

    public double getNetto() {
        return this.netto;
    }

    public double getVatPercentage() {
        return this.vatPercentage;
    }

    public double getVat() {
        return this.vat;
    }


    /**
     * Calculates the discount based on discount percentage and price pre discount.
     */
    private void calculateDiscount() {
        this.price = pricePreDiscount * (100 - discountPercentage) / 100;
        this.vat = vatPreDiscount * (100 - discountPercentage) / 100;
        this.netto = nettoPreDiscount * (100 - discountPercentage) / 100;
    }
}
