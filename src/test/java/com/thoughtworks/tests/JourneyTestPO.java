package com.thoughtworks.tests;

import com.thoughtworks.pages.HomePage;
import com.thoughtworks.pages.ProductListingPage;
import com.thoughtworks.pages.ShoppingPage;
import com.thoughtworks.tests.BaseTest;
import com.thoughtworks.utils.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JourneyTestPO extends BaseTest {


    @Test
    public void end2endUserJourney() {

        String searchKeyword = "Spree";
        String firstProductName = "Spree Bag";
        String secondProductName = "Spree Mug";

        HomePage homePage = new HomePage(driver);
        homePage.goToLogin()
                .login(Properties.userName, Properties.password)
                .validateLogin()
                .searchProduct("Brands", searchKeyword)
                .validateSearch(searchKeyword)
                .selectProduct(firstProductName)
                .addToCart(2)
                .waitForPage("Shopping Cart", 5);

        ProductListingPage productListingPage = new ProductListingPage(driver);
        productListingPage.searchProduct("Brands", searchKeyword)
                .validateSearch(searchKeyword)
                .selectProduct(secondProductName)
                .addToCart(1)
                .waitForPage("Shopping Cart", 5);

        ShoppingPage shoppingPage = new ShoppingPage(driver);
        List<String> addedProducts = shoppingPage.getProductsAddedInCart();

        Assert.assertEquals(addedProducts.contains(firstProductName), true, "Verify first Product is Added in Cart");
        Assert.assertEquals(addedProducts.contains(secondProductName), true, "Verify second product is added in cart");

    }
}
