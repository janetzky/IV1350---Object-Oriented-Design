package org.fredrikJ.model;

/**
 * The class itemType represents an item or group of similar items.
 */
public class ItemType {

    private final String itemId;
    private final String description;
    private Price price;
    private Price totalPrice;
    private int quantity;

    /**
     * Constructor that uses the parameters.
     *
     * @param itemId        the unique string that identifies each item.
     * @param netto         The price of each item/items.
     * @param vatPercentage vat percentage for item.
     * @param description   short description of item.
     * @param quantity      quantity of items.
     */
    public ItemType(String itemId, double netto, double vatPercentage, String description, int quantity) {
        this.totalPrice = new Price(netto, vatPercentage);
        this.price = new Price(netto, vatPercentage);
        this.itemId = itemId;
        this.description = description;
        this.quantity = quantity;
        calculateTotal();
    }

    /**
     * Constructor using existing object.
     *
     * @param ItemTypeToCopy an object of Itemtype.
     */
    public ItemType(ItemType ItemTypeToCopy) {

        this.price = new Price(ItemTypeToCopy.price.getNetto(), ItemTypeToCopy.price.getVatPercentage());
        this.itemId = ItemTypeToCopy.itemId;
        this.description = ItemTypeToCopy.description;
        this.quantity = ItemTypeToCopy.quantity;
        this.totalPrice = new Price();
        calculateTotal();
    }

    /**
     * Add or subract to the quantity.
     *
     * @param quantity to add or subtract
     */
    public boolean addAndSubToQuantity(int quantity) {
        if (this.quantity + quantity > 0)
            this.quantity += quantity;
        else
            return false;
        calculateTotal();
        return true;
    }

    /**
     * Get methods below doing the same thing with different return values.
     */
    public String getItemId() {
        return this.itemId;
    }

    public Price getPrice() {
        return this.price;
    }

    public Price getTotalPrice() { calculateTotal(); return this.totalPrice; }

    public String getDescription() { return this.description; }

    public int getQuantity() { return this.quantity;}

    /**
     * Calculates the vat-amount in cash not in percentage.
     */
    private void calculateTotal() {
        this.totalPrice.setNettoAndVatPercentage(this.price.getNetto() * this.quantity, this.price.getVatPercentage());
    }
}
