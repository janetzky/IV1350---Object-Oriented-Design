package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * A discount implementation.
 */
public class QuantityDiscount implements Discount {

    String itemId;
    int amountOfItems;
    int amountDiscounted;

    /**
     * Constructs quantityDiscount.
     *
     * @param itemId           a string representing an item.
     * @param amountOfItems is the number of items required to get available discount.
     * @param amountDiscounted is the number of items that will be discounted.
     */
    public QuantityDiscount(String itemId, int amountOfItems, int amountDiscounted) {
        this.itemId = itemId;
        this.amountOfItems = amountOfItems;
        this.amountDiscounted = amountDiscounted;
    }

    /**
     * Applies the discount if available to price objects in ItemList.
     *
     * @param items represents items in the ItemList .
     */
    @Override
    public void applyDiscount(ItemList items) {
        if (isDiscountValid(items))
            items.getItemTypeById(this.itemId).getTotalPrice().setDiscountByPercentage(getPercentage(items));
    }

    /**
     * Represents the the discount in text form.
     *
     * @param items contains itemTypes that will define witch if the discount is available.
     * @return a string representation of the particular discount.
     */
    @Override
    public String textRepresentation(ItemList items) {
        int amountOfItemsToPayFor = amountOfItems - amountDiscounted;
        String s = null;
        if (isDiscountValid(items))
            s = String.format("Buy %d %s and pay for %d: -%.2f kr.", amountOfItems, items.getItemTypeById(itemId).getDescription(), amountOfItemsToPayFor, getDiscountAmount(items));
        return s;
    }

    private double getDiscountAmount(ItemList items) {
        return items.getItemTypeById(itemId).getTotalPrice().getPrice() * (getPercentage(items) / 100);
    }

    private double getPercentage(ItemList items) {
        return ((items.getItemTypeById(itemId).getPrice().getPrice() * amountDiscounted) / items.getItemTypeById(itemId).getTotalPrice().getPrice()) * 100;
    }

    private boolean isDiscountValid(ItemList items) {
        return items.isItemTypeInList(itemId) && items.getItemTypeById(itemId).getQuantity() >= amountOfItems;
    }
}
