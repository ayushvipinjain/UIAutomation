package com.thoughtworks.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private Properties properties = new Properties();

    public ConfigReader() {

        try {
            String propertiesFilePath = "config.properties";
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
            properties.load(stream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getBaseUrl() {
        return properties.getProperty("baseURl");
    }

    public String getUserName() {
        return properties.getProperty("userName");
    }
    public String getPassword() {
        return properties.getProperty("password");
    }
}
