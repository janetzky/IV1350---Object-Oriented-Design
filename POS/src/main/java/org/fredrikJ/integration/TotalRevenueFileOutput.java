package org.fredrikJ.integration;

import org.fredrikJ.model.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * An implementation of SaleObserver that will log to a text file.
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue = 0;
    private PrintWriter revenueWriter;

    /**
     * Constructor of TotalRevenueFileOutput.
     */
    public TotalRevenueFileOutput() {
        try {
            FileWriter file = new FileWriter("RevenueLog.txt");
            revenueWriter = new PrintWriter(file, true);
        } catch (IOException e) {
            System.err.println("File writer could not be made");
        }
    }

    /**
     * Updates the total revenue and prints to the text file when observer is called.
     *
     * @param saleTotal the total of a specific sale.
     */
    @Override
    public void updateTotalRevenue(double saleTotal) {
        totalRevenue += saleTotal;
        revenueWriter.println(outputText(saleTotal));
    }

    private String outputText(double saleTotal) {
        Date date = new Date();
        return String.format("%10s: New Sale recorded: %10.2f kr   Total revenue is:  %10.2f kr ", date, saleTotal, totalRevenue);
    }
}