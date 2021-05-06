package org.fredrikJ.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.fredrikJ.integration.Printer;

public class ReceiptTest {
    private ItemList items;
    private Receipt receipt;
    private Printer printer;

    @Before
    public void setUp() throws Exception {
        printer = new Printer();
        items = new ItemList();
        items.addItemType(new ItemType("Kidu773", 80, 25, "Gröna oliver", 4));
        items.addItemType(new ItemType("Kid233333", 80, 6, "Röda oliver", 2));
        items.addItemByQuantity("Kidu773", 1);
        items.addItemByQuantity("Kid233333", 5);
    }

    @After
    public void tearDown() throws Exception {
        items = null;
    }

    @Test
    public void getReceiptStrings() {
        receipt = new Receipt(items, new Payment(items.getPrice().getPrice(), 1200));
        printer.printReceipt(receipt);
    }
}