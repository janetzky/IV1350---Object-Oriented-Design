package org.fredrikJ.model;

import org.fredrikJ.integration.InventoryCatalog;

/**
 * Represents an sale.
 */
public class Sale {

    private final InventoryCatalog inventoryCatalog = new InventoryCatalog();
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
     * @return return if the item is in the list of not.
     */
    public boolean enterItem(String itemId, int quantity) throws InvalidItemIdException, DatabaseFailureException {
        boolean isItemInList = itemList.isItemTypeInList(itemId);
        if (isItemInList)
            itemList.addItemByQuantity(itemId, quantity);
        else {
            itemList.addItemType(inventoryCatalog.getItemById(itemId, quantity));
        }
        return isItemInList;
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
     * Get methods
     */
    public ItemList getItemList() {
        return itemList;
    }

    public ItemType getItemById(String itemId) {
        return itemList.getItemTypeById(itemId);
    }

    public double getRunningTotal() {
        return itemList.getPrice().getPrice();
    }

    public String getScannedItems() {
        return itemList.getScannedItems();
    }

}
