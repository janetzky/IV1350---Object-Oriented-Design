package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.Payment;
import org.fredrikJ.model.Receipt;
import org.fredrikJ.model.Sale;

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
        String out = discountCatalog.getDiscountByCustomerId(customers.getCustomerById("Olle1337"), sale.getItemList());
        System.out.println(out);
        //Assert.assertEquals(0, discountCatalog.getDiscountByCustomerId(customers.getCustomerById("Olle1337")), 0.0001);
        //Printer printer = new Printer();
        //sale.enterItem("7350042710102", 3);
        //receipt = sale.endSale(new Payment(sale.getRunningTotal(), 4200));
        //printer.printReceipt(receipt);
    }

    @Test
    public void applyDiscountByCustomerId() {
        //this.sale.getItemList().getItemTypeById("A1").getTotalPrice().setDiscountByPercentage(20);

        System.out.println(this.sale.getItemList().getItemTypeById("A1").getTotalPrice().getDiscountAmount());
        System.out.println(this.sale.getItemList().getItemTypeById("A1").getTotalPrice().getPrice());

        discountCatalog.applyDiscountByCustomerId(customers.getCustomerById("Olle1337"), sale.getItemList());

        Printer printer = new Printer();
        receipt = sale.endSale(new Payment(sale.getRunningTotal(), 4200));
        printer.printReceipt(receipt);
    }

    private void addItem(String itemId, int quantity) {
        try {
            sale.enterItem(itemId, quantity);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void name() {
        Assert.assertEquals(5, sale.getItemList().getListOfItems().size());
        Assert.assertEquals(96.096, sale.getItemById("A1").getPrice().getPrice(),0.0001);
        Assert.assertEquals(96.096 * 3, sale.getItemById("A1").getTotalPrice().getPrice(),0.0001);
        sale.getItemById("A1").getTotalPrice().setDiscountByPercentage(10);
        Assert.assertEquals(10, sale.getItemById("A1").getTotalPrice().getDiscountPercentage(), 0.0001);
        discountCatalog.applyDiscountByCustomerId(customers.getCustomerById("Olle1337"), sale.getItemList());
        Assert.assertEquals(96.096 * 3 * 0.9, sale.getItemById("A1").getTotalPrice().getPrice(),0.0001);
    }
}