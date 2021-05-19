package org.fredrikJ.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents the database of the customers.
 */
public class CustomerCatalog {
    List<Customer> customerList;

    /**
     * Constructor of the customer catalog.
     */
    public CustomerCatalog() {
        customerList = new ArrayList();
        addHardCodedCustomers();
    }

    /**
     * Adds a customer to the customerList.
     *
     * @param customer Represents the customer.
     */
    public void addCustomer(Customer customer) {
        this.customerList.add(customer);
    }

    /**
     * Returns the customers id if it is in the customerList.
     *
     * @param customerId a string representing a customer.
     * @return if found the customer otherwise null.
     */
    public Customer getCustomerById(String customerId) {
        for (Customer customer : this.customerList) {
            if (customer.getCustomerId().equals(customerId))
                return customer;
        }
        return null;
    }

    private void addHardCodedCustomers() {
        addCustomer(new Customer("Olle1337", "Olle", new Date(20010825)));
        addCustomer(new Customer("Kalle1337", "Kalle", new Date(19960211)));
    }

}
