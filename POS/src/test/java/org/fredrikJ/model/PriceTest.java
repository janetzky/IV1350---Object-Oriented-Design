package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriceTest {
    public Price price;
    double netto = 35.99;
    double vat = 1.124;
    @Before
    public void setUp() {

        price = new Price(netto, 12.4);

    }

    @After
    public void tearDown() {
        price = null;
    }

    @Test
    public void setNettoAndVatPercentage() {
        price.setNettoAndVatPercentage(46.662, 8.99);
        Assert.assertEquals(46.662, price.getNetto() , 0.0001);
        Assert.assertEquals(46.662 * 0.0899, price.getVat() , 0.0001);
        Assert.assertEquals(8.99, price.getVatPercentage() , 0.0001);
    }

    @Test
    public void setPriceAndVat() {
        price.setPriceAndVat(159.872, 56.22);
        Assert.assertEquals(159.872 - 56.22, price.getNetto() , 0.0001);
        Assert.assertEquals(56.22, price.getVat() , 0.0001);
        //Assert.assertEquals(0, price.getVatPercentage() , 0.0001);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(netto * 1.124, price.getPrice(),0.0001);
    }

    @Test
    public void getNetto() {
        Assert.assertEquals(netto, price.getNetto() ,0.0001);
    }

    @Test
    public void getVatPercentage() {
        Assert.assertEquals(12.4, price.getVatPercentage(),0.0001);
    }

    @Test
    public void getVat() {
        Assert.assertEquals((netto * 0.124), price.getVat(), 0.0001);
    }

    @Test
    public void setDiscount() {
        price.setDiscountByPercentage(10);
        Assert.assertEquals((netto * 1.124 * 0.1), price.getDiscountAmount(), 0.0001);
        Assert.assertEquals((netto * vat), price.getPricePreDiscount(), 0.0001);
        Assert.assertEquals((netto * 1.124 * 0.9), price.getPrice(), 0.0001);
    }
}