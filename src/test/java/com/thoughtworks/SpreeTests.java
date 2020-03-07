package com.thoughtworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.thoughtworks.utils.Properties;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpreeTests extends BaseTest {


    @Test
    public void validateLoginIsSuccessful() {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(Properties.userName);
        driver.findElement( By.id("spree_user_password")).sendKeys(Properties.password);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("My Account")).isDisplayed(),true,"Verify Login is Successful");


    }

    @Test
    public void validateLoginFailed() {
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("testuser@gmail.com");
        driver.findElement( By.id("spree_user_password")).sendKeys("user");
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        boolean isLoginFailed = driver.findElement(By.xpath("//div[@class='alert alert-error'][text()='Invalid email or password.']")).isDisplayed();
       Assert.assertEquals(isLoginFailed,true);
    }





}
