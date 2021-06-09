package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.*;

/**
 * May be omitted for seminar 3.
 */
public class DiscountCatalogTest {
    private DiscountCatalog discountCatalog;
    private CustomerCatalog customers;
    private Sale sale;
    private Receipt receipt;

    @Before
    public void setUp() {
        customers = new CustomerCatalog();
        discountCatalog = new DiscountCatalog();
        sale = new Sale();

        addItem("A1", 3);
        addItem("A2", 4);
        addItem("A3", 5);
        addItem("A4", 6);
        addItem("A5", 7);
    }

    @After
    public void tearDown() {
        discountCatalog = null;
        sale = null;
        customers = null;
    }

    @Test
    public void getDiscountByCustomerId() {
        String out = discountCatalog.getDiscountByCustomerId(customers.getCustomerById("Olle1337"));
        System.out.println(out);
        Assert.assertEquals("Olle, You have some available discounts: \n10 % discount on  Nutrilett BlueBerry:    -28,83 kr.\nBuy 4 Nutrilett Apple and pay for 3: -9,75 kr.\nBuy 5 Nutrilett Raspberry and pay for 3: -954,64 kr.\nBuy 6 Nutrilett Cocoa & Oat and pay for 4: -59,42 kr.\nBuy for 1000 kr and get 200 kr off.\n",out);
    }

    @Test
    public void applyDiscountByCustomerId() {
        discountCatalog.applyDiscountByCustomer(customers.getCustomerById("Olle1337"));
        for(ItemType item : sale.getItemList().getListOfItems()){
           Assert.assertEquals(item.getTotalPrice().getPricePreDiscount()-item.getTotalPrice().getPrice(),item.getTotalPrice().getDiscountAmount(), 0.0001);
        }
        Assert.assertEquals(200,sale.getItemList().getPrice().getDiscountAmount(),0.00001);
    }

    @Test
    public void name() {
        Assert.assertEquals(5, sale.getItemList().getListOfItems().size());
        Assert.assertEquals(96.096, sale.getItemById("A1").getPrice().getPrice(),0.0001);
        Assert.assertEquals(96.096 * 3, sale.getItemById("A1").getTotalPrice().getPrice(),0.0001);
        sale.getItemById("A1").getTotalPrice().setDiscountByPercentage(10);
        Assert.assertEquals(10, sale.getItemById("A1").getTotalPrice().getDiscountPercentage(), 0.0001);
        discountCatalog.applyDiscountByCustomer(customers.getCustomerById("Olle1337"));
        Assert.assertEquals(96.096 * 3 * 0.9, sale.getItemById("A1").getTotalPrice().getPrice(),0.0001);
    }

    private void addItem(String itemId, int quantity) { // Not a test
        try {
            sale.enterItem(itemId, quantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}