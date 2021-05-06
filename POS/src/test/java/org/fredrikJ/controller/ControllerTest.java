package org.fredrikJ.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.integration.*;
import org.fredrikJ.model.InventoryCatalog;
import org.fredrikJ.model.Payment;
import org.fredrikJ.model.Sale;

public class ControllerTest {
    Controller controller;
    private Register register;
    private ExternalAccountingSystem externalAccountingSystem;
    private ExternalInventorySystem externalInventorySystem;
    private Printer printer;
    private InventoryCatalog inventoryCatalog;
    private DiscountCatalog discountCatalog;
    private Sale sale = new Sale();
    private Payment payment;

    @Before
    public void setUp() throws Exception {

        printer = new Printer();
        controller = new Controller(register, externalAccountingSystem, externalInventorySystem, printer, inventoryCatalog, discountCatalog);
        sale.enterItem("7340888803525", 2);
        sale.enterItem("7340888803525", 1);
    }

    @After
    public void tearDown() throws Exception {
        controller = null;
    }

    @Test
    public void startNewSale() {
        controller.startNewSale();
    }

    @Test
    public void enterItem() {
        sale.enterItem("7350042710102", 4);
        //Using the printfunction to show that the sale contains 4 of "Mycket god vatten"
        printer.printReceipt(sale.endSale(new Payment(sale.getRunningTotal(), 500)));
    }

    @Test
    public void getRunningTotal() {
        Assert.assertEquals(412.5, sale.getRunningTotal(), 0.0001);
    }
    // omitted in seminar 3
    @Test
    public void discountRequest() {
    }

    @Test
    public void pay() {
        sale.endSale(new Payment(sale.getRunningTotal(), 503));
    }
}