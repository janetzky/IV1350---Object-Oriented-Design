package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.*;

public class ExternalAccountingSystemTest {
    private ExternalAccountingSystem externalAccountingSystem;
    private Receipt receipt;
    private Payment payment;
    private ItemList items;

    @Before
    public void setUp() throws Exception {
        externalAccountingSystem = new ExternalAccountingSystem();
        payment = new Payment(500.72, 700);

        items = new ItemList();
        items.addItemType(new ItemType("Kidu773", 88.55, 35, "Gröna oliver", 4));
        items.addItemType(new ItemType("Kid233333", 88.55, 33, "Röda oliver", 2));
        items.addItemByQuantity("Kidu773", 1);
        items.addItemByQuantity("Kid233333", 5);

    }

    @After
    public void tearDown() throws Exception {
        externalAccountingSystem = null;
        payment = null;
        items = null;
    }

    @Test
    public void registerPayment() {
        receipt = new Receipt(items, new Payment(items.getPrice().getPrice(), 500));
        externalAccountingSystem.registerPayment(payment, receipt);
    }
}