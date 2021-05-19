package org.fredrikJ.model;

/**
 * InvalidItemIdException is thrown when the ItemId can not be found in the inventory catalog.
 */
public class InvalidItemIdException extends Exception {
    /**
     * Constructs an InvalidItemIdException with default message.
     */
    public InvalidItemIdException() {
        super("Invalid item identifier. Item identifier can not be found in database.");
    }

    /**
     * Constructs an InvalidItemIdException with custom message.
     *
     * @param s custom message
     */
    public InvalidItemIdException(String s) {
        super(s);
    }
}