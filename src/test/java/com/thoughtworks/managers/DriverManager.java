package com.thoughtworks.managers;

import org.openqa.selenium.WebDriver;

public interface DriverManager {
    //public String GRID_URL ="http://192.168.43.16:4444/wd/hub";
    public String GRID_URL ="http://127.0.0.1:4446/wd/hub";

    public WebDriver getDriver();
}
