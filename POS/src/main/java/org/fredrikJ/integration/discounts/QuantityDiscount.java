package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * A discount implementation.
 */
public class QuantityDiscount implements Discount {
    ItemList items = ItemList.getInstance();
    String itemId;
    int amountOfItems;
    int amountDiscounted;

    /**
     * Constructs quantityDiscount.
     *
     * @param itemId           a string representing an item.
     * @param amountOfItems    is the number of items required to get available discount.
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
     */
    @Override
    public void applyDiscount() {
        if (isDiscountValid())
            items.getItemTypeById(this.itemId).getTotalPrice().setDiscountByPercentage(getPercentage());
    }

    /**
     * Represents the the discount in text form.
     *
     * @return a string representation of the particular discount.
     */
    @Override
    public String textRepresentation() {
        int amountOfItemsToPayFor = amountOfItems - amountDiscounted;
        String s = null;
        if (isDiscountValid())
            s = String.format("Buy %d %s and pay for %d: -%.2f kr.", amountOfItems, items.getItemTypeById(itemId).getDescription(), amountOfItemsToPayFor, getDiscountAmount());
        return s;
    }

    private double getDiscountAmount() {
        return items.getItemTypeById(itemId).getTotalPrice().getPrice() * (getPercentage() / 100);
    }

    private double getPercentage() {
        return ((items.getItemTypeById(itemId).getPrice().getPrice() * amountDiscounted) / items.getItemTypeById(itemId).getTotalPrice().getPrice()) * 100;
    }

    private boolean isDiscountValid() {
        return items.isItemTypeInList(itemId) && items.getItemTypeById(itemId).getQuantity() >= amountOfItems;
    }
}
