package org.fredrikJ.controller;

import org.fredrikJ.integration.*;
import org.fredrikJ.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the controller
 */
public class Controller {
    private final List<ControllerPaymentObserver> controllerPaymentObserverList = new ArrayList<ControllerPaymentObserver>();
    private final Register register;
    private final ExternalAccountingSystem externalAccountingSystem;
    private final ExternalInventorySystem externalInventorySystem;
    private final Printer printer;
    private final InventoryCatalog inventoryCatalog;
    private final DiscountCatalog discountCatalog;
    private final CustomerCatalog customerCatalog;
    private Sale sale = new Sale();

    /**
     * Constructs a new controller that handles the communication between the different layers integration and view.
     *
     * @param register                 an object of Register.
     * @param externalAccountingSystem an object of ExternalAccountingSystem.
     * @param externalInventorySystem  an object of ExternalInventorySystem.
     * @param printer                  an object of Printer.
     * @param inventoryCatalog         an object of InventoryCatalog.
     * @param discountCatalog          an object of DiscountCatalog.
     */
    public Controller(Register register, ExternalAccountingSystem externalAccountingSystem, ExternalInventorySystem externalInventorySystem, Printer printer, InventoryCatalog inventoryCatalog, DiscountCatalog discountCatalog, CustomerCatalog customerCatalog) {
        this.register = register;
        this.externalAccountingSystem = externalAccountingSystem;
        this.externalInventorySystem = externalInventorySystem;
        this.printer = printer;
        this.inventoryCatalog = inventoryCatalog;
        this.discountCatalog = discountCatalog;
        this.customerCatalog = customerCatalog;
    }

    /**
     * Starts a new sale.
     */
    public void startNewSale() {
        ItemList.getInstance().reset();
        this.sale = new Sale();
    }

    /**
     * Enters items to the sale by their itemId and by quantity.
     *
     * @param itemId       a string representing the item.
     * @param itemQuantity the quantity of the specific item.
     * @return always true in our case considering the item will always be in the system.
     * @throws IllegalArgumentException if wrong parameter is typed in, a failure message is sent to the user
     */
    public boolean enterItem(String itemId, int itemQuantity) throws InvalidItemIdException, DatabaseFailureException {
        sale.enterItem(itemId, itemQuantity);
        return true;
    }

    /**
     * Represents the running total of the sale.
     *
     * @return the running total.
     */
    public double getRunningTotal() {
        return sale.getRunningTotal();
    }

    /**
     * Represents the scanned items.
     */
    public String getScannedItems() {
        return sale.getScannedItems();
    }

    /**
     * Creates and enters a payment.
     *
     * @param amountToPay the total cost of the sale, that should be paid.
     * @param amountPaid  the amount that is paid.
     */
    public void pay(double amountToPay, double amountPaid) {
        Payment payment = new Payment(amountToPay, amountPaid);
        Receipt receipt = sale.endSale(payment);

        externalAccountingSystem.registerPayment(payment, receipt);
        externalInventorySystem.registerSale(sale);
        register.deposit(payment);
        System.out.println("\n\n");
        printer.printReceipt(receipt);
        notifyObservers(payment.getAmountToPay());
    }

    /**
     * Notifies observers when a sale is ended.
     *
     * @param saleTotal will be sent to be part of the totalRevenue
     */
    public void notifyObservers(double saleTotal) {
        for (ControllerPaymentObserver controllerPaymentObserver : controllerPaymentObserverList) {
            controllerPaymentObserver.newSaleWasMade(saleTotal);
        }
    }

    /**
     * Adds a sale observer tot the observers list.
     *
     * @param saleobserver representing a saleobserver
     */
    public void addSaleObserver(ControllerPaymentObserver saleobserver) {
        this.controllerPaymentObserverList.add(saleobserver);
    }

    /**
     * Presents the avaliable discounts in text form.
     *
     * @param customerId a string representing a customer.
     */
    public String discountRequest(String customerId) {
        return discountCatalog.getDiscountByCustomerId(customerCatalog.getCustomerById(customerId));
    }

    /**
     * Applies available discounts.
     *
     * @param customerId a string representing a customer.
     */
    public void applyDiscount(String customerId) {
        discountCatalog.applyDiscountByCustomer(customerCatalog.getCustomerById(customerId));
    }


}

