package com.aleks.utils;

import com.aleks.server.ServerRunner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Oleksii_Shylo on 11/21/2016.
 */
public class PropertyUtils {

    private static final Logger LOG = LogManager.getLogger(ServerRunner.class);
    private static final String ERROR_LOAD_PROPERTIES_MESSAGE = "Can't load app properties file from resources";
    private static final String ERROR_CLOSE_CONNECTION_MESSAGE = "Can't close connection";

    public static String getUrl(String fileName, String propertyName) {
        Properties properties = new Properties();
        InputStream inputStream = null;
        String url = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            inputStream = loader.getResourceAsStream(fileName);
            properties.load(inputStream);
            url = properties.getProperty(propertyName);
        } catch (IOException e) {
            LOG.error(ERROR_LOAD_PROPERTIES_MESSAGE);
            throw new RuntimeException(ERROR_LOAD_PROPERTIES_MESSAGE, e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOG.error(ERROR_CLOSE_CONNECTION_MESSAGE);
                    throw new RuntimeException(ERROR_CLOSE_CONNECTION_MESSAGE, e);
                }
            }
        }
        return url;
    }
}
