package com.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage  {

    protected WebDriver driver =null;
    protected WebDriverWait wait = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean IsDisplayed(WebElement webElement){
       return webElement.isDisplayed();
    }

    public void waitForPage(String pageTitle, long timeOutInSeconds) {
        wait = new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.titleContains(pageTitle));
    }

}
