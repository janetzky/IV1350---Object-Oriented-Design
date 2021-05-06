package org.fredrikJ.integration;

/**
 * Represents the database containing customers and their discounts.
 */
public class DiscountCatalog {
    /**
     * Constructs a new DiscountCatalog
     */
    public DiscountCatalog() {
    }

    /**
     * Omitted in seminar 3.
     * Handle discount requests
     *
     * @param customerId a string representing a customer.
     * @return Returns discount amount to specified customer.
     */
    public double getDiscountByCustomerId(String customerId) {
        return 0;
    }

    /**
     * Omitted in seminar 3.
     * Validates discount request
     *
     * @param customerId a string representing a customer.
     * @return true or false considering if the customer is eligible for discount.
     */
    public boolean checkDiscountByCustomerId(String customerId) {
        return false;
    }

}
