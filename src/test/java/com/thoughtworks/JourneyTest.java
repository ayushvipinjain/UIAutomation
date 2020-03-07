package com.thoughtworks;

import com.thoughtworks.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JourneyTest extends BaseTest {

    @Test
    public void  validateProductSearch() throws InterruptedException {

        String searchText ="Spree";
        String firstProductName = "Spree Bag";
        String secondProductName = "Spree Mug";

        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(Properties.userName);
        driver.findElement( By.id("spree_user_password")).sendKeys(Properties.password);
        driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();
        Assert.assertEquals(driver.findElement(By.linkText("My Account")).isDisplayed(),true,"Verify Login is Successful");

        driver.findElement(By.id("taxon")).click();
        driver.findElement(By.xpath("//option[. = 'Brands']")).click();
        driver.findElement(By.id("keywords")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id='search-bar']//input[@type='submit'][@value='Search']")).click();


        WebElement searchTitle = driver.findElement(By.xpath("//*[@class='search-results-title']"));
        Assert.assertEquals(searchTitle.isDisplayed(),true,"Verify Search Title is Displayed");
        Assert.assertEquals(searchTitle.getText(),"Search results for '" + searchText + "'","Verify Search Text on Search page");
        driver.findElement(By.xpath("//span[text()=" + "'" +firstProductName+ "'" + "]/parent::a")).click();

        WebElement productTitle = driver.findElement(By.cssSelector("*[class='product-title']"));
        Assert.assertEquals(productTitle.isDisplayed(),true,"Verify Profuct Title id displayed on opening the product");
        Assert.assertEquals(productTitle.getText(),firstProductName,"Verify that the selected product is opened");

        WebElement quantity = driver.findElement(By.id("quantity"));
        quantity.clear();
        quantity.sendKeys("2");
        driver.findElement(By.id("add-to-cart-button")).click();

        System.out.println("START ---"+ LocalDateTime.now());
        WebDriverWait wait = new WebDriverWait(driver,5000);
        wait.until(ExpectedConditions.titleContains("Shopping Cart"));
        System.out.println("END ---"+LocalDateTime.now());

        driver.findElement(By.id("taxon")).click();
        driver.findElement(By.xpath("//option[. = 'Brands']")).click();
        driver.findElement(By.id("keywords")).sendKeys(searchText);
        driver.findElement(By.xpath("//*[@id='search-bar']//input[@type='submit'][@value='Search']")).click();

        searchTitle = driver.findElement(By.xpath("//*[@class='search-results-title']"));
        Assert.assertEquals(searchTitle.isDisplayed(),true,"Verify Search Title is Displayed");
        Assert.assertEquals(searchTitle.getText(),"Search results for '" + searchText + "'","Verify Search Text on Search page");
        driver.findElement(By.xpath("//span[text()=" + "'" +secondProductName+ "'" + "]/parent::a")).click();

        productTitle = driver.findElement(By.cssSelector("*[class='product-title']"));
        Assert.assertEquals(productTitle.isDisplayed(),true,"Verify Profuct Title id displayed on opening the product");
        Assert.assertEquals(productTitle.getText(),secondProductName,"Verify that the selected product is opened");

        quantity = driver.findElement(By.id("quantity"));
        quantity.clear();
        quantity.sendKeys("1");
        driver.findElement(By.id("add-to-cart-button")).click();
        wait.until(ExpectedConditions.titleContains("Shopping Cart"));

        List<String> addedProducts = new ArrayList<>();
        driver.findElements(By.xpath("//table[@id='cart-detail']//td[@class='cart-item-description']//a")).forEach(webElement -> {
            addedProducts.add(webElement.getText());
        });

        Assert.assertEquals(addedProducts.contains(firstProductName),true,"Verify First Product is Added in Cart");
        Assert.assertEquals(addedProducts.contains(secondProductName),true,"Verify Second Product is Added in Cart");

    }
}
