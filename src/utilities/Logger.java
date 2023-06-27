package utilities;

import org.apache.logging.log4j.LogManager;

public class Logger {
    static {
        System.setProperty("log4j.configurationFile", "log4j.xml");
    }

    static org.apache.logging.log4j.Logger logger;

    static public void initialize() {
        logger = LogManager.getLogger(Logger.class.getName());
        Log().info("The logger has been initialized.");
    }

    static public org.apache.logging.log4j.Logger Log() {
        return logger;
    }
}
