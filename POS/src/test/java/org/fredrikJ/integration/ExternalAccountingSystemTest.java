package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.*;

public class ExternalAccountingSystemTest {
    private ExternalAccountingSystem externalAccountingSystem;
    private Receipt receipt;
    private Payment payment;
    private ItemList items;

    @Before
    public void setUp() {
        externalAccountingSystem = new ExternalAccountingSystem();
        payment = new Payment(500.72, 700);

        items = ItemList.getInstance();
        items.addItemType(new ItemType("Kidu773", 88.55, 35, "Gröna oliver", 4));
        items.addItemType(new ItemType("Kid233333", 88.55, 33, "Röda oliver", 2));
        items.addItemByQuantity("Kidu773", 1);
        items.addItemByQuantity("Kid233333", 5);
    }

    @After
    public void tearDown() {
        externalAccountingSystem = null;
        payment = null;
        items = null;
    }

    @Test
    public void registerPayment() {
        receipt = new Receipt(items, new Payment(items.getPrice().getPrice(), 500));
        try{
            externalAccountingSystem.registerPayment(payment, receipt);
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }

    }
}