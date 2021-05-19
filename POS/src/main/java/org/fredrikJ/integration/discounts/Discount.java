package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * Represent the interface Discount
 */
public interface Discount {
    /**
     * Applies the discount if available to price objects in ItemList.
     *
     * @param items represents items in the ItemList .
     */
    void applyDiscount(ItemList items);

    /**
     * Represents the the discount in text form.
     *
     * @param items contains itemTypes that will define witch if the discount is available.
     * @return a string representation of the particular discount.
     */
    String textRepresentation(ItemList items);
}
