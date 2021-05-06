package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.integration.Printer;

public class SaleTest {
    private Sale sale;
    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        sale = new Sale();
        sale.enterItem("7350042710102", 3);
    }

    @After
    public void tearDown() throws Exception {
        sale = null;
    }

    @Test
    public void enterItem() {
        Assert.assertEquals(true,sale.enterItem("7350042710102", 3));
        Assert.assertEquals(false,sale.enterItem("7392257101382", 12));
        Assert.assertEquals(true,sale.enterItem("7392257101382", 12));
    }

    @Test
    public void getRunningTotal() {
        Assert.assertEquals(64.554,sale.getRunningTotal(), 0.0001);
    }

    @Test
    public void endSale() {
        Printer printer = new Printer();
        sale.enterItem("7350042710102", 3);
        receipt = sale.endSale(new Payment(sale.getRunningTotal(), 120));
        printer.printReceipt(receipt);
    }

    @Test
    public void addDiscount() {
    }
}