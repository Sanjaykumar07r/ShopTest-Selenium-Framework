package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    public void login() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(org.openqa.selenium.By.id("user-name")).sendKeys("standard_user");
        driver.findElement(org.openqa.selenium.By.id("password")).sendKeys("secret_sauce");
        driver.findElement(org.openqa.selenium.By.id("login-button")).click();
    }

    @Test
    public void verifySingleProductCartCount() {
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        Assert.assertEquals(productPage.getCartBadgeCount(), "1");
    }

    @Test
    public void verifyTwoProductCartCount() {
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.addBikeLightToCart();
        Assert.assertEquals(productPage.getCartBadgeCount(), "2");
    }

    @Test
    public void verifyRemoveProductFromCart() {
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.openCart();
        cartPage.removeBackpack();
        Assert.assertFalse(cartPage.isBackpackDisplayed());
    }
    @Test
    public void verifyCartRetainsProduct() {
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.openCart();
        cartPage.continueShopping();
        productPage.openCart();
        Assert.assertTrue(cartPage.isBackpackDisplayed());
    }

}