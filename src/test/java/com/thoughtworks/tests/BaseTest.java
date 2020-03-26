package com.thoughtworks.tests;

import com.thoughtworks.utils.Properties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver = null;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser ) throws InterruptedException, MalformedURLException {

        driver = DriverFactory.getDriver(browser);
        driver.navigate().to(Properties.baseUrl);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanSetup(){
        try {
            driver.close();
            driver.quit();
        }
        catch (Exception ex){
        }
    }
}
