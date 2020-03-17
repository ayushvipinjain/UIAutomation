package com.thoughtworks.tests;

import com.thoughtworks.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RemoteExecution {

    @Parameters("browser")
    @Test
    public void executeTest(String browser) throws MalformedURLException {

        Capabilities capabilities = getCapabilities(browser);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),capabilities);

        driver.navigate().to(Properties.baseUrl);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(Properties.userName);
        driver.findElement( By.id("spree_user_password")).sendKeys(Properties.password);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("My Account")).isDisplayed(),true,"Verify Login is Successful");

        driver.quit();
    }

    private Capabilities getCapabilities(String browser) {
        DesiredCapabilities desiredCapabilities = null;
        Capabilities capabilities;
        switch (browser){
            case "chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
                desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,browser);
                capabilities = new ChromeOptions();
                capabilities.merge(desiredCapabilities);

                break;
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
                desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME,browser);
                capabilities = new FirefoxOptions();
                capabilities.merge(desiredCapabilities);

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
        return capabilities;
    }
}
