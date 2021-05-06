package org.fredrikJ.integration;

import org.fredrikJ.model.Sale;

/**
 * Represents the external inventory system
 */
public class ExternalInventorySystem {
    /**
     * Constructs a new external inventory system.
     */
    public ExternalInventorySystem() {
    }

    /**
     * Registers a new sale to the external inventory system
     * @param sale will be saved by system.
     */
    public void registerSale(Sale sale) {
        System.out.println("Bought items registered to external inventory system");
    }

}