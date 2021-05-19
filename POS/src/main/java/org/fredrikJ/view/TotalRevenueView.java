package org.fredrikJ.view;

import org.fredrikJ.model.SaleObserver;

/**
 * An implementation of SaleObserver that will log to the view.
 */
public class TotalRevenueView implements SaleObserver {

    double totalRevenue = 0;

    /**
     * Updates the total revenue and prints to the view when observer is called.
     *
     * @param saleTotal the total of a specific sale.
     */
    @Override
    public void updateTotalRevenue(double saleTotal) {
        totalRevenue += saleTotal;
        System.out.println(outputText());
    }

    private String outputText() {
        String separator = "---------------------------------";
        return String.format("%s Total revenue is:  %10.2f kr %s \n\n\n", separator, totalRevenue, separator);
    }
}
