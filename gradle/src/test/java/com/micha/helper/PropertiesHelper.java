package com.micha.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static final Logger logger = LogManager.getLogger("com.example.PropertiesHelper");

    public static Properties loadPropertiesFile(String fileName) {
        try {
            Properties properties = new Properties();
            InputStream inputStream = PropertiesHelper.class.getClassLoader().getResourceAsStream(fileName);
            if(inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("The properties file, '" + fileName + "', was not found in the classpath.");
            }
            return properties;
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.debug("Stacktrace:", e);
            return null;
        }
    }

}
