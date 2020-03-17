package com.thoughtworks.tests;

import com.thoughtworks.managers.ChromeDriverManager;
import com.thoughtworks.managers.DriverManager;
import com.thoughtworks.managers.FirefoxDriverManager;
import com.thoughtworks.utils.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    public static WebDriver getDriver(String browser) throws MalformedURLException {

        DriverManager driverManager = null;
        WebDriver webDriver = null;
        String execType = IsNullOrEmpty(Properties.execType) != true ? Properties.execType : "local";
        switch (browser) {
            case "chrome":
                driverManager = new ChromeDriverManager(execType);
                webDriver = driverManager.getDriver();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager(execType);
                webDriver = driverManager.getDriver();
                break;
            default:
                driverManager = new ChromeDriverManager(execType);
                webDriver = driverManager.getDriver();
                break;
        }
        return webDriver;
    }

    public static boolean IsNullOrEmpty(String input) {
        if (input.isEmpty() || input == null)
            return true;
        else
            return false;
    }

}
