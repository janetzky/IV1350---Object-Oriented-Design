package org.fredrikJ.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.fredrikJ.model.Payment;

public class RegisterTest {
    private Register register;

    @Before
    public void setUp() {
        register = new Register();
    }

    @After
    public void tearDown() {
        register = null;
    }

    @Test
    public void deposit() {
        register.deposit(new Payment(300.872, 700));
    }
}