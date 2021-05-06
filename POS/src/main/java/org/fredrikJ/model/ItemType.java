package org.fredrikJ.model;

/**
 * The class itemType represents an item or group of similar items.
 */
public class ItemType {

    private final Price price;
    private final String itemId;
    private final String description;
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
        calculateTotal();
    }

    /**
     * Add or subract to the quantity.
     *
     * @param quantity to add or subtract
     */
    public void addAndSubbToQuantity(int quantity) {
        if (this.quantity + quantity >= 0)
            this.quantity += quantity;
        calculateTotal();
    }

    /**
     * Calculates the vat-amount in cash not in percentage.
     */
    private void calculateTotal() {
        this.totalPrice = new Price(this.price.getNetto() * this.quantity, this.price.getVatPercentage());
    }

    /**
     * Get methods below doing the same thing with different return values.
     */
    public String getItemId() {
        return this.itemId;
    }

    public Price getPrice() {
        return new Price(this.price);
    }

    public Price getTotalPrice() {
        calculateTotal();
        return new Price(this.totalPrice);
    }

    public String getDescription() {
        return this.description;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
