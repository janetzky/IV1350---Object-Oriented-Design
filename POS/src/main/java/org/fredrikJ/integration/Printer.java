package org.fredrikJ.integration;

import org.fredrikJ.model.Receipt;

/**
 * Represents the printer, printing out the receipt.
 */
public class Printer {
    /**
     * Constructs a new printer object
     */
    public Printer() {
    }

    /**
     *  Prints specified receipt
     * @param receipt to be printed
     */
    public void printReceipt(Receipt receipt) {
        for (String currentString : receipt.getReceiptStrings()) {
            System.out.println(currentString);
        }
    }
}
