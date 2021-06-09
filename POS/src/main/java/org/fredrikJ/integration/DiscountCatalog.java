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
     * Handle discount requests
     *
     * @param customer representing the customer.
     * @return Returns the discount as a string.
     */
    public String getDiscountByCustomerId(Customer customer) {
        return customer.getDiscountsTextRepresentation();
    }

    /**
     * Applies discount on the sale based on customer id.
     *
     * @param customer representing the customer.
     */
    public void applyDiscountByCustomer(Customer customer) {
        customer.applyDiscount();
    }

}
