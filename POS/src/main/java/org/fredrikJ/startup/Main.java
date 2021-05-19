package org.fredrikJ.startup;

import org.fredrikJ.controller.Controller;
import org.fredrikJ.integration.*;
import org.fredrikJ.view.View;

/**
 * The main method that makes the constructor and creates the view.
 */
public class Main {

    public static void main(String[] args) {

        Register register = new Register();

        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();

        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();

        Printer printer = new Printer();

        InventoryCatalog inventoryCatalog = new InventoryCatalog();

        DiscountCatalog discountCatalog = new DiscountCatalog();

        CustomerCatalog customerCatalog = new CustomerCatalog();


        System.out.println("Program Startup");

        Controller controller = new Controller(register, externalAccountingSystem, externalInventorySystem,
                printer, inventoryCatalog, discountCatalog, customerCatalog);

        View view = new View(controller);
        view.view();
    }
}
