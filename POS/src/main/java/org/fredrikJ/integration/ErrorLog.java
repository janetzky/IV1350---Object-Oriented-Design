package org.fredrikJ.integration;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Represents the ErrorLog.
 */
public class ErrorLog {

    private Logger logger;
    private FileHandler fileHandler;

    /**
     * Constructor of the ErrorLog.
     */
    public ErrorLog() {
        String filename = "errorLog.txt";
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("Log file created: " + myObj.getName());
            } else {
                System.out.println("Log file already exists. Using existing");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while making or opening Log file.");
            e.printStackTrace();
        }
        try {
            fileHandler = new FileHandler(filename, true);
        } catch (IOException e) {
            System.out.println("File handler was not created.");
        }
        logger = Logger.getLogger("test");
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }

    /**
     * Adds a warning exception that will be handled by the logger.
     *
     * @param exception exception
     */
    public void logWarning(Exception exception) {
        logger.warning(exception.getMessage());
    }

    /**
     * Adds an informative exception that will be handled by the logger.
     *
     * @param exception exception
     */
    public void logInfo(Exception exception) {
        logger.info(exception.getMessage());
    }

    /**
     * Adds a informative string that will be handled by the logger.
     *
     * @param info representing the specific info.
     */
    public void logInfoString(String info) {
        logger.info(info);
    }
}

