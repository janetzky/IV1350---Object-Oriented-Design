package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.fredrikJ.integration.Printer;

public class ReceiptTest {
    private ItemList items;
    private Receipt receipt;
    private Printer printer;

    @Before
    public void setUp() {
        printer = new Printer();
        items = ItemList.getInstance();
        items.addItemType(new ItemType("Kidu773", 80, 25, "Gröna oliver", 4));
        items.addItemType(new ItemType("Kid233333", 80, 6, "Röda oliver", 2));
        items.addItemByQuantity("Kidu773", 1);
        items.addItemByQuantity("Kid233333", 5);
    }

    @After
    public void tearDown() {
        items = null;
    }

    @Test
    public void getReceiptStrings() {
        try {
            receipt = new Receipt(items, new Payment(items.getPrice().getPrice(), 1200));
            printer.printReceipt(receipt);
        }catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}