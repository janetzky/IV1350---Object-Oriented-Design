package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.Sale;

public class ExternalInventorySystemTest {
    private ExternalInventorySystem externalInventorySystem;

    @Before
    public void setUp() {
        externalInventorySystem = new ExternalInventorySystem();
    }

    @After
    public void tearDown() {
        externalInventorySystem = null;
    }

    @Test
    public void registerSale() {
        try{
            externalInventorySystem.registerSale(new Sale());
        }catch(Exception e){
            Assert.fail(e.getMessage());
        }
    }
}