package com.thoughtworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "link-to-login")
    private WebElement login;

    @FindBy(linkText = "My Account")
    private WebElement myAccount;

    public LoginPage goToLogin() {
        login.click();
        return new LoginPage(driver);
    }

    public ProductListingPage validateLogin() {
        Assert.assertEquals(IsDisplayed(myAccount),true,"Validate login is successful");
        return new ProductListingPage(driver);
    }
}
