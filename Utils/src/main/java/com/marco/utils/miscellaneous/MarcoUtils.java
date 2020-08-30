package com.marco.utils.miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.marco.utils.MarcoException;

/**
 * This class provides a set of Utils methods
 * 
 * 
 * @author msolina
 *
 */
public class MarcoUtils {
	private static Properties appProperties = null;

	private MarcoUtils() {
	}

	public static void setAppProperties(Properties appProperties) {
		MarcoUtils.appProperties = appProperties;
	}

	/**
	 * It returns the value of the property
	 * 
	 * @param property
	 * @return
	 * @throws MarcoException
	 */
	public static String getProperty(String property) throws MarcoException {
		if (appProperties == null) {
			throw new MarcoException("Properties object not setted");
		}

		return appProperties.getProperty(property);
	}

	/**
	 * It configures log4j. It loads first the default log4j.properties file
	 * provided within this project, and then it looks for an external
	 * log4j.properties file to to overwrite the default properties
	 * 
	 * @param <T>
	 * @param mainClazz
	 * @return
	 */
	public static <T> Logger configureAndGetLogger(Class<T> mainClazz) {

		InputStream isLog4jProps = null;

		Logger logger = Logger.getLogger(mainClazz);
		try {
			/*
			 * Get the folder where this Jar is saved
			 */
			String jarFolder = new File(mainClazz.getProtectionDomain().getCodeSource().getLocation().toURI())
					.getParent();

			File log4JFile = new File(jarFolder + "/log4j.properties");

			Properties log4JProps = new Properties();

			/*
			 * Loading default log4j.properties
			 */
			isLog4jProps = Thread.currentThread().getContextClassLoader().getResourceAsStream(log4JFile.getName());
			log4JProps.load(isLog4jProps);
			isLog4jProps.close();

			/*
			 * Try to override log4j.properties
			 */
			if (log4JFile.exists()) {
				isLog4jProps = new FileInputStream(log4JFile);
				log4JProps.load(isLog4jProps);
				logger.info("Using custom log4j.properties");
			} else {
				logger.info("Using default log4j.properties");
			}

			/*
			 * Load the configuration into the system
			 */
			PropertyConfigurator.configure(log4JProps);

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		} finally {
			if (isLog4jProps != null) {
				try {
					isLog4jProps.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return logger;
	}

	/**
	 * It load the default application.properties and then it looks for an external
	 * file in the same folder of the Jar
	 * 
	 * @param <T>
	 * @param mainClazz
	 * @return
	 */
	public static <T> Properties retrieveAppProperties(Class<T> mainClazz) {
		InputStream isAppProps = null;
		Properties appProps = new Properties();

		Logger logger = Logger.getLogger(mainClazz);

		try {
			/*
			 * Get the folder where this Jar is saved
			 */
			String jarFolder = new File(mainClazz.getProtectionDomain().getCodeSource().getLocation().toURI())
					.getParent();

			File propertiesFile = new File(jarFolder + "/application.properties");

			/*
			 * Loading default application.properties
			 */
			isAppProps = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFile.getName());
			appProps.load(isAppProps);
			isAppProps.close();

			/*
			 * Try to override application.properties
			 */
			if (propertiesFile.exists()) {
				isAppProps = new FileInputStream(propertiesFile);
				appProps.load(isAppProps);
				logger.info("Using custom application.properties");
			} else {
				logger.info("Using default application.properties");
			}

		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		} finally {
			if (isAppProps != null) {
				try {
					isAppProps.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return appProps;
	}
}
