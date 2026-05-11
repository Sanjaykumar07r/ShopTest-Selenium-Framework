package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class ProductTest extends BaseTest {

    public void login(){
        CartPage loginPage = new CartPage(driver ,wait );
        loginPage.login("standard_user", "secret_sauce");
    }
    @Test // 1. Verify product displayed
    public void verifyProductDisplayed(){
        login();
        ProductPage productPage = new ProductPage(driver,wait);
        Assert.assertTrue(productPage.isProductDisplayed());
    }
    @Test
    public void verifySortName(){
        login();
        ProductPage productPage = new ProductPage(driver,wait);
        productPage.sortNameAToZ();
        Assert.assertEquals(productPage.getFirstProductName(), "Sauce Labs Backpack");
    }

    @Test
    public void verifyPriceSort(){
        login();
        ProductPage productPage = new ProductPage(driver,wait);
        productPage.sortPriceLowToHigh();
        Assert.assertEquals(productPage.getFirstProductPrice(), "$7.99");
    }
    @Test
    public void verifyOpenProduct() {
        login();
        ProductPage productPage = new ProductPage(driver,wait);
        Assert.assertEquals(productPage.getFirstProductName(), "Sauce Labs Backpack");
        Assert.assertEquals(
                productPage.getFirstProductPrice(), "$29.99");
                productPage.openFirstProduct();
    }



}