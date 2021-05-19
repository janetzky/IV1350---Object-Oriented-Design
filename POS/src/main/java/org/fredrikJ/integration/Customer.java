package org.fredrikJ.integration;


import org.fredrikJ.integration.discounts.Discount;
import org.fredrikJ.integration.discounts.ItemDiscount;
import org.fredrikJ.integration.discounts.QuantityDiscount;
import org.fredrikJ.integration.discounts.TotalSumDiscount;
import org.fredrikJ.model.ItemList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a customer.
 */
public class Customer {

    private final String customerId;
    private final String name;
    List<Discount> discountList = new ArrayList();
    private Date birthDate;
    private Date memberSince;

    /**
     * Constructs a customer.
     *
     * @param customerId The customers specific Id.
     * @param name       Name of the customer.
     * @param birthDate  Birthdate of the customer.
     */
    public Customer(String customerId, String name, Date birthDate) {
        this.customerId = customerId;
        this.name = name;
        this.birthDate = birthDate;
        this.memberSince = new Date();
        addHardCodedDiscounts();
    }

    /**
     * Returns the customer id.
     *
     * @return the customerId.
     */
    public String getCustomerId() {
        return this.customerId;
    }

    /**
     * Returns the customers name.
     *
     * @return the customers name.
     */
    public String getCustomerName() {
        return this.name;
    }

    /**
     * Adds a specific discount to the customers discount list.
     *
     * @param discount A specific discount which can be added.
     */
    public void addDiscount(Discount discount) {
        this.discountList.add(discount);
    }

    /**
     * Returns a string representing the specific discounts that are available.
     *
     * @param items Items inside the ItemList.
     * @return returns a string of discounts.
     */
    public String getDiscountsTextRepresentation(ItemList items) {
        StringBuilder discounts = new StringBuilder();
        discounts.append(this.name + ", You have some available discounts: \n");
        for (Discount discount : discountList) {
            String s = discount.textRepresentation(items);
            if (s != null)
                discounts.append(discount.textRepresentation(items)).append("\n");
        }
        if (discounts.length() - this.name.length() < 40)
            return "Sorry " + this.name + ", There are no discounts available.";
        return discounts.toString();
    }

    /**
     * Applies available discounts to price objects in ItemList.
     *
     * @param items representing the items in the ItemList.
     */
    public void applyDiscount(ItemList items) {
        for (Discount discount : discountList) {
            discount.applyDiscount(items);
        }
    }

    /**
     * Represents the hardcoded discounts.
     */
    public void addHardCodedDiscounts() {
        addDiscount(new ItemDiscount("Sås", 10));   //Invalid id
        addDiscount(new ItemDiscount("A1", 10));
        addDiscount(new QuantityDiscount("A2", 4, 1));
        addDiscount(new QuantityDiscount("A3", 5, 2));
        addDiscount(new QuantityDiscount("A4", 6, 2));
        addDiscount(new TotalSumDiscount(1000, 200));
    }
}
