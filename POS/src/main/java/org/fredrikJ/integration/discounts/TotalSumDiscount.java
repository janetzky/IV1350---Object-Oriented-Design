package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * Represent the interface Discount
 */
public class TotalSumDiscount implements Discount {
    double sumToReach;
    double discountAmount;

    /**
     * Constructs totalSumDiscount.
     *
     * @param sumToReach    The required amount needed to take part of the discount.
     * @param discountAmount is the amount of SEK to be discounted.
     */
    public TotalSumDiscount(double sumToReach, double discountAmount) {
        this.sumToReach = sumToReach;
        this.discountAmount = discountAmount;
    }

    /**
     * Applies the discount if available to price objects in ItemList.
     *
     * @param items represents items in the ItemList .
     */
    @Override
    public void applyDiscount(ItemList items) {
        if (isDiscountValid(items))
            items.setDiscount(getVatPercentage(items));
    }

    /**
     * Represents the the discount in text form.
     *
     * @param items contains itemTypes that will define witch if the discount is available.
     * @return a string representation of the particular discount.
     */
    @Override
    public String textRepresentation(ItemList items) {
        String s = null;
        if (isDiscountValid(items)) {
            s = String.format("Buy for %.0f kr and get %.0f kr off.", sumToReach, discountAmount);
        }
        return s;
    }

    private boolean isDiscountValid(ItemList items) {
        return items.getPrice().getPricePreDiscount() > sumToReach;
    }

    private double getVatPercentage(ItemList items) {
        return (discountAmount / items.getPrice().getPricePreDiscount()) * 100;
    }
}
