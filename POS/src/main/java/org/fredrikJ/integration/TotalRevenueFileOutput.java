package org.fredrikJ.integration;

import org.fredrikJ.model.TotalRevenueTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * An implementation of SaleObserver that will log to a text file.
 */
public class TotalRevenueFileOutput extends TotalRevenueTemplate {
    private double totalRevenue = 0;
    private PrintWriter revenueWriter;

    /**
     * A method calculating the total revenue while the program been active.
     * @param priceOfTheSaleThatWasJustMade income from the last sale.
     */
    @Override
    protected void calculateTotalIncome(double priceOfTheSaleThatWasJustMade) {
        totalRevenue += priceOfTheSaleThatWasJustMade;
    }

    /**
     * Method that print the total revenue for all the sales.
     * @throws Exception that issues the problem if the filewriter and revenuewriter could not be made.
     */
    @Override
    protected void doShowTotalIncome() throws Exception {
        try {
            FileWriter file = new FileWriter("RevenueLog.txt");
            revenueWriter = new PrintWriter(file, true);
        } catch (IOException e) {
            throw new IOException("File writer could not be made");
        }
        revenueWriter.println(outputText());
    }

    /**
     * Handles the errors encountered when presenting total income.
     * @param e get exceptions message
     */
    @Override
    protected void handleErrors(Exception e) {
        System.err.println(e.getMessage());
    }

    private String outputText() {
        Date date = new Date();
        return String.format("%10s: New Sale recorded. Total revenue is:  %10.2f kr "
                , date, totalRevenue);
    }
}