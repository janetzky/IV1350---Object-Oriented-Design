package org.fredrikJ.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an ItemList with itemTypes.
 */
public class ItemList {

    private List<ItemType> items = new ArrayList<ItemType>();

    private Price price;

    /**
     * Constructor
     */
    public ItemList() {
        price = new Price();
    }

    /**
     * Adds a new itemType to the list.
     *
     * @param newItemType to add
     */
    public void addItemType(ItemType newItemType) {
        if (newItemType != null && newItemType.getQuantity() > 0)
            this.items.add(newItemType);
    }

    /**
     * Adds to the quantity of already present item in the list.
     *
     * @param itemId   A specific item identifier for certain item types.
     * @param quantity quantity of the specific item.
     */
    public void addItemByQuantity(String itemId, int quantity) {
        for (ItemType currentItemType : items)
            if (currentItemType.getItemId().equals(itemId))
                if (!currentItemType.addAndSubToQuantity(quantity)) { //If item quantity = 0 delete item from list
                    items.remove(currentItemType);
                    break;
                }
    }


    /**
     * Checks if the ItemType is in list.
     *
     * @param itemId to search by
     * @return true is item with specified itemId is in list
     */
    public boolean isItemTypeInList(String itemId) {
        for (ItemType currentItemType : items) {
            if (currentItemType.getItemId().equals(itemId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds and returns an itemType with specified itemId.
     *
     * @param itemId specific item identifier.
     */
    public ItemType getItemTypeById(String itemId) {
        int index = 0;
        for (ItemType currentItemType : items) {
            if (currentItemType.getItemId().equals(itemId)) {
                return items.get(index);
            }
            index++;
        }
        return null;
    }

    /**
     * Represent items scanned in to the system during current sale.
     *
     * @return string representing previously added items.
     */
    public String getScannedItems() {
        StringBuilder string = new StringBuilder();

        for (ItemType currentItemType : items)
            string.append(String.format("%-20s %10d * %10.2f kr %10.2f kr \n", currentItemType.getDescription(), currentItemType.getQuantity(), currentItemType.getPrice().getPrice(), currentItemType.getTotalPrice().getPrice()));

        string.append(String.format("%-20s %10.2f kr %10s %10.2f kr  \n", "Total price:", getPrice().getPrice(), "Vat:", getPrice().getVat()));

        return string.toString();
    }

    /**
     * Returns a ArrayList of all items in the list.
     */
    public List<ItemType> getListOfItems() {
        List<ItemType> itemTypes = new ArrayList<>(this.items);
        return itemTypes;
    }

    /**
     * Returns an price object containing total price of items in list.
     */
    public Price getPrice() {
        updatePrice();
        return price;
    }

    /**
     * Updates the price of the Price object.
     */
    public void updatePrice() {
        double price = 0;
        double vat = 0;
        for (ItemType currentItemType : items) {
            price += currentItemType.getTotalPrice().getPrice();
            vat += currentItemType.getTotalPrice().getVat();
        }
        this.price.setPriceAndVat(price, vat);
    }

    /**
     * Sets a specified discount to the total price object.
     *
     * @param discount the specific discount.
     */
    public void setDiscount(double discount) {
        this.price.setDiscountByPercentage(discount);
    }
}
