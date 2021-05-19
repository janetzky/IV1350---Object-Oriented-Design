package org.fredrikJ.model;

/**
 * DatabaseFailureException is thrown when access to the database fails.
 */
public class DatabaseFailureException extends Exception {
    /**
     * Constructs an DatabaseFailureException with default message.
     */
    public DatabaseFailureException() {
        super("Database connection failure.");
    }

    /**
     * Constructs an DatabaseFailureException with custom message.
     *
     * @param s custom message
     */
    public DatabaseFailureException(String s) {
        super(s);
    }
}
