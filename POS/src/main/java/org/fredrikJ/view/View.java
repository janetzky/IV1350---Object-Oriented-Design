package org.fredrikJ.view;

import org.fredrikJ.controller.Controller;
import org.fredrikJ.integration.ErrorLog;
import org.fredrikJ.integration.TotalRevenueFileOutput;
import org.fredrikJ.model.DatabaseFailureException;
import org.fredrikJ.model.InvalidItemIdException;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private final Controller controller;
    private final ErrorLog errorlog;
    private final TotalRevenueFileOutput totalRevenueFileOutput;
    private final TotalRevenueView totalRevenueView;


    /**
     * Creates a new instance, representing thec controller.
     *
     * @param controller the controller
     */
    public View(Controller controller) {
        this.controller = controller;
        this.errorlog = new ErrorLog();
        this.totalRevenueFileOutput = new TotalRevenueFileOutput();
        this.totalRevenueView = new TotalRevenueView();
    }

    /**
     * A boolean checking if the string match.
     *
     * @param string the specific string to
     * @return true of false.
     */
    public static boolean isNumeric(String string) {
        String regex = "[0-9]+[\\.]?[0-9]*";
        return Pattern.matches(regex, string);
    }

    public void view() {
        errorlog.logInfoString("\n\nProgram started.");
        controller.addSaleObserver(totalRevenueFileOutput);
        controller.addSaleObserver(totalRevenueView);

        saleExample();
        saleExample();
    }

    private void saleExample(){
        controller.startNewSale();
        System.out.println("New Sale Started\n");

        enterHardCodedItems();

        System.out.println("Sale ended \n\n");

        System.out.println("Check for available discounts \n\n");

        System.out.println(controller.discountRequest("Olle1337"));

        controller.applyDiscount("Olle1337");

        System.out.printf("%-25s %10.2f kr %n", "To Pay:", controller.getRunningTotal());

        double amountPaid = 2500;
        System.out.printf("%-25s %10.2f kr %n", "Customer pays:", amountPaid );
        controller.pay(controller.getRunningTotal(), amountPaid);

        System.out.println("Sale ended\n\n");
    }

    private void manualView(){
        errorlog.logInfoString("\n\nProgram started.");
        controller.addSaleObserver(totalRevenueFileOutput);
        controller.addSaleObserver(totalRevenueView);

        while (true) {
            controller.startNewSale();
            System.out.println("New Sale Started\n");

            enterHardCodedItems();

            while (true) {
                String textIn = getItemId();
                if (textIn.equals("end"))
                    break;
                enterItem(textIn, getQuantity());
            }

            System.out.println("Sale ended \n\n");

            System.out.println("Entering Discount \n\n");
            String avaliableDiscounts = controller.discountRequest("Olle1337");
            System.out.println(avaliableDiscounts);

            controller.applyDiscount("Olle1337");

            System.out.printf("%-25s %10.2f%n", "To Pay:", controller.getRunningTotal());
            System.out.printf("%-25s%n", "Enter Cash Paid:");

            controller.pay(controller.getRunningTotal(), getDouble());
        }
    }

    private void enterHardCodedItems() {
        enterItem("A1", 3);
        enterItem("A2", 4);
        enterItem("A5", 3);
        enterItem("WrongItemId", 883);
        enterItem("A5", 6);
        enterItem("A2", -4);
        enterItem("A3", 6);
        enterItem("DBTest", 8);
    }

    private void enterItem(String itemId, int quantity) {
        try {
            System.out.println("New item added by id: \"" + itemId + "\" Quantity: " + quantity);
            controller.enterItem(itemId, quantity);
            System.out.println(controller.getScannedItems());
        } catch (InvalidItemIdException exception) {
            System.out.println("\u001B[33m" + exception.getMessage() + "\u001B[0m");
            errorlog.logInfo(exception);
        } catch (DatabaseFailureException exception) {
            System.out.println("\u001B[33m" + exception.getMessage() + "\u001B[0m");
            errorlog.logWarning(exception);
        }
    }

    private String getItemId() {
        String itemId;
        System.out.println("Enter ItemID or 'end' to end sale.");

        do {
            itemId = getString();
        } while (itemId.length() < 2);

        return itemId;
    }

    private int getQuantity() {
        System.out.println("Enter Quantity: ");
        String input;

        do {
            input = getString();
        } while (!isNumeric(input));

        return Integer.parseInt(input);
    }

    private String getString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private Double getDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}