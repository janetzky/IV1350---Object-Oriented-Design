package org.fredrikJ.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriceTest {
    public Price price;

    @Before
    public void setUp() throws Exception {
        price = new Price(35.99, 12.4);

    }

    @After
    public void tearDown() throws Exception {
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
        Assert.assertEquals(35.1656, price.getVatPercentage() , 0.0001);
    }

    @Test
    public void getPrice() {
        Assert.assertEquals(35.99 * 1.124, price.getPrice(),0.0001);
    }

    @Test
    public void getNetto() {
        Assert.assertEquals(35.99, price.getNetto() ,0.0001);
    }

    @Test
    public void getVatPercentage() {
        Assert.assertEquals(12.4, price.getVatPercentage(),0.0001);
    }

    @Test
    public void getVat() {
        Assert.assertEquals((35.99 * 0.124), price.getVat(), 0.0001);  }

    @Test
    public void setDiscount() {
    }
}