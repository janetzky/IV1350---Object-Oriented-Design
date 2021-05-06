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
     * Returns an price object
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns netto in sek.
     */
    public double getNetto() {
        return this.netto;
    }

    /**
     * Returns vat in Percentage.
     */
    public double getVatPercentage() {
        return this.vatPercentage;
    }

    /**
     * returns vat in sek.
     */
    public double getVat() {
        return this.vat;
    }

    /**
     * Alternative flow not omitted in seminar 3.
     */
    public void setDiscount(int discount) {
    }

    /**
     * Not used yet. Values passes through
     */
    private void calculateDiscount() {
        this.price = pricePreDiscount;
        this.vat = vatPreDiscount;
        this.netto = nettoPreDiscount;
    }

}
