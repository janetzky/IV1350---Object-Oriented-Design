package org.fredrikJ.integration;

import org.fredrikJ.model.Payment;
import org.fredrikJ.model.Receipt;

/**
 * Represents the external accounting system.
 */
public class ExternalAccountingSystem {
    /**
     * Constructs a new external accounting system.
     */
    public ExternalAccountingSystem() {
    }

    /**
     * Adds a new payment to the external accounting system.
     *
     * @param payment an object of Payment valid for this specific sale.
     * @param receipt an object of Receipt valid for this specific sale.
     */
    public void registerPayment(Payment payment, Receipt receipt) {
        System.out.println(String.format("Payment of %10.2f kr registered to external accounting system at %10s the %10s ",payment.getAmountToPay(), payment.getTime(),  payment.getDate() ));
    }

}
