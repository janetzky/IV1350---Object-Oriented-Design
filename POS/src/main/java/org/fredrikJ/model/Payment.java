package org.fredrikJ.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a payment done in the flow.
 */
public class Payment {

    private Date date;

    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm  z");
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

    private double amountToPay;
    private double amountPaid;
    private double change;

    /**
     * Constructor
     *
     * @param amountToPay sek
     * @param amountPaid  sek
     */
    public Payment(double amountToPay, double amountPaid) {
        this.amountToPay = amountToPay;
        this.amountPaid = amountPaid;
        this.date = new Date();
        calculateChange();
    }

    /**
     * Returns the amount the customer should pay for the sale.
     */
    public double getAmountToPay() {
        return this.amountToPay;
    }

    /**
     * Returns the amount paid in sek.
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    /**
     * Using private method calculateChange to get the right numbers back.
     * Returns change in sek.
     */
    public double getChange() {
        calculateChange();
        return this.change;
    }

    /**
     * Returns time - String in format HH:mm.
     */
    public String getTime() {
        return timeFormat.format(date);
    }

    /**
     * Returns date - String Year-Month-Date ex. 2021-Apr-30
     */
    public String getDate() {
        return dateFormat.format(date);
    }

    /**
     * Calculates the change and updates the variable this.change
     */
    private void calculateChange() {
        this.change = this.amountPaid - this.amountToPay;
    }

}
