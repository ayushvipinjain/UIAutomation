package com.thoughtworks.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.thoughtworks.dto.Login;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataDrivenTest extends BaseTest{

    @DataProvider(name = "getLoginInfo")
    public Object[] getLoginInfo() throws FileNotFoundException {

        String filepath = this.getClass().getClassLoader().getSystemResource("login.json").getFile();
        JsonParser jsonParser = new JsonParser();
        JsonElement loginElement = jsonParser.parse(new FileReader(filepath));
        Login[] loginarray = new Gson().fromJson(loginElement,  Login[].class);
        return loginarray;
    }

    @Test(dataProvider = "getLoginInfo")
    public void ValidateLoginWithDifferentUsers(Login loginInfo){

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(loginInfo.getUsername());
        driver.findElement( By.id("spree_user_password")).sendKeys(loginInfo.getPassword());
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("My Account")).isDisplayed(),true,"Verify Login is Successful");
    }

}
