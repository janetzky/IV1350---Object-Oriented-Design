package org.fredrikJ.integration.discounts;

import org.fredrikJ.model.ItemList;

/**
 * Represent the interface Discount
 */
public class TotalSumDiscount implements Discount {
    ItemList items = ItemList.getInstance();
    double sumToReach;
    double discountAmount;

    /**
     * Constructs totalSumDiscount.
     *
     * @param sumToReach     The required amount needed to take part of the discount.
     * @param discountAmount is the amount of SEK to be discounted.
     */
    public TotalSumDiscount(double sumToReach, double discountAmount) {
        this.sumToReach = sumToReach;
        this.discountAmount = discountAmount;
    }

    /**
     * Applies the discount if available to price objects in ItemList.
     *
     */
    @Override
    public void applyDiscount() {
        if (isDiscountValid())
            items.setDiscount(getVatPercentage());
    }

    /**
     * Represents the the discount in text form.
     *
     * @return a string representation of the particular discount.
     */
    @Override
    public String textRepresentation() {
        String s = null;
        if (isDiscountValid()) {
            s = String.format("Buy for %.0f kr and get %.0f kr off.", sumToReach, discountAmount);
        }
        return s;
    }

    private boolean isDiscountValid() {
        return items.getPrice().getPricePreDiscount() > sumToReach;
    }

    private double getVatPercentage() {
        return (discountAmount / items.getPrice().getPricePreDiscount()) * 100;
    }
}
