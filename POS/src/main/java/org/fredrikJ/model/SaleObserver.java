package org.fredrikJ.model;

/**
 * Represent the interface of SaleObserver.
 */
public interface SaleObserver {
    /**
     * Updates the total revenue and prints to the view when observer is called.
     *
     * @param saleTotal the total of a specific sale.
     */
    void updateTotalRevenue(double saleTotal);

}
