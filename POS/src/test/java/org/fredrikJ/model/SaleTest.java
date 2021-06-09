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
    public void tearDown() {
        sale = null;
    }

    @Test
    public void enterItem() {
        try {
            Assert.assertTrue( sale.enterItem("7350042710102", 3));
            Assert.assertFalse(sale.enterItem("7392257101382", 12));
            Assert.assertTrue( sale.enterItem("7392257101382", 12));
        }catch (Exception e){
            Assert.fail(e.getMessage());
        }
        try {
            Assert.assertFalse( sale.enterItem("invalidItemId", 12));
        }catch (Exception e){
            Assert.assertTrue(true);
        }
        Assert.assertEquals(6,sale.getItemById("7350042710102").getQuantity());
        Assert.assertEquals(24,sale.getItemById("7392257101382").getQuantity());

        Assert.assertEquals("7392257101382",sale.getItemById("7392257101382").getItemId());
        Assert.assertEquals("7350042710102",sale.getItemById("7350042710102").getItemId());
    }

    @Test
    public void getRunningTotal() {
        Assert.assertEquals(64.554,sale.getRunningTotal(), 0.0001);
    }

    @Test
    public void endSale() {
        try {
            Printer printer = new Printer();
            receipt = sale.endSale(new Payment(sale.getRunningTotal(), 120));
            printer.printReceipt(receipt);
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getItemList(){
        Assert.assertNotNull(sale.getItemList());
        Assert.assertEquals(sale.getRunningTotal(), sale.getItemList().getPrice().getPrice(),0.0001);
    }

    @Test
    public void getItemById(){
        Assert.assertNotNull(sale.getItemById("7350042710102"));
    }

    @Test
    public void getScannedItems(){
        Assert.assertNotNull(sale.getScannedItems());
    }
}