package org.fredrikJ.view;

import org.fredrikJ.controller.Controller;

import java.util.Scanner;

public class View {

    private Controller controller;

    /**
     * Creates a new instance, representing the controller.
     *
     * @param controller the controller
     */
    public View(Controller controller) {
        this.controller = controller;
    }
    /* Test för ItemRegistration */

    public void view() {
        controller.startNewSale();

        Scanner scanner = new Scanner(System.in);

        //controller.enterItem("A2", 4);
        //controller.enterItem("A2", 7);
        //controller.enterItem("A5", 3);
        //controller.enterItem("A5", 6);


        while (true) {
            String textIn = getItemId();
            if ( textIn.equals("end"))
                break;
            controller.enterItem(textIn, getQuantity());
            System.out.println("\n" + controller.getScannedItems());
        }

        System.out.println("Sale ended \n\n");

        System.out.println(String.format("%-25s %10s", "To Pay:", controller.getRunningTotal() ));
        System.out.println(String.format("%-25s", "Enter Cash Paid:" ));
        Double amountPaid = scanner.nextDouble();

        controller.pay(controller.getRunningTotal(), amountPaid);
    }

    private String getItemId() {
        Scanner scanner = new Scanner(System.in);
        String itemId;
        System.out.println("Enter ItemID or 'end' to end sale.");

        do {
            itemId = scanner.nextLine();
        } while (itemId.length() < 2);

        return itemId;
    }

    private int getQuantity() {
        Scanner scanner = new Scanner(System.in);
        int quantity;
        System.out.println("Enter Quantity: ");

        do {
            quantity = scanner.nextInt();
        } while (quantity == 0);
        return quantity;
    }


}