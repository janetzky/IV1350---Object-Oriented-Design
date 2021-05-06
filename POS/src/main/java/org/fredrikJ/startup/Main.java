package org.fredrikJ.startup;

import org.fredrikJ.controller.Controller;
import org.fredrikJ.integration.*;
import org.fredrikJ.model.InventoryCatalog;
import org.fredrikJ.view.View;

/**
 * class representing main and start up off all the systems
 */
public class Main {

    public static void main(String[] args) {

        Register register = new Register();

        ExternalAccountingSystem externalAccountingSystem = new ExternalAccountingSystem();

        ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();

        Printer printer = new Printer();

        InventoryCatalog inventoryCatalog = new InventoryCatalog();

        DiscountCatalog discountCatalog = new DiscountCatalog();


        System.out.println("Program Startup");

        Controller controller = new Controller(register, externalAccountingSystem, externalInventorySystem,
                printer, inventoryCatalog, discountCatalog);
        View view = new View(controller);

        view.view();
    }
}
