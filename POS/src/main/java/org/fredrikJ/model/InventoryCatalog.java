package org.fredrikJ.model;

import java.util.ArrayList;

/**
 * Database containing all avaliable item-Types in store and their data.
 * Such as ItemId, price, vat, vat percentage, description and quantity.
 * OBS! Quantity is 0 for now. Will be edited when customer buys items.
 */

public class InventoryCatalog {

    private final ArrayList<ItemType> items;
    private ItemType itemType;

    public InventoryCatalog() {
        items = new ArrayList<ItemType>();
        items.add(new ItemType("7350042710102", 20.3, 6, "Mycket god vatten", 0));
        items.add(new ItemType("7340001803525", 20.3, 12, "Mycket god godis", 0));
        items.add(new ItemType("7340888803525", 110, 25, "Mycket god Mat", 0));
        items.add(new ItemType("7392257101382", 10.3, 25, "Mycket god vegankaka", 0));
        items.add(new ItemType("7392257101337", 110.3, 6, "Mycket god Sur lakrits", 0));
        items.add(new ItemType("7070866022716", 450.3, 11, "Nutrilett Cocoa & Oat", 0));

        items.add(new ItemType("A1", 85.8, 12, "Nutrilett BlueBerry", 0));
        items.add(new ItemType("A2", 7.8, 25, "Nutrilett Apple", 0));
        items.add(new ItemType("A3", 450.3, 6, "Nutrilett Raspberry", 0));
        items.add(new ItemType("A4", 23.77, 25, "Nutrilett Cocoa & Oat", 0));
        items.add(new ItemType("A5", 14.99, 12, "Nutrilett Peach", 0));
        items.add(new ItemType("A6", 5.7, 12, "Nutrilett Mango", 0));
    }

    /**
     * Returns ItemType object with the specified ItemId and quantity.
     *
     * @param itemId   ItemId of the requested  item.
     * @param quantity Quantity of the specified item.
     */
    public ItemType getItemById(String itemId, int quantity) {
        for (ItemType currentItemType : items) {
            if (currentItemType.getItemId().equals(itemId)) {
                ItemType itemTypeToReturn = new ItemType(currentItemType);
                itemTypeToReturn.addAndSubbToQuantity(quantity);
                return new ItemType(itemTypeToReturn);
            }
        }
        return null;
    }

    //Alternative flow always true for now , should not be considered in seminar 3.
    public boolean validateItemById(String itemId) {
        return true;
    }

}
