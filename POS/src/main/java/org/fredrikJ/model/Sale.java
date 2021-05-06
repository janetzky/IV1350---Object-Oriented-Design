package org.fredrikJ.model;

/**
 * Represents an sale.
 */
public class Sale {

    private InventoryCatalog inventoryCatalog = new InventoryCatalog();
    private ItemList itemList = new ItemList();

    /**
     * Creates a new instance, representing a sale.
     */
    public Sale() {
    }

    /**
     * Enters item to sale, item is checked against inventory.
     *
     * @param itemId   specific item identifier.
     * @param quantity quantity of specific item.
     */
    public boolean enterItem(String itemId, int quantity) {
        boolean isItemInList = itemList.isItemTypeInList(itemId);
        if (isItemInList)
            itemList.addItemByQuantity(itemId, quantity);
        else {
            itemList.addItemType(inventoryCatalog.getItemById(itemId, quantity));
        }
        return isItemInList;
    }

    /**
     * Get the current total for sale
     */
    public double getRunningTotal() {
        return itemList.getPrice().getPrice();
    }
    public String getScannedItems() {
        return itemList.getScannedItems();
    }

    /**
     * Ends the sale by generating an receipt
     *
     * @param payment an object containing the information of the payment.
     */
    public Receipt endSale(Payment payment) {
        return new Receipt(itemList, payment);
    }

    /**
     * Omitted in seminar 3.
     */
    public void addDiscount(double discount) {

    }

}
