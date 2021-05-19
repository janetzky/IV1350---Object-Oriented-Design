package org.fredrikJ.integration;

import org.fredrikJ.model.ItemList;

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
     * @param items    items inside the itemlist.
     * @return Returns the discount as a string.
     */
    public String getDiscountByCustomerId(Customer customer, ItemList items) {
        return customer.getDiscountsTextRepresentation(items);
    }

    /**
     * Applies discount on the sale based on customer id.
     *
     * @param items    items inside the itemlist.
     * @param customer representing the customer.
     */
    public void applyDiscountByCustomerId(Customer customer, ItemList items) {
        customer.applyDiscount(items);
    }

}
