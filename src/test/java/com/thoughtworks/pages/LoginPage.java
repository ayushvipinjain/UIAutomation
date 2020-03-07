package com.thoughtworks.pages;

import com.thoughtworks.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "spree_user_email")
    private WebElement userName;

    @FindBy(id = "spree_user_password")
    private WebElement password;

    @FindBy(xpath = "//input[@type='submit'][@value='Login']")
    private WebElement btnlogin;

    public HomePage login(String user, String pwd) {
        userName.sendKeys(user);
        password.sendKeys(pwd);
        btnlogin.click();
        return new HomePage(driver);
    }
}
