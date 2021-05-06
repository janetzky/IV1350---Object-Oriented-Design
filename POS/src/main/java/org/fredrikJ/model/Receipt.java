package org.fredrikJ.model;

import java.util.ArrayList;

/**
 * A class that builds the receipt with all its information.
 */
public class Receipt {
    ItemList items;
    Payment payment;
    StoreInfo storeInfo;

    /**
     * Constructor
     *
     * @param items   an object of Itemlist containing all itemTypes in current sale.
     * @param payment an object containing the information of the payment.
     */
    public Receipt(ItemList items, Payment payment) {
        this.items = items;
        this.payment = payment;
        this.storeInfo = new StoreInfo();
    }

    /**
     * Creates a receipt in form of String ArrayList, by using Itemlist, Payment and storeInfo.
     *
     * @return Array list receipt array
     */
    public ArrayList<String> getReceiptStrings() {
        ArrayList<String> receiptArray = new ArrayList<String>();
        receiptArray.add("Receipt. Thank you for your buy!!");
        receiptArray.add(storeInfo.getStoreName());
        receiptArray.add(storeInfo.getAdressName());
        receiptArray.add(String.format("Tel: %s Org nr: %s \n", storeInfo.getTelephoneNumber(), storeInfo.getOrganisationNumber()));

        receiptArray.add(String.format("%-25s %5s %10s %15s\n", "Item", "Quantity", "Price", "Sum"));

        for (ItemType currentItemType : items.getListOfItems())
            receiptArray.add(String.format("%-25s %5d * %10.2f %15.2f kr", currentItemType.getDescription(), currentItemType.getQuantity(), currentItemType.getPrice().getPrice(), currentItemType.getTotalPrice().getPrice() ));

        receiptArray.add(String.format("\n%10s: %10.2f", "Total", items.getPrice().getPrice()));
        receiptArray.add(String.format("%10s: %10.2f \n", "Vat", items.getPrice().getVat()));

        receiptArray.add(String.format("%10s: %10.2f %10s: %10.2f \n", "Cash", payment.getAmountPaid(), "Change", payment.getChange()));

        receiptArray.add("Date: " + payment.getDate());
        receiptArray.add("Time: " + payment.getTime());

        return receiptArray;
    }
}