package org.fredrikJ.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.integration.*;
import org.fredrikJ.model.*;

public class ControllerTest {
    Controller controller;
    private Register register;
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;
    private Printer printer;
    private InventoryCatalog inventoryCatalog;
    private DiscountCatalog discountCatalog;
    private CustomerCatalog customerCatalog;
    private Sale sale = new Sale();
    private Payment payment;

    @Before
    public void setUp() {
        printer = new Printer();
        controller = new Controller(register, externalAccountingSystem, externalInventorySystem, printer, inventoryCatalog, discountCatalog, customerCatalog);
    }

    @After
    public void tearDown(){
        controller = null;
    }

    @Test
    public void startNewSale() {
        controller.startNewSale();
        Assert.assertEquals(0, controller.getRunningTotal(),0.0001);
    }

    @Test
    public void enterItem() {
        String invalidItemId = "7350042710101";
        String correctItem = "7350042710102";
        try {
            sale.enterItem(invalidItemId, 4);
            sale.enterItem(correctItem, 4);
            Assert.assertTrue(sale.getItemList().isItemTypeInList(correctItem));
            Assert.assertFalse(sale.getItemList().isItemTypeInList(invalidItemId));
        }
        catch (InvalidItemIdException | DatabaseFailureException exception){
           Assert.assertEquals("Invalid item identifier. Item identifier can not be found in database.", exception.getMessage());
        }
    }

    @Test
    public void getRunningTotal() {
        try{
            sale.enterItem("7340888803525", 2);
            sale.enterItem("7340888803525", 1);
        }catch(Exception exception){ }
        Assert.assertEquals(412.5, sale.getRunningTotal(), 0.0001);
    }

    @Test
    public void pay() {
        double amountPaid = 503.99;
        Payment payment = new Payment(sale.getRunningTotal(), amountPaid);
        Receipt receipt = sale.endSale(payment);
        Assert.assertNotEquals(null, receipt);
        Assert.assertEquals(payment.getChange(), amountPaid - sale.getRunningTotal() , 0.0001);
    }
}