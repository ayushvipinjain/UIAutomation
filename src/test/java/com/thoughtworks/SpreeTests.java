package com.thoughtworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SpreeTests {



    @Parameters("browser")
    @Test(groups = "testGroup")
    public void logintest(@Optional String browser){

    }

    @Parameters("browser")
    @Test
    public void valoidateProductSearch(@Optional String browser){

    }
}
