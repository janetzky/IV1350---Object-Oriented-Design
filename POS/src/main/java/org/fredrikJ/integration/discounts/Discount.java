package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * Represent the interface Discount
 */
public interface Discount {
    ItemList items = ItemList.getInstance();

    /**
     * Applies the discount if available to price objects in ItemList.
     *
     */
    void applyDiscount();

    /**
     * Represents the the discount in text form.
     *
     * @return a string representation of the particular discount.
     */
    String textRepresentation();
}
