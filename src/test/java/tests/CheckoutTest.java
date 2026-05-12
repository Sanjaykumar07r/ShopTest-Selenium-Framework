package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ProductPage;

import java.time.Duration;

public class CheckoutTest extends BaseTest {
    public void login(){

        driver.get(config.getBaseUrl());

        driver.findElement(By.id("user-name"))
                .sendKeys(config.getUsername());

        driver.findElement(By.id("password"))
                .sendKeys(config.getPassword());

        driver.findElement(By.id("login-button"))
                .click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("inventory"));

        driver.findElement(
                        By.id("react-burger-menu-btn"))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("reset_sidebar_link")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("react-burger-cross-btn")))
                .click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("bm-menu-wrap")));
    }

    @Test
    public void verifyCheckoutSummaryPage(){
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.openCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");
        checkoutPage.clickContinue();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void verifyOrderSummary(){
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.openCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getSummaryProductName(), "Sauce Labs Backpack");
        Assert.assertTrue(checkoutPage.getTotalPrice().contains("Total"));
    }

    @Test
    public void verifyOrderCompletion(){
        login();
        ProductPage productPage = new ProductPage(driver, wait);
        productPage.addBackpackToCart();
        productPage.openCart();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickCheckout();
        checkoutPage.enterFirstName("Sanjay");
        checkoutPage.enterLastName("Kumar");
        checkoutPage.enterPostalCode("620102");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!");
    }
}