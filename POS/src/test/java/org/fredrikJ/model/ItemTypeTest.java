package org.fredrikJ.model;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTypeTest {

    private ItemType item;

    @Before
    public void setUp() throws Exception {
        item = new ItemType("45LL@11||ww1", 761.99, 11.442, "Mycket god rulltårta", 12);
    }
    @After
    public void tearDown() throws Exception {
        item = null;
    }

    @Test
    public void addAndSubbToQuantity() {
        //Test add, 12 + 2 = 14
        item.addAndSubbToQuantity(2);
        Assert.assertEquals(14, item.getQuantity());

        Assert.assertEquals(11888.47654, item.getTotalPrice().getPrice(), 0.0001);
        Assert.assertEquals(10667.86, item.getTotalPrice().getNetto(), 0.0001);
        Assert.assertEquals(11.442, item.getTotalPrice().getVatPercentage(), 0.0001);

        //Test subtraction to much, 14 - 15 = -1, -1 !>= 0, should not change if the subtraction is to big.
        item.addAndSubbToQuantity(-15);
        Assert.assertEquals(14, item.getQuantity());

        //Test subtraction, 14 - 14 = 0
        item.addAndSubbToQuantity(-14);
        Assert.assertEquals(0, item.getQuantity());


    }
}