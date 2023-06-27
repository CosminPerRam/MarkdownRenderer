package utilities;

import org.apache.logging.log4j.LogManager;

/**
 * A helper logger wrapper.
 */
public class Logger {
    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    static org.apache.logging.log4j.Logger instance;

    /**
     * Initialize our logger, must be done before using the `Log` function.
     */
    static public void initialize() {
        instance = LogManager.getLogger(Logger.class.getName());
        Log().info("The logger has been initialized.");
    }

    /**
     * Returns the current logger instance;
     * @return the logger
     */
    static public org.apache.logging.log4j.Logger Log() {
        return instance;
    }
}
