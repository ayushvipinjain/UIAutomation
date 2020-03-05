package com.thoughtworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.thoughtworks.utils.Properties;
import java.util.concurrent.TimeUnit;

public class SpreeTests {

    WebDriver driver = null;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser ) throws InterruptedException {

        if(browser.equals("chrome")){
              WebDriverManager.chromedriver().setup();
              driver = new ChromeDriver();
        }
        else{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.navigate().to(Properties.baseUrl);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validateLoginIsSuccessful() {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(Properties.userName);
        driver.findElement( By.id("spree_user_password")).sendKeys(Properties.password);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("My Account")).isDisplayed(),true,"Verify Login is Successful");
    }

    @Test void validateLoginFailed() {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("testuser@gmail.com");
        driver.findElement( By.id("spree_user_password")).sendKeys("user");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        boolean isLoginFailed = driver.findElement(By.xpath("//div[@class='alert alert-error'][text()='Invalid email or password.']")).isDisplayed();
       Assert.assertEquals(isLoginFailed,true);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanSetup(){
        driver.quit();
    }
}
