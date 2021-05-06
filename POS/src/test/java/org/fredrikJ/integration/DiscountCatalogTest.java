package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* May be omitted for seminar 3.
*/
public class DiscountCatalogTest {
    private DiscountCatalog discountCatalog;
    @Before
    public void setUp() throws Exception {
        discountCatalog = new DiscountCatalog();
    }

    @After
    public void tearDown() throws Exception {
        discountCatalog = null;
    }

    @Test
    public void getDiscountByCustomerId() {
        Assert.assertEquals(0, discountCatalog.getDiscountByCustomerId("01062817653"), 0.0001);
    }

    @Test
    public void checkDiscountByCustomerId() {
        Assert.assertFalse(discountCatalog.checkDiscountByCustomerId("01062817653"));
    }
}