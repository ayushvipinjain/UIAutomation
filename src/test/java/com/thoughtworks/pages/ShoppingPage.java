package com.thoughtworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPage extends BasePage {

    public ShoppingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@id='cart-detail']//td[@class='cart-item-description']//a")
    private List<WebElement> productsInCart;

    public List<String> getProductsAddedInCart()
    {
        List<String> addedProducts = new ArrayList<>();
        driver.findElements(By.xpath("//table[@id='cart-detail']//td[@class='cart-item-description']//a")).forEach(webElement -> {
            addedProducts.add(webElement.getText());
        });
        return addedProducts;
    }

}
