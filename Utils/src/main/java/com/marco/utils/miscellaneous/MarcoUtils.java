package com.marco.utils.miscellaneous;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.marco.utils.MarcoException;
/**
 * This class provides a set of Utils methods
 * 
 * 
 * @author msolina
 *
 */
public class MarcoUtils {
	private static Properties properties = null;
    private static String PROPERTIES_FILE = "";
    final static Logger logger = Logger.getLogger(MarcoUtils.class);
    
    /**
     * Set the properties file name
     * @param fileName
     */
    public static void setPropertiesFileName(String fileName) {
        PROPERTIES_FILE = fileName;
    }
    /**
     * It retrieves the property from the properties
     * file
     * 
     * @param property
     * @return
     * @throws MarcoException 
     */
    public static String getProperty(String property) throws MarcoException {
        if (properties == null) {
            properties = new Properties();
            try {
                InputStream is = MarcoUtils.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
                properties.load(is);
                logger.info(PROPERTIES_FILE + " loaded successfully");
            } catch (IOException e) {
                logger.error("Can not load properties file");
                throw new MarcoException("Can not load properties file: " + PROPERTIES_FILE);
            }
        }

        String value = properties.getProperty(property);
        logger.debug("Property: " + property + " Value: " + value);
        return value;
    }
}
