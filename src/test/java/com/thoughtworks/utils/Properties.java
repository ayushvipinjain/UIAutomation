package com.thoughtworks.utils;

public class Properties {

    private static final ConfigReader propertiesReader = new ConfigReader();

    public static final String baseUrl = propertiesReader.getBaseUrl();
    public static final String userName = propertiesReader.getUserName();
    public static final String password = propertiesReader.getPassword();
}
