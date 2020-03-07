package com.thoughtworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class ProductListingPage extends BasePage {

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "taxon")
    private WebElement categories;

    @FindBy(id = "keywords")
    private WebElement keywords;

    @FindBy(xpath = "//*[@id='search-bar']//input[@type='submit'][@value='Search']")
    private WebElement search;

    @FindBy(className = "search-results-title")
    private WebElement searchTitle;

    @FindBy(className = "product-title")
    private WebElement productTitle;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    public ProductListingPage searchProduct(String category, String searchText) {

        if(!(category.isEmpty() || category==null)) {
            categories.click();
            driver.findElement(By.xpath("//option[. = '" + category + "']")).click();
        }
        keywords.sendKeys(searchText);
        search.click();
        return new ProductListingPage(driver);
    }

    public ProductListingPage validateSearch(String searchText) {
        Assert.assertEquals(this.IsDisplayed(searchTitle), true, "Verify Search Title is Displayed");
        Assert.assertEquals(searchTitle.getText(), "Search results for '" + searchText + "'", "Verify Search Text on Search page");
        return new ProductListingPage(driver);
    }

    public ProductListingPage selectProduct(String productName) {
        driver.findElement(By.xpath("//span[text()=" + "'" + productName + "'" + "]/parent::a")).click();
        Assert.assertEquals(IsDisplayed(productTitle),true,"Verify Product Is Opened");
        Assert.assertEquals(productTitle.getText(),productName,"Verify Correct Product is Opened");
        return new ProductListingPage(driver);
    }

    public ShoppingPage addToCart(int totalItems){
        quantity.clear();
        quantity.sendKeys(Integer.toString(totalItems));
        driver.findElement(By.id("add-to-cart-button")).click();
        return new ShoppingPage(driver);
    }
}
