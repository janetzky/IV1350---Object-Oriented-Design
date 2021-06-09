package org.fredrikJ.view;

import org.fredrikJ.model.TotalRevenueTemplate;

/**
 * An implementation of SaleObserver that will log to the view.
 */
public class TotalRevenueView extends TotalRevenueTemplate {

    double totalRevenue = 0;

    /**
     * Calculates the total income since program started.
     *
     * @param priceOfTheSaleThatWasJustMade income from the last sale.
     */
    @Override
    protected void calculateTotalIncome(double priceOfTheSaleThatWasJustMade) {
        totalRevenue += priceOfTheSaleThatWasJustMade;
    }

    /**
     * Prints total income to screen.
     *
     * @throws Exception that issues the problem if the filewriter and revenuewriter could not be made.
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        System.out.println(outputText());
    }

    /**
     * Handles the errors encountered when presenting total income.
     *
     * @param e
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println(e.getMessage());
    }

    private String outputText() {
        String separator = "---------------------------------";
        return String.format("%s Total revenue is:  %10.2f kr %s \n", separator, totalRevenue, separator);
    }

}
