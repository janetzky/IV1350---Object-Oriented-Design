package org.fredrikJ.integration;

import org.fredrikJ.model.Payment;
/**
*   Represents the register.
*/
public class Register {
    /**
    * Constructs a new register.
    */
    public Register() {
    }
    /**
    *   Deposit the amount to pay for the sale in the register.
    *@param payment object will specify amount.
    */
    public void deposit(Payment payment) {
        System.out.println(String.format("Deposited %10.2f to Register", payment.getAmountToPay()));
    }
}
